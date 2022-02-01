import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aohg
{
  public int a;
  public long a;
  public aogr a;
  public aogw a;
  public aogy a;
  public aohi a;
  public aoho a;
  public aoin a;
  public aojw a;
  public axnl a;
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public aohg()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Aogr = null;
  }
  
  public static aogo a(ArrayList<ARRecognition> paramArrayList, aohg paramaohg)
  {
    aogo localaogo = new aogo();
    if (paramaohg == null) {
      return localaogo;
    }
    aoac localaoac = ARRecognition.a(paramArrayList, paramaohg);
    if (localaoac.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localaogo;
      if (paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_Boolean) {
        paramArrayList = paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_Aogo;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localaoac.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localaogo;
        if (paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_Boolean) {
          paramArrayList = paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_Aogo;
        }
      }
      else if (localaoac.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localaogo;
        if (paramaohg.jdField_a_of_type_Aoin.jdField_a_of_type_Boolean) {
          paramArrayList = paramaohg.jdField_a_of_type_Aoin.jdField_a_of_type_Aogo;
        }
      }
      else
      {
        paramArrayList = localaogo;
        if (localaoac.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localaogo;
          if (paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_Boolean) {
            paramArrayList = paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_Aogo;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, aohg paramaohg)
  {
    Object localObject = null;
    if (paramaohg == null) {
      return null;
    }
    aoac localaoac = ARRecognition.a(paramArrayList, paramaohg);
    if (localaoac.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramaohg = aogq.a(new String(paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_ArrayOfAogs[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramaohg != null) {
          paramArrayList = paramaohg.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramaohg = null;
        continue;
      }
      if (localaoac.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramaohg = aogq.a(new String(paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_ArrayOfAogx[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramaohg == null) {
            continue;
          }
          paramArrayList = paramaohg.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramaohg = null;
          }
        }
      }
      if (localaoac.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramaohg.jdField_a_of_type_Aoin.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramaohg = aogq.a(new String(paramaohg.jdField_a_of_type_Aoin.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramaohg == null) {
            continue;
          }
          paramArrayList = paramaohg.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramaohg = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localaoac.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramaohg = aogq.a(new String(paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_ArrayOfAohp[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramaohg == null) {
          continue;
        }
        paramArrayList = paramaohg.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramaohg = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, aohg paramaohg)
  {
    if (paramaohg == null) {
      return "";
    }
    String str = "";
    aoac localaoac = ARRecognition.a(paramArrayList, paramaohg);
    if (localaoac.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_ArrayOfAogs[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localaoac.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_ArrayOfAogx[0].jdField_a_of_type_JavaLangString;
      }
      else if (localaoac.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_ArrayOfAohp[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localaoac.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramaohg.jdField_a_of_type_Aoin.e;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, aohg paramaohg, aogo paramaogo)
  {
    if (paramaohg == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramaogo.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramaohg);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_Aogo = paramaogo;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_Aogo = paramaogo;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramaohg.jdField_a_of_type_Aoin.jdField_a_of_type_Aogo = paramaogo;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_Aogo = paramaogo;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, aohg paramaohg)
  {
    boolean bool = false;
    if (paramaohg == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramaohg);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramaohg.jdField_a_of_type_Aogr.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramaohg.jdField_a_of_type_Aogw.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramaohg.jdField_a_of_type_Aoin.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramaohg.jdField_a_of_type_Aoho.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_Aogr + ", objectClassifyResult = " + this.jdField_a_of_type_Aogw + ", faceResult = " + this.jdField_a_of_type_Aohi + ", ocrResult = " + this.jdField_a_of_type_Axnl + ", preOcrResult = " + this.jdField_a_of_type_Aogy + ", questionResult = " + this.jdField_a_of_type_Aojw + ", sceneRecogResult = " + this.jdField_a_of_type_Aoho + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohg
 * JD-Core Version:    0.7.0.1
 */