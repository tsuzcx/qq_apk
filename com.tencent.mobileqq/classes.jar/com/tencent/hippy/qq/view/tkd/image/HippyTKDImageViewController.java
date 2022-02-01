package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;

@HippyController(name="Image")
public class HippyTKDImageViewController
  extends HippyImageViewController
{
  public static final String COMMAND_PAUSE = "pause";
  public static final String COMMAND_START_PLAY = "startPlay";
  private static final String TAG = "TKDImageViewController";
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTKDImageView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyTKDImageView(paramContext);
    if (paramHippyMap != null) {
      paramContext.setInitProps(paramHippyMap);
    }
    return paramContext;
  }
  
  public void dispatchFunction(HippyImageView paramHippyImageView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    super.dispatchFunction(paramHippyImageView, paramString, paramHippyArray, paramPromise);
    if ("startPlay".equals(paramString))
    {
      paramHippyImageView.startPlay();
      paramHippyImageView = new HippyMap();
      paramHippyImageView.pushBoolean("result", true);
      paramPromise.resolve(paramHippyImageView);
      return;
    }
    if ("pause".equals(paramString))
    {
      paramHippyImageView.pause();
      paramHippyImageView = new HippyMap();
      paramHippyImageView.pushBoolean("result", true);
      paramPromise.resolve(paramHippyImageView);
    }
  }
  
  public void setBackground(HippyImageView paramHippyImageView, int paramInt)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView))
    {
      HippyArray localHippyArray = new HippyArray();
      localHippyArray.pushInt(paramInt);
      ((HippyTKDImageView)paramHippyImageView).setBackgroundColors(localHippyArray);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="blurRadius")
  public void setBlurRadius(HippyImageView paramHippyImageView, int paramInt)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setBlurRadius(paramInt);
    }
  }
  
  @HippyControllerProps(defaultType="map", name="clipInfo")
  public void setClipInfo(HippyImageView paramHippyImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setClipInfo(paramHippyMap);
    }
  }
  
  @HippyControllerProps(name="customProp")
  public void setCustomProp(HippyImageView paramHippyImageView, String paramString, Object paramObject)
  {
    if ((paramHippyImageView instanceof HippyTKDCommonBorderHandler.HippyQBCommonBorder)) {
      HippyTKDCommonBorderHandler.handleCommonBorderColor((HippyTKDCommonBorderHandler.HippyQBCommonBorder)paramHippyImageView, paramString, paramObject);
    }
  }
  
  @HippyControllerProps(name="fitSystemRotation")
  public void setFitSystemRotation(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setFitSystemRotation(paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="gifEnabled")
  public void setGifEnabled(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setGifEnabled(paramBoolean);
    }
  }
  
  @HippyControllerProps(name="nightMode")
  public void setNightMode(HippyImageView paramHippyImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setNightModeOption(paramHippyMap);
    }
  }
  
  @HippyControllerProps(name="noPicMode")
  public void setNoPicMode(HippyImageView paramHippyImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setNoPicModeOption(paramHippyMap);
    }
  }
  
  @HippyControllerProps(defaultType="map", name="reportData")
  public void setReportData(HippyImageView paramHippyImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setReportData(paramHippyMap);
    }
  }
  
  @HippyControllerProps(name="srcs")
  public void setSrcs(HippyImageView paramHippyImageView, HippyArray paramHippyArray)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setSources(paramHippyArray);
    }
  }
  
  @HippyControllerProps(name="tintColors")
  public void setTintColors(HippyImageView paramHippyImageView, HippyArray paramHippyArray)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setTintColors(paramHippyArray);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="useThumbnail")
  public void setUseThumbnail(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setUseThumbnail(paramBoolean);
    }
  }
  
  @HippyControllerProps(name="pointsForCrop")
  public void setpointsForCrop(HippyImageView paramHippyImageView, HippyArray paramHippyArray)
  {
    if ((paramHippyImageView instanceof HippyTKDImageView)) {
      ((HippyTKDImageView)paramHippyImageView).setpointsForCrop(paramHippyArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDImageViewController
 * JD-Core Version:    0.7.0.1
 */