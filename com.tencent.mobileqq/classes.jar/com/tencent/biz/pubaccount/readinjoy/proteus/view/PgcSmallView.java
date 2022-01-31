package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import aekt;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.util.Pair;
import pgd;
import poe;
import pxk;
import pxt;
import qmv;
import qmw;
import shh;

public class PgcSmallView
  extends RelativeLayout
  implements pxk
{
  int jdField_a_of_type_Int;
  ComponentContentSmall jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  
  public PgcSmallView(int paramInt, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(paramContext);
    b(paramContext);
  }
  
  public long a(ArticleInfo paramArticleInfo)
  {
    try
    {
      long l = Long.parseLong(paramArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException paramArticleInfo) {}
    return 0L;
  }
  
  public RelativeLayout.LayoutParams a(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int i = aekt.a(12.0F, paramContext.getResources());
      localLayoutParams.setMargins(i, 0, i, 0);
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(67.0F, paramContext.getResources()));
    }
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(a(paramContext));
    Object localObject = b(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall = new ComponentContentSmall(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setId(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setScaleType(ImageView.ScaleType.FIT_XY);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall);
    localObject = c(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView);
  }
  
  public void a(Object paramObject)
  {
    pgd localpgd;
    if ((paramObject instanceof pgd))
    {
      localpgd = (pgd)paramObject;
      if ((localpgd.a() != 20) && (localpgd.a() != 12) && (localpgd.a() != 86) && (localpgd.a() != 95))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a(paramObject);
        if ((this.jdField_a_of_type_Int != 74) && (this.jdField_a_of_type_Int != 75)) {
          break label223;
        }
        paramObject = poe.a(((pgd)paramObject).a());
        if ((paramObject == null) || (!((Boolean)paramObject.first).booleanValue())) {
          break label205;
        }
        int i = aekt.a(50.0F, getContext().getResources());
        paramObject = new RelativeLayout.LayoutParams(i, i);
        paramObject.setMargins(0, 0, aekt.a(12.0F, getContext().getResources()), 0);
        paramObject.addRule(15);
        i = aekt.a(12.0F, getContext().getResources());
        paramObject.setMargins(i, 0, i, 0);
        paramObject.addRule(11);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(paramObject);
      }
    }
    while (localpgd.a() == null)
    {
      return;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
      continue;
      label223:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
    }
    paramObject = new SpannableStringBuilder();
    a(localpgd, paramObject);
    b(localpgd, paramObject);
  }
  
  public void a(pgd parampgd, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((parampgd == null) || (parampgd.a() == null)) {}
    do
    {
      return;
      if ((parampgd.a() == 10) || (parampgd.a() == 12))
      {
        paramSpannableStringBuilder.append("@");
        String str = parampgd.a().mSubscribeName;
        if (parampgd.a().mAccountLess == 0)
        {
          long l = a(parampgd.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new shh(l, "2", parampgd.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(": ");
          return;
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
      }
    } while ((parampgd.a() != 94) && (parampgd.a() != 95));
    paramSpannableStringBuilder.append("@");
    paramSpannableStringBuilder.append(parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qmv.d);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
    paramSpannableStringBuilder.append(": ");
  }
  
  public void a(pxt parampxt) {}
  
  public RelativeLayout.LayoutParams b(Context paramContext)
  {
    Object localObject = null;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.addRule(11);
      return paramContext;
      int i = aekt.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(aekt.a(96.0F, paramContext.getResources()), i);
      continue;
      i = aekt.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(aekt.a(96.0F, paramContext.getResources()), i);
      continue;
      i = aekt.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
      continue;
      i = aekt.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
    }
  }
  
  public void b(Context paramContext)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextSize(0, Utils.dp2px(16.0D));
      return;
      setBackgroundResource(2130842490);
      continue;
      setBackgroundResource(2130842490);
      continue;
      setBackgroundResource(2130842490);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845421);
      continue;
      setBackgroundResource(2130842490);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845421);
    }
  }
  
  public void b(pgd parampgd, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((parampgd == null) || (parampgd.a() == null)) {
      return;
    }
    int i = paramSpannableStringBuilder.length() - 2;
    Object localObject;
    if (i >= 0)
    {
      localObject = parampgd.a().mTitle;
      if ((parampgd.a() != 94) && (parampgd.a() != 95)) {
        break label189;
      }
      localObject = parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qmv.b;
      label75:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      switch (parampgd.a())
      {
      }
    }
    for (parampgd = (pgd)localObject;; parampgd = new ForegroundColorSpan(Color.parseColor("#606060")))
    {
      paramSpannableStringBuilder.setSpan(parampgd, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      label189:
      if ((parampgd.a() != 74) && (parampgd.a() != 75)) {
        break label75;
      }
      localObject = parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qmw.a;
      break label75;
    }
  }
  
  public RelativeLayout.LayoutParams c(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.getId());
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return localLayoutParams;
    case 16: 
    case 20: 
    case 83: 
    case 86: 
    case 132: 
      localLayoutParams.setMargins(aekt.a(12.0F, paramContext.getResources()), 0, aekt.a(12.0F, paramContext.getResources()), 0);
      return localLayoutParams;
    }
    localLayoutParams.setMargins(aekt.a(12.0F, paramContext.getResources()), 0, aekt.a(12.0F, paramContext.getResources()), 0);
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */