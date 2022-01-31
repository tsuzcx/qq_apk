import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aprr
  extends bead
{
  aprr(apro paramapro, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(beae parambeae)
  {
    try
    {
      super.onDone(parambeae);
      Bundle localBundle = parambeae.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambeae.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambeae.h;
        long l2 = parambeae.g;
        this.a.a(localBundle, parambeae, bool, parambeae.jdField_a_of_type_Int, parambeae.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambeae)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambeae);
    }
  }
  
  public void onDoneFile(beae parambeae)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambeae.a();
        i = ((Bundle)localObject).getInt(parambeae.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambeae);
        }
        apro.jdField_a_of_type_Aprn.b(localEmoticonPackage, (int)parambeae.jdField_a_of_type_Long, (int)parambeae.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambeae.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            apro.a(this.a, localEmoticonPackage.epId, (String)localObject, parambeae.jdField_a_of_type_Int);
          }
        }
        if (parambeae.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambeae.jdField_a_of_type_Int);
          if (apro.a(i)) {
            apro.jdField_a_of_type_Aprn.a(localEmoticonPackage, i, -1, parambeae.jdField_a_of_type_Int);
          }
          bdva.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambeae.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (apro.a(i))
        {
          apro.jdField_a_of_type_Aprn.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambeae);
          return;
        }
      }
      catch (Exception parambeae)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambeae);
        return;
      }
      if (i == 7) {
        this.a.a(parambeae);
      }
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambeae.a().getSerializable("emoticonPackage");
    apro.jdField_a_of_type_Aprn.a(localEmoticonPackage);
    super.onStart(parambeae);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprr
 * JD-Core Version:    0.7.0.1
 */