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

public class axed
  extends axeb
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  TVK_IDownloadMgr.ICallBackListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener = new axee(this);
  TVK_IDownloadMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private ArrayList<axef> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  List<axei> e = Collections.synchronizedList(new LinkedList());
  
  public axed(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(axei paramaxei)
  {
    if ((paramaxei == null) || (paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
        QLog.i("ShortVideoPreDownloader", 2, "downFullVideo, shortVideoReq.uuid = [" + paramaxei.jdField_a_of_type_JavaLangString + "],  initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160518, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener);
    }
    String str = ShortVideoUtils.a(paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramaxei.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramaxei.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      Object localObject = new StringBuilder();
      String[] arrayOfString = paramaxei.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(arrayOfString[i]);
        ((StringBuilder)localObject).append(";");
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160518, (String)localObject, paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, 0L, 0, str, 0);
      if (i <= 0) {
        break label442;
      }
      paramaxei.f = i;
    }
    for (;;)
    {
      this.e.add(paramaxei);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoPreDownloader", 2, " downFullVideo, add req to mSaveRequests, preLoadId = " + i + ", uniseq = " + paramaxei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
  
  axei a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      axei localaxei1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localaxei1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localaxei1;
      }
      synchronized (this.b)
      {
        localaxei1 = a(this.b);
        if (localaxei1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localaxei1;
        }
      }
    }
    synchronized (this.c)
    {
      axei localaxei2 = a(this.c);
      if (localaxei2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localaxei2;
      }
    }
    synchronized (this.d)
    {
      axei localaxei3 = a(this.d);
      if (localaxei3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localaxei3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  axei a(List<axei> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    axei localaxei;
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      localaxei = (axei)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localaxei;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localaxei = (axei)localIterator.next();
      if (localaxei.jdField_a_of_type_Axdt.jdField_a_of_type_Int != 0) {
        paramList.remove(localaxei);
      }
    }
    for (paramList = localaxei;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(asur paramasur)
  {
    if ((paramasur == null) || (paramasur.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramasur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramasur.a.jdField_a_of_type_Axdt.c;
    long l = paramasur.a.jdField_a_of_type_Axdt.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof ayow))) {
      ((ayow)localObject).a();
    }
    a(paramasur.a);
  }
  
  protected void a(axei paramaxei)
  {
    super.a(paramaxei);
    if (paramaxei.jdField_a_of_type_Axdt.jdField_a_of_type_Int == 0)
    {
      acvz localacvz = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localacvz != null)
      {
        paramaxei = new axef(this, paramaxei);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramaxei);
        localacvz.a(paramaxei.a, paramaxei);
      }
    }
  }
  
  public void b(asur paramasur)
  {
    if ((paramasur == null) || (paramasur.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramasur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bbmw localbbmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramasur.a.jdField_a_of_type_Axdt.c, paramasur.a.jdField_a_of_type_Axdt.jdField_a_of_type_Long);
      if ((localbbmw instanceof ayow)) {
        ((ayow)localbbmw).a();
      }
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) || (paramasur.a.f <= 0));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(paramasur.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axed
 * JD-Core Version:    0.7.0.1
 */