package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

public class BottomVideoInfoWidget$OnSimpleShareListenerImpl
  extends OnSimpleShareListener
{
  private final boolean b;
  private final VideoListFeedItem c;
  private final String d;
  private final StoryVideoItem e;
  private final boolean f;
  private final VideoViewVideoHolder g;
  private final boolean h;
  private final QQUserUIItem i;
  private boolean j;
  private final boolean k;
  private final long l;
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.j = true;
    SLog.b(this.a.i, "OnSimpleShareListenerImpl onChooseShareChannel");
    boolean bool = this.b;
    String str = "";
    if (bool) {
      StoryReportor.a("host_share", "share_chanel", 3, paramInt, new String[] { String.valueOf(StoryReportor.b(this.c)), "", this.d, this.e.mVid });
    } else {
      StoryReportor.a("host_share", "share_chanel", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.c)), "", this.d, this.e.mVid });
    }
    Object localObject1 = "2";
    Object localObject2;
    switch (paramInt)
    {
    case 6: 
    default: 
    case 11: 
      StoryReportor.a("play_video", "not_like", this.a.C(), 0, new String[] { "", "", "", this.e.mVid });
      return;
    case 10: 
      if (SendVideoToFriendHelper.a().b())
      {
        QQToast.makeText(this.a.y(), 0, HardCodeUtil.a(2131899421), 0).show();
      }
      else if (TextUtils.isEmpty(this.e.mLocalVideoPath))
      {
        QQToast.makeText(this.a.y(), 1, HardCodeUtil.a(2131899423), 0).show();
        SLog.e(this.a.i, "send video to friend failed because videoLocalPath is empty.");
      }
      else
      {
        this.a.a("", true, 300L);
        SendVideoToFriendHelper.a().a(this.e, String.valueOf(this.a.hashCode()));
      }
      StoryReportor.a("play_video", "share_friend", 0, 0, new String[] { "", "", "", this.e.mVid });
      return;
    case 9: 
      PlayModeUtils.a(this.a.y(), this.e, new BottomVideoInfoWidget.OnSimpleShareListenerImpl.2(this));
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      int m;
      if (this.k) {
        m = (int)this.l;
      } else {
        m = 0;
      }
      localObject1 = this.i;
      if (localObject1 == null) {
        localObject1 = "4";
      } else {
        localObject1 = String.valueOf(StoryReportor.a((IFeedOwner)localObject1));
      }
      StoryReportor.a("play_video", "more_report", paramInt, m, new String[] { "", localObject1 });
      paramInt = this.a.C();
      localObject1 = this.a.a(this.e);
      localObject2 = this.c;
      if (localObject2 != null) {
        str = ((VideoListFeedItem)localObject2).feedId;
      }
      StoryReportor.a("story_grp", "clk_one", paramInt, 0, new String[] { "7", localObject1, "", str });
      return;
    case 7: 
      if (SendVideoToFriendHelper.a().b())
      {
        QQToast.makeText(this.a.y(), 0, HardCodeUtil.a(2131899416), 0).show();
        return;
      }
      if (TextUtils.isEmpty(this.e.mLocalVideoPath))
      {
        SLog.d(this.a.i, "save video -info local file not exist , start download , vid:%s", new Object[] { this.e.mVid });
        BottomVideoInfoWidget.f(this.a).a(this.e.mVid, 0, false, new BottomVideoInfoWidget.OnSimpleShareListenerImpl.1(this));
      }
      else
      {
        SLog.d(this.a.i, "save video -info local file exist , start watermark , vid:%s", new Object[] { this.e.mVid });
        localObject2 = this.e;
        PlayModeUtils.a((StoryVideoItem)localObject2, ((StoryVideoItem)localObject2).mStoryType, String.valueOf(this.a.hashCode()));
      }
      paramInt = this.a.C();
      localObject2 = this.a.a(this.e);
      VideoListFeedItem localVideoListFeedItem = this.c;
      if (localVideoListFeedItem != null) {
        str = localVideoListFeedItem.feedId;
      }
      StoryReportor.a("story_grp", "clk_one", paramInt, 0, new String[] { "3", localObject2, "", str });
      if (!this.f) {
        localObject1 = "1";
      }
      StoryReportor.a("play_video", "clk_download", 0, 0, new String[] { localObject1 });
      return;
    case 5: 
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        localObject1 = "1";
      }
      if (this.k) {
        str = String.valueOf(this.l);
      } else {
        str = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 5, new String[] { localObject1, str, this.d, this.e.mVid });
      return;
    case 4: 
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        localObject1 = "1";
      }
      if (this.k) {
        str = String.valueOf(this.l);
      } else {
        str = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 4, new String[] { localObject1, str, this.d, this.e.mVid });
      return;
    case 3: 
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        localObject1 = "1";
      }
      if (this.k) {
        str = String.valueOf(this.l);
      } else {
        str = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 3, new String[] { localObject1, str, this.d, this.e.mVid });
      return;
    case 2: 
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        localObject1 = "1";
      }
      if (this.k) {
        str = String.valueOf(this.l);
      } else {
        str = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 2, new String[] { localObject1, str, this.d, this.e.mVid });
      return;
    case 1: 
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        localObject1 = "1";
      }
      if (this.k) {
        str = String.valueOf(this.l);
      } else {
        str = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 1, new String[] { localObject1, str, this.d, this.e.mVid });
    }
  }
  
  public void b()
  {
    super.b();
    SLog.b(this.a.i, "OnSimpleShareListenerImpl onShowUI");
    VideoViewVideoHolder localVideoViewVideoHolder = this.g;
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(true);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    SLog.b(this.a.i, "OnSimpleShareListenerImpl onSuccess");
    if (this.b) {
      StoryReportor.a("host_share", "suc_share", 3, paramInt, new String[] { String.valueOf(StoryReportor.b(this.c)), "", this.d, this.e.mVid });
    } else {
      StoryReportor.a("host_share", "suc_share", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.c)), "", this.d, this.e.mVid });
    }
    String str1 = "2";
    String str2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt == 10) {
                StoryReportor.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", this.e.mVid });
              }
            }
            else
            {
              if (this.h) {
                paramInt = 1;
              } else {
                paramInt = 2;
              }
              if (!this.f) {
                str1 = "1";
              }
              if (this.k) {
                str2 = String.valueOf(this.l);
              } else {
                str2 = String.valueOf(StoryReportor.a(this.c));
              }
              StoryReportor.a("play_video", "guest_share_suc", paramInt, 5, new String[] { str1, str2, this.d, this.e.mVid });
            }
          }
          else
          {
            if (this.h) {
              paramInt = 1;
            } else {
              paramInt = 2;
            }
            if (!this.f) {
              str1 = "1";
            }
            if (this.k) {
              str2 = String.valueOf(this.l);
            } else {
              str2 = String.valueOf(StoryReportor.a(this.c));
            }
            StoryReportor.a("play_video", "guest_share_suc", paramInt, 4, new String[] { str1, str2, this.d, this.e.mVid });
          }
        }
        else
        {
          if (this.h) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
          if (!this.f) {
            str1 = "1";
          }
          if (this.k) {
            str2 = String.valueOf(this.l);
          } else {
            str2 = String.valueOf(StoryReportor.a(this.c));
          }
          StoryReportor.a("play_video", "guest_share_suc", paramInt, 3, new String[] { str1, str2, this.d, this.e.mVid });
        }
      }
      else
      {
        if (this.h) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        if (!this.f) {
          str1 = "1";
        }
        if (this.k) {
          str2 = String.valueOf(this.l);
        } else {
          str2 = String.valueOf(StoryReportor.a(this.c));
        }
        StoryReportor.a("play_video", "guest_share_suc", paramInt, 2, new String[] { str1, str2, this.d, this.e.mVid });
      }
    }
    else
    {
      if (this.h) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.f) {
        str1 = "1";
      }
      if (this.k) {
        str2 = String.valueOf(this.l);
      } else {
        str2 = String.valueOf(StoryReportor.a(this.c));
      }
      StoryReportor.a("play_video", "guest_share_suc", paramInt, 1, new String[] { str1, str2, this.d, this.e.mVid });
    }
    if (this.e.getVideoGameInfo() != null)
    {
      if (this.f)
      {
        if (this.e.getVideoGameInfo().a == 1) {
          paramInt = 1;
        } else {
          paramInt = 3;
        }
      }
      else if (this.e.getVideoGameInfo().a == 1) {
        paramInt = 2;
      } else {
        paramInt = 4;
      }
      StoryReportor.a("video_game", "share_game", 0, 0, new String[] { String.valueOf(paramInt), "", "", this.e.getVideoGameInfo().b, this.e.mVid });
    }
  }
  
  public void c()
  {
    super.c();
    SLog.b(this.a.i, "OnSimpleShareListenerImpl onDismiss");
    VideoViewVideoHolder localVideoViewVideoHolder = this.g;
    if ((localVideoViewVideoHolder != null) && (!this.j)) {
      localVideoViewVideoHolder.c(false);
    }
    this.j = false;
  }
  
  public void d()
  {
    super.d();
    SLog.b(this.a.i, "OnSimpleShareListenerImpl onFinish");
    VideoViewVideoHolder localVideoViewVideoHolder = this.g;
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.OnSimpleShareListenerImpl
 * JD-Core Version:    0.7.0.1
 */