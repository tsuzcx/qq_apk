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
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.MalformedURLException;
import java.net.URL;
import pjr;
import rbn;
import rbx;
import rjh;
import rji;
import rsj;

public class ComponentTopicItemMulti
  extends RelativeLayout
  implements rbn
{
  private int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  public rsj a;
  TextView b;
  
  public ComponentTopicItemMulti(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560192, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131365278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379001));
    this.b = ((TextView)findViewById(2131365513));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof rsj))
    {
      this.jdField_a_of_type_Rsj = ((rsj)paramObject);
      b();
    }
    try
    {
      paramObject = new URL(this.jdField_a_of_type_Rsj.d);
      pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramObject, getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rsj.c + this.jdField_a_of_type_Rsj.a);
      paramObject = String.format(getResources().getString(2131717907), new Object[] { bmhv.a(this.jdField_a_of_type_Rsj.jdField_b_of_type_Int) });
      this.b.setText(paramObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rsj.jdField_b_of_type_JavaLangString))
      {
        setOnClickListener(new rjh(this));
        return;
      }
    }
    catch (MalformedURLException paramObject)
    {
      for (;;)
      {
        pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, null, getContext());
        paramObject.printStackTrace();
      }
      setOnClickListener(new rji(this));
    }
  }
  
  public void a(rbx paramrbx) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setArticleInfo(ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti
 * JD-Core Version:    0.7.0.1
 */