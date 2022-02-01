package com.tencent.biz.qqstory.storyHome.detail.view.segment;

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
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class DetailCommentSegment
  extends SegmentView
{
  public static final String KEY = "DetailCommentSegment";
  public DetailFeedItem a;
  private boolean b;
  private DetailEventCallback c;
  private DetailCommentSegment.ClickNickCallback d = new DetailCommentSegment.ClickNickCallback(1);
  private DetailCommentSegment.CommentTextOnTouchListener e = new DetailCommentSegment.CommentTextOnTouchListener();
  private DetailCommentSegment.OnChildViewClickListener f = new DetailCommentSegment.OnChildViewClickListener(this);
  
  public DetailCommentSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.m)
    {
      DetailFeedItem localDetailFeedItem = this.a;
      if (localDetailFeedItem != null) {
        return localDetailFeedItem.a(this.b).size();
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.a;
    if ((paramViewGroup != null) && (paramInt <= paramViewGroup.a(this.b).size()))
    {
      CommentEntry localCommentEntry = (CommentEntry)this.a.a(this.b).get(paramInt);
      if (localCommentEntry == null)
      {
        SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
        return paramBaseViewHolder.a();
      }
      ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131428988);
      TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131439303);
      TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131431067);
      paramViewGroup = (LinearLayout)paramBaseViewHolder.a(2131431059);
      TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131437615);
      ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131431079);
      ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131431101);
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
        paramViewGroup.append(this.d.hashCode());
        paramViewGroup.append("bubble_style");
        paramViewGroup = paramViewGroup.toString();
        Object localObject = StoryQQTextCacher.a().a(paramViewGroup);
        if (localObject != null)
        {
          localTextView2.setText((CharSequence)localObject);
        }
        else
        {
          localObject = SpannableStringUtils.b(this.l, this.a.a, localCommentEntry, this.d);
          localTextView2.setText((CharSequence)localObject);
          StoryQQTextCacher.a().a(paramViewGroup, (CharSequence)localObject);
        }
        paramViewGroup = ((UserManager)SuperManager.a(2)).c(localCommentEntry.authorUnionId);
        Drawable localDrawable = ImageUtil.j();
        String str = "";
        if (paramViewGroup == null) {
          localObject = "";
        } else {
          localObject = paramViewGroup.getUserIconUrl();
        }
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          str = "V";
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
              localImageView2.setImageDrawable(FaceDrawable.getFaceDrawable(PlayModeUtils.b(), 1, paramViewGroup.qq, 3, localDrawable, localDrawable));
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
          paramViewGroup.append(str);
          SpannableStringUtils.a(paramViewGroup, (String)localObject, paramInt, paramViewGroup.length());
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
        localTextView2.setOnTouchListener(this.e);
        localTextView2.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        localTextView2.setTextColor(-16777216);
      }
      if (QQStoryContext.e())
      {
        localTextView2.setBackgroundResource(2130848240);
        localTextView1.setTextColor(this.l.getResources().getColor(2131167385));
        localTextView2.setTextColor(this.l.getResources().getColor(2131167385));
        localTextView3.setBackgroundColor(this.l.getResources().getColor(2131167383));
      }
      return paramBaseViewHolder.a();
    }
    SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
    return paramBaseViewHolder.a();
  }
  
  public CommentEntry a(int paramInt)
  {
    DetailFeedItem localDetailFeedItem = this.a;
    if ((localDetailFeedItem != null) && (paramInt < localDetailFeedItem.a(this.b).size())) {
      return (CommentEntry)this.a.a(this.b).get(paramInt);
    }
    return null;
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628038, paramViewGroup, false));
    paramViewGroup.a(this.f);
    paramViewGroup.a(2131428988).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131439303).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131431068).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131431068).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131437615).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131437615).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.c = paramDetailEventCallback;
    this.d.a(paramDetailEventCallback);
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    this.a = paramDetailFeedItem;
    this.b = paramBoolean;
  }
  
  public String b()
  {
    return "DetailCommentSegment";
  }
  
  public void br_()
  {
    if (((StoryDetailListView)w()).b())
    {
      this.m = true;
      return;
    }
    this.m = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment
 * JD-Core Version:    0.7.0.1
 */