package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajya;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import axau;
import aykk;
import bbcz;
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
import okz;
import omr;
import onh;
import pau;
import pbg;
import pnj;
import puy;
import qcg;
import qcv;
import qda;
import qdc;
import qdq;
import qds;
import ram;
import rri;
import rvk;
import rvl;
import rvm;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, rvm<CharSequence>
{
  puy jdField_a_of_type_Puy = new puy();
  private rvl<CharSequence> jdField_a_of_type_Rvl;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(ajya.a(2131707087));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new pnj(this, paramArticleInfo, -3355444));
    if ((onh.k(paramArticleInfo)) || (onh.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((onh.b(paramArticleInfo)) || (onh.c(paramArticleInfo)))
    {
      onh.a(paramContext, paramArticleInfo, 1, false, 4, false);
      ram.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      onh.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private void a(pau parampau)
  {
    if (parampau.a() == null) {
      return;
    }
    this.jdField_a_of_type_Rvl = parampau.a().articleViewModel.b();
    this.jdField_a_of_type_Rvl.a(this);
    setText((CharSequence)this.jdField_a_of_type_Rvl.a());
    a(parampau.a());
  }
  
  public static void a(pau parampau, SpannableStringBuilder paramSpannableStringBuilder, pbg parampbg)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = parampau.a();
    localSpannableStringBuilder.append("@");
    if ((ram.d((ArticleInfo)localObject)) || (ram.b((BaseArticleInfo)localObject)) || (ram.b(parampau.a())))
    {
      localObject = parampau.a().mSubscribeName;
      if ((parampau.a() == 33) && (parampau.a().mSocialFeedInfo != null) && (parampau.a().mSocialFeedInfo.jdField_a_of_type_Qdq != null)) {
        if (parampau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b == 0L)
        {
          parampbg = parampau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
      }
    }
    while ((!ram.f((ArticleInfo)localObject)) || (!ram.i((ArticleInfo)localObject))) {
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(parampbg).longValue();
          localSpannableStringBuilder.setSpan(new rri(l1, "2", parampau.a()), 0, localSpannableStringBuilder.length(), 33);
          localSpannableStringBuilder.append(": ");
          paramSpannableStringBuilder.append(new SpannableStringBuilder(new aykk(localSpannableStringBuilder, 7, 16)));
          return;
          parampbg = String.valueOf(parampau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b);
          if (onh.a())
          {
            localObject = bbcz.b((QQAppInterface)onh.a(), parampbg, true);
            continue;
          }
          localObject = parampau.a().b(parampau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b);
        }
        catch (NumberFormatException parampbg)
        {
          parampbg.printStackTrace();
          l1 = 0L;
          continue;
        }
        if (parampau.a().mAccountLess == 0)
        {
          parampbg = parampau.a().mSubscribeID;
          try
          {
            long l2 = Long.valueOf(parampbg).longValue();
            l1 = l2;
          }
          catch (NumberFormatException parampbg)
          {
            for (;;)
            {
              parampbg.printStackTrace();
            }
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new rri(l1, "2", parampau.a()), 0, localSpannableStringBuilder.length(), 33);
          continue;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
    parampbg = ReadInJoyUserInfoModule.a(l1, parampbg);
    if (parampbg != null) {}
    for (parampbg = parampbg.nick;; parampbg = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampbg))
      {
        localSpannableStringBuilder.append(onh.d(parampbg));
        localSpannableStringBuilder.setSpan(new rri(l1, "2", parampau.a()), 0, localSpannableStringBuilder.length(), 33);
      }
      if (onh.p((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  public static void b(pau parampau, SpannableStringBuilder paramSpannableStringBuilder, pbg parampbg)
  {
    int j = 1;
    int k = 0;
    ArticleInfo localArticleInfo = parampau.a();
    if (okz.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    int i;
    switch (parampau.a())
    {
    default: 
      i = 0;
      if ((ram.d(localArticleInfo)) || (ram.b(localArticleInfo)) || (ram.b(parampau.a())))
      {
        k = ram.c(localArticleInfo);
        if (parampau.a().isPGCShortContent()) {
          if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString)))
          {
            parampau = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString;
            label194:
            paramSpannableStringBuilder.append(parampau);
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
        parampau = localArticleInfo.mTitle;
        break label194;
      }
      parampau = "";
      break label194;
      if ((35 == k) || (34 == k))
      {
        parampau = new SpannableStringBuilder();
        if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString != null))
        {
          parampau.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(parampau);
          i = j;
          break;
          if (localArticleInfo.mTitle != null) {
            parampau.append(localArticleInfo.mTitle);
          }
        }
      }
      if (i != 0)
      {
        if (!TextUtils.isEmpty(localArticleInfo.mSummary)) {}
        for (parampau = localArticleInfo.mSummary;; parampau = "")
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
            parampau = localArticleInfo.mTitle;
          }
          paramSpannableStringBuilder.append(parampau);
          i = 2;
          break;
        }
      }
      Object localObject = parampau.a().mSummary;
      if ((puy.f(parampau)) || (puy.i(parampau))) {
        localObject = parampau.a().mTitle;
      }
      parampbg = (pbg)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (parampau.a() == 33) {
          parampbg = ajya.a(2131707088);
        }
      }
      else
      {
        label558:
        paramSpannableStringBuilder.append(parampbg);
        if ((parampau.a() == 33) && (!ram.f(localArticleInfo)))
        {
          parampbg = (qds)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(0);
          localObject = paramSpannableStringBuilder.append("“");
          if (!TextUtils.isEmpty(parampbg.c)) {
            break label745;
          }
          parampau = "";
          label624:
          localObject = ((SpannableStringBuilder)localObject).append(parampau);
          if (!TextUtils.isEmpty(parampbg.jdField_a_of_type_JavaLangString)) {
            break label753;
          }
        }
      }
      label745:
      label753:
      for (parampau = "";; parampau = parampbg.jdField_a_of_type_JavaLangString)
      {
        ((SpannableStringBuilder)localObject).append(parampau).append("”");
        i = 3;
        break;
        if ((puy.e(parampau)) || (puy.g(parampau)) || (puy.h(parampau)))
        {
          parampbg = ajya.a(2131707086);
          break label558;
        }
        if ((puy.f(parampau)) || (puy.i(parampau)))
        {
          parampbg = ajya.a(2131707084);
          break label558;
        }
        if (puy.a(parampau))
        {
          parampbg = ajya.a(2131707085);
          break label558;
        }
        parampbg = ajya.a(2131707083);
        break label558;
        parampau = parampbg.c;
        break label624;
      }
      i = k;
      if (ram.f(localArticleInfo))
      {
        i = k;
        if (ram.i(localArticleInfo))
        {
          parampau = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString;
          if (onh.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda))
          {
            parampau = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.a(localArticleInfo, "2", parampbg);
            if (!TextUtils.isEmpty(parampau)) {
              paramSpannableStringBuilder.append(parampau);
            }
            i = 4;
          }
          else if ((puy.c(localArticleInfo)) && (!ram.q(localArticleInfo)))
          {
            parampau = ((qdc)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).e;
            if ((!TextUtils.isEmpty(parampau)) && (TextUtils.equals(omr.a(parampau), parampau))) {
              axau.b(parampau);
            }
            i = 5;
          }
          else
          {
            i = k;
            if (!TextUtils.isEmpty(parampau))
            {
              paramSpannableStringBuilder.append(new aykk(axau.b(parampau), 7, 16));
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void a(rvl<CharSequence> paramrvl)
  {
    paramrvl = (CharSequence)paramrvl.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramrvl));
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
    if (this.jdField_a_of_type_Rvl != null) {
      this.jdField_a_of_type_Rvl.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Rvl != null) {
      this.jdField_a_of_type_Rvl.b(this);
    }
  }
  
  public void setModel(pau parampau)
  {
    this.jdField_a_of_type_Puy.a(parampau);
    setShouldCallClick(false);
    switch (parampau.a())
    {
    }
    for (;;)
    {
      a(parampau);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */