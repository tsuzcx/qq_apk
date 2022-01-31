package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
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
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.BorderTextView;
import java.util.List;
import obj;
import opw;
import pex;
import pfh;
import pjg;
import pjx;
import ppu;
import ppv;
import ppw;
import ppx;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements pex
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pjx(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  public pjg a;
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
    this.jdField_a_of_type_Pjg = new pjg();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131494283, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131302227));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131300104));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
    this.b = ((TextView)paramView.findViewById(2131305317));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajjy.a(2131636494));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(Object paramObject)
  {
    b();
    ArticleInfo localArticleInfo;
    ppv localppv;
    if ((paramObject instanceof opw))
    {
      paramObject = (opw)paramObject;
      this.jdField_a_of_type_Pjg.a(paramObject);
      localArticleInfo = paramObject.a();
      localppv = (ppv)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localppv.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localppv.jdField_a_of_type_JavaLangString);
      }
      if ((localppv.jdField_a_of_type_Ppw != null) && (!TextUtils.isEmpty(localppv.jdField_a_of_type_Ppw.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localppv.jdField_a_of_type_Ppw.b);
      }
      if ((localppv.jdField_a_of_type_Ppx != null) && (localppv.jdField_a_of_type_Ppx.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder().append(bgmq.b(localppv.jdField_a_of_type_Ppx.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(localppv.jdField_a_of_type_Ppx.jdField_a_of_type_JavaLangString)) {
          break label240;
        }
        paramObject = ajjy.a(2131636509);
        paramObject = paramObject;
        this.b.setText(paramObject);
      }
      if (TextUtils.isEmpty(localppv.h)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localppv.h);
    }
    label240:
    label251:
    do
    {
      return;
      paramObject = localppv.jdField_a_of_type_Ppx.jdField_a_of_type_JavaLangString;
      break;
      if (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajjy.a(2131636528));
        return;
      }
    } while (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 13);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(ajjy.a(2131636460));
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = aciy.a(150.0F, getResources());
    localLayoutParams.height = aciy.a(150.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */