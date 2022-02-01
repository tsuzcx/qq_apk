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
  private View A;
  private PressDarkImageView B;
  private TextView C;
  private View D;
  private BottomVideoInfoWidget.MyActivityLifeCycle E;
  private StorySingleFileDownloader F = new StorySingleFileDownloader();
  private CommentFloatDialog G;
  private CommentFloatDialogController H;
  private BottomVideoInfoWidget.RenderResDownloadListener I;
  private boolean J = false;
  private String K = "";
  protected StoryShare s;
  private final FeedManager t = (FeedManager)SuperManager.a(11);
  private final LikeManager u = (LikeManager)SuperManager.a(15);
  private View v;
  private View w;
  private View x;
  private PressDarkImageView y;
  private TextView z;
  
  public BottomVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void F()
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
    localObject2 = ((UserManager)localObject2).b(localStoryVideoItem.mOwnerUid);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((VideoListFeedItem)localObject1).feedId;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
    if ((!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (new File(localStoryVideoItem.mLocalVideoPath).exists()))
    {
      a(localStoryVideoItem.mLocalVideoPath, ((QQUserUIItem)localObject2).uid, (String)localObject1, localStoryVideoItem.mVid, ((QQUserUIItem)localObject2).nickName, ((QQUserUIItem)localObject2).headUrl);
    }
    else
    {
      a(y().getString(2131917842), true);
      this.F.a(localStoryVideoItem.mVid, 0, true, new BottomVideoInfoWidget.6(this, localVideoViewVideoHolder, localStoryVideoItem, (QQUserUIItem)localObject2, (String)localObject1));
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      ThreadManager.getUIHandlerV2().postDelayed(new BottomVideoInfoWidget.7(this, localVideoViewVideoHolder, localStoryVideoItem), 15000L);
    }
    StoryReportor.a("share", "clk_video", 0, 0, new String[] { localStoryVideoItem.mVid });
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo) {}
  
  private void a(VideoListFeedItem paramVideoListFeedItem)
  {
    this.y.a();
    if (paramVideoListFeedItem.mHadLike == 1) {
      this.y.setImageResource(2130848349);
    } else {
      this.y.setImageResource(2130848652);
    }
    if (paramVideoListFeedItem.mLikeCount > 0)
    {
      this.z.setText(UIUtils.a(paramVideoListFeedItem.mLikeCount));
      return;
    }
    this.z.setText(HardCodeUtil.a(2131899426));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner localMediaScanner = MediaScanner.getInstance(y().getApplicationContext());
    System.currentTimeMillis();
    localMediaScanner.queryMediaInfoAsync(new BottomVideoInfoWidget.8(this, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1, localLocalMediaInfo), localLocalMediaInfo);
  }
  
  private void b(VideoListFeedItem paramVideoListFeedItem)
  {
    this.y.a();
    if (paramVideoListFeedItem.mCommentCount > 0)
    {
      this.C.setText(UIUtils.a(paramVideoListFeedItem.mCommentCount));
      return;
    }
    this.C.setText(HardCodeUtil.a(2131899429));
  }
  
  private int p()
  {
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  private void u()
  {
    if (this.p == null) {
      return;
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (((Boolean)localStoryConfigManager.c("first_clk_forward", Boolean.valueOf(true))).booleanValue())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
      QQCustomDialog localQQCustomDialog = DialogUtil.a(y(), 230);
      localQQCustomDialog.setTitle(HardCodeUtil.a(2131899427)).setMessage(HardCodeUtil.a(2131899420)).setPositiveButton(HardCodeUtil.a(2131899428), new BottomVideoInfoWidget.5(this)).setOnDismissListener(new BottomVideoInfoWidget.4(this, localVideoViewVideoHolder));
      localQQCustomDialog.show();
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      localStoryConfigManager.d("first_clk_forward", Boolean.valueOf(false));
      StoryReportor.a("play_video", "exp_window", 0, 0, new String[0]);
    }
    else
    {
      F();
    }
    StoryReportor.a("play_video", "clk_repost", 0, 0, new String[] { "", "", "", this.p.b });
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
    this.v = paramView.findViewById(2131450251);
    this.v.setOnClickListener(this);
    this.w = paramView.findViewById(2131450252);
    this.w.setOnClickListener(this);
    this.x = paramView.findViewById(2131437182);
    this.x.setOnClickListener(this);
    this.y = ((PressDarkImageView)paramView.findViewById(2131437186));
    this.z = ((TextView)paramView.findViewById(2131437184));
    this.A = paramView.findViewById(2131431033);
    this.C = ((TextView)paramView.findViewById(2131431069));
    this.B = ((PressDarkImageView)paramView.findViewById(2131431081));
    this.A.setOnClickListener(this);
    this.D = paramView.findViewById(2131445753);
    this.D.setOnClickListener(this);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new BottomVideoInfoWidget.GetFeedFeatureReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GenShareThumbReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GetFeedItemReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.DownloadStatusUpdateReceiver(this), "");
    paramMap.put(new BottomVideoInfoWidget.GetUserInfoReceiver(this), "");
    this.E = new BottomVideoInfoWidget.MyActivityLifeCycle(this);
    a(this.E);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.t.a(paramCommentEntry.feedId, true);
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
        if ((this.p != null) && ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId)))
        {
          localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
          paramBoolean = MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a());
          Object localObject2 = this.p.e();
          if ((paramBoolean) && (localObject2 != null))
          {
            localObject2 = ((StoryVideoItem)localObject2).mVid;
            StoryReportor.a("play_video", "findsucess_reply", (int)((MsgTabNodeInfo)localObject1).a((String)localObject2), 0, new String[] { "", "", "", localObject2 });
          }
        }
      }
      Object localObject1 = new FeedInfoChangeEvent(1, paramCommentEntry.feedId, 1);
      ((FeedInfoChangeEvent)localObject1).e = paramCommentEntry.commentId;
      ((FeedInfoChangeEvent)localObject1).c = localVideoListFeedItem;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryPlayerVideoData.a == null) || (paramStoryPlayerVideoData.a.b != 13);
  }
  
  public void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    SLog.a(this.i, "bindData=%s", paramStoryPlayerVideoData);
    VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)this.t.a(paramStoryPlayerVideoData.c, true);
    boolean bool2 = paramStoryVideoItem.isUploadSuc();
    boolean bool1 = false;
    if ((bool2) && (localVideoListFeedItem != null))
    {
      if (TextUtils.equals(this.K, paramStoryPlayerVideoData.b))
      {
        this.J = false;
      }
      else
      {
        this.J = true;
        this.K = paramStoryPlayerVideoData.b;
      }
      localObject = ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
      int i = i().mUIStyle.bottomWidgetShowFlag;
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
          SLog.d(this.i, "bind BottomWidget, vid = %s ,from = %d, showFlag = %d, VideoPublic=%s, isFriend=%s, isMe=%s, isVip=%s, TroopStory=%s, banType=%d", new Object[] { paramStoryVideoItem.mVid, Integer.valueOf(i().mReportData.from), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Integer.valueOf(paramStoryVideoItem.mBanType) });
          if ((!bool4) && ((!bool1) || (paramStoryVideoItem.mBanType != 0)) && (!bool2) && (!bool3) && (!bool5))
          {
            if ((bool1) && (i == 3))
            {
              SLog.d(this.i, "show BottomWidget because friend and showBottomWidgetFlag=3");
              break label466;
            }
            SLog.d(this.i, "hide BottomWidget");
          }
          else
          {
            SLog.d(this.i, "show BottomWidget");
            break label466;
          }
        }
        else
        {
          SLog.d(this.i, "hide BottomWidget because flag 2");
        }
        i = 0;
        break label468;
      }
      else
      {
        SLog.d(this.i, "show BottomWidget because flag 1");
      }
      label466:
      i = 1;
      label468:
      if (i != 0)
      {
        z();
        if (FontSettingManager.getFontLevel() > 16.0F)
        {
          this.v.setVisibility(8);
          this.w.setVisibility(0);
        }
        else
        {
          this.v.setVisibility(0);
          this.w.setVisibility(8);
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
          this.D.setVisibility(0);
          if (this.J) {
            StoryReportor.a("play_video", "exp_repost", 0, 0, new String[] { "", "", "", paramStoryPlayerVideoData.b });
          }
        }
        else
        {
          this.D.setVisibility(8);
        }
      }
      else
      {
        A();
      }
      return;
    }
    Object localObject = this.i;
    bool2 = paramStoryVideoItem.isUploadSuc();
    if (localVideoListFeedItem == null) {
      bool1 = true;
    }
    SLog.d((String)localObject, "hide BottomWidget because uploading=%s, no-feed=%s , feed id = %s", new Object[] { Boolean.valueOf(bool2 ^ true), Boolean.valueOf(bool1), paramStoryPlayerVideoData.c });
    A();
  }
  
  public boolean h()
  {
    if (this.p == null) {
      return false;
    }
    Object localObject1 = (UserManager)SuperManager.a(2);
    StoryPlayerVideoData localStoryPlayerVideoData = this.p;
    Object localObject3 = localStoryPlayerVideoData.e();
    VideoListFeedItem localVideoListFeedItem = localStoryPlayerVideoData.f();
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
    localObject1 = this.e;
    long l2 = 0L;
    long l1;
    boolean bool1;
    if ((localObject1 != null) && ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId)))
    {
      localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
      boolean bool2 = MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a());
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
    if ((B()) && (this.x.getVisibility() == 0))
    {
      if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mHadLike != 1))
      {
        this.x.setTag(Boolean.valueOf(true));
        onClick(this.x);
      }
      localObject3 = i();
      localObject1 = localObject2;
      if ((((OpenPlayerBuilder.Data)localObject3).mInfo instanceof MsgTabPlayInfo)) {
        localObject1 = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject3).mInfo).nodeUnionId;
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      int j = C();
      if (bool1) {
        localObject1 = String.valueOf(l1);
      } else {
        localObject1 = String.valueOf(StoryReportor.a((String)localObject1, localVideoListFeedItem));
      }
      StoryReportor.a("play_video", "dbl_like", i, j, new String[] { "", localObject1, "", localStoryPlayerVideoData.b });
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.p != null)
    {
      Object localObject1 = (UserManager)SuperManager.a(2);
      StoryVideoItem localStoryVideoItem = this.p.e();
      if (localStoryVideoItem == null)
      {
        SLog.e(this.i, "click error , video info not found , vid :%s", new Object[] { this.p.b });
      }
      else
      {
        VideoListFeedItem localVideoListFeedItem = this.p.f();
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
        if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId))
        {
          localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
          bool2 = MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a());
          bool1 = bool2;
          if (bool2)
          {
            l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
            bool1 = bool2;
            break label184;
          }
        }
        else
        {
          bool1 = false;
        }
        long l = 0L;
        label184:
        int j = paramView.getId();
        String str = "2";
        Object localObject2;
        switch (j)
        {
        default: 
          break;
        case 2131450251: 
        case 2131450252: 
          bool1 = true;
          break;
        case 2131445753: 
          u();
          break;
        case 2131437182: 
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
            ((LikeEntry)localObject1).uin = QQStoryContext.a().g();
            ((LikeEntry)localObject1).unionId = QQStoryContext.a().i();
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
            int m = C();
            j = 106;
            if (m != 106) {
              j = 0;
            }
            FeedLikeDataProvider.a(localVideoListFeedItem, bool3 ^ true, k, j);
            x();
            ThreadManager.post(new BottomVideoInfoWidget.3(this, bool3, (LikeEntry)localObject1, localVideoListFeedItem), 5, null, false);
            if (!bool2)
            {
              localObject1 = i();
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
              k = C();
              if (i != 0) {
                localObject2 = "2";
              } else {
                localObject2 = "1";
              }
              if (!bool4) {
                str = "1";
              }
              StoryReportor.a("play_video", (String)localObject1, j, k, new String[] { localObject2, str, String.valueOf(localStoryVideoItem.mOwnerUid), this.p.b });
            }
          }
          else if ((localStoryVideoItem.mHasLike != -1) && (localStoryVideoItem.mHasLike != 0))
          {
            this.y.setImageResource(2130848652);
            localStoryVideoItem.mHasLike = 0;
          }
          else
          {
            this.y.setImageResource(2130848349);
            localStoryVideoItem.mHasLike = 1;
          }
          break;
        case 2131431033: 
          bool1 = false;
        }
        if ((localVideoListFeedItem != null) && (localVideoListFeedItem.mDenyComment == 1))
        {
          QQToast.makeText(PlayModeUtils.a(), 1, HardCodeUtil.a(2131899424), 0).show();
        }
        else
        {
          VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
          if (localVideoViewVideoHolder != null) {
            localVideoViewVideoHolder.c(true);
          }
          if (this.H == null) {
            this.H = new CommentFloatDialogController();
          }
          localObject1 = HardCodeUtil.a(2131899425);
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
          localObject2 = i();
          if ((((OpenPlayerBuilder.Data)localObject2).mInfo instanceof MsgTabPlayInfo)) {
            bool2 = MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject2).mInfo).nodeUnionId);
          } else {
            bool2 = false;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899422));
          localObject1 = ((StringBuilder)localObject2).toString();
          this.G = new CommentFloatDialog(y(), this.p.c, this.H, (String)localObject1, 4444, bool1, bool2);
          this.G.show();
          this.G.setOnDismissListener(new BottomVideoInfoWidget.2(this, localVideoViewVideoHolder));
          if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId))
          {
            localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
            if (bool2)
            {
              l = ((MsgTabNodeInfo)localObject1).a(localStoryVideoItem.mVid);
              break label1144;
            }
          }
          l = 0L;
          label1144:
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
  
  protected void q() {}
  
  public void r()
  {
    Object localObject = this.F;
    if (localObject != null) {
      ((StorySingleFileDownloader)localObject).a();
    }
    localObject = this.H;
    if (localObject != null) {
      ((CommentFloatDialogController)localObject).a();
    }
    localObject = this.E;
    if (localObject != null) {
      b((ActivityLifeCycle)localObject);
    }
  }
  
  public int s()
  {
    return 2131628102;
  }
  
  public String t()
  {
    return "BottomVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */