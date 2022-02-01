import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

public class bbni
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
      return new bbnk();
    case 7: 
      return new bbnm();
    case 5: 
      return new bbno();
    case 6: 
      return new bbnp();
    case 4: 
      return new bbnl();
    case 106: 
      return new bbnn();
    }
    return new GPUAlphaBlendFilter();
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbni
 * JD-Core Version:    0.7.0.1
 */