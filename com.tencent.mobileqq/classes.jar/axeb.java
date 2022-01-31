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

public class axeb
  extends axdz
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  TVK_IDownloadMgr.ICallBackListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener = new axec(this);
  TVK_IDownloadMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private ArrayList<axed> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  List<axeg> e = Collections.synchronizedList(new LinkedList());
  
  public axeb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(axeg paramaxeg)
  {
    if ((paramaxeg == null) || (paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
        QLog.i("ShortVideoPreDownloader", 2, "downFullVideo, shortVideoReq.uuid = [" + paramaxeg.jdField_a_of_type_JavaLangString + "],  initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160518, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr$ICallBackListener);
    }
    String str = ShortVideoUtils.a(paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramaxeg.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramaxeg.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      Object localObject = new StringBuilder();
      String[] arrayOfString = paramaxeg.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(arrayOfString[i]);
        ((StringBuilder)localObject).append(";");
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160518, (String)localObject, paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, 0L, 0, str, 0);
      if (i <= 0) {
        break label442;
      }
      paramaxeg.f = i;
    }
    for (;;)
    {
      this.e.add(paramaxeg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoPreDownloader", 2, " downFullVideo, add req to mSaveRequests, preLoadId = " + i + ", uniseq = " + paramaxeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
  
  axeg a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      axeg localaxeg1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localaxeg1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localaxeg1;
      }
      synchronized (this.b)
      {
        localaxeg1 = a(this.b);
        if (localaxeg1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localaxeg1;
        }
      }
    }
    synchronized (this.c)
    {
      axeg localaxeg2 = a(this.c);
      if (localaxeg2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localaxeg2;
      }
    }
    synchronized (this.d)
    {
      axeg localaxeg3 = a(this.d);
      if (localaxeg3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localaxeg3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  axeg a(List<axeg> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    axeg localaxeg;
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      localaxeg = (axeg)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localaxeg;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localaxeg = (axeg)localIterator.next();
      if (localaxeg.jdField_a_of_type_Axdr.jdField_a_of_type_Int != 0) {
        paramList.remove(localaxeg);
      }
    }
    for (paramList = localaxeg;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(asup paramasup)
  {
    if ((paramasup == null) || (paramasup.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramasup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramasup.a.jdField_a_of_type_Axdr.c;
    long l = paramasup.a.jdField_a_of_type_Axdr.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof ayou))) {
      ((ayou)localObject).a();
    }
    a(paramasup.a);
  }
  
  protected void a(axeg paramaxeg)
  {
    super.a(paramaxeg);
    if (paramaxeg.jdField_a_of_type_Axdr.jdField_a_of_type_Int == 0)
    {
      acwd localacwd = acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localacwd != null)
      {
        paramaxeg = new axed(this, paramaxeg);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramaxeg);
        localacwd.a(paramaxeg.a, paramaxeg);
      }
    }
  }
  
  public void b(asup paramasup)
  {
    if ((paramasup == null) || (paramasup.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramasup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bbmi localbbmi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramasup.a.jdField_a_of_type_Axdr.c, paramasup.a.jdField_a_of_type_Axdr.jdField_a_of_type_Long);
      if ((localbbmi instanceof ayou)) {
        ((ayou)localbbmi).a();
      }
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) || (paramasup.a.f <= 0));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(paramasup.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axeb
 * JD-Core Version:    0.7.0.1
 */