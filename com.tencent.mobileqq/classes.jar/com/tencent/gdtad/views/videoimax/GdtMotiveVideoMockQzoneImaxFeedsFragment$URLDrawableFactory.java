package com.tencent.gdtad.views.videoimax;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import java.io.File;

class GdtMotiveVideoMockQzoneImaxFeedsFragment$URLDrawableFactory
  extends URLDrawableParams
{
  Context a;
  
  public GdtMotiveVideoMockQzoneImaxFeedsFragment$URLDrawableFactory(Context paramContext, File paramFile)
  {
    super(paramContext);
    this.a = paramContext;
    com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = paramFile;
    com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new DiskCache(paramFile);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (BaseApplicationImpl.sProcessId == 1) {}
      for (;;)
      {
        return new HttpDownloader(bool, paramObject);
        bool = false;
      }
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    return this.a.getResources().getDrawable(2130848203);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return this.a.getResources().getDrawable(2130848203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment.URLDrawableFactory
 * JD-Core Version:    0.7.0.1
 */