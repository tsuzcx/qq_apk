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
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i = QQStoryContext.a().i();
  protected String j;
  protected String k;
  protected int l = -1;
  protected int m = -1;
  protected boolean n = false;
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = a(6);
    a(paramShareCopyLinkData);
  }
  
  protected void a(ShareData paramShareData) {}
  
  public void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.a = 1;
    paramShareQQData.t = this.h;
    paramShareQQData.h = this.g;
    paramShareQQData.s = this.f;
    paramShareQQData.r = this.e;
    paramShareQQData.f = this.j;
    paramShareQQData.m = a(1);
    int i1 = this.l;
    if (i1 != -1) {
      paramShareQQData.p = i1;
    }
    i1 = this.m;
    if (i1 != -1) {
      paramShareQQData.q = i1;
    }
    a(paramShareQQData);
  }
  
  public void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.f = this.e;
    paramShareQZoneData.g = this.f;
    paramShareQZoneData.a = this.j;
    paramShareQZoneData.h = a(2);
    a(paramShareQZoneData);
  }
  
  public void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.a = this.k;
    String str = this.j;
    paramShareSinaData.h = str;
    paramShareSinaData.i = this.n;
    paramShareSinaData.g = ShareUtils.a(str);
    paramShareSinaData.f = a(5);
    a(paramShareSinaData);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.f = this.e;
    paramShareWeChatData.g = this.f;
    paramShareWeChatData.h = a(3);
    paramShareWeChatData.i = this.j;
    paramShareWeChatData.k = true;
    a(paramShareWeChatData);
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.f = this.e;
    paramShareWeChatData.g = this.f;
    paramShareWeChatData.h = a(4);
    paramShareWeChatData.i = this.j;
    paramShareWeChatData.k = true;
    a(paramShareWeChatData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase
 * JD-Core Version:    0.7.0.1
 */