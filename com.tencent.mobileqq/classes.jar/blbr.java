import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.3.1;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.3.2;
import mqq.os.MqqHandler;

public class blbr
  implements blae
{
  blbr(blbp paramblbp) {}
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.3.1(this, paramMetaMaterial));
  }
  
  public void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    blbp.a(this.a).a(new blaj(paramMetaMaterial, 1, paramInt));
  }
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.3.2(this, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbr
 * JD-Core Version:    0.7.0.1
 */