package com.tencent.mobileqq.ar;

import amsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azri;
import bdne;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class ARDeviceController$1
  implements Runnable
{
  public ARDeviceController$1(amsg paramamsg, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    azri.a(BaseApplication.getContext()).a(null, "AREnable", this.jdField_a_of_type_Boolean, 0L, 0L, (HashMap)localObject, null);
    localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("ar_incompatible_reason", this.jdField_a_of_type_Int);
    bdne.a((SharedPreferences.Editor)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARDeviceController.1
 * JD-Core Version:    0.7.0.1
 */