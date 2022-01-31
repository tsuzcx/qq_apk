package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import vkr;
import vks;
import vkt;
import vku;
import vkv;

public class AIOGalleryUtils
{
  public static final Handler a = null;
  
  static
  {
    if (BaseApplicationImpl.sApplication.getProcessName().endsWith(":peak"))
    {
      a = new vkv();
      return;
    }
  }
  
  public static int a(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramContext.getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getFavEmoticonList from addCustomEmotionForEmoGroup.");
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
      localFavroamingDBManager.c((CustomEmotionData)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.bt))) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (FavroamingManager)paramContext.getManager(102);
      i = m;
    } while (paramContext == null);
    label260:
    paramContext.a((CustomEmotionData)localObject);
    return 0;
  }
  
  public static int a(Context paramContext, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (FavroamingDBManager)localQQAppInterface.getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getFavEmoticonList from addCustomEmotionForAIO.");
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
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.bt))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new EmoAddedAuthCallback(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (FavroamingManager)localQQAppInterface.getManager(102);
    if (paramString != null) {
      paramString.a((CustomEmotionData)localObject, paramContext);
    }
    return 0;
  }
  
  public static int a(AIORichMediaData paramAIORichMediaData)
  {
    if ((AIOShortVideoData.class.isInstance(paramAIORichMediaData)) || (AIOFileVideoData.class.isInstance(paramAIORichMediaData))) {
      return 2;
    }
    return 1;
  }
  
  public static AIOFilePicData a(MessageForFile paramMessageForFile, QQAppInterface paramQQAppInterface)
  {
    AIOFilePicData localAIOFilePicData = new AIOFilePicData();
    localAIOFilePicData.jdField_g_of_type_Long = paramMessageForFile.uniseq;
    localAIOFilePicData.jdField_h_of_type_Long = paramMessageForFile.time;
    localAIOFilePicData.jdField_i_of_type_Long = paramMessageForFile.fileSize;
    localAIOFilePicData.jdField_a_of_type_JavaLangString = paramMessageForFile.frienduin;
    localAIOFilePicData.jdField_a_of_type_Int = paramMessageForFile.istroop;
    localAIOFilePicData.jdField_f_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localAIOFilePicData.jdField_b_of_type_Int = paramMessageForFile.issend;
    localAIOFilePicData.a(paramQQAppInterface);
    return localAIOFilePicData;
  }
  
  public static AIOFileVideoData a(MessageForFile paramMessageForFile, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new AIOFileVideoData(paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop));
    paramQQAppInterface.jdField_g_of_type_Long = paramMessageForFile.uniseq;
    paramQQAppInterface.jdField_h_of_type_Long = paramMessageForFile.time;
    paramQQAppInterface.jdField_i_of_type_Long = paramMessageForFile.fileSize;
    return paramQQAppInterface;
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_g_of_type_Long = paramMessageForPic.uniseq;
    localAIOImageData.jdField_f_of_type_Int = paramMessageForPic.subMsgId;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForPic.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForPic.size;
    localAIOImageData.jdField_b_of_type_Int = paramMessageForPic.istroop;
    localAIOImageData.jdField_g_of_type_JavaLangString = paramMessageForPic.frienduin;
    localAIOImageData.jdField_e_of_type_Long = paramMessageForPic.shmsgseq;
    localAIOImageData.jdField_f_of_type_JavaLangString = paramMessageForPic.senderuin;
    localAIOImageData.jdField_h_of_type_JavaLangString = paramMessageForPic.md5;
    if (paramMessageForPic.picExtraData != null) {
      localAIOImageData.k = paramMessageForPic.picExtraData.doutuSupplier;
    }
    int i;
    if (paramMessageForPic.isMixed)
    {
      i = 1;
      localAIOImageData.jdField_a_of_type_JavaLangString = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label268;
      }
      localAIOImageData.jdField_b_of_type_JavaLangString = localAIOImageData.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.jdField_c_of_type_JavaLangString = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForPic.uuid;
      localAIOImageData.jdField_d_of_type_Long = paramMessageForPic.groupFileID;
      localAIOImageData.jdField_a_of_type_Long = paramMessageForPic.width;
      localAIOImageData.jdField_b_of_type_Long = paramMessageForPic.height;
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForPic.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = paramMessageForPic.imageType;
      if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isHotPics())) {
        localAIOImageData.jdField_c_of_type_Int = 4;
      }
      return localAIOImageData;
      i = 65537;
      break;
      label268:
      URL localURL = URLDrawableHelper.a(paramMessageForPic, 1, null);
      localAIOImageData.jdField_b_of_type_JavaLangString = AbsDownloader.d(localURL.toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        File localFile = new File(localAIOImageData.jdField_b_of_type_JavaLangString);
        if ((localFile.exists()) && (localFile.length() < l)) {
          localAIOImageData.jdField_d_of_type_Boolean = true;
        }
        localAIOImageData.jdField_d_of_type_JavaLangString = AbsDownloader.e(localURL.toString());
        if ((paramMessageForPic.mShowLength > 0) && (paramMessageForPic.mShowLength < paramMessageForPic.mDownloadLength)) {
          localAIOImageData.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static AIOImageData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_g_of_type_Long = paramMessageForTroopFile.uniseq;
    localAIOImageData.jdField_f_of_type_Int = 0;
    localAIOImageData.jdField_h_of_type_Long = paramMessageForTroopFile.time;
    localAIOImageData.jdField_i_of_type_Long = paramMessageForTroopFile.fileSize;
    localAIOImageData.jdField_b_of_type_Int = paramMessageForTroopFile.istroop;
    localAIOImageData.jdField_g_of_type_JavaLangString = paramMessageForTroopFile.frienduin;
    localAIOImageData.jdField_e_of_type_Long = paramMessageForTroopFile.shmsgseq;
    localAIOImageData.jdField_f_of_type_JavaLangString = paramMessageForTroopFile.senderuin;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo.jdField_d_of_type_JavaLangString != null) {}
    for (Object localObject = localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;; localObject = localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)
    {
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
      localAIOImageData.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.uuid;
      localAIOImageData.jdField_d_of_type_Long = localTroopFileStatusInfo.jdField_a_of_type_Int;
      try
      {
        localObject = TroopFileItemBuilder.a(paramQQAppInterface.getApplication(), localTroopFileStatusInfo, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = URLDrawableHelper.b();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = URLDrawableHelper.b();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = URLDrawableHelper.b();
      }
      localAIOImageData.jdField_a_of_type_Long = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.jdField_b_of_type_Long = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.jdField_e_of_type_Boolean = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.jdField_a_of_type_Int = 1000;
      localAIOImageData.jdField_g_of_type_Boolean = true;
      localAIOImageData.jdField_i_of_type_JavaLangString = localTroopFileStatusInfo.jdField_g_of_type_JavaLangString;
      localAIOImageData.j = localTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localAIOImageData.jdField_f_of_type_Long = localTroopFileStatusInfo.jdField_b_of_type_Long;
      localAIOImageData.jdField_d_of_type_Int = localTroopFileStatusInfo.jdField_e_of_type_Int;
      localAIOImageData.jdField_c_of_type_Int = 3;
      return localAIOImageData;
    }
  }
  
  public static AIOShortVideoData a(MessageForShortVideo paramMessageForShortVideo)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.jdField_g_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_h_of_type_Long = paramMessageForShortVideo.time;
    localAIOShortVideoData.jdField_i_of_type_Long = paramMessageForShortVideo.videoFileSize;
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localAIOShortVideoData.jdField_a_of_type_JavaLangString = str1;
    localAIOShortVideoData.jdField_b_of_type_JavaLangString = str2;
    localAIOShortVideoData.jdField_a_of_type_Int = paramMessageForShortVideo.videoFileTime;
    localAIOShortVideoData.jdField_b_of_type_Int = paramMessageForShortVideo.busiType;
    localAIOShortVideoData.jdField_c_of_type_Int = paramMessageForShortVideo.thumbWidth;
    localAIOShortVideoData.jdField_d_of_type_Int = paramMessageForShortVideo.thumbHeight;
    localAIOShortVideoData.jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.jdField_e_of_type_Int = paramMessageForShortVideo.redBagType;
    localAIOShortVideoData.jdField_c_of_type_JavaLangString = paramMessageForShortVideo.shortVideoId;
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = MsgProxyUtils.c(paramMessageForShortVideo);
    localAIOShortVideoData.jdField_g_of_type_Int = paramMessageForShortVideo.redBagStat;
    localAIOShortVideoData.jdField_e_of_type_JavaLangString = paramMessageForShortVideo.frienduin;
    localAIOShortVideoData.jdField_h_of_type_Int = paramMessageForShortVideo.istroop;
    if (paramMessageForShortVideo.isSend()) {}
    for (int i = 1;; i = 0)
    {
      localAIOShortVideoData.jdField_i_of_type_Int = i;
      localAIOShortVideoData.j = paramMessageForShortVideo.specialVideoType;
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (FavroamingDBManager)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getFavEmoticonList from getExitInCustomEmotionResp.");
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
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
    QZoneHelper.a(paramActivity, localUserInfo, paramIntent, paramString2, paramString3, paramString4, paramString5, paramInt1, paramArrayList, 7001, paramInt2);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    new File(AppConstants.aP).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = FileUtils.a(paramFile.getAbsolutePath());
      str = paramString + "." + str;
    }
    paramString = new File(AppConstants.aP, str);
    if (!paramString.exists()) {
      try
      {
        if (paramString.createNewFile()) {
          b(paramActivity, paramFile, paramString);
        }
        return;
      }
      catch (IOException paramFile)
      {
        do
        {
          QQToast.a(paramActivity, paramActivity.getString(2131434566), 0).a();
        } while (!QLog.isColorLevel());
        QLog.e("AIOGalleryUtils", 2, "", paramFile);
        return;
      }
    }
    DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131434569)).setMessage(paramActivity.getString(2131434571)).setPositiveButton(paramActivity.getString(2131434570), new vks(paramActivity, paramFile, paramString)).setNegativeButton(paramActivity.getString(2131432995), new vkr()).show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean, String paramString3)
  {
    if ((paramAIORichMediaInfo == null) || (!AIOImageData.class.isInstance(paramAIORichMediaInfo.a))) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
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
      QZoneHelper.a(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramAIORichMediaInfo, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
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
      QZoneHelper.a(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList3, paramInt);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new vku(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(140);
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
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2)
  {
    new vkt(paramFile2, paramFile1, paramActivity).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(140);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */