import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class bdzf
  extends bdvu
{
  bdzf(bdze parambdze) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (parambdvv == null)
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
      File localFile = new File(bdze.jdField_a_of_type_JavaLangString + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      parambdvv = new Bundle();
      Object localObject = new bdvv((String)localObject, localFile);
      ((bdvv)localObject).n = true;
      ((bdvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1).a((bdvv)localObject, this.a.jdField_a_of_type_Bdvu, parambdvv);
      return;
    }
    super.onDone(parambdvv);
    parambdvv.a();
    if ((parambdvv.a() == 3) && (parambdvv.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + parambdvv.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + parambdvv.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzf
 * JD-Core Version:    0.7.0.1
 */