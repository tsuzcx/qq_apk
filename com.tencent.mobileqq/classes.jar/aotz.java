import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.util.Arrays;

class aotz
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
  
  aotz(aotx paramaotx) {}
  
  public void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    if (aotx.a(this.jdField_a_of_type_Aotx) != Thread.currentThread()) {}
    while ((!aotx.a(this.jdField_a_of_type_Aotx)) || (paramArrayOfObject.length != 2)) {
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[0] != aotx.a(this.jdField_a_of_type_Aotx))) {
      throw new AssertionError();
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[1].getClass() != Float.class)) {
      throw new AssertionError();
    }
    ShadowParcel.a((int)aotx.a(this.jdField_a_of_type_Aotx), ((Float)paramArrayOfObject[1]).floatValue());
    QLog.i("ParcelHooker", 2, "onMethodEntry() called with: className = [" + paramString1 + "], methodName = [" + paramString2 + "], sig = [" + paramString3 + "], arguments = [" + Arrays.toString(paramArrayOfObject) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotz
 * JD-Core Version:    0.7.0.1
 */