package com.tencent.ad.tangram.views.floattips;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public class AdFloatTipsViewContainer
  extends LinearLayout
{
  public static final String TAG = "AdFloatTipsViewContainer";
  private View appTipsView;
  private View industrialView;
  
  public AdFloatTipsViewContainer(Context paramContext, AdFloatTipsViewContainer.Params paramParams1, AdFloatTipsViewContainer.Params paramParams2)
  {
    super(paramContext);
    initView();
    initChildViews(paramParams1, paramParams2);
  }
  
  private void initChildViews(AdFloatTipsViewContainer.Params paramParams1, AdFloatTipsViewContainer.Params paramParams2)
  {
    AdLog.i(TAG, "[initChildViews]");
    if (paramParams1 != null)
    {
      this.appTipsView = new a(getContext(), paramParams1);
      addView(this.appTipsView);
    }
    paramParams1 = new View(getContext());
    paramParams1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    addView(paramParams1);
    if (paramParams2 != null)
    {
      this.industrialView = new a(getContext(), paramParams2);
      addView(this.industrialView);
    }
  }
  
  private void initView()
  {
    AdLog.i(TAG, "[initView]");
    setGravity(16);
  }
  
  public View getAppTipsView()
  {
    return this.appTipsView;
  }
  
  public View getIndustrialView()
  {
    return this.industrialView;
  }
  
  public void onRecycle()
  {
    AdLog.i(TAG, "[onRecycle]");
    removeAllViews();
  }
  
  public void resetTipsView(AdFloatTipsViewContainer.Params paramParams1, AdFloatTipsViewContainer.Params paramParams2)
  {
    AdLog.i(TAG, "[resetTipsView]");
    onRecycle();
    initChildViews(paramParams1, paramParams2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer
 * JD-Core Version:    0.7.0.1
 */