package com.tencent.mobileqq.app;

import aezm;
import aiej;
import amsw;
import anbc;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import anuz;
import bamu;
import bcef;
import bfyz;
import bgfm;
import bgfn;
import bgfo;
import bgfp;
import bgog;
import bgoj;
import bjmp;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
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
  public static ConcurrentHashMap<Integer, bgfo> a;
  public static ConcurrentLinkedQueue<Runnable> a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  public static boolean a;
  public static bgfn[] a;
  private static bgfo jdField_b_of_type_Bgfo;
  public static final String b;
  public static int c;
  public static final String c;
  public static int d;
  public static final String d;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new anbc(this);
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public bgfo a;
  private bgoj jdField_a_of_type_Bgoj;
  public QQAppInterface a;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public int b;
  private ConcurrentHashMap<String, RichStatus> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + ".signatureTemplate/";
    jdField_b_of_type_JavaLangString = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT + "sign_tpl.json";
    jdField_c_of_type_JavaLangString = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT;
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString + "/temp";
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bgoj = ((bgog)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
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
      jdField_d_of_type_Int -= 1;
      if ((jdField_d_of_type_Int < jdField_c_of_type_Int) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()))
      {
        ThreadManagerV2.excute((Runnable)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll(), 32, null, true);
        jdField_d_of_type_Int += 1;
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(bgfo parambgfo)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(parambgfo.a[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambgfo.a[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambgfo.a[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambgfo.a[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambgfo.a[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((aiej)paramQQAppInterface.getManager(34)).b(paramString)) {
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
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (SharpPUtil.isSharpPFile(new File(paramString))) {
        return true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Signature", 2, paramString + " is not a picture");
    return false;
  }
  
  private static String b(RichStatus paramRichStatus)
  {
    int k = 0;
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ver", "1.0");
        localJSONObject1.put("time", String.valueOf(paramRichStatus.time));
        if ((paramRichStatus.actionText != null) && (paramRichStatus.actionText.trim().length() > 0))
        {
          localJSONObject1.put("aid", String.valueOf(paramRichStatus.actionId));
          localJSONObject1.put("actiontext", paramRichStatus.actionText);
        }
        if ((paramRichStatus.dataText != null) && (paramRichStatus.dataText.trim().length() > 0))
        {
          localJSONObject1.put("did", String.valueOf(paramRichStatus.dataId));
          localJSONObject1.put("datatext", paramRichStatus.dataText);
        }
        localJSONObject1.put("loctextpos", String.valueOf(paramRichStatus.locationPosition));
        JSONArray localJSONArray;
        Object localObject;
        if ((paramRichStatus.plainText != null) && (paramRichStatus.plainText.size() > 0))
        {
          j = paramRichStatus.plainText.size();
          localJSONArray = new JSONArray();
          i = 0;
          if (i < j)
          {
            localObject = (String)paramRichStatus.plainText.get(i);
            if (localObject == null) {
              break label770;
            }
            localJSONArray.put(localObject);
            break label770;
          }
          if (localJSONArray.length() > 0) {
            localJSONObject1.put("plaintext", localJSONArray);
          }
        }
        if (paramRichStatus.topics.size() > 0) {
          localJSONObject1.put("topics", paramRichStatus.topicToJson());
        }
        if (paramRichStatus.topicsPos.size() > 0) {
          localJSONObject1.put("topicsPos", paramRichStatus.topicPosToJson());
        }
        if ((paramRichStatus.locationText != null) && (paramRichStatus.locationText.trim().length() > 0)) {
          localJSONObject1.put("loctext", paramRichStatus.locationText);
        }
        if (!TextUtils.isEmpty(paramRichStatus.feedsId)) {
          localJSONObject1.put("feedid", paramRichStatus.feedsId);
        }
        localJSONObject1.put("tplid", paramRichStatus.tplId);
        if ((paramRichStatus.sigZanInfo == null) || (paramRichStatus.sigZanInfo.get(Integer.valueOf(255)) == null)) {
          break label763;
        }
        j = ((bamu)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).jdField_b_of_type_Int;
        i = ((bamu)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).jdField_c_of_type_Int;
        localJSONObject1.put("count", j);
        localJSONObject1.put("zanfalg", i);
        if ((paramRichStatus.mStickerInfos != null) && (paramRichStatus.mStickerInfos.size() > 0))
        {
          localJSONArray = new JSONArray();
          i = k;
          if (i < paramRichStatus.mStickerInfos.size())
          {
            localObject = (RichStatus.StickerInfo)paramRichStatus.mStickerInfos.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("id", ((RichStatus.StickerInfo)localObject).id);
            localJSONObject2.put("posX", ((RichStatus.StickerInfo)localObject).posX);
            localJSONObject2.put("posY", ((RichStatus.StickerInfo)localObject).posY);
            localJSONObject2.put("width", ((RichStatus.StickerInfo)localObject).width);
            localJSONObject2.put("height", ((RichStatus.StickerInfo)localObject).height);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
          localJSONObject1.put("sticker", localJSONArray);
        }
        localJSONObject1.put("fontId", paramRichStatus.fontId);
        localJSONObject1.put("fontType", paramRichStatus.fontType);
        if (localJSONObject1.length() <= 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded sign is empty,rs.actionText is:" + paramRichStatus.actionText + ",rs.dataText is:" + paramRichStatus.dataText + ",rs.plainText is:" + paramRichStatus.plainText + ",rs.locationText is:" + paramRichStatus.locationText);
          }
          return null;
        }
      }
      catch (JSONException paramRichStatus)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insertSignMsgIfNeeded failed,error msg is:" + paramRichStatus.getMessage(), paramRichStatus);
        }
        return null;
      }
      return localJSONObject1.toString();
      label763:
      int i = 0;
      int j = 0;
      continue;
      label770:
      i += 1;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramRichStatus.tplId)))
    {
      paramQQAppInterface = bgfm.a(paramQQAppInterface, paramRichStatus.tplId);
      if (paramQQAppInterface != null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramRichStatus.tplId), paramQQAppInterface);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, ExtensionInfo paramExtensionInfo, String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    aezm localaezm = (aezm)paramQQAppInterface.getManager(282);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.frienduin = paramString2;
    localBeancurdMsg.busiid = 1;
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.ispush = false;
    localBeancurdMsg.startTime = NetConnInfoCenter.getServerTime();
    localBeancurdMsg.validTime = 2592000L;
    localBeancurdMsg.buffer = paramString1;
    localaezm.a(localBeancurdMsg);
    bfyz.b(paramQQAppInterface.getCurrentUin(), paramString2, l);
    if (paramExtensionInfo != null)
    {
      paramExtensionInfo.isAdded2C2C = true;
      ((amsw)paramQQAppInterface.getManager(51)).a(paramExtensionInfo);
    }
    bcef.b(paramQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(paramRichStatus.tplId), "", "", "");
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, String paramString)
  {
    boolean bool = false;
    if ((paramRichStatus.isEmpty()) || (TextUtils.isEmpty(paramRichStatus.feedsId)))
    {
      paramRichStatus = paramQQAppInterface.getMessageFacade().getAllMessages(paramString, 0, new int[] { -1034 });
      if (paramRichStatus != null)
      {
        paramRichStatus = paramRichStatus.iterator();
        while (paramRichStatus.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramRichStatus.next();
          paramQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
      ((aezm)paramQQAppInterface.getManager(282)).a(paramString, 0, 1);
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "insertSignMsgIfNeeded delete signature");
      }
      bfyz.b(paramQQAppInterface.getCurrentUin(), paramString, 0L);
      bool = true;
    }
    return bool;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((RecentUser)paramQQAppInterface.getProxyManager().a().findRecentUserByUin(paramString, 0) == null)
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
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "insertSignMsgIfNeeded serverTime = " + l1 + " richTime = " + paramRichStatus.time);
    }
    return l1 - l2 >= 604800L;
  }
  
  public static boolean b(String paramString)
  {
    paramString = bgfm.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (FileUtils.getChildFiles(paramString).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    try
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      Object localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject != null)
      {
        localObject = ((ExtensionInfo)localObject).getRichStatus();
        if (localObject != null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RichStatus)localObject).feedsId, localObject);
        }
      }
      return (RichStatus)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (paramString != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
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
    switch (paramMessage.what)
    {
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfBgfn = null;
    jdField_b_of_type_Bgfo = null;
    a(null);
    if (this.jdField_a_of_type_Bgoj != null) {
      this.jdField_a_of_type_Bgoj.b();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */