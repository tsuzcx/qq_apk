import android.os.Environment;
import android.os.Parcel;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.io.File;
import java.util.HashMap;

public class aogs
{
  private static volatile boolean b;
  private volatile long jdField_a_of_type_Long;
  private volatile Parcel jdField_a_of_type_AndroidOsParcel;
  private volatile Thread jdField_a_of_type_JavaLangThread;
  private volatile boolean jdField_a_of_type_Boolean;
  
  @NonNull
  private PermissionMonitor.Listener a()
  {
    return new aogt(this);
  }
  
  private void a(aoft paramaoft, String paramString)
  {
    paramaoft = new Gson().toJson(paramaoft);
    String str = bhgg.a(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/MessageHandlerOnReceive/");
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    bgmg.a(str, System.currentTimeMillis() + "-" + paramString + ".json", paramaoft);
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
    return new aogu(this);
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
  
  @NonNull
  private PermissionMonitor.Listener c()
  {
    return new aogv(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener d()
  {
    return new aogw(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener e()
  {
    return new aogx(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener f()
  {
    return new aogy(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener g()
  {
    return new aogz(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener h()
  {
    return new aoha(this);
  }
  
  @NonNull
  private PermissionMonitor.Listener i()
  {
    return new aohb(this);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = bgjw.a(a(paramToServiceMsg));
    if (QLog.isColorLevel()) {
      QLog.d("ParcelHooker", 2, "printParams reqData=[" + paramToServiceMsg + "]");
    }
    Object localObject = paramFromServiceMsg.attributes.remove("FromServiceMsg");
    String str = bgjw.a(a(paramFromServiceMsg));
    paramFromServiceMsg.attributes.put("FromServiceMsg", localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ParcelHooker", 2, "printParams respData=[" + str + "]");
    }
    localObject = new aoft();
    ((aoft)localObject).jdField_a_of_type_JavaLangString = paramToServiceMsg;
    ((aoft)localObject).jdField_b_of_type_JavaLangString = str;
    ((aoft)localObject).c = "placeholder for MessageRecord's metadata";
    ((aoft)localObject).jdField_b_of_type_Int = 1;
    ((aoft)localObject).jdField_a_of_type_Int = 1;
    a((aoft)localObject, paramFromServiceMsg.getServiceCmd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogs
 * JD-Core Version:    0.7.0.1
 */