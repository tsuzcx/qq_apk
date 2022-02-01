import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Arrays;

class bgai
  implements AbsListView.OnScrollListener
{
  bgai(bgah parambgah) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(bgah.a(this.a), paramInt1);
    if ((paramInt1 >= 0) && (bgah.a(this.a).a != null)) {
      bgah.a(this.a).a.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgai
 * JD-Core Version:    0.7.0.1
 */