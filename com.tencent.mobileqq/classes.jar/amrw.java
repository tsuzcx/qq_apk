class amrw
  extends anov
{
  amrw(amrv paramamrv) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (amrv.a(this.a) != null) {
      amrv.a(this.a).a(paramArrayOfFloat);
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (amrv.a(this.a) != null) {
      amrv.a(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrw
 * JD-Core Version:    0.7.0.1
 */