package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AIOGalleryUtils
{
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramContext.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localFavroamingDBManager.a();
    int j;
    int i;
    int k;
    int n;
    if (localObject != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= ((List)localObject).size()) {
        break label260;
      }
      n = ((CustomEmotionData)((List)localObject).get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(j)).emoPath))) {
        i = 2;
      }
    }
    label234:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)((List)localObject).get(j)).md5 == null) || (!str.equals(((CustomEmotionData)((List)localObject).get(j)).md5))) {
          break label234;
        }
        if (!"needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {
          break;
        }
        localFavroamingDBManager.a((CustomEmotionData)((List)localObject).get(j), j);
        paramContext = paramContext.getHandler(ChatActivity.class);
        i = m;
      } while (paramContext == null);
      paramContext.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramContext.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      localFavroamingDBManager.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (FavroamingManager)paramContext.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      i = m;
    } while (paramContext == null);
    label260:
    paramContext.d((CustomEmotionData)localObject);
    return 0;
  }
  
  public static int a(Context paramContext, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (FavroamingDBManager)localQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((FavroamingDBManager)localObject).a();
    if (localList != null)
    {
      int i = 1;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        int m = ((CustomEmotionData)localList.get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)localList.get(j)).md5 != null) && (str.equals(((CustomEmotionData)localList.get(j)).md5)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          if ("needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType))
          {
            ((FavroamingDBManager)localObject).a((CustomEmotionData)localList.get(j), j);
            paramContext = localQQAppInterface.getHandler(ChatActivity.class);
            if (paramContext != null) {
              paramContext.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
        i = k;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new EmoAddedAuthCallback(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (FavroamingManager)localQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
    if (paramString != null) {
      paramString.b((CustomEmotionData)localObject, paramContext);
    }
    return 0;
  }
  
  public static int a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOLightVideoData.class.isInstance(paramAIORichMediaData)) {
      return 3;
    }
    if ((AIOShortVideoData.class.isInstance(paramAIORichMediaData)) || (AIOFileVideoData.class.isInstance(paramAIORichMediaData))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, PicMessageExtraData paramPicMessageExtraData, EmoBatchAddedCallback paramEmoBatchAddedCallback, int paramInt)
  {
    if (paramURLDrawable.getStatus() != 1) {
      paramURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(paramURLDrawable.getURL().toString());
    if (paramURLDrawable.getTag() == null) {
      return 1;
    }
    paramURLDrawable = paramURLDrawable.getURL().toString();
    if (!AbsDownloader.hasFile(paramURLDrawable))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, has file");
      }
      return 1;
    }
    Object localObject1 = AbsDownloader.getFile(paramURLDrawable);
    if (localObject1 != null) {}
    for (paramURLDrawable = SecUtil.getFileMd5(((File)localObject1).getAbsolutePath());; paramURLDrawable = null)
    {
      if ((paramURLDrawable == null) || ("".equals(paramURLDrawable)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
        }
        return 1;
      }
      FileUtils.c(AppConstants.SDCARD_IMG_FAVORITE + ".nomedia");
      Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
      int i;
      String str;
      if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label364;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(paramPicMessageExtraData.emojiId)) {
          break label355;
        }
        str = "0";
        label193:
        str = str;
        label205:
        paramURLDrawable = AppConstants.SDCARD_IMG_FAVORITE + DiySecureFileHelper.a((String)localObject2) + paramURLDrawable + str + ".jpg";
      }
      for (;;)
      {
        try
        {
          FileUtils.a((File)localObject1, new File(paramURLDrawable));
          str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramURLDrawable));
          localObject1 = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
          }
          localObject2 = ((FavroamingDBManager)localObject1).a();
          if (localObject2 == null) {
            break label487;
          }
          i = 0;
          if (i >= ((List)localObject2).size()) {
            break label487;
          }
          if ((paramURLDrawable == null) || (!paramURLDrawable.equals(((CustomEmotionData)((List)localObject2).get(i)).emoPath))) {
            break label385;
          }
          return 2;
        }
        catch (Exception paramQQAppInterface)
        {
          label355:
          label364:
          QLog.d("AIOGalleryUtils", 1, paramQQAppInterface, new Object[0]);
          return 1;
        }
        i = 0;
        break;
        str = paramPicMessageExtraData.emojiId;
        break label193;
        str = "";
        break label205;
        label385:
        if ((str != null) && (((CustomEmotionData)((List)localObject2).get(i)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject2).get(i)).md5)))
        {
          if ("needDel".equals(((CustomEmotionData)((List)localObject2).get(i)).RomaingType))
          {
            ((FavroamingDBManager)localObject1).a((CustomEmotionData)((List)localObject2).get(i), i);
            return 0;
          }
          return 2;
        }
        i += 1;
      }
      label487:
      localObject1 = new CustomEmotionData();
      ((CustomEmotionData)localObject1).uin = paramQQAppInterface.getCurrentAccountUin();
      ((CustomEmotionData)localObject1).emoId = paramInt;
      ((CustomEmotionData)localObject1).emoPath = paramURLDrawable;
      ((CustomEmotionData)localObject1).md5 = str;
      if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
        ((CustomEmotionData)localObject1).eId = paramPicMessageExtraData.emojiPkgId;
      }
      if ((!TextUtils.isEmpty(paramURLDrawable)) && (paramURLDrawable.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramEmoBatchAddedCallback.a((CustomEmotionData)localObject1);
      paramQQAppInterface = (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b((CustomEmotionData)localObject1, paramEmoBatchAddedCallback);
      }
      return 3;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 0;
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((FavroamingDBManager)localObject).a();
    int j;
    int i;
    int k;
    int n;
    if (localList != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= localList.size()) {
        break label250;
      }
      n = ((CustomEmotionData)localList.get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath))) {
        i = 2;
      }
    }
    label224:
    label250:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)localList.get(j)).md5 == null) || (!str.equals(((CustomEmotionData)localList.get(j)).md5))) {
          break label224;
        }
        if (!"needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType)) {
          break;
        }
        ((FavroamingDBManager)localObject).a((CustomEmotionData)localList.get(j), j);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        i = m;
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new EmoAddedAuthCallback(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (FileManagerUtil.a(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localTroopFileStatusInfo.jdField_b_of_type_Int != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
        return null;
        if ((localTroopFileStatusInfo.jdField_b_of_type_Int != 4) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is:" + localTroopFileStatusInfo.jdField_b_of_type_Int);
      return null;
      if ((!FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) || ((localTroopFileStatusInfo.jdField_b_of_type_Int != 1) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 2) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is:" + localTroopFileStatusInfo.jdField_b_of_type_Int);
    return null;
    ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(localTroopFileStatusInfo.jdField_g_of_type_JavaLangString));
    Object localObject = localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      FileManagerUtil.a(paramMessageForTroopFile);
    }
    localObject = new AIOFilePicData();
    ((AIOFilePicData)localObject).jdField_f_of_type_Long = paramMessageForTroopFile.uniseq;
    ((AIOFilePicData)localObject).jdField_g_of_type_Long = paramMessageForTroopFile.time;
    ((AIOFilePicData)localObject).jdField_i_of_type_Long = paramMessageForTroopFile.shmsgseq;
    ((AIOFilePicData)localObject).jdField_h_of_type_Long = paramMessageForTroopFile.fileSize;
    ((AIOFilePicData)localObject).jdField_a_of_type_JavaLangString = paramMessageForTroopFile.frienduin;
    ((AIOFilePicData)localObject).jdField_a_of_type_Int = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).jdField_f_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    ((AIOFilePicData)localObject).jdField_b_of_type_Int = paramMessageForTroopFile.issend;
    ((AIOFilePicData)localObject).jdField_g_of_type_Int = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).jdField_k_of_type_Boolean = paramMessageForTroopFile.isMultiMsg;
    ((AIOFilePicData)localObject).jdField_c_of_type_Int = paramMessageForTroopFile.width;
    ((AIOFilePicData)localObject).jdField_d_of_type_Int = paramMessageForTroopFile.height;
    ((AIOFilePicData)localObject).jdField_e_of_type_Int = localTroopFileStatusInfo.j;
    ((AIOFilePicData)localObject).jdField_h_of_type_JavaLangString = paramMessageForTroopFile.url;
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).jdField_f_of_type_Boolean = bool;
      ((AIOFilePicData)localObject).a(localTroopFileStatusInfo);
      ((AIOFilePicData)localObject).m = MessageHandlerUtils.b(paramMessageForTroopFile);
      return localObject;
    }
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_f_of_type_Long = paramMessageForPic.uniseq;
    localAIOImageData.jdField_f_of_type_Int = paramMessageForPic.subMsgId;
    localAIOImageData.jdField_g_of_type_Long = paramMessageForPic.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForPic.shmsgseq;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForPic.size;
    localAIOImageData.jdField_g_of_type_Int = paramMessageForPic.istroop;
    localAIOImageData.jdField_f_of_type_JavaLangString = paramMessageForPic.md5;
    localAIOImageData.jdField_j_of_type_JavaLangString = paramMessageForPic.rawMsgUrl;
    localAIOImageData.jdField_k_of_type_JavaLangString = paramMessageForPic.senderuin;
    localAIOImageData.jdField_l_of_type_JavaLangString = paramMessageForPic.frienduin;
    Object localObject1;
    if (AnonymousChatHelper.a(paramMessageForPic))
    {
      localObject1 = AnonymousChatHelper.a(paramMessageForPic);
      if ((((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_JavaLangString != null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int == 2)) {
        break label437;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryUtils", 2, "toAIOImageData anonymousExtInfo : an_id is null");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData, pic_server_url = " + localAIOImageData.jdField_j_of_type_JavaLangString + "  send_uin = " + localAIOImageData.jdField_k_of_type_JavaLangString);
    }
    if (paramMessageForPic.picExtraData != null) {
      localAIOImageData.jdField_i_of_type_JavaLangString = paramMessageForPic.picExtraData.doutuSupplier;
    }
    int i;
    if (paramMessageForPic.isMixed)
    {
      i = 1;
      label222:
      localAIOImageData.jdField_a_of_type_JavaLangString = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label515;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForPic.uuid;
      localAIOImageData.jdField_d_of_type_Long = paramMessageForPic.groupFileID;
      localAIOImageData.jdField_a_of_type_Long = paramMessageForPic.width;
      localAIOImageData.jdField_b_of_type_Long = paramMessageForPic.height;
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForPic.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = paramMessageForPic.imageType;
      localAIOImageData.jdField_k_of_type_Boolean = paramMessageForPic.isMultiMsg;
      localAIOImageData.jdField_i_of_type_Boolean = paramMessageForPic.isSend();
      if (paramMessageForPic.picExtraData != null)
      {
        if (paramMessageForPic.picExtraData.isHotPics()) {
          localAIOImageData.jdField_b_of_type_Int = 4;
        }
        localAIOImageData.jdField_e_of_type_Int = paramMessageForPic.picExtraData.imageBizType;
        localAIOImageData.o = paramMessageForPic.picExtraData.mTemplateId;
        localAIOImageData.p = paramMessageForPic.picExtraData.mTemplateName;
      }
      localAIOImageData.jdField_l_of_type_Boolean = paramMessageForPic.isInMixedMsg;
      localAIOImageData.m = MessageHandlerUtils.b(paramMessageForPic);
      return localAIOImageData;
      label437:
      Object localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).a();
      if ((localObject2 == null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      AnonymousChatHelper.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.jdField_j_of_type_Boolean = true;
      localAIOImageData.n = AnonymousChatHelper.a().a(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label515:
      localObject1 = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = AbsDownloader.getFilePath(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = AbsDownloader.getDisplayFilePath(((URL)localObject1).toString());
        if ((paramMessageForPic.mShowLength > 0) && (paramMessageForPic.mShowLength < paramMessageForPic.mDownloadLength)) {
          localAIOImageData.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static AIOImageData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_f_of_type_Long = paramMessageForTroopFile.uniseq;
    localAIOImageData.jdField_f_of_type_Int = 0;
    localAIOImageData.jdField_g_of_type_Long = paramMessageForTroopFile.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForTroopFile.shmsgseq;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForTroopFile.fileSize;
    localAIOImageData.jdField_g_of_type_Int = paramMessageForTroopFile.istroop;
    localAIOImageData.jdField_h_of_type_Boolean = true;
    localAIOImageData.jdField_k_of_type_JavaLangString = paramMessageForTroopFile.senderuin;
    localAIOImageData.jdField_k_of_type_Boolean = paramMessageForTroopFile.isMultiMsg;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData file, isFromFile = " + localAIOImageData.jdField_h_of_type_Boolean + "  send_uin = " + localAIOImageData.jdField_k_of_type_JavaLangString);
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localTroopFileStatusInfo.jdField_d_of_type_JavaLangString != null)
    {
      localObject = localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      localAIOImageData.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (localAIOImageData.jdField_a_of_type_JavaLangString == null) {
        localAIOImageData.jdField_a_of_type_JavaLangString = "I:N";
      }
      if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
        localAIOImageData.jdField_b_of_type_JavaLangString = localTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        localAIOImageData.jdField_c_of_type_JavaLangString = localTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      }
      if (localTroopFileStatusInfo.jdField_b_of_type_Int != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool;
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localTroopFileStatusInfo.jdField_a_of_type_Int;
      try
      {
        localObject = TroopFileItemBuilder.a(paramQQAppInterface.getApplication(), localTroopFileStatusInfo, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = URLDrawableHelper.getLoadingDrawable();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = URLDrawableHelper.getLoadingDrawable();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = URLDrawableHelper.getLoadingDrawable();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_g_of_type_JavaLangString = localTroopFileStatusInfo.jdField_g_of_type_JavaLangString;
      localAIOImageData.jdField_h_of_type_JavaLangString = localTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_e_of_type_Long = localTroopFileStatusInfo.jdField_c_of_type_Long;
      localAIOImageData.jdField_c_of_type_Int = localTroopFileStatusInfo.jdField_h_of_type_Int;
      localAIOImageData.jdField_b_of_type_Int = 3;
      return localAIOImageData;
      localObject = localTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public static AIORichMediaData a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramChatMessage == null)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      return paramQQAppInterface;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      localObject1 = b(paramChatMessage, paramQQAppInterface);
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localObject1 == null) {
        break;
      }
      QLog.i("AIOGalleryUtils<QFile>", 1, "toAIOFileMediaData: media data is null.");
      ((AIORichMediaData)localObject1).m = MessageHandlerUtils.b(paramChatMessage);
      return localObject1;
      if ((paramChatMessage instanceof MessageForTroopFile))
      {
        localObject1 = c(paramChatMessage, paramQQAppInterface);
      }
      else
      {
        localObject1 = localObject2;
        if ((paramChatMessage instanceof MessageForDLFile)) {
          localObject1 = d(paramChatMessage, paramQQAppInterface);
        }
      }
    }
  }
  
  public static AIOShortVideoData a(MessageForShortVideo paramMessageForShortVideo)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.jdField_f_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_g_of_type_Long = paramMessageForShortVideo.time;
    localAIOShortVideoData.jdField_h_of_type_Long = paramMessageForShortVideo.videoFileSize;
    localAIOShortVideoData.jdField_i_of_type_Long = paramMessageForShortVideo.shmsgseq;
    String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localAIOShortVideoData.jdField_a_of_type_JavaLangString = str1;
    localAIOShortVideoData.jdField_b_of_type_JavaLangString = str2;
    localAIOShortVideoData.jdField_a_of_type_Int = paramMessageForShortVideo.videoFileTime;
    localAIOShortVideoData.jdField_b_of_type_Int = paramMessageForShortVideo.busiType;
    localAIOShortVideoData.jdField_c_of_type_Int = paramMessageForShortVideo.thumbWidth;
    localAIOShortVideoData.jdField_d_of_type_Int = paramMessageForShortVideo.thumbHeight;
    localAIOShortVideoData.jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_e_of_type_Int = paramMessageForShortVideo.redBagType;
    localAIOShortVideoData.jdField_c_of_type_JavaLangString = paramMessageForShortVideo.shortVideoId;
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = MsgProxyUtils.a(paramMessageForShortVideo);
    localAIOShortVideoData.jdField_h_of_type_Int = paramMessageForShortVideo.redBagStat;
    localAIOShortVideoData.jdField_e_of_type_JavaLangString = paramMessageForShortVideo.frienduin;
    localAIOShortVideoData.jdField_g_of_type_Int = paramMessageForShortVideo.istroop;
    if (paramMessageForShortVideo.isSend()) {}
    for (int i = 1;; i = 0)
    {
      localAIOShortVideoData.jdField_i_of_type_Int = i;
      localAIOShortVideoData.jdField_k_of_type_Int = paramMessageForShortVideo.specialVideoType;
      localAIOShortVideoData.j = paramMessageForShortVideo.videoFileStatus;
      localAIOShortVideoData.jdField_k_of_type_Boolean = paramMessageForShortVideo.isMultiMsg;
      localAIOShortVideoData.jdField_f_of_type_JavaLangString = paramMessageForShortVideo.templateId;
      localAIOShortVideoData.jdField_g_of_type_JavaLangString = paramMessageForShortVideo.templateName;
      localAIOShortVideoData.m = MessageHandlerUtils.b(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (FavroamingDBManager)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
    }
    List localList = paramContext.a();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(i);
          paramContext.a(paramString, i);
          return paramString;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean, String paramString3)
  {
    if ((paramAIORichMediaInfo == null) || (!AIOImageData.class.isInstance(paramAIORichMediaInfo.a))) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
    paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
    if (!paramString1.endsWith("_hd"))
    {
      paramAIORichMediaInfo = paramString1 + "_hd";
      if (new File(paramAIORichMediaInfo).exists()) {
        paramString1 = paramAIORichMediaInfo;
      }
    }
    for (;;)
    {
      paramAIORichMediaInfo = localAIOImageData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOImageData.jdField_c_of_type_Long;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.jdField_d_of_type_Long;
      }
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramAIORichMediaInfo, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<AIORichMediaInfo> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(paramString1.a))
      {
        localAIOImageData = (AIOImageData)paramString1.a;
        localArrayList2.add(localAIOImageData.jdField_e_of_type_JavaLangString);
        localArrayList3.add(Long.valueOf(localAIOImageData.jdField_c_of_type_Long));
        if (paramBoolean) {
          localArrayList4.add(Long.valueOf(localAIOImageData.jdField_d_of_type_Long));
        }
        paramString1 = localAIOImageData.jdField_a_of_type_JavaLangString;
        if (paramString1.endsWith("_hd")) {
          break label298;
        }
        paramList = paramString1 + "_hd";
        if (!new File(paramList).exists()) {
          break label298;
        }
        paramString1 = paramList;
      }
    }
    label298:
    for (;;)
    {
      localArrayList1.add(paramString1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryUtils", 2, "fowardToQZoneGroupAlbums(), uuid:" + localAIOImageData.jdField_e_of_type_JavaLangString + " time:" + localAIOImageData.jdField_c_of_type_Long + " path:" + paramString1);
      break;
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new AIOGalleryUtils.1(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      if (!localVipComicFavorEmoStructMsgInfo.equals(paramQQAppInterface.a(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
        paramQQAppInterface.a(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  /* Error */
  private static AIORichMediaData b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: checkcast 717	com/tencent/mobileqq/data/MessageForFile
    //   7: astore 4
    //   9: aload_1
    //   10: invokevirtual 968	com/tencent/mobileqq/app/QQAppInterface:getFileManagerDataCenter	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   13: aload 4
    //   15: getfield 969	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   18: aload 4
    //   20: getfield 970	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   23: aload 4
    //   25: getfield 971	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   28: invokevirtual 976	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnonnull +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: aload 7
    //   42: getfield 981	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   45: ifne +190 -> 235
    //   48: new 391	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   51: dup
    //   52: invokespecial 392	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: aload 4
    //   61: getfield 969	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   64: putfield 399	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   67: aload 5
    //   69: aload 4
    //   71: getfield 982	com/tencent/mobileqq/data/MessageForFile:time	J
    //   74: putfield 404	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   77: aload 5
    //   79: aload 4
    //   81: getfield 983	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   84: putfield 409	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_Long	J
    //   87: aload 5
    //   89: aload 4
    //   91: getfield 984	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   94: putfield 415	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_Long	J
    //   97: aload 5
    //   99: aload 4
    //   101: getfield 970	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   104: putfield 419	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: aload 5
    //   109: aload 4
    //   111: getfield 971	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   114: putfield 424	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Int	I
    //   117: aload 5
    //   119: aload_1
    //   120: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   123: putfield 426	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload 5
    //   128: aload 4
    //   130: getfield 985	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   133: putfield 430	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_b_of_type_Int	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 988	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   142: putfield 432	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Int	I
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 989	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   151: putfield 435	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_k_of_type_Boolean	Z
    //   154: aload 5
    //   156: aload 7
    //   158: getfield 992	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   161: putfield 455	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload 7
    //   166: getfield 995	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   169: iconst_2
    //   170: if_icmpne +60 -> 230
    //   173: iconst_1
    //   174: istore_3
    //   175: aload 5
    //   177: iload_3
    //   178: putfield 457	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   181: aload 5
    //   183: aload 7
    //   185: getfield 998	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   188: putfield 999	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload 5
    //   193: aload 7
    //   195: getfield 1002	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   198: putfield 440	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_Int	I
    //   201: aload 5
    //   203: aload 7
    //   205: getfield 1005	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   208: putfield 445	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Int	I
    //   211: aload 5
    //   213: aload 7
    //   215: getfield 1008	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   218: putfield 450	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_e_of_type_Int	I
    //   221: aload 5
    //   223: aload_1
    //   224: invokevirtual 1011	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   227: aload 5
    //   229: areturn
    //   230: iconst_0
    //   231: istore_3
    //   232: goto -57 -> 175
    //   235: aload 7
    //   237: getfield 981	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   240: iconst_2
    //   241: if_icmpne +629 -> 870
    //   244: aload 7
    //   246: getfield 995	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   249: bipush 16
    //   251: if_icmpne +48 -> 299
    //   254: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -219 -> 38
    //   260: ldc_w 1013
    //   263: iconst_1
    //   264: new 265	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 344
    //   274: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 7
    //   279: getfield 1016	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   282: invokevirtual 894	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   285: ldc_w 1018
    //   288: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aconst_null
    //   298: areturn
    //   299: aload 7
    //   301: invokevirtual 1021	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   304: ifeq +48 -> 352
    //   307: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -272 -> 38
    //   313: ldc_w 1013
    //   316: iconst_1
    //   317: new 265	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 344
    //   327: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 7
    //   332: getfield 1016	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   335: invokevirtual 894	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   338: ldc_w 1023
    //   341: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aconst_null
    //   351: areturn
    //   352: aload 7
    //   354: invokevirtual 1025	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   357: invokestatic 364	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   360: istore_3
    //   361: iload_3
    //   362: ifeq +57 -> 419
    //   365: aload 7
    //   367: getfield 995	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   370: iconst_1
    //   371: if_icmpeq +48 -> 419
    //   374: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq -339 -> 38
    //   380: ldc_w 1013
    //   383: iconst_1
    //   384: new 265	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 344
    //   394: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 7
    //   399: getfield 1016	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   402: invokevirtual 894	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: ldc_w 1027
    //   408: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aconst_null
    //   418: areturn
    //   419: aload_1
    //   420: ldc_w 366
    //   423: ldc 148
    //   425: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   428: checkcast 366	com/tencent/mobileqq/filemanager/api/IQFileConfigManager
    //   431: aload 7
    //   433: getfield 1028	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   436: invokestatic 376	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokeinterface 380 2 0
    //   444: astore 8
    //   446: aload 7
    //   448: getfield 1031	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   451: invokestatic 1034	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   454: ifeq +322 -> 776
    //   457: aload 7
    //   459: getfield 1031	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   462: astore_1
    //   463: aload_1
    //   464: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifeq +39 -> 506
    //   470: ldc 55
    //   472: iconst_1
    //   473: new 265	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 1036
    //   483: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 7
    //   488: getfield 1016	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   491: invokevirtual 894	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   494: ldc_w 1038
    //   497: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: new 209	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   509: dup
    //   510: aload_1
    //   511: invokespecial 1039	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   514: astore 6
    //   516: aload 6
    //   518: aload 4
    //   520: getfield 970	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   523: putfield 1040	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   526: aload 6
    //   528: aload 4
    //   530: getfield 971	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   533: putfield 1041	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Int	I
    //   536: aload 6
    //   538: aload 4
    //   540: getfield 985	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   543: putfield 1042	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_d_of_type_Int	I
    //   546: aload 6
    //   548: aload 7
    //   550: getfield 992	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   553: putfield 1043	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   556: aload 6
    //   558: aload 7
    //   560: getfield 998	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   563: putfield 1044	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 6
    //   568: aload 4
    //   570: getfield 969	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   573: putfield 1045	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   576: aload 6
    //   578: aload 4
    //   580: getfield 982	com/tencent/mobileqq/data/MessageForFile:time	J
    //   583: putfield 1046	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Long	J
    //   586: aload 6
    //   588: aload 4
    //   590: getfield 983	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   593: putfield 1047	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_i_of_type_Long	J
    //   596: aload 6
    //   598: aload 7
    //   600: getfield 1048	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   603: putfield 1049	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_h_of_type_Long	J
    //   606: aload 6
    //   608: aload 7
    //   610: getfield 1028	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   613: putfield 1050	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   616: aload 6
    //   618: aload_0
    //   619: getfield 988	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   622: putfield 1051	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_g_of_type_Int	I
    //   625: aload 6
    //   627: aload 7
    //   629: getfield 1005	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   632: putfield 1052	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   635: aload 6
    //   637: aload 7
    //   639: getfield 1002	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   642: putfield 1053	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   645: aload 6
    //   647: aload 8
    //   649: getfield 1056	com/tencent/mobileqq/filemanager/data/DownloadFileConfig:jdField_b_of_type_Int	I
    //   652: i2l
    //   653: putfield 1057	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Long	J
    //   656: iload_3
    //   657: ifeq +107 -> 764
    //   660: aload 6
    //   662: aload 7
    //   664: invokevirtual 1025	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   667: putfield 1058	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   670: aload 6
    //   672: iconst_1
    //   673: putfield 1060	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_Boolean	Z
    //   676: new 1062	android/media/MediaMetadataRetriever
    //   679: dup
    //   680: invokespecial 1063	android/media/MediaMetadataRetriever:<init>	()V
    //   683: astore_1
    //   684: aload_1
    //   685: aload 6
    //   687: getfield 1058	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   690: invokevirtual 1066	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   693: aload_1
    //   694: bipush 24
    //   696: invokevirtual 1070	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   699: astore 4
    //   701: aload_1
    //   702: bipush 19
    //   704: invokevirtual 1070	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   707: astore 5
    //   709: aload_1
    //   710: bipush 18
    //   712: invokevirtual 1070	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   715: astore 7
    //   717: aload 4
    //   719: invokestatic 1075	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   722: istore_2
    //   723: iload_2
    //   724: bipush 90
    //   726: if_icmpeq +10 -> 736
    //   729: iload_2
    //   730: sipush 270
    //   733: if_icmpne +83 -> 816
    //   736: aload 6
    //   738: aload 5
    //   740: invokestatic 1075	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   743: putfield 1053	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   746: aload 6
    //   748: aload 7
    //   750: invokestatic 1075	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   753: putfield 1052	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   756: aload_1
    //   757: ifnull +7 -> 764
    //   760: aload_1
    //   761: invokevirtual 1078	android/media/MediaMetadataRetriever:release	()V
    //   764: aload 6
    //   766: aload_0
    //   767: getfield 989	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   770: putfield 1079	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_k_of_type_Boolean	Z
    //   773: aload 6
    //   775: areturn
    //   776: aload 7
    //   778: getfield 1082	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   781: invokestatic 1034	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   784: ifeq +12 -> 796
    //   787: aload 7
    //   789: getfield 1082	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   792: astore_1
    //   793: goto -330 -> 463
    //   796: aload 7
    //   798: getfield 1085	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   801: invokestatic 1034	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   804: ifeq +93 -> 897
    //   807: aload 7
    //   809: getfield 1085	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   812: astore_1
    //   813: goto -350 -> 463
    //   816: aload 6
    //   818: aload 7
    //   820: invokestatic 1075	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   823: putfield 1053	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_a_of_type_Int	I
    //   826: aload 6
    //   828: aload 5
    //   830: invokestatic 1075	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   833: putfield 1052	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_Int	I
    //   836: goto -80 -> 756
    //   839: astore 4
    //   841: aload 4
    //   843: invokevirtual 1088	java/lang/Exception:printStackTrace	()V
    //   846: aload_1
    //   847: ifnull -83 -> 764
    //   850: aload_1
    //   851: invokevirtual 1078	android/media/MediaMetadataRetriever:release	()V
    //   854: goto -90 -> 764
    //   857: astore_0
    //   858: aconst_null
    //   859: astore_1
    //   860: aload_1
    //   861: ifnull +7 -> 868
    //   864: aload_1
    //   865: invokevirtual 1078	android/media/MediaMetadataRetriever:release	()V
    //   868: aload_0
    //   869: athrow
    //   870: ldc 55
    //   872: iconst_1
    //   873: ldc_w 333
    //   876: invokestatic 336	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: aconst_null
    //   880: areturn
    //   881: astore_0
    //   882: goto -22 -> 860
    //   885: astore_0
    //   886: goto -26 -> 860
    //   889: astore 4
    //   891: aload 5
    //   893: astore_1
    //   894: goto -53 -> 841
    //   897: aconst_null
    //   898: astore_1
    //   899: goto -436 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	paramChatMessage	ChatMessage
    //   0	902	1	paramQQAppInterface	QQAppInterface
    //   722	12	2	i	int
    //   174	483	3	bool	boolean
    //   7	711	4	localObject1	Object
    //   839	3	4	localException1	Exception
    //   889	1	4	localException2	Exception
    //   1	891	5	localObject2	Object
    //   514	313	6	localAIOFileVideoData	AIOFileVideoData
    //   31	788	7	localObject3	Object
    //   444	204	8	localDownloadFileConfig	DownloadFileConfig
    // Exception table:
    //   from	to	target	type
    //   684	723	839	java/lang/Exception
    //   736	756	839	java/lang/Exception
    //   816	836	839	java/lang/Exception
    //   676	684	857	finally
    //   684	723	881	finally
    //   736	756	881	finally
    //   816	836	881	finally
    //   841	846	885	finally
    //   676	684	889	java/lang/Exception
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
      paramQQAppInterface.a(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "handleComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
      }
    }
  }
  
  private static AIORichMediaData c(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
      return null;
    }
    if (FileManagerUtil.a(((MessageForTroopFile)paramChatMessage).fileName) != 2)
    {
      QLog.e("AIOGalleryUtils", 1, "unknow file Type");
      return null;
    }
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is deleted!");
      }
      return null;
    }
    if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 4) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is:" + localTroopFileStatusInfo.jdField_b_of_type_Int);
      }
      return null;
    }
    if ((FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && ((localTroopFileStatusInfo.jdField_b_of_type_Int == 1) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 2) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 3)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " file is:" + localTroopFileStatusInfo.jdField_b_of_type_Int);
      }
      return null;
    }
    DownloadFileConfig localDownloadFileConfig = ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(localTroopFileStatusInfo.jdField_g_of_type_JavaLangString));
    Object localObject = localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    paramQQAppInterface = (QQAppInterface)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramQQAppInterface = localTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    localObject = paramQQAppInterface;
    if (localMessageForTroopFile.isMultiMsg)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = FileManagerUtil.a(localMessageForTroopFile);
      }
    }
    paramQQAppInterface = new AIOFileVideoData((String)localObject);
    paramQQAppInterface.jdField_h_of_type_JavaLangString = localMessageForTroopFile.frienduin;
    paramQQAppInterface.jdField_c_of_type_Int = localMessageForTroopFile.istroop;
    paramQQAppInterface.jdField_d_of_type_Int = localMessageForTroopFile.issend;
    paramQQAppInterface.jdField_f_of_type_Long = localMessageForTroopFile.uniseq;
    paramQQAppInterface.jdField_g_of_type_Long = localMessageForTroopFile.time;
    paramQQAppInterface.jdField_i_of_type_Long = localMessageForTroopFile.shmsgseq;
    paramQQAppInterface.jdField_h_of_type_Long = localMessageForTroopFile.fileSize;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localMessageForTroopFile.fileName;
    paramQQAppInterface.jdField_g_of_type_Int = localMessageForTroopFile.istroop;
    paramQQAppInterface.jdField_a_of_type_Long = localDownloadFileConfig.jdField_b_of_type_Int;
    paramQQAppInterface.jdField_a_of_type_Int = localMessageForTroopFile.width;
    paramQQAppInterface.jdField_b_of_type_Int = localMessageForTroopFile.height;
    if (FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
    {
      paramQQAppInterface.jdField_c_of_type_JavaLangString = localTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      paramQQAppInterface.jdField_c_of_type_Boolean = true;
    }
    paramQQAppInterface.jdField_k_of_type_Boolean = paramChatMessage.isMultiMsg;
    return paramQQAppInterface;
  }
  
  private static AIORichMediaData d(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (MessageForDLFile)paramChatMessage;
    Object localObject2 = paramQQAppInterface.getMessageFacade().a(((MessageForDLFile)localObject1).deviceType);
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((DatalineMessageManager)localObject2).a(((MessageForDLFile)localObject1).associatedId);
    if (localObject2 == null) {
      return null;
    }
    int i = FileManagerUtil.a(((DataLineMsgRecord)localObject2).filename);
    if (i == 0)
    {
      paramQQAppInterface = new AIOFilePicData();
      paramQQAppInterface.a((DataLineMsgRecord)localObject2);
    }
    for (;;)
    {
      paramQQAppInterface.jdField_f_of_type_Long = paramChatMessage.uniseq;
      paramQQAppInterface.jdField_k_of_type_Boolean = paramChatMessage.isMultiMsg;
      return paramQQAppInterface;
      if (i != 2) {
        break;
      }
      localObject1 = new AIOFileVideoData();
      ((AIOFileVideoData)localObject1).a((DataLineMsgRecord)localObject2);
      ((AIOFileVideoData)localObject1).jdField_a_of_type_Long = ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(((DataLineMsgRecord)localObject2).filename)).jdField_b_of_type_Int;
      paramQQAppInterface = (QQAppInterface)localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */