package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import aciy;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
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
import opw;
import owe;
import pey;
import pfh;
import prd;
import pre;
import rev;

public class PgcSmallView
  extends RelativeLayout
  implements pey
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
      int i = aciy.a(12.0F, paramContext.getResources());
      localLayoutParams.setMargins(i, 0, i, 0);
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(67.0F, paramContext.getResources()));
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
    opw localopw;
    if ((paramObject instanceof opw))
    {
      localopw = (opw)paramObject;
      if ((localopw.a() != 20) && (localopw.a() != 12) && (localopw.a() != 86) && (localopw.a() != 95))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a(paramObject);
        if ((this.jdField_a_of_type_Int != 74) && (this.jdField_a_of_type_Int != 75)) {
          break label223;
        }
        paramObject = owe.a(((opw)paramObject).a());
        if ((paramObject == null) || (!((Boolean)paramObject.first).booleanValue())) {
          break label205;
        }
        int i = aciy.a(50.0F, getContext().getResources());
        paramObject = new RelativeLayout.LayoutParams(i, i);
        paramObject.setMargins(0, 0, aciy.a(12.0F, getContext().getResources()), 0);
        paramObject.addRule(15);
        i = aciy.a(12.0F, getContext().getResources());
        paramObject.setMargins(i, 0, i, 0);
        paramObject.addRule(11);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(paramObject);
      }
    }
    while (localopw.a() == null)
    {
      return;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
      continue;
      label223:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
    }
    paramObject = new SpannableStringBuilder();
    a(localopw, paramObject);
    b(localopw, paramObject);
  }
  
  public void a(opw paramopw, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramopw == null) || (paramopw.a() == null)) {}
    do
    {
      return;
      if ((paramopw.a() == 10) || (paramopw.a() == 12))
      {
        paramSpannableStringBuilder.append("@");
        String str = paramopw.a().mSubscribeName;
        if (paramopw.a().mAccountLess == 0)
        {
          long l = a(paramopw.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new rev(l, "2", paramopw.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(": ");
          return;
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
      }
    } while ((paramopw.a() != 94) && (paramopw.a() != 95));
    paramSpannableStringBuilder.append("@");
    paramSpannableStringBuilder.append(paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prd.d);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
    paramSpannableStringBuilder.append(": ");
  }
  
  public void a(pfh parampfh) {}
  
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
      int i = aciy.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(aciy.a(96.0F, paramContext.getResources()), i);
      continue;
      i = aciy.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(aciy.a(96.0F, paramContext.getResources()), i);
      continue;
      i = aciy.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
      continue;
      i = aciy.a(67.0F, paramContext.getResources());
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
      setBackgroundResource(2130842236);
      continue;
      setBackgroundResource(2130842236);
      continue;
      setBackgroundResource(2130842236);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130844968);
      continue;
      setBackgroundResource(2130842236);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130844968);
    }
  }
  
  public void b(opw paramopw, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramopw == null) || (paramopw.a() == null)) {
      return;
    }
    int i = paramSpannableStringBuilder.length() - 2;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramopw.a().mTitle;
      if ((paramopw.a() != 94) && (paramopw.a() != 95)) {
        break label181;
      }
      localObject = paramopw.a().mSocialFeedInfo.jdField_a_of_type_Prd.b;
      label75:
      paramSpannableStringBuilder.append((CharSequence)localObject);
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      switch (paramopw.a())
      {
      }
    }
    for (paramopw = (opw)localObject;; paramopw = new ForegroundColorSpan(Color.parseColor("#606060")))
    {
      paramSpannableStringBuilder.setSpan(paramopw, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      label181:
      if ((paramopw.a() != 74) && (paramopw.a() != 75)) {
        break label75;
      }
      localObject = paramopw.a().mSocialFeedInfo.jdField_a_of_type_Pre.a;
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
      localLayoutParams.setMargins(aciy.a(12.0F, paramContext.getResources()), 0, aciy.a(12.0F, paramContext.getResources()), 0);
      return localLayoutParams;
    }
    localLayoutParams.setMargins(aciy.a(12.0F, paramContext.getResources()), 0, aciy.a(12.0F, paramContext.getResources()), 0);
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */