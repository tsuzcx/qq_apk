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
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import orc;
import pgd;
import pxj;
import pxt;
import qbs;
import qfe;
import qff;
import qnm;
import qno;

public class ComponentTopicItemSingle
  extends RelativeLayout
  implements pxj
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public qbs a;
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
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559981, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131364879));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377884));
    this.b = ((TextView)findViewById(2131365102));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
      b();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mTopicRecommendFeedsInfo != null) && (paramObject.mTopicRecommendFeedsInfo.a != null) && (paramObject.mTopicRecommendFeedsInfo.a.size() != 0)) {}
    }
    else
    {
      return;
    }
    paramObject = (qno)paramObject.mTopicRecommendFeedsInfo.a.get(0);
    try
    {
      Object localObject = new URL(paramObject.d);
      orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.c + paramObject.a);
      localObject = String.format(getResources().getString(2131719051), new Object[] { bjxj.a(paramObject.jdField_b_of_type_Int) });
      this.b.setText((CharSequence)localObject);
      if (!TextUtils.isEmpty(paramObject.jdField_b_of_type_JavaLangString))
      {
        setOnClickListener(new qfe(this, paramObject));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, null, getContext());
        localMalformedURLException.printStackTrace();
      }
      setOnClickListener(new qff(this));
    }
  }
  
  public void a(pxt parampxt) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle
 * JD-Core Version:    0.7.0.1
 */