import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public abstract class apck
{
  public String businessId;
  public boolean observerOnUiThread;
  
  public apck(String paramString)
  {
    this.businessId = paramString;
  }
  
  public apck(String paramString, boolean paramBoolean)
  {
    this.businessId = paramString;
    this.observerOnUiThread = paramBoolean;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public abstract void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apck
 * JD-Core Version:    0.7.0.1
 */