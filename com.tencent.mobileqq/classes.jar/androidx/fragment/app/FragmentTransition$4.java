package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;

final class FragmentTransition$4
  implements Runnable
{
  FragmentTransition$4(Object paramObject1, FragmentTransitionImpl paramFragmentTransitionImpl, View paramView, Fragment paramFragment, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Object paramObject2) {}
  
  public void run()
  {
    Object localObject = this.val$enterTransition;
    if (localObject != null)
    {
      this.val$impl.removeTarget(localObject, this.val$nonExistentView);
      localObject = FragmentTransition.configureEnteringExitingViews(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView);
      this.val$enteringViews.addAll((Collection)localObject);
    }
    if (this.val$exitingViews != null)
    {
      if (this.val$exitTransition != null)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.val$nonExistentView);
        this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, (ArrayList)localObject);
      }
      this.val$exitingViews.clear();
      this.val$exitingViews.add(this.val$nonExistentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.4
 * JD-Core Version:    0.7.0.1
 */