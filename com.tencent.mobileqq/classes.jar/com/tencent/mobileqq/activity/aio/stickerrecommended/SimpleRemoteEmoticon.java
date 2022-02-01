package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class SimpleRemoteEmoticon
  extends BaseEmoticonExposure
  implements IStickerRecEmoticon
{
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
    paramURL.setTag(new int[] { 0, 0, (int)paramURLDrawableOptions.mGifRoundCorner });
    return paramURL;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo) {}
  
  public boolean b()
  {
    return false;
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this;
    return localURLDrawableOptions;
  }
  
  public int j()
  {
    return 1;
  }
  
  public URL k()
  {
    URL localURL2;
    try
    {
      URL localURL1 = new URL("sticker_recommended_pic", "fromAIO", ((StickerRecData)this).y());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getURL create url exception e = ");
      localStringBuilder.append(localMalformedURLException.getMessage());
      QLog.e("SimpleRemoteEmoticon", 1, localStringBuilder.toString());
      localURL2 = null;
    }
    if (localURL2 == null)
    {
      QLog.e("SimpleRemoteEmoticon", 1, "getURL url = null");
      return null;
    }
    return localURL2;
  }
  
  public String m()
  {
    return "z-";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.SimpleRemoteEmoticon
 * JD-Core Version:    0.7.0.1
 */