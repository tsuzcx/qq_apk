package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

class FragmentTransitionImpl$3
  implements Runnable
{
  FragmentTransitionImpl$3(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int j = this.val$sharedElementsIn.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.val$sharedElementsIn.get(i);
      String str = ViewCompat.getTransitionName(localView);
      ViewCompat.setTransitionName(localView, (String)this.val$nameOverrides.get(str));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionImpl.3
 * JD-Core Version:    0.7.0.1
 */