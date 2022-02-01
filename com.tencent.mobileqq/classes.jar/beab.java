import com.tencent.image.NativeGifImage;
import java.io.File;

public class beab
  extends NativeGifImage
{
  public beab(beaa parambeaa, File paramFile, boolean paramBoolean, float paramFloat)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentFrameIndex >= 1) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beab
 * JD-Core Version:    0.7.0.1
 */