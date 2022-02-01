class ascw
  extends anrh
{
  ascw(asct paramasct) {}
  
  protected void doOnDeleteEmoResult(int paramInt)
  {
    asct.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
  
  protected void doOnGetEmoListResult(int paramInt)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  protected void onCameraEmoSend(boolean paramBoolean, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascw
 * JD-Core Version:    0.7.0.1
 */