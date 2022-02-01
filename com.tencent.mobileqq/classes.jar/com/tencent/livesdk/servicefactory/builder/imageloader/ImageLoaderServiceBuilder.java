package com.tencent.livesdk.servicefactory.builder.imageloader;

import com.tencent.falco.base.imageloader.ImageLoaderComponent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.utils.FileUtil;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import java.io.File;

public class ImageLoaderServiceBuilder
  implements BaseServiceBuilder
{
  private static final String TAG = "ImageLoaderServiceBuild";
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ImageLoaderComponent localImageLoaderComponent = new ImageLoaderComponent();
    try
    {
      localObject = new File(FileUtil.getExternalCacheDir(((AppGeneralInfoService)paramServiceAccessor.getService(AppGeneralInfoService.class)).getApplication()), "app_imageloader");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
    }
    catch (Exception localException)
    {
      Object localObject;
      label57:
      break label57;
    }
    localObject = "";
    localImageLoaderComponent.init((String)localObject, new ImageLoaderServiceBuilder.1(this, paramServiceAccessor));
    return localImageLoaderComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.imageloader.ImageLoaderServiceBuilder
 * JD-Core Version:    0.7.0.1
 */