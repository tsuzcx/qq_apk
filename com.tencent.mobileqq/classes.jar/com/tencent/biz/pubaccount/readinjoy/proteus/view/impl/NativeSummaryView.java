package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import amtj;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import bblk;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import oyx;
import pay;
import pgb;
import pgw;
import pvc;
import pwf;
import qkd;
import qtr;
import rep;
import rfe;
import rfj;
import rga;
import rgc;
import slt;
import tas;
import tfp;
import tfq;
import tfr;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, tfr<CharSequence>
{
  qtr jdField_a_of_type_Qtr = new qtr();
  private tfq<CharSequence> jdField_a_of_type_Tfq;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pwf parampwf)
  {
    int i = 0;
    String str = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaLangString;
    if (pay.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj))
    {
      a(paramArticleInfo, paramSpannableStringBuilder, parampwf);
      i = 4;
    }
    do
    {
      return i;
      if ((qtr.c(paramArticleInfo)) && (!pgb.q(paramArticleInfo))) {
        return 5;
      }
    } while (TextUtils.isEmpty(str));
    a(str, paramSpannableStringBuilder);
    return 6;
  }
  
  private static int a(ArticleInfo paramArticleInfo, pvc parampvc, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = pgb.a(paramArticleInfo);
    if (parampvc.a().isPGCShortContent())
    {
      a(paramArticleInfo, paramSpannableStringBuilder);
      return 7;
    }
    if ((35 == i) || (34 == i))
    {
      b(paramArticleInfo, paramSpannableStringBuilder);
      return 1;
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {}
      for (parampvc = paramArticleInfo.mSummary;; parampvc = "")
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          parampvc = paramArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(parampvc);
        return 2;
      }
    }
    a(paramArticleInfo, paramSpannableStringBuilder, parampvc);
    return 3;
  }
  
  private static String a(@NotNull pvc parampvc)
  {
    if (parampvc.a() == 33) {
      return amtj.a(2131706200);
    }
    if ((qtr.e(parampvc)) || (qtr.g(parampvc)) || (qtr.h(parampvc))) {
      return amtj.a(2131706198);
    }
    if ((qtr.f(parampvc)) || (qtr.i(parampvc))) {
      return amtj.a(2131706196);
    }
    if (qtr.a(parampvc)) {
      return amtj.a(2131706197);
    }
    return amtj.a(2131706195);
  }
  
  public static void a(int paramInt, pvc parampvc, SpannableStringBuilder paramSpannableStringBuilder, pwf parampwf)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = parampvc.a();
    if (!pgb.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((pgb.d((ArticleInfo)localObject)) || (pgb.h((BaseArticleInfo)localObject)) || (pgb.a(parampvc.a())) || (pgb.a((BaseArticleInfo)localObject)))
    {
      localObject = parampvc.a().mSubscribeName;
      if ((parampvc.a() == 33) && (parampvc.a().mSocialFeedInfo != null) && (parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga != null))
      {
        if (parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b == 0L)
        {
          parampwf = parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        try
        {
          l2 = Long.valueOf(parampwf).longValue();
          l1 = l2;
        }
        catch (NumberFormatException parampwf)
        {
          for (;;)
          {
            parampwf.printStackTrace();
          }
        }
        localSpannableStringBuilder.setSpan(new tas(l1, "2", parampvc.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(": ");
      }
    }
    while ((!pgb.f((ArticleInfo)localObject)) || (!pgb.i((ArticleInfo)localObject))) {
      for (;;)
      {
        long l2;
        paramSpannableStringBuilder.append(new SpannableStringBuilder(new QQText(localSpannableStringBuilder, 3, 16)));
        return;
        parampwf = String.valueOf(parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b);
        if (pay.a())
        {
          localObject = ContactUtils.getBuddyName((QQAppInterface)pay.a(), parampwf, true);
        }
        else
        {
          localObject = parampvc.a().a(parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b);
          continue;
          if (parampvc.a().mAccountLess == 0)
          {
            parampwf = parampvc.a().mSubscribeID;
            try
            {
              l2 = Long.valueOf(parampwf).longValue();
              l1 = l2;
            }
            catch (NumberFormatException parampwf)
            {
              for (;;)
              {
                parampwf.printStackTrace();
              }
            }
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.setSpan(new tas(l1, "2", parampvc.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
            continue;
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
        }
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long;
    parampwf = ReadInJoyUserInfoModule.a(l1, parampwf);
    if (parampwf != null) {}
    for (parampwf = parampwf.nick;; parampwf = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampwf))
      {
        localSpannableStringBuilder.append(pay.e(parampwf));
        localSpannableStringBuilder.setSpan(new tas(l1, "2", parampvc.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      if (pay.q((ArticleInfo)localObject)) {
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
      setSpanText(amtj.a(2131706199));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new qkd(this, paramArticleInfo, this.b));
    if ((pay.l(paramArticleInfo)) || (pay.m(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.b);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((pay.c(paramArticleInfo)) || (pay.d(paramArticleInfo)))
    {
      pay.a(paramContext, paramArticleInfo, 1, false, 4, false);
      pgw.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      pay.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString))) {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(paramArticleInfo);
      return;
      if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mTitle))) {
        paramArticleInfo = paramArticleInfo.mTitle;
      } else {
        paramArticleInfo = "";
      }
    }
  }
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull pvc parampvc)
  {
    String str1 = parampvc.a().mSummary;
    if ((qtr.f(parampvc)) || (qtr.i(parampvc))) {
      str1 = parampvc.a().mTitle;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = a(parampvc);
    }
    paramSpannableStringBuilder.append(str2);
    if ((parampvc.a() == 33) && (!pgb.l(paramArticleInfo)))
    {
      parampvc = (rgc)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rga.jdField_a_of_type_JavaUtilArrayList.get(0);
      paramSpannableStringBuilder = paramSpannableStringBuilder.append("“");
      if (!TextUtils.isEmpty(parampvc.c)) {
        break label146;
      }
      paramArticleInfo = "";
      paramSpannableStringBuilder = paramSpannableStringBuilder.append(paramArticleInfo);
      if (!TextUtils.isEmpty(parampvc.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
    }
    label146:
    label154:
    for (paramArticleInfo = "";; paramArticleInfo = parampvc.jdField_a_of_type_JavaLangString)
    {
      paramSpannableStringBuilder.append(paramArticleInfo).append("”");
      return;
      paramArticleInfo = parampvc.c;
      break;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pwf parampwf)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Rep.a(paramArticleInfo, "2", parampwf);
    if (!TextUtils.isEmpty(paramArticleInfo)) {
      paramSpannableStringBuilder.append(paramArticleInfo);
    }
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new QQText(bblk.b(paramString), 3, 16));
  }
  
  private void a(pvc parampvc)
  {
    if (parampvc.a() == null) {
      return;
    }
    this.jdField_a_of_type_Tfq = parampvc.a().articleViewModel.b();
    this.jdField_a_of_type_Tfq.a(this);
    setText((CharSequence)this.jdField_a_of_type_Tfq.a());
    a(parampvc.a());
  }
  
  public static void a(pvc parampvc, SpannableStringBuilder paramSpannableStringBuilder, pwf parampwf)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    int j = 0;
    if (oyx.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(parampvc);
    int i;
    if (pgb.a(localArticleInfo))
    {
      a(paramSpannableStringBuilder, localArticleInfo);
      i = j;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      if ((pgb.d(localArticleInfo)) || (pgb.h(localArticleInfo)) || (pgb.a(parampvc.a())))
      {
        i = a(localArticleInfo, parampvc, paramSpannableStringBuilder, bool);
      }
      else
      {
        i = j;
        if (pgb.f(localArticleInfo))
        {
          i = j;
          if (pgb.i(localArticleInfo)) {
            i = a(localArticleInfo, paramSpannableStringBuilder, parampwf);
          }
        }
      }
    }
  }
  
  private static boolean a(pvc parampvc)
  {
    if (parampvc != null) {}
    switch (parampvc.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  public void a(tfq<CharSequence> paramtfq)
  {
    paramtfq = (CharSequence)paramtfq.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramtfq));
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
    setShouldCallClick(false);
    switch (parampvc.a())
    {
    }
    for (;;)
    {
      a(parampvc);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */