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
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  
  AVGameAppInterface$3(AVGameAppInterface paramAVGameAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ("fileassistantimage".equals(paramString)) {
      return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
    }
    if ("file".equalsIgnoreCase(paramString)) {
      return new LocaleFileDownloader();
    }
    if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
      this.jdField_a_of_type_ComTencentImageProtocolDownloader = new HttpDownloader();
    }
    return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
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
    return null;
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface.3
 * JD-Core Version:    0.7.0.1
 */