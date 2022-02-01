package com.tencent.comic.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import com.tencent.qphone.base.util.QLog;

@HippyController(name="BoodoImage")
public class BoodoHippyImageViewController
  extends HippyImageViewController
{
  public static final String CLASS_NAME = "BoodoImage";
  
  protected View createViewImpl(Context paramContext)
  {
    return new BoodoHippyImageView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new BoodoHippyImageView(paramContext);
    if (paramHippyMap != null) {
      paramContext.setInitProps(paramHippyMap);
    }
    return paramContext;
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="blurRadius")
  public void setBlurRadius(HippyImageView paramHippyImageView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, new Object[] { "mBlurRadius", Integer.valueOf(paramInt) });
    }
    if ((paramHippyImageView instanceof BoodoHippyImageView)) {
      ((BoodoHippyImageView)paramHippyImageView).setBlurRadius(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.view.BoodoHippyImageViewController
 * JD-Core Version:    0.7.0.1
 */