import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
import mqq.manager.ServerConfigManager.ConfigType;

public class awer
  implements Manager
{
  public static long a;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  awfr jdField_a_of_type_Awfr;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoPreDownloader.2(this);
  List<awey> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  public PriorityBlockingQueue<awey> a;
  public AtomicBoolean a;
  public AtomicInteger a;
  List<awey> b;
  public PriorityBlockingQueue<awey> b;
  public AtomicInteger b;
  List<awey> c = Collections.synchronizedList(new LinkedList());
  List<awey> d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public awer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awfr = new awes(this);
  }
  
  private String a(long paramLong, List<awey> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      awey localawey = (awey)paramList.next();
      if ((localawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (localawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == paramLong))
      {
        this.jdField_a_of_type_JavaUtilList.remove(localawey);
        return localawey.jdField_a_of_type_JavaLangString;
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
    int i = atps.a(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i == 0) || (i == 1))
    {
      int j = paramQQAppInterface.b(paramMessageForShortVideo.frienduin);
      if ((j == 2) || (j == 3) || (j == 4)) {
        return false;
      }
    }
    if (i == 2)
    {
      ajhh localajhh = (ajhh)paramQQAppInterface.getManager(53);
      if (localajhh != null)
      {
        paramQQAppInterface = localajhh.a(paramMessageForShortVideo.frienduin, paramQQAppInterface.getCurrentAccountUin());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  awey a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      awey localawey1;
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        localawey1 = (awey)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localawey1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          localawey1 = (awey)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localawey1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        awey localawey2 = (awey)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localawey2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        awey localawey3 = (awey)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localawey3;
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
  
  Collection<awey> a(int paramInt)
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
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(awey paramawey)
  {
    aweg.a(paramawey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.busiType);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    a("productFromMsg", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5);
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
      localObject = arxu.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      i = atps.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
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
      boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131629640), "qqsetting_auto_receive_pic_key", true);
      if ((badq.b(BaseApplication.getContext()) == 1) || (bool)) {}
      for (int i = 1; ("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0); i = 0) {
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
          localObject2 = (awey)localIterator.next();
          if (((awey)localObject2).jdField_a_of_type_Awej.jdField_a_of_type_Long != paramMessageForShortVideo.uniseq) {
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
    for (AtomicInteger localAtomicInteger = ShortVideoUtils.a(); (!paramBoolean) && (localAtomicInteger.get() == 1); localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
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
    int j = atps.a();
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
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (bace.b((String)localObject))
    {
      a("consumeShortVideoThumb", (String)localObject + " exists");
      return;
    }
    awey localawey = aweg.a(2, paramMessageForShortVideo.busiType);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(localawey.b);
    localawej.i = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0)
    {
      localawej.e = 1002;
      localawej.f = 2;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!((QQMessageFacade)localObject).a()) || (!((QQMessageFacade)localObject).a().equals(paramMessageForShortVideo.frienduin))) {
        break label241;
      }
    }
    label241:
    for (localawej.g = 2;; localawej.g = 1)
    {
      localawey.a(localawej);
      localawey.a(paramMessageForShortVideo);
      int i = atps.a();
      if ((PicPreDownloader.a) || (i == 0)) {
        break label250;
      }
      a("consumeShortVideoThumb", "screenOFF, no preDownload, networkType: " + i);
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localawey);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        localawej.e = 1006;
        break;
      }
      if (paramMessageForShortVideo.istroop != 1) {
        break;
      }
      localawej.e = 1004;
      break;
    }
    label250:
    ThreadManager.post(new ShortVideoPreDownloader.3(this, localawej, paramMessageForShortVideo, localawey), 5, null, false);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    a("handleShortVideo", " START uniseq=" + paramMessageForShortVideo.uniseq + ", uuid=" + paramMessageForShortVideo.uuid + ", priority=" + paramInt);
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (bace.b((String)localObject)) {
      a("handleShortVideo", "Video has already existed, path=" + (String)localObject);
    }
    awey localawey;
    do
    {
      return;
      localawey = aweg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
    } while (localawey == null);
    localObject = null;
    String str = "";
    int i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 5)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      localawey.c = 5;
      paramMessageForShortVideo = "AIORequests";
      switch (i)
      {
      default: 
        localawey.d = 2;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        a("handleShortVideo", "successfully to add the short video request to " + paramMessageForShortVideo);
        ((List)localObject).add(localawey);
        this.jdField_a_of_type_JavaUtilMap.put(localawey.jdField_a_of_type_Awej.jdField_a_of_type_JavaLangString, Integer.valueOf(localawey.c));
      }
      paramInt = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt >= 1) {
        break;
      }
      c();
      return;
      localawey.d = 4;
      continue;
      localawey.d = 3;
      continue;
      paramMessageForShortVideo = str;
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localObject = this.d;
          localawey.c = 2;
          localawey.d = localawey.c;
          paramMessageForShortVideo = "GroupRequests";
          break;
        case 3: 
          localObject = this.jdField_b_of_type_JavaUtilList;
          localawey.c = 4;
          localawey.d = localawey.c;
          paramMessageForShortVideo = "C2CRequests";
          break;
        case 2: 
          localObject = this.c;
          localawey.c = 3;
          localawey.d = localawey.c;
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
      atpg.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
    }
    awey localawey;
    do
    {
      return;
      int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i >= 1)
      {
        a("consumeShortVideo", "handlingNum(" + i + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
        return;
      }
      localawey = a();
    } while (localawey == null);
    if (localawey.jdField_a_of_type_Awej == null)
    {
      a("consumeShortVideo", "req.downinfo == null");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove(localawey.jdField_a_of_type_Awej.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localawey);
    localawey.d = localawey.c;
    localawey.c = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localawey.jdField_a_of_type_Awej.jdField_a_of_type_JavaLangString, Integer.valueOf(6));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localawey.jdField_a_of_type_Awfr = this.jdField_a_of_type_Awfr;
    ThreadManager.post(new ShortVideoPreDownloader.4(this, localawey), 5, null, false);
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
    int i = atps.a();
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
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awer
 * JD-Core Version:    0.7.0.1
 */