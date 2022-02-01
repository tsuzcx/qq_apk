package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import anvx;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.BorderTextView;
import java.util.List;
import pjr;
import qfw;
import rbn;
import rbx;
import rfw;
import rgn;
import rps;
import rpt;
import rpu;
import rpv;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements rbn
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rgn(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  public rfw a;
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
    this.jdField_a_of_type_Rfw = new rfw();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560161, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368572));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131366208));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
    this.b = ((TextView)paramView.findViewById(2131372158));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anvx.a(2131701786));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(Object paramObject)
  {
    b();
    ArticleInfo localArticleInfo;
    rpt localrpt;
    if ((paramObject instanceof qfw))
    {
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
      localArticleInfo = paramObject.a();
      localrpt = (rpt)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localrpt.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localrpt.jdField_a_of_type_JavaLangString);
      }
      if ((localrpt.jdField_a_of_type_Rpu != null) && (!TextUtils.isEmpty(localrpt.jdField_a_of_type_Rpu.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localrpt.jdField_a_of_type_Rpu.b);
      }
      if ((localrpt.jdField_a_of_type_Rpv != null) && (localrpt.jdField_a_of_type_Rpv.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder().append(bmhv.b(localrpt.jdField_a_of_type_Rpv.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(localrpt.jdField_a_of_type_Rpv.jdField_a_of_type_JavaLangString)) {
          break label240;
        }
        paramObject = anvx.a(2131701801);
        paramObject = paramObject;
        this.b.setText(paramObject);
      }
      if (TextUtils.isEmpty(localrpt.h)) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localrpt.h);
    }
    label240:
    label251:
    do
    {
      return;
      paramObject = localrpt.jdField_a_of_type_Rpv.jdField_a_of_type_JavaLangString;
      break;
      if (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anvx.a(2131701820));
        return;
      }
    } while (localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 13);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(anvx.a(2131701752));
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = AIOUtils.dp2px(150.0F, getResources());
    localLayoutParams.height = AIOUtils.dp2px(150.0F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */