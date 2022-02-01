package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecognition.RecognitionResult;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult;
import com.tencent.mobileqq.ocr.data.TranslateResult;
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
  public TranslateResult a;
  public String a;
  public long b = 0L;
  
  public ARCloudRecogResult()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult = null;
  }
  
  public static ARCloudLBSLocationCheckResult a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
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
    else if (localRecognitionResult.jdField_a_of_type_Long == 2L)
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
    paramARCloudRecogResult = new StringBuilder();
    paramARCloudRecogResult.append("getLBSLocationCheckResult. retCode = ");
    paramARCloudRecogResult.append(paramArrayList.jdField_a_of_type_Int);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
    return paramArrayList;
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    Object localObject = null;
    if (paramARCloudRecogResult == null) {
      return null;
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_Boolean)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        }
        catch (Exception paramArrayList)
        {
          paramARCloudRecogResult = new StringBuilder();
          paramARCloudRecogResult.append("parse json failed. error msg = ");
          paramARCloudRecogResult.append(paramArrayList.getMessage());
          QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
          paramARCloudRecogResult = null;
        }
        paramArrayList = localObject;
        if (paramARCloudRecogResult != null) {
          paramArrayList = paramARCloudRecogResult.a;
        }
      }
    }
    else if (localRecognitionResult.jdField_a_of_type_Long == 2L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_Boolean)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudObjectClassifyResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
        }
        catch (Exception paramArrayList)
        {
          paramARCloudRecogResult = new StringBuilder();
          paramARCloudRecogResult.append("parse json failed. error msg = ");
          paramARCloudRecogResult.append(paramArrayList.getMessage());
          QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
          paramARCloudRecogResult = null;
        }
        paramArrayList = localObject;
        if (paramARCloudRecogResult != null) {
          paramArrayList = paramARCloudRecogResult.a;
        }
      }
    }
    else if (localRecognitionResult.jdField_a_of_type_Long == 128L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_Boolean)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.a(), "utf-8"));
        }
        catch (Exception paramArrayList)
        {
          paramARCloudRecogResult = new StringBuilder();
          paramARCloudRecogResult.append("parse json failed. error msg = ");
          paramARCloudRecogResult.append(paramArrayList.getMessage());
          QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
          paramARCloudRecogResult = null;
        }
        paramArrayList = localObject;
        if (paramARCloudRecogResult != null) {
          paramArrayList = paramARCloudRecogResult.a;
        }
      }
    }
    else
    {
      paramArrayList = localObject;
      if (localRecognitionResult.jdField_a_of_type_Long == 2048L)
      {
        paramArrayList = localObject;
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_Boolean)
        {
          try
          {
            paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudSceneRecogResult$ImageTag[0].jdField_a_of_type_ArrayOfByte, "utf-8"));
          }
          catch (Exception paramArrayList)
          {
            paramARCloudRecogResult = new StringBuilder();
            paramARCloudRecogResult.append("parse json failed. error msg = ");
            paramARCloudRecogResult.append(paramArrayList.getMessage());
            QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
            paramARCloudRecogResult = null;
          }
          paramArrayList = localObject;
          if (paramARCloudRecogResult != null) {
            paramArrayList = paramARCloudRecogResult.a;
          }
        }
      }
    }
    paramARCloudRecogResult = new StringBuilder();
    paramARCloudRecogResult.append("getLBSActivity. activity info = ");
    paramARCloudRecogResult.append(paramArrayList);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
    return paramArrayList;
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    String str = "";
    if (paramARCloudRecogResult == null) {
      return "";
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.jdField_a_of_type_Long == 1L)
    {
      paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARCloudMarkerRecogResult$ImageTag[0].jdField_a_of_type_JavaLangString;
    }
    else if (localRecognitionResult.jdField_a_of_type_Long == 2L)
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
        paramArrayList = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.e;
      }
    }
    paramARCloudRecogResult = new StringBuilder();
    paramARCloudRecogResult.append("getImageId. imageId = ");
    paramARCloudRecogResult.append(paramArrayList);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
    return paramArrayList;
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult, ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    if (paramARCloudRecogResult == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLBSLocationCheckResult. retCode = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int);
    QLog.i("AREngine_ARCloudRecogResult", 1, localStringBuilder.toString());
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
    if (paramArrayList.jdField_a_of_type_Long == 2048L) {
      paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = paramARCloudLBSLocationCheckResult;
    }
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    boolean bool = false;
    if (paramARCloudRecogResult == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (paramArrayList.jdField_a_of_type_Long == 1L) {
      bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.jdField_a_of_type_Boolean;
    } else if (paramArrayList.jdField_a_of_type_Long == 2L) {
      bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.jdField_a_of_type_Boolean;
    } else if (paramArrayList.jdField_a_of_type_Long == 128L) {
      bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.jdField_a_of_type_Boolean;
    } else if (paramArrayList.jdField_a_of_type_Long == 2048L) {
      bool = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.jdField_a_of_type_Boolean;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("isNeedUploadLBSLocation. isNeed = ");
    paramArrayList.append(bool);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramArrayList.toString());
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogResult{, sessionId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", recogType = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", businessType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", markerResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
    localStringBuilder.append(", objectClassifyResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
    localStringBuilder.append(", faceResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
    localStringBuilder.append(", ocrResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult);
    localStringBuilder.append(", preOcrResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult);
    localStringBuilder.append(", questionResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineSearchQuestionResult);
    localStringBuilder.append(", sceneRecogResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
    localStringBuilder.append(", translateReslut = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogResult
 * JD-Core Version:    0.7.0.1
 */