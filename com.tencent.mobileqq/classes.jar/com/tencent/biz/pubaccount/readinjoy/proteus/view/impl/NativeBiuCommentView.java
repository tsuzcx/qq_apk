package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import alpo;
import android.content.Context;
import baig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import pgd;
import pte;
import qbs;
import slx;
import sly;
import slz;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, slz<CharSequence>
{
  private slx a;
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(baig.a);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Slx != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Slx.a();
      setMaxLines(a(localArticleInfo));
      setSpanText(alpo.a(2131707450));
      setMoreSpan(new pte(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_Sly = this.jdField_a_of_type_Slx.c();
      this.jdField_a_of_type_Sly.a(this);
      a(localArticleInfo);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_Sly.a());
      setText((CharSequence)this.jdField_a_of_type_Sly.a());
    }
  }
  
  public void a(sly<CharSequence> paramsly)
  {
    paramsly = (CharSequence)paramsly.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramsly));
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
    if (this.jdField_a_of_type_Sly != null) {
      this.jdField_a_of_type_Sly.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Sly != null) {
      this.jdField_a_of_type_Sly.b(this);
    }
  }
  
  public void setModel(pgd parampgd)
  {
    this.jdField_a_of_type_Qbs.a(parampgd);
    this.jdField_a_of_type_Slx = parampgd.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */