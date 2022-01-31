package com.tencent.mobileqq.armap;

import abbu;
import abbv;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ARMapActivity$LocationMonitor
{
  int a;
  public ARMapActivity a;
  int b;
  
  ARMapActivity$LocationMonitor(ARMapActivity paramARMapActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity = paramARMapActivity;
  }
  
  public void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int j = 30;
    int i = 15;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.d > 0) {
      j = 30 / this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.d;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.d > 0) {
      i = 15 / this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.d;
    }
    if (j < 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "monitorLocation ,manual set cellLocationCountLimit = " + 5);
      }
      j = 5;
    }
    for (;;)
    {
      if (i < 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "monitorLocation ,manual set overSpeedCountLimit = " + 5);
        }
        i = 5;
      }
      for (;;)
      {
        if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.m != null))
        {
          if (paramSosoLbsInfo.a.m.equals("cell"))
          {
            this.jdField_a_of_type_Int += 1;
            if (this.jdField_a_of_type_Int > j)
            {
              this.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.runOnUiThread(new abbu(this));
            }
            this.b = 0;
            return;
          }
          if (paramSosoLbsInfo.a.m.equals("gps"))
          {
            if (paramSosoLbsInfo.a.b > 4.17D)
            {
              this.b += 1;
              if (this.b > i) {
                this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.runOnUiThread(new abbv(this));
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Int = 0;
              return;
              this.b = 0;
            }
          }
          this.jdField_a_of_type_Int = 0;
          this.b = 0;
          return;
        }
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapActivity.LocationMonitor
 * JD-Core Version:    0.7.0.1
 */