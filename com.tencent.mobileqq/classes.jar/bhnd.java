import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;

public class bhnd
  implements PtuFilterResource
{
  public boolean checkPendantVersionOK()
  {
    return azgk.d();
  }
  
  public String getPortraitPathDir()
  {
    return getSoPathDir();
  }
  
  public String getSoPathDir()
  {
    return azgk.b(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnd
 * JD-Core Version:    0.7.0.1
 */