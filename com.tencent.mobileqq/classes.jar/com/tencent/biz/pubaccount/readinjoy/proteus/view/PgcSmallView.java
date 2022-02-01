package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import agej;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import ppu;
import pyi;
import qjg;
import qjp;
import qyk;
import qyl;
import sws;

public class PgcSmallView
  extends RelativeLayout
  implements qjg
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
      int i = agej.a(12.0F, paramContext.getResources());
      localLayoutParams.setMargins(i, 0, i, 0);
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, agej.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, agej.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, agej.a(67.0F, paramContext.getResources()));
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
    ppu localppu;
    if ((paramObject instanceof ppu))
    {
      localppu = (ppu)paramObject;
      if ((localppu.a() != 20) && (localppu.a() != 12) && (localppu.a() != 86) && (localppu.a() != 95))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a(paramObject);
        if ((this.jdField_a_of_type_Int != 74) && (this.jdField_a_of_type_Int != 75)) {
          break label223;
        }
        paramObject = pyi.a(((ppu)paramObject).a());
        if ((paramObject == null) || (!((Boolean)paramObject.first).booleanValue())) {
          break label205;
        }
        int i = agej.a(50.0F, getContext().getResources());
        paramObject = new RelativeLayout.LayoutParams(i, i);
        paramObject.setMargins(0, 0, agej.a(12.0F, getContext().getResources()), 0);
        paramObject.addRule(15);
        i = agej.a(12.0F, getContext().getResources());
        paramObject.setMargins(i, 0, i, 0);
        paramObject.addRule(11);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(paramObject);
      }
    }
    while (localppu.a() == null)
    {
      return;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
      continue;
      label223:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
    }
    paramObject = new SpannableStringBuilder();
    a(localppu, paramObject);
    b(localppu, paramObject);
  }
  
  public void a(ppu paramppu, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramppu == null) || (paramppu.a() == null)) {}
    do
    {
      return;
      if ((paramppu.a() == 10) || (paramppu.a() == 12))
      {
        paramSpannableStringBuilder.append("@");
        String str = paramppu.a().mSubscribeName;
        if (paramppu.a().mAccountLess == 0)
        {
          long l = a(paramppu.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new sws(l, "2", paramppu.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(": ");
          return;
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
      }
    } while ((paramppu.a() != 94) && (paramppu.a() != 95));
    paramSpannableStringBuilder.append("@");
    paramSpannableStringBuilder.append(paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qyk.d);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
    paramSpannableStringBuilder.append(": ");
  }
  
  public void a(qjp paramqjp) {}
  
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
      int i = agej.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(agej.a(96.0F, paramContext.getResources()), i);
      continue;
      i = agej.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(agej.a(96.0F, paramContext.getResources()), i);
      continue;
      i = agej.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
      continue;
      i = agej.a(67.0F, paramContext.getResources());
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
      setBackgroundResource(2130842843);
      continue;
      setBackgroundResource(2130842843);
      continue;
      setBackgroundResource(2130842843);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845906);
      continue;
      setBackgroundResource(2130842843);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130845906);
    }
  }
  
  public void b(ppu paramppu, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramppu == null) || (paramppu.a() == null)) {
      return;
    }
    int i = paramSpannableStringBuilder.length() - 2;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramppu.a().mTitle;
      if ((paramppu.a() != 94) && (paramppu.a() != 95)) {
        break label189;
      }
      localObject = paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qyk.b;
      label75:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      switch (paramppu.a())
      {
      }
    }
    for (paramppu = (ppu)localObject;; paramppu = new ForegroundColorSpan(Color.parseColor("#606060")))
    {
      paramSpannableStringBuilder.setSpan(paramppu, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      label189:
      if ((paramppu.a() != 74) && (paramppu.a() != 75)) {
        break label75;
      }
      localObject = paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qyl.a;
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
      localLayoutParams.setMargins(agej.a(12.0F, paramContext.getResources()), 0, agej.a(12.0F, paramContext.getResources()), 0);
      return localLayoutParams;
    }
    localLayoutParams.setMargins(agej.a(12.0F, paramContext.getResources()), 0, agej.a(12.0F, paramContext.getResources()), 0);
    return localLayoutParams;
  }
  
  public void setTitleCustomStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("PgcSmallView", 2, "setTitleCustomStyle | fontSize : " + paramInt1 + "; fontColor : " + paramInt2 + "; linkTextColor : " + paramInt3 + "; lineSpace : " + paramInt4);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView != null)
    {
      if (paramInt1 > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextSize(paramInt1);
      }
      if (paramInt2 > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(paramInt2);
      }
      if (paramInt3 > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLinkedTextColor(paramInt3);
      }
      if (paramInt4 > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLineSpacing(paramInt4, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */