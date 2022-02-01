package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
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
  
  public StickerRecCameraData(QQAppInterface paramQQAppInterface, CameraEmotionData paramCameraEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    paramQQAppInterface = (CameraEmotionRoamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.a(paramCameraEmotionData);
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
    try
    {
      URL localURL1 = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.jdField_a_of_type_JavaLangString);
      if (localURL1 == null)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url = null");
        return null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException.getMessage());
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ((CameraEmoRoamingManager)paramQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), HardCodeUtil.a(2131714269), 0).b(paramContext.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.strContext, null);
    ((CameraEmoRoamingManager)paramQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraData
 * JD-Core Version:    0.7.0.1
 */