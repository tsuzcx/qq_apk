import com.tencent.map.geolocation.TencentDirectionListener;

class azfa
  implements TencentDirectionListener
{
  azfa(azey paramazey) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (azey.a(this.a) != null)
    {
      azey.a(this.a, 180.0D + paramDouble);
      azey.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfa
 * JD-Core Version:    0.7.0.1
 */