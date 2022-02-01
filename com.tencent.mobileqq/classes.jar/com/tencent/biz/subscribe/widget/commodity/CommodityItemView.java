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
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class CommodityItemView
  extends BaseWidgetView
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
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
  
  protected int a()
  {
    return 2131558737;
  }
  
  protected View.OnClickListener a()
  {
    return new CommodityItemView.2(this);
  }
  
  protected View a()
  {
    return this;
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369330));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379589));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379590));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379555);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369336);
    this.c = (ImmersiveUtils.getScreenWidth() * 5 / 6);
    if (getLayoutParams() == null) {
      setLayoutParams(new FrameLayout.LayoutParams(this.c, ImmersiveUtils.dpToPx(132.0F)));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(ImmersiveUtils.getScreenWidth() / 750 * 24);
  }
  
  protected void a(Object paramObject)
  {
    Object localObject;
    long l;
    if ((paramObject instanceof CommodityBean))
    {
      paramObject = (CommodityBean)paramObject;
      localObject = paramObject.mTitle;
      l = paramObject.mPrice;
      paramObject = paramObject.mImg;
    }
    else
    {
      paramObject = (CertifiedAccountMeta.StYouZanGood)paramObject;
      localObject = paramObject.title.get();
      l = paramObject.price.get();
      paramObject = paramObject.img.get();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (l % 100L == 0L) {
      localObject = String.format("%d", new Object[] { Long.valueOf(l / 100L) });
    } else {
      localObject = String.format("%.2f", new Object[] { Float.valueOf((float)l / 100.0F) });
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.getFailedDrawable();
        paramObject = URLDrawable.getDrawable(paramObject, (URLDrawable.URLDrawableOptions)localObject);
        if (paramObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramObject);
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      paramObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      if (paramObject != null)
      {
        paramObject = paramObject.poster.id.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("auth_");
        ((StringBuilder)localObject).append(SubscribeShareHelper.a(a()));
        VSReporter.a(paramObject, ((StringBuilder)localObject).toString(), "exp_goods", 0, 0, new String[0]);
      }
    }
    else
    {
      ImageLoader.getInstance().loadImageAsync(paramObject, new CommodityItemView.1(this));
    }
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
    if (!paramBoolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 8) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView
 * JD-Core Version:    0.7.0.1
 */