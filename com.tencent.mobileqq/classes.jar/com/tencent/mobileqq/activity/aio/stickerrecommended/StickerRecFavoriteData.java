package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManagerConstants;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil;
import com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class StickerRecFavoriteData
  extends BaseLocalStickerRecEmoticon
{
  public CustomEmotionData a;
  private Emoticon b;
  private String c;
  
  public StickerRecFavoriteData(BaseQQAppInterface paramBaseQQAppInterface, CustomEmotionData paramCustomEmotionData)
  {
    this.a = paramCustomEmotionData;
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (localIFavroamingDBManagerService != null) {
      this.c = localIFavroamingDBManagerService.getCustomEmoticonPath(paramCustomEmotionData);
    }
    if (paramCustomEmotionData.isMarkFace) {
      this.b = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId);
    }
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if ((this.a.isMarkFace) && (this.b != null))
    {
      paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
      if (paramURL.getStatus() != 1) {
        paramURL.setTag(this.b);
      }
      return paramURL;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((IFavroamingManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.a);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo);
    if ((this.a.isMarkFace) && (this.b != null))
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmoticon(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.b, false);
    }
    else
    {
      if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramBaseSessionInfo.a, paramBaseSessionInfo.b)))
      {
        paramContext = (QBaseActivity)paramContext;
        QQToast.makeText(paramBaseQQAppInterface.getApp(), "热聊暂不支持发送自定义表情", 0).show(paramContext.getTitleBarHeight());
        return;
      }
      String str = null;
      if (!this.a.isMarkFace) {
        str = VipComicMqqManagerConstants.a(((IVipComicMqqManagerService)paramBaseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class)).getComicStructInfoMap(), this.a.md5);
      }
      if (((IEmosmService)QRoute.api(IEmosmService.class)).isComeFromComic(str)) {
        FavoriteEmoticonInfoSender.sendStructMsgForImage(paramBaseQQAppInterface, paramBaseSessionInfo, this.c, str);
      } else {
        CustomEmotionSenderUtil.sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.c, true, TextUtils.isEmpty(this.a.eId) ^ true, this.a.eId, null);
      }
    }
    ((IFavroamingManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).asyncIncreaseEmotionClickNum(this.a);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    if ((this.a.isMarkFace) && (this.b != null))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (this.b.isAPNG)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecFavoriteData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
        }
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
      }
      return localURLDrawableOptions;
    }
    return super.c();
  }
  
  public String e()
  {
    return this.a.url;
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
    return 4;
  }
  
  public URL k()
  {
    StringBuilder localStringBuilder;
    if (!this.a.isMarkFace) {
      try
      {
        URL localURL1 = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.c);
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StickerRecFavoriteData getURL url exception e = ");
        localStringBuilder.append(localMalformedURLException1.getMessage());
        QLog.e("StickerRecFavoriteData", 1, localStringBuilder.toString());
        break label160;
      }
    } else {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.emoPath);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.a.eId);
        localObject = new URL("emotion_pic", "fromAIO", ((StringBuilder)localObject).toString());
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StickerLocalRecData getURL url exception e = ");
        localStringBuilder.append(localMalformedURLException2.getMessage());
        QLog.e("StickerRecFavoriteData", 1, localStringBuilder.toString());
      }
    }
    label160:
    URL localURL2 = null;
    if (localURL2 == null)
    {
      QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url = null");
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
    return "c-";
  }
  
  public boolean n()
  {
    Emoticon localEmoticon = this.b;
    return (localEmoticon != null) && (localEmoticon.parseSoundPrintString() != null) && (!this.b.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteData
 * JD-Core Version:    0.7.0.1
 */