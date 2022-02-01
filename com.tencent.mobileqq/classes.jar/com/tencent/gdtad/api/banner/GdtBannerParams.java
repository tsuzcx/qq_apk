package com.tencent.gdtad.api.banner;

import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAdParams;

public final class GdtBannerParams
  extends GdtAdParams
{
  public int a;
  public long a;
  public int b = -2147483648;
  public int c = -2147483648;
  
  public GdtBannerParams()
  {
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  public boolean a()
  {
    return (super.a()) && (this.jdField_a_of_type_Int != -2147483648) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.b()) && (this.b > 0) && (this.c > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerParams
 * JD-Core Version:    0.7.0.1
 */