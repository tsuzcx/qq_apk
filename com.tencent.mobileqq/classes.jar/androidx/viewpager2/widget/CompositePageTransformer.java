package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositePageTransformer
  implements ViewPager2.PageTransformer
{
  private final List<ViewPager2.PageTransformer> mTransformers = new ArrayList();
  
  public void addTransformer(@NonNull ViewPager2.PageTransformer paramPageTransformer)
  {
    this.mTransformers.add(paramPageTransformer);
  }
  
  public void removeTransformer(@NonNull ViewPager2.PageTransformer paramPageTransformer)
  {
    this.mTransformers.remove(paramPageTransformer);
  }
  
  public void transformPage(@NonNull View paramView, float paramFloat)
  {
    Iterator localIterator = this.mTransformers.iterator();
    while (localIterator.hasNext()) {
      ((ViewPager2.PageTransformer)localIterator.next()).transformPage(paramView, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.CompositePageTransformer
 * JD-Core Version:    0.7.0.1
 */