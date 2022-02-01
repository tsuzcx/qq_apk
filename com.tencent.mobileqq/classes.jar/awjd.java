import com.tencent.map.geolocation.TencentDirectionListener;

class awjd
  implements TencentDirectionListener
{
  awjd(awiz paramawiz) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (awiz.a(this.a) != null)
    {
      awiz.a(this.a, 180.0D + paramDouble);
      awiz.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjd
 * JD-Core Version:    0.7.0.1
 */