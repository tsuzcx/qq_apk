package com.tencent.mobileqq.app.message.hookparcel;

import android.os.Environment;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.util.Base64;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.app.message.OnReceiveVerify;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.app.message.SendMsgVerify;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ParcelHooker
{
  private static Set<Class> jdField_a_of_type_JavaUtilSet;
  private static volatile boolean b;
  private volatile long jdField_a_of_type_Long;
  private volatile Parcel jdField_a_of_type_AndroidOsParcel;
  private volatile Thread jdField_a_of_type_JavaLangThread;
  private ThreadLocal<SendMsgVerify> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static Gson a(Class<? extends MessageRecord> paramClass)
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    paramClass = paramClass.getFields();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramClass[i];
      if (((localObject.getModifiers() & 0xC8) == 0) && (localObject.getAnnotation(RecordForTest.class) != null))
      {
        if (!MessageMicro.class.isAssignableFrom(localObject.getType())) {
          break label92;
        }
        localGsonBuilder.registerTypeAdapter(localObject.getType(), new PBJsonAdapter(localObject.getType()));
      }
      for (;;)
      {
        i += 1;
        break;
        label92:
        if (StructMsgForGeneralShare.class == localObject.getType()) {
          localGsonBuilder.registerTypeAdapter(localObject.getType(), new GeneralStructMsgJsonAdapter());
        }
      }
    }
    return localGsonBuilder.excludeFieldsWithModifiers(new int[] { 8, 128, 64 }).setExclusionStrategies(new ExclusionStrategy[] { new ParcelHooker.10() }).create();
  }
  
  @NonNull
  private PermissionMonitor.Listener a()
  {
    return new ParcelHooker.1(this);
  }
  
  private void a(OnReceiveVerify paramOnReceiveVerify, String paramString)
  {
    paramOnReceiveVerify = new Gson().toJson(paramOnReceiveVerify);
    String str = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/MessageHandlerOnReceive/");
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    FileUtils.a(str, System.currentTimeMillis() + "-" + paramString + ".json", paramOnReceiveVerify);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/QQMessageFacade/");
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis());
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    FileUtils.a(str, (String)localObject + ".txt", paramString1);
  }
  
  private void a(Thread paramThread, Parcel paramParcel, long paramLong)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    Number localNumber = ShadowParcel.a();
    b(Thread.currentThread(), localParcel, localNumber.longValue());
    paramFromServiceMsg.writeToParcel(localParcel, 0);
    a(Thread.currentThread(), localParcel, localNumber.longValue());
    paramFromServiceMsg = ShadowParcel.a(localNumber.intValue());
    localParcel.recycle();
    return paramFromServiceMsg;
  }
  
  private byte[] a(ToServiceMsg paramToServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    Number localNumber = ShadowParcel.a();
    b(Thread.currentThread(), localParcel, localNumber.longValue());
    paramToServiceMsg.mSkipBinderWhenMarshall = true;
    paramToServiceMsg.writeToParcel(localParcel, 0);
    paramToServiceMsg.mSkipBinderWhenMarshall = false;
    a(Thread.currentThread(), localParcel, localNumber.longValue());
    paramToServiceMsg = ShadowParcel.a(localNumber.intValue());
    localParcel.recycle();
    return paramToServiceMsg;
  }
  
  @NonNull
  private PermissionMonitor.Listener b()
  {
    return new ParcelHooker.2(this);
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    try
    {
      Method localMethod = Entity.class.getDeclaredMethod("prewrite", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramMessageRecord, new Object[0]);
      return;
    }
    catch (NoSuchMethodException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private void b(Thread paramThread, Parcel paramParcel, long paramLong)
  {
    if (!b)
    {
      b = true;
      PermissionMonitor.Listener localListener1 = i();
      PermissionMonitor.Listener localListener2 = h();
      PermissionMonitor.Listener localListener3 = e();
      PermissionMonitor.Listener localListener4 = a();
      PermissionMonitor.Listener localListener5 = b();
      PermissionMonitor.Listener localListener6 = c();
      PermissionMonitor.Listener localListener7 = d();
      PermissionMonitor.Listener localListener8 = f();
      PermissionMonitor.Listener localListener9 = g();
      PermissionMonitor.getInstance().config(new PermissionMonitor.Listener[] { localListener1, localListener2, localListener3, localListener4, localListener5, localListener6, localListener7, localListener8, localListener9 }, new String[] { "android/os/Parcel$ReadWriteHelper", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel", "android/os/Parcel" }, new String[] { "writeString", "writeStringNoHelper", "writeInt", "writeLong", "writeFloat", "writeDouble", "writeByteArray", "writeBlob", "setDataPosition" }, new String[] { "(Landroid/os/Parcel;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "(I)V", "(J)V", "(F)V", "(D)V", "([BII)V", "([BII)V", "(I)V" }).start();
    }
    this.jdField_a_of_type_JavaLangThread = paramThread;
    this.jdField_a_of_type_AndroidOsParcel = paramParcel;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static boolean b(Type paramType)
  {
    if (paramType == null) {
      return false;
    }
    if (jdField_a_of_type_JavaUtilSet == null)
    {
      jdField_a_of_type_JavaUtilSet = new HashSet();
      jdField_a_of_type_JavaUtilSet.addAll(Arrays.asList(new Class[] { Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, Byte.TYPE, Byte.class, Boolean.TYPE, Boolean.class, Short.TYPE, Short.class, String.class }));
    }
    return jdField_a_of_type_JavaUtilSet.contains(paramType);
  }
  
  @NonNull
  private PermissionMonitor.Listener c()
  {
    return new ParcelHooker.3(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener d()
  {
    return new ParcelHooker.4(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener e()
  {
    return new ParcelHooker.5(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener f()
  {
    return new ParcelHooker.6(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener g()
  {
    return new ParcelHooker.7(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener h()
  {
    return new ParcelHooker.8(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener i()
  {
    return new ParcelHooker.9(this);
  }
  
  public SendMsgVerify a()
  {
    if (this.jdField_a_of_type_JavaLangThreadLocal.get() == null) {
      this.jdField_a_of_type_JavaLangThreadLocal.set(new SendMsgVerify());
    }
    return (SendMsgVerify)this.jdField_a_of_type_JavaLangThreadLocal.get();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    b(paramMessageRecord);
    SendMsgVerify localSendMsgVerify = a();
    localSendMsgVerify.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    localSendMsgVerify.jdField_b_of_type_JavaLangString = a(paramMessageRecord.getClass()).toJson(paramMessageRecord);
    localSendMsgVerify.jdField_a_of_type_JavaLangString = paramMessageRecord.getClass().getName();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = Utils.a(a(paramToServiceMsg));
    if (QLog.isColorLevel()) {
      QLog.d("ParcelHooker", 2, "printSendParams reqData=[" + paramToServiceMsg + "]");
    }
    SendMsgVerify localSendMsgVerify = a();
    localSendMsgVerify.c = paramToServiceMsg;
    localSendMsgVerify.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)a(localSendMsgVerify.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getClass()).fromJson(localSendMsgVerify.jdField_b_of_type_JavaLangString, localSendMsgVerify.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getClass()));
    localSendMsgVerify.jdField_b_of_type_JavaLangString = null;
    a(a(localSendMsgVerify.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getClass()).toJson(localSendMsgVerify), "_" + localSendMsgVerify.jdField_a_of_type_JavaLangString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = Utils.a(a(paramToServiceMsg));
    if (QLog.isColorLevel()) {
      QLog.d("ParcelHooker", 2, "printParams reqData=[" + paramToServiceMsg + "]");
    }
    Object localObject = paramFromServiceMsg.attributes.remove("FromServiceMsg");
    String str = Utils.a(a(paramFromServiceMsg));
    paramFromServiceMsg.attributes.put("FromServiceMsg", localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ParcelHooker", 2, "printParams respData=[" + str + "]");
    }
    localObject = new OnReceiveVerify();
    ((OnReceiveVerify)localObject).jdField_a_of_type_JavaLangString = paramToServiceMsg;
    ((OnReceiveVerify)localObject).jdField_b_of_type_JavaLangString = str;
    ((OnReceiveVerify)localObject).c = "placeholder for MessageRecord's metadata";
    ((OnReceiveVerify)localObject).jdField_b_of_type_Int = 1;
    ((OnReceiveVerify)localObject).jdField_a_of_type_Int = 1;
    a((OnReceiveVerify)localObject, paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a().d = Base64.encodeToString(paramArrayOfByte, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.ParcelHooker
 * JD-Core Version:    0.7.0.1
 */