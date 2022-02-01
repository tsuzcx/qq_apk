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
  public String a = "";
  public long b = 0L;
  public int c = -1;
  public ARCloudMarkerRecogResult d = null;
  public ARCloudObjectClassifyResult e;
  public ARCloudRecogRspFaceResult f;
  public ARCloudOcrResult g;
  public ARCloudPreOcrResult h;
  public SearchQuestionResult i;
  public ARMIGObjectClassifyResult j;
  public ARCloudSceneRecogResult k;
  public TranslateResult l;
  public long m = 0L;
  
  public static void a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult, ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    if (paramARCloudRecogResult == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLBSLocationCheckResult. retCode = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.a);
    QLog.i("AREngine_ARCloudRecogResult", 1, localStringBuilder.toString());
    paramArrayList = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (paramArrayList.a == 1L)
    {
      paramARCloudRecogResult.d.l = paramARCloudLBSLocationCheckResult;
      return;
    }
    if (paramArrayList.a == 2L)
    {
      paramARCloudRecogResult.e.l = paramARCloudLBSLocationCheckResult;
      return;
    }
    if (paramArrayList.a == 128L)
    {
      paramARCloudRecogResult.j.l = paramARCloudLBSLocationCheckResult;
      return;
    }
    if (paramArrayList.a == 2048L) {
      paramARCloudRecogResult.k.l = paramARCloudLBSLocationCheckResult;
    }
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    boolean bool = false;
    if (paramARCloudRecogResult == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (paramArrayList.a == 1L) {
      bool = paramARCloudRecogResult.d.k;
    } else if (paramArrayList.a == 2L) {
      bool = paramARCloudRecogResult.e.k;
    } else if (paramArrayList.a == 128L) {
      bool = paramARCloudRecogResult.j.k;
    } else if (paramArrayList.a == 2048L) {
      bool = paramARCloudRecogResult.k.k;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("isNeedUploadLBSLocation. isNeed = ");
    paramArrayList.append(bool);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramArrayList.toString());
    return bool;
  }
  
  public static ARCloudLBSLocationCheckResult b(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    ARCloudLBSLocationCheckResult localARCloudLBSLocationCheckResult = new ARCloudLBSLocationCheckResult();
    if (paramARCloudRecogResult == null) {
      return localARCloudLBSLocationCheckResult;
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.a == 1L)
    {
      paramArrayList = localARCloudLBSLocationCheckResult;
      if (paramARCloudRecogResult.d.k) {
        paramArrayList = paramARCloudRecogResult.d.l;
      }
    }
    else if (localRecognitionResult.a == 2L)
    {
      paramArrayList = localARCloudLBSLocationCheckResult;
      if (paramARCloudRecogResult.e.k) {
        paramArrayList = paramARCloudRecogResult.e.l;
      }
    }
    else if (localRecognitionResult.a == 128L)
    {
      paramArrayList = localARCloudLBSLocationCheckResult;
      if (paramARCloudRecogResult.j.k) {
        paramArrayList = paramARCloudRecogResult.j.l;
      }
    }
    else
    {
      paramArrayList = localARCloudLBSLocationCheckResult;
      if (localRecognitionResult.a == 2048L)
      {
        paramArrayList = localARCloudLBSLocationCheckResult;
        if (paramARCloudRecogResult.k.k) {
          paramArrayList = paramARCloudRecogResult.k.l;
        }
      }
    }
    paramARCloudRecogResult = new StringBuilder();
    paramARCloudRecogResult.append("getLBSLocationCheckResult. retCode = ");
    paramARCloudRecogResult.append(paramArrayList.a);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
    return paramArrayList;
  }
  
  public static ArLBSActivity c(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    Object localObject = null;
    if (paramARCloudRecogResult == null) {
      return null;
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.a == 1L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.d.k)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.d.g[0].g, "utf-8"));
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
          paramArrayList = paramARCloudRecogResult.q;
        }
      }
    }
    else if (localRecognitionResult.a == 2L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.e.k)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.e.g[0].g, "utf-8"));
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
          paramArrayList = paramARCloudRecogResult.q;
        }
      }
    }
    else if (localRecognitionResult.a == 128L)
    {
      paramArrayList = localObject;
      if (paramARCloudRecogResult.j.k)
      {
        try
        {
          paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.j.c(), "utf-8"));
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
          paramArrayList = paramARCloudRecogResult.q;
        }
      }
    }
    else
    {
      paramArrayList = localObject;
      if (localRecognitionResult.a == 2048L)
      {
        paramArrayList = localObject;
        if (paramARCloudRecogResult.k.k)
        {
          try
          {
            paramARCloudRecogResult = ARCloudMarkerJsonParser.a(new String(paramARCloudRecogResult.k.g[0].g, "utf-8"));
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
            paramArrayList = paramARCloudRecogResult.q;
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
  
  public static String d(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    String str = "";
    if (paramARCloudRecogResult == null) {
      return "";
    }
    ARRecognition.RecognitionResult localRecognitionResult = ARRecognition.a(paramArrayList, paramARCloudRecogResult);
    if (localRecognitionResult.a == 1L)
    {
      paramArrayList = paramARCloudRecogResult.d.g[0].a;
    }
    else if (localRecognitionResult.a == 2L)
    {
      paramArrayList = paramARCloudRecogResult.e.g[0].a;
    }
    else if (localRecognitionResult.a == 2048L)
    {
      paramArrayList = paramARCloudRecogResult.k.g[0].a;
    }
    else
    {
      paramArrayList = str;
      if (localRecognitionResult.a == 128L) {
        paramArrayList = paramARCloudRecogResult.j.n;
      }
    }
    paramARCloudRecogResult = new StringBuilder();
    paramARCloudRecogResult.append("getImageId. imageId = ");
    paramARCloudRecogResult.append(paramArrayList);
    QLog.i("AREngine_ARCloudRecogResult", 1, paramARCloudRecogResult.toString());
    return paramArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogResult{, sessionId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", recogType = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", businessType = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", markerResult = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", objectClassifyResult = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", faceResult = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ocrResult = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", preOcrResult = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", questionResult = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", sceneRecogResult = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", translateReslut = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogResult
 * JD-Core Version:    0.7.0.1
 */