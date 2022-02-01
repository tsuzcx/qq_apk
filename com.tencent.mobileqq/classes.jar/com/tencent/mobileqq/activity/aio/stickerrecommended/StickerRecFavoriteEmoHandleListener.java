package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StickerRecFavoriteEmoHandleListener
  extends BaseLocalEmoticonHandleListener
{
  private Collection<String> a;
  
  public StickerRecFavoriteEmoHandleListener(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilCollection = null;
  }
  
  public List<? extends IStickerRecEmoticon> a(String paramString, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    paramSessionInfo = new ArrayList();
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    Object localObject = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    StickerRecManager localStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((FavroamingDBManager)localObject).a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticonDataList.size : " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
        if (("isUpdate".equals(localCustomEmotionData.RomaingType)) || ("needDownload".equals(localCustomEmotionData.RomaingType)) || ("overflow".equals(localCustomEmotionData.RomaingType)) || ("overflow_downloaded".equals(localCustomEmotionData.RomaingType))) {
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localStickerRecManager.b(localCustomEmotionData.modifyWord))))
          {
            paramSessionInfo.add(new StickerRecFavoriteData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localStickerRecManager.b(localCustomEmotionData.ocrWord))))
          {
            paramSessionInfo.add(new StickerRecFavoriteData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localEmoticonManager.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localStickerRecManager.b(localEmoticon.name)))) {
              paramSessionInfo.add(new StickerRecFavoriteData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (paramSessionInfo.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + MessageRecordUtil.a(paramString));
      }
      return null;
    }
    return paramSessionInfo;
  }
  
  public void a()
  {
    StickerRecManager localStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localStickerRecManager != null) {
      this.jdField_a_of_type_JavaUtilCollection = localStickerRecManager.b();
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteEmoHandleListener
 * JD-Core Version:    0.7.0.1
 */