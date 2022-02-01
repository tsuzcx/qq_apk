package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

final class CompositeOnPageChangeCallback
  extends ViewPager2.OnPageChangeCallback
{
  @NonNull
  private final List<ViewPager2.OnPageChangeCallback> mCallbacks;
  
  CompositeOnPageChangeCallback(int paramInt)
  {
    this.mCallbacks = new ArrayList(paramInt);
  }
  
  private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException paramConcurrentModificationException)
  {
    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", paramConcurrentModificationException);
  }
  
  void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mCallbacks.add(paramOnPageChangeCallback);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    try
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      throwCallbackListModifiedWhileInUse(localConcurrentModificationException);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, @Px int paramInt2)
  {
    try
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      throwCallbackListModifiedWhileInUse(localConcurrentModificationException);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    try
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageSelected(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      throwCallbackListModifiedWhileInUse(localConcurrentModificationException);
    }
  }
  
  void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.mCallbacks.remove(paramOnPageChangeCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.CompositeOnPageChangeCallback
 * JD-Core Version:    0.7.0.1
 */