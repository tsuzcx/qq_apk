import com.tencent.map.geolocation.TencentDirectionListener;

class aqzg
  implements TencentDirectionListener
{
  aqzg(aqzc paramaqzc) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (aqzc.a(this.a) != null)
    {
      aqzc.a(this.a, 180.0D + paramDouble);
      aqzc.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzg
 * JD-Core Version:    0.7.0.1
 */