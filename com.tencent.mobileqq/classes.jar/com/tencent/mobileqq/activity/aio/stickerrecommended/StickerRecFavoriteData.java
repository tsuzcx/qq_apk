package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class StickerRecFavoriteData
  extends BaseLocalStickerRecEmoticon
{
  public CustomEmotionData a;
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private String jdField_a_of_type_JavaLangString;
  
  public StickerRecFavoriteData(QQAppInterface paramQQAppInterface, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (localFavroamingDBManager != null) {
      this.jdField_a_of_type_JavaLangString = localFavroamingDBManager.a(paramCustomEmotionData);
    }
    if (paramCustomEmotionData.isMarkFace) {
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", "[图片]");
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", paramString);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)StructMsgFactory.a(localBundle), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, 0);
    paramSessionInfo = AIOGallerySceneWithBusiness.a(paramString);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      VipComicReportUtils.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], AIOGallerySceneWithBusiness.a(paramString) });
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
    if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) {}
    URL localURL3;
    for (;;)
    {
      URL localURL2;
      try
      {
        URL localURL1 = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.jdField_a_of_type_JavaLangString);
        if (localURL1 != null) {
          break;
        }
        QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url = null");
        return null;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url exception e = " + localMalformedURLException1.getMessage());
        localURL2 = null;
        continue;
      }
      try
      {
        localURL2 = new URL("emotion_pic", "fromAIO", this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath + "_" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId);
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        QLog.e("StickerRecFavoriteData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException2.getMessage());
        localURL3 = null;
      }
    }
    return localURL3;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ((FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    super.a(paramQQAppInterface, paramContext, paramSessionInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
    {
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isNewSoundEmoticon()) {
        EmoticonManager.a(paramQQAppInterface, "0X800A932", paramSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
      ((FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), "热聊暂不支持发送自定义表情", 0).b(paramContext.getTitleBarHeight());
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) {}
    for (String str = VipComicMqqManager.a(((VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER)).a(), this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);; str = null)
    {
      if (AIOGallerySceneWithBusiness.a(str))
      {
        a(paramQQAppInterface, paramSessionInfo, str);
        break;
      }
      str = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId)) {
        bool = true;
      }
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, str, true, bool, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId, null);
      break;
    }
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
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString() != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteData
 * JD-Core Version:    0.7.0.1
 */