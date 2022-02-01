import com.tencent.mobileqq.data.CustomEmotionData;

class aqzp
  extends arbj<CustomEmotionData>
{
  aqzp(aqzl paramaqzl) {}
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    if (((paramInt1 <= 28) || (paramInt2 % 28 == 0)) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
  
  public void onUploadFinish()
  {
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzp
 * JD-Core Version:    0.7.0.1
 */