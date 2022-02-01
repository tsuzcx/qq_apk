import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class bilf
  extends biht
{
  bilf(bile parambile) {}
  
  public void onDone(bihu parambihu)
  {
    if (parambihu == null)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size()=" + this.a.jdField_a_of_type_JavaUtilArrayList.size() + ", url=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("VoiceChangeManager", 1, "picDownloadListener url = null");
          onDone(null);
        }
      }
      else
      {
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size() = 0");
        return;
      }
      File localFile = new File(bile.jdField_a_of_type_JavaLangString + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      parambihu = new Bundle();
      Object localObject = new bihu((String)localObject, localFile);
      ((bihu)localObject).n = true;
      ((bihw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1).a((bihu)localObject, this.a.jdField_a_of_type_Biht, parambihu);
      return;
    }
    super.onDone(parambihu);
    parambihu.a();
    if ((parambihu.a() == 3) && (parambihu.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + parambihu.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + parambihu.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilf
 * JD-Core Version:    0.7.0.1
 */