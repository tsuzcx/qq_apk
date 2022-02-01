import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mqq.util.WeakReference;

final class boel
  extends PagerAdapter
{
  private List<boek> a;
  
  public void a(List<boek> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = boek.a((boek)this.a.get(paramInt));
    if ((boek.a((boek)this.a.get(paramInt)) instanceof bofg)) {
      ((bofg)boek.a((boek)this.a.get(paramInt))).a();
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
 * Qualified Name:     boel
 * JD-Core Version:    0.7.0.1
 */