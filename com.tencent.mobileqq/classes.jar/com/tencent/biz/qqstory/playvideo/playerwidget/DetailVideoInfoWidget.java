package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tribe.async.dispatch.Subscriber;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class DetailVideoInfoWidget
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView A;
  private TextView B;
  private ImageView C;
  private TextView D;
  private TextView E;
  private boolean F = false;
  private String G = "";
  private DetailVideoInfoWidget.SubscribeStatusReceiver H;
  private LinearLayout s;
  private LinearLayout t;
  private LinearLayout u;
  private ImageView v;
  private StoryUserBadgeView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public DetailVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(@Nullable QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = ImageUtil.j();
    if (paramQQUserUIItem == null)
    {
      this.v.setImageDrawable((Drawable)localObject);
      this.w.setVisibility(8);
      return;
    }
    if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser()))
    {
      if (!android.text.TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        localObject = FaceDrawable.getFaceDrawable(PlayModeUtils.b(), 1, paramQQUserUIItem.qq, 3, (Drawable)localObject, (Drawable)localObject);
        this.v.setImageDrawable((Drawable)localObject);
      }
      else if (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl))
      {
        UIUtils.b(this.v, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
      }
      else
      {
        this.v.setImageDrawable((Drawable)localObject);
      }
    }
    else {
      UIUtils.b(this.v, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
    }
    this.w.setUnionID(paramQQUserUIItem.getUnionId(), 2);
    if (((UserManager)SuperManager.a(2)).d(paramQQUserUIItem.qq))
    {
      this.w.setVisibility(8);
      this.w.setOnClickListener(null);
    }
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    long l2 = paramStoryVideoItem.mCreateTime;
    long l1;
    boolean bool1;
    if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
    {
      l1 = paramStoryVideoItem.mTimeZoneOffsetMillis;
      bool1 = true;
    }
    else
    {
      l1 = TimeZone.getDefault().getRawOffset();
      bool1 = false;
    }
    boolean bool2;
    if (this.f.size() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramStoryVideoItem = StoryListUtils.a(l2, l1, bool1, true, bool2);
    this.z.setText(paramStoryVideoItem);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()) && (!paramQQUserUIItem.isMe()))
    {
      this.y.setVisibility(0);
      if (this.F) {
        StoryReportor.a("play_video", "exp_bigv", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      }
    }
    else
    {
      this.y.setVisibility(8);
    }
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull VideoListFeedItem paramVideoListFeedItem)
  {
    Object localObject = ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
    int i;
    if ((localObject != null) && (((QQUserUIItem)localObject).isMe())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((localObject != null) && (((QQUserUIItem)localObject).isFriend())) {
      j = 1;
    } else {
      j = 0;
    }
    localObject = new StringBuilder();
    if (paramVideoListFeedItem.mLikeCount > 0)
    {
      ((StringBuilder)localObject).append("赞");
      ((StringBuilder)localObject).append(UIUtils.a(paramVideoListFeedItem.mLikeCount));
    }
    if (((paramStoryVideoItem.mStoryType != 1) || (i != 0) || (j == 0)) && (paramVideoListFeedItem.mViewTotalTime > 0L))
    {
      if (paramVideoListFeedItem.mLikeCount > 0) {
        ((StringBuilder)localObject).append(" • ");
      }
      ((StringBuilder)localObject).append("浏览");
      ((StringBuilder)localObject).append(UIUtils.a(paramVideoListFeedItem.mViewTotalTime));
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      if ((paramStoryVideoItem.mStoryType == 1) && (i == 0) && (paramVideoListFeedItem.mLikeCount == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.s.setClickable(false);
        this.B.setVisibility(0);
        this.C.setVisibility(8);
      }
      else
      {
        this.s.setClickable(true);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
      }
      this.B.setText(((StringBuilder)localObject).toString());
      this.s.setVisibility(0);
      return;
    }
    this.B.setVisibility(8);
    this.C.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  private void a(@Nullable String paramString, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramQQUserUIItem == null)
      {
        this.x.setText(PlayModeUtils.b);
        return;
      }
      TroopNickNameManager localTroopNickNameManager = (TroopNickNameManager)SuperManager.a(23);
      this.x.setText(localTroopNickNameManager.a(paramQQUserUIItem, paramString, false, true));
      return;
    }
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isAvailable()))
    {
      if (paramQQUserUIItem.isVipButNoFriend())
      {
        this.x.setText(paramQQUserUIItem.nickName);
        return;
      }
      this.x.setText(paramQQUserUIItem.getDisplayName());
      return;
    }
    this.x.setText(PlayModeUtils.b);
  }
  
  private void b(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()))
    {
      this.H.a = paramQQUserUIItem.getUnionId();
      ((QQStoryHandler)PlayModeUtils.b().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, paramQQUserUIItem.uid, 0, 1);
      Object localObject;
      if (this.p != null) {
        localObject = this.p.e();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        localObject = ((StoryVideoItem)localObject).mVid;
      } else {
        localObject = "";
      }
      long l2 = 0L;
      long l1 = l2;
      if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId))
      {
        MsgTabNodeInfo localMsgTabNodeInfo = ((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a;
        l1 = l2;
        if (MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a())) {
          l1 = localMsgTabNodeInfo.a((String)localObject);
        }
      }
      int i;
      if (paramQQUserUIItem.isVip) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.a("play_video", "follow_bigv", i, (int)l1, new String[] { "1", "", "", localObject });
    }
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
    if (localVideoViewVideoHolder == null) {
      return;
    }
    localVideoViewVideoHolder.c(true);
    MyVideoVisibilityDialog localMyVideoVisibilityDialog = new MyVideoVisibilityDialog(y(), paramStoryVideoItem.mVid, paramStoryVideoItem.mBanType, paramStoryVideoItem.mVideoSpreadGroupList, false);
    localMyVideoVisibilityDialog.setCanceledOnTouchOutside(true);
    localMyVideoVisibilityDialog.setCancelable(true);
    localMyVideoVisibilityDialog.setOnDismissListener(new DetailVideoInfoWidget.1(this, localVideoViewVideoHolder));
    localMyVideoVisibilityDialog.show();
    StoryReportor.a("pub_control", "clk_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void b(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.i, 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    StoryApi.a(y(), 9, paramStoryVideoItem.mOwnerUid);
    if (paramBoolean)
    {
      Object localObject1 = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
      Object localObject2 = "1";
      if (localObject1 != null)
      {
        if (((QQUserUIItem)localObject1).isMe())
        {
          localObject1 = "1";
          localObject2 = "2";
        }
        else if (((QQUserUIItem)localObject1).isFriend())
        {
          localObject1 = "2";
        }
        else if (((QQUserUIItem)localObject1).isVip())
        {
          localObject1 = "3";
        }
        else
        {
          localObject1 = "";
        }
      }
      else
      {
        localObject1 = "";
        localObject2 = localObject1;
      }
      StoryReportor.a("play_video", "clk_head", 0, 0, new String[] { localObject1, localObject2, "", paramStoryVideoItem.mVid });
      return;
    }
    StoryReportor.a("play_video", "clk_name", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = (StoryPlayerGroupHolder)d();
    Dialog localDialog = WeShiGuideDialog.a(y(), paramStoryVideoItem.mOwnerUid, "4", paramStoryVideoItem.mVid, 3, paramStoryVideoItem.mWsSchema);
    localObject = ((StoryPlayerGroupHolder)localObject).r();
    if (localDialog != null)
    {
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).c(true);
      }
      localDialog.setOnDismissListener(new DetailVideoInfoWidget.2(this, (VideoViewVideoHolder)localObject));
    }
    int i;
    if (WeishiGuideUtils.a(y())) {
      i = 2;
    } else {
      i = 1;
    }
    StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramStoryVideoItem.mOwnerUid, "weishi", paramStoryVideoItem.mVid });
  }
  
  private void d(StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mOwnerUid;
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c((String)localObject);
    if (paramStoryVideoItem.mStoryType == 2)
    {
      String str = paramStoryVideoItem.mGroupId;
      localObject = str;
      if (android.text.TextUtils.isEmpty(str))
      {
        paramStoryPlayerVideoData = paramStoryPlayerVideoData.f();
        localObject = str;
        if (paramStoryPlayerVideoData != null)
        {
          localObject = str;
          if (paramStoryPlayerVideoData.getOwner() != null)
          {
            localObject = str;
            if ((paramStoryPlayerVideoData.getOwner() instanceof QQUserUIItem)) {
              localObject = ((QQUserUIItem)paramStoryPlayerVideoData.getOwner()).qq;
            }
          }
        }
      }
    }
    else
    {
      localObject = null;
    }
    a(localQQUserUIItem);
    a((String)localObject, localQQUserUIItem);
    boolean bool;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramStoryVideoItem, bool);
    a(paramStoryVideoItem);
    a(paramStoryVideoItem, localQQUserUIItem);
  }
  
  private void e(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.f();
    if (paramStoryPlayerVideoData == null)
    {
      this.s.setVisibility(8);
      return;
    }
    this.s.setVisibility(0);
    a(paramStoryVideoItem, paramStoryPlayerVideoData);
  }
  
  private void f(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if (!c(paramStoryPlayerVideoData, paramStoryVideoItem))
    {
      this.t.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
  }
  
  private void g(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.c()) && (paramStoryPlayerVideoData.h.a()) && (!android.text.TextUtils.isEmpty(paramStoryPlayerVideoData.h.d)))
    {
      this.u.setVisibility(0);
      paramStoryVideoItem = paramStoryPlayerVideoData.h.d;
      paramStoryPlayerVideoData = paramStoryVideoItem;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramStoryVideoItem)) {
        paramStoryPlayerVideoData = EmotionCodecUtils.c(paramStoryVideoItem);
      }
      paramStoryPlayerVideoData = new QQTextBuilder(paramStoryPlayerVideoData, 3, 16);
      this.E.setText(paramStoryPlayerVideoData);
      return;
    }
    this.u.setVisibility(8);
  }
  
  protected void a(View paramView)
  {
    this.s = ((LinearLayout)paramView.findViewById(2131435856));
    this.t = ((LinearLayout)paramView.findViewById(2131446808));
    this.u = ((LinearLayout)paramView.findViewById(2131433652));
    this.v = ((ImageView)paramView.findViewById(2131442755));
    this.w = ((StoryUserBadgeView)paramView.findViewById(2131442758));
    this.x = ((TextView)paramView.findViewById(2131442756));
    this.y = ((TextView)paramView.findViewById(2131446570));
    this.z = ((TextView)paramView.findViewById(2131442757));
    this.B = ((TextView)paramView.findViewById(2131435855));
    this.C = ((ImageView)paramView.findViewById(2131428782));
    this.D = ((TextView)paramView.findViewById(2131446416));
    this.A = ((ImageView)paramView.findViewById(2131449770));
    this.E = ((TextView)paramView.findViewById(2131433660));
    this.v.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.H = new DetailVideoInfoWidget.SubscribeStatusReceiver(this, null);
    a(this.H);
    paramMap.put(new DetailVideoInfoWidget.GetUserInfoReceiver(this), "");
    paramMap.put(new DetailVideoInfoWidget.GetFeedFeatureReceiver(this), "");
    paramMap.put(new DetailVideoInfoWidget.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new DetailVideoInfoWidget.GetFeedItemReceiver(this), "");
    paramMap.put(new DetailVideoInfoWidget.GetStoryTagInfoReceiver(this), "");
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if ((!paramStoryVideoItem.isMine()) && (!StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid)))
    {
      this.A.setVisibility(8);
      return false;
    }
    this.A.setVisibility(0);
    if (paramStoryVideoItem.mBanType == 0)
    {
      if (paramBoolean) {
        this.A.setImageResource(2130848675);
      } else {
        this.A.setImageResource(2130848671);
      }
    }
    else if (paramStoryVideoItem.mBanType == 1) {
      this.A.setImageResource(2130848673);
    } else if ((paramStoryVideoItem.mBanType != 2) && (paramStoryVideoItem.mBanType != 3)) {
      this.A.setImageResource(2130848675);
    } else {
      this.A.setImageResource(2130848677);
    }
    if (this.F) {
      StoryReportor.a("pub_control", "exp_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    }
    return true;
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!i().mUIStyle.hideVideoDetailInfo) && ((paramStoryPlayerVideoData.a == null) || (paramStoryPlayerVideoData.a.b != 13));
  }
  
  protected void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!android.text.TextUtils.equals(this.G, paramStoryPlayerVideoData.b))
    {
      this.G = paramStoryPlayerVideoData.b;
      this.F = true;
    }
    else
    {
      this.G = "";
      this.F = false;
    }
    d(paramStoryPlayerVideoData, paramStoryVideoItem);
    e(paramStoryPlayerVideoData, paramStoryVideoItem);
    f(paramStoryPlayerVideoData, paramStoryVideoItem);
    g(paramStoryPlayerVideoData, paramStoryVideoItem);
  }
  
  public boolean c(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    TagItem.TagInfoBase localTagInfoBase = paramStoryVideoItem.mTagInfoBase;
    if ((!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorUnionId)) && (!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorName)))
    {
      this.D.setCompoundDrawablesWithIntrinsicBounds(2130848455, 0, 0, 0);
      this.D.setCompoundDrawablePadding(UIUtils.a(y(), 2.0F));
      this.D.setText(paramStoryVideoItem.originalAuthorName);
      this.D.setVisibility(0);
      this.D.setTag(paramStoryVideoItem.originalAuthorUnionId);
    }
    else if ((localTagInfoBase != null) && (!android.text.TextUtils.isEmpty(localTagInfoBase.b)))
    {
      this.D.setCompoundDrawablesWithIntrinsicBounds(2130848653, 0, 0, 0);
      this.D.setCompoundDrawablePadding(UIUtils.a(y(), 2.0F));
      this.D.setText(localTagInfoBase.b);
      this.D.setVisibility(0);
      this.D.setTag(null);
    }
    else
    {
      this.D.setVisibility(8);
      this.D.setTag(null);
    }
    if (this.D.getVisibility() == 0)
    {
      if (this.F)
      {
        String str = "";
        if (localTagInfoBase != null) {
          str = String.valueOf(localTagInfoBase.a);
        }
        StoryReportor.a("play_video", "exp_tag_play", 0, 0, new String[] { "", str, paramStoryPlayerVideoData.c, paramStoryVideoItem.mVid });
      }
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.p != null) {
      localStoryVideoItem = this.p.e();
    } else {
      localStoryVideoItem = null;
    }
    if (localStoryVideoItem == null)
    {
      SLog.e(this.i, "click error , video info not found");
    }
    else
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)d()).r();
      Object localObject = (UserManager)SuperManager.a(2);
      VideoListFeedItem localVideoListFeedItem = this.p.f();
      QQUserUIItem localQQUserUIItem = ((UserManager)localObject).b(localStoryVideoItem.mOwnerUid);
      int i;
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool = PlayModeUtils.a(localStoryVideoItem);
      int j = paramView.getId();
      String str = "2";
      localObject = "1";
      switch (j)
      {
      default: 
        break;
      case 2131450116: 
        c(localStoryVideoItem);
        break;
      case 2131449770: 
        b(localStoryVideoItem);
        break;
      case 2131446570: 
        if (localQQUserUIItem != null) {
          b(localQQUserUIItem);
        }
        break;
      case 2131446416: 
        if (paramView.getTag() != null)
        {
          localObject = (String)paramView.getTag();
          SLog.d(this.i, "startStoryProfileActivity by original author name, video-item-unionId=%s, tag-unionId=%s", new Object[] { localStoryVideoItem.originalAuthorUnionId, localObject });
          StoryApi.a(y(), 9, (String)localObject);
        }
        else
        {
          StoryTagUtil.a(y(), localStoryVideoItem.mTagInfoBase);
          if (localStoryVideoItem.mTagInfoBase != null)
          {
            if (localStoryVideoItem.mTagInfoBase.d != 0) {
              localObject = "2";
            }
            str = String.valueOf(localStoryVideoItem.mTagInfoBase.a);
          }
          else
          {
            str = "";
          }
          StoryReportor.a("play_video", "clk_tag", 0, 0, new String[] { "", localObject, str, localStoryVideoItem.mVid });
        }
        break;
      case 2131442756: 
      case 2131442757: 
        b(localStoryVideoItem, false);
        break;
      case 2131442755: 
        b(localStoryVideoItem, true);
        break;
      case 2131438862: 
        localObject = (ActionSheet)ActionSheetHelper.c(y(), null);
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131901281), 5);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        ((ActionSheet)localObject).setOnButtonClickListener(new DetailVideoInfoWidget.3(this, localStoryVideoItem, localVideoViewVideoHolder, localAtomicBoolean, (ActionSheet)localObject));
        ((ActionSheet)localObject).setOnDismissListener(new DetailVideoInfoWidget.4(this, localAtomicBoolean, localVideoViewVideoHolder));
        if (!((ActionSheet)localObject).isShowing())
        {
          ((ActionSheet)localObject).show();
          if (localVideoViewVideoHolder != null) {
            localVideoViewVideoHolder.c(true);
          }
          if (i != 0) {
            i = 1;
          } else {
            i = 2;
          }
          j = StoryReportor.a(localVideoListFeedItem);
          if (bool) {
            localObject = str;
          } else {
            localObject = "1";
          }
          StoryReportor.a("play_video", "clk_more_play", i, j, new String[] { localObject, String.valueOf(StoryReportor.a(localQQUserUIItem)), localStoryVideoItem.mVid });
        }
        break;
      case 2131435856: 
        i = StoryFailCommentCacher.a().a(this.p.c);
        if (i != -1) {
          StoryDetailActivity.a(y(), this.p.c, PlayModeUtils.b(C()), i, C(), 0);
        } else {
          StoryDetailActivity.a(y(), this.p.c, PlayModeUtils.b(C()), false, this.p.b, C());
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void q() {}
  
  public void r()
  {
    DetailVideoInfoWidget.SubscribeStatusReceiver localSubscribeStatusReceiver = this.H;
    if (localSubscribeStatusReceiver != null) {
      b(localSubscribeStatusReceiver);
    }
  }
  
  protected int s()
  {
    return 2131628203;
  }
  
  public String t()
  {
    return "DetailVideoInfoWidget";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */