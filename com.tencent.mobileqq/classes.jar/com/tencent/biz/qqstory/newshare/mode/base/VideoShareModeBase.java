package com.tencent.biz.qqstory.newshare.mode.base;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class VideoShareModeBase
  extends ShareModeBase
{
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected StoryVideoItem j;
  protected int k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected int p = -1;
  protected int v = -1;
  protected int w = 1;
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = a(6);
    a(paramShareCopyLinkData);
  }
  
  protected void a(ShareData paramShareData) {}
  
  public final void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.a = 0;
    paramShareQQData.h = this.n;
    paramShareQQData.f = this.j.mVideoThumbnailUrl;
    paramShareQQData.j = this.j.mVid;
    paramShareQQData.o = this.o;
    paramShareQQData.m = a(1);
    int i1 = this.p;
    if (i1 != -1) {
      paramShareQQData.p = i1;
    }
    i1 = this.v;
    if (i1 != -1) {
      paramShareQQData.q = i1;
    }
    a(paramShareQQData);
  }
  
  public final void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.a = this.j.mVideoThumbnailUrl;
    paramShareQZoneData.f = this.e;
    paramShareQZoneData.g = this.l;
    paramShareQZoneData.h = a(2);
    a(paramShareQZoneData);
  }
  
  public final void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.h = this.j.mVideoThumbnailUrl;
    paramShareSinaData.g = this.j.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramShareSinaData.g)) {
      paramShareSinaData.g = ShareUtils.a(paramShareSinaData.h);
    }
    paramShareSinaData.f = a(5);
    paramShareSinaData.a = this.m;
    a(paramShareSinaData);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.g = this.l;
    paramShareWeChatData.f = this.e;
    paramShareWeChatData.h = a(3);
    paramShareWeChatData.i = this.j.mVideoThumbnailUrl;
    paramShareWeChatData.l = true;
    a(paramShareWeChatData);
  }
  
  protected void a_(ShareData paramShareData)
  {
    SLog.b("VideoShareModeBase", "prepareCommonShareData");
    super.a_(paramShareData);
    if (this.j.isPollVideo()) {
      paramShareData.a("vote", "1");
    } else if (this.j.isInteractVideo()) {
      paramShareData.a("grade", "1");
    }
    paramShareData.e = this.j;
  }
  
  protected String b()
  {
    if (this.j.isPollVideo())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913565));
      return ((StringBuilder)localObject).toString();
    }
    if (this.j.isInteractVideo())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913575));
      return ((StringBuilder)localObject).toString();
    }
    if (this.j.isGameVideo())
    {
      localObject = this.j.getVideoGameInfo();
      if (((VideoGameInfo)localObject).a == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131913566));
        localStringBuilder.append(((VideoGameInfo)localObject).c);
        localStringBuilder.append(HardCodeUtil.a(2131913556));
        return localStringBuilder.toString();
      }
      if (this.k == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131913557));
        localStringBuilder.append(((VideoGameInfo)localObject).c);
        localStringBuilder.append(((VideoGameInfo)localObject).d);
        localStringBuilder.append(HardCodeUtil.a(2131913574));
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j.mOwnerName);
      localStringBuilder.append(HardCodeUtil.a(2131913560));
      localStringBuilder.append(((VideoGameInfo)localObject).c);
      localStringBuilder.append(((VideoGameInfo)localObject).d);
      localStringBuilder.append(HardCodeUtil.a(2131913559));
      return localStringBuilder.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131913563));
    ((StringBuilder)localObject).append(QQStoryConstant.a);
    return ((StringBuilder)localObject).toString();
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.g = this.l;
    paramShareWeChatData.f = this.e;
    paramShareWeChatData.i = this.j.mVideoThumbnailUrl;
    paramShareWeChatData.h = a(4);
    paramShareWeChatData.l = true;
    a(paramShareWeChatData);
  }
  
  protected String c()
  {
    Object localObject1 = this.j.getPollLayout();
    Object localObject2 = this.j.getInteractLayout();
    if ((localObject1 != null) && (((StoryVideoItem.PollLayout)localObject1).j != null) && (((StoryVideoItem.PollLayout)localObject1).j.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" · ");
      localStringBuilder.append(localObject1.j[0]);
      return localStringBuilder.toString();
    }
    if ((localObject2 != null) && (((StoryVideoItem.InteractPasterLayout)localObject2).i != null) && (((StoryVideoItem.InteractPasterLayout)localObject2).i.length > 0))
    {
      localObject1 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" · ");
      localStringBuilder.append(localObject2.i[0]);
      return localStringBuilder.toString();
    }
    localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
    if (TextUtils.isEmpty(this.h)) {
      localObject1 = "1个小视频";
    } else {
      localObject1 = this.h;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(" · ");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase
 * JD-Core Version:    0.7.0.1
 */