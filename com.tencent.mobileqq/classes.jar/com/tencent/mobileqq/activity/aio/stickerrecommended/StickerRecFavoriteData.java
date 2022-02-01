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
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private String jdField_a_of_type_JavaLangString;
  
  public StickerRecFavoriteData(BaseQQAppInterface paramBaseQQAppInterface, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (localIFavroamingDBManagerService != null) {
      this.jdField_a_of_type_JavaLangString = localIFavroamingDBManagerService.getCustomEmoticonPath(paramCustomEmotionData);
    }
    if (paramCustomEmotionData.isMarkFace) {
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.exposeNum;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG)
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
    return super.a();
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
    {
      paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
      if (paramURL.getStatus() != 1) {
        paramURL.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      }
      return paramURL;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url;
  }
  
  public URL a()
  {
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) {
      try
      {
        URL localURL1 = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.jdField_a_of_type_JavaLangString);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId);
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
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((IFavroamingManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmoticon(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, false);
    }
    else
    {
      if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramBaseSessionInfo.jdField_a_of_type_Int, paramBaseSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramContext = (QBaseActivity)paramContext;
        QQToast.a(paramBaseQQAppInterface.getApp(), "热聊暂不支持发送自定义表情", 0).b(paramContext.getTitleBarHeight());
        return;
      }
      String str = null;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) {
        str = VipComicMqqManagerConstants.a(((IVipComicMqqManagerService)paramBaseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class)).getComicStructInfoMap(), this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      }
      if (((IEmosmService)QRoute.api(IEmosmService.class)).isComeFromComic(str)) {
        FavoriteEmoticonInfoSender.sendStructMsgForImage(paramBaseQQAppInterface, paramBaseSessionInfo, this.jdField_a_of_type_JavaLangString, str);
      } else {
        CustomEmotionSenderUtil.sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.jdField_a_of_type_JavaLangString, true, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId) ^ true, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId, null);
      }
    }
    ((IFavroamingManagerService)paramBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class)).asyncIncreaseEmotionClickNum(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.clickNum;
  }
  
  public int c()
  {
    return 4;
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5;
    if (str != null) {
      return str.toLowerCase();
    }
    return null;
  }
  
  public String d()
  {
    return "c-";
  }
  
  public boolean d()
  {
    Emoticon localEmoticon = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    return (localEmoticon != null) && (localEmoticon.parseSoundPrintString() != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteData
 * JD-Core Version:    0.7.0.1
 */