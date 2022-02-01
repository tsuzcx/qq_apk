package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.text.TextUtils;
import anvx;
import bgip;
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
import ppe;
import pqw;
import qfw;
import qvw;
import qvx;
import rfw;
import rqw;
import rqx;
import ttb;
import ttc;
import ttd;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, ttd<CharSequence>
{
  protected int a;
  protected long a;
  protected String a;
  public rfw a;
  protected ttc<CharSequence> a;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Rfw = new rfw();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null) && (this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      this.jdField_a_of_type_Ttc = localArticleInfo.articleViewModel.a();
      a(localArticleInfo);
      this.jdField_a_of_type_Ttc.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Ttc.a();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqx == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqx.c)))) {
        break label553;
      }
      localObject = new QQText(bgip.a(((CharSequence)this.jdField_a_of_type_Ttc.a()).toString().replaceAll("\024", "")), 3, 16);
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
      if ((ppe.a(this.jdField_a_of_type_Rfw.a.a())) || (ppe.i(this.jdField_a_of_type_Rfw.a.a())) || (ppe.h(this.jdField_a_of_type_Rfw.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Rfw.a.a()));
        if (localArticleInfo.mArticleType == BaseArticleInfo.TYPE_ARTICLE_NOVEL) {
          setSpanText(BaseApplication.getContext().getString(2131717836));
        }
        for (;;)
        {
          setMoreSpan(new qvw(this, this.jdField_b_of_type_Int, 16777215, 860716207));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          setHeight(0);
          return;
          if (localArticleInfo.isPGCShortContent()) {
            setSpanText(anvx.a(2131706543));
          }
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Rfw.a.a()));
        if (((pqw.l(localArticleInfo)) || (pqw.m(localArticleInfo))) && (this.jdField_a_of_type_Rfw.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new qvx(this, this.jdField_b_of_type_Int, 16777215, 860716207, localArticleInfo));
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
    if (this.jdField_a_of_type_Ttc != null)
    {
      localObject = (CharSequence)this.jdField_a_of_type_Ttc.a();
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
      if (this.jdField_a_of_type_Ttc == null) {
        break label158;
      }
    }
    label158:
    for (paramArticleInfo = (CharSequence)this.jdField_a_of_type_Ttc.a();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(ttc<CharSequence> paramttc)
  {
    paramttc = (CharSequence)paramttc.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramttc));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = (anvx.a(2131718073) + "：");
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
    if (this.jdField_a_of_type_Ttc != null) {
      this.jdField_a_of_type_Ttc.b(this);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    switch (paramqfw.a())
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