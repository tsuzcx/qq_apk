import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr.ICallBackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class awet
  extends awer
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  TVK_IDownloadMgr.ICallBackListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener = new aweu(this);
  TVK_IDownloadMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private ArrayList<awev> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  List<awey> e = Collections.synchronizedList(new LinkedList());
  
  public awet(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(awey paramawey)
  {
    if ((paramawey == null) || (paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        this.jdField_a_of_type_Boolean = true;
      }
      if ((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoPreDownloader", 2, "downFullVideo handle short video but sdk not installed");
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      }
    } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getDownloadMgr(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160518, "");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPreDownloader", 2, "downFullVideo, shortVideoReq.uuid = [" + paramawey.jdField_a_of_type_JavaLangString + "],  initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160518, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener);
    }
    String str = ShortVideoUtils.a(paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramawey.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramawey.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      Object localObject = new StringBuilder();
      String[] arrayOfString = paramawey.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(arrayOfString[i]);
        ((StringBuilder)localObject).append(";");
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160518, (String)localObject, paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, 0L, 0, str, 0);
      if (i <= 0) {
        break label442;
      }
      paramawey.f = i;
    }
    for (;;)
    {
      this.e.add(paramawey);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoPreDownloader", 2, " downFullVideo, add req to mSaveRequests, preLoadId = " + i + ", uniseq = " + paramawey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
      return;
      label442:
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, " downFullVideo error preLoadId = " + i);
      }
    }
  }
  
  awey a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      awey localawey1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localawey1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localawey1;
      }
      synchronized (this.b)
      {
        localawey1 = a(this.b);
        if (localawey1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localawey1;
        }
      }
    }
    synchronized (this.c)
    {
      awey localawey2 = a(this.c);
      if (localawey2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localawey2;
      }
    }
    synchronized (this.d)
    {
      awey localawey3 = a(this.d);
      if (localawey3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localawey3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  awey a(List<awey> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    awey localawey;
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      localawey = (awey)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localawey;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localawey = (awey)localIterator.next();
      if (localawey.jdField_a_of_type_Awej.jdField_a_of_type_Int != 0) {
        paramList.remove(localawey);
      }
    }
    for (paramList = localawey;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(aryl paramaryl)
  {
    if ((paramaryl == null) || (paramaryl.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramaryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramaryl.a.jdField_a_of_type_Awej.c;
    long l = paramaryl.a.jdField_a_of_type_Awej.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof axoo))) {
      ((axoo)localObject).a();
    }
    a(paramaryl.a);
  }
  
  protected void a(awey paramawey)
  {
    super.a(paramawey);
    if (paramawey.jdField_a_of_type_Awej.jdField_a_of_type_Int == 0)
    {
      aclk localaclk = aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaclk != null)
      {
        paramawey = new awev(this, paramawey);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramawey);
        localaclk.a(paramawey.a, paramawey);
      }
    }
  }
  
  public void b(aryl paramaryl)
  {
    if ((paramaryl == null) || (paramaryl.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramaryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      baky localbaky = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaryl.a.jdField_a_of_type_Awej.c, paramaryl.a.jdField_a_of_type_Awej.jdField_a_of_type_Long);
      if ((localbaky instanceof axoo)) {
        ((axoo)localbaky).a();
      }
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) || (paramaryl.a.f <= 0));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(paramaryl.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awet
 * JD-Core Version:    0.7.0.1
 */