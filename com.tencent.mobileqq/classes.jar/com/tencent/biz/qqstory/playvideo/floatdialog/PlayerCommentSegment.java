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
    CommentFloatDialogController localCommentFloatDialogController = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
    return (localCommentFloatDialogController == null) || (localCommentFloatDialogController.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
      if (localDetailFeedItem != null) {
        return localDetailFeedItem.a(b()).size();
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
    if ((paramViewGroup != null) && (paramInt <= paramViewGroup.a(b()).size()))
    {
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(b()).get(paramInt);
      if (localCommentEntry == null)
      {
        SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
        return paramBaseViewHolder.a();
      }
      ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131363135);
      TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371862);
      TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131364942);
      paramViewGroup = (LinearLayout)paramBaseViewHolder.a(2131364936);
      TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131370353);
      ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131364953);
      ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131364974);
      if (localCommentEntry.type == 1)
      {
        localImageView2.setVisibility(8);
        paramViewGroup.setVisibility(8);
        localTextView3.setVisibility(0);
        localTextView3.setText(localCommentEntry.content);
      }
      else
      {
        localImageView2.setVisibility(0);
        paramViewGroup.setVisibility(0);
        localTextView3.setVisibility(8);
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localCommentEntry.commentId);
        paramViewGroup.append(localCommentEntry.feedId);
        paramViewGroup.append(localCommentEntry.status);
        paramViewGroup.append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$ClickNickCallback.hashCode());
        paramViewGroup.append("bubble_style");
        paramViewGroup = paramViewGroup.toString();
        Object localObject1 = StoryQQTextCacher.a().a(paramViewGroup);
        if (localObject1 != null)
        {
          localTextView2.setText((CharSequence)localObject1);
        }
        else
        {
          localObject1 = SpannableStringUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a, localCommentEntry, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$ClickNickCallback);
          localTextView2.setText((CharSequence)localObject1);
          if (localCommentEntry.isReply())
          {
            localObject2 = ((UserManager)SuperManager.a(2)).c(localCommentEntry.replierUnionId);
            if ((localObject2 != null) && (((QQUserUIItem)localObject2).isAvailable())) {
              StoryQQTextCacher.a().a(paramViewGroup, (CharSequence)localObject1);
            }
          }
          else
          {
            StoryQQTextCacher.a().a(paramViewGroup, (CharSequence)localObject1);
          }
        }
        paramViewGroup = ((UserManager)SuperManager.a(2)).c(localCommentEntry.authorUnionId);
        Drawable localDrawable = ImageUtil.e();
        Object localObject2 = "";
        if (paramViewGroup == null) {
          localObject1 = "";
        } else {
          localObject1 = paramViewGroup.getUserIconUrl();
        }
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = "V";
        }
        if (paramViewGroup == null) {
          localImageView2.setImageDrawable(localDrawable);
        }
        for (;;)
        {
          break;
          if ((!paramViewGroup.isVipButNoFriend()) && (!paramViewGroup.isNotDovUser()))
          {
            if (!TextUtils.isEmpty(paramViewGroup.qq)) {
              localImageView2.setImageDrawable(FaceDrawable.getFaceDrawable(PlayModeUtils.a(), 1, paramViewGroup.qq, 3, localDrawable, localDrawable));
            } else if (HttpUtil.isValidUrl(paramViewGroup.headUrl)) {
              UIUtils.b(localImageView2, paramViewGroup.headUrl, 60, 60, localDrawable, "QQStory_player");
            } else {
              localImageView2.setImageDrawable(localDrawable);
            }
          }
          else {
            UIUtils.b(localImageView2, paramViewGroup.headUrl, 60, 60, localDrawable, "QQStory_player");
          }
        }
        if ((paramViewGroup != null) && (paramViewGroup.isAvailable()))
        {
          if (paramViewGroup.isVipButNoFriend()) {
            paramViewGroup = new SpannableStringBuilder(paramViewGroup.nickName);
          } else {
            paramViewGroup = new SpannableStringBuilder(paramViewGroup.getDisplayName());
          }
        }
        else {
          paramViewGroup = new SpannableStringBuilder(PlayModeUtils.b);
        }
        if ((bool ^ true))
        {
          paramInt = paramViewGroup.length();
          paramViewGroup.append((CharSequence)localObject2);
          SpannableStringUtils.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
        }
        localTextView1.setText(paramViewGroup);
        if (localCommentEntry.status == 2)
        {
          localImageView1.setVisibility(0);
          localProgressBar.setVisibility(8);
        }
        else
        {
          localImageView1.setVisibility(8);
          if (localCommentEntry.status == 1) {
            localProgressBar.setVisibility(0);
          } else {
            localProgressBar.setVisibility(8);
          }
        }
        localTextView2.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$CommentTextOnTouchListener);
        localTextView2.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        localTextView2.setTextColor(-16777216);
      }
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846688);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166526));
      }
      return paramBaseViewHolder.a();
    }
    SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
    return paramBaseViewHolder.a();
  }
  
  public CommentEntry a(int paramInt)
  {
    DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
    if ((localDetailFeedItem != null) && (paramInt < localDetailFeedItem.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a()).size())) {
      return (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a()).get(paramInt);
    }
    return null;
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561659, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogPlayerCommentSegment$OnChildViewClickListener);
    paramViewGroup.a(2131363135).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371862).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364943).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364943).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370353).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370353).setOnLongClickListener(paramViewGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentSegment
 * JD-Core Version:    0.7.0.1
 */