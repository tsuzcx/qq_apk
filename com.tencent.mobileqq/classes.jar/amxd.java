import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class amxd
{
  public int a;
  public long a;
  public amwo a;
  public amwt a;
  public amwv a;
  public amxf a;
  public amxl a;
  public amyk a;
  public amzt a;
  public avtj a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public amxd()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Amwo = null;
  }
  
  public static amwl a(ArrayList<ARRecognition> paramArrayList, amxd paramamxd)
  {
    amwl localamwl = new amwl();
    if (paramamxd == null) {
      return localamwl;
    }
    ampu localampu = ARRecognition.a(paramArrayList, paramamxd);
    if (localampu.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localamwl;
      if (paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_Boolean) {
        paramArrayList = paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_Amwl;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localampu.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localamwl;
        if (paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_Boolean) {
          paramArrayList = paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_Amwl;
        }
      }
      else if (localampu.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localamwl;
        if (paramamxd.jdField_a_of_type_Amyk.jdField_a_of_type_Boolean) {
          paramArrayList = paramamxd.jdField_a_of_type_Amyk.jdField_a_of_type_Amwl;
        }
      }
      else
      {
        paramArrayList = localamwl;
        if (localampu.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localamwl;
          if (paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_Boolean) {
            paramArrayList = paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_Amwl;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, amxd paramamxd)
  {
    Object localObject = null;
    if (paramamxd == null) {
      return null;
    }
    ampu localampu = ARRecognition.a(paramArrayList, paramamxd);
    if (localampu.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramamxd = amwn.a(new String(paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_ArrayOfAmwp[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramamxd != null) {
          paramArrayList = paramamxd.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramamxd = null;
        continue;
      }
      if (localampu.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramamxd = amwn.a(new String(paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_ArrayOfAmwu[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramamxd == null) {
            continue;
          }
          paramArrayList = paramamxd.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramamxd = null;
          }
        }
      }
      if (localampu.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramamxd.jdField_a_of_type_Amyk.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramamxd = amwn.a(new String(paramamxd.jdField_a_of_type_Amyk.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramamxd == null) {
            continue;
          }
          paramArrayList = paramamxd.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramamxd = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localampu.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramamxd = amwn.a(new String(paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_ArrayOfAmxm[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramamxd == null) {
          continue;
        }
        paramArrayList = paramamxd.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramamxd = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, amxd paramamxd)
  {
    if (paramamxd == null) {
      return "";
    }
    String str = "";
    ampu localampu = ARRecognition.a(paramArrayList, paramamxd);
    if (localampu.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_ArrayOfAmwp[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localampu.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_ArrayOfAmwu[0].jdField_a_of_type_JavaLangString;
      }
      else if (localampu.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_ArrayOfAmxm[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localampu.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramamxd.jdField_a_of_type_Amyk.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, amxd paramamxd, amwl paramamwl)
  {
    if (paramamxd == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramamwl.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramamxd);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_Amwl = paramamwl;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_Amwl = paramamwl;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramamxd.jdField_a_of_type_Amyk.jdField_a_of_type_Amwl = paramamwl;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_Amwl = paramamwl;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, amxd paramamxd)
  {
    boolean bool = false;
    if (paramamxd == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramamxd);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramamxd.jdField_a_of_type_Amwo.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramamxd.jdField_a_of_type_Amwt.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramamxd.jdField_a_of_type_Amyk.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramamxd.jdField_a_of_type_Amxl.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Amwo + ", objectClassifyResult = " + this.jdField_a_of_type_Amwt + ", faceResult = " + this.jdField_a_of_type_Amxf + ", ocrResult = " + this.jdField_a_of_type_Avtj + ", preOcrResult = " + this.jdField_a_of_type_Amwv + ", questionResult = " + this.jdField_a_of_type_Amzt + ", sceneRecogResult = " + this.jdField_a_of_type_Amxl + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */