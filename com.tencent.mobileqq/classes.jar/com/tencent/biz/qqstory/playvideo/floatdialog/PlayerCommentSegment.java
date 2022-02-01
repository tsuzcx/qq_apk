package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class PlayerCommentSegment
  extends SegmentView
{
  public static final String KEY = "PlayerCommentSegment";
  private int jdField_a_of_type_Int;
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  private PlayerCommentSegment.ClickNickCallback jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$ClickNickCallback = new PlayerCommentSegment.ClickNickCallback(this);
  private PlayerCommentSegment.CommentTextOnTouchListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$CommentTextOnTouchListener = new PlayerCommentSegment.CommentTextOnTouchListener();
  private PlayerCommentSegment.OnChildViewClickListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$OnChildViewClickListener = new PlayerCommentSegment.OnChildViewClickListener(this);
  private StoryPlayerCommentListView.CommentListViewStateChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener;
  public DetailFeedItem a;
  
  public PlayerCommentSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(b()).size();
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) || (paramInt > this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(b()).size()))
    {
      SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramBaseViewHolder.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(b()).get(paramInt);
    if (localCommentEntry == null)
    {
      SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramBaseViewHolder.a();
    }
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131363196);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131372273);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131365059);
    Object localObject1 = (LinearLayout)paramBaseViewHolder.a(2131365053);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131370716);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131365070);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131365093);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846808);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166512));
      }
      return paramBaseViewHolder.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$ClickNickCallback.hashCode() + "bubble_style";
    Object localObject2 = StoryQQTextCacher.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = ImageUtil.c();
      if (localQQUserUIItem != null) {
        break label616;
      }
      localObject1 = "";
      label383:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label626;
      }
      paramInt = 1;
      label393:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label631;
      }
      localObject2 = "V";
      label405:
      if (localQQUserUIItem != null) {
        break label638;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      label416:
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        break label751;
      }
      paramViewGroup = new SpannableStringBuilder(PlayModeUtils.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        SpannableStringUtils.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
      }
      localTextView1.setText(paramViewGroup);
      if (localCommentEntry.status != 2) {
        break label791;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$CommentTextOnTouchListener);
      localTextView2.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = SpannableStringUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a, localCommentEntry, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$ClickNickCallback);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((UserManager)SuperManager.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        StoryQQTextCacher.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      StoryQQTextCacher.a().a((String)localObject1, (CharSequence)localObject2);
      break label352;
      label616:
      localObject1 = localQQUserUIItem.getUserIconUrl();
      break label383;
      label626:
      paramInt = 0;
      break label393;
      label631:
      localObject2 = "";
      break label405;
      label638:
      if ((localQQUserUIItem.isVipButNoFriend()) || (localQQUserUIItem.isNotDovUser()))
      {
        UIUtils.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(FaceDrawable.getFaceDrawable(PlayModeUtils.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (HttpUtil.isValidUrl(localQQUserUIItem.headUrl))
      {
        UIUtils.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      break label416;
      label751:
      if (localQQUserUIItem.isVipButNoFriend())
      {
        paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.nickName);
        break label440;
      }
      paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.getDisplayName());
      break label440;
      label791:
      localImageView.setVisibility(8);
      if (localCommentEntry.status == 1) {
        localProgressBar.setVisibility(0);
      } else {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  public CommentEntry a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a()).get(paramInt);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561803, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$OnChildViewClickListener);
    paramViewGroup.a(2131363196).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131372273).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131365060).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131365060).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370716).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370716).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public String a()
  {
    return "PlayerCommentSegment";
  }
  
  public void a(CommentFloatDialogController paramCommentFloatDialogController, StoryPlayerCommentListView.CommentListViewStateChangeListener paramCommentListViewStateChangeListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = paramCommentFloatDialogController;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener = paramCommentListViewStateChangeListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentSegment
 * JD-Core Version:    0.7.0.1
 */