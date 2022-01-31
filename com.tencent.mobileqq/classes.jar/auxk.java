import com.tencent.mobileqq.nearby.now.view.SplitedProgressBar;
import java.security.InvalidParameterException;

public class auxk
{
  private SplitedProgressBar a;
  
  public auxk(SplitedProgressBar paramSplitedProgressBar)
  {
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.a = paramSplitedProgressBar;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setTotalCount(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.a.b) {
      this.a.setProgress(paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.a;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localSplitedProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setShowMaxCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auxk
 * JD-Core Version:    0.7.0.1
 */