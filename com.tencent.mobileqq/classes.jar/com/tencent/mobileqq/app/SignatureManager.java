package com.tencent.mobileqq.app;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignatureManager
  implements Handler.Callback, Manager
{
  public static final String a;
  public static ConcurrentHashMap<Integer, SignatureTemplateInfo> a;
  public static ConcurrentLinkedQueue<Runnable> a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  public static boolean a;
  public static SignatureTemplateConfig.SignatureTemplateType[] a;
  private static SignatureTemplateInfo jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo;
  public static final String b;
  public static final String c;
  public static int d;
  public static final String d;
  public static int e;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new SignatureManager.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = null;
  protected QQAppInterface a;
  private IPreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController;
  public SignatureTemplateInfo a;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public int b;
  private ConcurrentHashMap<String, RichStatus> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  public int c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".signatureTemplate/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    localStringBuilder.append("sign_tpl.json");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_c_of_type_JavaLangString = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("/temp");
    jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_d_of_type_Int = 1;
    e = 0;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController = ((IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class));
  }
  
  public static int a(String paramString, ListAdapter paramListAdapter)
  {
    int i = 0;
    while (i < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i);
      if (((localObject instanceof RichStatus)) && (((RichStatus)localObject).feedsId.equals(paramString))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      e -= 1;
      if ((e < jdField_d_of_type_Int) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()))
      {
        ThreadManagerV2.excute((Runnable)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll(), 32, null, true);
        e += 1;
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).isNewFriend(paramString)) {
        return false;
      }
      if (paramQQAppInterface.getCurrentAccountUin().equals(paramString)) {
        return true;
      }
      paramQQAppInterface = new SignatureManager.2(paramRichStatus, paramString);
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramQQAppInterface);
      a(false);
      return true;
    }
    return false;
  }
  
  public static boolean a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    SignatureTemplateInfo.DynamicItem[] arrayOfDynamicItem = paramSignatureTemplateInfo.a;
    boolean bool = false;
    if ((!TextUtils.isEmpty(arrayOfDynamicItem[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.a[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.a[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.a[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.a[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (SharpPUtil.isSharpPFile(new File(paramString))) {
      return true;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth != -1) && (((BitmapFactory.Options)localObject).outHeight != -1)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" is not a picture");
      QLog.d("Signature", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private static String b(RichStatus paramRichStatus)
  {
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("ver", "1.0");
        ((JSONObject)localObject1).put("time", String.valueOf(paramRichStatus.time));
        if ((paramRichStatus.actionText != null) && (paramRichStatus.actionText.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("aid", String.valueOf(paramRichStatus.actionId));
          ((JSONObject)localObject1).put("actiontext", paramRichStatus.actionText);
        }
        if ((paramRichStatus.dataText != null) && (paramRichStatus.dataText.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("did", String.valueOf(paramRichStatus.dataId));
          ((JSONObject)localObject1).put("datatext", paramRichStatus.dataText);
        }
        ((JSONObject)localObject1).put("loctextpos", String.valueOf(paramRichStatus.locationPosition));
        Object localObject2 = paramRichStatus.plainText;
        int k = 0;
        Object localObject3;
        if ((localObject2 != null) && (paramRichStatus.plainText.size() > 0))
        {
          j = paramRichStatus.plainText.size();
          localObject2 = new JSONArray();
          i = 0;
          if (i < j)
          {
            localObject3 = (String)paramRichStatus.plainText.get(i);
            if (localObject3 == null) {
              break label808;
            }
            ((JSONArray)localObject2).put(localObject3);
            break label808;
          }
          if (((JSONArray)localObject2).length() > 0) {
            ((JSONObject)localObject1).put("plaintext", localObject2);
          }
        }
        if (paramRichStatus.topics.size() > 0) {
          ((JSONObject)localObject1).put("topics", paramRichStatus.topicToJson());
        }
        if (paramRichStatus.topicsPos.size() > 0) {
          ((JSONObject)localObject1).put("topicsPos", paramRichStatus.topicPosToJson());
        }
        if ((paramRichStatus.locationText != null) && (paramRichStatus.locationText.trim().length() > 0)) {
          ((JSONObject)localObject1).put("loctext", paramRichStatus.locationText);
        }
        if (!TextUtils.isEmpty(paramRichStatus.feedsId)) {
          ((JSONObject)localObject1).put("feedid", paramRichStatus.feedsId);
        }
        ((JSONObject)localObject1).put("tplid", paramRichStatus.tplId);
        if ((paramRichStatus.sigZanInfo == null) || (paramRichStatus.sigZanInfo.get(Integer.valueOf(255)) == null)) {
          break label815;
        }
        i = ((RichStatus.SigZanInfo)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).jdField_b_of_type_Int;
        j = ((RichStatus.SigZanInfo)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).jdField_c_of_type_Int;
        ((JSONObject)localObject1).put("count", i);
        ((JSONObject)localObject1).put("zanfalg", j);
        if ((paramRichStatus.mStickerInfos != null) && (paramRichStatus.mStickerInfos.size() > 0))
        {
          localObject2 = new JSONArray();
          i = k;
          if (i < paramRichStatus.mStickerInfos.size())
          {
            localObject3 = (RichStatus.StickerInfo)paramRichStatus.mStickerInfos.get(i);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", ((RichStatus.StickerInfo)localObject3).id);
            localJSONObject.put("posX", ((RichStatus.StickerInfo)localObject3).posX);
            localJSONObject.put("posY", ((RichStatus.StickerInfo)localObject3).posY);
            localJSONObject.put("width", ((RichStatus.StickerInfo)localObject3).width);
            localJSONObject.put("height", ((RichStatus.StickerInfo)localObject3).height);
            ((JSONArray)localObject2).put(localJSONObject);
            i += 1;
            continue;
          }
          ((JSONObject)localObject1).put("sticker", localObject2);
        }
        ((JSONObject)localObject1).put("fontId", paramRichStatus.fontId);
        ((JSONObject)localObject1).put("fontType", paramRichStatus.fontType);
        if (((JSONObject)localObject1).length() <= 3)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("insertSignMsgIfNeeded sign is empty,rs.actionText is:");
            ((StringBuilder)localObject1).append(paramRichStatus.actionText);
            ((StringBuilder)localObject1).append(",rs.dataText is:");
            ((StringBuilder)localObject1).append(paramRichStatus.dataText);
            ((StringBuilder)localObject1).append(",rs.plainText is:");
            ((StringBuilder)localObject1).append(paramRichStatus.plainText);
            ((StringBuilder)localObject1).append(",rs.locationText is:");
            ((StringBuilder)localObject1).append(paramRichStatus.locationText);
            QLog.d("Signature", 2, ((StringBuilder)localObject1).toString());
          }
          return null;
        }
        return ((JSONObject)localObject1).toString();
      }
      catch (JSONException paramRichStatus)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("insertSignMsgIfNeeded failed,error msg is:");
          ((StringBuilder)localObject1).append(paramRichStatus.getMessage());
          QLog.d("Signature", 2, ((StringBuilder)localObject1).toString(), paramRichStatus);
        }
        return null;
      }
      label808:
      i += 1;
      continue;
      label815:
      int i = 0;
      int j = 0;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramRichStatus.tplId)))
    {
      paramQQAppInterface = SignatureTemplateConfig.a(paramQQAppInterface, paramRichStatus.tplId);
      if (paramQQAppInterface != null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramRichStatus.tplId), paramQQAppInterface);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, ExtensionInfo paramExtensionInfo, String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    BeancurdManager localBeancurdManager = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.frienduin = paramString2;
    localBeancurdMsg.busiid = 1;
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.ispush = false;
    localBeancurdMsg.startTime = NetConnInfoCenter.getServerTime();
    localBeancurdMsg.validTime = 2592000L;
    localBeancurdMsg.buffer = paramString1;
    localBeancurdManager.a(localBeancurdMsg);
    SharedPreUtils.b(paramQQAppInterface.getCurrentUin(), paramString2, l);
    if (paramExtensionInfo != null)
    {
      paramExtensionInfo.isAdded2C2C = true;
      ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramExtensionInfo);
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(paramRichStatus.tplId), "", "", "");
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, String paramString)
  {
    if ((!paramRichStatus.isEmpty()) && (!TextUtils.isEmpty(paramRichStatus.feedsId))) {
      return false;
    }
    paramRichStatus = paramQQAppInterface.getMessageFacade().a(paramString, 0, new int[] { -1034 });
    if (paramRichStatus != null)
    {
      paramRichStatus = paramRichStatus.iterator();
      while (paramRichStatus.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramRichStatus.next();
        paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        paramQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      }
    }
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramString, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "insertSignMsgIfNeeded delete signature");
    }
    SharedPreUtils.b(paramQQAppInterface.getCurrentUin(), paramString, 0L);
    return true;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface.getProxyManager().a().a(paramString, 0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "insertSignMsgIfNeeded fail ResentUser = null ");
      }
      return true;
    }
    return false;
  }
  
  private static boolean b(RichStatus paramRichStatus)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = paramRichStatus.time;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertSignMsgIfNeeded serverTime = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" richTime = ");
      localStringBuilder.append(paramRichStatus.time);
      QLog.d("Signature", 2, localStringBuilder.toString());
    }
    return l1 - l2 >= 604800L;
  }
  
  public static boolean b(String paramString)
  {
    paramString = SignatureTemplateConfig.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      if (!localFile.isDirectory()) {
        return false;
      }
      return FileUtils.getChildFiles(paramString).size() > 0;
    }
    return false;
  }
  
  public RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
      }
      finally {}
    }
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (localObject != null)
    {
      localObject = ExtensionRichStatus.a((ExtensionInfo)localObject);
      if (localObject != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RichStatus)localObject).feedsId, localObject);
      }
    }
    return (RichStatus)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      if (paramString != null)
      {
        localConcurrentHashMap.remove(paramString);
        return;
      }
      localConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  public void a(List<RichStatus> paramList)
  {
    if (paramList != null) {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)paramList.next();
          if (!TextUtils.isEmpty(localRichStatus.feedsId)) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localRichStatus.feedsId, localRichStatus);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return true;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo = null;
    a(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
    if (localObject != null) {
      ((DownloaderInterface)localObject).onDestroy();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */