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
  
  public URLDrawable.URLDrawableOptions a()
  {
    return URLDrawable.URLDrawableOptions.obtain();
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    this.a = true;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalStickerRecEmoticon
 * JD-Core Version:    0.7.0.1
 */