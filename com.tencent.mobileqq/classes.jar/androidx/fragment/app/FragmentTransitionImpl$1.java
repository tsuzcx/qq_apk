package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class FragmentTransitionImpl$1
  implements Runnable
{
  FragmentTransitionImpl$1(FragmentTransitionImpl paramFragmentTransitionImpl, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$numSharedElements)
    {
      ViewCompat.setTransitionName((View)this.val$sharedElementsIn.get(i), (String)this.val$inNames.get(i));
      ViewCompat.setTransitionName((View)this.val$sharedElementsOut.get(i), (String)this.val$outNames.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionImpl.1
 * JD-Core Version:    0.7.0.1
 */