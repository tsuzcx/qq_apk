import com.tencent.mobileqq.app.QQAppInterface;
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

public class aojb
{
  protected static INetEngine.IBreakDownFix a;
  public QQAppInterface a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<aojh> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, aojg> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aojf();
  }
  
  public aojb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public boolean a(aojh paramaojh, aojg paramaojg)
  {
    if ((paramaojh == null) || (paramaojg == null)) {
      return false;
    }
    Object localObject1 = new aojc(this, paramaojh);
    ??? = new aojd(this);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = ((INetEngine.INetEngineListener)???);
    localHttpNetReq.mReqUrl = paramaojh.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramaojh.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramaojh.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramaojh);
        switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new aoje(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaojh.b, (HttpEngineTask.IHttpEngineTask)localObject1, localHttpNetReq, paramaojh, paramaojg);
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(10065, "prd", paramaojh.b, 0, paramaojh.jdField_a_of_type_JavaLangString, localHttpNetReq.mOutPath, i, 0, false, (AbsPreDownloadTask)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramaojh.b, paramaojg);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramaojh.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     aojb
 * JD-Core Version:    0.7.0.1
 */