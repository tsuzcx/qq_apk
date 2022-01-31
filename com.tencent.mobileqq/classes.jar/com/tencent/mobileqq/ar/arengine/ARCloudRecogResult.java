package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecognition.RecognitionResult;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARCloudRecogResult
{
  public int a;
  public long a;
  public ARCloudMarkerRecogResult a;
  public ARCloudObjectClassifyResult a;
  public ARCloudPreOcrResult a;
  public ARCloudRecogRspFaceResult a;
  public ARCloudSceneRecogResult a;
  public ARMIGObjectClassifyResult a;
  public SearchQuestionResult a;
  public ARCloudOcrResult a;
  public String a;
  public long b = 0L;
  
  public ARCloudRecogResult()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = null;
  }
  
  public static ARCloudLBSLocationCheckResult a(ArrayList paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    ARCloudLBSLocationCheckResult localARCloudLBSLocationCheckResult = new ARCloudLBSLocationCheckResult();
    if (paramARCloudRecogResult == null) {
      return localARCloudLBSLocationCheckResult;
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localARCloudLBSLocationCheckResult;
      if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_Boolean) {
        paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.jdField_a_of_type_Int);
      return paramArrayList;
      if (localRecognitionResult.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localARCloudLBSLocationCheckResult;
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_Boolean) {
          paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult;
        }
      }
      else if (localRecognitionResult.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localARCloudLBSLocationCheckResult;
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_Boolean) {
          paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult;
        }
      }
      else
      {
        paramArrayList = localARCloudLBSLocationCheckResult;
        if (localRecognitionResult.jdField_a_of_type_Long == 2048L)
        {
          paramArrayList = localARCloudLBSLocationCheckResult;
          if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_Boolean) {
            paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    Object localObject = null;
    if (paramARCloudRecogResult == null) {
      return null;
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (!paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramARCloudRecogResult != null) {
          paramArrayList = paramARCloudRecogResult.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramARCloudRecogResult = null;
        continue;
      }
      if (localRecognitionResult.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = localObject;
        if (!paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          paramArrayList = localObject;
          if (paramARCloudRecogResult == null) {
            continue;
          }
          paramArrayList = paramARCloudRecogResult.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramARCloudRecogResult = null;
          }
        }
      }
      if (localRecognitionResult.jdField_a_of_type_Long == 128L)
      {
        paramArrayList = localObject;
        if (!paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_Boolean) {
          continue;
        }
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.a(), "utf-8"));
          paramArrayList = localObject;
          if (paramARCloudRecogResult == null) {
            continue;
          }
          paramArrayList = paramARCloudRecogResult.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramARCloudRecogResult = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localRecognitionResult.jdField_a_of_type_Long != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_Boolean) {
        continue;
      }
      try
      {
        paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        paramArrayList = localObject;
        if (paramARCloudRecogResult == null) {
          continue;
        }
        paramArrayList = paramARCloudRecogResult.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramARCloudRecogResult = null;
        }
      }
    }
  }
  
  public static String a(ArrayList paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (paramARCloudRecogResult == null) {
      return "";
    }
    String str = "";
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.jdField_a_of_type_Long == 1L) {
      paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localRecognitionResult.jdField_a_of_type_Long == 2L)
      {
        paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_a_of_type_JavaLangString;
      }
      else if (localRecognitionResult.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[0].jdField_a_of_type_JavaLangString;
      }
      else
      {
        paramArrayList = str;
        if (localRecognitionResult.jdField_a_of_type_Long == 128L) {
          paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.d;
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, ARCloudRecogResult paramARCloudRecogResult, ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    if (paramARCloudRecogResult == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int);
      paramArrayList = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
      if (paramArrayList.jdField_a_of_type_Long == 1L)
      {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = paramARCloudLBSLocationCheckResult;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 2L)
      {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = paramARCloudLBSLocationCheckResult;
        return;
      }
      if (paramArrayList.jdField_a_of_type_Long == 128L)
      {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = paramARCloudLBSLocationCheckResult;
        return;
      }
    } while (paramArrayList.jdField_a_of_type_Long != 2048L);
    paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = paramARCloudLBSLocationCheckResult;
  }
  
  public static boolean a(ArrayList paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    boolean bool = false;
    if (paramARCloudRecogResult == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.jdField_a_of_type_Long == 2L) {
        bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
        bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_Boolean;
      } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
        bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_Boolean;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.jdField_a_of_type_JavaLangString + ", recogType = " + this.jdField_a_of_type_Long + ", businessType = " + this.jdField_a_of_type_Int + ", markerResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult + ", objectClassifyResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult + ", faceResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult + ", ocrResult = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult + ", preOcrResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult + ", questionResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineSearchQuestionResult + ", sceneRecogResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult + ", uin = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogResult
 * JD-Core Version:    0.7.0.1
 */