package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import anni;
import bdnt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import pxk;
import qlg;
import qva;
import tkt;
import tku;
import tkv;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, tkv<CharSequence>
{
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(bdnt.a);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader | linkTextColor " + this.b);
    if (this.jdField_a_of_type_Tkt != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Tkt.a();
      a(localArticleInfo);
      setMaxLines(a(localArticleInfo));
      setSpanText(anni.a(2131705853));
      setMoreSpan(new qlg(this, localArticleInfo, this.b));
      this.jdField_a_of_type_Tkt.a(this.b);
      this.jdField_a_of_type_Tku = this.jdField_a_of_type_Tkt.c();
      this.jdField_a_of_type_Tku.a(this);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_Tku.a());
      setText((CharSequence)this.jdField_a_of_type_Tku.a());
    }
  }
  
  public void a(tku<CharSequence> paramtku)
  {
    paramtku = (CharSequence)paramtku.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramtku));
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Tku != null) {
      this.jdField_a_of_type_Tku.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Tku != null) {
      this.jdField_a_of_type_Tku.b(this);
    }
  }
  
  public void setModel(pxk parampxk)
  {
    this.jdField_a_of_type_Qva.a(parampxk);
    this.jdField_a_of_type_Tkt = parampxk.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */