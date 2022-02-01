package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="TKDGifImageView")
public class HippyTKDGifImageViewController
  extends HippyViewController<HippyTKDGifImageView>
{
  public static final String CLASS_NAME = "TKDGifImageView";
  public static final String PROPS_GIFINFO = "gifInfo";
  public static final String PROPS_GIFURL = "gifUrl";
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyTKDGifImageView(paramContext);
  }
  
  @HippyControllerProps(defaultType="map", name="clipInfo")
  public void setClipInfo(HippyTKDGifImageView paramHippyTKDGifImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyTKDGifImageView instanceof HippyTKDGifImageView)) {
      paramHippyTKDGifImageView.setClipInfo(paramHippyMap);
    }
  }
  
  @HippyControllerProps(defaultType="map", name="gifInfo")
  public void setGifInfo(HippyTKDGifImageView paramHippyTKDGifImageView, HippyMap paramHippyMap)
  {
    boolean bool1;
    if (paramHippyMap != null)
    {
      if (paramHippyMap.containsKey("enableNoPicMode")) {
        paramHippyTKDGifImageView.setNoPicModeOption(paramHippyMap.getBoolean("enableNoPicMode"));
      }
      if (paramHippyMap.containsKey("sustainedPlay")) {
        paramHippyTKDGifImageView.setSustainedPlay(paramHippyMap.getBoolean("sustainedPlay"));
      }
      if (paramHippyMap.containsKey("startPlay"))
      {
        bool1 = paramHippyMap.getBoolean("startPlay");
        bool2 = bool1;
        if (paramHippyMap.containsKey("gifUrl"))
        {
          paramHippyMap = paramHippyMap.getString("gifUrl");
          if (paramHippyTKDGifImageView.getUrl() != null)
          {
            bool2 = bool1;
            if (paramHippyTKDGifImageView.getUrl().equals(paramHippyMap)) {}
          }
          else
          {
            paramHippyTKDGifImageView.mGIFUrl = paramHippyMap;
            paramHippyTKDGifImageView.setGifUrl(paramHippyTKDGifImageView.mGIFUrl);
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2)
      {
        paramHippyTKDGifImageView.mUserRequestPlay = true;
        paramHippyTKDGifImageView.startPlay();
        return;
      }
      paramHippyTKDGifImageView.mUserRequestPlay = false;
      paramHippyTKDGifImageView.stopPlay();
      return;
      bool1 = true;
      break;
    }
  }
  
  @HippyControllerProps(defaultType="map", name="reportData")
  public void setReportData(HippyTKDGifImageView paramHippyTKDGifImageView, HippyMap paramHippyMap)
  {
    if ((paramHippyTKDGifImageView instanceof HippyTKDGifImageView)) {
      paramHippyTKDGifImageView.setReportData(paramHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController
 * JD-Core Version:    0.7.0.1
 */