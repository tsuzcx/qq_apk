package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import anzj;
import bcsa;
import begp;
import bhlg;
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
import oxs;
import ozs;
import ppu;
import pql;
import qef;
import qno;
import qxr;
import qyg;
import qyl;
import qzb;
import qzd;
import sel;
import sws;
import tbm;
import tbn;
import tbo;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, tbo<CharSequence>
{
  qno jdField_a_of_type_Qno = new qno();
  private tbn<CharSequence> jdField_a_of_type_Tbn;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pql parampql)
  {
    int i = 0;
    String str = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaLangString;
    if (ozs.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl))
    {
      a(paramArticleInfo, paramSpannableStringBuilder, parampql);
      i = 4;
    }
    do
    {
      return i;
      if ((qno.c(paramArticleInfo)) && (!sel.q(paramArticleInfo))) {
        return 5;
      }
    } while (TextUtils.isEmpty(str));
    a(str, paramSpannableStringBuilder);
    return 6;
  }
  
  private static int a(ArticleInfo paramArticleInfo, ppu paramppu, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = sel.c(paramArticleInfo);
    if (paramppu.a().isPGCShortContent())
    {
      if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString))) {
        paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString;
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
      paramppu = new SpannableStringBuilder();
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString != null))
      {
        paramppu.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        paramSpannableStringBuilder.append(paramppu);
        return 1;
        if (paramArticleInfo.mTitle != null) {
          paramppu.append(paramArticleInfo.mTitle);
        }
      }
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {}
      for (paramppu = paramArticleInfo.mSummary;; paramppu = "")
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          paramppu = paramArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(paramppu);
        return 2;
      }
    }
    String str2 = paramppu.a().mSummary;
    if ((qno.f(paramppu)) || (qno.i(paramppu))) {
      str2 = paramppu.a().mTitle;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramppu.a() == 33) {
        str1 = anzj.a(2131705970);
      }
    }
    else
    {
      paramSpannableStringBuilder.append(str1);
      if ((paramppu.a() == 33) && (!sel.l(paramArticleInfo)))
      {
        paramppu = (qzd)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb.jdField_a_of_type_JavaUtilArrayList.get(0);
        paramSpannableStringBuilder = paramSpannableStringBuilder.append("“");
        if (!TextUtils.isEmpty(paramppu.c)) {
          break label524;
        }
        paramArticleInfo = "";
        label410:
        paramSpannableStringBuilder = paramSpannableStringBuilder.append(paramArticleInfo);
        if (!TextUtils.isEmpty(paramppu.jdField_a_of_type_JavaLangString)) {
          break label532;
        }
      }
    }
    label524:
    label532:
    for (paramArticleInfo = "";; paramArticleInfo = paramppu.jdField_a_of_type_JavaLangString)
    {
      paramSpannableStringBuilder.append(paramArticleInfo).append("”");
      return 3;
      if ((qno.e(paramppu)) || (qno.g(paramppu)) || (qno.h(paramppu)))
      {
        str1 = anzj.a(2131705968);
        break;
      }
      if ((qno.f(paramppu)) || (qno.i(paramppu)))
      {
        str1 = anzj.a(2131705966);
        break;
      }
      if (qno.a(paramppu))
      {
        str1 = anzj.a(2131705967);
        break;
      }
      str1 = anzj.a(2131705965);
      break;
      paramArticleInfo = paramppu.c;
      break label410;
    }
  }
  
  public static void a(int paramInt, ppu paramppu, SpannableStringBuilder paramSpannableStringBuilder, pql parampql)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramppu.a();
    if (!sel.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((sel.d((ArticleInfo)localObject)) || (sel.h((BaseArticleInfo)localObject)) || (sel.b(paramppu.a())) || (sel.a((BaseArticleInfo)localObject)))
    {
      localObject = paramppu.a().mSubscribeName;
      if ((paramppu.a() == 33) && (paramppu.a().mSocialFeedInfo != null) && (paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb != null))
      {
        if (paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b == 0L)
        {
          parampql = paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        try
        {
          l2 = Long.valueOf(parampql).longValue();
          l1 = l2;
        }
        catch (NumberFormatException parampql)
        {
          for (;;)
          {
            parampql.printStackTrace();
          }
        }
        localSpannableStringBuilder.setSpan(new sws(l1, "2", paramppu.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(": ");
      }
    }
    while ((!sel.f((ArticleInfo)localObject)) || (!sel.i((ArticleInfo)localObject))) {
      for (;;)
      {
        long l2;
        paramSpannableStringBuilder.append(new SpannableStringBuilder(new begp(localSpannableStringBuilder, 3, 16)));
        return;
        parampql = String.valueOf(paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b);
        if (ozs.a())
        {
          localObject = bhlg.b((QQAppInterface)ozs.a(), parampql, true);
        }
        else
        {
          localObject = paramppu.a().b(paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b);
          continue;
          if (paramppu.a().mAccountLess == 0)
          {
            parampql = paramppu.a().mSubscribeID;
            try
            {
              l2 = Long.valueOf(parampql).longValue();
              l1 = l2;
            }
            catch (NumberFormatException parampql)
            {
              for (;;)
              {
                parampql.printStackTrace();
              }
            }
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.setSpan(new sws(l1, "2", paramppu.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
            continue;
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
        }
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long;
    parampql = ReadInJoyUserInfoModule.a(l1, parampql);
    if (parampql != null) {}
    for (parampql = parampql.nick;; parampql = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampql))
      {
        localSpannableStringBuilder.append(ozs.e(parampql));
        localSpannableStringBuilder.setSpan(new sws(l1, "2", paramppu.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      if (ozs.p((ArticleInfo)localObject)) {
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
      setSpanText(anzj.a(2131705969));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new qef(this, paramArticleInfo, this.b));
    if ((ozs.k(paramArticleInfo)) || (ozs.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.b);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((ozs.b(paramArticleInfo)) || (ozs.c(paramArticleInfo)))
    {
      ozs.a(paramContext, paramArticleInfo, 1, false, 4, false);
      sel.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      ozs.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, pql parampql)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Qxr.a(paramArticleInfo, "2", parampql);
    if (!TextUtils.isEmpty(paramArticleInfo)) {
      paramSpannableStringBuilder.append(paramArticleInfo);
    }
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new begp(bcsa.b(paramString), 3, 16));
  }
  
  private void a(ppu paramppu)
  {
    if (paramppu.a() == null) {
      return;
    }
    this.jdField_a_of_type_Tbn = paramppu.a().articleViewModel.b();
    this.jdField_a_of_type_Tbn.a(this);
    setText((CharSequence)this.jdField_a_of_type_Tbn.a());
    a(paramppu.a());
  }
  
  public static void a(ppu paramppu, SpannableStringBuilder paramSpannableStringBuilder, pql parampql)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    int j = 0;
    if (oxs.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(paramppu);
    int i;
    if (sel.a(localArticleInfo))
    {
      a(paramSpannableStringBuilder, localArticleInfo);
      i = j;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      if ((sel.d(localArticleInfo)) || (sel.h(localArticleInfo)) || (sel.b(paramppu.a())))
      {
        i = a(localArticleInfo, paramppu, paramSpannableStringBuilder, bool);
      }
      else
      {
        i = j;
        if (sel.f(localArticleInfo))
        {
          i = j;
          if (sel.i(localArticleInfo)) {
            i = a(localArticleInfo, paramSpannableStringBuilder, parampql);
          }
        }
      }
    }
  }
  
  private static boolean a(ppu paramppu)
  {
    if (paramppu != null) {}
    switch (paramppu.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void a(tbn<CharSequence> paramtbn)
  {
    paramtbn = (CharSequence)paramtbn.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramtbn));
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
    setShouldCallClick(false);
    switch (paramppu.a())
    {
    }
    for (;;)
    {
      a(paramppu);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */