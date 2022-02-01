import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apki
{
  public int a;
  public long a;
  public apjt a;
  public apjy a;
  public apka a;
  public apkk a;
  public apkq a;
  public aplp a;
  public apmy a;
  public aytu a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public apki()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Apjt = null;
  }
  
  public static apjq a(ArrayList<ARRecognition> paramArrayList, apki paramapki)
  {
    apjq localapjq = new apjq();
    if (paramapki == null) {
      return localapjq;
    }
    apde localapde = ARRecognition.a(paramArrayList, paramapki);
    if (localapde.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localapjq;
      if (paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_Boolean) {
        paramArrayList = paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_Apjq;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localapde.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localapjq;
        if (paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_Boolean) {
          paramArrayList = paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_Apjq;
        }
      }
      else if (localapde.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localapjq;
        if (paramapki.jdField_a_of_type_Aplp.jdField_a_of_type_Boolean) {
          paramArrayList = paramapki.jdField_a_of_type_Aplp.jdField_a_of_type_Apjq;
        }
      }
      else
      {
        paramArrayList = localapjq;
        if (localapde.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localapjq;
          if (paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_Boolean) {
            paramArrayList = paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_Apjq;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, apki paramapki)
  {
    Object localObject = null;
    if (paramapki == null) {
      return null;
    }
    apde localapde = ARRecognition.a(paramArrayList, paramapki);
    if (localapde.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramapki = apjs.a(new String(paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_ArrayOfApju[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapki != null) {
          paramArrayList = paramapki.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramapki = null;
        continue;
      }
      if (localapde.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapki = apjs.a(new String(paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_ArrayOfApjz[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramapki == null) {
            continue;
          }
          paramArrayList = paramapki.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapki = null;
          }
        }
      }
      if (localapde.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramapki.jdField_a_of_type_Aplp.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapki = apjs.a(new String(paramapki.jdField_a_of_type_Aplp.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramapki == null) {
            continue;
          }
          paramArrayList = paramapki.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapki = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localapde.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramapki = apjs.a(new String(paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_ArrayOfApkr[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapki == null) {
          continue;
        }
        paramArrayList = paramapki.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramapki = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, apki paramapki)
  {
    if (paramapki == null) {
      return "";
    }
    String str = "";
    apde localapde = ARRecognition.a(paramArrayList, paramapki);
    if (localapde.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_ArrayOfApju[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localapde.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_ArrayOfApjz[0].jdField_a_of_type_JavaLangString;
      }
      else if (localapde.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_ArrayOfApkr[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localapde.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramapki.jdField_a_of_type_Aplp.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, apki paramapki, apjq paramapjq)
  {
    if (paramapki == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramapjq.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramapki);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_Apjq = paramapjq;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_Apjq = paramapjq;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramapki.jdField_a_of_type_Aplp.jdField_a_of_type_Apjq = paramapjq;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_Apjq = paramapjq;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, apki paramapki)
  {
    boolean bool = false;
    if (paramapki == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramapki);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramapki.jdField_a_of_type_Apjt.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramapki.jdField_a_of_type_Apjy.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramapki.jdField_a_of_type_Aplp.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramapki.jdField_a_of_type_Apkq.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Apjt + ", objectClassifyResult = " + this.jdField_a_of_type_Apjy + ", faceResult = " + this.jdField_a_of_type_Apkk + ", ocrResult = " + this.jdField_a_of_type_Aytu + ", preOcrResult = " + this.jdField_a_of_type_Apka + ", questionResult = " + this.jdField_a_of_type_Apmy + ", sceneRecogResult = " + this.jdField_a_of_type_Apkq + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apki
 * JD-Core Version:    0.7.0.1
 */