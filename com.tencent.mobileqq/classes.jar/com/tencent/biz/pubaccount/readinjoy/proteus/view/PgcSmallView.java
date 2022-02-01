package com.tencent.biz.pubaccount.readinjoy.proteus.view;

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
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.QuestionCardProteusItem;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ShareWebPageInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.text.UserSpan;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class PgcSmallView
  extends RelativeLayout
  implements ComponentView
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
      int i = AIOUtils.a(12.0F, paramContext.getResources());
      if (localLayoutParams != null) {
        localLayoutParams.setMargins(i, 0, i, 0);
      }
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(67.0F, paramContext.getResources()));
      continue;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(67.0F, paramContext.getResources()));
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
  
  public void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      if ((paramIReadInJoyModel.a() == 10) || (paramIReadInJoyModel.a() == 12))
      {
        paramSpannableStringBuilder.append("@");
        String str = paramIReadInJoyModel.a().mSubscribeName;
        if (paramIReadInJoyModel.a().mAccountLess == 0)
        {
          long l = a(paramIReadInJoyModel.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new UserSpan(l, "2", paramIReadInJoyModel.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        for (;;)
        {
          paramSpannableStringBuilder.append(": ");
          return;
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
      }
    } while ((paramIReadInJoyModel.a() != 94) && (paramIReadInJoyModel.a() != 95));
    paramSpannableStringBuilder.append("@");
    paramSpannableStringBuilder.append(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.d);
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
    paramSpannableStringBuilder.append(": ");
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    IReadInJoyModel localIReadInJoyModel;
    if ((paramObject instanceof IReadInJoyModel))
    {
      localIReadInJoyModel = (IReadInJoyModel)paramObject;
      if ((localIReadInJoyModel.a() != 20) && (localIReadInJoyModel.a() != 12) && (localIReadInJoyModel.a() != 86) && (localIReadInJoyModel.a() != 95))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a(paramObject);
        if ((this.jdField_a_of_type_Int != 74) && (this.jdField_a_of_type_Int != 75)) {
          break label223;
        }
        paramObject = QuestionCardProteusItem.a(((IReadInJoyModel)paramObject).a());
        if ((paramObject == null) || (!((Boolean)paramObject.first).booleanValue())) {
          break label205;
        }
        int i = AIOUtils.a(50.0F, getContext().getResources());
        paramObject = new RelativeLayout.LayoutParams(i, i);
        paramObject.setMargins(0, 0, AIOUtils.a(12.0F, getContext().getResources()), 0);
        paramObject.addRule(15);
        i = AIOUtils.a(12.0F, getContext().getResources());
        paramObject.setMargins(i, 0, i, 0);
        paramObject.addRule(11);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(paramObject);
      }
    }
    while (localIReadInJoyModel.a() == null)
    {
      return;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
      continue;
      label223:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.setLayoutParams(b(getContext()));
    }
    paramObject = new SpannableStringBuilder();
    a(localIReadInJoyModel, paramObject);
    b(localIReadInJoyModel, paramObject);
  }
  
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
      if (paramContext != null) {
        paramContext.addRule(11);
      }
      return paramContext;
      int i = AIOUtils.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(96.0F, paramContext.getResources()), i);
      continue;
      i = AIOUtils.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(96.0F, paramContext.getResources()), i);
      continue;
      i = AIOUtils.a(67.0F, paramContext.getResources());
      paramContext = new RelativeLayout.LayoutParams(i, i);
      continue;
      i = AIOUtils.a(67.0F, paramContext.getResources());
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
      setBackgroundResource(2130843084);
      continue;
      setBackgroundResource(2130843084);
      continue;
      setBackgroundResource(2130843084);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130846215);
      continue;
      setBackgroundResource(2130843084);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentSmall.a().setImageResource(2130846215);
    }
  }
  
  public void b(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {
      return;
    }
    int i = paramSpannableStringBuilder.length() - 2;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramIReadInJoyModel.a().mTitle;
      if ((paramIReadInJoyModel.a() != 94) && (paramIReadInJoyModel.a() != 95)) {
        break label189;
      }
      localObject = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.b;
      label75:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      switch (paramIReadInJoyModel.a())
      {
      }
    }
    for (paramIReadInJoyModel = (IReadInJoyModel)localObject;; paramIReadInJoyModel = new ForegroundColorSpan(Color.parseColor("#606060")))
    {
      paramSpannableStringBuilder.setSpan(paramIReadInJoyModel, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      i = 0;
      break;
      label189:
      if ((paramIReadInJoyModel.a() != 74) && (paramIReadInJoyModel.a() != 75)) {
        break label75;
      }
      localObject = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
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
      localLayoutParams.setMargins(AIOUtils.a(12.0F, paramContext.getResources()), 0, AIOUtils.a(12.0F, paramContext.getResources()), 0);
      return localLayoutParams;
    }
    localLayoutParams.setMargins(AIOUtils.a(12.0F, paramContext.getResources()), 0, AIOUtils.a(12.0F, paramContext.getResources()), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */