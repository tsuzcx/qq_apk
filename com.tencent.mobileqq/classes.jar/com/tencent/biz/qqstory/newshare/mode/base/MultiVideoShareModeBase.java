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
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected StoryVideoItem i;
  protected int j;
  protected String k;
  protected String l;
  protected String m;
  protected int n = -1;
  protected int o = -1;
  protected int p = 1;
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = a(6);
  }
  
  public final void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.a = 0;
    paramShareQQData.h = this.m;
    paramShareQQData.f = this.i.mVideoThumbnailUrl;
    paramShareQQData.j = this.i.mVid;
    paramShareQQData.m = a(1);
    int i1 = this.n;
    if (i1 != -1) {
      paramShareQQData.p = i1;
    }
    i1 = this.o;
    if (i1 != -1) {
      paramShareQQData.q = i1;
    }
  }
  
  public final void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.a = this.i.mVideoThumbnailUrl;
    paramShareQZoneData.f = this.d;
    paramShareQZoneData.g = this.k;
    paramShareQZoneData.h = a(2);
  }
  
  public final void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.h = this.i.mVideoThumbnailUrl;
    paramShareSinaData.g = this.i.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramShareSinaData.g)) {
      paramShareSinaData.g = ShareUtils.a(paramShareSinaData.h);
    }
    paramShareSinaData.f = a(5);
    paramShareSinaData.a = this.l;
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.g = this.k;
    paramShareWeChatData.f = this.e;
    paramShareWeChatData.h = a(3);
    paramShareWeChatData.i = this.i.mVideoThumbnailUrl;
    paramShareWeChatData.l = true;
  }
  
  protected void a_(ShareData paramShareData)
  {
    SLog.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramShareData);
    if (this.i.isPollVideo()) {
      paramShareData.a("vote", "1");
    } else if (this.i.isInteractVideo()) {
      paramShareData.a("grade", "1");
    }
    paramShareData.e = this.i;
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.g = this.k;
    paramShareWeChatData.f = this.d;
    paramShareWeChatData.h = a(4);
    paramShareWeChatData.i = this.i.mVideoThumbnailUrl;
    paramShareWeChatData.l = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.MultiVideoShareModeBase
 * JD-Core Version:    0.7.0.1
 */