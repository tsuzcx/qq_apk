package com.tencent.biz.pubaccount.readinjoyAd.ad.diversion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyAdDiversionWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private Activity a;
  private View b;
  private Button c;
  private URLImageView d;
  private RelativeLayout e;
  private URLImageView f;
  private int g = 0;
  private final String h = "http://img.nfa.qq.com/gmaster_prod/16245792/gmaster_71lw6fufgfc0_qb_public_account_readinjoy_ad_diversion_window.png";
  
  public ReadInJoyAdDiversionWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.b = LayoutInflater.from(paramActivity).inflate(2131626103, null);
    setContentView(this.b);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      a(this.b);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  private void a(View paramView)
  {
    this.c = ((Button)paramView.findViewById(2131427681));
    this.d = ((URLImageView)paramView.findViewById(2131428619));
    this.e = ((RelativeLayout)paramView.findViewById(2131427682));
    this.f = ((URLImageView)paramView.findViewById(2131445526));
    Object localObject = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getScreenSize(this.a);
    this.g = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(274.0F, this.a.getResources());
    setWidth(localObject[0]);
    setHeight(this.g);
    setBackgroundDrawable(new ColorDrawable());
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(15.5F, this.a.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
    float f1 = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(15.5F, this.a.getResources());
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFFFF"));
    paramView.setBackgroundDrawable((Drawable)localObject);
    paramView = new GradientDrawable();
    paramView.setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(19.0F, this.a.getResources()));
    paramView.setColor(Color.parseColor("#12B7F5"));
    this.c.setBackgroundDrawable(paramView);
    b();
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    setAnimationStyle(2131953357);
  }
  
  private void b()
  {
    String str = Aladdin.getConfig(514).getString("app_icon", "");
    float f1 = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(9.5F, this.a.getResources());
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).loadImage(this.d, str, (int)f1, 71, 71, -1, this.a);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).loadImage(this.f, "http://img.nfa.qq.com/gmaster_prod/16245792/gmaster_71lw6fufgfc0_qb_public_account_readinjoy_ad_diversion_window.png", 0, 17, 17, -1, this.a);
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
    Activity localActivity = this.a;
    if ((localActivity != null) && (localActivity.getWindow() != null) && (this.a.getWindow().getDecorView() != null))
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getScreenSize(this.a);
      showAsDropDown(this.a.getWindow().getDecorView(), 0, -this.g);
      a(this);
    }
  }
  
  public void a(PopupWindow paramPopupWindow)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = (View)paramPopupWindow.getContentView().getParent();
      } else {
        localObject1 = paramPopupWindow.getContentView();
      }
      Object localObject2 = localObject1;
      if (paramPopupWindow.getBackground() != null) {
        localObject2 = (View)((View)localObject1).getParent();
      }
      paramPopupWindow = (WindowManager)paramPopupWindow.getContentView().getContext().getSystemService("window");
      Object localObject1 = (WindowManager.LayoutParams)((View)localObject2).getLayoutParams();
      ((WindowManager.LayoutParams)localObject1).flags |= 0x2;
      ((WindowManager.LayoutParams)localObject1).dimAmount = 0.2F;
      paramPopupWindow.updateViewLayout((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    catch (Exception paramPopupWindow) {}
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131427682)
    {
      dismiss();
      return;
    }
    if (i == 2131427681)
    {
      DiversionUtil.a(this.a, 2);
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.ReadInJoyAdDiversionWindow
 * JD-Core Version:    0.7.0.1
 */