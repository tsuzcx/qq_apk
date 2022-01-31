import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public final class anzl
  implements Runnable
{
  public void run()
  {
    try
    {
      SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "GIFEngine");
      ShortVideoUtils.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      ShortVideoUtils.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzl
 * JD-Core Version:    0.7.0.1
 */