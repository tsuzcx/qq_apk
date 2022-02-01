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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DetailVideoInfoWidget.SubscribeStatusReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget$SubscribeStatusReceiver;
  private StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private TextView d;
  private TextView e;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  
  public DetailVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private void a(@Nullable QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = ImageUtil.e();
    if (paramQQUserUIItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser()))
    {
      if (!android.text.TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        localObject = FaceDrawable.getFaceDrawable(PlayModeUtils.a(), 1, paramQQUserUIItem.qq, 3, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      else if (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl))
      {
        UIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    else {
      UIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, 80, 80, (Drawable)localObject, "QQStory_player");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setUnionID(paramQQUserUIItem.getUnionId(), 2);
    if (((UserManager)SuperManager.a(2)).a(paramQQUserUIItem.qq))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setOnClickListener(null);
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
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramStoryVideoItem = StoryListUtils.a(l2, l1, bool1, true, bool2);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramStoryVideoItem);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()) && (!paramQQUserUIItem.isMe()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_f_of_type_Boolean) {
        StoryReportor.a("play_video", "exp_bigv", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
        this.d.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
        this.d.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.d.setText(((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    StoryApi.a(b(), 9, paramStoryVideoItem.mOwnerUid);
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
  
  private void a(@Nullable String paramString, @Nullable QQUserUIItem paramQQUserUIItem)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramQQUserUIItem == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(PlayModeUtils.jdField_b_of_type_JavaLangString);
        return;
      }
      TroopNickNameManager localTroopNickNameManager = (TroopNickNameManager)SuperManager.a(23);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopNickNameManager.a(paramQQUserUIItem, paramString, false, true));
      return;
    }
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isAvailable()))
    {
      if (paramQQUserUIItem.isVipButNoFriend())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.nickName);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.getDisplayName());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(PlayModeUtils.jdField_b_of_type_JavaLangString);
  }
  
  private void b(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isSubscribe()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget$SubscribeStatusReceiver.jdField_a_of_type_JavaLangString = paramQQUserUIItem.getUnionId();
      ((QQStoryHandler)PlayModeUtils.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, paramQQUserUIItem.uid, 0, 1);
      Object localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
      {
        MsgTabNodeInfo localMsgTabNodeInfo = ((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
        l1 = l2;
        if (MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a())) {
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
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
    if (localVideoViewVideoHolder == null) {
      return;
    }
    localVideoViewVideoHolder.c(true);
    MyVideoVisibilityDialog localMyVideoVisibilityDialog = new MyVideoVisibilityDialog(b(), paramStoryVideoItem.mVid, paramStoryVideoItem.mBanType, paramStoryVideoItem.mVideoSpreadGroupList, false);
    localMyVideoVisibilityDialog.setCanceledOnTouchOutside(true);
    localMyVideoVisibilityDialog.setCancelable(true);
    localMyVideoVisibilityDialog.setOnDismissListener(new DetailVideoInfoWidget.1(this, localVideoViewVideoHolder));
    localMyVideoVisibilityDialog.show();
    StoryReportor.a("pub_control", "clk_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
  }
  
  private void b(StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = paramStoryVideoItem.mOwnerUid;
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c((String)localObject);
    if (paramStoryVideoItem.mStoryType == 2)
    {
      String str = paramStoryVideoItem.mGroupId;
      localObject = str;
      if (android.text.TextUtils.isEmpty(str))
      {
        paramStoryPlayerVideoData = paramStoryPlayerVideoData.a();
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
  
  private void c(StoryVideoItem paramStoryVideoItem)
  {
    Object localObject = (StoryPlayerGroupHolder)a();
    Dialog localDialog = WeShiGuideDialog.a(b(), paramStoryVideoItem.mOwnerUid, "4", paramStoryVideoItem.mVid, 3, paramStoryVideoItem.mWsSchema);
    localObject = ((StoryPlayerGroupHolder)localObject).a();
    if (localDialog != null)
    {
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).c(true);
      }
      localDialog.setOnDismissListener(new DetailVideoInfoWidget.2(this, (VideoViewVideoHolder)localObject));
    }
    int i;
    if (WeishiGuideUtils.a(b())) {
      i = 2;
    } else {
      i = 1;
    }
    StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", paramStoryVideoItem.mOwnerUid, "weishi", paramStoryVideoItem.mVid });
  }
  
  private void c(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.a();
    if (paramStoryPlayerVideoData == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(paramStoryVideoItem, paramStoryPlayerVideoData);
  }
  
  private void d(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ((UserManager)SuperManager.a(2)).c(paramStoryVideoItem.mOwnerUid);
    if (!b(paramStoryPlayerVideoData, paramStoryVideoItem))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    paramStoryPlayerVideoData = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramStoryPlayerVideoData != null) && (paramStoryPlayerVideoData.a()) && (paramStoryPlayerVideoData.a.a()) && (!android.text.TextUtils.isEmpty(paramStoryPlayerVideoData.a.d)))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramStoryVideoItem = paramStoryPlayerVideoData.a.d;
      paramStoryPlayerVideoData = paramStoryVideoItem;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramStoryVideoItem)) {
        paramStoryPlayerVideoData = EmotionCodecUtils.b(paramStoryVideoItem);
      }
      paramStoryPlayerVideoData = new QQTextBuilder(paramStoryPlayerVideoData, 3, 16);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramStoryPlayerVideoData);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public String a()
  {
    return "DetailVideoInfoWidget";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368910));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378289));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367196));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374585));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = ((StoryUserBadgeView)paramView.findViewById(2131374588));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374586));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378070));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374587));
    this.d = ((TextView)paramView.findViewById(2131368909));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362981));
    this.e = ((TextView)paramView.findViewById(2131377930));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380800));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367204));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  protected void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!android.text.TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      this.jdField_f_of_type_Boolean = true;
    }
    else
    {
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_f_of_type_Boolean = false;
    }
    b(paramStoryPlayerVideoData, paramStoryVideoItem);
    c(paramStoryPlayerVideoData, paramStoryVideoItem);
    d(paramStoryPlayerVideoData, paramStoryVideoItem);
    e(paramStoryPlayerVideoData, paramStoryVideoItem);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget$SubscribeStatusReceiver = new DetailVideoInfoWidget.SubscribeStatusReceiver(this, null);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget$SubscribeStatusReceiver);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramStoryVideoItem.mBanType == 0)
    {
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847123);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847119);
      }
    }
    else if (paramStoryVideoItem.mBanType == 1) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847121);
    } else if ((paramStoryVideoItem.mBanType != 2) && (paramStoryVideoItem.mBanType != 3)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847123);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847125);
    }
    if (this.jdField_f_of_type_Boolean) {
      StoryReportor.a("pub_control", "exp_icon", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
    }
    return true;
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!a().mUIStyle.hideVideoDetailInfo) && ((paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo == null) || (paramStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int != 13));
  }
  
  protected int b()
  {
    return 2131561824;
  }
  
  public boolean b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    TagItem.TagInfoBase localTagInfoBase = paramStoryVideoItem.mTagInfoBase;
    if ((!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorUnionId)) && (!android.text.TextUtils.isEmpty(paramStoryVideoItem.originalAuthorName)))
    {
      this.e.setCompoundDrawablesWithIntrinsicBounds(2130846903, 0, 0, 0);
      this.e.setCompoundDrawablePadding(UIUtils.a(b(), 2.0F));
      this.e.setText(paramStoryVideoItem.originalAuthorName);
      this.e.setVisibility(0);
      this.e.setTag(paramStoryVideoItem.originalAuthorUnionId);
    }
    else if ((localTagInfoBase != null) && (!android.text.TextUtils.isEmpty(localTagInfoBase.jdField_a_of_type_JavaLangString)))
    {
      this.e.setCompoundDrawablesWithIntrinsicBounds(2130847101, 0, 0, 0);
      this.e.setCompoundDrawablePadding(UIUtils.a(b(), 2.0F));
      this.e.setText(localTagInfoBase.jdField_a_of_type_JavaLangString);
      this.e.setVisibility(0);
      this.e.setTag(null);
    }
    else
    {
      this.e.setVisibility(8);
      this.e.setTag(null);
    }
    if (this.e.getVisibility() == 0)
    {
      if (this.jdField_f_of_type_Boolean)
      {
        String str = "";
        if (localTagInfoBase != null) {
          str = String.valueOf(localTagInfoBase.jdField_a_of_type_Long);
        }
        StoryReportor.a("play_video", "exp_tag_play", 0, 0, new String[] { "", str, paramStoryPlayerVideoData.jdField_b_of_type_JavaLangString, paramStoryVideoItem.mVid });
      }
      return true;
    }
    return false;
  }
  
  protected void f() {}
  
  public void g()
  {
    DetailVideoInfoWidget.SubscribeStatusReceiver localSubscribeStatusReceiver = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetDetailVideoInfoWidget$SubscribeStatusReceiver;
    if (localSubscribeStatusReceiver != null) {
      b(localSubscribeStatusReceiver);
    }
  }
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    } else {
      localStoryVideoItem = null;
    }
    if (localStoryVideoItem == null)
    {
      SLog.e(this.jdField_b_of_type_JavaLangString, "click error , video info not found");
    }
    else
    {
      VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)a()).a();
      Object localObject = (UserManager)SuperManager.a(2);
      VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
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
      case 2131381101: 
        c(localStoryVideoItem);
        break;
      case 2131380800: 
        b(localStoryVideoItem);
        break;
      case 2131378070: 
        if (localQQUserUIItem != null) {
          b(localQQUserUIItem);
        }
        break;
      case 2131377930: 
        if (paramView.getTag() != null)
        {
          localObject = (String)paramView.getTag();
          SLog.d(this.jdField_b_of_type_JavaLangString, "startStoryProfileActivity by original author name, video-item-unionId=%s, tag-unionId=%s", new Object[] { localStoryVideoItem.originalAuthorUnionId, localObject });
          StoryApi.a(b(), 9, (String)localObject);
        }
        else
        {
          StoryTagUtil.a(b(), localStoryVideoItem.mTagInfoBase);
          if (localStoryVideoItem.mTagInfoBase != null)
          {
            if (localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Int != 0) {
              localObject = "2";
            }
            str = String.valueOf(localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long);
          }
          else
          {
            str = "";
          }
          StoryReportor.a("play_video", "clk_tag", 0, 0, new String[] { "", localObject, str, localStoryVideoItem.mVid });
        }
        break;
      case 2131374586: 
      case 2131374587: 
        a(localStoryVideoItem, false);
        break;
      case 2131374585: 
        a(localStoryVideoItem, true);
        break;
      case 2131371487: 
        localObject = (ActionSheet)ActionSheetHelper.b(b(), null);
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131703321), 5);
        ((ActionSheet)localObject).addCancelButton(2131690728);
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
      case 2131368910: 
        i = StoryFailCommentCacher.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString);
        if (i != -1) {
          StoryDetailActivity.a(b(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, PlayModeUtils.a(c()), i, c(), 0);
        } else {
          StoryDetailActivity.a(b(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_b_of_type_JavaLangString, PlayModeUtils.a(c()), false, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, c());
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */