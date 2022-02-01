package com.tencent.biz.qqstory.newshare.mode.base;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;

public abstract class WebShareModeBase
  extends ShareModeBase
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  public void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = this.c;
  }
  
  public void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.a = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append("] ");
    localStringBuilder.append(this.a);
    paramShareQQData.h = localStringBuilder.toString();
    paramShareQQData.f = this.d;
    paramShareQQData.r = this.a;
    paramShareQQData.s = this.b;
    paramShareQQData.m = this.c;
  }
  
  public void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.f = this.a;
    paramShareQZoneData.g = this.b;
    paramShareQZoneData.a = this.d;
    paramShareQZoneData.h = this.c;
  }
  
  public void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.f = this.c;
    String str = this.d;
    paramShareSinaData.h = str;
    paramShareSinaData.a = this.a;
    paramShareSinaData.g = ShareUtils.a(str);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.g = this.b;
    paramShareWeChatData.f = this.a;
    paramShareWeChatData.h = this.c;
    paramShareWeChatData.i = this.d;
    paramShareWeChatData.l = true;
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.g = this.b;
    paramShareWeChatData.f = this.a;
    paramShareWeChatData.h = this.c;
    paramShareWeChatData.i = this.d;
    paramShareWeChatData.l = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.WebShareModeBase
 * JD-Core Version:    0.7.0.1
 */