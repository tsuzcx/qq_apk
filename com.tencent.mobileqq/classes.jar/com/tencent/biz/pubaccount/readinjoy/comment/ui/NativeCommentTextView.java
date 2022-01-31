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
import bajq;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ntt;
import nvf;
import nwk;
import nwx;
import nzg;
import nzh;

public class NativeCommentTextView
  extends ReadInJoyYAFolderTextView
  implements View.OnClickListener, View.OnLongClickListener, IView
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "NativeCommentTextView";
  private nwk jdField_a_of_type_Nwk;
  private nwx jdField_a_of_type_Nwx;
  
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
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showAnchorAniation");
    if ((this.jdField_a_of_type_Nwx == null) || (this.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.jdField_a_of_type_AndroidViewView;
    } while (localView == null);
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showAnchorAniation start");
    this.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new nzg(this, localView));
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
    if (this.jdField_a_of_type_Nwk == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      setBackgroundResource(2130848147);
      this.jdField_a_of_type_Nwk.a(this.jdField_a_of_type_Nwx);
      return;
    }
    ((nvf)this.jdField_a_of_type_Nwk).a(this.jdField_a_of_type_Nwx, ntt.a(this.jdField_a_of_type_Nwx, this.jdField_a_of_type_Int));
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
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Nwk == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_a_of_type_Nwk.a(this.jdField_a_of_type_Nwk.a(), this, this.jdField_a_of_type_Nwx, new nzh(this));
    }
    return true;
  }
  
  public void setCommentModel(nwx paramnwx)
  {
    this.jdField_a_of_type_Nwx = paramnwx;
    if ((this.jdField_a_of_type_Nwx == null) || (this.jdField_a_of_type_Nwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    setShouldCallClick(true);
    setMaxLines(100);
    setText(this.jdField_a_of_type_Nwx.jdField_a_of_type_JavaLangCharSequence);
    setSpanText("");
    setOnClickListener(this);
    setOnLongClickListener(this);
    b();
  }
  
  public void setModel(nwk paramnwk, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramnwk == null)) {
      return;
    }
    this.jdField_a_of_type_Nwk = paramnwk;
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
  }
  
  public void setModel(nwk paramnwk, View paramView, int paramInt)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramnwk == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Nwx != null) && (this.jdField_a_of_type_Nwx.c != null) && (this.jdField_a_of_type_Nwx.c.size() > paramInt)) {
      setText((CharSequence)this.jdField_a_of_type_Nwx.c.get(paramInt));
    }
    if (paramInt == 0) {
      setPadding(bajq.b(9.0F), bajq.b(12.0F), bajq.b(9.0F), bajq.b(12.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_Nwk = paramnwk;
      this.jdField_a_of_type_AndroidViewView = paramView;
      b();
      return;
      if (paramInt == 1) {
        setPadding(bajq.b(9.0F), bajq.b(0.0F), bajq.b(9.0F), bajq.b(12.0F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView
 * JD-Core Version:    0.7.0.1
 */