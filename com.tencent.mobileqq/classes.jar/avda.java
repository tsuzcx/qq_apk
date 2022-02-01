import com.tencent.map.geolocation.TencentDirectionListener;

class avda
  implements TencentDirectionListener
{
  avda(avcw paramavcw) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (avcw.a(this.a) != null)
    {
      avcw.a(this.a, 180.0D + paramDouble);
      avcw.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avda
 * JD-Core Version:    0.7.0.1
 */