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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
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
  public static int a(Context paramContext, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (IFavroamingDBManagerService)localQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if (localList != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
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
            ((IFavroamingDBManagerService)localObject).updateDeletedEmoticon((CustomEmotionData)localList.get(j), j);
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
    paramContext = ((IEmoAddedAuthCallbackService)QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (IFavroamingManagerService)localQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramString != null) {
      paramString.syncUpload((CustomEmotionData)localObject, paramContext);
    }
    return 0;
  }
  
  public static int a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOLightVideoData.class.isInstance(paramAIORichMediaData)) {
      return 3;
    }
    if ((!AIOShortVideoData.class.isInstance(paramAIORichMediaData)) && (!AIOFileVideoData.class.isInstance(paramAIORichMediaData))) {
      return 1;
    }
    return 2;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, PicMessageExtraData paramPicMessageExtraData, IEmoBatchAddedCallback paramIEmoBatchAddedCallback, int paramInt)
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
    File localFile = AbsDownloader.getFile(paramURLDrawable);
    paramURLDrawable = null;
    if (localFile != null) {
      paramURLDrawable = SecUtil.getFileMd5(localFile.getAbsolutePath());
    }
    if (paramURLDrawable != null)
    {
      String str = "";
      if (!"".equals(paramURLDrawable))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_FAVORITE);
        ((StringBuilder)localObject).append(".nomedia");
        FileUtils.createFileIfNotExits(((StringBuilder)localObject).toString());
        localObject = paramQQAppInterface.getCurrentAccountUin();
        int i;
        if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("_diydoutu@");
          if (TextUtils.isEmpty(paramPicMessageExtraData.emojiId)) {
            str = "0";
          } else {
            str = paramPicMessageExtraData.emojiId;
          }
          localStringBuilder.append(str);
          str = localStringBuilder.toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
        localStringBuilder.append(DiySecureFileHelper.a((String)localObject));
        localStringBuilder.append(paramURLDrawable);
        localStringBuilder.append(str);
        localStringBuilder.append(".jpg");
        paramURLDrawable = localStringBuilder.toString();
        try
        {
          FileUtils.copyFile(localFile, new File(paramURLDrawable));
          return a(paramQQAppInterface, paramPicMessageExtraData, paramIEmoBatchAddedCallback, paramInt, paramURLDrawable);
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.d("AIOGalleryUtils", 1, paramQQAppInterface, new Object[0]);
          return 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
    }
    return 1;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, PicMessageExtraData paramPicMessageExtraData, IEmoBatchAddedCallback paramIEmoBatchAddedCallback, int paramInt, String paramString)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath))) {
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)localList.get(i)).md5 != null) && (str.equals(((CustomEmotionData)localList.get(i)).md5)))
        {
          if ("needDel".equals(((CustomEmotionData)localList.get(i)).RomaingType))
          {
            ((IFavroamingDBManagerService)localObject).updateDeletedEmoticon((CustomEmotionData)localList.get(i), i);
            return 0;
          }
          return 2;
        }
        i += 1;
      }
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = paramInt;
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramIEmoBatchAddedCallback.a((CustomEmotionData)localObject);
    paramQQAppInterface = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.syncUpload((CustomEmotionData)localObject, paramIEmoBatchAddedCallback);
    }
    return 3;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if (localList != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        int m = ((CustomEmotionData)localList.get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath))) {
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)localList.get(j)).md5 != null) && (str.equals(((CustomEmotionData)localList.get(j)).md5)))
        {
          if ("needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType))
          {
            ((IFavroamingDBManagerService)localObject).updateDeletedEmoticon((CustomEmotionData)localList.get(j), j);
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
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
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramString = ((IEmoAddedAuthCallbackService)QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
    paramQQAppInterface = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.syncUpload((CustomEmotionData)localObject, paramString);
    }
    return 0;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
      return null;
    }
    int i = FileManagerUtil.c(paramMessageForTroopFile.fileName);
    boolean bool = true;
    if (i != 0)
    {
      QLog.e("AIOGalleryUtils", 1, "unknow file Type");
      return null;
    }
    if (localTroopFileStatusInfo.e == 12)
    {
      if (QLog.isColorLevel())
      {
        paramMessageForTroopFile = new StringBuilder();
        paramMessageForTroopFile.append("id:");
        paramMessageForTroopFile.append(localTroopFileStatusInfo.a);
        paramMessageForTroopFile.append(" file is deleted!");
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, paramMessageForTroopFile.toString());
      }
      return null;
    }
    if ((localTroopFileStatusInfo.e != 4) && (localTroopFileStatusInfo.e != 5))
    {
      if ((FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.k)) && ((localTroopFileStatusInfo.e == 1) || (localTroopFileStatusInfo.e == 2) || (localTroopFileStatusInfo.e == 3)))
      {
        if (QLog.isColorLevel())
        {
          paramMessageForTroopFile = new StringBuilder();
          paramMessageForTroopFile.append("id:");
          paramMessageForTroopFile.append(localTroopFileStatusInfo.a);
          paramMessageForTroopFile.append(" file is:");
          paramMessageForTroopFile.append(localTroopFileStatusInfo.e);
          QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, paramMessageForTroopFile.toString());
        }
        return null;
      }
      ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(localTroopFileStatusInfo.t));
      Object localObject = localTroopFileStatusInfo.n;
      if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
        FileManagerUtil.e(paramMessageForTroopFile);
      }
      localObject = new AIOFilePicData();
      ((AIOFilePicData)localObject).L = paramMessageForTroopFile.uniseq;
      ((AIOFilePicData)localObject).N = paramMessageForTroopFile.time;
      ((AIOFilePicData)localObject).P = paramMessageForTroopFile.shmsgseq;
      ((AIOFilePicData)localObject).O = paramMessageForTroopFile.fileSize;
      ((AIOFilePicData)localObject).a = paramMessageForTroopFile.frienduin;
      ((AIOFilePicData)localObject).b = paramMessageForTroopFile.istroop;
      ((AIOFilePicData)localObject).o = paramQQAppInterface.getCurrentAccountUin();
      ((AIOFilePicData)localObject).p = paramMessageForTroopFile.issend;
      ((AIOFilePicData)localObject).Q = paramMessageForTroopFile.istroop;
      ((AIOFilePicData)localObject).R = paramMessageForTroopFile.isMultiMsg;
      ((AIOFilePicData)localObject).u = paramMessageForTroopFile.width;
      ((AIOFilePicData)localObject).v = paramMessageForTroopFile.height;
      ((AIOFilePicData)localObject).w = localTroopFileStatusInfo.H;
      ((AIOFilePicData)localObject).r = paramMessageForTroopFile.url;
      if (localTroopFileStatusInfo.e != 8) {
        bool = false;
      }
      ((AIOFilePicData)localObject).s = bool;
      ((AIOFilePicData)localObject).a(localTroopFileStatusInfo);
      ((AIOFilePicData)localObject).T = MessageHandlerUtils.b(paramMessageForTroopFile);
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForTroopFile = new StringBuilder();
      paramMessageForTroopFile.append("id:");
      paramMessageForTroopFile.append(localTroopFileStatusInfo.a);
      paramMessageForTroopFile.append(" file is:");
      paramMessageForTroopFile.append(localTroopFileStatusInfo.e);
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, paramMessageForTroopFile.toString());
    }
    return null;
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.L = paramMessageForPic.uniseq;
    localAIOImageData.M = paramMessageForPic.subMsgId;
    localAIOImageData.N = paramMessageForPic.time;
    localAIOImageData.P = paramMessageForPic.shmsgseq;
    localAIOImageData.O = paramMessageForPic.size;
    localAIOImageData.Q = paramMessageForPic.istroop;
    localAIOImageData.q = paramMessageForPic.md5;
    localAIOImageData.A = paramMessageForPic.rawMsgUrl;
    localAIOImageData.B = paramMessageForPic.senderuin;
    localAIOImageData.F = paramMessageForPic.frienduin;
    Object localObject1;
    Object localObject2;
    if (AnonymousChatHelper.c(paramMessageForPic))
    {
      localObject1 = AnonymousChatHelper.g(paramMessageForPic);
      if ((((AnonymousChatHelper.AnonymousExtInfo)localObject1).b == null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject1).a != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryUtils", 2, "toAIOImageData anonymousExtInfo : an_id is null");
        }
      }
      else
      {
        localObject2 = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).a();
        if ((localObject2 != null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject1).a != 2))
        {
          localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
          AnonymousChatHelper.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
          localAIOImageData.G = true;
          localAIOImageData.I = AnonymousChatHelper.a().a(paramMessageForPic.frienduin, (String)localObject1);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("toAIOImageData, pic_server_url = ");
      ((StringBuilder)localObject1).append(localAIOImageData.A);
      ((StringBuilder)localObject1).append("  send_uin = ");
      ((StringBuilder)localObject1).append(localAIOImageData.B);
      QLog.d("AIOGalleryUtils", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramMessageForPic.picExtraData != null) {
      localAIOImageData.z = paramMessageForPic.picExtraData.doutuSupplier;
    }
    int i;
    if (paramMessageForPic.isMixed) {
      i = 1;
    } else {
      i = 65537;
    }
    localAIOImageData.a = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, i, "chatthumb").toString());
    if (paramMessageForPic.isMixed)
    {
      localAIOImageData.b = localAIOImageData.a;
    }
    else
    {
      localObject1 = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
      localAIOImageData.b = AbsDownloader.getFilePath(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.b);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.h = true;
        }
        localAIOImageData.d = AbsDownloader.getDisplayFilePath(((URL)localObject1).toString());
        if ((paramMessageForPic.mShowLength > 0) && (paramMessageForPic.mShowLength < paramMessageForPic.mDownloadLength)) {
          localAIOImageData.k = true;
        }
      }
    }
    if (paramMessageForPic.fileSizeFlag == 1) {
      localAIOImageData.c = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, 131075, null).toString());
    }
    localAIOImageData.n = paramMessageForPic.uuid;
    localAIOImageData.p = paramMessageForPic.groupFileID;
    localAIOImageData.l = paramMessageForPic.width;
    localAIOImageData.m = paramMessageForPic.height;
    localAIOImageData.j = paramMessageForPic.isSendFromLocal();
    localAIOImageData.i = paramMessageForPic.imageType;
    localAIOImageData.R = paramMessageForPic.isMultiMsg;
    localAIOImageData.E = paramMessageForPic.isSend();
    if (paramMessageForPic.picExtraData != null)
    {
      if (paramMessageForPic.picExtraData.isHotPics()) {
        localAIOImageData.r = 4;
      }
      localAIOImageData.D = paramMessageForPic.picExtraData.imageBizType;
      localAIOImageData.J = paramMessageForPic.picExtraData.mTemplateId;
      localAIOImageData.K = paramMessageForPic.picExtraData.mTemplateName;
    }
    localAIOImageData.S = paramMessageForPic.isInMixedMsg;
    localAIOImageData.T = MessageHandlerUtils.b(paramMessageForPic);
    return localAIOImageData;
  }
  
  public static AIORichMediaData a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    AIORichMediaData localAIORichMediaData = null;
    if (paramChatMessage == null) {
      return null;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      localAIORichMediaData = b(paramChatMessage, paramQQAppInterface);
    } else if ((paramChatMessage instanceof MessageForTroopFile)) {
      localAIORichMediaData = c(paramChatMessage, paramQQAppInterface);
    } else if ((paramChatMessage instanceof MessageForDLFile)) {
      localAIORichMediaData = d(paramChatMessage, paramQQAppInterface);
    }
    if (localAIORichMediaData != null)
    {
      QLog.i("AIOGalleryUtils<QFile>", 1, "toAIOFileMediaData: media data is null.");
      localAIORichMediaData.T = MessageHandlerUtils.b(paramChatMessage);
    }
    return localAIORichMediaData;
  }
  
  public static AIOShortVideoData a(MessageForShortVideo paramMessageForShortVideo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (IFavroamingDBManagerService)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
    }
    List localList = paramContext.getEmoticonDataList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(i);
          paramContext.updateDeletedEmoticon(paramString, i);
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
    if (paramAIORichMediaInfo != null)
    {
      if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.a)) {
        return;
      }
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramString1;
      AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
      paramString1 = localAIOImageData.a;
      if (!paramString1.endsWith("_hd"))
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append(paramString1);
        paramAIORichMediaInfo.append("_hd");
        paramAIORichMediaInfo = paramAIORichMediaInfo.toString();
        if (new File(paramAIORichMediaInfo).exists()) {
          paramString1 = paramAIORichMediaInfo;
        }
      }
      paramAIORichMediaInfo = localAIOImageData.n;
      long l2 = localAIOImageData.o;
      long l1;
      if (paramBoolean) {
        l1 = localAIOImageData.p;
      } else {
        l1 = 0L;
      }
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramAIORichMediaInfo, l2, l1, -1);
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
    while (localIterator.hasNext())
    {
      paramString1 = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(paramString1.a))
      {
        AIOImageData localAIOImageData = (AIOImageData)paramString1.a;
        localArrayList2.add(localAIOImageData.n);
        localArrayList3.add(Long.valueOf(localAIOImageData.o));
        if (paramBoolean) {
          localArrayList4.add(Long.valueOf(localAIOImageData.p));
        }
        paramList = localAIOImageData.a;
        paramString1 = paramList;
        if (!paramList.endsWith("_hd"))
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramList);
          paramString1.append("_hd");
          String str = paramString1.toString();
          paramString1 = paramList;
          if (new File(str).exists()) {
            paramString1 = str;
          }
        }
        localArrayList1.add(paramString1);
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("fowardToQZoneGroupAlbums(), uuid:");
          paramList.append(localAIOImageData.n);
          paramList.append(" time:");
          paramList.append(localAIOImageData.o);
          paramList.append(" path:");
          paramList.append(paramString1);
          QLog.d("AIOGalleryUtils", 2, paramList.toString());
        }
      }
    }
    QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fowardToGroupAlbum(),uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" qunId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" qunCode:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" uuid:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" time:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" path:");
      localStringBuilder.append(paramInt);
      QLog.d("AIOGalleryUtils", 2, localStringBuilder.toString());
    }
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fowardToGroupAlbumEx(),uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" qunId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" qunCode:");
      localStringBuilder.append(paramString3);
      QLog.d("AIOGalleryUtils", 2, localStringBuilder.toString());
    }
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new AIOGalleryUtils.1(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.c(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      IVipComicMqqManagerService localIVipComicMqqManagerService = (IVipComicMqqManagerService)paramQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
      paramQQAppInterface = new VipComicFavorEmoStructMsgInfo();
      paramQQAppInterface.picMd5 = paramCustomEmotionData.md5;
      paramQQAppInterface.actionData = paramStructMsgForImageShare;
      if (!paramQQAppInterface.equals(localIVipComicMqqManagerService.getComicStructInfo(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(paramQQAppInterface);
        localIVipComicMqqManagerService.setMyComicEmoticon(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel())
        {
          paramStructMsgForImageShare = new StringBuilder();
          paramStructMsgForImageShare.append("handleOldComicStructMsg , emoStructMsgInfo = ");
          paramStructMsgForImageShare.append(paramQQAppInterface);
          QLog.d("AIOGalleryUtils", 2, paramStructMsgForImageShare.toString());
        }
      }
    }
  }
  
  public static AIOImageData[] a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    int i = 0;
    if (paramMessageForMixedMsg == null) {
      return new AIOImageData[0];
    }
    paramMessageForMixedMsg = paramMessageForMixedMsg.getPicMsgList();
    if (paramMessageForMixedMsg == null) {
      return new AIOImageData[0];
    }
    AIOImageData[] arrayOfAIOImageData = new AIOImageData[paramMessageForMixedMsg.size()];
    while (i < paramMessageForMixedMsg.size())
    {
      arrayOfAIOImageData[i] = a((MessageForPic)paramMessageForMixedMsg.get(i));
      i += 1;
    }
    return arrayOfAIOImageData;
  }
  
  public static AIOImageData b(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.L = paramMessageForTroopFile.uniseq;
    boolean bool = false;
    localAIOImageData.M = 0;
    localAIOImageData.N = paramMessageForTroopFile.time;
    localAIOImageData.P = paramMessageForTroopFile.shmsgseq;
    localAIOImageData.O = paramMessageForTroopFile.fileSize;
    localAIOImageData.Q = paramMessageForTroopFile.istroop;
    localAIOImageData.C = true;
    localAIOImageData.B = paramMessageForTroopFile.senderuin;
    localAIOImageData.R = paramMessageForTroopFile.isMultiMsg;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toAIOImageData file, isFromFile = ");
      ((StringBuilder)localObject).append(localAIOImageData.C);
      ((StringBuilder)localObject).append("  send_uin = ");
      ((StringBuilder)localObject).append(localAIOImageData.B);
      QLog.d("AIOGalleryUtils", 2, ((StringBuilder)localObject).toString());
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo.n != null) {
      localObject = localTroopFileStatusInfo.n;
    } else {
      localObject = localTroopFileStatusInfo.l;
    }
    localAIOImageData.a = ((String)localObject);
    if (localAIOImageData.a == null) {
      localAIOImageData.a = "I:N";
    }
    if (!TextUtils.isEmpty(localTroopFileStatusInfo.m)) {
      localAIOImageData.b = localTroopFileStatusInfo.m;
    }
    if ((!TextUtils.isEmpty(localTroopFileStatusInfo.k)) && (FileUtils.fileExists(localTroopFileStatusInfo.k))) {
      localAIOImageData.c = localTroopFileStatusInfo.k;
    }
    if (localTroopFileStatusInfo.e == 8) {
      bool = true;
    }
    localAIOImageData.k = bool;
    localAIOImageData.n = paramMessageForTroopFile.uuid;
    localAIOImageData.p = localTroopFileStatusInfo.b;
    try
    {
      localObject = TroopFileItemBuilder.a(paramQQAppInterface.getApplication(), localTroopFileStatusInfo, paramMessageForTroopFile);
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject != null) {
        break label317;
      }
      paramQQAppInterface = URLDrawableHelper.getLoadingDrawable();
    }
    catch (Exception paramQQAppInterface)
    {
      label313:
      label317:
      break label313;
    }
    paramQQAppInterface = URLDrawableHelper.getLoadingDrawable();
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localObject = URLDrawableHelper.getLoadingDrawable();
    }
    localAIOImageData.l = ((Drawable)localObject).getIntrinsicWidth();
    localAIOImageData.m = ((Drawable)localObject).getIntrinsicHeight();
    localAIOImageData.j = paramMessageForTroopFile.isSendFromLocal();
    localAIOImageData.i = 1000;
    localAIOImageData.t = true;
    localAIOImageData.v = localTroopFileStatusInfo.t;
    localAIOImageData.w = localTroopFileStatusInfo.r;
    localAIOImageData.u = localTroopFileStatusInfo.i;
    localAIOImageData.x = localTroopFileStatusInfo.u;
    localAIOImageData.r = 3;
    return localAIOImageData;
  }
  
  /* Error */
  private static AIORichMediaData b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 689	com/tencent/mobileqq/data/MessageForFile
    //   4: astore 8
    //   6: aload_1
    //   7: invokevirtual 920	com/tencent/mobileqq/app/QQAppInterface:getFileManagerDataCenter	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   10: aload 8
    //   12: getfield 921	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   15: aload 8
    //   17: getfield 922	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   20: aload 8
    //   22: getfield 923	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   25: invokevirtual 928	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 6
    //   38: ifnonnull +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: aload 6
    //   45: getfield 933	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   48: istore_2
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_2
    //   52: ifne +188 -> 240
    //   55: new 385	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   58: dup
    //   59: invokespecial 386	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload 8
    //   68: getfield 921	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   71: putfield 393	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:L	J
    //   74: aload 4
    //   76: aload 8
    //   78: getfield 934	com/tencent/mobileqq/data/MessageForFile:time	J
    //   81: putfield 399	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:N	J
    //   84: aload 4
    //   86: aload 8
    //   88: getfield 935	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   91: putfield 405	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:P	J
    //   94: aload 4
    //   96: aload 8
    //   98: getfield 936	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   101: putfield 411	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:O	J
    //   104: aload 4
    //   106: aload 8
    //   108: getfield 922	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   111: putfield 416	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	Ljava/lang/String;
    //   114: aload 4
    //   116: aload 8
    //   118: getfield 923	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   121: putfield 421	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:b	I
    //   124: aload 4
    //   126: aload_1
    //   127: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   130: putfield 424	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:o	Ljava/lang/String;
    //   133: aload 4
    //   135: aload 8
    //   137: getfield 937	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   140: putfield 430	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:p	I
    //   143: aload 4
    //   145: aload_0
    //   146: getfield 940	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   149: putfield 433	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:Q	I
    //   152: aload 4
    //   154: aload_0
    //   155: getfield 941	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   158: putfield 436	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:R	Z
    //   161: aload 4
    //   163: aload 6
    //   165: getfield 944	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   168: putfield 459	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:r	Ljava/lang/String;
    //   171: aload 6
    //   173: getfield 947	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   176: iconst_2
    //   177: if_icmpne +6 -> 183
    //   180: goto +5 -> 185
    //   183: iconst_0
    //   184: istore_3
    //   185: aload 4
    //   187: iload_3
    //   188: putfield 462	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:s	Z
    //   191: aload 4
    //   193: aload 6
    //   195: getfield 950	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   198: putfield 951	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:t	Ljava/lang/String;
    //   201: aload 4
    //   203: aload 6
    //   205: getfield 954	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   208: putfield 442	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:u	I
    //   211: aload 4
    //   213: aload 6
    //   215: getfield 957	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   218: putfield 448	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:v	I
    //   221: aload 4
    //   223: aload 6
    //   225: getfield 960	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   228: putfield 453	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:w	I
    //   231: aload 4
    //   233: aload_1
    //   234: invokevirtual 963	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   237: aload 4
    //   239: areturn
    //   240: aload 6
    //   242: getfield 933	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   245: iconst_2
    //   246: if_icmpne +704 -> 950
    //   249: aload 6
    //   251: getfield 947	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   254: bipush 16
    //   256: if_icmpne +56 -> 312
    //   259: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +48 -> 310
    //   265: new 246	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   272: astore_0
    //   273: aload_0
    //   274: ldc_w 334
    //   277: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_0
    //   282: aload 6
    //   284: getfield 966	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   287: invokevirtual 781	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: ldc_w 968
    //   295: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc_w 970
    //   302: iconst_1
    //   303: aload_0
    //   304: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aconst_null
    //   311: areturn
    //   312: aload 6
    //   314: invokevirtual 973	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   317: ifeq +56 -> 373
    //   320: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +48 -> 371
    //   326: new 246	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   333: astore_0
    //   334: aload_0
    //   335: ldc_w 334
    //   338: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_0
    //   343: aload 6
    //   345: getfield 966	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   348: invokevirtual 781	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_0
    //   353: ldc_w 975
    //   356: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: ldc_w 970
    //   363: iconst_1
    //   364: aload_0
    //   365: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aconst_null
    //   372: areturn
    //   373: aload 6
    //   375: invokevirtual 977	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   378: invokestatic 353	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   381: istore_3
    //   382: iload_3
    //   383: ifeq +65 -> 448
    //   386: aload 6
    //   388: getfield 947	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   391: iconst_1
    //   392: if_icmpeq +56 -> 448
    //   395: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +48 -> 446
    //   401: new 246	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   408: astore_0
    //   409: aload_0
    //   410: ldc_w 334
    //   413: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_0
    //   418: aload 6
    //   420: getfield 966	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   423: invokevirtual 781	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_0
    //   428: ldc_w 979
    //   431: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc_w 970
    //   438: iconst_1
    //   439: aload_0
    //   440: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aconst_null
    //   447: areturn
    //   448: aload_1
    //   449: ldc_w 360
    //   452: ldc 151
    //   454: invokevirtual 363	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   457: checkcast 360	com/tencent/mobileqq/filemanager/api/IQFileConfigManager
    //   460: aload 6
    //   462: getfield 980	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   465: invokestatic 369	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokeinterface 373 2 0
    //   473: astore 9
    //   475: aload 6
    //   477: getfield 983	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   480: invokestatic 987	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   483: ifeq +12 -> 495
    //   486: aload 6
    //   488: getfield 983	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   491: astore_1
    //   492: goto +45 -> 537
    //   495: aload 6
    //   497: getfield 990	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   500: invokestatic 987	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   503: ifeq +12 -> 515
    //   506: aload 6
    //   508: getfield 990	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   511: astore_1
    //   512: goto +25 -> 537
    //   515: aload 6
    //   517: getfield 993	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   520: invokestatic 987	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   523: ifeq +12 -> 535
    //   526: aload 6
    //   528: getfield 993	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   531: astore_1
    //   532: goto +5 -> 537
    //   535: aconst_null
    //   536: astore_1
    //   537: aload_1
    //   538: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   541: ifeq +52 -> 593
    //   544: new 246	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   551: astore 7
    //   553: aload 7
    //   555: ldc_w 995
    //   558: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 7
    //   564: aload 6
    //   566: getfield 966	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   569: invokevirtual 781	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 7
    //   575: ldc_w 997
    //   578: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: ldc 45
    //   584: iconst_1
    //   585: aload 7
    //   587: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: new 191	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   596: dup
    //   597: aload_1
    //   598: invokespecial 998	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   601: astore 7
    //   603: aload 7
    //   605: aload 8
    //   607: getfield 922	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   610: putfield 999	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:r	Ljava/lang/String;
    //   613: aload 7
    //   615: aload 8
    //   617: getfield 923	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   620: putfield 1001	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:s	I
    //   623: aload 7
    //   625: aload 8
    //   627: getfield 937	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   630: putfield 1003	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:t	I
    //   633: aload 7
    //   635: aload 6
    //   637: getfield 944	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   640: putfield 1005	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:u	Ljava/lang/String;
    //   643: aload 7
    //   645: aload 6
    //   647: getfield 950	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   650: putfield 1006	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:v	Ljava/lang/String;
    //   653: aload 7
    //   655: aload 8
    //   657: getfield 921	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   660: putfield 1007	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:L	J
    //   663: aload 7
    //   665: aload 8
    //   667: getfield 934	com/tencent/mobileqq/data/MessageForFile:time	J
    //   670: putfield 1008	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:N	J
    //   673: aload 7
    //   675: aload 8
    //   677: getfield 935	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   680: putfield 1009	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:P	J
    //   683: aload 7
    //   685: aload 6
    //   687: getfield 1010	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   690: putfield 1011	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:O	J
    //   693: aload 7
    //   695: aload 6
    //   697: getfield 980	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   700: putfield 1012	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:a	Ljava/lang/String;
    //   703: aload 7
    //   705: aload_0
    //   706: getfield 940	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   709: putfield 1013	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:Q	I
    //   712: aload 7
    //   714: aload 6
    //   716: getfield 957	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   719: putfield 1016	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:f	I
    //   722: aload 7
    //   724: aload 6
    //   726: getfield 954	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   729: putfield 1017	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:e	I
    //   732: aload 7
    //   734: aload 9
    //   736: getfield 1020	com/tencent/mobileqq/filemanager/data/DownloadFileConfig:b	I
    //   739: i2l
    //   740: putfield 1022	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:d	J
    //   743: iload_3
    //   744: ifeq +194 -> 938
    //   747: aload 7
    //   749: aload 6
    //   751: invokevirtual 977	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   754: putfield 1023	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:c	Ljava/lang/String;
    //   757: aload 7
    //   759: iconst_1
    //   760: putfield 1025	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:o	Z
    //   763: aload 4
    //   765: astore_1
    //   766: new 1027	android/media/MediaMetadataRetriever
    //   769: dup
    //   770: invokespecial 1028	android/media/MediaMetadataRetriever:<init>	()V
    //   773: astore 4
    //   775: aload 4
    //   777: aload 7
    //   779: getfield 1023	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:c	Ljava/lang/String;
    //   782: invokevirtual 1031	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   785: aload 4
    //   787: bipush 24
    //   789: invokevirtual 1035	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   792: astore_1
    //   793: aload 4
    //   795: bipush 19
    //   797: invokevirtual 1035	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   800: astore 5
    //   802: aload 4
    //   804: bipush 18
    //   806: invokevirtual 1035	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   809: astore 6
    //   811: aload_1
    //   812: invokestatic 1040	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   815: istore_2
    //   816: iload_2
    //   817: bipush 90
    //   819: if_icmpeq +36 -> 855
    //   822: iload_2
    //   823: sipush 270
    //   826: if_icmpne +6 -> 832
    //   829: goto +26 -> 855
    //   832: aload 7
    //   834: aload 6
    //   836: invokestatic 1040	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   839: putfield 1017	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:e	I
    //   842: aload 7
    //   844: aload 5
    //   846: invokestatic 1040	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   849: putfield 1016	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:f	I
    //   852: goto +23 -> 875
    //   855: aload 7
    //   857: aload 5
    //   859: invokestatic 1040	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   862: putfield 1017	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:e	I
    //   865: aload 7
    //   867: aload 6
    //   869: invokestatic 1040	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   872: putfield 1016	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:f	I
    //   875: aload 4
    //   877: invokevirtual 1043	android/media/MediaMetadataRetriever:release	()V
    //   880: goto +58 -> 938
    //   883: astore_0
    //   884: aload 4
    //   886: astore_1
    //   887: goto +41 -> 928
    //   890: astore 5
    //   892: goto +15 -> 907
    //   895: astore_0
    //   896: goto +32 -> 928
    //   899: astore_1
    //   900: aload 5
    //   902: astore 4
    //   904: aload_1
    //   905: astore 5
    //   907: aload 4
    //   909: astore_1
    //   910: aload 5
    //   912: invokevirtual 1046	java/lang/Exception:printStackTrace	()V
    //   915: aload 4
    //   917: ifnull +21 -> 938
    //   920: aload 4
    //   922: invokevirtual 1043	android/media/MediaMetadataRetriever:release	()V
    //   925: goto +13 -> 938
    //   928: aload_1
    //   929: ifnull +7 -> 936
    //   932: aload_1
    //   933: invokevirtual 1043	android/media/MediaMetadataRetriever:release	()V
    //   936: aload_0
    //   937: athrow
    //   938: aload 7
    //   940: aload_0
    //   941: getfield 941	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   944: putfield 1047	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:R	Z
    //   947: aload 7
    //   949: areturn
    //   950: ldc 45
    //   952: iconst_1
    //   953: ldc_w 325
    //   956: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: aconst_null
    //   960: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	paramChatMessage	ChatMessage
    //   0	961	1	paramQQAppInterface	QQAppInterface
    //   48	779	2	i	int
    //   50	694	3	bool	boolean
    //   34	887	4	localObject1	Object
    //   31	827	5	str	String
    //   890	11	5	localException	Exception
    //   905	6	5	localQQAppInterface	QQAppInterface
    //   28	840	6	localObject2	Object
    //   551	397	7	localObject3	Object
    //   4	672	8	localMessageForFile	MessageForFile
    //   473	262	9	localDownloadFileConfig	DownloadFileConfig
    // Exception table:
    //   from	to	target	type
    //   775	816	883	finally
    //   832	852	883	finally
    //   855	875	883	finally
    //   775	816	890	java/lang/Exception
    //   832	852	890	java/lang/Exception
    //   855	875	890	java/lang/Exception
    //   766	775	895	finally
    //   910	915	895	finally
    //   766	775	899	java/lang/Exception
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.c(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      IVipComicMqqManagerService localIVipComicMqqManagerService = (IVipComicMqqManagerService)paramQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
      paramQQAppInterface = new VipComicFavorEmoStructMsgInfo();
      paramQQAppInterface.picMd5 = paramCustomEmotionData.md5;
      paramQQAppInterface.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(paramQQAppInterface);
      localIVipComicMqqManagerService.setMyComicEmoticon(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel())
      {
        paramStructMsgForImageShare = new StringBuilder();
        paramStructMsgForImageShare.append("handleComicStructMsg , emoStructMsgInfo = ");
        paramStructMsgForImageShare.append(paramQQAppInterface);
        QLog.d("AIOGalleryUtils", 2, paramStructMsgForImageShare.toString());
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
    if (FileManagerUtil.c(localMessageForTroopFile.fileName) != 2)
    {
      QLog.e("AIOGalleryUtils", 1, "unknow file Type");
      return null;
    }
    if (localTroopFileStatusInfo.e == 12)
    {
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("id:");
        paramChatMessage.append(localTroopFileStatusInfo.a);
        paramChatMessage.append(" file is deleted!");
        QLog.w("AIOGalleryUtilsFileVideo", 1, paramChatMessage.toString());
      }
      return null;
    }
    if ((localTroopFileStatusInfo.e != 4) && (localTroopFileStatusInfo.e != 5))
    {
      if ((FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.k)) && ((localTroopFileStatusInfo.e == 1) || (localTroopFileStatusInfo.e == 2) || (localTroopFileStatusInfo.e == 3)))
      {
        if (QLog.isColorLevel())
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append("id:");
          paramChatMessage.append(localTroopFileStatusInfo.a);
          paramChatMessage.append(" file is:");
          paramChatMessage.append(localTroopFileStatusInfo.e);
          QLog.w("AIOGalleryUtilsFileVideo", 1, paramChatMessage.toString());
        }
        return null;
      }
      DownloadFileConfig localDownloadFileConfig = ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(localTroopFileStatusInfo.t));
      Object localObject = localTroopFileStatusInfo.n;
      paramQQAppInterface = (QQAppInterface)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramQQAppInterface = localTroopFileStatusInfo.m;
      }
      localObject = paramQQAppInterface;
      if (localMessageForTroopFile.isMultiMsg)
      {
        localObject = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject = FileManagerUtil.e(localMessageForTroopFile);
        }
      }
      paramQQAppInterface = new AIOFileVideoData((String)localObject);
      paramQQAppInterface.r = localMessageForTroopFile.frienduin;
      paramQQAppInterface.s = localMessageForTroopFile.istroop;
      paramQQAppInterface.t = localMessageForTroopFile.issend;
      paramQQAppInterface.L = localMessageForTroopFile.uniseq;
      paramQQAppInterface.N = localMessageForTroopFile.time;
      paramQQAppInterface.P = localMessageForTroopFile.shmsgseq;
      paramQQAppInterface.O = localMessageForTroopFile.fileSize;
      paramQQAppInterface.a = localMessageForTroopFile.fileName;
      paramQQAppInterface.Q = localMessageForTroopFile.istroop;
      paramQQAppInterface.d = localDownloadFileConfig.b;
      paramQQAppInterface.e = localMessageForTroopFile.width;
      paramQQAppInterface.f = localMessageForTroopFile.height;
      if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.k))
      {
        paramQQAppInterface.c = localTroopFileStatusInfo.k;
        paramQQAppInterface.o = true;
      }
      paramQQAppInterface.R = paramChatMessage.isMultiMsg;
      return paramQQAppInterface;
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("id:");
      paramChatMessage.append(localTroopFileStatusInfo.a);
      paramChatMessage.append(" file is:");
      paramChatMessage.append(localTroopFileStatusInfo.e);
      QLog.w("AIOGalleryUtilsFileVideo", 1, paramChatMessage.toString());
    }
    return null;
  }
  
  private static AIORichMediaData d(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (MessageForDLFile)paramChatMessage;
    Object localObject2 = paramQQAppInterface.getMessageFacade().d(((MessageForDLFile)localObject1).deviceType);
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((DatalineMessageManager)localObject2).a(((MessageForDLFile)localObject1).associatedId);
    if (localObject2 == null) {
      return null;
    }
    int i = FileManagerUtil.c(((DataLineMsgRecord)localObject2).filename);
    if (i == 0)
    {
      paramQQAppInterface = new AIOFilePicData();
      paramQQAppInterface.a((DataLineMsgRecord)localObject2);
    }
    else
    {
      if (i != 2) {
        break label145;
      }
      localObject1 = new AIOFileVideoData();
      ((AIOFileVideoData)localObject1).a((DataLineMsgRecord)localObject2);
      ((AIOFileVideoData)localObject1).d = ((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(((DataLineMsgRecord)localObject2).filename)).b;
      paramQQAppInterface = (QQAppInterface)localObject1;
    }
    paramQQAppInterface.L = paramChatMessage.uniseq;
    paramQQAppInterface.R = paramChatMessage.isMultiMsg;
    return paramQQAppInterface;
    label145:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */