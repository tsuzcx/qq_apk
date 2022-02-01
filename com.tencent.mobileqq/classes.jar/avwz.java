import com.tencent.map.geolocation.TencentDirectionListener;

class avwz
  implements TencentDirectionListener
{
  avwz(avwv paramavwv) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (avwv.a(this.a) != null)
    {
      avwv.a(this.a, 180.0D + paramDouble);
      avwv.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwz
 * JD-Core Version:    0.7.0.1
 */