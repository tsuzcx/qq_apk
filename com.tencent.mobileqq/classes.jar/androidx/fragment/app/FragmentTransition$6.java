package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

final class FragmentTransition$6
  implements Runnable
{
  FragmentTransition$6(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject1, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList paramArrayList1, View paramView, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList2, Object paramObject2, Rect paramRect) {}
  
  public void run()
  {
    Object localObject1 = FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
    if (localObject1 != null)
    {
      this.val$sharedElementsIn.addAll(((ArrayMap)localObject1).values());
      this.val$sharedElementsIn.add(this.val$nonExistentView);
    }
    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, (ArrayMap)localObject1, false);
    Object localObject2 = this.val$finalSharedElementTransition;
    if (localObject2 != null)
    {
      this.val$impl.swapSharedElementTargets(localObject2, this.val$sharedElementsOut, this.val$sharedElementsIn);
      localObject1 = FragmentTransition.getInEpicenterView((ArrayMap)localObject1, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
      if (localObject1 != null) {
        this.val$impl.getBoundsOnScreen((View)localObject1, this.val$inEpicenter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.6
 * JD-Core Version:    0.7.0.1
 */