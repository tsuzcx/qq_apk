package com.tencent.biz.qqstory.newshare.mode.base;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class MultiVideoShareModeBase
  extends ShareModeBase
{
  public int a;
  public StoryVideoItem a;
  protected int b = -1;
  public int c = -1;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public MultiVideoShareModeBase()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = a(6);
  }
  
  public final void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.b = 0;
    paramShareQQData.jdField_d_of_type_JavaLangString = this.k;
    paramShareQQData.a = this.a.mVideoThumbnailUrl;
    paramShareQQData.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramShareQQData.h = a(1);
    if (this.b != -1) {
      paramShareQQData.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramShareQQData.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.a = this.a.mVideoThumbnailUrl;
    paramShareQZoneData.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramShareQZoneData.jdField_d_of_type_JavaLangString = this.i;
    paramShareQZoneData.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareSinaData.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramShareSinaData.jdField_d_of_type_JavaLangString)) {
      paramShareSinaData.jdField_d_of_type_JavaLangString = ShareUtils.a(paramShareSinaData.jdField_e_of_type_JavaLangString);
    }
    paramShareSinaData.jdField_c_of_type_JavaLangString = a(5);
    paramShareSinaData.a = this.j;
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.i;
    paramShareWeChatData.a = this.jdField_e_of_type_JavaLangString;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(3);
    paramShareWeChatData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(ShareData paramShareData)
  {
    SLog.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramShareData);
    if (this.a.isPollVideo()) {
      paramShareData.a("vote", "1");
    }
    for (;;)
    {
      paramShareData.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramShareData.a("grade", "1");
      }
    }
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.i;
    paramShareWeChatData.a = this.jdField_d_of_type_JavaLangString;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(4);
    paramShareWeChatData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.MultiVideoShareModeBase
 * JD-Core Version:    0.7.0.1
 */