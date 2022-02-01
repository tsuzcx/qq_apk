package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BaseLocalStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConstants;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class StickerRecAdData
  extends BaseLocalStickerRecEmoticon
{
  AdEmoItem a;
  BaseSessionInfo b;
  String c;
  int d;
  
  public StickerRecAdData(AdEmoItem paramAdEmoItem, BaseSessionInfo paramBaseSessionInfo, String paramString)
  {
    this.a = paramAdEmoItem;
    this.b = paramBaseSessionInfo;
    this.c = paramString;
  }
  
  @NotNull
  public Intent a(BaseSessionInfo paramBaseSessionInfo, String paramString)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("uin", paramBaseSessionInfo.b);
    localIntent.putExtra("uintype", paramBaseSessionInfo.a);
    localIntent.putExtra("troop_uin", paramBaseSessionInfo.c);
    localIntent.putExtra("key_confess_topicid", paramBaseSessionInfo.v);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("send_in_background", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("quick_send_original_md5", this.a.b);
    localIntent.putExtra("quick_send_original_size", this.a.c);
    localIntent.putExtra("quick_send_thumb_md5", this.a.b);
    localIntent.putExtra("quick_send_is_ad_emo", true);
    localIntent.putExtra("quick_send_ad_emo_jump_url", this.a.f);
    localIntent.putExtra("quick_send_ad_emo_desc_str", this.a.g);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
    return localIntent;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
    paramURL.setTag(new int[] { 0, 0, (int)paramURLDrawableOptions.mGifRoundCorner });
    return paramURL;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEmoticonWillShow, index = ");
      localStringBuilder.append(paramInt);
      QLog.d("StickerRecAdData", 2, localStringBuilder.toString());
    }
    this.d = paramInt;
    new AdEmoReportUtil().a(paramBaseQQAppInterface, this.b, e(), paramInt, this.a.b, this.c);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecAdData", 2, "sendEmoticon");
    }
    if (this.a == null) {
      return;
    }
    new AdEmoReportUtil().b(paramBaseQQAppInterface, paramBaseSessionInfo, e(), this.d, this.a.b, this.c);
    paramBaseSessionInfo = a(paramBaseSessionInfo, StickerRecConstants.a(n()));
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmoPic(paramContext, paramBaseSessionInfo);
    paramBaseQQAppInterface = paramBaseQQAppInterface.getHandler(getClass());
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.sendMessage(paramBaseQQAppInterface.obtainMessage(92));
    }
  }
  
  public URLDrawable.URLDrawableOptions c()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this;
    return localURLDrawableOptions;
  }
  
  public String e()
  {
    AdEmoItem localAdEmoItem = this.a;
    if (localAdEmoItem != null) {
      return localAdEmoItem.a;
    }
    return null;
  }
  
  public String f()
  {
    AdEmoItem localAdEmoItem = this.a;
    if (localAdEmoItem != null) {
      return localAdEmoItem.a;
    }
    return null;
  }
  
  public int h()
  {
    return 0;
  }
  
  public int i()
  {
    return 0;
  }
  
  public int j()
  {
    return 5;
  }
  
  public URL k()
  {
    URL localURL2;
    try
    {
      if ((this.a != null) && (!TextUtils.isEmpty(this.a.b))) {
        URL localURL1 = new URL("sticker_recommended_pic", "fromAIO", this.a.b);
      }
    }
    catch (Exception localException)
    {
      QLog.e("StickerRecAdData", 1, "getProtocolURL error ", localException);
      localURL2 = null;
    }
    if (localURL2 == null)
    {
      QLog.e("StickerRecAdData", 1, "getURL url = null");
      return null;
    }
    return localURL2;
  }
  
  public String l()
  {
    AdEmoItem localAdEmoItem = this.a;
    if (localAdEmoItem != null) {
      return localAdEmoItem.b;
    }
    return null;
  }
  
  public String m()
  {
    return null;
  }
  
  public String n()
  {
    AdEmoItem localAdEmoItem = this.a;
    if (localAdEmoItem != null) {
      return localAdEmoItem.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdData
 * JD-Core Version:    0.7.0.1
 */