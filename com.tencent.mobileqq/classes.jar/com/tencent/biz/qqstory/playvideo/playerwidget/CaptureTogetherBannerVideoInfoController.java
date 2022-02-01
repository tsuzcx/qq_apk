package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoCompInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CaptureTogetherBannerVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private StoryPlayerVideoData f;
  private VideoLinkInfo g;
  private boolean h = false;
  private String i = "";
  private String j;
  private String k;
  private BannerVideoInfoWidget3.MyActivityLifeCycle l;
  private CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver m;
  private int n;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  private void d()
  {
    int i1 = this.n;
    if ((i1 != 1) && (i1 != 2)) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.f.e();
    Object localObject1 = this.g.k;
    i1 = this.f.e().comparedLevel;
    int i2 = this.n;
    String str1 = "2";
    String str2;
    if (i2 == 1)
    {
      Object localObject2 = ((VideoCompInfo)localObject1).a;
      str2 = ((VideoCompInfo)localObject1).b;
      i2 = ((VideoCompInfo)localObject1).e;
      localObject1 = (StoryManager)SuperManager.a(5);
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localObject1 = ((StoryManager)localObject1).b(str2);
      if (localObject1 != null)
      {
        a(str2, (String)localObject2, false, i1, i2);
        localObject2 = localUserManager.b(((StoryVideoItem)localObject1).mOwnerUid);
        if ((localObject2 != null) && (((QQUserUIItem)localObject2).isVip)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 == 0) {
          str1 = "1";
        }
        StoryReportor.a("play_video", "multishoot_entry_clk", 0, i2, new String[] { str1, str2, ((StoryVideoItem)localObject1).mOwnerUid, localStoryVideoItem.mVid });
        return;
      }
      this.j = str2;
      this.k = ((String)localObject2);
      return;
    }
    if (i2 == 2)
    {
      str2 = localStoryVideoItem.mVid;
      a(str2, "", true, i1, 0);
      localObject1 = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
      if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {
        str1 = "1";
      }
      StoryReportor.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { str1, str2, localStoryVideoItem.mOwnerUid, str2 });
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.m == null) {
      this.m = new CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver(this);
    }
    localHashMap.put(this.m, "");
    localHashMap.put(new CaptureTogetherBannerVideoInfoController.GetVideoBasicInfoListEventReceiver(this), "");
    localHashMap.put(new CaptureTogetherBannerVideoInfoController.GetStoryTagInfoReceiver(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    d();
    return true;
  }
  
  public Set<ActivityLifeCycle> b()
  {
    HashSet localHashSet = new HashSet(1);
    BannerVideoInfoWidget3.MyActivityLifeCycle localMyActivityLifeCycle = new BannerVideoInfoWidget3.MyActivityLifeCycle();
    this.l = localMyActivityLifeCycle;
    localHashSet.add(localMyActivityLifeCycle);
    return localHashSet;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.f = paramStoryPlayerVideoData;
    this.j = null;
    this.k = null;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.e();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    VideoLinkInfo localVideoLinkInfo = localStoryVideoItem.getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).k != null) && (!TextUtils.isEmpty(((VideoLinkInfo)localObject).k.b)))
    {
      this.n = 1;
      this.g = ((VideoLinkInfo)localObject);
      SLog.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramStoryPlayerVideoData.b, this.g.c, this.g.k.b, Integer.valueOf(this.g.k.e), this.g.k.a, this.g.k.d });
    }
    else
    {
      if ((localVideoLinkInfo == null) || (localVideoLinkInfo.a != 3)) {
        break label522;
      }
      this.n = 2;
      this.g = localVideoLinkInfo;
      SLog.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramStoryPlayerVideoData.b, this.g.c);
    }
    this.a.z();
    localObject = this.g.k;
    if (TextUtils.equals(this.i, paramStoryPlayerVideoData.b))
    {
      this.h = false;
    }
    else
    {
      this.h = true;
      this.i = paramStoryPlayerVideoData.b;
    }
    paramBannerViewHolder.c.setVisibility(0);
    paramBannerViewHolder.e.setVisibility(0);
    paramBannerViewHolder.b.setVisibility(0);
    paramStoryPlayerVideoData = this.g.c;
    if (!TextUtils.isEmpty(paramStoryPlayerVideoData))
    {
      paramBannerViewHolder.c.setText(paramStoryPlayerVideoData);
      paramBannerViewHolder.c.setContentDescription(paramStoryPlayerVideoData);
    }
    else
    {
      paramBannerViewHolder.c.setText(HardCodeUtil.a(2131899676));
      paramBannerViewHolder.c.setContentDescription(HardCodeUtil.a(2131899677));
    }
    paramBannerViewHolder.b.setImageResource(2130848215);
    if ((localObject != null) && (!TextUtils.isEmpty(((VideoCompInfo)localObject).d))) {
      BannerVideoInfoWidget3.a(((VideoCompInfo)localObject).d, paramBannerViewHolder.b, paramBannerViewHolder.a.getContext().getResources().getDrawable(2130848215), paramBannerViewHolder.g, paramBannerViewHolder.g);
    }
    paramBannerViewHolder = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
    if (this.h)
    {
      int i1;
      if ((paramBannerViewHolder != null) && (paramBannerViewHolder.isVip)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if (localObject != null) {
        i2 = ((VideoCompInfo)localObject).e;
      } else {
        i2 = 0;
      }
      if (i1 != 0) {
        paramBannerViewHolder = "2";
      } else {
        paramBannerViewHolder = "1";
      }
      if (localObject != null) {
        paramStoryPlayerVideoData = ((VideoCompInfo)localObject).b;
      } else {
        paramStoryPlayerVideoData = "";
      }
      StoryReportor.a("play_video", "multishoot_entry_exp", 0, i2, new String[] { paramBannerViewHolder, paramStoryPlayerVideoData, "", localStoryVideoItem.mVid });
    }
    return;
    label522:
    SLog.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramStoryPlayerVideoData.b);
    this.a.A();
    this.n = -1;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */