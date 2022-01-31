import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.1;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.2;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class aqvu
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqtn jdField_a_of_type_Aqtn = new aqvv(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<String, aqvw> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<aqvw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  public aqvu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.3(this));
  }
  
  private void a(aqvw paramaqvw)
  {
    if (paramaqvw == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramaqvw.jdField_a_of_type_JavaLangString, paramaqvw);
    } while (!QLog.isColorLevel());
    QLog.i("ThumbDownloadManager", 2, "addDownloadingTask : MapDowloadingTask currentSize[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = arni.g(paramString2);
    if (!a(paramString1, paramString2)) {
      return false;
    }
    aqvw localaqvw = new aqvw();
    localaqvw.b = paramString1;
    localaqvw.jdField_a_of_type_JavaLangString = paramString2;
    localaqvw.jdField_a_of_type_Long = paramLong;
    this.b.add(paramString2);
    this.jdField_a_of_type_JavaUtilList.add(localaqvw);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.b.contains(paramString2)) {}
    while (arof.b(paramString1)) {
      return false;
    }
    return true;
  }
  
  private void b(aqvw paramaqvw)
  {
    if (paramaqvw == null) {
      return;
    }
    new aqtm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaqvw.jdField_a_of_type_Long, paramaqvw.b, paramaqvw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqtn);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ThumbDownloadManager", 2, "removeDownloadingTask : MapDowloadingTask currentSize[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
    }
  }
  
  private void c(String paramString)
  {
    if (!this.b.remove(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[" + paramString + "]");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask currentSize[" + this.b.size() + "]");
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.1(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvu
 * JD-Core Version:    0.7.0.1
 */