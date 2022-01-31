import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.widget.AbsListView;
import java.util.Arrays;

class bcdn
  implements bhpo
{
  bcdn(bcdm parambcdm) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(bcdm.a(this.a), paramInt1);
    if ((paramInt1 >= 0) && (bcdm.a(this.a).a != null)) {
      bcdm.a(this.a).a.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdn
 * JD-Core Version:    0.7.0.1
 */