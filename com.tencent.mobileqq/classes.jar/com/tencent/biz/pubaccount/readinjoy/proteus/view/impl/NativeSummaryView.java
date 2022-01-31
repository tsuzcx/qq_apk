package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajjy;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import awbk;
import axkd;
import babh;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import nzr;
import obj;
import obz;
import opw;
import oqi;
import pbu;
import pjg;
import pqm;
import pqz;
import pre;
import prg;
import prv;
import prx;
import qoe;
import rev;
import rix;
import riy;
import riz;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, riz<CharSequence>
{
  pjg jdField_a_of_type_Pjg = new pjg();
  private riy<CharSequence> jdField_a_of_type_Riy;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(ajjy.a(2131641291));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new pbu(this, paramArticleInfo, -3355444));
    if ((obz.k(paramArticleInfo)) || (obz.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((obz.b(paramArticleInfo)) || (obz.c(paramArticleInfo)))
    {
      obz.a(paramContext, paramArticleInfo, 1, false, 4, false);
      qoe.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      obz.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private void a(opw paramopw)
  {
    if (paramopw.a() == null) {
      return;
    }
    this.jdField_a_of_type_Riy = paramopw.a().articleViewModel.b();
    this.jdField_a_of_type_Riy.a(this);
    setText((CharSequence)this.jdField_a_of_type_Riy.a());
    a(paramopw.a());
  }
  
  public static void a(opw paramopw, SpannableStringBuilder paramSpannableStringBuilder, oqi paramoqi)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramopw.a();
    localSpannableStringBuilder.append("@");
    if ((qoe.d((ArticleInfo)localObject)) || (qoe.b((BaseArticleInfo)localObject)) || (qoe.b(paramopw.a())))
    {
      localObject = paramopw.a().mSubscribeName;
      if ((paramopw.a() == 33) && (paramopw.a().mSocialFeedInfo != null) && (paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prv != null)) {
        if (paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b == 0L)
        {
          paramoqi = paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
      }
    }
    while ((!qoe.f((ArticleInfo)localObject)) || (!qoe.i((ArticleInfo)localObject))) {
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(paramoqi).longValue();
          localSpannableStringBuilder.setSpan(new rev(l1, "2", paramopw.a()), 0, localSpannableStringBuilder.length(), 33);
          localSpannableStringBuilder.append(": ");
          paramSpannableStringBuilder.append(new SpannableStringBuilder(new axkd(localSpannableStringBuilder, 7, 16)));
          return;
          paramoqi = String.valueOf(paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b);
          if (obz.a())
          {
            localObject = babh.b((QQAppInterface)obz.a(), paramoqi, true);
            continue;
          }
          localObject = paramopw.a().b(paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b);
        }
        catch (NumberFormatException paramoqi)
        {
          paramoqi.printStackTrace();
          l1 = 0L;
          continue;
        }
        if (paramopw.a().mAccountLess == 0)
        {
          paramoqi = paramopw.a().mSubscribeID;
          try
          {
            long l2 = Long.valueOf(paramoqi).longValue();
            l1 = l2;
          }
          catch (NumberFormatException paramoqi)
          {
            for (;;)
            {
              paramoqi.printStackTrace();
            }
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new rev(l1, "2", paramopw.a()), 0, localSpannableStringBuilder.length(), 33);
          continue;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long;
    paramoqi = ReadInJoyUserInfoModule.a(l1, paramoqi);
    if (paramoqi != null) {}
    for (paramoqi = paramoqi.nick;; paramoqi = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(paramoqi))
      {
        localSpannableStringBuilder.append(obz.d(paramoqi));
        localSpannableStringBuilder.setSpan(new rev(l1, "2", paramopw.a()), 0, localSpannableStringBuilder.length(), 33);
      }
      if (obz.p((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  public static void b(opw paramopw, SpannableStringBuilder paramSpannableStringBuilder, oqi paramoqi)
  {
    int j = 1;
    int k = 0;
    ArticleInfo localArticleInfo = paramopw.a();
    if (nzr.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    int i;
    switch (paramopw.a())
    {
    default: 
      i = 0;
      if ((qoe.d(localArticleInfo)) || (qoe.b(localArticleInfo)) || (qoe.b(paramopw.a())))
      {
        k = qoe.c(localArticleInfo);
        if (paramopw.a().isPGCShortContent()) {
          if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString)))
          {
            paramopw = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString;
            label194:
            paramSpannableStringBuilder.append(paramopw);
            i = 7;
          }
        }
      }
      break;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      i = 1;
      break;
      i = 1;
      break;
      if (!TextUtils.isEmpty(localArticleInfo.mTitle))
      {
        paramopw = localArticleInfo.mTitle;
        break label194;
      }
      paramopw = "";
      break label194;
      if ((35 == k) || (34 == k))
      {
        paramopw = new SpannableStringBuilder();
        if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString != null))
        {
          paramopw.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(paramopw);
          i = j;
          break;
          if (localArticleInfo.mTitle != null) {
            paramopw.append(localArticleInfo.mTitle);
          }
        }
      }
      if (i != 0)
      {
        if (!TextUtils.isEmpty(localArticleInfo.mSummary)) {}
        for (paramopw = localArticleInfo.mSummary;; paramopw = "")
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
            paramopw = localArticleInfo.mTitle;
          }
          paramSpannableStringBuilder.append(paramopw);
          i = 2;
          break;
        }
      }
      Object localObject = paramopw.a().mSummary;
      if ((pjg.f(paramopw)) || (pjg.i(paramopw))) {
        localObject = paramopw.a().mTitle;
      }
      paramoqi = (oqi)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramopw.a() == 33) {
          paramoqi = ajjy.a(2131641292);
        }
      }
      else
      {
        label558:
        paramSpannableStringBuilder.append(paramoqi);
        if ((paramopw.a() == 33) && (!qoe.f(localArticleInfo)))
        {
          paramoqi = (prx)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(0);
          localObject = paramSpannableStringBuilder.append("“");
          if (!TextUtils.isEmpty(paramoqi.c)) {
            break label745;
          }
          paramopw = "";
          label624:
          localObject = ((SpannableStringBuilder)localObject).append(paramopw);
          if (!TextUtils.isEmpty(paramoqi.jdField_a_of_type_JavaLangString)) {
            break label753;
          }
        }
      }
      label745:
      label753:
      for (paramopw = "";; paramopw = paramoqi.jdField_a_of_type_JavaLangString)
      {
        ((SpannableStringBuilder)localObject).append(paramopw).append("”");
        i = 3;
        break;
        if ((pjg.e(paramopw)) || (pjg.g(paramopw)) || (pjg.h(paramopw)))
        {
          paramoqi = ajjy.a(2131641290);
          break label558;
        }
        if ((pjg.f(paramopw)) || (pjg.i(paramopw)))
        {
          paramoqi = ajjy.a(2131641288);
          break label558;
        }
        if (pjg.a(paramopw))
        {
          paramoqi = ajjy.a(2131641289);
          break label558;
        }
        paramoqi = ajjy.a(2131641287);
        break label558;
        paramopw = paramoqi.c;
        break label624;
      }
      i = k;
      if (qoe.f(localArticleInfo))
      {
        i = k;
        if (qoe.i(localArticleInfo))
        {
          paramopw = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaLangString;
          if (obz.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre))
          {
            paramopw = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqm.a(localArticleInfo, "2", paramoqi);
            if (!TextUtils.isEmpty(paramopw)) {
              paramSpannableStringBuilder.append(paramopw);
            }
            i = 4;
          }
          else if ((pjg.c(localArticleInfo)) && (!qoe.q(localArticleInfo)))
          {
            paramopw = ((prg)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).e;
            if ((!TextUtils.isEmpty(paramopw)) && (TextUtils.equals(obj.a(paramopw), paramopw))) {
              awbk.b(paramopw);
            }
            i = 5;
          }
          else
          {
            i = k;
            if (!TextUtils.isEmpty(paramopw))
            {
              paramSpannableStringBuilder.append(new axkd(awbk.b(paramopw), 7, 16));
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void a(riy<CharSequence> paramriy)
  {
    paramriy = (CharSequence)paramriy.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramriy));
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
    setShouldCallClick(false);
    switch (paramopw.a())
    {
    }
    for (;;)
    {
      a(paramopw);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */