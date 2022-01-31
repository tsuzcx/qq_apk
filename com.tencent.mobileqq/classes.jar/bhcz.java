import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class bhcz
  implements CosFunHelper.CountDownListener
{
  bhcz(bhcw parambhcw) {}
  
  public void onCountDownEnd()
  {
    bhcw.b(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    bhcw.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhcz
 * JD-Core Version:    0.7.0.1
 */