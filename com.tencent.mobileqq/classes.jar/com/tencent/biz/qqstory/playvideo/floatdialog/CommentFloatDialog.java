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
  private int jdField_a_of_type_Int;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  private CommentFloatDialogTopGestureLayout jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout;
  private StoryPlayerCommentListView jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  @Nullable
  private DetailCommentHelper jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public CommentFloatDialog(@NonNull Context paramContext, @NonNull String paramString1, CommentFloatDialogController paramCommentFloatDialogController, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131755284);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = paramCommentFloatDialogController;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    paramContext = LayoutInflater.from(paramContext).inflate(2131561802, null);
    a(paramContext, paramString2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.b();
    super.setContentView(paramContext);
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(16);
      paramString1 = paramContext.getAttributes();
      paramString1.width = -1;
      paramString1.height = UIUtils.c(getContext());
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout = ((CommentFloatDialogTopGestureLayout)paramView.findViewById(2131365169));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365132));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = ((StoryPlayerCommentListView)paramView.findViewById(2131364973));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController, new CommentFloatDialog.OnCommentListViewStateChangeListener(this, null), this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout;
    ((CommentFloatDialogTopGestureLayout)localObject).a(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView, (View)localObject);
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramView.findViewById(2131376421)).setBackgroundColor(getContext().getResources().getColor(2131166527));
      ((LinearLayout)paramView.findViewById(2131363748)).setBackgroundColor(getContext().getResources().getColor(2131166526));
      ((XEditTextEx)paramView.findViewById(2131366317)).setHintTextColor(getContext().getResources().getColor(2131166528));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.setBackgroundColor(getContext().getResources().getColor(2131166526));
      paramView.findViewById(2131378837).setBackgroundColor(getContext().getResources().getColor(2131166526));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.setBackgroundColor(getContext().getResources().getColor(2131166526));
      paramView.findViewById(2131365759).setBackgroundColor(getContext().getResources().getColor(2131166527));
    }
    paramView.setOnClickListener(new CommentFloatDialog.1(this));
    localObject = (ImageView)paramView.findViewById(2131364711);
    ((ImageView)localObject).setOnClickListener(new CommentFloatDialog.2(this));
    if (QQStoryContext.a()) {
      ((ImageView)localObject).setBackgroundResource(2130846684);
    }
    ((TextView)paramView.findViewById(2131378784)).setText(paramString);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new CommentFloatDialog.3(this));
  }
  
  public CharSequence a()
  {
    DetailCommentHelper localDetailCommentHelper = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper;
    if (localDetailCommentHelper != null) {
      return localDetailCommentHelper.a.getText();
    }
    return "";
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      this.c = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, paramInt, 1, 1.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new CommentFloatDialog.4(this));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(localTranslateAnimation);
    }
  }
  
  public boolean a()
  {
    DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
    return (localDetailFeedItem != null) && (localDetailFeedItem.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe());
  }
  
  public boolean b()
  {
    DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
    return (localDetailFeedItem != null) && (localDetailFeedItem.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isVip());
  }
  
  protected void onStart()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */