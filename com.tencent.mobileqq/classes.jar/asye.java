import android.graphics.Rect;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class asye
{
  private int jdField_a_of_type_Int;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  
  private View a()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter();
    if ((localObject != null) && ((localObject instanceof FragmentPagerAdapter)))
    {
      localObject = ((asup)localObject).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localObject == null) {
        Log.i("NestScrollHelper", "getScrollableView: fragment is null");
      }
      if ((localObject instanceof NearbyMomentFragment)) {
        return ((NearbyMomentFragment)localObject).a();
      }
      if ((localObject instanceof NearbyProfileFragment)) {
        return ((NearbyProfileFragment)localObject).a();
      }
    }
    return null;
  }
  
  private boolean a(LinearLayout paramLinearLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLinearLayout != null)
    {
      View localView = paramLinearLayout.getChildAt(0);
      bool1 = bool2;
      if (localView != null)
      {
        Rect localRect = new Rect();
        paramLinearLayout.getHitRect(localRect);
        bool1 = bool2;
        if (localView.getLocalVisibleRect(localRect))
        {
          bool1 = bool2;
          if (localRect.top == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListView != null)
    {
      bool1 = bool2;
      if (paramListView.getFirstVisiblePosition() == 0)
      {
        paramListView = paramListView.getChildAt(0);
        if (paramListView != null)
        {
          bool1 = bool2;
          if (paramListView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = a();
    if (localView == null) {
      Log.e("NestScrollHelper", "smoothScrollBy: scrollableView is null");
    }
    while (!(localView instanceof ListView)) {
      return;
    }
    ((ListView)localView).smoothScrollBy(paramInt2, paramInt3);
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public boolean a()
  {
    View localView = a();
    if (localView == null)
    {
      Log.e("NestScrollHelper", "isTop: scrollableView is null");
      return true;
    }
    if ((localView instanceof ListView)) {
      return a((ListView)localView);
    }
    if ((localView instanceof LinearLayout)) {
      return a((LinearLayout)localView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asye
 * JD-Core Version:    0.7.0.1
 */