package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

public class SubscribeVideoSharedCardView
  extends SubscribeMultiPicSharedCardView
{
  private ImageView a;
  
  public SubscribeVideoSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364540));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    super.a(paramShareInfoBean, paramBitmap, paramShareDataBindListener);
    paramShareInfoBean = paramShareInfoBean.a();
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramShareInfoBean.cover.width.get(), paramShareInfoBean.cover.height.get());
    this.jdField_a_of_type_JavaUtilArrayList.add(paramShareInfoBean.poster.icon.get());
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramShareInfoBean.cover.url.get());
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView);
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, paramShareDataBindListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeVideoSharedCardView
 * JD-Core Version:    0.7.0.1
 */