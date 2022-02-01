package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
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
import anzj;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.BorderTextView;
import java.util.List;
import ozc;
import ppu;
import qjf;
import qjp;
import qno;
import qof;
import qwo;
import qwp;
import qwq;
import qwr;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements qjf
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new qof(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  public qno a;
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
    this.jdField_a_of_type_Qno = new qno();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560107, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368391));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131366076));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
    this.b = ((TextView)paramView.findViewById(2131372002));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anzj.a(2131701200));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(Object paramObject)
  {
    b();
    ArticleInfo localArticleInfo;
    qwp localqwp;
    if ((paramObject instanceof ppu))
    {
      paramObject = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(paramObject);
      localArticleInfo = paramObject.a();
      localqwp = (qwp)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      ozc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localqwp.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqwp.jdField_a_of_type_JavaLangString);
      }
      if ((localqwp.jdField_a_of_type_Qwq != null) && (!TextUtils.isEmpty(localqwp.jdField_a_of_type_Qwq.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqwp.jdField_a_of_type_Qwq.b);
      }
      if ((localqwp.jdField_a_of_type_Qwr != null) && (localqwp.jdField_a_of_type_Qwr.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder().append(bnrf.b(localqwp.jdField_a_of_type_Qwr.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(localqwp.jdField_a_of_type_Qwr.jdField_a_of_type_JavaLangString)) {
          break label240;
        }
        paramObject = anzj.a(2131701215);
        paramObject = paramObject;
        this.b.setText(paramObject);
      }
      if (TextUtils.isEmpty(localqwp.h)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localqwp.h);
    }
    label240:
    label251:
    do
    {
      return;
      paramObject = localqwp.jdField_a_of_type_Qwr.jdField_a_of_type_JavaLangString;
      break;
      if (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anzj.a(2131701234));
        return;
      }
    } while (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 13);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anzj.a(2131701166));
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = agej.a(150.0F, getResources());
    localLayoutParams.height = agej.a(150.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */