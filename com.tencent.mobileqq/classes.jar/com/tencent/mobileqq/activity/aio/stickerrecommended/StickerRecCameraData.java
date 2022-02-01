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
  private CameraEmotionData jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public StickerRecCameraData(BaseQQAppInterface paramBaseQQAppInterface, CameraEmotionData paramCameraEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    paramBaseQQAppInterface = (ICameraEmotionRoamingDBManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    if (paramBaseQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramBaseQQAppInterface.getCustomEmoticonPath(paramCameraEmotionData);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.exposeNum;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.url;
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.url;
  }
  
  public URL a()
  {
    URL localURL2;
    try
    {
      URL localURL1 = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.jdField_a_of_type_JavaLangString);
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
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((ICameraEmoRoamingManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncIncreaseEmoticonExposeNum(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramBaseSessionInfo.jdField_a_of_type_Int, paramBaseSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (QBaseActivity)paramContext;
      QQToast.a(paramBaseQQAppInterface.getApp(), HardCodeUtil.a(2131699766), 0).b(paramContext.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    CustomEmotionSenderUtil.sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.strContext, null);
    ((ICameraEmoRoamingManagerService)paramBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).asyncIncreaseEmotionClickNum(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.clickNum;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return 3;
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.md5;
    if (str != null) {
      return str.toLowerCase();
    }
    return null;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public String d()
  {
    return "a-";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraData
 * JD-Core Version:    0.7.0.1
 */