import com.tencent.map.geolocation.TencentDirectionListener;

class axyo
  implements TencentDirectionListener
{
  axyo(axym paramaxym) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (axym.a(this.a) != null)
    {
      axym.a(this.a, 180.0D + paramDouble);
      axym.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyo
 * JD-Core Version:    0.7.0.1
 */