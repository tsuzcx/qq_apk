import com.tencent.map.geolocation.TencentDirectionListener;

class aysn
  implements TencentDirectionListener
{
  aysn(aysl paramaysl) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (aysl.a(this.a) != null)
    {
      aysl.a(this.a, 180.0D + paramDouble);
      aysl.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysn
 * JD-Core Version:    0.7.0.1
 */