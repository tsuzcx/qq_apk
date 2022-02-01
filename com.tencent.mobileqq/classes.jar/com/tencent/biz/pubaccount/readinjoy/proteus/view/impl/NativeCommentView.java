package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.text.TextUtils;
import anzj;
import begp;
import bgqv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ozs;
import ppu;
import qdt;
import qdu;
import qno;
import qxr;
import qxs;
import sel;
import tbm;
import tbn;
import tbo;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, tbo<CharSequence>
{
  protected int a;
  protected long a;
  protected String a;
  public qno a;
  protected tbn<CharSequence> a;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Qno = new qno();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null) && (this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Qno.a.a();
      this.jdField_a_of_type_Tbn = localArticleInfo.articleViewModel.a();
      a(localArticleInfo);
      this.jdField_a_of_type_Tbn.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Tbn.a();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxs == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxs.c)))) {
        break label553;
      }
      localObject = new begp(bgqv.a(((CharSequence)this.jdField_a_of_type_Tbn.a()).toString().replaceAll("\024", "")), 3, 16);
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
      if ((sel.a(this.jdField_a_of_type_Qno.a.a())) || (sel.i(this.jdField_a_of_type_Qno.a.a())) || (sel.h(this.jdField_a_of_type_Qno.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Qno.a.a()));
        if (localArticleInfo.mArticleType == BaseArticleInfo.TYPE_ARTICLE_NOVEL) {
          setSpanText(BaseApplication.getContext().getString(2131717237));
        }
        for (;;)
        {
          setMoreSpan(new qdt(this, this.jdField_b_of_type_Int, 16777215, 860716207));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          setHeight(0);
          return;
          if (localArticleInfo.isPGCShortContent()) {
            setSpanText(anzj.a(2131705961));
          }
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Qno.a.a()));
        if (((ozs.k(localArticleInfo)) || (ozs.l(localArticleInfo))) && (this.jdField_a_of_type_Qno.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new qdu(this, this.jdField_b_of_type_Int, 16777215, 860716207, localArticleInfo));
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
    if (this.jdField_a_of_type_Tbn != null)
    {
      localObject = (CharSequence)this.jdField_a_of_type_Tbn.a();
      QLog.d("NativeCommentView", 1, localObject);
      if ((paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null))
      {
        paramArticleInfo.articleViewModel.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramArticleInfo.articleViewModel.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        paramArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      localObject = new StringBuilder().append("current text: ");
      if (this.jdField_a_of_type_Tbn == null) {
        break label142;
      }
    }
    label142:
    for (paramArticleInfo = (CharSequence)this.jdField_a_of_type_Tbn.a();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(tbn<CharSequence> paramtbn)
  {
    paramtbn = (CharSequence)paramtbn.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramtbn));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = (anzj.a(2131717470) + "：");
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
    if (this.jdField_a_of_type_Tbn != null) {
      this.jdField_a_of_type_Tbn.b(this);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    switch (paramppu.a())
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