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

public class blga
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new blgc();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new blfr();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new blfq();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new blfs();
  }
  
  public GestureResource getGestureResource()
  {
    return new blfv();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new blfx();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new blfy();
  }
  
  public SensorResource getSensorResource()
  {
    return new blgb();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new blfu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blga
 * JD-Core Version:    0.7.0.1
 */