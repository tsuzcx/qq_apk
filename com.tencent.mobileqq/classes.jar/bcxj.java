import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class bcxj
  implements Manager
{
  public static long a;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  bcyl jdField_a_of_type_Bcyl;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoPreDownloader.2(this);
  List<bcxr> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  public PriorityBlockingQueue<bcxr> a;
  public AtomicBoolean a;
  public AtomicInteger a;
  List<bcxr> b;
  public PriorityBlockingQueue<bcxr> b;
  public AtomicInteger b;
  List<bcxr> c = Collections.synchronizedList(new LinkedList());
  List<bcxr> d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public bcxj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bcyl = new bcxk(this);
  }
  
  private String a(long paramLong, List<bcxr> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bcxr localbcxr = (bcxr)paramList.next();
      if ((localbcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (localbcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == paramLong))
      {
        this.jdField_a_of_type_JavaUtilList.remove(localbcxr);
        return localbcxr.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = azkc.a(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i == 0) || (i == 1))
    {
      int j = paramQQAppInterface.getTroopMask(paramMessageForShortVideo.frienduin);
      if ((j == 2) || (j == 3) || (j == 4)) {
        return false;
      }
    }
    if (i == 2)
    {
      antp localantp = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localantp != null)
      {
        paramQQAppInterface = localantp.a(paramMessageForShortVideo.frienduin, paramQQAppInterface.getCurrentAccountUin());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  bcxr a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      bcxr localbcxr1;
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        localbcxr1 = (bcxr)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localbcxr1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          localbcxr1 = (bcxr)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localbcxr1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        bcxr localbcxr2 = (bcxr)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localbcxr2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        bcxr localbcxr3 = (bcxr)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localbcxr3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  protected String a(long paramLong)
  {
    Object localObject = a(paramLong, this.jdField_a_of_type_JavaUtilList);
    if (localObject != null) {}
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          str = a(paramLong, this.c);
          localObject = str;
        } while (str != null);
        str = a(paramLong, this.d);
        localObject = str;
      } while (str != null);
      str = a(paramLong, this.jdField_b_of_type_JavaUtilList);
      localObject = str;
    } while (str != null);
    return null;
  }
  
  Collection<bcxr> a(int paramInt)
  {
    a("getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.jdField_a_of_type_JavaUtilList;
    case 4: 
      return this.jdField_b_of_type_JavaUtilList;
    case 3: 
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    a("off", "mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
      return;
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
  }
  
  public void a(bcxr parambcxr)
  {
    bcwz.a(parambcxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.busiType);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    a("productFromMsg", "uniseq:" + paramMessageForShortVideo.uniseq + ", md5=" + paramMessageForShortVideo.md5);
    boolean bool = a(paramMessageForShortVideo, false);
    if (bool) {
      a(paramMessageForShortVideo, 1);
    }
    if ((!bool) && (a(paramMessageForShortVideo))) {
      b(paramMessageForShortVideo);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    a("add", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5 + " priority=" + paramInt);
    if ((paramMessageForShortVideo.uuid == null) && (paramMessageForShortVideo.md5 == null))
    {
      a("add", "msg.uuid and md5 are null");
      return;
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      a("add", "MessageRecord isSendFromLocal");
      return;
    }
    if (a(paramMessageForShortVideo, paramInt))
    {
      a("add", "skip uniseq:" + paramMessageForShortVideo.uniseq + "priority:" + paramInt);
      return;
    }
    Object localObject;
    int i;
    if ((paramMessageForShortVideo.isMultiMsg) && (!paramMessageForShortVideo.isSend()))
    {
      localObject = axio.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).curType;
        localObject = ((SessionInfo)localObject).curFriendUin;
      }
    }
    for (;;)
    {
      i = azkc.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask((String)localObject);
      if ((i == 0) || (j != 2)) {
        break;
      }
      a("add", "MSG_FILTER_NUM, no need to pre download short video");
      return;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
      continue;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
    }
    b(paramMessageForShortVideo, paramInt);
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002) {
      a("isNeedPredownloadThumb", "short video has expired");
    }
    for (;;)
    {
      return false;
      if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long)
      {
        a("isNeedPredownloadThumb", "out of validity, no need to pre download");
        return false;
      }
      boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694758), "qqsetting_auto_receive_pic_key", true);
      if ((NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) || (bool)) {}
      for (int i = 1; (azjg.a) || (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    a("filter", "uuid=" + paramMessageForShortVideo.uuid + " uniseq=" + paramMessageForShortVideo.uniseq + " priority=" + paramInt);
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForShortVideo.uuid);
    if (localInteger == null)
    {
      a("filter", "msg cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection == null)
    {
      a("filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label294:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (bcxr)localIterator.next();
          if (((bcxr)localObject2).jdField_a_of_type_Bcxb.jdField_a_of_type_Long != paramMessageForShortVideo.uniseq) {
            break label294;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label294;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          a("filter", "No need to update the short video request");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.d = localObject1.c;
      localObject1.c = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForShortVideo.uuid, Integer.valueOf(paramInt));
      a("filter", "Updated the short video request");
      return bool1;
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a("isNeedPredownload", "short video has expired");
      return false;
    }
    if (paramMessageForShortVideo.busiType == 0) {}
    for (AtomicInteger localAtomicInteger = ShortVideoUtils.getDefaultShortVideoStrategy(); (!paramBoolean) && (localAtomicInteger.get() == 1); localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      a("isNeedPredownload", "isFromAIO=false and mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if (localAtomicInteger.get() == 2)
    {
      a("isNeedPredownload", "mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if ((paramMessageForShortVideo.istroop == 0) && (paramMessageForShortVideo.msgtype == -2071)) {}
    for (int i = 1; (i == 0) && (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long); i = 0)
    {
      a("isNeedPredownload", "out of validity, no need to pre download");
      return false;
    }
    int j = azkc.a();
    if (i != 0)
    {
      if ((j != 0) && (j != 1))
      {
        a("isNeedPredownload", "Not Wifi or 4G, networkType=" + j + ", no need to predownload for lightvideo");
        return false;
      }
    }
    else if (j != 0)
    {
      a("isNeedPredownload", "Not Wifi, networkType=" + j + ", no need to predownload");
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a("on", "ShortVideoPreDownloader is on, mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    c();
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    a("consumeShortVideoThumb", null);
    Object localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      a("consumeShortVideoThumb", (String)localObject + " exists");
      return;
    }
    bcxr localbcxr = bcwz.a(2, paramMessageForShortVideo.busiType);
    bcxb localbcxb = paramMessageForShortVideo.getDownloadInfo(localbcxr.b);
    localbcxb.i = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0)
    {
      localbcxb.e = 1002;
      localbcxb.f = 2;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if ((!((QQMessageFacade)localObject).isChatting()) || (!((QQMessageFacade)localObject).getCurrChatUin().equals(paramMessageForShortVideo.frienduin))) {
        break label241;
      }
    }
    label241:
    for (localbcxb.g = 2;; localbcxb.g = 1)
    {
      localbcxr.a(localbcxb);
      localbcxr.a(paramMessageForShortVideo);
      int i = azkc.a();
      if ((PicPreDownloader.a) || (i == 0)) {
        break label250;
      }
      a("consumeShortVideoThumb", "screenOFF, no preDownload, networkType: " + i);
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localbcxr);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        localbcxb.e = 1006;
        break;
      }
      if (paramMessageForShortVideo.istroop != 1) {
        break;
      }
      localbcxb.e = 1004;
      break;
    }
    label250:
    ThreadManager.post(new ShortVideoPreDownloader.3(this, localbcxb, paramMessageForShortVideo, localbcxr), 5, null, false);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    a("handleShortVideo", " START uniseq=" + paramMessageForShortVideo.uniseq + ", uuid=" + paramMessageForShortVideo.uuid + ", priority=" + paramInt);
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
      a("handleShortVideo", "Video has already existed, path=" + (String)localObject);
    }
    bcxr localbcxr;
    do
    {
      return;
      localbcxr = bcwz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
    } while (localbcxr == null);
    localObject = null;
    String str = "";
    int i = azkc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 5)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      localbcxr.c = 5;
      paramMessageForShortVideo = "AIORequests";
      switch (i)
      {
      default: 
        localbcxr.d = 2;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        a("handleShortVideo", "successfully to add the short video request to " + paramMessageForShortVideo);
        ((List)localObject).add(localbcxr);
        this.jdField_a_of_type_JavaUtilMap.put(localbcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_JavaLangString, Integer.valueOf(localbcxr.c));
      }
      paramInt = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt >= 1) {
        break;
      }
      c();
      return;
      localbcxr.d = 4;
      continue;
      localbcxr.d = 3;
      continue;
      paramMessageForShortVideo = str;
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localObject = this.d;
          localbcxr.c = 2;
          localbcxr.d = localbcxr.c;
          paramMessageForShortVideo = "GroupRequests";
          break;
        case 3: 
          localObject = this.jdField_b_of_type_JavaUtilList;
          localbcxr.c = 4;
          localbcxr.d = localbcxr.c;
          paramMessageForShortVideo = "C2CRequests";
          break;
        case 2: 
          localObject = this.c;
          localbcxr.c = 3;
          localbcxr.d = localbcxr.c;
          paramMessageForShortVideo = "DiscussionRequests";
        }
      }
    }
    a("handleShortVideo", "mHandlingNum(" + paramInt + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
  }
  
  public void c()
  {
    a("consumeShortVideo", null);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      azjq.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
    }
    bcxr localbcxr;
    do
    {
      return;
      int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i >= 1)
      {
        a("consumeShortVideo", "handlingNum(" + i + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
        return;
      }
      localbcxr = a();
    } while (localbcxr == null);
    if (localbcxr.jdField_a_of_type_Bcxb == null)
    {
      a("consumeShortVideo", "req.downinfo == null");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove(localbcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localbcxr);
    localbcxr.d = localbcxr.c;
    localbcxr.c = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localbcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_JavaLangString, Integer.valueOf(6));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localbcxr.jdField_a_of_type_Bcyl = this.jdField_a_of_type_Bcyl;
    ThreadManager.post(new ShortVideoPreDownloader.4(this, localbcxr), 5, null, false);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = a(paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessageForShortVideo);
    }
  }
  
  public void d()
  {
    a("consumeAllThumbsInPendingQueue", null);
    int i = azkc.a();
    if ((!PicPreDownloader.a) && (i != 0))
    {
      a("consumeAllThumbsInPendingQueue", "screenOFF, no preDownload, networkType: " + i);
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.5(this), 5, null, false);
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxj
 * JD-Core Version:    0.7.0.1
 */