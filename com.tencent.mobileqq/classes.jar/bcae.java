import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class bcae
  extends bbwt
{
  bcae(bcad parambcad) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (parambbwu == null)
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
      File localFile = new File(bcad.jdField_a_of_type_JavaLangString + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      parambbwu = new Bundle();
      Object localObject = new bbwu((String)localObject, localFile);
      ((bbwu)localObject).n = true;
      ((bbww)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1).a((bbwu)localObject, this.a.jdField_a_of_type_Bbwt, parambbwu);
      return;
    }
    super.onDone(parambbwu);
    parambbwu.a();
    if ((parambbwu.a() == 3) && (parambbwu.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + parambbwu.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + parambbwu.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcae
 * JD-Core Version:    0.7.0.1
 */