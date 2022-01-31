import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class biit
  implements CosFunHelper.CountDownListener
{
  biit(biim parambiim) {}
  
  public void onCountDownEnd()
  {
    biim.d(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    biim.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biit
 * JD-Core Version:    0.7.0.1
 */