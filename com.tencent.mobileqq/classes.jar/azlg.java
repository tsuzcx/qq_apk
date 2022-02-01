import com.tencent.map.geolocation.TencentDirectionListener;

class azlg
  implements TencentDirectionListener
{
  azlg(azle paramazle) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (azle.a(this.a) != null)
    {
      azle.a(this.a, 180.0D + paramDouble);
      azle.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlg
 * JD-Core Version:    0.7.0.1
 */