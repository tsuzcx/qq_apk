import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class anvv
  extends bbwf
{
  anvv(anvs paramanvs, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    try
    {
      super.onDone(parambbwg);
      Bundle localBundle = parambbwg.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambbwg.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambbwg.h;
        long l2 = parambbwg.g;
        this.a.a(localBundle, parambbwg, bool, parambbwg.jdField_a_of_type_Int, parambbwg.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambbwg)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", parambbwg);
    }
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambbwg.a();
        i = ((Bundle)localObject).getInt(parambbwg.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambbwg);
        }
        anvs.jdField_a_of_type_Anvr.b(localEmoticonPackage, (int)parambbwg.jdField_a_of_type_Long, (int)parambbwg.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambbwg.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            anvs.a(this.a, localEmoticonPackage.epId, (String)localObject, parambbwg.jdField_a_of_type_Int);
          }
        }
        if (parambbwg.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + parambbwg.jdField_a_of_type_Int);
          if (anvs.a(i)) {
            anvs.jdField_a_of_type_Anvr.a(localEmoticonPackage, i, -1, parambbwg.jdField_a_of_type_Int);
          }
          bbrj.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambbwg.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (anvs.a(i))
        {
          anvs.jdField_a_of_type_Anvr.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambbwg);
          return;
        }
      }
      catch (Exception parambbwg)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", parambbwg);
        return;
      }
      if (i == 7) {
        this.a.a(parambbwg);
      }
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambbwg.a().getSerializable("emoticonPackage");
    anvs.jdField_a_of_type_Anvr.a(localEmoticonPackage);
    super.onStart(parambbwg);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */