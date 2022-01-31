package c.t.m.g;

import java.util.Arrays;
import java.util.List;

public class dg
{
  private static dg f = null;
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 100.0F;
  private boolean d = false;
  private boolean e = false;
  
  public static dg a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new dg();
      }
      return f;
    }
    finally {}
  }
  
  public final boolean a(List<Float> paramList, int paramInt)
  {
    float f2 = 0.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt + "颗卫星,");
    float f1;
    if (paramList.size() >= 5)
    {
      float[] arrayOfFloat = new float[paramList.size()];
      paramInt = 0;
      if (paramInt < arrayOfFloat.length)
      {
        Float localFloat = (Float)paramList.get(paramInt);
        if (localFloat == null) {}
        for (f1 = 0.0F;; f1 = localFloat.floatValue())
        {
          arrayOfFloat[paramInt] = f1;
          paramInt += 1;
          break;
        }
      }
      Arrays.sort(arrayOfFloat);
      paramList = new float[5];
      paramInt = 0;
      f1 = f2;
      while (paramInt < 5)
      {
        paramList[paramInt] = arrayOfFloat[(arrayOfFloat.length - 1 - paramInt)];
        f1 += paramList[paramInt];
        paramInt += 1;
      }
      f1 /= 5.0F;
      localStringBuilder.append("\n");
      localStringBuilder.append("绝对判断：");
      if (paramList[0] <= 35.0F) {
        break label521;
      }
      this.d = true;
      localStringBuilder.append("室外|");
      if (f1 < 22.0F)
      {
        localStringBuilder.append("室内|");
        this.d = false;
      }
      localStringBuilder.append("avg" + f1);
      localStringBuilder.append("avg'" + (f1 - this.a));
      localStringBuilder.append("avgMax" + this.b);
      localStringBuilder.append("avgMin" + this.c);
      localStringBuilder.append(this.d);
      localStringBuilder.append("\n");
      if (this.b < f1) {
        this.b = f1;
      }
      if (this.c > f1) {
        this.c = f1;
      }
      this.a = f1;
      localStringBuilder.append("相对判断：");
      if (f1 - this.a > 3.0F) {
        localStringBuilder.append("信号增强");
      }
      if (this.a - f1 > 2.0F)
      {
        localStringBuilder.append("信号衰弱");
        this.e = false;
      }
      if (f1 <= (this.b + this.c) / 2.0F) {
        break label544;
      }
      this.e = true;
    }
    for (;;)
    {
      if (this.d != this.e) {
        localStringBuilder.append("\n冲突" + this.d + "|" + this.e);
      }
      localStringBuilder.append("\n最终结果" + this.e);
      localStringBuilder.toString();
      return this.e;
      label521:
      if (f1 <= 30.0F) {
        break;
      }
      this.d = true;
      localStringBuilder.append("室外|");
      break;
      label544:
      if (f1 < 22.0F) {
        this.e = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dg
 * JD-Core Version:    0.7.0.1
 */