import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class askg
  extends biht
{
  askg(askd paramaskd, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    try
    {
      super.onDone(parambihu);
      Bundle localBundle = parambihu.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (parambihu.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = parambihu.h;
        long l2 = parambihu.g;
        this.a.a(localBundle, parambihu, bool, parambihu.jdField_a_of_type_Int, parambihu.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception parambihu)
    {
      QLog.e(askd.a(), 1, "onDone failed", parambihu);
    }
  }
  
  public void onDoneFile(bihu parambihu)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = parambihu.a();
        i = ((Bundle)localObject).getInt(parambihu.c);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(askd.a(), 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + parambihu);
        }
        askd.jdField_a_of_type_Askc.b(localEmoticonPackage, (int)parambihu.jdField_a_of_type_Long, (int)parambihu.b);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(parambihu.c + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            askd.a(this.a, localEmoticonPackage.epId, (String)localObject, parambihu.jdField_a_of_type_Int);
          }
        }
        if (parambihu.jdField_a_of_type_Int != 0)
        {
          QLog.e(askd.a(), 1, "onDoneFile : ondone error , reportCode = " + parambihu.jdField_a_of_type_Int);
          if (askd.a(i)) {
            askd.jdField_a_of_type_Askc.a(localEmoticonPackage, i, -1, parambihu.jdField_a_of_type_Int);
          }
          biah.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", parambihu.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (askd.a(i))
        {
          askd.jdField_a_of_type_Askc.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.a.b(parambihu);
          return;
        }
      }
      catch (Exception parambihu)
      {
        QLog.e(askd.a(), 1, "onDoneFile failed", parambihu);
        return;
      }
      if (i == 7) {
        this.a.a(parambihu);
      }
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)parambihu.a().getSerializable("emoticonPackage");
    askd.jdField_a_of_type_Askc.a(localEmoticonPackage);
    super.onStart(parambihu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askg
 * JD-Core Version:    0.7.0.1
 */