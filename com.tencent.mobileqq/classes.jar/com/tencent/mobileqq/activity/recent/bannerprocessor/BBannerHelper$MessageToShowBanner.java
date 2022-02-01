package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.support.annotation.NonNull;

public final class BBannerHelper$MessageToShowBanner
{
  public final int a;
  @NonNull
  public final BBannerHelper.IBannerInteract a;
  @NonNull
  public final String a;
  public final int b;
  @NonNull
  public final String b;
  
  public BBannerHelper$MessageToShowBanner(int paramInt1, @NonNull String paramString1, int paramInt2, @NonNull String paramString2, @NonNull BBannerHelper.IBannerInteract paramIBannerInteract)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$IBannerInteract = paramIBannerInteract;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MessageToShowBanner)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) {
        return false;
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      return this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.jdField_a_of_type_Int * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_b_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageToShowBanner{bannerLev=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", businessCategory='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconIdx=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", callback=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$IBannerInteract);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.MessageToShowBanner
 * JD-Core Version:    0.7.0.1
 */