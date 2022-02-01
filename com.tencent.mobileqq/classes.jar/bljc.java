import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mqq.util.WeakReference;

final class bljc
  extends PagerAdapter
{
  private List<bljb> a;
  
  public void a(List<bljb> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = bljb.a((bljb)this.a.get(paramInt));
    if ((bljb.a((bljb)this.a.get(paramInt)) instanceof bljx)) {
      ((bljx)bljb.a((bljb)this.a.get(paramInt))).a();
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
 * Qualified Name:     bljc
 * JD-Core Version:    0.7.0.1
 */