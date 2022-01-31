import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;

public class bfmj
  implements PtuFilterResource
{
  public boolean checkPendantVersionOK()
  {
    return axle.d();
  }
  
  public String getPortraitPathDir()
  {
    return getSoPathDir();
  }
  
  public String getSoPathDir()
  {
    return axle.b(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmj
 * JD-Core Version:    0.7.0.1
 */