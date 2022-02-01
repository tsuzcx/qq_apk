import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.util.Arrays;

class aoha
  implements PermissionMonitor.Listener
{
  static
  {
    if (!aogs.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  aoha(aogs paramaogs) {}
  
  public void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    if (aogs.a(this.jdField_a_of_type_Aogs) != Thread.currentThread()) {}
    while ((!aogs.a(this.jdField_a_of_type_Aogs)) || (paramArrayOfObject.length != 2)) {
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[0] != aogs.a(this.jdField_a_of_type_Aogs))) {
      throw new AssertionError();
    }
    ShadowParcel.a((int)aogs.a(this.jdField_a_of_type_Aogs), (String)paramArrayOfObject[1]);
    QLog.i("ParcelHooker", 2, "onMethodEntry() called with: className = [" + paramString1 + "], methodName = [" + paramString2 + "], sig = [" + paramString3 + "], arguments = [" + Arrays.toString(paramArrayOfObject) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */