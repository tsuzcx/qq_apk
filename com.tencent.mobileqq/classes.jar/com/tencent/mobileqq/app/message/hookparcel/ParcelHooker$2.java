package com.tencent.mobileqq.app.message.hookparcel;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.permissionmonitorcore.PermissionMonitor.Listener;
import com.tencent.robolectric.ShadowParcel;
import java.util.Arrays;

class ParcelHooker$2
  implements PermissionMonitor.Listener
{
  static
  {
    if (!ParcelHooker.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  ParcelHooker$2(ParcelHooker paramParcelHooker) {}
  
  public void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    if (ParcelHooker.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHookparcelParcelHooker) != Thread.currentThread()) {}
    while ((!ParcelHooker.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHookparcelParcelHooker)) || (paramArrayOfObject.length != 2)) {
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[0] != ParcelHooker.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHookparcelParcelHooker))) {
      throw new AssertionError();
    }
    if ((!jdField_a_of_type_Boolean) && (paramArrayOfObject[1].getClass() != Float.class)) {
      throw new AssertionError();
    }
    ShadowParcel.a((int)ParcelHooker.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHookparcelParcelHooker), ((Float)paramArrayOfObject[1]).floatValue());
    QLog.i("ParcelHooker", 2, "onMethodEntry() called with: className = [" + paramString1 + "], methodName = [" + paramString2 + "], sig = [" + paramString3 + "], arguments = [" + Arrays.toString(paramArrayOfObject) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.ParcelHooker.2
 * JD-Core Version:    0.7.0.1
 */