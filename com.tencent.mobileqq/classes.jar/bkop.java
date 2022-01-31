import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mqq.util.WeakReference;

final class bkop
  extends PagerAdapter
{
  private List<bkoo> a;
  
  public void a(List<bkoo> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = bkoo.a((bkoo)this.a.get(paramInt));
    if ((bkoo.a((bkoo)this.a.get(paramInt)) instanceof bkpk)) {
      ((bkpk)bkoo.a((bkoo)this.a.get(paramInt))).a();
    }
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkop
 * JD-Core Version:    0.7.0.1
 */