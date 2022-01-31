import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anbm
{
  public int a;
  public long a;
  public anax a;
  public anbc a;
  public anbe a;
  public anbo a;
  public anbu a;
  public anct a;
  public anec a;
  public avxs a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public anbm()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Anax = null;
  }
  
  public static anau a(ArrayList<ARRecognition> paramArrayList, anbm paramanbm)
  {
    anau localanau = new anau();
    if (paramanbm == null) {
      return localanau;
    }
    amuj localamuj = ARRecognition.a(paramArrayList, paramanbm);
    if (localamuj.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localanau;
      if (paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_Boolean) {
        paramArrayList = paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_Anau;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localamuj.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localanau;
        if (paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_Boolean) {
          paramArrayList = paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_Anau;
        }
      }
      else if (localamuj.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localanau;
        if (paramanbm.jdField_a_of_type_Anct.jdField_a_of_type_Boolean) {
          paramArrayList = paramanbm.jdField_a_of_type_Anct.jdField_a_of_type_Anau;
        }
      }
      else
      {
        paramArrayList = localanau;
        if (localamuj.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localanau;
          if (paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_Boolean) {
            paramArrayList = paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_Anau;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, anbm paramanbm)
  {
    Object localObject = null;
    if (paramanbm == null) {
      return null;
    }
    amuj localamuj = ARRecognition.a(paramArrayList, paramanbm);
    if (localamuj.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramanbm = anaw.a(new String(paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_ArrayOfAnay[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramanbm != null) {
          paramArrayList = paramanbm.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramanbm = null;
        continue;
      }
      if (localamuj.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramanbm = anaw.a(new String(paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_ArrayOfAnbd[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramanbm == null) {
            continue;
          }
          paramArrayList = paramanbm.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramanbm = null;
          }
        }
      }
      if (localamuj.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramanbm.jdField_a_of_type_Anct.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramanbm = anaw.a(new String(paramanbm.jdField_a_of_type_Anct.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramanbm == null) {
            continue;
          }
          paramArrayList = paramanbm.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramanbm = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localamuj.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramanbm = anaw.a(new String(paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_ArrayOfAnbv[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramanbm == null) {
          continue;
        }
        paramArrayList = paramanbm.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramanbm = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, anbm paramanbm)
  {
    if (paramanbm == null) {
      return "";
    }
    String str = "";
    amuj localamuj = ARRecognition.a(paramArrayList, paramanbm);
    if (localamuj.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_ArrayOfAnay[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localamuj.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_ArrayOfAnbd[0].jdField_a_of_type_JavaLangString;
      }
      else if (localamuj.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_ArrayOfAnbv[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localamuj.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramanbm.jdField_a_of_type_Anct.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, anbm paramanbm, anau paramanau)
  {
    if (paramanbm == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramanau.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramanbm);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_Anau = paramanau;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_Anau = paramanau;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramanbm.jdField_a_of_type_Anct.jdField_a_of_type_Anau = paramanau;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_Anau = paramanau;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, anbm paramanbm)
  {
    boolean bool = false;
    if (paramanbm == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramanbm);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramanbm.jdField_a_of_type_Anax.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramanbm.jdField_a_of_type_Anbc.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramanbm.jdField_a_of_type_Anct.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramanbm.jdField_a_of_type_Anbu.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Anax + ", objectClassifyResult = " + this.jdField_a_of_type_Anbc + ", faceResult = " + this.jdField_a_of_type_Anbo + ", ocrResult = " + this.jdField_a_of_type_Avxs + ", preOcrResult = " + this.jdField_a_of_type_Anbe + ", questionResult = " + this.jdField_a_of_type_Anec + ", sceneRecogResult = " + this.jdField_a_of_type_Anbu + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbm
 * JD-Core Version:    0.7.0.1
 */