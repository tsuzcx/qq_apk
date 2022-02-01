package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import oqy;
import orv;
import otd;
import otp;
import oxf;
import oxg;

public class NativeCommentTextView
  extends ReadInJoyYAFolderTextView
  implements View.OnClickListener, View.OnLongClickListener, IView
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private otd jdField_a_of_type_Otd;
  private otp jdField_a_of_type_Otp;
  
  public NativeCommentTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public NativeCommentTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  private void b()
  {
    QLog.d("NativeCommentTextView", 2, "showAnchorAniation");
    if ((this.jdField_a_of_type_Otp == null) || (this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.jdField_a_of_type_AndroidViewView;
    } while (localView == null);
    QLog.d("NativeCommentTextView", 2, "showAnchorAniation start");
    this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new oxf(this, localView));
    localValueAnimator.start();
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Otd == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Int == -1)
      {
        setBackgroundResource(2130849372);
        this.jdField_a_of_type_Otd.a(this.jdField_a_of_type_Otp);
      }
      else
      {
        ((orv)this.jdField_a_of_type_Otd).a(this.jdField_a_of_type_Otp, oqy.a(this.jdField_a_of_type_Otp, this.jdField_a_of_type_Int), 2);
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Otd == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_a_of_type_Otd.a(this.jdField_a_of_type_Otd.a(), this, this.jdField_a_of_type_Otp, new oxg(this));
    }
    return true;
  }
  
  public void setCommentModel(otp paramotp)
  {
    this.jdField_a_of_type_Otp = paramotp;
    if ((this.jdField_a_of_type_Otp == null) || (this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    setShouldCallClick(true);
    setMaxLines(100);
    setText(this.jdField_a_of_type_Otp.jdField_a_of_type_JavaLangCharSequence);
    setSpanText("");
    setOnClickListener(this);
    setOnLongClickListener(this);
    b();
  }
  
  public void setModel(otd paramotd, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramotd == null)) {
      return;
    }
    this.jdField_a_of_type_Otd = paramotd;
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
  }
  
  public void setModel(otd paramotd, View paramView, int paramInt)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramotd == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Otp != null) && (this.jdField_a_of_type_Otp.c != null) && (this.jdField_a_of_type_Otp.c.size() > paramInt)) {
      setText((CharSequence)this.jdField_a_of_type_Otp.c.get(paramInt));
    }
    this.jdField_a_of_type_Otd = paramotd;
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView
 * JD-Core Version:    0.7.0.1
 */