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
  private SquareImageView c;
  private TextView d;
  private TextView e;
  private View f;
  private View g;
  private boolean h;
  private int i;
  private CertifiedAccountMeta.StFeed j;
  
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
  
  protected void a(Context paramContext, View paramView)
  {
    this.c = ((SquareImageView)paramView.findViewById(2131436331));
    this.d = ((TextView)paramView.findViewById(2131448346));
    this.e = ((TextView)paramView.findViewById(2131448347));
    this.f = paramView.findViewById(2131448307);
    this.g = paramView.findViewById(2131436341);
    this.i = (ImmersiveUtils.getScreenWidth() * 5 / 6);
    if (getLayoutParams() == null) {
      setLayoutParams(new FrameLayout.LayoutParams(this.i, ImmersiveUtils.dpToPx(132.0F)));
    }
    this.e.setTextSize(ImmersiveUtils.getScreenWidth() / 750 * 24);
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
    this.d.setText((CharSequence)localObject);
    if (l % 100L == 0L) {
      localObject = String.format("%d", new Object[] { Long.valueOf(l / 100L) });
    } else {
      localObject = String.format("%.2f", new Object[] { Float.valueOf((float)l / 100.0F) });
    }
    this.e.setText((CharSequence)localObject);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.getFailedDrawable();
        paramObject = URLDrawable.getDrawable(paramObject, (URLDrawable.URLDrawableOptions)localObject);
        if (paramObject != null) {
          this.c.setImageDrawable(paramObject);
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      paramObject = this.j;
      if (paramObject != null)
      {
        paramObject = paramObject.poster.id.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("auth_");
        ((StringBuilder)localObject).append(SubscribeShareHelper.a(getExtraTypeInfo()));
        VSReporter.a(paramObject, ((StringBuilder)localObject).toString(), "exp_goods", 0, 0, new String[0]);
      }
    }
    else
    {
      ImageLoader.getInstance().loadImageAsync(paramObject, new CommodityItemView.1(this));
    }
  }
  
  protected View f()
  {
    return this;
  }
  
  public View getDeleteBtn()
  {
    return this.g;
  }
  
  protected int getLayoutId()
  {
    return 2131624357;
  }
  
  protected View.OnClickListener getOnClickLister()
  {
    return new CommodityItemView.2(this);
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.j = paramStFeed;
  }
  
  public void setIsPublishUI(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (!paramBoolean) {
      return;
    }
    if (this.f.getVisibility() == 0) {
      this.f.setVisibility(8);
    }
    if (this.g.getVisibility() == 8) {
      this.g.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView
 * JD-Core Version:    0.7.0.1
 */