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
  private final long jdField_a_of_type_Long;
  private final QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private final StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private final VideoViewVideoHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
  private final VideoListFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  private boolean d;
  private final boolean e;
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.d = true;
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "OnSimpleShareListenerImpl onChooseShareChannel");
    boolean bool = this.jdField_a_of_type_Boolean;
    String str = "";
    if (bool) {
      StoryReportor.a("host_share", "share_chanel", 3, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    } else {
      StoryReportor.a("host_share", "share_chanel", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
    Object localObject1 = "2";
    Object localObject2;
    switch (paramInt)
    {
    case 6: 
    default: 
    case 11: 
      StoryReportor.a("play_video", "not_like", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.c(), 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 10: 
      if (SendVideoToFriendHelper.a().a())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b(), 0, HardCodeUtil.a(2131701394), 0).a();
      }
      else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b(), 1, HardCodeUtil.a(2131701396), 0).a();
        SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "send video to friend failed because videoLocalPath is empty.");
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.a("", true, 300L);
        SendVideoToFriendHelper.a().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.hashCode()));
      }
      StoryReportor.a("play_video", "share_friend", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 9: 
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, new BottomVideoInfoWidget.OnSimpleShareListenerImpl.2(this));
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      int i;
      if (this.e) {
        i = (int)this.jdField_a_of_type_Long;
      } else {
        i = 0;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if (localObject1 == null) {
        localObject1 = "4";
      } else {
        localObject1 = String.valueOf(StoryReportor.a((IFeedOwner)localObject1));
      }
      StoryReportor.a("play_video", "more_report", paramInt, i, new String[] { "", localObject1 });
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.c();
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      if (localObject2 != null) {
        str = ((VideoListFeedItem)localObject2).feedId;
      }
      StoryReportor.a("story_grp", "clk_one", paramInt, 0, new String[] { "7", localObject1, "", str });
      return;
    case 7: 
      if (SendVideoToFriendHelper.a().a())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b(), 0, HardCodeUtil.a(2131701389), 0).a();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath))
      {
        SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "save video -info local file not exist , start download , vid:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        BottomVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new BottomVideoInfoWidget.OnSimpleShareListenerImpl.1(this));
      }
      else
      {
        SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "save video -info local file exist , start watermark , vid:%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        PlayModeUtils.a((StoryVideoItem)localObject2, ((StoryVideoItem)localObject2).mStoryType, String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.hashCode()));
      }
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.c();
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      if (localVideoListFeedItem != null) {
        str = localVideoListFeedItem.feedId;
      }
      StoryReportor.a("story_grp", "clk_one", paramInt, 0, new String[] { "3", localObject2, "", str });
      if (!this.b) {
        localObject1 = "1";
      }
      StoryReportor.a("play_video", "clk_download", 0, 0, new String[] { localObject1 });
      return;
    case 5: 
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        localObject1 = "1";
      }
      if (this.e) {
        str = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 5, new String[] { localObject1, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 4: 
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        localObject1 = "1";
      }
      if (this.e) {
        str = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 4, new String[] { localObject1, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 3: 
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        localObject1 = "1";
      }
      if (this.e) {
        str = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 3, new String[] { localObject1, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 2: 
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        localObject1 = "1";
      }
      if (this.e) {
        str = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 2, new String[] { localObject1, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    case 1: 
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        localObject1 = "1";
      }
      if (this.e) {
        str = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share", paramInt, 1, new String[] { localObject1, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
  
  public void b()
  {
    super.b();
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "OnSimpleShareListenerImpl onShowUI");
    VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(true);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "OnSimpleShareListenerImpl onSuccess");
    if (this.jdField_a_of_type_Boolean) {
      StoryReportor.a("host_share", "suc_share", 3, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    } else {
      StoryReportor.a("host_share", "suc_share", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
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
                StoryReportor.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
              }
            }
            else
            {
              if (this.c) {
                paramInt = 1;
              } else {
                paramInt = 2;
              }
              if (!this.b) {
                str1 = "1";
              }
              if (this.e) {
                str2 = String.valueOf(this.jdField_a_of_type_Long);
              } else {
                str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
              }
              StoryReportor.a("play_video", "guest_share_suc", paramInt, 5, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
            }
          }
          else
          {
            if (this.c) {
              paramInt = 1;
            } else {
              paramInt = 2;
            }
            if (!this.b) {
              str1 = "1";
            }
            if (this.e) {
              str2 = String.valueOf(this.jdField_a_of_type_Long);
            } else {
              str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
            }
            StoryReportor.a("play_video", "guest_share_suc", paramInt, 4, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
          }
        }
        else
        {
          if (this.c) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
          if (!this.b) {
            str1 = "1";
          }
          if (this.e) {
            str2 = String.valueOf(this.jdField_a_of_type_Long);
          } else {
            str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
          }
          StoryReportor.a("play_video", "guest_share_suc", paramInt, 3, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        }
      }
      else
      {
        if (this.c) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        if (!this.b) {
          str1 = "1";
        }
        if (this.e) {
          str2 = String.valueOf(this.jdField_a_of_type_Long);
        } else {
          str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
        }
        StoryReportor.a("play_video", "guest_share_suc", paramInt, 2, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      }
    }
    else
    {
      if (this.c) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (!this.b) {
        str1 = "1";
      }
      if (this.e) {
        str2 = String.valueOf(this.jdField_a_of_type_Long);
      } else {
        str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      }
      StoryReportor.a("play_video", "guest_share_suc", paramInt, 1, new String[] { str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo() != null)
    {
      if (this.b)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_Int == 1) {
          paramInt = 1;
        } else {
          paramInt = 3;
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_Int == 1) {
        paramInt = 2;
      } else {
        paramInt = 4;
      }
      StoryReportor.a("video_game", "share_game", 0, 0, new String[] { String.valueOf(paramInt), "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoGameInfo().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
  
  public void c()
  {
    super.c();
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "OnSimpleShareListenerImpl onDismiss");
    VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
    if ((localVideoViewVideoHolder != null) && (!this.d)) {
      localVideoViewVideoHolder.c(false);
    }
    this.d = false;
  }
  
  public void d()
  {
    super.d();
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b, "OnSimpleShareListenerImpl onFinish");
    VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.OnSimpleShareListenerImpl
 * JD-Core Version:    0.7.0.1
 */