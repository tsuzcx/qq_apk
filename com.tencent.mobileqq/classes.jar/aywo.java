import com.tencent.image.NativeGifImage;
import java.io.File;

public class aywo
  extends NativeGifImage
{
  public aywo(aywn paramaywn, File paramFile, boolean paramBoolean, float paramFloat)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aywo
 * JD-Core Version:    0.7.0.1
 */