class apis
  extends aqgz
{
  apis(apir paramapir) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (apir.a(this.a) != null) {
      apir.a(this.a).a(paramArrayOfFloat);
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (apir.a(this.a) != null) {
      apir.a(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apis
 * JD-Core Version:    0.7.0.1
 */