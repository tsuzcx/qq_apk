package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajjy;
import android.content.Context;
import android.text.TextUtils;
import axkd;
import azho;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import obz;
import opw;
import pbi;
import pbj;
import pjg;
import pqm;
import pqn;
import qoe;
import rix;
import riy;
import riz;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, riz<CharSequence>
{
  private String jdField_a_of_type_JavaLangString = "NativeCommentView";
  public pjg a;
  private riy<CharSequence> jdField_a_of_type_Riy;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Pjg = new pjg();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Pjg.a != null) && (this.jdField_a_of_type_Pjg.a.a() != null) && (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
      this.jdField_a_of_type_Riy = localArticleInfo.articleViewModel.a();
      this.jdField_a_of_type_Riy.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Riy.a();
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqn == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqn.c)))) {
        break label478;
      }
      localObject = new axkd(azho.a(((CharSequence)this.jdField_a_of_type_Riy.a()).toString().replaceAll("\024", "")), 2, 16);
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
      if ((qoe.a(this.jdField_a_of_type_Pjg.a.a())) || (qoe.c(this.jdField_a_of_type_Pjg.a.a())) || (qoe.h(this.jdField_a_of_type_Pjg.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Pjg.a.a()));
        if (localArticleInfo.isPGCShortContent()) {
          setSpanText(ajjy.a(2131641283));
        }
        setMoreSpan(new pbi(this, -12084769, 16777215, 860716207));
        if (this.b)
        {
          setHeight(0);
          return;
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Pjg.a.a()));
        if (((obz.k(localArticleInfo)) || (obz.l(localArticleInfo))) && (this.jdField_a_of_type_Pjg.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new pbj(this, -12084769, 16777215, 860716207, localArticleInfo));
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  public void a(riy<CharSequence> paramriy)
  {
    paramriy = (CharSequence)paramriy.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramriy));
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
    this.jdField_a_of_type_Pjg.a(paramopw);
    switch (paramopw.a())
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