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
  private String b;
  
  public StickerRecLocalData(Emoticon paramEmoticon)
  {
    this.a = paramEmoticon;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
    if (paramURL.getStatus() != 1) {
      paramURL.setTag(this.a);
    }
    return paramURL;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncIncreaseEmoticonExposeNum(this);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo);
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.a);
    paramContext = this.a;
    if ((paramContext != null) && (paramContext.isNewSoundEmoticon())) {
      EmoticonOperateReport.reportNewSoundEvent(paramBaseQQAppInterface, "0X800A932", paramBaseSessionInfo.a, this.a.epId);
    }
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(this.a);
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (this.a.isAPNG)
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
  
  public String e()
  {
    Object localObject = MobileQQ.sMobileQQ;
    String str1 = null;
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if ((localObject instanceof BaseQQAppInterface))
    {
      boolean bool1 = ((IEmojiManagerService)((BaseQQAppInterface)localObject).getRuntimeService(IEmojiManagerService.class)).supportExtensionDisplay(this.a);
      boolean bool2 = this.a.isAPNG;
      str1 = "200";
      if (bool2)
      {
        str2 = EmotionPanelConstans.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", this.a.eId.substring(0, 2)).replace("[eId]", this.a.eId);
        if (bool1) {
          localObject = String.valueOf(this.a.extensionWidth);
        } else {
          localObject = "200";
        }
        localObject = str2.replace("[width]", (CharSequence)localObject);
        if (bool1) {
          str1 = String.valueOf(this.a.extensionHeight);
        }
        return ((String)localObject).replace("[height]", str1);
      }
      String str2 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", this.a.eId.substring(0, 2)).replace("[eId]", this.a.eId);
      if (bool1) {
        localObject = String.valueOf(this.a.extensionWidth);
      } else {
        localObject = "200";
      }
      localObject = str2.replace("[width]", (CharSequence)localObject);
      if (bool1) {
        str1 = String.valueOf(this.a.extensionHeight);
      }
      str1 = ((String)localObject).replace("[height]", str1);
    }
    return str1;
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
    return 2;
  }
  
  public URL k()
  {
    URL localURL;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.epId);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.a.eId);
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
  
  public String l()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    if (this.a.isAPNG) {
      localObject = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", this.a.epId).replace("[eId]", this.a.eId);
    } else {
      localObject = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", this.a.epId).replace("[eId]", this.a.eId);
    }
    localObject = MD5.getFileMd5((String)localObject);
    if (localObject != null)
    {
      this.b = MD5.toMD5((byte[])localObject);
      localObject = this.b;
      if (localObject != null) {
        this.b = ((String)localObject).toLowerCase();
      }
      return this.b;
    }
    return null;
  }
  
  public String m()
  {
    if (n()) {
      return "d-";
    }
    return "b-";
  }
  
  public boolean n()
  {
    return (this.a.parseSoundPrintString() != null) && (!this.a.parseSoundPrintString().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalData
 * JD-Core Version:    0.7.0.1
 */