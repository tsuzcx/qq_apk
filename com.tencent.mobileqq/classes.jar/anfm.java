import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class anfm
  extends batl
{
  anfm(anfj paramanfj, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(batm parambatm)
  {
    try
    {
      super.onDone(parambatm);
      Bundle localBundle = parambatm.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambatm.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambatm.h;
        long l2 = parambatm.g;
        this.a.a(localBundle, parambatm, bool, parambatm.jdField_a_of_type_Int, parambatm.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambatm)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambatm);
    }
  }
  
  public void onDoneFile(batm parambatm)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambatm.a();
        i = ((Bundle)localObject).getInt(parambatm.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambatm);
        }
        anfj.jdField_a_of_type_Anfi.b(localEmoticonPackage, (int)parambatm.jdField_a_of_type_Long, (int)parambatm.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambatm.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            anfj.a(this.a, localEmoticonPackage.epId, (String)localObject, parambatm.jdField_a_of_type_Int);
          }
        }
        if (parambatm.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambatm.jdField_a_of_type_Int);
          if (anfj.a(i)) {
            anfj.jdField_a_of_type_Anfi.a(localEmoticonPackage, i, -1, parambatm.jdField_a_of_type_Int);
          }
          bapm.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambatm.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (anfj.a(i))
        {
          anfj.jdField_a_of_type_Anfi.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambatm);
          return;
        }
      }
      catch (Exception parambatm)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambatm);
        return;
      }
      if (i == 7) {
        this.a.a(parambatm);
      }
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambatm.a().getSerializable("emoticonPackage");
    anfj.jdField_a_of_type_Anfi.a(localEmoticonPackage);
    super.onStart(parambatm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfm
 * JD-Core Version:    0.7.0.1
 */