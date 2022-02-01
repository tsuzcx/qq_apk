package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import anni;
import bbzj;
import bdnt;
import bglf;
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
import pfa;
import pha;
import pxk;
import pyb;
import qlt;
import qva;
import rgy;
import rhn;
import rhs;
import rii;
import rik;
import snh;
import tfy;
import tkt;
import tku;
import tkv;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, tkv<CharSequence>
{
  qva jdField_a_of_type_Qva = new qva();
  private tku<CharSequence> jdField_a_of_type_Tku;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pyb parampyb)
  {
    int i = 0;
    String str = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaLangString;
    if (pha.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs))
    {
      a(paramArticleInfo, paramSpannableStringBuilder, parampyb);
      i = 4;
    }
    do
    {
      return i;
      if ((qva.c(paramArticleInfo)) && (!snh.q(paramArticleInfo))) {
        return 5;
      }
    } while (TextUtils.isEmpty(str));
    a(str, paramSpannableStringBuilder);
    return 6;
  }
  
  private static int a(ArticleInfo paramArticleInfo, pxk parampxk, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = snh.c(paramArticleInfo);
    if (parampxk.a().isPGCShortContent())
    {
      if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString))) {
        paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        paramSpannableStringBuilder.append(paramArticleInfo);
        return 7;
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          paramArticleInfo = paramArticleInfo.mTitle;
        } else {
          paramArticleInfo = "";
        }
      }
    }
    if ((35 == i) || (34 == i))
    {
      parampxk = new SpannableStringBuilder();
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString != null))
      {
        parampxk.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        paramSpannableStringBuilder.append(parampxk);
        return 1;
        if (paramArticleInfo.mTitle != null) {
          parampxk.append(paramArticleInfo.mTitle);
        }
      }
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {}
      for (parampxk = paramArticleInfo.mSummary;; parampxk = "")
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          parampxk = paramArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(parampxk);
        return 2;
      }
    }
    String str2 = parampxk.a().mSummary;
    if ((qva.f(parampxk)) || (qva.i(parampxk))) {
      str2 = parampxk.a().mTitle;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (parampxk.a() == 33) {
        str1 = anni.a(2131705863);
      }
    }
    else
    {
      paramSpannableStringBuilder.append(str1);
      if ((parampxk.a() == 33) && (!snh.l(paramArticleInfo)))
      {
        parampxk = (rik)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.get(0);
        paramSpannableStringBuilder = paramSpannableStringBuilder.append("“");
        if (!TextUtils.isEmpty(parampxk.c)) {
          break label524;
        }
        paramArticleInfo = "";
        label410:
        paramSpannableStringBuilder = paramSpannableStringBuilder.append(paramArticleInfo);
        if (!TextUtils.isEmpty(parampxk.jdField_a_of_type_JavaLangString)) {
          break label532;
        }
      }
    }
    label524:
    label532:
    for (paramArticleInfo = "";; paramArticleInfo = parampxk.jdField_a_of_type_JavaLangString)
    {
      paramSpannableStringBuilder.append(paramArticleInfo).append("”");
      return 3;
      if ((qva.e(parampxk)) || (qva.g(parampxk)) || (qva.h(parampxk)))
      {
        str1 = anni.a(2131705861);
        break;
      }
      if ((qva.f(parampxk)) || (qva.i(parampxk)))
      {
        str1 = anni.a(2131705859);
        break;
      }
      if (qva.a(parampxk))
      {
        str1 = anni.a(2131705860);
        break;
      }
      str1 = anni.a(2131705858);
      break;
      paramArticleInfo = parampxk.c;
      break label410;
    }
  }
  
  public static void a(int paramInt, pxk parampxk, SpannableStringBuilder paramSpannableStringBuilder, pyb parampyb)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = parampxk.a();
    if (!snh.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((snh.d((ArticleInfo)localObject)) || (snh.h((BaseArticleInfo)localObject)) || (snh.b(parampxk.a())) || (snh.a((BaseArticleInfo)localObject)))
    {
      localObject = parampxk.a().mSubscribeName;
      if ((parampxk.a() == 33) && (parampxk.a().mSocialFeedInfo != null) && (parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rii != null))
      {
        if (parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b == 0L)
        {
          parampyb = parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        try
        {
          l2 = Long.valueOf(parampyb).longValue();
          l1 = l2;
        }
        catch (NumberFormatException parampyb)
        {
          for (;;)
          {
            parampyb.printStackTrace();
          }
        }
        localSpannableStringBuilder.setSpan(new tfy(l1, "2", parampxk.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(": ");
      }
    }
    while ((!snh.f((ArticleInfo)localObject)) || (!snh.i((ArticleInfo)localObject))) {
      for (;;)
      {
        long l2;
        paramSpannableStringBuilder.append(new SpannableStringBuilder(new bdnt(localSpannableStringBuilder, 3, 16)));
        return;
        parampyb = String.valueOf(parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b);
        if (pha.a())
        {
          localObject = bglf.b((QQAppInterface)pha.a(), parampyb, true);
        }
        else
        {
          localObject = parampxk.a().b(parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b);
          continue;
          if (parampxk.a().mAccountLess == 0)
          {
            parampyb = parampxk.a().mSubscribeID;
            try
            {
              l2 = Long.valueOf(parampyb).longValue();
              l1 = l2;
            }
            catch (NumberFormatException parampyb)
            {
              for (;;)
              {
                parampyb.printStackTrace();
              }
            }
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.setSpan(new tfy(l1, "2", parampxk.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
            continue;
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
        }
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Long;
    parampyb = ReadInJoyUserInfoModule.a(l1, parampyb);
    if (parampyb != null) {}
    for (parampyb = parampyb.nick;; parampyb = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampyb))
      {
        localSpannableStringBuilder.append(pha.e(parampyb));
        localSpannableStringBuilder.setSpan(new tfy(l1, "2", parampxk.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      if (pha.p((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, ArticleInfo paramArticleInfo)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
      str = paramArticleInfo.mTitle;
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(str);
      return;
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {
        str = paramArticleInfo.mSummary;
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(anni.a(2131705862));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new qlt(this, paramArticleInfo, this.b));
    if ((pha.k(paramArticleInfo)) || (pha.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.b);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((pha.b(paramArticleInfo)) || (pha.c(paramArticleInfo)))
    {
      pha.a(paramContext, paramArticleInfo, 1, false, 4, false);
      snh.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      pha.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pyb parampyb)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Rgy.a(paramArticleInfo, "2", parampyb);
    if (!TextUtils.isEmpty(paramArticleInfo)) {
      paramSpannableStringBuilder.append(paramArticleInfo);
    }
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new bdnt(bbzj.b(paramString), 3, 16));
  }
  
  private void a(pxk parampxk)
  {
    if (parampxk.a() == null) {
      return;
    }
    this.jdField_a_of_type_Tku = parampxk.a().articleViewModel.b();
    this.jdField_a_of_type_Tku.a(this);
    setText((CharSequence)this.jdField_a_of_type_Tku.a());
    a(parampxk.a());
  }
  
  public static void a(pxk parampxk, SpannableStringBuilder paramSpannableStringBuilder, pyb parampyb)
  {
    ArticleInfo localArticleInfo = parampxk.a();
    int j = 0;
    if (pfa.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(parampxk);
    int i;
    if (snh.a(localArticleInfo))
    {
      a(paramSpannableStringBuilder, localArticleInfo);
      i = j;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      if ((snh.d(localArticleInfo)) || (snh.h(localArticleInfo)) || (snh.b(parampxk.a())))
      {
        i = a(localArticleInfo, parampxk, paramSpannableStringBuilder, bool);
      }
      else
      {
        i = j;
        if (snh.f(localArticleInfo))
        {
          i = j;
          if (snh.i(localArticleInfo)) {
            i = a(localArticleInfo, paramSpannableStringBuilder, parampyb);
          }
        }
      }
    }
  }
  
  private static boolean a(pxk parampxk)
  {
    if (parampxk != null) {}
    switch (parampxk.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void a(tku<CharSequence> paramtku)
  {
    paramtku = (CharSequence)paramtku.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramtku));
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
    if (this.jdField_a_of_type_Tku != null) {
      this.jdField_a_of_type_Tku.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Tku != null) {
      this.jdField_a_of_type_Tku.b(this);
    }
  }
  
  public void setModel(pxk parampxk)
  {
    this.jdField_a_of_type_Qva.a(parampxk);
    setShouldCallClick(false);
    switch (parampxk.a())
    {
    }
    for (;;)
    {
      a(parampxk);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */