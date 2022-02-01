import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aojl
{
  protected static INetEngine.IBreakDownFix a;
  public AppInterface a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<aojp> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aojn();
  }
  
  public aojl(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((aojp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq(((aojp)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(aojp paramaojp, aojo arg2)
  {
    if ((paramaojp == null) || (??? == null)) {
      return false;
    }
    ??? = new aojm(this, paramaojp, ???);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = ???;
    localHttpNetReq.mReqUrl = paramaojp.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramaojp.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
    paramaojp.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaojp);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramaojp.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojl
 * JD-Core Version:    0.7.0.1
 */