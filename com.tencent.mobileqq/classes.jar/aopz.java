import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.util.Arrays;

class aopz
  implements PermissionMonitor.Listener
{
  static
  {
    if (!aopp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  aopz(aopp paramaopp) {}
  
  public void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    if (aopp.a(this.jdField_a_of_type_Aopp) != Thread.currentThread()) {}
    while ((!aopp.a(this.jdField_a_of_type_Aopp)) || (paramArrayOfObject.length != 3)) {
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[1] != aopp.a(this.jdField_a_of_type_Aopp))) {
      throw new AssertionError();
    }
    ShadowParcel.a((int)aopp.a(this.jdField_a_of_type_Aopp), (String)paramArrayOfObject[2]);
    QLog.i("ParcelHooker", 2, "onMethodEntry() called with: className = [" + paramString1 + "], methodName = [" + paramString2 + "], sig = [" + paramString3 + "], arguments = [" + Arrays.toString(paramArrayOfObject) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopz
 * JD-Core Version:    0.7.0.1
 */