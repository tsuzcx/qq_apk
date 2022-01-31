import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class anrr
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, anrs> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public anrr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public anrs a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
      }
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      paramString = (anrs)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public void a(String paramString, anrs paramanrs)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramanrs == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.setPreprocessor in valid param");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, new Object[] { "AAShare.setPreprocessor app=", paramString });
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramanrs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrr
 * JD-Core Version:    0.7.0.1
 */