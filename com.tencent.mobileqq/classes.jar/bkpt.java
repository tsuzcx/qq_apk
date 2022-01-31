import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class bkpt
  implements CosFunHelper.CountDownListener
{
  bkpt(bkpl parambkpl) {}
  
  public void onCountDownEnd()
  {
    bkpl.d(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    bkpl.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpt
 * JD-Core Version:    0.7.0.1
 */