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

public class bflu
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new bflw();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new bfll();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new bflk();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new bflm();
  }
  
  public GestureResource getGestureResource()
  {
    return new bflp();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new bflr();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new bfls();
  }
  
  public SensorResource getSensorResource()
  {
    return new bflv();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new bflo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bflu
 * JD-Core Version:    0.7.0.1
 */