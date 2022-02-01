package com.tencent.avgame.localvoicerecog.engine;

import com.car.ailib.ckws.AILibCkws;
import com.car.ailib.ckws.AILibCkwsOutParam;
import com.car.ailib.ckws.AILibCkwsParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AILabVoiceRecogEngine
  implements IVoiceRecogEngine
{
  private static volatile AILabVoiceRecogEngine jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineAILabVoiceRecogEngine;
  private static float b = 0.0F;
  private static float c = 0.0F;
  private float jdField_a_of_type_Float = 3.8F;
  private int jdField_a_of_type_Int = 0;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  
  public static AILabVoiceRecogEngine a()
  {
    if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineAILabVoiceRecogEngine == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineAILabVoiceRecogEngine == null) {
        jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineAILabVoiceRecogEngine = new AILabVoiceRecogEngine();
      }
      return jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineAILabVoiceRecogEngine;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() * 2);
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append(paramString.charAt(i));
      if (i != paramString.length() - 1) {
        localStringBuilder.append('_');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static float b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AILabVoiceRecogEngine", 2, "getCurSceneWordScore " + b);
    }
    return b;
  }
  
  public float a()
  {
    AILibCkwsOutParam localAILibCkwsOutParam = new AILibCkwsOutParam();
    AILibCkws.getCkwsInfo(localAILibCkwsOutParam);
    return localAILibCkwsOutParam.score;
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AILabVoiceRecogEngine", 2, "update word:" + paramString + " format:" + a(paramString) + " SceneWordsTh: " + this.jdField_a_of_type_Float);
    }
    b = 0.0F;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramString));
    paramString = new ArrayList();
    paramString.add(Float.valueOf(this.jdField_a_of_type_Float));
    return AILibCkws.setWords(localArrayList, paramString);
  }
  
  public int a(String paramString1, String paramString2)
  {
    QLog.d("AILabVoiceRecogEngine", 1, "init path=" + paramString1 + " version=" + AILibCkws.getVersion());
    return AILibCkws.init(paramString1 + "/", 1);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[1280];
    }
    byte[] arrayOfByte = new byte[320];
    AILibCkwsParam localAILibCkwsParam = new AILibCkwsParam();
    localAILibCkwsParam.dataMicIn = arrayOfByte;
    localAILibCkwsParam.dataMicInLength = arrayOfByte.length;
    localAILibCkwsParam.chaneel = 1;
    localAILibCkwsParam.hasKeyWord = 0;
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte.length);
    this.jdField_a_of_type_Int += paramArrayOfByte.length;
    int i = 0;
    if (this.jdField_a_of_type_Int >= arrayOfByte.length)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      this.jdField_a_of_type_Int -= arrayOfByte.length;
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, arrayOfByte.length, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
      int j = AILibCkws.process(localAILibCkwsParam);
      paramInt = i;
      if (i != 1) {
        if (j < 0) {
          break label211;
        }
      }
      label211:
      for (paramInt = localAILibCkwsParam.hasKeyWord;; paramInt = j)
      {
        float f = a();
        i = paramInt;
        if (c == f) {
          break;
        }
        c = f;
        i = paramInt;
        if (f <= b) {
          break;
        }
        b = f;
        i = paramInt;
        break;
      }
    }
    return i;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public int b()
  {
    QLog.d("AILabVoiceRecogEngine", 1, "end");
    return 0;
  }
  
  public int c()
  {
    QLog.d("AILabVoiceRecogEngine", 1, "destroy");
    b = 0.0F;
    c = 0.0F;
    return AILibCkws.exit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.AILabVoiceRecogEngine
 * JD-Core Version:    0.7.0.1
 */