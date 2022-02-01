package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import qfw;
import qvv;
import rfw;
import ttb;
import ttc;
import ttd;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, ttd<CharSequence>
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
    if (this.jdField_a_of_type_Ttb != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Ttb.a();
      a(localArticleInfo);
      setMaxLines(a(localArticleInfo));
      setSpanText(anvx.a(2131706542));
      setMoreSpan(new qvv(this, localArticleInfo, this.b));
      this.jdField_a_of_type_Ttb.a(this.b);
      this.jdField_a_of_type_Ttc = this.jdField_a_of_type_Ttb.c();
      this.jdField_a_of_type_Ttc.a(this);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_Ttc.a());
      setText((CharSequence)this.jdField_a_of_type_Ttc.a());
    }
  }
  
  public void a(ttc<CharSequence> paramttc)
  {
    paramttc = (CharSequence)paramttc.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramttc));
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
    if (this.jdField_a_of_type_Ttc != null) {
      this.jdField_a_of_type_Ttc.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Ttc != null) {
      this.jdField_a_of_type_Ttc.b(this);
    }
  }
  
  public void setModel(qfw paramqfw)
  {
    this.jdField_a_of_type_Rfw.a(paramqfw);
    this.jdField_a_of_type_Ttb = paramqfw.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */