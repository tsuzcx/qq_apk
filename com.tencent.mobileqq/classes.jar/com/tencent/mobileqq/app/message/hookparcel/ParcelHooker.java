package com.tencent.mobileqq.app.message.hookparcel;

import android.os.Environment;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.util.Base64;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.app.message.OnReceiveVerify;
import com.tencent.mobileqq.app.message.SendMsgVerify;
import com.tencent.mobileqq.cuckoo.Cuckoo;
import com.tencent.mobileqq.cuckoo.MethodCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robolectric.ShadowParcel;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ParcelHooker
{
  private static volatile boolean b;
  private static Set<Class> g;
  private static ParcelHooker.Callback h;
  volatile boolean a;
  private volatile Thread c;
  private volatile Parcel d;
  private volatile long e;
  private ThreadLocal<SendMsgVerify> f = new ThreadLocal();
  
  static {}
  
  public static Gson a(Class<? extends MessageRecord> paramClass)
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    paramClass = paramClass.getFields();
    h.a(localGsonBuilder, paramClass);
    return localGsonBuilder.excludeFieldsWithModifiers(new int[] { 8, 128, 64 }).setExclusionStrategies(new ExclusionStrategy[] { new ParcelHooker.10() }).create();
  }
  
  private void a(OnReceiveVerify paramOnReceiveVerify, String paramString)
  {
    paramOnReceiveVerify = new Gson().toJson(paramOnReceiveVerify);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject1).append("/Tencent/MobileQQ/MessageHandlerOnReceive/");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".json");
    FileUtils.writeFile((String)localObject1, ((StringBuilder)localObject2).toString(), paramOnReceiveVerify);
  }
  
  public static void a(ParcelHooker.Callback paramCallback)
  {
    h = paramCallback;
  }
  
  private static void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append("/Tencent/MobileQQ/QQMessageFacade/");
    String str = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".txt");
    FileUtils.writeFile(str, localStringBuilder.toString(), paramString1);
  }
  
  private byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    Number localNumber = ShadowParcel.a();
    a(Thread.currentThread(), localParcel, localNumber.longValue());
    paramFromServiceMsg.writeToParcel(localParcel, 0);
    b(Thread.currentThread(), localParcel, localNumber.longValue());
    paramFromServiceMsg = ShadowParcel.a(localNumber.intValue());
    localParcel.recycle();
    return paramFromServiceMsg;
  }
  
  @NonNull
  private MethodCallback b()
  {
    return new ParcelHooker.1(this);
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
    catch (InvocationTargetException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private void b(Thread paramThread, Parcel paramParcel, long paramLong)
  {
    this.a = false;
  }
  
  private static boolean b(Type paramType)
  {
    if (paramType == null) {
      return false;
    }
    if (g == null)
    {
      g = new HashSet();
      g.addAll(Arrays.asList(new Class[] { Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, Byte.TYPE, Byte.class, Boolean.TYPE, Boolean.class, Short.TYPE, Short.class, String.class }));
    }
    return g.contains(paramType);
  }
  
  private byte[] b(ToServiceMsg paramToServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    Number localNumber = ShadowParcel.a();
    a(Thread.currentThread(), localParcel, localNumber.longValue());
    paramToServiceMsg.mSkipBinderWhenMarshall = true;
    paramToServiceMsg.writeToParcel(localParcel, 0);
    paramToServiceMsg.mSkipBinderWhenMarshall = false;
    b(Thread.currentThread(), localParcel, localNumber.longValue());
    paramToServiceMsg = ShadowParcel.a(localNumber.intValue());
    localParcel.recycle();
    return paramToServiceMsg;
  }
  
  @NonNull
  private MethodCallback c()
  {
    return new ParcelHooker.2(this);
  }
  
  @NonNull
  private MethodCallback d()
  {
    return new ParcelHooker.3(this);
  }
  
  @NonNull
  private MethodCallback e()
  {
    return new ParcelHooker.4(this);
  }
  
  @NonNull
  private MethodCallback f()
  {
    return new ParcelHooker.5(this);
  }
  
  @NonNull
  private MethodCallback g()
  {
    return new ParcelHooker.6(this);
  }
  
  @NonNull
  private MethodCallback h()
  {
    return new ParcelHooker.7(this);
  }
  
  @NonNull
  private MethodCallback i()
  {
    return new ParcelHooker.8(this);
  }
  
  @NonNull
  private MethodCallback j()
  {
    return new ParcelHooker.9(this);
  }
  
  public SendMsgVerify a()
  {
    if (this.f.get() == null) {
      this.f.set(new SendMsgVerify());
    }
    return (SendMsgVerify)this.f.get();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    b(paramMessageRecord);
    SendMsgVerify localSendMsgVerify = a();
    localSendMsgVerify.e = paramMessageRecord;
    localSendMsgVerify.b = a(paramMessageRecord.getClass()).toJson(paramMessageRecord);
    localSendMsgVerify.a = paramMessageRecord.getClass().getName();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    String str = Utils.b(b(paramToServiceMsg));
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("printSendParams reqData=[");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append("]");
      QLog.d("ParcelHooker", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = a();
    paramToServiceMsg.c = str;
    paramToServiceMsg.e = ((MessageRecord)a(paramToServiceMsg.e.getClass()).fromJson(paramToServiceMsg.b, paramToServiceMsg.e.getClass()));
    paramToServiceMsg.b = null;
    str = a(paramToServiceMsg.e.getClass()).toJson(paramToServiceMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(paramToServiceMsg.a);
    a(str, localStringBuilder.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = Utils.b(b(paramToServiceMsg));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("printParams reqData=[");
      ((StringBuilder)localObject1).append(paramToServiceMsg);
      ((StringBuilder)localObject1).append("]");
      QLog.d("ParcelHooker", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramFromServiceMsg.attributes.remove("FromServiceMsg");
    Object localObject1 = Utils.b(a(paramFromServiceMsg));
    paramFromServiceMsg.attributes.put("FromServiceMsg", localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("printParams respData=[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.d("ParcelHooker", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new OnReceiveVerify();
    ((OnReceiveVerify)localObject2).a = paramToServiceMsg;
    ((OnReceiveVerify)localObject2).b = ((String)localObject1);
    ((OnReceiveVerify)localObject2).c = "placeholder for MessageRecord's metadata";
    ((OnReceiveVerify)localObject2).e = 1;
    ((OnReceiveVerify)localObject2).d = 1;
    a((OnReceiveVerify)localObject2, paramFromServiceMsg.getServiceCmd());
  }
  
  void a(Thread paramThread, Parcel paramParcel, long paramLong)
  {
    if (!b)
    {
      b = true;
      Cuckoo.a(true);
      Cuckoo.a("android/os/Parcel$ReadWriteHelper", "writeString", "(Landroid/os/Parcel;Ljava/lang/String;)V", j());
      Cuckoo.a("android/os/Parcel", "writeStringNoHelper", "(Ljava/lang/String;)V", i());
      Cuckoo.a("android/os/Parcel", "writeInt", "(I)V", f());
      Cuckoo.a("android/os/Parcel", "writeLong", "(J)V", b());
      Cuckoo.a("android/os/Parcel", "writeFloat", "(F)V", c());
      Cuckoo.a("android/os/Parcel", "writeDouble", "(D)V", d());
      Cuckoo.a("android/os/Parcel", "writeByteArray", "([BII)V", e());
      Cuckoo.a("android/os/Parcel", "writeBlob", "([BII)V", g());
      Cuckoo.a("android/os/Parcel", "setDataPosition", "(I)V", h());
    }
    this.c = paramThread;
    this.d = paramParcel;
    this.e = paramLong;
    this.a = true;
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