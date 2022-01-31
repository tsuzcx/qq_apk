import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.widget.AbsListView;
import java.util.Arrays;

class bchw
  implements bhtv
{
  bchw(bchv parambchv) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(bchv.a(this.a), paramInt1);
    if ((paramInt1 >= 0) && (bchv.a(this.a).a != null)) {
      bchv.a(this.a).a.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchw
 * JD-Core Version:    0.7.0.1
 */