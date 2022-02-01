package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

class FragmentTransitionImpl$2
  implements Runnable
{
  FragmentTransitionImpl$2(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int j = this.val$sharedElementsIn.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.val$sharedElementsIn.get(i);
      String str = ViewCompat.getTransitionName(localView);
      if (str != null) {
        ViewCompat.setTransitionName(localView, FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, str));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionImpl.2
 * JD-Core Version:    0.7.0.1
 */