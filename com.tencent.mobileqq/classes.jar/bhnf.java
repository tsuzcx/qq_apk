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

public class bhnf
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new bhnh();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new bhmw();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new bhmv();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new bhmx();
  }
  
  public GestureResource getGestureResource()
  {
    return new bhna();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new bhnc();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new bhnd();
  }
  
  public SensorResource getSensorResource()
  {
    return new bhng();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new bhmz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnf
 * JD-Core Version:    0.7.0.1
 */