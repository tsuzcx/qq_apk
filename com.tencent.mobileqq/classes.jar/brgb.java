import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

public class brgb
{
  public static GPUBaseFilter a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new GPUBaseFilter();
    case 101: 
      return new GPUBaseFilter();
    case 102: 
      return new GPUOESBaseFilter();
    case 0: 
      return new brgd();
    case 7: 
      return new brgf();
    case 5: 
      return new brgh();
    case 6: 
      return new brgi();
    case 4: 
      return new brge();
    case 106: 
      return new brgg();
    }
    return new GPUOESMovieFilter();
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brgb
 * JD-Core Version:    0.7.0.1
 */