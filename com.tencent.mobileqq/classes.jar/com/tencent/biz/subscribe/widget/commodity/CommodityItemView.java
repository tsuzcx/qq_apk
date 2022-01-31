package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import baul;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import yjq;
import yka;
import ykb;
import yvu;

public class CommodityItemView
  extends BaseWidgetView
{
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public CommodityItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommodityItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommodityItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return 2131558702;
  }
  
  public View.OnClickListener a()
  {
    return new ykb(this);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368738));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378663));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378664));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378630);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368744);
    this.jdField_a_of_type_Int = (ImmersiveUtils.a() * 5 / 6);
    if (getLayoutParams() == null) {
      setLayoutParams(new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, ImmersiveUtils.a(132.0F)));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(ImmersiveUtils.a() / 750 * 24);
  }
  
  public void a(Object paramObject)
  {
    long l;
    if ((paramObject instanceof CommodityBean))
    {
      localObject = ((CommodityBean)paramObject).mTitle;
      l = ((CommodityBean)paramObject).mPrice;
      paramObject = ((CommodityBean)paramObject).mImg;
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (l % 100L != 0L) {
        break label228;
      }
    }
    label228:
    for (Object localObject = String.format("%d", new Object[] { Long.valueOf(l / 100L) });; localObject = String.format("%.2f", new Object[] { Float.valueOf((float)l / 100.0F) }))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label261;
      }
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.b();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a();
        paramObject = URLDrawable.getDrawable(paramObject, (URLDrawable.URLDrawableOptions)localObject);
        if (paramObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramObject);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        yvu.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + yjq.a(a()), "exp_goods", 0, 0, new String[0]);
      }
      return;
      localObject = ((CertifiedAccountMeta.StYouZanGood)paramObject).title.get();
      l = ((CertifiedAccountMeta.StYouZanGood)paramObject).price.get();
      paramObject = ((CertifiedAccountMeta.StYouZanGood)paramObject).img.get();
      break;
    }
    label261:
    ImageLoader.getInstance().loadImageAsync(paramObject, new yka(this));
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
  }
  
  public void setIsPublishUI(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView
 * JD-Core Version:    0.7.0.1
 */