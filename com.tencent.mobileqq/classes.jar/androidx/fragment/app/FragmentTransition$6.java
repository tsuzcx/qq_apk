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
    Object localObject = FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
    if (localObject != null)
    {
      this.val$sharedElementsIn.addAll(((ArrayMap)localObject).values());
      this.val$sharedElementsIn.add(this.val$nonExistentView);
    }
    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, (ArrayMap)localObject, false);
    if (this.val$finalSharedElementTransition != null)
    {
      this.val$impl.swapSharedElementTargets(this.val$finalSharedElementTransition, this.val$sharedElementsOut, this.val$sharedElementsIn);
      localObject = FragmentTransition.getInEpicenterView((ArrayMap)localObject, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
      if (localObject != null) {
        this.val$impl.getBoundsOnScreen((View)localObject, this.val$inEpicenter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.6
 * JD-Core Version:    0.7.0.1
 */