package com.tencent.biz.qqstory.comment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class FeedCommentEventHandler$OnActionSheetButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  private final CommentEntry b;
  private final ActionSheet c;
  private final int d;
  
  public FeedCommentEventHandler$OnActionSheetButtonClickListener(FeedCommentEventHandler paramFeedCommentEventHandler, ActionSheet paramActionSheet, CommentEntry paramCommentEntry, int paramInt)
  {
    this.c = paramActionSheet;
    this.b = paramCommentEntry;
    this.d = paramInt;
  }
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.c.getContent(paramInt);
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCommentItemClick.ActionSheet click: which=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", text = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("FeedCommentEventHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (HardCodeUtil.a(2131902454).equals(paramView))
    {
      this.a.a.b(this.d);
      paramView = this.a.d.getOwner();
      if ((paramView != null) && (paramView.isVip())) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (this.b.authorUin.equals(this.a.c)) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      StoryReportor.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.a.d.feedId });
    }
    else if (HardCodeUtil.a(2131902443).equals(paramView))
    {
      this.a.b.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
    }
    else if (HardCodeUtil.a(2131902435).equals(paramView))
    {
      PlayModeUtils.a(this.a.a.c, this.b);
      StoryReportor.a("play_video", "report_reply", StoryReportor.a(this.a.d), 0, new String[] { "", StoryReportor.b(this.a.a.h), "", this.a.d.feedId });
    }
    else if (HardCodeUtil.a(2131902458).equals(paramView))
    {
      this.b.status = 1;
      this.a.a.g();
      this.b.pbType = this.a.a.g.getCommentLikeType();
      StoryQQTextCacher.a().a = "";
      FeedCommentLego.a(this.a.d, this.b, false, this.a.a.h, new FeedCommentEventHandler.OnActionSheetButtonClickListener.2(this));
    }
    else if (HardCodeUtil.a(2131902431).equals(paramView))
    {
      try
      {
        localObject = this.b.content;
        paramView = (View)localObject;
        if (TextUtils.hasSysEmotion((String)localObject)) {
          paramView = EmotionCodecUtils.c((String)localObject);
        }
        localObject = (ClipboardManager)this.a.a.p.getSystemService("clipboard");
        paramView = ClipData.newPlainText("comment content", paramView);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, paramView);
        ((ClipboardManager)localObject).setPrimaryClip(paramView);
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FeedCommentEventHandler", 2, paramView.toString());
        }
        return;
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener
 * JD-Core Version:    0.7.0.1
 */