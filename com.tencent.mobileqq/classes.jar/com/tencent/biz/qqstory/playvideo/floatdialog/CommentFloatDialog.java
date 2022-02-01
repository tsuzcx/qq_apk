package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import javax.annotation.Nullable;

public class CommentFloatDialog
  extends ReportDialog
{
  private RelativeLayout a;
  private CommentFloatDialogTopGestureLayout b;
  private StoryPlayerCommentListView c;
  private RelativeLayout d;
  @Nullable
  private DetailCommentHelper e;
  private CommentFloatDialogController f;
  private String g;
  private int h;
  private boolean i = false;
  private boolean j = false;
  private Animation k;
  private Animation l;
  private DetailFeedItem m;
  private boolean n = false;
  
  public CommentFloatDialog(@NonNull Context paramContext, @NonNull String paramString1, CommentFloatDialogController paramCommentFloatDialogController, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131951973);
    this.g = paramString1;
    this.f = paramCommentFloatDialogController;
    this.h = paramInt;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    paramContext = LayoutInflater.from(paramContext).inflate(2131628181, null);
    a(paramContext, paramString2);
    this.f.a(this.g);
    this.f.b();
    super.setContentView(paramContext);
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(16);
      paramString1 = paramContext.getAttributes();
      paramString1.width = -1;
      paramString1.height = UIUtils.d(getContext());
      paramString1.flags |= 0x20;
      paramString1.gravity = 80;
      paramContext.setAttributes(paramString1);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        paramContext = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
        paramContext.setStatusBarDrawable(null);
        paramContext.init();
      }
    }
  }
  
  private void a(View paramView, String paramString)
  {
    this.a = ((RelativeLayout)paramView);
    this.b = ((CommentFloatDialogTopGestureLayout)paramView.findViewById(2131431322));
    this.d = ((RelativeLayout)paramView.findViewById(2131431280));
    this.c = ((StoryPlayerCommentListView)paramView.findViewById(2131431100));
    this.c.a(this.f, new CommentFloatDialog.OnCommentListViewStateChangeListener(this, null), this.h);
    Object localObject = this.b;
    ((CommentFloatDialogTopGestureLayout)localObject).a(this, this.c, (View)localObject);
    if (QQStoryContext.e())
    {
      ((InputLinearLayout)paramView.findViewById(2131444638)).setBackgroundColor(getContext().getResources().getColor(2131167384));
      ((LinearLayout)paramView.findViewById(2131429671)).setBackgroundColor(getContext().getResources().getColor(2131167383));
      ((XEditTextEx)paramView.findViewById(2131432617)).setHintTextColor(getContext().getResources().getColor(2131167385));
      this.c.setBackgroundColor(getContext().getResources().getColor(2131167383));
      paramView.findViewById(2131447534).setBackgroundColor(getContext().getResources().getColor(2131167383));
      this.b.setBackgroundColor(getContext().getResources().getColor(2131167383));
      paramView.findViewById(2131432003).setBackgroundColor(getContext().getResources().getColor(2131167384));
    }
    paramView.setOnClickListener(new CommentFloatDialog.1(this));
    localObject = (ImageView)paramView.findViewById(2131430817);
    ((ImageView)localObject).setOnClickListener(new CommentFloatDialog.2(this));
    if (QQStoryContext.e()) {
      ((ImageView)localObject).setBackgroundResource(2130848236);
    }
    ((TextView)paramView.findViewById(2131447463)).setText(paramString);
    this.k = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.l = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.k.setDuration(400L);
    this.l.setDuration(300L);
    this.l.setAnimationListener(new CommentFloatDialog.3(this));
  }
  
  public void a()
  {
    if (!this.n)
    {
      this.n = true;
      this.b.startAnimation(this.l);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.n)
    {
      this.n = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, paramInt, 1, 1.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new CommentFloatDialog.4(this));
      this.b.startAnimation(localTranslateAnimation);
    }
  }
  
  public CharSequence b()
  {
    DetailCommentHelper localDetailCommentHelper = this.e;
    if (localDetailCommentHelper != null) {
      return localDetailCommentHelper.a.getText();
    }
    return "";
  }
  
  public boolean c()
  {
    DetailFeedItem localDetailFeedItem = this.m;
    return (localDetailFeedItem != null) && (localDetailFeedItem.a != null) && (this.m.a.getOwner().isMe());
  }
  
  public boolean d()
  {
    DetailFeedItem localDetailFeedItem = this.m;
    return (localDetailFeedItem != null) && (localDetailFeedItem.a != null) && (this.m.a.getOwner().isVip());
  }
  
  protected void onStart()
  {
    this.b.startAnimation(this.k);
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */