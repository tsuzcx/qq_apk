package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aepi;
import alud;
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
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.BorderTextView;
import java.util.List;
import orc;
import pgd;
import pxj;
import pxt;
import qbs;
import qcj;
import qlj;
import qlk;
import qll;
import qlm;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements pxj
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new qcj(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  public qbs a;
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
    this.jdField_a_of_type_Qbs = new qbs();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559948, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367992));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131365786));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377938));
    this.b = ((TextView)paramView.findViewById(2131371323));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(alud.a(2131702673));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(Object paramObject)
  {
    b();
    ArticleInfo localArticleInfo;
    qlk localqlk;
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
      localArticleInfo = paramObject.a();
      localqlk = (qlk)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localqlk.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqlk.jdField_a_of_type_JavaLangString);
      }
      if ((localqlk.jdField_a_of_type_Qll != null) && (!TextUtils.isEmpty(localqlk.jdField_a_of_type_Qll.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqlk.jdField_a_of_type_Qll.b);
      }
      if ((localqlk.jdField_a_of_type_Qlm != null) && (localqlk.jdField_a_of_type_Qlm.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder().append(bkbq.b(localqlk.jdField_a_of_type_Qlm.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(localqlk.jdField_a_of_type_Qlm.jdField_a_of_type_JavaLangString)) {
          break label240;
        }
        paramObject = alud.a(2131702688);
        paramObject = paramObject;
        this.b.setText(paramObject);
      }
      if (TextUtils.isEmpty(localqlk.h)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localqlk.h);
    }
    label240:
    label251:
    do
    {
      return;
      paramObject = localqlk.jdField_a_of_type_Qlm.jdField_a_of_type_JavaLangString;
      break;
      if (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(alud.a(2131702707));
        return;
      }
    } while (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 13);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(alud.a(2131702639));
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = aepi.a(150.0F, getResources());
    localLayoutParams.height = aepi.a(150.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */