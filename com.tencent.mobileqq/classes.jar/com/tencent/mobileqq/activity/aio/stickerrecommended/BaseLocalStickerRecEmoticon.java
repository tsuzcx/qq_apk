package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import java.net.URL;

public abstract class BaseLocalStickerRecEmoticon
  extends BaseEmoticonExposure
  implements IStickerRecEmoticon
{
  private boolean a;
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    this.a = true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    return URLDrawable.URLDrawableOptions.obtain();
  }
  
  public boolean d()
  {
    return this.a;
  }
  
  public String e()
  {
    return null;
  }
  
  public String f()
  {
    return null;
  }
  
  public boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalStickerRecEmoticon
 * JD-Core Version:    0.7.0.1
 */