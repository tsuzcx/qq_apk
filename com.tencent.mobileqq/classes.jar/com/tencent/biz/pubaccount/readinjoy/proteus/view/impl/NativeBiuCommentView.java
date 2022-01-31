package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajyc;
import android.content.Context;
import ayki;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pax;
import pmz;
import rvn;
import rvo;
import rvp;

public class NativeBiuCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, rvp<CharSequence>
{
  public final String a;
  private rvn jdField_a_of_type_Rvn;
  private rvo<CharSequence> jdField_a_of_type_Rvo;
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "NativeBiuCommentView";
    setSpannableFactory(ayki.a);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Rvn != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rvn.a();
      setMaxLines(a(localArticleInfo));
      setSpanText(ajyc.a(2131707067));
      setMoreSpan(new pmz(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_Rvo = this.jdField_a_of_type_Rvn.c();
      this.jdField_a_of_type_Rvo.a(this);
      setText((CharSequence)this.jdField_a_of_type_Rvo.a());
    }
  }
  
  public void a(rvo<CharSequence> paramrvo)
  {
    paramrvo = (CharSequence)paramrvo.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramrvo));
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
    if (this.jdField_a_of_type_Rvo != null) {
      this.jdField_a_of_type_Rvo.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Rvo != null) {
      this.jdField_a_of_type_Rvo.b(this);
    }
  }
  
  public void setModel(pax parampax)
  {
    this.jdField_a_of_type_Rvn = parampax.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */