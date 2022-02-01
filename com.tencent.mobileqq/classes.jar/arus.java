import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class arus
  extends bhhe
{
  arus(arup paramarup, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhhf parambhhf)
  {
    try
    {
      super.onDone(parambhhf);
      Bundle localBundle = parambhhf.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambhhf.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambhhf.h;
        long l2 = parambhhf.g;
        this.a.a(localBundle, parambhhf, bool, parambhhf.jdField_a_of_type_Int, parambhhf.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambhhf)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambhhf);
    }
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambhhf.a();
        i = ((Bundle)localObject).getInt(parambhhf.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambhhf);
        }
        arup.jdField_a_of_type_Aruo.b(localEmoticonPackage, (int)parambhhf.jdField_a_of_type_Long, (int)parambhhf.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambhhf.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            arup.a(this.a, localEmoticonPackage.epId, (String)localObject, parambhhf.jdField_a_of_type_Int);
          }
        }
        if (parambhhf.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambhhf.jdField_a_of_type_Int);
          if (arup.a(i)) {
            arup.jdField_a_of_type_Aruo.a(localEmoticonPackage, i, -1, parambhhf.jdField_a_of_type_Int);
          }
          bhab.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambhhf.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (arup.a(i))
        {
          arup.jdField_a_of_type_Aruo.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambhhf);
          return;
        }
      }
      catch (Exception parambhhf)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambhhf);
        return;
      }
      if (i == 7) {
        this.a.a(parambhhf);
      }
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambhhf.a().getSerializable("emoticonPackage");
    arup.jdField_a_of_type_Aruo.a(localEmoticonPackage);
    super.onStart(parambhhf);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arus
 * JD-Core Version:    0.7.0.1
 */