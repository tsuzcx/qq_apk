package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;

public abstract class WebShareModeBase
  extends ShareModeBase
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  public void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.b = 2;
    paramShareQQData.d = ("[小视频] " + this.a);
    paramShareQQData.a = this.d;
    paramShareQQData.k = this.a;
    paramShareQQData.l = this.b;
    paramShareQQData.h = this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.jdField_c_of_type_JavaLangString = this.a;
    paramShareQZoneData.d = this.b;
    paramShareQZoneData.a = this.d;
    paramShareQZoneData.e = this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    paramShareSinaData.e = this.d;
    paramShareSinaData.a = this.a;
    paramShareSinaData.d = ShareUtils.a(this.d);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.b;
    paramShareWeChatData.a = this.a;
    paramShareWeChatData.d = this.jdField_c_of_type_JavaLangString;
    paramShareWeChatData.e = this.d;
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.b;
    paramShareWeChatData.a = this.a;
    paramShareWeChatData.d = this.jdField_c_of_type_JavaLangString;
    paramShareWeChatData.e = this.d;
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.WebShareModeBase
 * JD-Core Version:    0.7.0.1
 */