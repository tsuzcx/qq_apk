package com.tencent.biz.subscribe.part.block.base;

import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.SharePreferenceUtils;

public class LoadInfo
{
  private volatile int jdField_a_of_type_Int = 4;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private String jdField_a_of_type_JavaLangString = null;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private String b = null;
  private String c;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public String a()
  {
    if (this.c == null) {
      this.c = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(COMM.StCommonExt paramStCommonExt)
  {
    this.jdField_a_of_type_NS_COMMCOMM$StCommonExt = paramStCommonExt;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public COMM.StCommonExt b()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public String b()
  {
    if (this.b == null) {
      this.b = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_livePageInfo_cache");
    }
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.b = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 4;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Int == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.LoadInfo
 * JD-Core Version:    0.7.0.1
 */