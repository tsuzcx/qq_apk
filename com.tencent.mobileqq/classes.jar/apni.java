import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class apni
  extends bdvu
{
  apni(apnf paramapnf, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    try
    {
      super.onDone(parambdvv);
      Bundle localBundle = parambdvv.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambdvv.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambdvv.h;
        long l2 = parambdvv.g;
        this.a.a(localBundle, parambdvv, bool, parambdvv.jdField_a_of_type_Int, parambdvv.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambdvv)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambdvv);
    }
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambdvv.a();
        i = ((Bundle)localObject).getInt(parambdvv.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambdvv);
        }
        apnf.jdField_a_of_type_Apne.b(localEmoticonPackage, (int)parambdvv.jdField_a_of_type_Long, (int)parambdvv.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambdvv.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            apnf.a(this.a, localEmoticonPackage.epId, (String)localObject, parambdvv.jdField_a_of_type_Int);
          }
        }
        if (parambdvv.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambdvv.jdField_a_of_type_Int);
          if (apnf.a(i)) {
            apnf.jdField_a_of_type_Apne.a(localEmoticonPackage, i, -1, parambdvv.jdField_a_of_type_Int);
          }
          bdqr.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambdvv.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (apnf.a(i))
        {
          apnf.jdField_a_of_type_Apne.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambdvv);
          return;
        }
      }
      catch (Exception parambdvv)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambdvv);
        return;
      }
      if (i == 7) {
        this.a.a(parambdvv);
      }
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambdvv.a().getSerializable("emoticonPackage");
    apnf.jdField_a_of_type_Apne.a(localEmoticonPackage);
    super.onStart(parambdvv);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apni
 * JD-Core Version:    0.7.0.1
 */