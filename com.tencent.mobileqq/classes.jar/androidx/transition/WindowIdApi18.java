package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class WindowIdApi18
  implements WindowIdImpl
{
  private final WindowId mWindowId;
  
  WindowIdApi18(@NonNull View paramView)
  {
    this.mWindowId = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WindowIdApi18)) && (((WindowIdApi18)paramObject).mWindowId.equals(this.mWindowId));
  }
  
  public int hashCode()
  {
    return this.mWindowId.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.WindowIdApi18
 * JD-Core Version:    0.7.0.1
 */