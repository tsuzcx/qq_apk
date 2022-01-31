package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import nzj;
import nzk;

public class ReadInJoyCommentLikeView
  extends FrameLayout
  implements IView
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
  private nzk jdField_a_of_type_Nzk;
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    inflate(getContext(), 2131494271, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303736));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302975));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312292));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nzj(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, SCALE_X, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, SCALE_Y, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void b()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isLiked()) {
        break label77;
      }
    }
    label77:
    for (int i = 2130842167;; i = 2130842165)
    {
      localImageView.setImageResource(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.likeCnt > 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(bgmq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.likeCnt));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.likeCnt == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      }
      return;
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
    b();
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setOnLikeListener(nzk paramnzk)
  {
    this.jdField_a_of_type_Nzk = paramnzk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView
 * JD-Core Version:    0.7.0.1
 */