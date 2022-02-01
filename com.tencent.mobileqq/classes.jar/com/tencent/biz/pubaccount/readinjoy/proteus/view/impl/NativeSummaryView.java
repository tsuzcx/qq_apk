package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import anvx;
import bcsc;
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
import pid;
import pkh;
import pnn;
import ppe;
import pqb;
import pqw;
import pqx;
import prg;
import qfw;
import qhl;
import qwi;
import rfw;
import rqw;
import rrl;
import rrq;
import rsh;
import rsj;
import szd;
import toa;
import ttb;
import ttc;
import ttd;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, ttd<CharSequence>
{
  rfw jdField_a_of_type_Rfw = new rfw();
  private ttc<CharSequence> jdField_a_of_type_Ttc;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, qhl paramqhl)
  {
    int i = 0;
    String str = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaLangString;
    if (pqw.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq))
    {
      a(paramArticleInfo, paramSpannableStringBuilder, paramqhl);
      i = 4;
    }
    do
    {
      return i;
      if ((rfw.c(paramArticleInfo)) && (!ppe.q(paramArticleInfo))) {
        return 5;
      }
    } while (TextUtils.isEmpty(str));
    a(str, paramSpannableStringBuilder);
    return 6;
  }
  
  private static int a(ArticleInfo paramArticleInfo, qfw paramqfw, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = ppe.a(paramArticleInfo);
    if (paramqfw.a().isPGCShortContent())
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
      for (paramqfw = paramArticleInfo.mSummary;; paramqfw = "")
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          paramqfw = paramArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(paramqfw);
        return 2;
      }
    }
    a(paramArticleInfo, paramSpannableStringBuilder, paramqfw);
    return 3;
  }
  
  private static String a(@NotNull qfw paramqfw)
  {
    if (paramqfw.a() == 33) {
      return anvx.a(2131706552);
    }
    if ((rfw.e(paramqfw)) || (rfw.g(paramqfw)) || (rfw.h(paramqfw))) {
      return anvx.a(2131706550);
    }
    if ((rfw.f(paramqfw)) || (rfw.i(paramqfw))) {
      return anvx.a(2131706548);
    }
    if (rfw.a(paramqfw)) {
      return anvx.a(2131706549);
    }
    return anvx.a(2131706547);
  }
  
  public static void a(int paramInt, qfw paramqfw, SpannableStringBuilder paramSpannableStringBuilder, qhl paramqhl)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramqfw.a();
    if (!ppe.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((ppe.d((ArticleInfo)localObject)) || (ppe.h((BaseArticleInfo)localObject)) || (ppe.a(paramqfw.a())) || (ppe.a((BaseArticleInfo)localObject)))
    {
      localObject = paramqfw.a().mSubscribeName;
      if ((paramqfw.a() == 33) && (paramqfw.a().mSocialFeedInfo != null) && (paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh != null))
      {
        if (paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b == 0L)
        {
          paramqhl = paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        try
        {
          l2 = Long.valueOf(paramqhl).longValue();
          l1 = l2;
        }
        catch (NumberFormatException paramqhl)
        {
          for (;;)
          {
            paramqhl.printStackTrace();
          }
        }
        localSpannableStringBuilder.setSpan(new toa(l1, "2", paramqfw.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(": ");
      }
    }
    while ((!ppe.f((ArticleInfo)localObject)) || (!ppe.i((ArticleInfo)localObject))) {
      for (;;)
      {
        long l2;
        paramSpannableStringBuilder.append(new SpannableStringBuilder(new QQText(localSpannableStringBuilder, 3, 16)));
        return;
        paramqhl = String.valueOf(paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b);
        if (pnn.a())
        {
          localObject = ContactUtils.getBuddyName((QQAppInterface)pkh.a(), paramqhl, true);
        }
        else
        {
          localObject = paramqfw.a().a(paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b);
          continue;
          if (paramqfw.a().mAccountLess == 0)
          {
            paramqhl = paramqfw.a().mSubscribeID;
            try
            {
              l2 = Long.valueOf(paramqhl).longValue();
              l1 = l2;
            }
            catch (NumberFormatException paramqhl)
            {
              for (;;)
              {
                paramqhl.printStackTrace();
              }
            }
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.setSpan(new toa(l1, "2", paramqfw.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
            continue;
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
        }
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long;
    paramqhl = ReadInJoyUserInfoModule.a(l1, paramqhl);
    if (paramqhl != null) {}
    for (paramqhl = paramqhl.nick;; paramqhl = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(paramqhl))
      {
        localSpannableStringBuilder.append(prg.a(paramqhl));
        localSpannableStringBuilder.setSpan(new toa(l1, "2", paramqfw.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      if (pqw.q((ArticleInfo)localObject)) {
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
      setSpanText(anvx.a(2131706551));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new qwi(this, paramArticleInfo, this.b));
    if ((pqw.l(paramArticleInfo)) || (pqw.m(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.b);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((pqw.c(paramArticleInfo)) || (pqw.d(paramArticleInfo)))
    {
      pqx.a(paramContext, paramArticleInfo, 1, false, 4, false);
      pqb.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      pqb.c(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString))) {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString;
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
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull qfw paramqfw)
  {
    String str1 = paramqfw.a().mSummary;
    if ((rfw.f(paramqfw)) || (rfw.i(paramqfw))) {
      str1 = paramqfw.a().mTitle;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = a(paramqfw);
    }
    paramSpannableStringBuilder.append(str2);
    if ((paramqfw.a() == 33) && (!ppe.l(paramArticleInfo)))
    {
      paramqfw = (rsj)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_a_of_type_JavaUtilArrayList.get(0);
      paramSpannableStringBuilder = paramSpannableStringBuilder.append("“");
      if (!TextUtils.isEmpty(paramqfw.c)) {
        break label146;
      }
      paramArticleInfo = "";
      paramSpannableStringBuilder = paramSpannableStringBuilder.append(paramArticleInfo);
      if (!TextUtils.isEmpty(paramqfw.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
    }
    label146:
    label154:
    for (paramArticleInfo = "";; paramArticleInfo = paramqfw.jdField_a_of_type_JavaLangString)
    {
      paramSpannableStringBuilder.append(paramArticleInfo).append("”");
      return;
      paramArticleInfo = paramqfw.c;
      break;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, qhl paramqhl)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Rqw.a(paramArticleInfo, "2", paramqhl);
    if (!TextUtils.isEmpty(paramArticleInfo)) {
      paramSpannableStringBuilder.append(paramArticleInfo);
    }
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new QQText(bcsc.b(paramString), 3, 16));
  }
  
  private void a(qfw paramqfw)
  {
    if (paramqfw.a() == null) {
      return;
    }
    this.jdField_a_of_type_Ttc = paramqfw.a().articleViewModel.b();
    this.jdField_a_of_type_Ttc.a(this);
    setText((CharSequence)this.jdField_a_of_type_Ttc.a());
    a(paramqfw.a());
  }
  
  public static void a(qfw paramqfw, SpannableStringBuilder paramSpannableStringBuilder, qhl paramqhl)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    int j = 0;
    if (pid.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(paramqfw);
    int i;
    if (ppe.a(localArticleInfo))
    {
      a(paramSpannableStringBuilder, localArticleInfo);
      i = j;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      if ((ppe.d(localArticleInfo)) || (ppe.h(localArticleInfo)) || (ppe.a(paramqfw.a())))
      {
        i = a(localArticleInfo, paramqfw, paramSpannableStringBuilder, bool);
      }
      else
      {
        i = j;
        if (ppe.f(localArticleInfo))
        {
          i = j;
          if (ppe.i(localArticleInfo)) {
            i = a(localArticleInfo, paramSpannableStringBuilder, paramqhl);
          }
        }
      }
    }
  }
  
  private static boolean a(qfw paramqfw)
  {
    if (paramqfw != null) {}
    switch (paramqfw.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString);
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
  
  public void a(ttc<CharSequence> paramttc)
  {
    paramttc = (CharSequence)paramttc.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramttc));
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
    setShouldCallClick(false);
    switch (paramqfw.a())
    {
    }
    for (;;)
    {
      a(paramqfw);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */