package androidx.fragment.app;

import android.view.View;
import androidx.annotation.Nullable;

class Fragment$4
  extends FragmentContainer
{
  Fragment$4(Fragment paramFragment) {}
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    if (this.this$0.mView != null) {
      return this.this$0.mView.findViewById(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" does not have a view");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean onHasView()
  {
    return this.this$0.mView != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.Fragment.4
 * JD-Core Version:    0.7.0.1
 */