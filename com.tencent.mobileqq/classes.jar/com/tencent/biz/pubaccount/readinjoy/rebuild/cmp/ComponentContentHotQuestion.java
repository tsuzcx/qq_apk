package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.BorderTextView;
import java.util.List;
import omr;
import pau;
import pqo;
import pqy;
import puy;
import pvp;
import qbn;
import qbo;
import qbp;
import qbq;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements pqo
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pvp(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  public puy a;
  TextView b;
  
  public ComponentContentHotQuestion(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Puy = new puy();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559854, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367846));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131365700));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
    this.b = ((TextView)paramView.findViewById(2131370992));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajya.a(2131702289));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(Object paramObject)
  {
    b();
    ArticleInfo localArticleInfo;
    qbo localqbo;
    if ((paramObject instanceof pau))
    {
      paramObject = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(paramObject);
      localArticleInfo = paramObject.a();
      localqbo = (qbo)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localqbo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqbo.jdField_a_of_type_JavaLangString);
      }
      if ((localqbo.jdField_a_of_type_Qbp != null) && (!TextUtils.isEmpty(localqbo.jdField_a_of_type_Qbp.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqbo.jdField_a_of_type_Qbp.b);
      }
      if ((localqbo.jdField_a_of_type_Qbq != null) && (localqbo.jdField_a_of_type_Qbq.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder().append(bhvy.b(localqbo.jdField_a_of_type_Qbq.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(localqbo.jdField_a_of_type_Qbq.jdField_a_of_type_JavaLangString)) {
          break label240;
        }
        paramObject = ajya.a(2131702304);
        paramObject = paramObject;
        this.b.setText(paramObject);
      }
      if (TextUtils.isEmpty(localqbo.h)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localqbo.h);
    }
    label240:
    label251:
    do
    {
      return;
      paramObject = localqbo.jdField_a_of_type_Qbq.jdField_a_of_type_JavaLangString;
      break;
      if (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajya.a(2131702323));
        return;
      }
    } while (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 13);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajya.a(2131702255));
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = actj.a(150.0F, getResources());
    localLayoutParams.height = actj.a(150.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */