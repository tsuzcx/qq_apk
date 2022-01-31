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

public class bhrm
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new bhro();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new bhrd();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new bhrc();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new bhre();
  }
  
  public GestureResource getGestureResource()
  {
    return new bhrh();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new bhrj();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new bhrk();
  }
  
  public SensorResource getSensorResource()
  {
    return new bhrn();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new bhrg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhrm
 * JD-Core Version:    0.7.0.1
 */