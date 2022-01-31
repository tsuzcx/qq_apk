import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.LowLightResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;

public class bfml
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new bfmn();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new bfmc();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new bfmb();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new bfmd();
  }
  
  public GestureResource getGestureResource()
  {
    return new bfmg();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new bfmi();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new bfmj();
  }
  
  public SensorResource getSensorResource()
  {
    return new bfmm();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new bfmf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfml
 * JD-Core Version:    0.7.0.1
 */