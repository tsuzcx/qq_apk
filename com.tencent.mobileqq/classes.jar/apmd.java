import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class apmd
{
  protected static INetEngine.IBreakDownFix a;
  public QQAppInterface a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<apmj> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, apmi> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new apmh();
  }
  
  public apmd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2));
  }
  
  public boolean a(apmj paramapmj, apmi paramapmi)
  {
    if ((paramapmj == null) || (paramapmi == null)) {
      return false;
    }
    Object localObject1 = new apme(this, paramapmj);
    ??? = new apmf(this);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = ((INetEngine.INetEngineListener)???);
    localHttpNetReq.mReqUrl = paramapmj.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramapmj.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramapmj.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramapmj);
        switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new apmg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramapmj.b, (HttpEngineTask.IHttpEngineTask)localObject1, localHttpNetReq, paramapmj, paramapmi);
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(10065, "prd", paramapmj.b, 0, paramapmj.jdField_a_of_type_JavaLangString, localHttpNetReq.mOutPath, i, 0, false, (AbsPreDownloadTask)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramapmj.b, paramapmi);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramapmj.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
      int i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmd
 * JD-Core Version:    0.7.0.1
 */