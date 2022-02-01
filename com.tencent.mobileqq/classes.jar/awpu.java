import com.tencent.map.geolocation.TencentDirectionListener;

class awpu
  implements TencentDirectionListener
{
  awpu(awpq paramawpq) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (awpq.a(this.a) != null)
    {
      awpq.a(this.a, 180.0D + paramDouble);
      awpq.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpu
 * JD-Core Version:    0.7.0.1
 */