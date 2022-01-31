import com.tencent.map.geolocation.TencentDirectionListener;

class atlr
  implements TencentDirectionListener
{
  atlr(atln paramatln) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (atln.a(this.a) != null)
    {
      atln.a(this.a, 180.0D + paramDouble);
      atln.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlr
 * JD-Core Version:    0.7.0.1
 */