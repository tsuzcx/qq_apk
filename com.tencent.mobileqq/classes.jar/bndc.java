import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mqq.util.WeakReference;

final class bndc
  extends PagerAdapter
{
  private List<bndb> a;
  
  public void a(List<bndb> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = bndb.a((bndb)this.a.get(paramInt));
    if ((bndb.a((bndb)this.a.get(paramInt)) instanceof bndx)) {
      ((bndx)bndb.a((bndb)this.a.get(paramInt))).a();
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
 * Qualified Name:     bndc
 * JD-Core Version:    0.7.0.1
 */