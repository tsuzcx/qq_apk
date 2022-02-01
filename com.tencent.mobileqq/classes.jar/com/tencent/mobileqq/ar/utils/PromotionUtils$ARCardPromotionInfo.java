package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.qphone.base.util.QLog;

public class PromotionUtils$ARCardPromotionInfo
  extends PromotionUtils.BasePromotionInfo
{
  private int a;
  public String a;
  public String b = "";
  public String c = "";
  public String d;
  private boolean d;
  public String e;
  private boolean e;
  public String f = "";
  
  public PromotionUtils$ARCardPromotionInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("PromotionID");
    this.b = paramBundle.getString("PromotionWords");
    this.c = paramBundle.getString("PromotionIconUrl");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("PromotionUserFrom");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("PromotionUserTo");
    this.f = paramBundle.getString("PromotionUserShareId");
    if ((!TextUtils.isEmpty(this.g)) && (TextUtils.equals(this.g, "1"))) {
      this.jdField_d_of_type_Boolean = true;
    }
    try
    {
      this.jdField_d_of_type_JavaLangString = NearbyURLSafeUtil.b(this.jdField_d_of_type_JavaLangString);
      this.jdField_e_of_type_JavaLangString = NearbyURLSafeUtil.b(this.jdField_e_of_type_JavaLangString);
      label109:
      if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
      {
        if (this.jdField_e_of_type_JavaLangString.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 1;
        }
        if (this.jdField_d_of_type_JavaLangString.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 2;
        }
      }
      QLog.w("ScanTorchActivity", 1, "ARRelationShipPromotion, mPromotionId[" + this.jdField_a_of_type_JavaLangString + "], mPromotionWords[" + this.b + "], mPromotionIconUrl[" + this.c + "], mRecoglizeMask[" + this.jdField_a_of_type_Long + "], isMasterState[" + this.jdField_e_of_type_Boolean + "]");
      return;
    }
    catch (Exception paramBundle)
    {
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.ARCardPromotionInfo
 * JD-Core Version:    0.7.0.1
 */