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
  protected StoryShare s;
  public ActionSheet t;
  private final FeedManager u;
  private View v;
  private MoreVideoInfoWidget.MyActivityLifeCycle w;
  private StorySingleFileDownloader x = new StorySingleFileDownloader();
  private MoreVideoInfoWidget.RenderResDownloadListener y;
  
  public MoreVideoInfoWidget(View paramView)
  {
    super(paramView);
    this.v = paramView;
    this.u = ((FeedManager)SuperManager.a(11));
  }
  
  private boolean d(StoryVideoItem paramStoryVideoItem)
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
    int i1 = i().mUIStyle.bottomWidgetShowFlag;
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
        SLog.d(this.i, "hide BottomWidget because flag 2");
      }
      return false;
    }
    else
    {
      SLog.d(this.i, "show BottomWidget because flag 1");
    }
    label237:
    return true;
  }
  
  private void e(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)d()).r();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new MoreVideoInfoWidget.7(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem);
    localObject = DialogUtil.a(y(), 230, 2131624611, HardCodeUtil.a(2131904763), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131904768), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "2", "", paramStoryVideoItem.mVid });
  }
  
  private void h()
  {
    if (this.p == null) {
      return;
    }
    Object localObject = ((StoryPlayerGroupHolder)d()).r();
    VideoListFeedItem localVideoListFeedItem = this.p.f();
    StoryVideoItem localStoryVideoItem = this.p.e();
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
    int i;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip())) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = PlayModeUtils.a(localStoryVideoItem);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c(y(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131904761), 5);
    localActionSheet.addCancelButton(2131887648);
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
  
  private void p()
  {
    if (this.p == null) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
    StoryVideoItem localStoryVideoItem = this.p.e();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c(y(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131904759), 5);
    localActionSheet.addCancelButton(2131887648);
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
  
  public void a(View paramView)
  {
    new MoreVideoInfoWidget.1(this);
    this.v.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (this.p == null) {
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().c()))
    {
      QQToast.makeText(BaseApplicationImpl.getApplication().getApplicationContext(), 1, HardCodeUtil.a(2131904767), 0).show();
      return;
    }
    QQToast.makeText(y(), HardCodeUtil.a(2131904764), 0).show();
    new ReportNoInterestingVideoHandler().a(paramStoryVideoItem.mVid);
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    localFeedVideoManager.a(this.p.c, 0, paramStoryVideoItem);
    localFeedVideoManager.a(this.p.c, 1, paramStoryVideoItem);
    paramStoryVideoItem = new ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent(new ErrorMessage(), paramStoryVideoItem.mVid);
    StoryDispatcher.a().dispatch(paramStoryVideoItem);
  }
  
  public void a(ShareUI paramShareUI)
  {
    if (this.p == null) {
      return;
    }
    Object localObject2 = (UserManager)SuperManager.a(2);
    StoryVideoItem localStoryVideoItem = this.p.e();
    if (localStoryVideoItem == null)
    {
      SLog.e(this.i, "click error , video info not found , vid :%s", new Object[] { this.p.b });
      return;
    }
    Object localObject1 = this.p.f();
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
    if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      localObject2 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
      bool1 = MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a());
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
    if ((localStoryVideoItem.mStoryType == 2) && (!TextUtils.isEmpty(D())))
    {
      localObject2 = ((ShareGroupManager)SuperManager.a(7)).a(D());
      if (localObject2 != null)
      {
        localObject3 = ((TroopManager)PlayModeUtils.b().getManager(QQManagerFactory.TROOP_MANAGER)).g(String.valueOf(((ShareGroupItem)localObject2).groupUin));
        localObject4 = PlayModeUtils.b().getCurrentAccountUin();
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
    Object localObject4 = ((StoryPlayerGroupHolder)d()).r();
    int j;
    if (bool4)
    {
      j = C();
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
    localObject1 = this.t;
    if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
      this.t.dismiss();
    }
    if (localObject3 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((VideoListFeedItem)localObject3).feedId;
    }
    if (C() == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool9 = i().mUIStyle.showVideoNoInteresting;
    if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
      ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).b();
    }
    if ((this.e instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId))
    {
      localObject1 = (FeedIdBasePlayPageLoader.FeedBaseGroupId)this.e;
      if (((FeedIdBasePlayPageLoader.FeedBaseGroupId)localObject1).a != null)
      {
        localObject1 = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)localObject1).a.a;
        localObject1 = this.u.a((String)localObject1, true);
        if (!(localObject1 instanceof GeneralRecommendFeedItem)) {
          bool9 = localObject1 instanceof TagFeedItem;
        }
      }
    }
    SLog.d(this.i, "onShareMoreClick, vip=%s, troop=%s, mine=%s, friend=%s, memory=%s, vid=%s, isShareGroupOwner=%s, isTroopManager=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool8), Boolean.valueOf(bool5), Boolean.valueOf(bool1), localStoryVideoItem.mVid, Boolean.valueOf(bool6), Boolean.valueOf(bool2) });
    if (this.p.e().isGameVideo()) {
      StoryReportor.a("video_game", "clk_challenge", 0, 0, new String[] { "", "", this.p.e().getVideoGameInfo().b });
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
      b(paramShareUI).a((List)localObject1).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if (bool8)
    {
      b(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } })).a(2131916565).a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if (bool5)
    {
      b(paramShareUI).a(Arrays.asList(new int[][] { { 10, 7, 9 } })).a().a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
      return;
    }
    if ((bool3) || (i != 0)) {
      b(paramShareUI).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 9 } })).a(2131916565).a(new MyContentStoryShareMode(localStoryVideoItem, bool1, (String)localObject2)).a(new MoreVideoInfoWidget.OnSimpleShareListenerImpl(this, bool1, (VideoListFeedItem)localObject3, (String)localObject2, localStoryVideoItem, bool8, (VideoViewVideoHolder)localObject4, bool3, localQQUserUIItem, bool7, l)).b();
    }
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
    this.w = new MoreVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.w);
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!i().mUIStyle.hideMoreIcon) && ((paramStoryPlayerVideoData.a == null) || (paramStoryPlayerVideoData.a.b != 13));
  }
  
  protected StoryShare b(ShareUI paramShareUI)
  {
    if (paramShareUI == null) {
      this.s = StoryShare.a(y());
    } else {
      this.s = StoryShare.a(y(), paramShareUI);
    }
    return this.s;
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = ((StoryPlayerGroupHolder)d()).r();
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).c(true);
    }
    localObject = new MoreVideoInfoWidget.8(this, (VideoViewVideoHolder)localObject, paramStoryVideoItem, localFeedVideoManager);
    localObject = DialogUtil.a(y(), 230, 2131624611, HardCodeUtil.a(2131904756), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131904766), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((QQCustomDialog)localObject).show();
    StoryReportor.a("play_video", "exp_del", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    StoryReportor.a("play_video", "clk_delete", 0, 0, new String[] { "", "1", "", paramStoryVideoItem.mVid });
  }
  
  public void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.i, "bindData=%s", paramStoryPlayerVideoData);
    z();
  }
  
  public String c(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail()) {
      return "3";
    }
    if (paramStoryVideoItem.isUploading()) {
      return "1";
    }
    return "2";
  }
  
  public void onClick(View paramView)
  {
    if (this.p != null)
    {
      StoryVideoItem localStoryVideoItem = this.p.e();
      int i = 0;
      if (localStoryVideoItem == null)
      {
        SLog.e(this.i, "click error , video info not found , vid :%s", new Object[] { this.p.b });
      }
      else
      {
        if (localStoryVideoItem.mStoryType == 2) {
          i = 1;
        }
        boolean bool = d(localStoryVideoItem);
        if (i != 0) {
          a(null);
        } else if (PlayModeUtils.a(localStoryVideoItem))
        {
          if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploading())) {
            a(null);
          } else {
            p();
          }
        }
        else if (bool) {
          a(null);
        } else {
          h();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  public void r()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((StorySingleFileDownloader)localObject).a();
    }
    localObject = this.w;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  public int s()
  {
    return -1;
  }
  
  public String t()
  {
    return "MoreVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */