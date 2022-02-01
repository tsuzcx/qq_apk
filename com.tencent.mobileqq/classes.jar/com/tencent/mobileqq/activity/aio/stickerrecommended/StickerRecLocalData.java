package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.app.MobileQQ;

public class StickerRecLocalData
  extends BaseLocalStickerRecEmoticon
  implements IStickerRecLocalData
{
  public Emoticon a;
  private String a;
  
  public StickerRecLocalData(Emoticon paramEmoticon)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.exposeNum;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
      }
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
    }
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
    if (paramURL.getStatus() != 1) {
      paramURL.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    }
    return paramURL;
  }
  
  public String a()
  {
    Object localObject = MobileQQ.sMobileQQ;
    String str1 = null;
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if ((localObject instanceof BaseQQAppInterface))
    {
      boolean bool1 = ((IEmojiManagerService)((BaseQQAppInterface)localObject).getRuntimeService(IEmojiManagerService.class)).supportExtensionDisplay(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG;
      str1 = "200";
      if (bool2)
      {
        str2 = EmotionPanelConstans.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.substring(0, 2)).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        if (bool1) {
          localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth);
        } else {
          localObject = "200";
        }
        localObject = str2.replace("[width]", (CharSequence)localObject);
        if (bool1) {
          str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight);
        }
        return ((String)localObject).replace("[height]", str1);
      }
      String str2 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.substring(0, 2)).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (bool1) {
        localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth);
      } else {
        localObject = "200";
      }
      localObject = str2.replace("[width]", (CharSequence)localObject);
      if (bool1) {
        str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight);
      }
      str1 = ((String)localObject).replace("[height]", str1);
    }
    return str1;
  }
  
  public URL a()
  {
    URL localURL;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject = new URL("emotion_pic", "fromAIO", ((StringBuilder)localObject).toString());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StickerLocalRecData getURL url exception e = ");
      localStringBuilder.append(localMalformedURLException.getMessage());
      QLog.e("StickerRecLocalData", 1, localStringBuilder.toString());
      localURL = null;
    }
    if (localURL == null)
    {
      QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url = null");
      return null;
    }
    return localURL;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncIncreaseEmoticonExposeNum(this);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo);
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    if ((paramContext != null) && (paramContext.isNewSoundEmoticon())) {
      EmoticonOperateReport.reportNewSoundEvent(paramBaseQQAppInterface, "0X800A932", paramBaseSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    }
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.clickNum;
  }
  
  public int c()
  {
    return 2;
  }
  
  public String c()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      return localObject;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG) {
      localObject = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    } else {
      localObject = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    }
    localObject = MD5.getFileMd5((String)localObject);
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaLangString = MD5.toMD5((byte[])localObject);
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = ((String)localObject).toLowerCase();
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public String d()
  {
    if (d()) {
      return "d-";
    }
    return "b-";
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString() != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalData
 * JD-Core Version:    0.7.0.1
 */