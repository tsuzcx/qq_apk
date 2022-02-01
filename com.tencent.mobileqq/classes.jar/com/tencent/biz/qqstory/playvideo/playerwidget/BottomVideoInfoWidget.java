package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.comment.FeedLikeDataProvider;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.videoplayer.StoryPlayerCommentDialog.CommentDialogListener;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber;
import java.io.File;
import java.util.Map;

public class BottomVideoInfoWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener, StoryPlayerCommentDialog.CommentDialogListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StorySingleFileDownloader jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader = new StorySingleFileDownloader();
  private final LikeManager jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = (LikeManager)SuperManager.a(15);
  protected StoryShare a;
  private CommentFloatDialog jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog;
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  private BottomVideoInfoWidget.MyActivityLifeCycle jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle;
  private BottomVideoInfoWidget.RenderResDownloadListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$RenderResDownloadListener;
  private final FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = (FeedManager)SuperManager.a(11);
  private PressDarkImageView jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageView jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private View d;
  private View e;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = false;
  
  public BottomVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo) {}
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846797);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847100);
    }
    if (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(UIUtils.a(paramVideoListFeedItem.mLikeCount));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701399));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(b().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new BottomVideoInfoWidget.8(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(UIUtils.a(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701402));
  }
  
  private int d()
  {
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return;
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (((Boolean)localStoryConfigManager.b("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      QQCustomDialog localQQCustomDialog = DialogUtil.a(b(), 230);
      localQQCustomDialog.setTitle(HardCodeUtil.a(2131701400)).setMessage(HardCodeUtil.a(2131701393)).setPositiveButton(HardCodeUtil.a(2131701401), new BottomVideoInfoWidget.5(this)).setOnDismissListener(new BottomVideoInfoWidget.4(this, localVideoViewVideoHolder));
      localQQCustomDialog.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localStoryConfigManager.b("first_clk_forward", Boolean.valueOf(false));
      StoryReportor.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    else
    {
      e();
    }
    StoryReportor.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return;
    }
    Object localObject2 = (UserManager)SuperManager.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    if (localStoryVideoItem == null)
    {
      SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    localObject2 = ((UserManager)localObject2).b(localStoryVideoItem.mOwnerUid);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    if ((!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (new File(localStoryVideoItem.mLocalVideoPath).exists()))
    {
      a(localStoryVideoItem.mLocalVideoPath, ((QQUserUIItem)localObject2).uid, (String)localObject1, localStoryVideoItem.mVid, ((QQUserUIItem)localObject2).nickName, ((QQUserUIItem)localObject2).headUrl);
    }
    else
    {
      a(b().getString(2131720209), true);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader.a(localStoryVideoItem.mVid, 0, true, new BottomVideoInfoWidget.6(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      ThreadManager.getUIHandlerV2().postDelayed(new BottomVideoInfoWidget.7(this, localVideoViewVideoHolder, localStoryVideoItem), 15000L);
    }
    StoryReportor.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
  }
  
  public String a()
  {
    return "BottomVideoInfoWidget";
  }
  
  public String a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail()) {
      return "3";
    }
    if (paramStoryVideoItem.isUploading()) {
      return "1";
    }
    return "2";
  }
  
  public void a(View paramView)
  {
    new BottomVideoInfoWidget.1(this);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381203);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381204);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131370026);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131370030));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370028));
    this.e = paramView.findViewById(2131364910);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364944));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131364955));
    this.e.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131377360);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramStoryPlayerVideoData);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(paramStoryPlayerVideoData.jdField_b_of_type_JavaLangString, true);
    boolean bool2 = paramStoryVideoItem.isUploadSuc();
    boolean bool1 = false;
    if ((bool2) && (localVideoListFeedItem != null))
    {
      if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
      {
        this.jdField_f_of_type_Boolean = false;
      }
      else
      {
        this.jdField_f_of_type_Boolean = true;
        this.jdField_c_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      }
      localObject = ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
      int i = a().mUIStyle.bottomWidgetShowFlag;
      if (i != 1)
      {
        if (i != 2)
        {
          if ((paramStoryVideoItem.mStoryType == 1) && (localObject != null) && (!((QQUserUIItem)localObject).isVip()) && (!((QQUserUIItem)localObject).isFriend())) {
            ((QQUserUIItem)localObject).isMe();
          }
          if ((localObject != null) && (((QQUserUIItem)localObject).isFriend())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((localObject != null) && (((QQUserUIItem)localObject).isMe())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          boolean bool3;
          if ((localObject != null) && (((QQUserUIItem)localObject).isVip())) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          boolean bool4;
          if (paramStoryVideoItem.mBanType == 1000) {
            bool4 = true;
          } else {
            bool4 = false;
          }
          boolean bool5;
          if (paramStoryVideoItem.mStoryType == 2) {
            bool5 = true;
          } else {
            bool5 = false;
          }
          SLog.d(this.jdField_b_of_type_JavaLangString, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5))
          {
            if ((bool1) && (i == 3))
            {
              SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because friend and showBottomWidgetFlag=3");
              break label466;
            }
            SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget");
          }
          else
          {
            SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget");
            break label466;
          }
        }
        else
        {
          SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
        }
        i = 0;
        break label468;
      }
      else
      {
        SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      }
      label466:
      i = 1;
      label468:
      if (i != 0)
      {
        j();
        if (FontSettingManager.getFontLevel() > 16.0F)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        a(localVideoListFeedItem);
        b(localVideoListFeedItem);
        if ((localObject != null) && (((QQUserUIItem)localObject).isFriend())) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if ((localObject != null) && (((QQUserUIItem)localObject).isMe())) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if ((localObject != null) && (((QQUserUIItem)localObject).isVip())) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (paramStoryVideoItem.mStoryType == 2) {
          m = 1;
        } else {
          m = 0;
        }
        if ((m == 0) && (j == 0) && (i == 0) && (k != 0))
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          if (this.jdField_f_of_type_Boolean) {
            StoryReportor.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
          }
        }
        else
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        k();
      }
      return;
    }
    Object localObject = this.jdField_b_of_type_JavaLangString;
    bool2 = paramStoryVideoItem.isUploadSuc();
    if (localVideoListFeedItem == null) {
      bool1 = true;
    }
    SLog.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool2 ^ true), Boolean.valueOf(bool1), paramStoryPlayerVideoData.jdField_b_of_type_JavaLangString });
    k();
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new BottomVideoInfoWidget.GetFeedFeatureReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GenShareThumbReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GetFeedItemReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.DownloadStatusUpdateReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GetUserInfoReceiver(this), "");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle = new BottomVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(paramCommentEntry.feedId, true);
    if (localVideoListFeedItem != null)
    {
      if (paramBoolean)
      {
        if (localVideoListFeedItem.mFriendCommentCount != -1) {
          localVideoListFeedItem.mFriendCommentCount += 1;
        } else {
          localVideoListFeedItem.mFriendCommentCount = 1;
        }
        if (localVideoListFeedItem.mCommentCount != -1) {
          localVideoListFeedItem.mCommentCount += 1;
        } else {
          localVideoListFeedItem.mCommentCount = 1;
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)))
        {
          localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
          paramBoolean = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
          Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
          if ((paramBoolean) && (localObject2 != null))
          {
            localObject2 = ((StoryVideoItem)localObject2).mVid;
            StoryReportor.a("play_video", "findsucess_reply", (int)((MsgTabNodeInfo)localObject1).a((String)localObject2), 0, new String[] { "", "", "", localObject2 });
          }
        }
      }
      Object localObject1 = new FeedInfoChangeEvent(1, paramCommentEntry.feedId, 1);
      ((FeedInfoChangeEvent)localObject1).c = paramCommentEntry.commentId;
      ((FeedInfoChangeEvent)localObject1).a = localVideoListFeedItem;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo == null) || (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a != 13);
  }
  
  public int b()
  {
    return 2131561723;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return false;
    }
    Object localObject1 = (UserManager)SuperManager.a(2);
    StoryPlayerVideoData localStoryPlayerVideoData = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
    Object localObject3 = localStoryPlayerVideoData.a();
    VideoListFeedItem localVideoListFeedItem = localStoryPlayerVideoData.a();
    Object localObject2 = null;
    if (localObject3 != null) {
      localObject1 = ((UserManager)localObject1).b(((StoryVideoItem)localObject3).mOwnerUid);
    } else {
      localObject1 = null;
    }
    int i;
    if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip)) {
      i = 1;
    } else {
      i = 0;
    }
    if (localObject1 != null) {
      ((QQUserUIItem)localObject1).isMe();
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
    long l2 = 0L;
    long l1;
    boolean bool1;
    if ((localObject1 != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)))
    {
      localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      boolean bool2 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
      l1 = l2;
      bool1 = bool2;
      if (bool2)
      {
        l1 = l2;
        bool1 = bool2;
        if (localObject1 != null)
        {
          l1 = l2;
          bool1 = bool2;
          if (localObject3 != null)
          {
            l1 = ((MsgTabNodeInfo)localObject1).a(((StoryVideoItem)localObject3).mVid);
            bool1 = bool2;
          }
        }
      }
    }
    else
    {
      bool1 = false;
      l1 = l2;
    }
    if ((c()) && (this.d.getVisibility() == 0))
    {
      if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mHadLike != 1))
      {
        this.d.setTag(Boolean.valueOf(true));
        onClick(this.d);
      }
      localObject3 = a();
      localObject1 = localObject2;
      if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
        localObject1 = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId;
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      int j = c();
      if (bool1) {
        localObject1 = String.valueOf(l1);
      } else {
        localObject1 = String.valueOf(StoryReportor.a((String)localObject1, localVideoListFeedItem));
      }
      StoryReportor.a("play_video", "dbl_like", i, j, new String[] { "", localObject1, "", localStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return true;
    }
    return false;
  }
  
  protected void f() {}
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader;
    if (localObject != null) {
      ((StorySingleFileDownloader)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
    if (localObject != null) {
      ((CommentFloatDialogController)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null)
    {
      Object localObject1 = (UserManager)SuperManager.a(2);
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      if (localStoryVideoItem == null)
      {
        SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      }
      else
      {
        VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(localStoryVideoItem.mOwnerUid);
        int i;
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool4 = PlayModeUtils.a(localStoryVideoItem);
        boolean bool2;
        boolean bool1;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
        {
          localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
          bool2 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
          bool1 = bool2;
          if (bool2)
          {
            l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
            bool1 = bool2;
            break label185;
          }
        }
        else
        {
          bool1 = false;
        }
        long l = 0L;
        label185:
        int j = paramView.getId();
        String str = "2";
        Object localObject2;
        switch (j)
        {
        default: 
          break;
        case 2131381203: 
        case 2131381204: 
          bool1 = true;
          break;
        case 2131377360: 
          d();
          break;
        case 2131370026: 
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
          {
            bool2 = ((Boolean)localObject1).booleanValue();
            paramView.setTag(null);
          }
          else
          {
            bool2 = false;
          }
          if (localVideoListFeedItem != null)
          {
            localObject1 = new LikeEntry();
            ((LikeEntry)localObject1).likeTime = System.currentTimeMillis();
            ((LikeEntry)localObject1).uin = QQStoryContext.a().a();
            ((LikeEntry)localObject1).unionId = QQStoryContext.a().b();
            ((LikeEntry)localObject1).feedId = localVideoListFeedItem.feedId;
            boolean bool3;
            if (localVideoListFeedItem.mHadLike == 1) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            if (bool3)
            {
              localVideoListFeedItem.mHadLike = 0;
              localVideoListFeedItem.mLikeCount -= 1;
            }
            else
            {
              localVideoListFeedItem.mHadLike = 1;
              localVideoListFeedItem.mLikeCount += 1;
            }
            int k = localVideoListFeedItem.getCommentLikeType();
            int m = c();
            j = 106;
            if (m != 106) {
              j = 0;
            }
            FeedLikeDataProvider.a(localVideoListFeedItem, bool3 ^ true, k, j);
            i();
            ThreadManager.post(new BottomVideoInfoWidget.3(this, bool3, (LikeEntry)localObject1, localVideoListFeedItem), 5, null, false);
            if (!bool2)
            {
              localObject1 = a();
              if ((((OpenPlayerBuilder.Data)localObject1).mInfo instanceof MsgTabPlayInfo)) {
                localObject2 = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject1).mInfo).nodeUnionId;
              } else {
                localObject2 = null;
              }
              if (bool3) {
                localObject1 = "unlike";
              } else {
                localObject1 = "like";
              }
              if (bool1) {
                j = (int)l;
              } else {
                j = StoryReportor.a((String)localObject2, localVideoListFeedItem);
              }
              k = c();
              if (i != 0) {
                localObject2 = "2";
              } else {
                localObject2 = "1";
              }
              if (!bool4) {
                str = "1";
              }
              StoryReportor.a("play_video", (String)localObject1, j, k, new String[] { localObject2, str, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
            }
          }
          else if ((localStoryVideoItem.mHasLike != -1) && (localStoryVideoItem.mHasLike != 0))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847100);
            localStoryVideoItem.mHasLike = 0;
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846797);
            localStoryVideoItem.mHasLike = 1;
          }
          break;
        case 2131364910: 
          bool1 = false;
        }
        if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mDenyComment == 1))
        {
          QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131701397), 0).a();
        }
        else
        {
          VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
          if (localVideoViewVideoHolder != null) {
            localVideoViewVideoHolder.c(true);
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController == null) {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = new CommentFloatDialogController();
          }
          localObject1 = HardCodeUtil.a(2131701398);
          if ((localVideoListFeedItem != null) && (localVideoListFeedItem.type == 2))
          {
            localObject1 = localVideoListFeedItem.getOwner().getName();
          }
          else if (localQQUserUIItem != null)
          {
            if (localStoryVideoItem.mStoryType == 2)
            {
              localObject2 = localStoryVideoItem.mGroupId;
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (localVideoListFeedItem != null)
                {
                  localObject1 = localObject2;
                  if (localVideoListFeedItem.getOwner() != null)
                  {
                    localObject1 = localObject2;
                    if ((localVideoListFeedItem.getOwner() instanceof QQUserUIItem)) {
                      localObject1 = ((QQUserUIItem)localVideoListFeedItem.getOwner()).qq;
                    }
                  }
                }
              }
            }
            else
            {
              localObject1 = null;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = ((TroopNickNameManager)SuperManager.a(23)).a(localQQUserUIItem, (String)localObject1, false, true);
            } else if (localQQUserUIItem.isVipButNoFriend()) {
              localObject1 = localQQUserUIItem.nickName;
            } else {
              localObject1 = localQQUserUIItem.getDisplayName();
            }
          }
          localObject2 = a();
          if ((((OpenPlayerBuilder.Data)localObject2).mInfo instanceof MsgTabPlayInfo)) {
            bool2 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject2).mInfo).nodeUnionId);
          } else {
            bool2 = false;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701395));
          localObject1 = ((StringBuilder)localObject2).toString();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog = new CommentFloatDialog(b(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController, (String)localObject1, 4444, bool1, bool2);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.show();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.setOnDismissListener(new BottomVideoInfoWidget.2(this, localVideoViewVideoHolder));
          if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
          {
            localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
            if (bool2)
            {
              l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
              break label1148;
            }
          }
          l = 0L;
          label1148:
          if (bool1)
          {
            j = (int)l;
            if (bool4) {
              localObject1 = "2";
            } else {
              localObject1 = "1";
            }
            if (i == 0) {
              str = "1";
            }
            StoryReportor.a("play_video", "input_reply", j, 0, new String[] { localObject1, str, "", localStoryVideoItem.mVid });
          }
          else
          {
            j = (int)l;
            if (bool4) {
              localObject1 = "2";
            } else {
              localObject1 = "1";
            }
            if (i == 0) {
              str = "1";
            }
            StoryReportor.a("play_video", "clk_reply", j, 1, new String[] { localObject1, str, "", localStoryVideoItem.mVid });
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */