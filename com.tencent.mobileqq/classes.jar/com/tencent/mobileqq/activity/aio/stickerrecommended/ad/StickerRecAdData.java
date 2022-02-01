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
  int jdField_a_of_type_Int;
  BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  AdEmoItem jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem;
  String jdField_a_of_type_JavaLangString;
  
  public StickerRecAdData(AdEmoItem paramAdEmoItem, BaseSessionInfo paramBaseSessionInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem = paramAdEmoItem;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  @NotNull
  public Intent a(BaseSessionInfo paramBaseSessionInfo, String paramString)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("uin", paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramBaseSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramBaseSessionInfo.b);
    localIntent.putExtra("key_confess_topicid", paramBaseSessionInfo.e);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("send_in_background", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("quick_send_original_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b);
    localIntent.putExtra("quick_send_original_size", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.jdField_a_of_type_Long);
    localIntent.putExtra("quick_send_thumb_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b);
    localIntent.putExtra("quick_send_is_ad_emo", true);
    localIntent.putExtra("quick_send_ad_emo_jump_url", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.c);
    localIntent.putExtra("quick_send_ad_emo_desc_str", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.d);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
    return localIntent;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this;
    return localURLDrawableOptions;
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
  
  public String a()
  {
    AdEmoItem localAdEmoItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem;
    if (localAdEmoItem != null) {
      return localAdEmoItem.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public URL a()
  {
    URL localURL2;
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b))) {
        URL localURL1 = new URL("sticker_recommended_pic", "fromAIO", this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b);
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
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEmoticonWillShow, index = ");
      localStringBuilder.append(paramInt);
      QLog.d("StickerRecAdData", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    new AdEmoReportUtil().a(paramBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, a(), paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecAdData", 2, "sendEmoticon");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem == null) {
      return;
    }
    new AdEmoReportUtil().b(paramBaseQQAppInterface, paramBaseSessionInfo, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem.b, this.jdField_a_of_type_JavaLangString);
    paramBaseSessionInfo = a(paramBaseSessionInfo, StickerRecConstants.a(e()));
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmoPic(paramContext, paramBaseSessionInfo);
    paramBaseQQAppInterface = paramBaseQQAppInterface.getHandler(getClass());
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.sendMessage(paramBaseQQAppInterface.obtainMessage(92));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    AdEmoItem localAdEmoItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem;
    if (localAdEmoItem != null) {
      return localAdEmoItem.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int c()
  {
    return 5;
  }
  
  public String c()
  {
    AdEmoItem localAdEmoItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem;
    if (localAdEmoItem != null) {
      return localAdEmoItem.b;
    }
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public String e()
  {
    AdEmoItem localAdEmoItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdAdEmoItem;
    if (localAdEmoItem != null) {
      return localAdEmoItem.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdData
 * JD-Core Version:    0.7.0.1
 */