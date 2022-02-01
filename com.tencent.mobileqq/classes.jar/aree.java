import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aree
  extends bgod
{
  aree(areb paramareb, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bgoe parambgoe)
  {
    try
    {
      super.onDone(parambgoe);
      Bundle localBundle = parambgoe.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambgoe.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambgoe.h;
        long l2 = parambgoe.g;
        this.a.a(localBundle, parambgoe, bool, parambgoe.jdField_a_of_type_Int, parambgoe.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambgoe)
    {
      QLog.e(areb.a(), 1, "onDone failed", parambgoe);
    }
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    int i;
    EmoticonPackage localEmoticonPackage;
    try
    {
      Object localObject = parambgoe.a();
      i = ((Bundle)localObject).getInt(parambgoe.c);
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(areb.a(), 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambgoe);
      }
      areb.jdField_a_of_type_Area.b(localEmoticonPackage, (int)parambgoe.jdField_a_of_type_Long, (int)parambgoe.b);
      if (i == 9)
      {
        localObject = ((Bundle)localObject).getString(parambgoe.c + "emoticonId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          areb.a(this.a, localEmoticonPackage.epId, (String)localObject, parambgoe.jdField_a_of_type_Int);
        }
      }
      if (parambgoe.jdField_a_of_type_Int != 0)
      {
        QLog.e(areb.a(), 1, "onDoneFile : ondone error , reportCode = " + parambgoe.jdField_a_of_type_Int);
        if (areb.a(i)) {
          areb.jdField_a_of_type_Area.a(localEmoticonPackage, i, -1, parambgoe.jdField_a_of_type_Int);
        }
        bggr.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambgoe.jdField_a_of_type_Int + "", "", "", "");
        return;
      }
    }
    catch (Exception parambgoe)
    {
      QLog.e(areb.a(), 1, "onDoneFile failed", parambgoe);
      return;
    }
    if (areb.a(i)) {
      areb.jdField_a_of_type_Area.a(localEmoticonPackage, i, 0, 0);
    }
    while ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      this.a.b(parambgoe);
      return;
      if (i == 7) {
        this.a.a(parambgoe);
      }
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambgoe.a().getSerializable("emoticonPackage");
    areb.jdField_a_of_type_Area.a(localEmoticonPackage);
    super.onStart(parambgoe);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aree
 * JD-Core Version:    0.7.0.1
 */