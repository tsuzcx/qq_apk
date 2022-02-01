package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;

final class FragmentTransition$5
  implements Runnable
{
  FragmentTransition$5(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap, View paramView, FragmentTransitionImpl paramFragmentTransitionImpl, Rect paramRect) {}
  
  public void run()
  {
    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
    View localView = this.val$epicenterView;
    if (localView != null) {
      this.val$impl.getBoundsOnScreen(localView, this.val$epicenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.5
 * JD-Core Version:    0.7.0.1
 */