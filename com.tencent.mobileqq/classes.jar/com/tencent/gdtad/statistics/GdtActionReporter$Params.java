package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;

public class GdtActionReporter$Params
{
  public int a;
  public long a;
  public GdtAd a;
  
  public GdtActionReporter$Params()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) && (this.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtActionReporter.Params
 * JD-Core Version:    0.7.0.1
 */