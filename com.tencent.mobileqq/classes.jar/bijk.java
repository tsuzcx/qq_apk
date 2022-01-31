import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class bijk
  implements CosFunHelper.CountDownListener
{
  bijk(bijd parambijd) {}
  
  public void onCountDownEnd()
  {
    bijd.d(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    bijd.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijk
 * JD-Core Version:    0.7.0.1
 */