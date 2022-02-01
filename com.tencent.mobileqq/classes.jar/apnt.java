import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apnt
{
  public int a;
  public long a;
  public apne a;
  public apnj a;
  public apnl a;
  public apnv a;
  public apob a;
  public appa a;
  public apqj a;
  public azad a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public apnt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Apne = null;
  }
  
  public static apnb a(ArrayList<ARRecognition> paramArrayList, apnt paramapnt)
  {
    apnb localapnb = new apnb();
    if (paramapnt == null) {
      return localapnb;
    }
    apgq localapgq = ARRecognition.a(paramArrayList, paramapnt);
    if (localapgq.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localapnb;
      if (paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_Boolean) {
        paramArrayList = paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_Apnb;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localapgq.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localapnb;
        if (paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_Boolean) {
          paramArrayList = paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_Apnb;
        }
      }
      else if (localapgq.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localapnb;
        if (paramapnt.jdField_a_of_type_Appa.jdField_a_of_type_Boolean) {
          paramArrayList = paramapnt.jdField_a_of_type_Appa.jdField_a_of_type_Apnb;
        }
      }
      else
      {
        paramArrayList = localapnb;
        if (localapgq.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localapnb;
          if (paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_Boolean) {
            paramArrayList = paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_Apnb;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, apnt paramapnt)
  {
    Object localObject = null;
    if (paramapnt == null) {
      return null;
    }
    apgq localapgq = ARRecognition.a(paramArrayList, paramapnt);
    if (localapgq.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramapnt = apnd.a(new String(paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_ArrayOfApnf[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapnt != null) {
          paramArrayList = paramapnt.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramapnt = null;
        continue;
      }
      if (localapgq.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapnt = apnd.a(new String(paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_ArrayOfApnk[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramapnt == null) {
            continue;
          }
          paramArrayList = paramapnt.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapnt = null;
          }
        }
      }
      if (localapgq.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramapnt.jdField_a_of_type_Appa.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapnt = apnd.a(new String(paramapnt.jdField_a_of_type_Appa.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramapnt == null) {
            continue;
          }
          paramArrayList = paramapnt.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapnt = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localapgq.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramapnt = apnd.a(new String(paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_ArrayOfApoc[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapnt == null) {
          continue;
        }
        paramArrayList = paramapnt.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramapnt = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, apnt paramapnt)
  {
    if (paramapnt == null) {
      return "";
    }
    String str = "";
    apgq localapgq = ARRecognition.a(paramArrayList, paramapnt);
    if (localapgq.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_ArrayOfApnf[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localapgq.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_ArrayOfApnk[0].jdField_a_of_type_JavaLangString;
      }
      else if (localapgq.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_ArrayOfApoc[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localapgq.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramapnt.jdField_a_of_type_Appa.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, apnt paramapnt, apnb paramapnb)
  {
    if (paramapnt == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramapnb.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramapnt);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_Apnb = paramapnb;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_Apnb = paramapnb;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramapnt.jdField_a_of_type_Appa.jdField_a_of_type_Apnb = paramapnb;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_Apnb = paramapnb;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, apnt paramapnt)
  {
    boolean bool = false;
    if (paramapnt == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramapnt);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramapnt.jdField_a_of_type_Apne.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramapnt.jdField_a_of_type_Apnj.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramapnt.jdField_a_of_type_Appa.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramapnt.jdField_a_of_type_Apob.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Apne + ", objectClassifyResult = " + this.jdField_a_of_type_Apnj + ", faceResult = " + this.jdField_a_of_type_Apnv + ", ocrResult = " + this.jdField_a_of_type_Azad + ", preOcrResult = " + this.jdField_a_of_type_Apnl + ", questionResult = " + this.jdField_a_of_type_Apqj + ", sceneRecogResult = " + this.jdField_a_of_type_Apob + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnt
 * JD-Core Version:    0.7.0.1
 */