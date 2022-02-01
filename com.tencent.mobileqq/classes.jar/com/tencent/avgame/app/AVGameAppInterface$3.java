package com.tencent.avgame.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;

class AVGameAppInterface$3
  extends URLDrawableParams
{
  private ProtocolDownloader b;
  
  AVGameAppInterface$3(AVGameAppInterface paramAVGameAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  protected ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ("fileassistantimage".equals(paramString)) {
      return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
    }
    if ("file".equalsIgnoreCase(paramString)) {
      return new LocaleFileDownloader();
    }
    if (this.b == null) {
      this.b = new HttpDownloader();
    }
    return this.b;
  }
  
  protected String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  protected ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  protected Drawable getDefaultLoadingDrawable()
  {
    return null;
  }
  
  protected Drawable getDefualtFailedDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface.3
 * JD-Core Version:    0.7.0.1
 */