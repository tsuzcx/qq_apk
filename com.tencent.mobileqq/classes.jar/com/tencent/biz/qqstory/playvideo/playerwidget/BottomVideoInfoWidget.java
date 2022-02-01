package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
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
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo)
  {
    paramActivity = paramActivity.getIntent();
    paramActivity.putExtra("is_video_forward", true);
    paramActivity.putExtra("vip_forward_feedid", paramString1);
    paramActivity.putExtra("vip_forward_vid", paramString2);
    paramActivity.putExtra("vip_forward_uid", paramString3);
    paramActivity.putExtra("vip_forward_name", paramString4);
    paramActivity.putExtra("vip_forward_avatrname", paramString5);
  }
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846919);
    }
    while (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(UIUtils.a(paramVideoListFeedItem.mLikeCount));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847232);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701259));
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701262));
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
      localQQCustomDialog.setTitle(HardCodeUtil.a(2131701260)).setMessage(HardCodeUtil.a(2131701253)).setPositiveButton(HardCodeUtil.a(2131701261), new BottomVideoInfoWidget.5(this)).setOnDismissListener(new BottomVideoInfoWidget.4(this, localVideoViewVideoHolder));
      localQQCustomDialog.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localStoryConfigManager.b("first_clk_forward", Boolean.valueOf(false));
      StoryReportor.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    for (;;)
    {
      StoryReportor.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return;
      e();
    }
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
    VideoViewVideoHolder localVideoViewVideoHolder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      if ((TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) || (!new File(localStoryVideoItem.mLocalVideoPath).exists())) {
        break label171;
      }
      a(localStoryVideoItem.mLocalVideoPath, ((QQUserUIItem)localObject2).uid, (String)localObject1, localStoryVideoItem.mVid, ((QQUserUIItem)localObject2).nickName, ((QQUserUIItem)localObject2).headUrl);
    }
    for (;;)
    {
      StoryReportor.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
      return;
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
      break;
      label171:
      a(b().getString(2131720497), true);
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader.a(localStoryVideoItem.mVid, 0, true, new BottomVideoInfoWidget.6(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      ThreadManager.getUIHandlerV2().postDelayed(new BottomVideoInfoWidget.7(this, localVideoViewVideoHolder, localStoryVideoItem), 15000L);
    }
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381998);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381999);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131370359);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131370364));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370362));
    this.e = paramView.findViewById(2131365027);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365061));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageView = ((PressDarkImageView)paramView.findViewById(2131365072));
    this.e.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131377936);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramStoryPlayerVideoData);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(paramStoryPlayerVideoData.jdField_b_of_type_JavaLangString, true);
    Object localObject;
    boolean bool1;
    boolean bool2;
    if ((!paramStoryVideoItem.isUploadSuc()) || (localVideoListFeedItem == null))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      if (!paramStoryVideoItem.isUploadSuc())
      {
        bool1 = true;
        if (localVideoListFeedItem != null) {
          break label110;
        }
      }
      label110:
      for (bool2 = true;; bool2 = false)
      {
        SLog.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramStoryPlayerVideoData.jdField_b_of_type_JavaLangString });
        k();
        return;
        bool1 = false;
        break;
      }
    }
    label135:
    int i;
    label237:
    label253:
    boolean bool3;
    label269:
    boolean bool4;
    label282:
    boolean bool5;
    label293:
    label435:
    label469:
    label496:
    int j;
    label512:
    int k;
    if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
    {
      this.jdField_f_of_type_Boolean = false;
      localObject = ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
      i = a().mUIStyle.bottomWidgetShowFlag;
      switch (i)
      {
      default: 
        if (((paramStoryVideoItem.mStoryType != 1) || (localObject == null) || (((QQUserUIItem)localObject).isVip()) || (((QQUserUIItem)localObject).isFriend()) || (((QQUserUIItem)localObject).isMe())) || ((localObject != null) && (((QQUserUIItem)localObject).isFriend())))
        {
          bool1 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label663;
          }
          bool2 = true;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label669;
          }
          bool3 = true;
          if (paramStoryVideoItem.mBanType != 1000) {
            break label675;
          }
          bool4 = true;
          if (paramStoryVideoItem.mStoryType != 2) {
            break label681;
          }
          bool5 = true;
          SLog.d(this.jdField_b_of_type_JavaLangString, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(a().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5)) {
            break label687;
          }
          i = 1;
          SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget");
          if (i == 0) {
            break label780;
          }
          j();
          if (FontSettingManager.getFontLevel() <= 16.0F) {
            break label727;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          a(localVideoListFeedItem);
          b(localVideoListFeedItem);
          if ((localObject == null) || (!((QQUserUIItem)localObject).isFriend())) {
            break label747;
          }
          i = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isMe())) {
            break label752;
          }
          j = 1;
          if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
            break label758;
          }
          k = 1;
          label528:
          if (paramStoryVideoItem.mStoryType != 2) {
            break label764;
          }
        }
        break;
      }
    }
    label663:
    label669:
    label675:
    label681:
    label687:
    label727:
    label747:
    label752:
    label758:
    label764:
    for (int m = 1;; m = 0)
    {
      if ((m != 0) || (j != 0) || (i != 0) || (k == 0)) {
        break label770;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_f_of_type_Boolean) {
        break;
      }
      StoryReportor.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_f_of_type_Boolean = true;
      this.jdField_c_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      break label135;
      i = 1;
      SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      break label435;
      i = 0;
      SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
      break label435;
      bool1 = false;
      break label237;
      bool2 = false;
      break label253;
      bool3 = false;
      break label269;
      bool4 = false;
      break label282;
      bool5 = false;
      break label293;
      if ((bool1) && (i == 3))
      {
        i = 1;
        SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because friend and showBottomWidgetFlag=3");
        break label435;
      }
      i = 0;
      SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget");
      break label435;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label469;
      i = 0;
      break label496;
      j = 0;
      break label512;
      k = 0;
      break label528;
    }
    label770:
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    return;
    label780:
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
    if (localVideoListFeedItem != null) {
      if (paramBoolean)
      {
        if (localVideoListFeedItem.mFriendCommentCount == -1) {
          break label217;
        }
        localVideoListFeedItem.mFriendCommentCount += 1;
        if (localVideoListFeedItem.mCommentCount == -1) {
          break label225;
        }
      }
    }
    label217:
    label225:
    for (localVideoListFeedItem.mCommentCount += 1;; localVideoListFeedItem.mCommentCount = 1)
    {
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
      Object localObject1 = new FeedInfoChangeEvent(1, paramCommentEntry.feedId, 1);
      ((FeedInfoChangeEvent)localObject1).c = paramCommentEntry.commentId;
      ((FeedInfoChangeEvent)localObject1).a = localVideoListFeedItem;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
      localVideoListFeedItem.mFriendCommentCount = 1;
      break;
    }
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo == null) || (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a != 13);
  }
  
  public int b()
  {
    return 2131561872;
  }
  
  public boolean d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {}
    label72:
    label345:
    label348:
    label352:
    for (;;)
    {
      return false;
      Object localObject = (UserManager)SuperManager.a(2);
      StoryPlayerVideoData localStoryPlayerVideoData = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
      StoryVideoItem localStoryVideoItem = localStoryPlayerVideoData.a();
      VideoListFeedItem localVideoListFeedItem = localStoryPlayerVideoData.a();
      int i;
      boolean bool;
      if (localStoryVideoItem != null)
      {
        localObject = ((UserManager)localObject).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label309;
        }
        i = 1;
        if (((localObject != null) && (((QQUserUIItem)localObject).isMe())) && ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId == null) || (!(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)))) {
          break label348;
        }
        localObject = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
        bool = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
        if ((!bool) || (localObject == null)) {
          break label345;
        }
        if (localStoryVideoItem == null) {
          break label314;
        }
        l = ((MsgTabNodeInfo)localObject).a(localStoryVideoItem.mVid);
      }
      for (;;)
      {
        if ((!c()) || (this.d.getVisibility() != 0)) {
          break label352;
        }
        if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mHadLike != 1))
        {
          this.d.setTag(Boolean.valueOf(true));
          onClick(this.d);
        }
        localObject = a();
        if ((((OpenPlayerBuilder.Data)localObject).mInfo instanceof MsgTabPlayInfo)) {}
        for (localObject = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject).mInfo).nodeUnionId;; localObject = null)
        {
          label247:
          int j;
          if (i != 0)
          {
            i = 1;
            j = c();
            if (!bool) {
              break label324;
            }
          }
          for (localObject = String.valueOf(l);; localObject = String.valueOf(StoryReportor.a((String)localObject, localVideoListFeedItem)))
          {
            StoryReportor.a("play_video", "dbl_like", i, j, new String[] { "", localObject, "", localStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
            return true;
            localObject = null;
            break;
            i = 0;
            break label72;
            l = 0L;
            break label161;
            i = 2;
            break label247;
          }
        }
        continue;
        bool = false;
      }
    }
  }
  
  protected void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle != null) {
      b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget$MyActivityLifeCycle);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {}
    Object localObject1;
    StoryVideoItem localStoryVideoItem;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = (UserManager)SuperManager.a(2);
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      if (localStoryVideoItem != null) {
        break;
      }
      SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(localStoryVideoItem.mOwnerUid);
    int i;
    label101:
    boolean bool5;
    boolean bool2;
    long l;
    boolean bool1;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      i = 1;
      bool5 = PlayModeUtils.a(localStoryVideoItem);
      bool2 = false;
      l = 0L;
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
        break label1279;
      }
      localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      bool1 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
      if (!bool1) {
        break label1276;
      }
      l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
    }
    for (;;)
    {
      label277:
      Object localObject2;
      label352:
      int j;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365027: 
      case 2131381998: 
      case 2131381999: 
        for (;;)
        {
          if ((localObject3 == null) || (((VideoListFeedItem)localObject3).mDenyComment != 1)) {
            break label277;
          }
          QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131701257), 0).a();
          break;
          i = 0;
          break label101;
          bool2 = true;
        }
        localObject2 = ((StoryPlayerGroupHolder)a()).a();
        if (localObject2 != null) {
          ((VideoViewVideoHolder)localObject2).c(true);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = new CommentFloatDialogController();
        }
        localObject1 = HardCodeUtil.a(2131701258);
        if ((localObject3 != null) && (((VideoListFeedItem)localObject3).type == 2)) {
          localObject1 = ((VideoListFeedItem)localObject3).getOwner().getName();
        }
        while (localQQUserUIItem == null)
        {
          bool1 = false;
          localObject3 = a();
          if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
            bool1 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId);
          }
          localObject1 = (String)localObject1 + HardCodeUtil.a(2131701255);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog = new CommentFloatDialog(b(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController, (String)localObject1, 4444, bool2, bool1);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.show();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.setOnDismissListener(new BottomVideoInfoWidget.2(this, (VideoViewVideoHolder)localObject2));
          if (!(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
            break label1261;
          }
          localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
          if (!bool1) {
            break label1261;
          }
          l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
          if (!bool2) {
            break label727;
          }
          j = (int)l;
          if (!bool5) {
            break label711;
          }
          localObject1 = "2";
          if (i == 0) {
            break label719;
          }
          localObject2 = "2";
          StoryReportor.a("play_video", "input_reply", j, 0, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
          break;
        }
        if (localStoryVideoItem.mStoryType == 2)
        {
          localObject1 = localStoryVideoItem.mGroupId;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject3 != null) && (((VideoListFeedItem)localObject3).getOwner() != null) && ((((VideoListFeedItem)localObject3).getOwner() instanceof QQUserUIItem))) {
            localObject1 = ((QQUserUIItem)((VideoListFeedItem)localObject3).getOwner()).qq;
          }
        }
      case 2131370359: 
      case 2131377936: 
        for (;;)
        {
          label518:
          label537:
          label546:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((TroopNickNameManager)SuperManager.a(23)).a(localQQUserUIItem, (String)localObject1, false, true);
            break label352;
          }
          if (localQQUserUIItem.isVipButNoFriend())
          {
            localObject1 = localQQUserUIItem.nickName;
            break label352;
          }
          localObject1 = localQQUserUIItem.getDisplayName();
          break label352;
          label711:
          localObject1 = "1";
          break label537;
          label719:
          localObject2 = "1";
          break label546;
          label727:
          j = (int)l;
          if (bool5)
          {
            localObject1 = "2";
            label741:
            if (i == 0) {
              break label799;
            }
          }
          label799:
          for (localObject2 = "2";; localObject2 = "1")
          {
            StoryReportor.a("play_video", "clk_reply", j, 1, new String[] { localObject1, localObject2, "", localStoryVideoItem.mVid });
            break;
            localObject1 = "1";
            break label741;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
          {
            bool2 = ((Boolean)localObject1).booleanValue();
            paramView.setTag(null);
          }
          for (;;)
          {
            if (localObject3 != null)
            {
              localObject1 = new LikeEntry();
              ((LikeEntry)localObject1).likeTime = System.currentTimeMillis();
              ((LikeEntry)localObject1).uin = QQStoryContext.a().a();
              ((LikeEntry)localObject1).unionId = QQStoryContext.a().b();
              ((LikeEntry)localObject1).feedId = ((VideoListFeedItem)localObject3).feedId;
              boolean bool3;
              label907:
              label930:
              boolean bool4;
              label938:
              int k;
              if (((VideoListFeedItem)localObject3).mHadLike == 1)
              {
                bool3 = true;
                if (!bool3) {
                  break label1128;
                }
                ((VideoListFeedItem)localObject3).mHadLike = 0;
                ((VideoListFeedItem)localObject3).mLikeCount -= 1;
                if (bool3) {
                  break label1149;
                }
                bool4 = true;
                k = ((VideoListFeedItem)localObject3).getCommentLikeType();
                if (c() != 106) {
                  break label1155;
                }
                j = 106;
                label957:
                FeedLikeDataProvider.a((CommentLikeFeedItem)localObject3, bool4, k, j);
                i();
                ThreadManager.post(new BottomVideoInfoWidget.3(this, bool3, (LikeEntry)localObject1, (VideoListFeedItem)localObject3), 5, null, false);
                if (bool2) {
                  break;
                }
                localObject2 = null;
                localObject1 = a();
                if ((((OpenPlayerBuilder.Data)localObject1).mInfo instanceof MsgTabPlayInfo)) {
                  localObject2 = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject1).mInfo).nodeUnionId;
                }
                if (!bool3) {
                  break label1160;
                }
                localObject1 = "unlike";
                label1039:
                if (!bool1) {
                  break label1168;
                }
                j = (int)l;
                label1048:
                k = c();
                if (i == 0) {
                  break label1179;
                }
                localObject2 = "2";
                label1063:
                if (!bool5) {
                  break label1187;
                }
              }
              label1155:
              label1160:
              label1168:
              label1179:
              label1187:
              for (localObject3 = "2";; localObject3 = "1")
              {
                StoryReportor.a("play_video", (String)localObject1, j, k, new String[] { localObject2, localObject3, String.valueOf(localStoryVideoItem.mOwnerUid), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
                break;
                bool3 = false;
                break label907;
                label1128:
                ((VideoListFeedItem)localObject3).mHadLike = 1;
                ((VideoListFeedItem)localObject3).mLikeCount += 1;
                break label930;
                label1149:
                bool4 = false;
                break label938;
                j = 0;
                break label957;
                localObject1 = "like";
                break label1039;
                j = StoryReportor.a((String)localObject2, (VideoListFeedItem)localObject3);
                break label1048;
                localObject2 = "1";
                break label1063;
              }
            }
            if ((localStoryVideoItem.mHasLike == -1) || (localStoryVideoItem.mHasLike == 0))
            {
              this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130846919);
              localStoryVideoItem.mHasLike = 1;
              break;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageView.setImageResource(2130847232);
            localStoryVideoItem.mHasLike = 0;
            break;
            d();
            break;
            bool2 = false;
          }
          label1261:
          l = 0L;
          break label518;
          continue;
          localObject1 = null;
        }
        label1276:
        continue;
        label1279:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */