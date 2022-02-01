import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class bnek
  implements CosFunHelper.CountDownListener
{
  bnek(bndy parambndy) {}
  
  public void onCountDownEnd()
  {
    bndy.b(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    bndy.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnek
 * JD-Core Version:    0.7.0.1
 */