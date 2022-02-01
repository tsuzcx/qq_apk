import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apad
{
  public int a;
  public long a;
  public aozo a;
  public aozt a;
  public aozv a;
  public apaf a;
  public apal a;
  public apbk a;
  public apct a;
  public ayhk a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public apad()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Aozo = null;
  }
  
  public static aozl a(ArrayList<ARRecognition> paramArrayList, apad paramapad)
  {
    aozl localaozl = new aozl();
    if (paramapad == null) {
      return localaozl;
    }
    aota localaota = ARRecognition.a(paramArrayList, paramapad);
    if (localaota.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localaozl;
      if (paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_Boolean) {
        paramArrayList = paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_Aozl;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localaota.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localaozl;
        if (paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_Boolean) {
          paramArrayList = paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_Aozl;
        }
      }
      else if (localaota.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localaozl;
        if (paramapad.jdField_a_of_type_Apbk.jdField_a_of_type_Boolean) {
          paramArrayList = paramapad.jdField_a_of_type_Apbk.jdField_a_of_type_Aozl;
        }
      }
      else
      {
        paramArrayList = localaozl;
        if (localaota.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localaozl;
          if (paramapad.jdField_a_of_type_Apal.jdField_a_of_type_Boolean) {
            paramArrayList = paramapad.jdField_a_of_type_Apal.jdField_a_of_type_Aozl;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, apad paramapad)
  {
    Object localObject = null;
    if (paramapad == null) {
      return null;
    }
    aota localaota = ARRecognition.a(paramArrayList, paramapad);
    if (localaota.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramapad = aozn.a(new String(paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_ArrayOfAozp[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapad != null) {
          paramArrayList = paramapad.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramapad = null;
        continue;
      }
      if (localaota.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapad = aozn.a(new String(paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_ArrayOfAozu[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramapad == null) {
            continue;
          }
          paramArrayList = paramapad.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapad = null;
          }
        }
      }
      if (localaota.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramapad.jdField_a_of_type_Apbk.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramapad = aozn.a(new String(paramapad.jdField_a_of_type_Apbk.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramapad == null) {
            continue;
          }
          paramArrayList = paramapad.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramapad = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localaota.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramapad.jdField_a_of_type_Apal.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramapad = aozn.a(new String(paramapad.jdField_a_of_type_Apal.jdField_a_of_type_ArrayOfApam[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramapad == null) {
          continue;
        }
        paramArrayList = paramapad.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramapad = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, apad paramapad)
  {
    if (paramapad == null) {
      return "";
    }
    String str = "";
    aota localaota = ARRecognition.a(paramArrayList, paramapad);
    if (localaota.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_ArrayOfAozp[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localaota.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_ArrayOfAozu[0].jdField_a_of_type_JavaLangString;
      }
      else if (localaota.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramapad.jdField_a_of_type_Apal.jdField_a_of_type_ArrayOfApam[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localaota.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramapad.jdField_a_of_type_Apbk.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, apad paramapad, aozl paramaozl)
  {
    if (paramapad == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramaozl.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramapad);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_Aozl = paramaozl;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_Aozl = paramaozl;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramapad.jdField_a_of_type_Apbk.jdField_a_of_type_Aozl = paramaozl;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramapad.jdField_a_of_type_Apal.jdField_a_of_type_Aozl = paramaozl;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, apad paramapad)
  {
    boolean bool = false;
    if (paramapad == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramapad);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramapad.jdField_a_of_type_Aozo.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramapad.jdField_a_of_type_Aozt.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramapad.jdField_a_of_type_Apbk.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramapad.jdField_a_of_type_Apal.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Aozo + ", objectClassifyResult = " + this.jdField_a_of_type_Aozt + ", faceResult = " + this.jdField_a_of_type_Apaf + ", ocrResult = " + this.jdField_a_of_type_Ayhk + ", preOcrResult = " + this.jdField_a_of_type_Aozv + ", questionResult = " + this.jdField_a_of_type_Apct + ", sceneRecogResult = " + this.jdField_a_of_type_Apal + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apad
 * JD-Core Version:    0.7.0.1
 */