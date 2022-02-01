package com.tencent.avgame.localvoicerecog.engine;

import com.car.ailib.ckws.AILibCkws;
import com.car.ailib.ckws.AILibCkwsOutParam;
import com.car.ailib.ckws.AILibCkwsParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AILabVoiceRecogEngine
  implements IVoiceRecogEngine
{
  private static volatile AILabVoiceRecogEngine a;
  private static float e;
  private static float f;
  private byte[] b = null;
  private int c = 0;
  private float d = 3.8F;
  
  public static AILabVoiceRecogEngine a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AILabVoiceRecogEngine();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String b(String paramString)
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
  
  public static float f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurSceneWordScore ");
      localStringBuilder.append(e);
      QLog.d("AILabVoiceRecogEngine", 2, localStringBuilder.toString());
    }
    return e;
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update word:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" format:");
      ((StringBuilder)localObject).append(b(paramString));
      ((StringBuilder)localObject).append(" SceneWordsTh: ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("AILabVoiceRecogEngine", 2, ((StringBuilder)localObject).toString());
    }
    e = 0.0F;
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(b(paramString));
    paramString = new ArrayList();
    paramString.add(Float.valueOf(this.d));
    return AILibCkws.setWords((ArrayList)localObject, paramString);
  }
  
  public int a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("init path=");
    paramString2.append(paramString1);
    paramString2.append(" version=");
    paramString2.append(AILibCkws.getVersion());
    QLog.d("AILabVoiceRecogEngine", 1, paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("/");
    return AILibCkws.init(paramString2.toString(), 1);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b == null) {
      this.b = new byte[1280];
    }
    byte[] arrayOfByte = new byte[320];
    AILibCkwsParam localAILibCkwsParam = new AILibCkwsParam();
    localAILibCkwsParam.dataMicIn = arrayOfByte;
    localAILibCkwsParam.dataMicInLength = arrayOfByte.length;
    localAILibCkwsParam.chaneel = 1;
    localAILibCkwsParam.hasKeyWord = 0;
    System.arraycopy(paramArrayOfByte, 0, this.b, this.c, paramArrayOfByte.length);
    this.c += paramArrayOfByte.length;
    int i = 0;
    while (this.c >= arrayOfByte.length)
    {
      System.arraycopy(this.b, 0, arrayOfByte, 0, arrayOfByte.length);
      this.c -= arrayOfByte.length;
      paramArrayOfByte = this.b;
      System.arraycopy(paramArrayOfByte, arrayOfByte.length, paramArrayOfByte, 0, this.c);
      int j = AILibCkws.process(localAILibCkwsParam);
      paramInt = i;
      if (i != 1) {
        if (j >= 0) {
          paramInt = localAILibCkwsParam.hasKeyWord;
        } else {
          paramInt = j;
        }
      }
      float f1 = d();
      i = paramInt;
      if (f != f1)
      {
        f = f1;
        i = paramInt;
        if (f1 > e)
        {
          e = f1;
          i = paramInt;
        }
      }
    }
    return i;
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public int b()
  {
    return 0;
  }
  
  public int c()
  {
    QLog.d("AILabVoiceRecogEngine", 1, "end");
    return 0;
  }
  
  public float d()
  {
    AILibCkwsOutParam localAILibCkwsOutParam = new AILibCkwsOutParam();
    AILibCkws.getCkwsInfo(localAILibCkwsOutParam);
    return localAILibCkwsOutParam.score;
  }
  
  public int e()
  {
    QLog.d("AILabVoiceRecogEngine", 1, "destroy");
    e = 0.0F;
    f = 0.0F;
    return AILibCkws.exit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.AILabVoiceRecogEngine
 * JD-Core Version:    0.7.0.1
 */