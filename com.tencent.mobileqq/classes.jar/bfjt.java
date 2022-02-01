import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.widget.AbsListView;
import java.util.Arrays;

class bfjt
  implements bkhe
{
  bfjt(bfjs parambfjs) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(bfjs.a(this.a), paramInt1);
    if ((paramInt1 >= 0) && (bfjs.a(this.a).a != null)) {
      bfjs.a(this.a).a.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjt
 * JD-Core Version:    0.7.0.1
 */