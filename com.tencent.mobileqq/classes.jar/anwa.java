import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class anwa
  extends bbwt
{
  anwa(anvx paramanvx, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    try
    {
      super.onDone(parambbwu);
      Bundle localBundle = parambbwu.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambbwu.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambbwu.h;
        long l2 = parambbwu.g;
        this.a.a(localBundle, parambbwu, bool, parambbwu.jdField_a_of_type_Int, parambbwu.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambbwu)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambbwu);
    }
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambbwu.a();
        i = ((Bundle)localObject).getInt(parambbwu.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambbwu);
        }
        anvx.jdField_a_of_type_Anvw.b(localEmoticonPackage, (int)parambbwu.jdField_a_of_type_Long, (int)parambbwu.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambbwu.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            anvx.a(this.a, localEmoticonPackage.epId, (String)localObject, parambbwu.jdField_a_of_type_Int);
          }
        }
        if (parambbwu.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambbwu.jdField_a_of_type_Int);
          if (anvx.a(i)) {
            anvx.jdField_a_of_type_Anvw.a(localEmoticonPackage, i, -1, parambbwu.jdField_a_of_type_Int);
          }
          bbrx.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambbwu.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (anvx.a(i))
        {
          anvx.jdField_a_of_type_Anvw.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambbwu);
          return;
        }
      }
      catch (Exception parambbwu)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambbwu);
        return;
      }
      if (i == 7) {
        this.a.a(parambbwu);
      }
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambbwu.a().getSerializable("emoticonPackage");
    anvx.jdField_a_of_type_Anvw.a(localEmoticonPackage);
    super.onStart(parambbwu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwa
 * JD-Core Version:    0.7.0.1
 */