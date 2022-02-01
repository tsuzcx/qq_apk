package com.tencent.biz.expand.api;

public class ApiDecodeRequest
{
  public String bitmapKey;
  public String faceId;
  public int faceShape;
  public int faceType;
  public String faceUin;
  public String pathKey;
  
  public ApiDecodeRequest(int paramInt1, String paramString, int paramInt2)
  {
    this.faceType = paramInt1;
    this.faceUin = paramString;
    this.faceShape = paramInt2;
    this.bitmapKey = getBitmapKey(this.faceType, this.faceUin, this.faceShape);
    this.pathKey = getPathKey(this.faceType, this.faceUin);
    this.faceId = (paramString + "_" + paramInt1 + "_" + paramInt2);
  }
  
  public static String[] getAllFaceShapePathKeys(int paramInt, String paramString)
  {
    return new String[] { getPathKey(paramInt, paramString) };
  }
  
  private static String getBitmapKey(int paramInt1, String paramString, int paramInt2)
  {
    return "flutter_face_bmp_" + paramInt1 + "_" + paramString + "_" + paramInt2;
  }
  
  private static String getPathKey(int paramInt, String paramString)
  {
    return "flutter_face_path_" + paramInt + "_" + paramString;
  }
  
  public String toString()
  {
    return "DecodeRequest{faceType=" + this.faceType + ", faceUin='" + this.faceUin + '\'' + ", faceShape=" + this.faceShape + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.ApiDecodeRequest
 * JD-Core Version:    0.7.0.1
 */