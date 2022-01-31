package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajyc;
import android.content.Context;
import android.text.TextUtils;
import ayki;
import bair;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import onk;
import pax;
import pna;
import pnb;
import pvb;
import qcj;
import qck;
import rap;
import rvn;
import rvo;
import rvp;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, rvp<CharSequence>
{
  private String jdField_a_of_type_JavaLangString = "NativeCommentView";
  public pvb a;
  private rvo<CharSequence> jdField_a_of_type_Rvo;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Pvb = new pvb();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null) && (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
      this.jdField_a_of_type_Rvo = localArticleInfo.articleViewModel.a();
      this.jdField_a_of_type_Rvo.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_Rvo.a();
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qck == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qck.c)))) {
        break label478;
      }
      localObject = new ayki(bair.a(((CharSequence)this.jdField_a_of_type_Rvo.a()).toString().replaceAll("\024", "")), 2, 16);
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
      if ((rap.a(this.jdField_a_of_type_Pvb.a.a())) || (rap.c(this.jdField_a_of_type_Pvb.a.a())) || (rap.h(this.jdField_a_of_type_Pvb.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_Pvb.a.a()));
        if (localArticleInfo.isPGCShortContent()) {
          setSpanText(ajyc.a(2131707068));
        }
        setMoreSpan(new pna(this, -12084769, 16777215, 860716207));
        if (this.b)
        {
          setHeight(0);
          return;
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd != null)
      {
        setMaxLines(a(this.jdField_a_of_type_Pvb.a.a()));
        if (((onk.k(localArticleInfo)) || (onk.l(localArticleInfo))) && (this.jdField_a_of_type_Pvb.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new pnb(this, -12084769, 16777215, 860716207, localArticleInfo));
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  public void a(rvo<CharSequence> paramrvo)
  {
    paramrvo = (CharSequence)paramrvo.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramrvo));
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.jdField_a_of_type_Pvb.a(parampax);
    switch (parampax.a())
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