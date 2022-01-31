package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import alud;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import azah;
import bamp;
import bdgc;
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
import opj;
import orc;
import ors;
import pgd;
import pgr;
import ptr;
import qbs;
import qmc;
import qmr;
import qmw;
import qmy;
import qnm;
import qno;
import rqj;
import shh;
import slx;
import sly;
import slz;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, slz<CharSequence>
{
  qbs jdField_a_of_type_Qbs = new qbs();
  private sly<CharSequence> jdField_a_of_type_Sly;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(alud.a(2131707471));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new ptr(this, paramArticleInfo, -3355444));
    if ((ors.k(paramArticleInfo)) || (ors.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((ors.b(paramArticleInfo)) || (ors.c(paramArticleInfo)))
    {
      ors.a(paramContext, paramArticleInfo, 1, false, 4, false);
      rqj.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      ors.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private void a(pgd parampgd)
  {
    if (parampgd.a() == null) {
      return;
    }
    this.jdField_a_of_type_Sly = parampgd.a().articleViewModel.b();
    this.jdField_a_of_type_Sly.a(this);
    setText((CharSequence)this.jdField_a_of_type_Sly.a());
    a(parampgd.a());
  }
  
  public static void a(pgd parampgd, SpannableStringBuilder paramSpannableStringBuilder, pgr parampgr)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = parampgd.a();
    if (!rqj.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((rqj.d((ArticleInfo)localObject)) || (rqj.c((BaseArticleInfo)localObject)) || (rqj.b(parampgd.a())) || (rqj.a((BaseArticleInfo)localObject)))
    {
      localObject = parampgd.a().mSubscribeName;
      if ((parampgd.a() == 33) && (parampgd.a().mSocialFeedInfo != null) && (parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm != null)) {
        if (parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b == 0L)
        {
          parampgr = parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
      }
    }
    while ((!rqj.f((ArticleInfo)localObject)) || (!rqj.i((ArticleInfo)localObject))) {
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(parampgr).longValue();
          localSpannableStringBuilder.setSpan(new shh(l1, "2", parampgd.a()), 0, localSpannableStringBuilder.length(), 33);
          localSpannableStringBuilder.append(": ");
          paramSpannableStringBuilder.append(new SpannableStringBuilder(new bamp(localSpannableStringBuilder, 3, 16)));
          return;
          parampgr = String.valueOf(parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b);
          if (ors.a())
          {
            localObject = bdgc.b((QQAppInterface)ors.a(), parampgr, true);
            continue;
          }
          localObject = parampgd.a().b(parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b);
        }
        catch (NumberFormatException parampgr)
        {
          parampgr.printStackTrace();
          l1 = 0L;
          continue;
        }
        if (parampgd.a().mAccountLess == 0)
        {
          parampgr = parampgd.a().mSubscribeID;
          try
          {
            long l2 = Long.valueOf(parampgr).longValue();
            l1 = l2;
          }
          catch (NumberFormatException parampgr)
          {
            for (;;)
            {
              parampgr.printStackTrace();
            }
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new shh(l1, "2", parampgd.a()), 0, localSpannableStringBuilder.length(), 33);
          continue;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long;
    parampgr = ReadInJoyUserInfoModule.a(l1, parampgr);
    if (parampgr != null) {}
    for (parampgr = parampgr.nick;; parampgr = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampgr))
      {
        localSpannableStringBuilder.append(ors.d(parampgr));
        localSpannableStringBuilder.setSpan(new shh(l1, "2", parampgd.a()), 0, localSpannableStringBuilder.length(), 33);
      }
      if (ors.p((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  public static void b(pgd parampgd, SpannableStringBuilder paramSpannableStringBuilder, pgr parampgr)
  {
    int j = 1;
    int k = 0;
    ArticleInfo localArticleInfo = parampgd.a();
    if (opj.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    int i;
    switch (parampgd.a())
    {
    default: 
      i = 0;
      if (rqj.a(localArticleInfo))
      {
        parampgd = "";
        if (!TextUtils.isEmpty(localArticleInfo.mTitle))
        {
          parampgd = localArticleInfo.mTitle;
          label122:
          paramSpannableStringBuilder.append(parampgd);
          i = k;
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
      if (TextUtils.isEmpty(localArticleInfo.mSummary)) {
        break label122;
      }
      parampgd = localArticleInfo.mSummary;
      break label122;
      if ((rqj.d(localArticleInfo)) || (rqj.c(localArticleInfo)) || (rqj.b(parampgd.a())))
      {
        k = rqj.c(localArticleInfo);
        if (parampgd.a().isPGCShortContent())
        {
          i = 7;
          if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString))) {
            parampgd = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            paramSpannableStringBuilder.append(parampgd);
            break;
            if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
              parampgd = localArticleInfo.mTitle;
            } else {
              parampgd = "";
            }
          }
        }
        if ((35 == k) || (34 == k))
        {
          parampgd = new SpannableStringBuilder();
          if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString != null))
          {
            parampgd.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString);
            }
          }
          for (;;)
          {
            paramSpannableStringBuilder.append(parampgd);
            i = j;
            break;
            if (localArticleInfo.mTitle != null) {
              parampgd.append(localArticleInfo.mTitle);
            }
          }
        }
        if (i != 0)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mSummary)) {}
          for (parampgd = localArticleInfo.mSummary;; parampgd = "")
          {
            if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
              parampgd = localArticleInfo.mTitle;
            }
            paramSpannableStringBuilder.append(parampgd);
            i = 2;
            break;
          }
        }
        Object localObject = parampgd.a().mSummary;
        if ((qbs.f(parampgd)) || (qbs.i(parampgd))) {
          localObject = parampgd.a().mTitle;
        }
        parampgr = (pgr)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (parampgd.a() == 33) {
            parampgr = alud.a(2131707472);
          }
        }
        else
        {
          label618:
          paramSpannableStringBuilder.append(parampgr);
          if ((parampgd.a() == 33) && (!rqj.g(localArticleInfo)))
          {
            parampgr = (qno)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm.jdField_a_of_type_JavaUtilArrayList.get(0);
            localObject = paramSpannableStringBuilder.append("“");
            if (!TextUtils.isEmpty(parampgr.c)) {
              break label805;
            }
            parampgd = "";
            label684:
            localObject = ((SpannableStringBuilder)localObject).append(parampgd);
            if (!TextUtils.isEmpty(parampgr.jdField_a_of_type_JavaLangString)) {
              break label813;
            }
          }
        }
        label805:
        label813:
        for (parampgd = "";; parampgd = parampgr.jdField_a_of_type_JavaLangString)
        {
          ((SpannableStringBuilder)localObject).append(parampgd).append("”");
          i = 3;
          break;
          if ((qbs.e(parampgd)) || (qbs.g(parampgd)) || (qbs.h(parampgd)))
          {
            parampgr = alud.a(2131707470);
            break label618;
          }
          if ((qbs.f(parampgd)) || (qbs.i(parampgd)))
          {
            parampgr = alud.a(2131707468);
            break label618;
          }
          if (qbs.a(parampgd))
          {
            parampgr = alud.a(2131707469);
            break label618;
          }
          parampgr = alud.a(2131707467);
          break label618;
          parampgd = parampgr.c;
          break label684;
        }
      }
      i = k;
      if (rqj.f(localArticleInfo))
      {
        i = k;
        if (rqj.i(localArticleInfo))
        {
          parampgd = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaLangString;
          if (ors.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw))
          {
            parampgd = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.a(localArticleInfo, "2", parampgr);
            if (!TextUtils.isEmpty(parampgd)) {
              paramSpannableStringBuilder.append(parampgd);
            }
            i = 4;
          }
          else if ((qbs.c(localArticleInfo)) && (!rqj.q(localArticleInfo)))
          {
            parampgd = ((qmy)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).e;
            if ((!TextUtils.isEmpty(parampgd)) && (TextUtils.equals(orc.a(parampgd), parampgd))) {
              azah.b(parampgd);
            }
            i = 5;
          }
          else
          {
            i = k;
            if (!TextUtils.isEmpty(parampgd))
            {
              paramSpannableStringBuilder.append(new bamp(azah.b(parampgd), 3, 16));
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void a(sly<CharSequence> paramsly)
  {
    paramsly = (CharSequence)paramsly.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramsly));
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
    setShouldCallClick(false);
    switch (parampgd.a())
    {
    }
    for (;;)
    {
      a(parampgd);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */