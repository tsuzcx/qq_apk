package com.gyailib.library;

public class Face3DResult
{
  public float[] euler;
  public float[] exp;
  public int facekitVertexNum;
  public float[] facekitVertices;
  public float pointScale;
  public float scale;
  public int traceId;
  public float[] transMatrix;
  public float[] translate;
  
  public Face3DResult(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat4, int paramInt2, float[] paramArrayOfFloat5)
  {
    this.traceId = paramInt1;
    this.transMatrix = paramArrayOfFloat1;
    this.euler = paramArrayOfFloat2;
    this.translate = paramArrayOfFloat3;
    this.scale = paramFloat1;
    this.pointScale = paramFloat2;
    this.exp = paramArrayOfFloat4;
    this.facekitVertexNum = paramInt2;
    this.facekitVertices = paramArrayOfFloat5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.Face3DResult
 * JD-Core Version:    0.7.0.1
 */