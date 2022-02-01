package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class StickerRecCameraData
  extends BaseLocalStickerRecEmoticon
{
  private CameraEmotionData a;
  private boolean b;
  private String c;
  
  public StickerRecCameraData(BaseQQAppInterface paramBaseQQAppInterface, CameraEmotionData paramCameraEmotionData)
  {
    this.a = paramCameraEmotionData;
    paramBaseQQAppInterface = (ICameraEmotionRoamingDBManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    if (paramBaseQQAppInterface != null) {
      this.c = paramBaseQQAppInterface.getCustomEmoticonPath(paramCameraEmotionData);
    }
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((ICameraEmoRoamingManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.a);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramBaseSessionInfo.a, paramBaseSessionInfo.b)))
    {
      paramContext = (QBaseActivity)paramContext;
      QQToast.makeText(paramBaseQQAppInterface.getApp(), HardCodeUtil.a(2131897799), 0).show(paramContext.getTitleBarHeight());
      return;
    }
    this.b = true;
    CustomEmotionSenderUtil.sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.c, true, this.a.strContext, null);
    ((ICameraEmoRoamingManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).asyncIncreaseEmotionClickNum(this.a);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this.a.url;
    return localURLDrawableOptions;
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.a.url;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public int h()
  {
    return this.a.exposeNum;
  }
  
  public int i()
  {
    return this.a.clickNum;
  }
  
  public int j()
  {
    return 3;
  }
  
  public URL k()
  {
    URL localURL2;
    try
    {
      URL localURL1 = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.c);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StickerLocalRecData getURL url exception e = ");
      localStringBuilder.append(localMalformedURLException.getMessage());
      QLog.e("StickerRecCameraData", 1, localStringBuilder.toString());
      localURL2 = null;
    }
    if (localURL2 == null)
    {
      QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url = null");
      return null;
    }
    return localURL2;
  }
  
  public String l()
  {
    String str = this.a.md5;
    if (str != null) {
      return str.toLowerCase();
    }
    return null;
  }
  
  public String m()
  {
    return "a-";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraData
 * JD-Core Version:    0.7.0.1
 */