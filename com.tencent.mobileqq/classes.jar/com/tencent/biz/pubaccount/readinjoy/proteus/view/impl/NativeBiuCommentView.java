package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import amtj;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import pvc;
import qjq;
import qtr;
import tfp;
import tfq;
import tfr;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, tfr<CharSequence>
{
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(QQText.SPANNABLE_FACTORY);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader | linkTextColor " + this.b);
    if (this.jdField_a_of_type_Tfp != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Tfp.a();
      a(localArticleInfo);
      setMaxLines(a(localArticleInfo));
      setSpanText(amtj.a(2131706190));
      setMoreSpan(new qjq(this, localArticleInfo, this.b));
      this.jdField_a_of_type_Tfp.a(this.b);
      this.jdField_a_of_type_Tfq = this.jdField_a_of_type_Tfp.c();
      this.jdField_a_of_type_Tfq.a(this);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_Tfq.a());
      setText((CharSequence)this.jdField_a_of_type_Tfq.a());
    }
  }
  
  public void a(tfq<CharSequence> paramtfq)
  {
    paramtfq = (CharSequence)paramtfq.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramtfq));
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
    if (this.jdField_a_of_type_Tfq != null) {
      this.jdField_a_of_type_Tfq.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Tfq != null) {
      this.jdField_a_of_type_Tfq.b(this);
    }
  }
  
  public void setModel(pvc parampvc)
  {
    this.jdField_a_of_type_Qtr.a(parampvc);
    this.jdField_a_of_type_Tfp = parampvc.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */