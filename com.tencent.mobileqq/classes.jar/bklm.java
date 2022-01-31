import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class bklm
  implements CosFunHelper.CountDownListener
{
  bklm(bkle parambkle) {}
  
  public void onCountDownEnd()
  {
    bkle.d(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    bkle.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklm
 * JD-Core Version:    0.7.0.1
 */