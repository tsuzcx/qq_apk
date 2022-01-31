import com.tencent.image.NativeGifImage;
import java.io.File;

public class banv
  extends NativeGifImage
{
  private int a = 1;
  
  public banv(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
    this.a = paramInt;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.a) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     banv
 * JD-Core Version:    0.7.0.1
 */