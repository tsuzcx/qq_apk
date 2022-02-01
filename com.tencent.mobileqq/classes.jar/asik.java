import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class asik
  extends bhyn
{
  asik(asih paramasih, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    try
    {
      super.onDone(parambhyo);
      Bundle localBundle = parambhyo.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambhyo.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambhyo.h;
        long l2 = parambhyo.g;
        this.a.a(localBundle, parambhyo, bool, parambhyo.jdField_a_of_type_Int, parambhyo.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambhyo)
    {
      QLog.e(asih.a(), 1, "onDone failed", parambhyo);
    }
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    int i;
    EmoticonPackage localEmoticonPackage;
    try
    {
      Object localObject = parambhyo.a();
      i = ((Bundle)localObject).getInt(parambhyo.c);
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(asih.a(), 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambhyo);
      }
      asih.jdField_a_of_type_Asig.b(localEmoticonPackage, (int)parambhyo.jdField_a_of_type_Long, (int)parambhyo.b);
      if (i == 9)
      {
        localObject = ((Bundle)localObject).getString(parambhyo.c + "emoticonId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          asih.a(this.a, localEmoticonPackage.epId, (String)localObject, parambhyo.jdField_a_of_type_Int);
        }
      }
      if (parambhyo.jdField_a_of_type_Int != 0)
      {
        QLog.e(asih.a(), 1, "onDoneFile : ondone error , reportCode = " + parambhyo.jdField_a_of_type_Int);
        if (asih.a(i)) {
          asih.jdField_a_of_type_Asig.a(localEmoticonPackage, i, -1, parambhyo.jdField_a_of_type_Int);
        }
        bhpl.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambhyo.jdField_a_of_type_Int + "", "", "", "");
        return;
      }
    }
    catch (Exception parambhyo)
    {
      QLog.e(asih.a(), 1, "onDoneFile failed", parambhyo);
      return;
    }
    if (asih.a(i)) {
      asih.jdField_a_of_type_Asig.a(localEmoticonPackage, i, 0, 0);
    }
    while ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      this.a.b(parambhyo);
      return;
      if (i == 7) {
        this.a.a(parambhyo);
      }
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambhyo.a().getSerializable("emoticonPackage");
    asih.jdField_a_of_type_Asig.a(localEmoticonPackage);
    super.onStart(parambhyo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asik
 * JD-Core Version:    0.7.0.1
 */