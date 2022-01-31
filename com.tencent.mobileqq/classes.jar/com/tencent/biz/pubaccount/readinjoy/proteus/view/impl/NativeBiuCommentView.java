package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajya;
import android.content.Context;
import aykk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pau;
import pmw;
import rvk;
import rvl;
import rvm;

public class NativeBiuCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, rvm<CharSequence>
{
  public final String a;
  private rvk jdField_a_of_type_Rvk;
  private rvl<CharSequence> jdField_a_of_type_Rvl;
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "NativeBiuCommentView";
    setSpannableFactory(aykk.a);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Rvk != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rvk.a();
      setMaxLines(a(localArticleInfo));
      setSpanText(ajya.a(2131707078));
      setMoreSpan(new pmw(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_Rvl = this.jdField_a_of_type_Rvk.c();
      this.jdField_a_of_type_Rvl.a(this);
      setText((CharSequence)this.jdField_a_of_type_Rvl.a());
    }
  }
  
  public void a(rvl<CharSequence> paramrvl)
  {
    paramrvl = (CharSequence)paramrvl.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramrvl));
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
    if (this.jdField_a_of_type_Rvl != null) {
      this.jdField_a_of_type_Rvl.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Rvl != null) {
      this.jdField_a_of_type_Rvl.b(this);
    }
  }
  
  public void setModel(pau parampau)
  {
    this.jdField_a_of_type_Rvk = parampau.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */