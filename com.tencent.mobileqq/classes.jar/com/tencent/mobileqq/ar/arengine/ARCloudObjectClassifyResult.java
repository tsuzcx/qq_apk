package com.tencent.mobileqq.ar.arengine;

public class ARCloudObjectClassifyResult
  extends ARCloudRecogResultBase
  implements ARCloudObjectClassifyCommonInterface
{
  public int a = -1;
  public String b = "";
  public String c;
  public int d = -1;
  public String e = "";
  public String f = "";
  public ARCloudObjectClassifyResult.ImageTag[] g = null;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  
  public static boolean a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    if ((paramARCloudObjectClassifyResult != null) && (paramARCloudObjectClassifyResult.a == 0) && (paramARCloudObjectClassifyResult.d == 0))
    {
      ARCloudObjectClassifyResult.ImageTag[] arrayOfImageTag = paramARCloudObjectClassifyResult.g;
      if ((arrayOfImageTag != null) && (arrayOfImageTag[0].f == 0) && (paramARCloudObjectClassifyResult.g[0].g != null)) {
        return true;
      }
    }
    return false;
  }
  
  public byte[] c()
  {
    return this.g[0].g;
  }
  
  public String toString()
  {
    if (this.g != null)
    {
      int k = 0;
      localObject1 = "ImageTags{";
      for (;;)
      {
        localObject2 = localObject1;
        if (k >= this.g.length) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", imageTags[");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append("] = ");
        ((StringBuilder)localObject2).append(this.g[k]);
        localObject1 = ((StringBuilder)localObject2).toString();
        k += 1;
      }
    }
    Object localObject2 = "null";
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ARCloudObjectClassifyResult{retCode = ");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(", retMsg = ");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(", recogSvrRetCode = ");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(", recogSvrRetMsg = ");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append(", sessionId = ");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append(", imageTags = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(", timeLen = ");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(", score = ");
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append(", kptNum = ");
    ((StringBuilder)localObject1).append(this.j);
    ((StringBuilder)localObject1).append(super.toString());
    ((StringBuilder)localObject1).append('}');
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */