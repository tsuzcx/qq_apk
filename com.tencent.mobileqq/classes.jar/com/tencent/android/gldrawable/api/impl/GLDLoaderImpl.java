package com.tencent.android.gldrawable.api.impl;

import androidx.annotation.Keep;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.base.AbsGLDLoader;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import org.jetbrains.annotations.NotNull;

@Keep
public class GLDLoaderImpl
  extends AbsGLDLoader
{
  private ILoadUtils loadUtils = new LoaderUtilsImpl();
  
  @NotNull
  public ILoadUtils getLoaderUtils()
  {
    return this.loadUtils;
  }
  
  public void onLoadSucess()
  {
    super.onLoadSucess();
    if (DeviceInfoUtils.b()) {
      GLDrawableApi.config().setFpsLimit(20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.impl.GLDLoaderImpl
 * JD-Core Version:    0.7.0.1
 */