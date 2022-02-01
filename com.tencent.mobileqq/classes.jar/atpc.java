import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.1;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.2;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class atpc
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private atmg jdField_a_of_type_Atmg = new atpd(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<String, atpe> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<atpe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  public atpc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.3(this));
  }
  
  private void a(atpe paramatpe)
  {
    if (paramatpe == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramatpe.jdField_a_of_type_JavaLangString, paramatpe);
    } while (!QLog.isColorLevel());
    QLog.i("ThumbDownloadManager", 2, "addDownloadingTask : MapDowloadingTask currentSize[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = auea.g(paramString2);
    if (!a(paramString1, paramString2)) {
      return false;
    }
    atpe localatpe = new atpe();
    localatpe.b = paramString1;
    localatpe.jdField_a_of_type_JavaLangString = paramString2;
    localatpe.jdField_a_of_type_Long = paramLong;
    this.b.add(paramString2);
    this.jdField_a_of_type_JavaUtilList.add(localatpe);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.b.contains(paramString2)) {}
    while (FileUtil.fileExistsAndNotEmpty(paramString1)) {
      return false;
    }
    return true;
  }
  
  private void b(atpe paramatpe)
  {
    if (paramatpe == null) {
      return;
    }
    new atmf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramatpe.jdField_a_of_type_Long, paramatpe.b, paramatpe.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atmg);
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
 * Qualified Name:     atpc
 * JD-Core Version:    0.7.0.1
 */