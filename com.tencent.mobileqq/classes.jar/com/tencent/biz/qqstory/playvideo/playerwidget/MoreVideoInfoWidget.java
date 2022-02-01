package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler;
import com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.MyContentStoryShareMode;
import com.tencent.biz.qqstory.newshare.ui.ShareUI;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader.FeedBaseGroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Subscriber;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoreVideoInfoWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private StorySingleFileDownloader jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader = new StorySingleFileDownloader();
  protected StoryShare a;
  private MoreVideoInfoWidget.MyActivityLifeCycle jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle;
  private MoreVideoInfoWidget.RenderResDownloadListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$RenderResDownloadListener;
  private final FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
  public ActionSheet a;
  private View b;
  
  public MoreVideoInfoWidget(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
  }
  
  private boolean a(StoryVideoItem paramStoryVideoItem)
  {
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if ((paramStoryVideoItem.mStoryType == 1) && (localQQUserUIItem != null) && (!localQQUserUIItem.isVip()) && (!localQQUserUIItem.isFriend())) {
      localQQUserUIItem.isMe();
    }
    int i;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isFriend())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isMe())) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip())) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (paramStoryVideoItem.mBanType == 1000) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (paramStoryVideoItem.mStoryType == 2) {
      n = 1;
    } else {
      n = 0;
    }
    int i1 = a().mUIStyle.bottomWidgetShowFlag;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((m != 0) || ((i != 0) && (paramStoryVideoItem.mBanType == 0)) || (j != 0) || (k != 0)) {
          break label237;
        }
        if (n != 0) {
          return true;
        }
        if ((i != 0) && (i1 == 3)) {
          return true;
        }
      }
      else
      {
        SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
      }
      return false;
    }
    else
    {
      SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
    }
    label237:
    return true;
  }
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new MoreVideoInfoWidget.7(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = DialogUtil.a(b(), 230, 2131558978, HardCodeUtil.a(2131706920), null, HardCodeUtil.a(2131706918), HardCodeUtil.a(2131706925), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return;
    }
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
    int i;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip())) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = PlayModeUtils.a(localStoryVideoItem);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(b(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131706917), 5);
    localActionSheet.addCancelButton(2131690728);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localActionSheet.setOnButtonClickListener(new MoreVideoInfoWidget.2(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localActionSheet));
    localActionSheet.setOnDismissListener(new MoreVideoInfoWidget.3(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    if (!localActionSheet.isShowing())
    {
      localActionSheet.show();
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).c(true);
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      int j = StoryReportor.a(localVideoListFeedItem);
      if (bool) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      StoryReportor.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(StoryReportor.a(localQQUserUIItem)), localStoryVideoItem.mVid });
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(b(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131706914), 5);
    localActionSheet.addCancelButton(2131690728);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localActionSheet.setOnButtonClickListener(new MoreVideoInfoWidget.4(this, localStoryVideoItem, localAtomicBoolean, localActionSheet));
    localActionSheet.setOnDismissListener(new MoreVideoInfoWidget.5(this, localAtomicBoolean, localVideoViewVideoHolder));
    if (!localActionSheet.isShowing())
    {
      localActionSheet.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
    }
  }
  
  protected StoryShare a(ShareUI paramShareUI)
  {
    if (paramShareUI == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(b());
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(b(), paramShareUI);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  }
  
  public String a()
  {
    return "MoreVideoInfoWidget";
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
    new MoreVideoInfoWidget.1(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().a()))
    {
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, HardCodeUtil.a(2131706924), 0).a();
      return;
    }
    QQToast.a(b(), HardCodeUtil.a(2131706921), 0).a();
    new ReportNoInterestingVideoHandler().a(paramStoryVideoItem.mVid);
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    localFeedVideoManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, 0, paramStoryVideoItem);
    localFeedVideoManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, 1, paramStoryVideoItem);
    paramStoryVideoItem = new ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent(new ErrorMessage(), paramStoryVideoItem.mVid);
    StoryDispatcher.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(ShareUI paramShareUI)
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
    QQUserUIItem localQQUserUIItem = ((UserManager)localObject2).b(localStoryVideoItem.mOwnerUid);
    boolean bool3;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if (localStoryVideoItem.mStoryType == 2) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool8 = PlayModeUtils.a(localStoryVideoItem);
    boolean bool5;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.relationType == 0)) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    int i;
    if (localStoryVideoItem.mBanType == 1000) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1;
    long l;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      localObject2 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
      bool1 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
      if (bool1) {
        l = ((MsgTabNodeInfo)localObject2).a(localStoryVideoItem.mVid);
      } else {
        l = 0L;
      }
    }
    else
    {
      l = 0L;
      bool1 = false;
    }
    Object localObject3;
    if ((localStoryVideoItem.mStoryType == 2) && (!TextUtils.isEmpty(b())))
    {
      localObject2 = ((ShareGroupManager)SuperManager.a(7)).a(b());
      if (localObject2 != null)
      {
        localObject3 = ((TroopManager)PlayModeUtils.a().getManager(QQManagerFactory.TROOP_MANAGER)).c(String.valueOf(((ShareGroupItem)localObject2).groupUin));
        localObject4 = PlayModeUtils.a().getCurrentAccountUin();
        if ((localObject3 != null) && ((((TroopInfo)localObject3).isTroopAdmin((String)localObject4)) || (((TroopInfo)localObject3).isTroopOwner((String)localObject4)))) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        bool6 = ((ShareGroupItem)localObject2).isOwner();
        break label363;
      }
    }
    boolean bool6 = false;
    boolean bool2 = false;
    label363:
    Object localObject4 = ((StoryPlayerGroupHolder)a()).a();
    int j;
    if (bool4)
    {
      j = c();
      if (localObject1 != null) {
        localObject2 = ((VideoListFeedItem)localObject1).feedId;
      } else {
        localObject2 = "";
      }
      StoryReportor.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject2 });
    }
    boolean bool7;
    for (;;)
    {
      bool7 = bool1;
      localObject3 = localObject1;
      break;
      if (bool3) {
        j = 1;
      } else {
        j = 2;
      }
      int k = StoryReportor.a((FeedItem)localObject1);
      if (bool8) {
        localObject2 = "2";
      } else {
        localObject2 = "1";
      }
      StoryReportor.a("play_video", "clk_more_play", j, k, new String[] { localObject2, String.valueOf(StoryReportor.a(localQQUserUIItem)), localStoryVideoItem.mVid });
    }
    if (localObject4 != null) {
      ((VideoViewVideoHolder)localObject4).c(true);
    }
    new MoreVideoInfoWidget.6(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject4);
    localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (localObject3 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((VideoListFeedItem)localObject3).feedId;
    }
    if (c() == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool9 = a().mUIStyle.showVideoNoInteresting;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
      ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId))
    {
      localObject1 = (FeedIdBasePlayPageLoader.FeedBaseGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
      if (((FeedIdBasePlayPageLoader.FeedBaseGroupId)localObject1).a != null)
      {
        localObject1 = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)localObject1).a.jdField_a_of_type_JavaLangString;
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a((String)localObject1, true);
        if (!(localObject1 instanceof GeneralRecommendFeedItem)) {
          bool9 = localObject1 instanceof TagFeedItem;
        }
      }
    }
    SLog.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool8), Boolean.valueOf(bool5), Boolean.valueOf(bool1), localStoryVideoItem.mVid, Boolean.valueOf(bool6), Boolean.valueOf(bool2) });
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().isGameVideo()) {
      StoryReportor.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
    }
    if (bool4)
    {
      if ((!bool6) && (!bool8))
      {
        if (bool2) {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9, 8 } });
        } else {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9 } });
        }
      }
      else {
        localObject1 = Arrays.asList(new int[][] { { 10, 7, 8 } });
      }
      a(paramShareUI).a((List)localObject1).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if (bool8)
    {
      a(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131719029).a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if (bool5)
    {
      a(paramShareUI).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if ((bool3) || (i != 0)) {
      a(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131719029).a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
    }
  }
  
  public void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "bindData=%s", paramStoryPlayerVideoData);
    j();
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new MoreVideoInfoWidget.StoryVideoDeleteReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.GetFeedFeatureReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.GenShareThumbReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.GetFeedItemReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.DownloadStatusUpdateReceiver(this), "");
    paramMap.put(new MoreVideoInfoWidget.GetUserInfoReceiver(this), "");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle = new MoreVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle);
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideMoreIcon) && ((paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo == null) || (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a != 13));
  }
  
  public int b()
  {
    return -1;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new MoreVideoInfoWidget.8(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localFeedVideoManager);
    localObject = DialogUtil.a(b(), 230, 2131558978, HardCodeUtil.a(2131706911), null, HardCodeUtil.a(2131706916), HardCodeUtil.a(2131706923), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  protected void f() {}
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader;
    if (localObject != null) {
      ((StorySingleFileDownloader)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null)
    {
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      int i = 0;
      if (localStoryVideoItem == null)
      {
        SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      }
      else
      {
        if (localStoryVideoItem.mStoryType == 2) {
          i = 1;
        }
        boolean bool = a(localStoryVideoItem);
        if (i != 0) {
          a(null);
        } else if (PlayModeUtils.a(localStoryVideoItem))
        {
          if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploading())) {
            a(null);
          } else {
            e();
          }
        }
        else if (bool) {
          a(null);
        } else {
          d();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */