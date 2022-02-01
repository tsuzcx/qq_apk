import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mqq.util.WeakReference;

final class bmwa
  extends PagerAdapter
{
  private List<bmvz> a;
  
  public void a(List<bmvz> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = bmvz.a((bmvz)this.a.get(paramInt));
    if ((bmvz.a((bmvz)this.a.get(paramInt)) instanceof bmwz)) {
      ((bmwz)bmvz.a((bmvz)this.a.get(paramInt))).a();
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
 * Qualified Name:     bmwa
 * JD-Core Version:    0.7.0.1
 */