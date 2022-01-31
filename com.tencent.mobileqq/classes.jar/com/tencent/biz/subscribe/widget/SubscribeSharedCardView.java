package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import awmc;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import vms;
import vxn;

public class SubscribeSharedCardView
  extends FrameLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RadiusLinerLayout jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private final String jdField_a_of_type_JavaLangString = "SubscribeSharedCardView";
  private vxn jdField_a_of_type_Vxn;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public SubscribeSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131493147, this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout = ((RadiusLinerLayout)localView.findViewById(2131298460));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298464));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)localView.findViewById(2131298457));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298462));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298463));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298459));
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public Bitmap a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout != null)
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout.getWidth(), this.jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout.getHeight(), Bitmap.Config.ARGB_8888);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRadiusLinerLayout.draw(new Canvas(localBitmap));
        return localBitmap;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("SubscribeSharedCardView", 4, "failed to get bitmap from view");
    }
    return null;
  }
  
  public void a(vxn paramvxn, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Vxn = paramvxn;
    paramvxn = paramvxn.a();
    if (paramvxn != null)
    {
      if (paramvxn.images.size() <= 0) {
        break label202;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131311070, ((CertifiedAccountMeta.StImage)paramvxn.images.get(0)).url.get());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131311040, Boolean.valueOf(false));
      vms.a(this.jdField_a_of_type_AndroidWidgetImageView, ((CertifiedAccountMeta.StImage)paramvxn.images.get(0)).url.get(), this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), null, null);
      QLog.d("budingnie_test", 4, paramvxn.hashCode() + "feed images is not empty");
    }
    for (;;)
    {
      vms.b(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramvxn.poster.icon.get(), awmc.a(22.0F), awmc.a(22.0F), null, "");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vxn.f());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vxn.c());
      if (paramBitmap != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      return;
      label202:
      QLog.d("budingnie_test", 4, paramvxn.hashCode() + "feed images is empty");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeSharedCardView
 * JD-Core Version:    0.7.0.1
 */