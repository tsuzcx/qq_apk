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
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
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
    int i;
    int j;
    label83:
    int k;
    label99:
    int m;
    label112:
    int n;
    label123:
    int i1;
    if (((paramStoryVideoItem.mStoryType != 1) || (localQQUserUIItem == null) || (localQQUserUIItem.isVip()) || (localQQUserUIItem.isFriend()) || (localQQUserUIItem.isMe())) || ((localQQUserUIItem != null) && (localQQUserUIItem.isFriend())))
    {
      i = 1;
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isMe())) {
        break label197;
      }
      j = 1;
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break label202;
      }
      k = 1;
      if (paramStoryVideoItem.mBanType != 1000) {
        break label208;
      }
      m = 1;
      if (paramStoryVideoItem.mStoryType != 2) {
        break label214;
      }
      n = 1;
      i1 = a().mUIStyle.bottomWidgetShowFlag;
      switch (i1)
      {
      default: 
        if ((m == 0) && ((i == 0) || (paramStoryVideoItem.mBanType != 0)) && (j == 0) && (k == 0) && (n == 0)) {
          break;
        }
      }
    }
    label197:
    label202:
    label208:
    label214:
    while ((i != 0) && (i1 == 3))
    {
      return true;
      i = 0;
      break;
      j = 0;
      break label83;
      k = 0;
      break label99;
      m = 0;
      break label112;
      n = 0;
      break label123;
      SLog.d(this.jdField_b_of_type_JavaLangString, "show BottomWidget because flag 1");
      return true;
      SLog.d(this.jdField_b_of_type_JavaLangString, "hide BottomWidget because flag 2");
      return false;
    }
    return false;
  }
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new MoreVideoInfoWidget.7(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = DialogUtil.a(b(), 230, 2131559084, HardCodeUtil.a(2131706898), null, HardCodeUtil.a(2131706896), HardCodeUtil.a(2131706903), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {}
    VideoListFeedItem localVideoListFeedItem;
    StoryVideoItem localStoryVideoItem;
    QQUserUIItem localQQUserUIItem;
    int i;
    boolean bool;
    ActionSheet localActionSheet;
    do
    {
      return;
      localObject = ((StoryPlayerGroupHolder)a()).a();
      localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
        break;
      }
      i = 1;
      bool = PlayModeUtils.a(localStoryVideoItem);
      localActionSheet = (ActionSheet)ActionSheetHelper.b(b(), null);
      localActionSheet.addButton(HardCodeUtil.a(2131706895), 5);
      localActionSheet.addCancelButton(2131690800);
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localActionSheet.setOnButtonClickListener(new MoreVideoInfoWidget.2(this, localStoryVideoItem, (VideoViewVideoHolder)localObject, localAtomicBoolean, localActionSheet));
      localActionSheet.setOnDismissListener(new MoreVideoInfoWidget.3(this, localAtomicBoolean, (VideoViewVideoHolder)localObject));
    } while (localActionSheet.isShowing());
    localActionSheet.show();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    label185:
    int j;
    if (i != 0)
    {
      i = 1;
      j = StoryReportor.a(localVideoListFeedItem);
      if (!bool) {
        break label247;
      }
    }
    label247:
    for (Object localObject = "2";; localObject = "1")
    {
      StoryReportor.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(StoryReportor.a(localQQUserUIItem)), localStoryVideoItem.mVid });
      return;
      i = 0;
      break;
      i = 2;
      break label185;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {}
    VideoViewVideoHolder localVideoViewVideoHolder;
    do
    {
      ActionSheet localActionSheet;
      do
      {
        return;
        localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
        localActionSheet = (ActionSheet)ActionSheetHelper.b(b(), null);
        localActionSheet.addButton(HardCodeUtil.a(2131706892), 5);
        localActionSheet.addCancelButton(2131690800);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        localActionSheet.setOnButtonClickListener(new MoreVideoInfoWidget.4(this, localStoryVideoItem, localAtomicBoolean, localActionSheet));
        localActionSheet.setOnDismissListener(new MoreVideoInfoWidget.5(this, localAtomicBoolean, localVideoViewVideoHolder));
      } while (localActionSheet.isShowing());
      localActionSheet.show();
    } while (localVideoViewVideoHolder == null);
    localVideoViewVideoHolder.c(true);
  }
  
  protected StoryShare a(ShareUI paramShareUI)
  {
    if (paramShareUI == null) {}
    for (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(b());; this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(b(), paramShareUI)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
    }
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
      QQToast.a(BaseApplicationImpl.getApplication().getApplicationContext(), 1, HardCodeUtil.a(2131706902), 0).a();
      return;
    }
    QQToast.a(b(), HardCodeUtil.a(2131706899), 0).a();
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
    Object localObject1 = (UserManager)SuperManager.a(2);
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    if (localStoryVideoItem == null)
    {
      SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return;
    }
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(localStoryVideoItem.mOwnerUid);
    boolean bool2;
    boolean bool3;
    label105:
    boolean bool8;
    boolean bool4;
    label128:
    int i;
    label141:
    boolean bool5;
    long l1;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    label325:
    boolean bool7;
    boolean bool6;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      bool2 = true;
      if (localStoryVideoItem.mStoryType != 2) {
        break label835;
      }
      bool3 = true;
      bool8 = PlayModeUtils.a(localStoryVideoItem);
      if ((localQQUserUIItem == null) || (localQQUserUIItem.relationType != 0)) {
        break label841;
      }
      bool4 = true;
      if (localStoryVideoItem.mBanType != 1000) {
        break label847;
      }
      i = 1;
      long l2 = 0L;
      bool5 = false;
      l1 = l2;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
      {
        localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
        bool1 = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
        bool5 = bool1;
        l1 = l2;
        if (bool1)
        {
          l1 = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
          bool5 = bool1;
        }
      }
      if ((localStoryVideoItem.mStoryType != 2) || (TextUtils.isEmpty(b()))) {
        break label1378;
      }
      localObject1 = ((ShareGroupManager)SuperManager.a(7)).a(b());
      if (localObject1 == null) {
        break label1378;
      }
      localObject2 = ((TroopManager)PlayModeUtils.a().getManager(QQManagerFactory.TROOP_MANAGER)).c(String.valueOf(((ShareGroupItem)localObject1).groupUin));
      localObject3 = PlayModeUtils.a().getCurrentAccountUin();
      if ((localObject2 == null) || ((!((TroopInfo)localObject2).isTroopAdmin((String)localObject3)) && (!((TroopInfo)localObject2).isTroopOwner((String)localObject3)))) {
        break label852;
      }
      bool1 = true;
      bool7 = ((ShareGroupItem)localObject1).isOwner();
      bool6 = bool1;
      bool1 = bool7;
    }
    for (;;)
    {
      localObject3 = ((StoryPlayerGroupHolder)a()).a();
      int j;
      if (bool3)
      {
        j = c();
        if (localVideoListFeedItem != null)
        {
          localObject1 = localVideoListFeedItem.feedId;
          label374:
          StoryReportor.a("story_grp", "video_more", j, 0, new String[] { "", "", "", localObject1 });
          if (localObject3 != null) {
            ((VideoViewVideoHolder)localObject3).c(true);
          }
          new MoreVideoInfoWidget.6(this, new Boolean[] { Boolean.valueOf(false) }, (VideoViewVideoHolder)localObject3);
          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
          if (localVideoListFeedItem != null) {
            break label941;
          }
          localObject2 = null;
          label474:
          if (c() != 12) {
            break label951;
          }
          bool7 = true;
          label486:
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
              if (((localObject1 instanceof GeneralRecommendFeedItem)) || (!(localObject1 instanceof TagFeedItem))) {}
            }
          }
          SLog.d(this.jdField_b_of_type_JavaLangString, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool7), localStoryVideoItem.mVid, Boolean.valueOf(bool1), Boolean.valueOf(bool6) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().isGameVideo()) {
            StoryReportor.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().getVideoGameInfo().jdField_a_of_type_JavaLangString });
          }
          if (!bool3) {
            break label1033;
          }
          if ((!bool1) && (!bool8)) {
            break label957;
          }
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 8 } });
        }
      }
      for (;;)
      {
        a(paramShareUI).a((List)localObject1).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool7, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
        bool2 = false;
        break;
        label835:
        bool3 = false;
        break label105;
        label841:
        bool4 = false;
        break label128;
        label847:
        i = 0;
        break label141;
        label852:
        bool1 = false;
        break label325;
        localObject1 = "";
        break label374;
        label872:
        int k;
        if (bool2)
        {
          j = 1;
          k = StoryReportor.a(localVideoListFeedItem);
          if (!bool8) {
            break label934;
          }
        }
        label934:
        for (localObject1 = "2";; localObject1 = "1")
        {
          StoryReportor.a("play_video", "clk_more_play", j, k, new String[] { localObject1, String.valueOf(StoryReportor.a(localQQUserUIItem)), localStoryVideoItem.mVid });
          break;
          j = 2;
          break label872;
        }
        label941:
        localObject2 = localVideoListFeedItem.feedId;
        break label474;
        label951:
        bool7 = false;
        break label486;
        label957:
        if (bool6) {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9, 8 } });
        } else {
          localObject1 = Arrays.asList(new int[][] { { 10, 7, 9 } });
        }
      }
      label1033:
      if (bool8)
      {
        a(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131719311).a(new MyContentStoryShareMode(localStoryVideoItem, bool7, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if (bool4)
      {
        a(paramShareUI).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool7, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
        return;
      }
      if ((!bool2) && (i == 0)) {
        break;
      }
      a(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131719311).a(new MyContentStoryShareMode(localStoryVideoItem, bool7, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool7, localVideoListFeedItem, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject3, bool2, localQQUserUIItem, bool5, l1)).b();
      return;
      label1378:
      bool1 = false;
      bool6 = false;
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
    localObject = DialogUtil.a(b(), 230, 2131559084, HardCodeUtil.a(2131706889), null, HardCodeUtil.a(2131706894), HardCodeUtil.a(2131706901), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  protected void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle != null) {
      b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget$MyActivityLifeCycle);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
      if (localStoryVideoItem == null)
      {
        SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found , vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      }
      else
      {
        if (localStoryVideoItem.mStoryType == 2) {}
        boolean bool;
        for (;;)
        {
          bool = a(localStoryVideoItem);
          if (i == 0) {
            break label91;
          }
          a(null);
          break;
          i = 0;
        }
        label91:
        if (PlayModeUtils.a(localStoryVideoItem))
        {
          if ((localStoryVideoItem.isUploadFail()) || (localStoryVideoItem.isUploading())) {
            e();
          } else {
            a(null);
          }
        }
        else if (bool) {
          a(null);
        } else {
          d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */