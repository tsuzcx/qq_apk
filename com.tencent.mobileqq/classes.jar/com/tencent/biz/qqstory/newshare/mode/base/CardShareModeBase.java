package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;

public abstract class CardShareModeBase
  extends ShareModeBase
{
  protected int a;
  protected boolean a;
  protected int b = -1;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i = QQStoryContext.a().b();
  public String j;
  protected String k;
  
  public CardShareModeBase()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.jdField_a_of_type_JavaLangString = a(6);
    a(paramShareCopyLinkData);
  }
  
  protected void a(ShareData paramShareData) {}
  
  public void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.b = 1;
    paramShareQQData.m = this.h;
    paramShareQQData.jdField_d_of_type_JavaLangString = this.g;
    paramShareQQData.l = this.f;
    paramShareQQData.k = this.e;
    paramShareQQData.jdField_a_of_type_JavaLangString = this.j;
    paramShareQQData.h = a(1);
    if (this.jdField_a_of_type_Int != -1) {
      paramShareQQData.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    }
    if (this.b != -1) {
      paramShareQQData.e = this.b;
    }
    a(paramShareQQData);
  }
  
  public void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.c = this.e;
    paramShareQZoneData.jdField_d_of_type_JavaLangString = this.f;
    paramShareQZoneData.jdField_a_of_type_JavaLangString = this.j;
    paramShareQZoneData.e = a(2);
    a(paramShareQZoneData);
  }
  
  public void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.jdField_a_of_type_JavaLangString = this.k;
    paramShareSinaData.e = this.j;
    paramShareSinaData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramShareSinaData.jdField_d_of_type_JavaLangString = ShareUtils.a(this.j);
    paramShareSinaData.c = a(5);
    a(paramShareSinaData);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.jdField_a_of_type_JavaLangString = this.e;
    paramShareWeChatData.c = this.f;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(3);
    paramShareWeChatData.e = this.j;
    paramShareWeChatData.b = true;
    a(paramShareWeChatData);
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.jdField_a_of_type_JavaLangString = this.e;
    paramShareWeChatData.c = this.f;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(4);
    paramShareWeChatData.e = this.j;
    paramShareWeChatData.b = true;
    a(paramShareWeChatData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase
 * JD-Core Version:    0.7.0.1
 */