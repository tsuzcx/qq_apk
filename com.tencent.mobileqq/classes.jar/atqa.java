import com.tencent.map.geolocation.TencentDirectionListener;

class atqa
  implements TencentDirectionListener
{
  atqa(atpw paramatpw) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (atpw.a(this.a) != null)
    {
      atpw.a(this.a, 180.0D + paramDouble);
      atpw.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqa
 * JD-Core Version:    0.7.0.1
 */