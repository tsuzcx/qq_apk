package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, ComponentInheritView
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
  public ComponentContentUgcImage(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str2 = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.contains("https")) {
        str1 = str2.replaceFirst("https", "http");
      }
    }
    localArrayList.add(str1);
    TroopNoticeJsHandler.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969690, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367470));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367471));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      b();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.a.size() != 0)) {}
    }
    else
    {
      return;
    }
    String str = ((SocializeFeedsInfo.UGCPicInfo)paramObject.mSocialFeedInfo.a.a.get(0)).jdField_c_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "thumb url is " + str);
    }
    paramObject = str;
    if (!TextUtils.isEmpty(str))
    {
      paramObject = str;
      if (str.contains("https")) {
        paramObject = str.replaceFirst("https", "http");
      }
    }
    ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ReadInJoyUtils.b(paramObject), getContext());
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int j = AIOUtils.a(12.0F, getResources());
    int m = AIOUtils.a(4.5F, getResources());
    int k = (i - (j * 2 + m * 2)) / 3 * 2 + m;
    m = (i - (j * 2 + m)) / 2;
    float f3 = k;
    float f4 = k;
    j = 0;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a;
    float f2;
    float f1;
    if (((List)localObject).size() > 0)
    {
      f2 = ((SocializeFeedsInfo.UGCPicInfo)((List)localObject).get(0)).a;
      f1 = ((SocializeFeedsInfo.UGCPicInfo)((List)localObject).get(0)).jdField_b_of_type_Int;
      if (((SocializeFeedsInfo.UGCPicInfo)((List)localObject).get(0)).jdField_c_of_type_Int == 1)
      {
        i = 1;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        f1 = f2 / f1;
        if (f1 >= 0.455D) {
          break label405;
        }
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = k;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getText(2131428494));
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428496);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setPadding(0, 0, 0, 0);
      return;
      i = 0;
      break;
      i = j;
      f1 = f4;
      f2 = f3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ComponentContentUgcImage", 2, "ugc pic info is null");
      i = j;
      f1 = f4;
      f2 = f3;
      break;
      label405:
      if ((0.455D <= f1) && (f1 <= 0.7441D))
      {
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = k;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      else if ((0.7441D <= f1) && (f1 <= 1.3439D))
      {
        ((ViewGroup.LayoutParams)localObject).width = k;
        ((ViewGroup.LayoutParams)localObject).height = k;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      else if ((1.3439D <= f1) && (f1 <= 2.2D))
      {
        ((ViewGroup.LayoutParams)localObject).width = k;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).width = k;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getText(2131428494));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    c();
    ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */