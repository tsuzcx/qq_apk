package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import amtj;
import android.content.Context;
import android.text.TextUtils;
import bfaj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import pay;
import pgb;
import pvc;
import qjr;
import qjs;
import qtr;
import rep;
import req;
import tfp;
import tfq;
import tfr;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, tfr<CharSequence>
{
  protected int a;
  protected long a;
  protected String a;
  public qtr a;
  protected tfq<CharSequence> a;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Qtr = new qtr();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Qtr.a != null) && (this.jdField_a_of_type_Qtr.a.a() != null) && (this.jdField_a_of_type_Qtr.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Qtr.a.a();
      this.jdField_a_of_type_Tfq = localArticleInfo.articleViewModel.a();
      a(localArticleInfo);
      this.jdField_a_of_type_Tfq.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Tfq.a();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Req == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Req.c)))) {
        break label553;
      }
      localObject = new QQText(bfaj.a(((CharSequence)this.jdField_a_of_type_Tfq.a()).toString().replaceAll("\024", "")), 3, 16);
    }
    label553:
    for (;;)
    {
      setVisibility(0);
      if (this.jdField_b_of_type_Boolean)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((pgb.a(this.jdField_a_of_type_Qtr.a.a())) || (pgb.i(this.jdField_a_of_type_Qtr.a.a())) || (pgb.h(this.jdField_a_of_type_Qtr.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Qtr.a.a()));
        if (localArticleInfo.mArticleType == BaseArticleInfo.TYPE_ARTICLE_NOVEL) {
          setSpanText(BaseApplication.getContext().getString(2131717470));
        }
        for (;;)
        {
          setMoreSpan(new qjr(this, this.jdField_b_of_type_Int, 16777215, 860716207));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          setHeight(0);
          return;
          if (localArticleInfo.isPGCShortContent()) {
            setSpanText(amtj.a(2131706191));
          }
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Qtr.a.a()));
        if (((pay.l(localArticleInfo)) || (pay.m(localArticleInfo))) && (this.jdField_a_of_type_Qtr.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new qjs(this, this.jdField_b_of_type_Int, 16777215, 860716207, localArticleInfo));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_Tfq != null)
    {
      localObject = (CharSequence)this.jdField_a_of_type_Tfq.a();
      QLog.d("NativeCommentView", 1, localObject);
      if ((paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null))
      {
        paramArticleInfo.articleViewModel.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramArticleInfo.articleViewModel.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        paramArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Long != 0L) {
          paramArticleInfo.articleViewModel.a();
        }
      }
      localObject = new StringBuilder().append("current text: ");
      if (this.jdField_a_of_type_Tfq == null) {
        break label158;
      }
    }
    label158:
    for (paramArticleInfo = (CharSequence)this.jdField_a_of_type_Tfq.a();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(tfq<CharSequence> paramtfq)
  {
    paramtfq = (CharSequence)paramtfq.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramtfq));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = (amtj.a(2131717702) + "：");
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
    if (this.jdField_a_of_type_Tfq != null) {
      this.jdField_a_of_type_Tfq.b(this);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    switch (parampvc.a())
    {
    }
    for (;;)
    {
      b();
      setShouldCallClick(this.jdField_b_of_type_Boolean);
      return;
      this.jdField_b_of_type_Boolean = true;
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