public class borm
  extends bogb
{
  private bhyq a;
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borm
 * JD-Core Version:    0.7.0.1
 */