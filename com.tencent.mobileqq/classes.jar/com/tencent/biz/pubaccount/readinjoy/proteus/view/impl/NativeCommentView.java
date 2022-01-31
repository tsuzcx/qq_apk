package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajya;
import android.content.Context;
import android.text.TextUtils;
import aykk;
import bajf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import onh;
import pau;
import pmx;
import pmy;
import puy;
import qcg;
import qch;
import ram;
import rvk;
import rvl;
import rvm;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, rvm<CharSequence>
{
  private String jdField_a_of_type_JavaLangString = "NativeCommentView";
  public puy a;
  private rvl<CharSequence> jdField_a_of_type_Rvl;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Puy = new puy();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null) && (this.jdField_a_of_type_Puy.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      this.jdField_a_of_type_Rvl = localArticleInfo.articleViewModel.a();
      this.jdField_a_of_type_Rvl.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Rvl.a();
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qch == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qch.c)))) {
        break label478;
      }
      localObject = new aykk(bajf.a(((CharSequence)this.jdField_a_of_type_Rvl.a()).toString().replaceAll("\024", "")), 2, 16);
    }
    label478:
    for (;;)
    {
      setVisibility(0);
      if (this.b)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((ram.a(this.jdField_a_of_type_Puy.a.a())) || (ram.c(this.jdField_a_of_type_Puy.a.a())) || (ram.h(this.jdField_a_of_type_Puy.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Puy.a.a()));
        if (localArticleInfo.isPGCShortContent()) {
          setSpanText(ajya.a(2131707079));
        }
        setMoreSpan(new pmx(this, -12084769, 16777215, 860716207));
        if (this.b)
        {
          setHeight(0);
          return;
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Puy.a.a()));
        if (((onh.k(localArticleInfo)) || (onh.l(localArticleInfo))) && (this.jdField_a_of_type_Puy.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new pmy(this, -12084769, 16777215, 860716207, localArticleInfo));
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  public void a(rvl<CharSequence> paramrvl)
  {
    paramrvl = (CharSequence)paramrvl.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramrvl));
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.jdField_a_of_type_Puy.a(parampau);
    switch (parampau.a())
    {
    }
    for (;;)
    {
      b();
      setShouldCallClick(this.b);
      return;
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */