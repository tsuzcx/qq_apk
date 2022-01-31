package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import omu;
import pax;
import pqr;
import prb;
import pvb;
import pyn;
import pyo;
import qdt;
import qdv;

public class ComponentTopicItemSingle
  extends RelativeLayout
  implements pqr
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public pvb a;
  TextView b;
  
  public ComponentTopicItemSingle(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pvb = new pvb();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559886, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131364799));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.b = ((TextView)findViewById(2131365018));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      paramObject = (pax)paramObject;
      this.jdField_a_of_type_Pvb.a(paramObject);
      b();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mTopicRecommendFeedsInfo != null) && (paramObject.mTopicRecommendFeedsInfo.a != null) && (paramObject.mTopicRecommendFeedsInfo.a.size() != 0)) {}
    }
    else
    {
      return;
    }
    paramObject = (qdv)paramObject.mTopicRecommendFeedsInfo.a.get(0);
    try
    {
      Object localObject = new URL(paramObject.d);
      omu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.c + paramObject.a);
      localObject = String.format(getResources().getString(2131718580), new Object[] { bhvh.a(paramObject.jdField_b_of_type_Int) });
      this.b.setText((CharSequence)localObject);
      if (!TextUtils.isEmpty(paramObject.jdField_b_of_type_JavaLangString))
      {
        setOnClickListener(new pyn(this, paramObject));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        omu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, null, getContext());
        localMalformedURLException.printStackTrace();
      }
      setOnClickListener(new pyo(this));
    }
  }
  
  public void a(prb paramprb) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle
 * JD-Core Version:    0.7.0.1
 */