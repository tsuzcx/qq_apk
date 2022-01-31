package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajyc;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import axas;
import ayki;
import bbcl;
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
import olc;
import omu;
import onk;
import pax;
import pbj;
import pnm;
import pvb;
import qcj;
import qcy;
import qdd;
import qdf;
import qdt;
import qdv;
import rap;
import rrl;
import rvn;
import rvo;
import rvp;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, rvp<CharSequence>
{
  pvb jdField_a_of_type_Pvb = new pvb();
  private rvo<CharSequence> jdField_a_of_type_Rvo;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(ajyc.a(2131707076));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new pnm(this, paramArticleInfo, -3355444));
    if ((onk.k(paramArticleInfo)) || (onk.l(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((onk.b(paramArticleInfo)) || (onk.c(paramArticleInfo)))
    {
      onk.a(paramContext, paramArticleInfo, 1, false, 4, false);
      rap.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      onk.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private void a(pax parampax)
  {
    if (parampax.a() == null) {
      return;
    }
    this.jdField_a_of_type_Rvo = parampax.a().articleViewModel.b();
    this.jdField_a_of_type_Rvo.a(this);
    setText((CharSequence)this.jdField_a_of_type_Rvo.a());
    a(parampax.a());
  }
  
  public static void a(pax parampax, SpannableStringBuilder paramSpannableStringBuilder, pbj parampbj)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = parampax.a();
    localSpannableStringBuilder.append("@");
    if ((rap.d((ArticleInfo)localObject)) || (rap.b((BaseArticleInfo)localObject)) || (rap.b(parampax.a())))
    {
      localObject = parampax.a().mSubscribeName;
      if ((parampax.a() == 33) && (parampax.a().mSocialFeedInfo != null) && (parampax.a().mSocialFeedInfo.jdField_a_of_type_Qdt != null)) {
        if (parampax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b == 0L)
        {
          parampbj = parampax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
      }
    }
    while ((!rap.f((ArticleInfo)localObject)) || (!rap.i((ArticleInfo)localObject))) {
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(parampbj).longValue();
          localSpannableStringBuilder.setSpan(new rrl(l1, "2", parampax.a()), 0, localSpannableStringBuilder.length(), 33);
          localSpannableStringBuilder.append(": ");
          paramSpannableStringBuilder.append(new SpannableStringBuilder(new ayki(localSpannableStringBuilder, 7, 16)));
          return;
          parampbj = String.valueOf(parampax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b);
          if (onk.a())
          {
            localObject = bbcl.b((QQAppInterface)onk.a(), parampbj, true);
            continue;
          }
          localObject = parampax.a().b(parampax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b);
        }
        catch (NumberFormatException parampbj)
        {
          parampbj.printStackTrace();
          l1 = 0L;
          continue;
        }
        if (parampax.a().mAccountLess == 0)
        {
          parampbj = parampax.a().mSubscribeID;
          try
          {
            long l2 = Long.valueOf(parampbj).longValue();
            l1 = l2;
          }
          catch (NumberFormatException parampbj)
          {
            for (;;)
            {
              parampbj.printStackTrace();
            }
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new rrl(l1, "2", parampax.a()), 0, localSpannableStringBuilder.length(), 33);
          continue;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long;
    parampbj = ReadInJoyUserInfoModule.a(l1, parampbj);
    if (parampbj != null) {}
    for (parampbj = parampbj.nick;; parampbj = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(parampbj))
      {
        localSpannableStringBuilder.append(onk.d(parampbj));
        localSpannableStringBuilder.setSpan(new rrl(l1, "2", parampax.a()), 0, localSpannableStringBuilder.length(), 33);
      }
      if (onk.p((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  public static void b(pax parampax, SpannableStringBuilder paramSpannableStringBuilder, pbj parampbj)
  {
    int j = 1;
    int k = 0;
    ArticleInfo localArticleInfo = parampax.a();
    if (olc.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    int i;
    switch (parampax.a())
    {
    default: 
      i = 0;
      if ((rap.d(localArticleInfo)) || (rap.b(localArticleInfo)) || (rap.b(parampax.a())))
      {
        k = rap.c(localArticleInfo);
        if (parampax.a().isPGCShortContent()) {
          if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString)))
          {
            parampax = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString;
            label194:
            paramSpannableStringBuilder.append(parampax);
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
        parampax = localArticleInfo.mTitle;
        break label194;
      }
      parampax = "";
      break label194;
      if ((35 == k) || (34 == k))
      {
        parampax = new SpannableStringBuilder();
        if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString != null))
        {
          parampax.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(parampax);
          i = j;
          break;
          if (localArticleInfo.mTitle != null) {
            parampax.append(localArticleInfo.mTitle);
          }
        }
      }
      if (i != 0)
      {
        if (!TextUtils.isEmpty(localArticleInfo.mSummary)) {}
        for (parampax = localArticleInfo.mSummary;; parampax = "")
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
            parampax = localArticleInfo.mTitle;
          }
          paramSpannableStringBuilder.append(parampax);
          i = 2;
          break;
        }
      }
      Object localObject = parampax.a().mSummary;
      if ((pvb.f(parampax)) || (pvb.i(parampax))) {
        localObject = parampax.a().mTitle;
      }
      parampbj = (pbj)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (parampax.a() == 33) {
          parampbj = ajyc.a(2131707077);
        }
      }
      else
      {
        label558:
        paramSpannableStringBuilder.append(parampbj);
        if ((parampax.a() == 33) && (!rap.f(localArticleInfo)))
        {
          parampbj = (qdv)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdt.jdField_a_of_type_JavaUtilArrayList.get(0);
          localObject = paramSpannableStringBuilder.append("“");
          if (!TextUtils.isEmpty(parampbj.c)) {
            break label745;
          }
          parampax = "";
          label624:
          localObject = ((SpannableStringBuilder)localObject).append(parampax);
          if (!TextUtils.isEmpty(parampbj.jdField_a_of_type_JavaLangString)) {
            break label753;
          }
        }
      }
      label745:
      label753:
      for (parampax = "";; parampax = parampbj.jdField_a_of_type_JavaLangString)
      {
        ((SpannableStringBuilder)localObject).append(parampax).append("”");
        i = 3;
        break;
        if ((pvb.e(parampax)) || (pvb.g(parampax)) || (pvb.h(parampax)))
        {
          parampbj = ajyc.a(2131707075);
          break label558;
        }
        if ((pvb.f(parampax)) || (pvb.i(parampax)))
        {
          parampbj = ajyc.a(2131707073);
          break label558;
        }
        if (pvb.a(parampax))
        {
          parampbj = ajyc.a(2131707074);
          break label558;
        }
        parampbj = ajyc.a(2131707072);
        break label558;
        parampax = parampbj.c;
        break label624;
      }
      i = k;
      if (rap.f(localArticleInfo))
      {
        i = k;
        if (rap.i(localArticleInfo))
        {
          parampax = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_JavaLangString;
          if (onk.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd))
          {
            parampax = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Qcj.a(localArticleInfo, "2", parampbj);
            if (!TextUtils.isEmpty(parampax)) {
              paramSpannableStringBuilder.append(parampax);
            }
            i = 4;
          }
          else if ((pvb.c(localArticleInfo)) && (!rap.q(localArticleInfo)))
          {
            parampax = ((qdf)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).e;
            if ((!TextUtils.isEmpty(parampax)) && (TextUtils.equals(omu.a(parampax), parampax))) {
              axas.b(parampax);
            }
            i = 5;
          }
          else
          {
            i = k;
            if (!TextUtils.isEmpty(parampax))
            {
              paramSpannableStringBuilder.append(new ayki(axas.b(parampax), 7, 16));
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void a(rvo<CharSequence> paramrvo)
  {
    paramrvo = (CharSequence)paramrvo.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramrvo));
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
    setShouldCallClick(false);
    switch (parampax.a())
    {
    }
    for (;;)
    {
      a(parampax);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */