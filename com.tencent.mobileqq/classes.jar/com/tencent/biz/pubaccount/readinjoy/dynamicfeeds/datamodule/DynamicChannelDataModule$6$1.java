package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import ovz;
import owb;

public class DynamicChannelDataModule$6$1
  implements Runnable
{
  public DynamicChannelDataModule$6$1(owb paramowb, Bundle paramBundle, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("isPullDownRefresh", 0) == 1)
    {
      localObject = new ArrayList();
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label97;
      }
      localObject = ovz.a(this.jdField_a_of_type_Owb.jdField_a_of_type_Ovz, this.jdField_a_of_type_Owb.jdField_a_of_type_Int, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_AndroidOsBundle);
    }
    for (;;)
    {
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        ovz.a(this.jdField_a_of_type_Owb.jdField_a_of_type_Ovz, bool, this.jdField_a_of_type_Owb.jdField_a_of_type_Int, false, false, null);
      }
      return;
      bool = false;
      break;
      label97:
      QLog.d("DynamicChannelDataModule", 2, "onResult, result is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.6.1
 * JD-Core Version:    0.7.0.1
 */