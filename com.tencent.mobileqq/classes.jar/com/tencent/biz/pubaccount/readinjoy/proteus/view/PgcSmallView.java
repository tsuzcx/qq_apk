package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import actj;
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
import pau;
import pht;
import pqp;
import pqy;
import qcz;
import qda;
import rri;

public class PgcSmallView
  extends RelativeLayout
  implements pqp
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
      int i = actj.a(12.0F, paramContext.getResources());
      localLayoutParams.setMargins(i, 0, i, 0);
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(67.0F, paramContext.getResources()));
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
    pau localpau;
    if ((paramObject instanceof pau))
    {
      localpau = (pau)paramObject;
      if ((localpau.a() != 20) && (localpau.a() != 12) && (localpau.a() != 86) && (localpau.a() != 95))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a(paramObject);
        if ((this.jdField_a_of_type_Int != 74) && (this.jdField_a_of_type_Int != 75)) {
          break label223;
        }
        paramObject = pht.a(((pau)paramObject).a());
        if ((paramObject == null) || (!((Boolean)paramObject.first).booleanValue())) {
          break label205;
        }
        int i = actj.a(50.0F, getContext().getResources());
        paramObject = new RelativeLayout.LayoutParams(i, i);
        paramObject.setMargins(0, 0, actj.a(12.0F, getContext().getResources()), 0);
        paramObject.addRule(15);
        i = actj.a(12.0F, getContext().getResources());
        paramObject.setMargins(i, 0, i, 0);
        paramObject.addRule(11);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(paramObject);
      }
    }
    while (localpau.a() == null)
    {
      return;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
      continue;
      label223:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
    }
    paramObject = new SpannableStringBuilder();
    a(localpau, paramObject);
    b(localpau, paramObject);
  }
  
  public void a(pau parampau, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((parampau == null) || (parampau.a() == null)) {}
    do
    {
      return;
      if ((parampau.a() == 10) || (parampau.a() == 12))
      {
        paramSpannableStringBuilder.append("@");
        String str = parampau.a().mSubscribeName;
        if (parampau.a().mAccountLess == 0)
        {
          long l = a(parampau.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new rri(l, "2", parampau.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(": ");
          return;
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
      }
    } while ((parampau.a() != 94) && (parampau.a() != 95));
    paramSpannableStringBuilder.append("@");
    paramSpannableStringBuilder.append(parampau.a().mSocialFeedInfo.jdField_a_of_type_Qcz.d);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
    paramSpannableStringBuilder.append(": ");
  }
  
  public void a(pqy parampqy) {}
  
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
      int i = actj.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(actj.a(96.0F, paramContext.getResources()), i);
      continue;
      i = actj.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(actj.a(96.0F, paramContext.getResources()), i);
      continue;
      i = actj.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
      continue;
      i = actj.a(67.0F, paramContext.getResources());
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
      setBackgroundResource(2130842321);
      continue;
      setBackgroundResource(2130842321);
      continue;
      setBackgroundResource(2130842321);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845056);
      continue;
      setBackgroundResource(2130842321);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845056);
    }
  }
  
  public void b(pau parampau, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((parampau == null) || (parampau.a() == null)) {
      return;
    }
    int i = paramSpannableStringBuilder.length() - 2;
    Object localObject;
    if (i >= 0)
    {
      localObject = parampau.a().mTitle;
      if ((parampau.a() != 94) && (parampau.a() != 95)) {
        break label189;
      }
      localObject = parampau.a().mSocialFeedInfo.jdField_a_of_type_Qcz.b;
      label75:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      switch (parampau.a())
      {
      }
    }
    for (parampau = (pau)localObject;; parampau = new ForegroundColorSpan(Color.parseColor("#606060")))
    {
      paramSpannableStringBuilder.setSpan(parampau, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      label189:
      if ((parampau.a() != 74) && (parampau.a() != 75)) {
        break label75;
      }
      localObject = parampau.a().mSocialFeedInfo.jdField_a_of_type_Qda.a;
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
      localLayoutParams.setMargins(actj.a(12.0F, paramContext.getResources()), 0, actj.a(12.0F, paramContext.getResources()), 0);
      return localLayoutParams;
    }
    localLayoutParams.setMargins(actj.a(12.0F, paramContext.getResources()), 0, actj.a(12.0F, paramContext.getResources()), 0);
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */