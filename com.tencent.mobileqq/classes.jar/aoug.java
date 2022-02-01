import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.util.Arrays;

class aoug
  implements PermissionMonitor.Listener
{
  static
  {
    if (!aotx.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  aoug(aotx paramaotx) {}
  
  public void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    if (aotx.a(this.jdField_a_of_type_Aotx) != Thread.currentThread()) {}
    while ((!aotx.a(this.jdField_a_of_type_Aotx)) || (paramArrayOfObject.length != 3)) {
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[1] != aotx.a(this.jdField_a_of_type_Aotx))) {
      throw new AssertionError();
    }
    ShadowParcel.a((int)aotx.a(this.jdField_a_of_type_Aotx), (String)paramArrayOfObject[2]);
    QLog.i("ParcelHooker", 2, "onMethodEntry() called with: className = [" + paramString1 + "], methodName = [" + paramString2 + "], sig = [" + paramString3 + "], arguments = [" + Arrays.toString(paramArrayOfObject) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */