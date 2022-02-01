package com.tencent.comic;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

public class VipComicJumpActivity$ComicParam
{
  public int a;
  public long a;
  Intent jdField_a_of_type_AndroidContentIntent = new Intent();
  Bundle jdField_a_of_type_AndroidOsBundle;
  VipComicJumpActivity.ComicInfo jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo = null;
  VipComicJumpActivity.PageOpenTraceInfo jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo;
  String jdField_a_of_type_JavaLangString = "";
  HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  String jdField_e_of_type_JavaLangString = "com.qqcomic.activity.VipComicMainTabActivity";
  boolean jdField_e_of_type_Boolean = true;
  String jdField_f_of_type_JavaLangString = "";
  boolean jdField_f_of_type_Boolean = false;
  String jdField_g_of_type_JavaLangString = null;
  boolean jdField_g_of_type_Boolean = false;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = false;
  String jdField_i_of_type_JavaLangString = null;
  boolean jdField_i_of_type_Boolean = false;
  String j = "";
  String k = "";
  String l = "";
  String m = "";
  String n = "";
  
  public VipComicJumpActivity$ComicParam()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  boolean a(String paramString)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) && (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).booleanValue());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicParam{clickTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", sourceFrom=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", extUrlParam='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpConponentName='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpurl='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comicInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo);
    localStringBuilder.append(", jumpMainTab='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpSubTab='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftViewText='");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", returnDetail=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", returnToHome=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", returnHomeFromDetail=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", isPlayerLocked=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", needClearTop=");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append(", isFullscreen=");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    localStringBuilder.append(", mIntent=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent);
    localStringBuilder.append(", mNeedLaunchPlugin=");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append(", mIsTabRedMap=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap);
    localStringBuilder.append(", mIsNewFlag=");
    localStringBuilder.append(this.jdField_h_of_type_Boolean);
    localStringBuilder.append(", mRedDotMissionIds='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsJumpActPage=");
    localStringBuilder.append(this.jdField_i_of_type_Boolean);
    localStringBuilder.append(", mJumpActUrl='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.ComicParam
 * JD-Core Version:    0.7.0.1
 */