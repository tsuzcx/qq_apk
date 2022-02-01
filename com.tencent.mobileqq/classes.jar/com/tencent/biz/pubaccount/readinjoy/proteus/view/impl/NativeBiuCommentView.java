package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import anzj;
import begp;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ppu;
import qds;
import qno;
import tbm;
import tbn;
import tbo;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, tbo<CharSequence>
{
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(begp.a);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader | linkTextColor " + this.b);
    if (this.jdField_a_of_type_Tbm != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Tbm.a();
      a(localArticleInfo);
      setMaxLines(a(localArticleInfo));
      setSpanText(anzj.a(2131705960));
      setMoreSpan(new qds(this, localArticleInfo, this.b));
      this.jdField_a_of_type_Tbm.a(this.b);
      this.jdField_a_of_type_Tbn = this.jdField_a_of_type_Tbm.c();
      this.jdField_a_of_type_Tbn.a(this);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_Tbn.a());
      setText((CharSequence)this.jdField_a_of_type_Tbn.a());
    }
  }
  
  public void a(tbn<CharSequence> paramtbn)
  {
    paramtbn = (CharSequence)paramtbn.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramtbn));
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
    if (this.jdField_a_of_type_Tbn != null) {
      this.jdField_a_of_type_Tbn.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Tbn != null) {
      this.jdField_a_of_type_Tbn.b(this);
    }
  }
  
  public void setModel(ppu paramppu)
  {
    this.jdField_a_of_type_Qno.a(paramppu);
    this.jdField_a_of_type_Tbm = paramppu.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */