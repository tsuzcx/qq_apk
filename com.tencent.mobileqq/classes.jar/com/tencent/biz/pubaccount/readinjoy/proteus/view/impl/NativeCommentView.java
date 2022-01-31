package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import alud;
import android.content.Context;
import android.text.TextUtils;
import bamp;
import bcmc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ors;
import pgd;
import ptf;
import ptg;
import qbs;
import qmc;
import qmd;
import rqj;
import slx;
import sly;
import slz;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, slz<CharSequence>
{
  protected int a;
  protected long a;
  protected String a;
  public qbs a;
  protected sly<CharSequence> a;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Qbs = new qbs();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Qbs.a != null) && (this.jdField_a_of_type_Qbs.a.a() != null) && (this.jdField_a_of_type_Qbs.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Qbs.a.a();
      this.jdField_a_of_type_Sly = localArticleInfo.articleViewModel.a();
      a(localArticleInfo);
      this.jdField_a_of_type_Sly.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Sly.a();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmd == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmd.c)))) {
        break label508;
      }
      localObject = new bamp(bcmc.a(((CharSequence)this.jdField_a_of_type_Sly.a()).toString().replaceAll("\024", "")), 3, 16);
    }
    label508:
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
      if ((rqj.a(this.jdField_a_of_type_Qbs.a.a())) || (rqj.d(this.jdField_a_of_type_Qbs.a.a())) || (rqj.h(this.jdField_a_of_type_Qbs.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Qbs.a.a()));
        if (localArticleInfo.isPGCShortContent()) {
          setSpanText(alud.a(2131707463));
        }
        setMoreSpan(new ptf(this, -12084769, 16777215, 860716207));
        if (this.b)
        {
          setHeight(0);
          return;
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Qbs.a.a()));
        if (((ors.k(localArticleInfo)) || (ors.l(localArticleInfo))) && (this.jdField_a_of_type_Qbs.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new ptg(this, -12084769, 16777215, 860716207, localArticleInfo));
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("current text: ");
    Object localObject;
    if (this.jdField_a_of_type_Sly != null)
    {
      localObject = (CharSequence)this.jdField_a_of_type_Sly.a();
      QLog.d("NativeCommentView", 1, localObject);
      if ((paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null))
      {
        paramArticleInfo.articleViewModel.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramArticleInfo.articleViewModel.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        paramArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        paramArticleInfo.articleViewModel.a();
      }
      localObject = new StringBuilder().append("current text: ");
      if (this.jdField_a_of_type_Sly == null) {
        break label147;
      }
    }
    label147:
    for (paramArticleInfo = (CharSequence)this.jdField_a_of_type_Sly.a();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(sly<CharSequence> paramsly)
  {
    paramsly = (CharSequence)paramsly.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramsly));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = (alud.a(2131719267) + "：");
    }
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    switch (parampgd.a())
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
  
  public void setPreAccountUin(long paramLong)
  {
    QLog.d("NativeCommentView", 1, "setPreAccountUin: " + paramLong);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setPreBlankNum(int paramInt)
  {
    QLog.d("NativeCommentView", 1, "setPreBlankNum: " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */