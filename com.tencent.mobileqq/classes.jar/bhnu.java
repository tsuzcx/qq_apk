import com.tencent.image.NativeGifImage;
import java.io.File;

public class bhnu
  extends NativeGifImage
{
  private int a = 1;
  
  public bhnu(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnu
 * JD-Core Version:    0.7.0.1
 */