package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajjy;
import android.content.Context;
import axkd;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import opw;
import pbh;
import rix;
import riy;
import riz;

public class NativeBiuCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, riz<CharSequence>
{
  public final String a;
  private rix jdField_a_of_type_Rix;
  private riy<CharSequence> jdField_a_of_type_Riy;
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "NativeBiuCommentView";
    setSpannableFactory(axkd.a);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Rix != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rix.a();
      setMaxLines(a(localArticleInfo));
      setSpanText(ajjy.a(2131641282));
      setMoreSpan(new pbh(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_Riy = this.jdField_a_of_type_Rix.c();
      this.jdField_a_of_type_Riy.a(this);
      setText((CharSequence)this.jdField_a_of_type_Riy.a());
    }
  }
  
  public void a(riy<CharSequence> paramriy)
  {
    paramriy = (CharSequence)paramriy.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramriy));
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
    if (this.jdField_a_of_type_Riy != null) {
      this.jdField_a_of_type_Riy.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Riy != null) {
      this.jdField_a_of_type_Riy.b(this);
    }
  }
  
  public void setModel(opw paramopw)
  {
    this.jdField_a_of_type_Rix = paramopw.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */