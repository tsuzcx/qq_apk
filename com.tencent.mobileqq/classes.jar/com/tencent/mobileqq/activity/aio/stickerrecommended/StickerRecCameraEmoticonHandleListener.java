package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StickerRecCameraEmoticonHandleListener
  extends BaseLocalEmoticonHandleListener
{
  private Collection<String> a;
  
  public StickerRecCameraEmoticonHandleListener(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilCollection = null;
  }
  
  private List<StickerRecCameraData> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (CameraEmotionRoamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    StickerRecManager localStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((CameraEmotionRoamingDBManager)localObject).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localStickerRecManager.b(localCameraEmotionData.strContext)))) {
          localArrayList.add(new StickerRecCameraData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + MessageRecordUtil.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<StickerRecCameraData> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString);
  }
  
  public void a()
  {
    StickerRecManager localStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localStickerRecManager != null) {
      this.jdField_a_of_type_JavaUtilCollection = localStickerRecManager.a();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilCollection == null) {
      a();
    }
    return (this.jdField_a_of_type_JavaUtilCollection != null) && (this.jdField_a_of_type_JavaUtilCollection.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraEmoticonHandleListener
 * JD-Core Version:    0.7.0.1
 */