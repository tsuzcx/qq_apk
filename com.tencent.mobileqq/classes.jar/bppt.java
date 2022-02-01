import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

public class bppt
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
      return new bppv();
    case 106: 
      return new bppw();
    }
    return new GPUOESMovieFilter();
  }
  
  public static boolean a(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppt
 * JD-Core Version:    0.7.0.1
 */