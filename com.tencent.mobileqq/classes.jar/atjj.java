import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.10.1;
import java.util.List;

public class atjj
  implements AbsListView.OnScrollListener
{
  public atjj(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramAbsListView = ShortVideoCommentsView.a(this.a).getChildAt(0);
      if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
      {
        ShortVideoCommentsView.a(this.a, true);
        return;
      }
      ShortVideoCommentsView.a(this.a, false);
      return;
    }
    ShortVideoCommentsView.a(this.a, false);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.a.a.a.size() > 0) && (!ShortVideoCommentsView.b(this.a)) && (!ShortVideoCommentsView.c(this.a))) {
        ShortVideoCommentsView.c(this.a);
      }
      if (ShortVideoCommentsView.a(this.a) == null) {
        break label269;
      }
      paramAbsListView = ShortVideoCommentsView.a(this.a).jdField_a_of_type_JavaLangString;
      if (ShortVideoCommentsView.a(this.a) != null) {
        long l = ShortVideoCommentsView.a(this.a).jdField_a_of_type_Long;
      }
      paramInt = ShortVideoCommentsView.a(this.a);
      if ((paramInt < ShortVideoCommentsView.b(this.a)) || (paramInt < muc.a(this.a.getContext(), 40.0F))) {
        break label272;
      }
      if (!ShortVideoCommentsView.d(this.a))
      {
        ShortVideoCommentsView.a(this.a, true);
        if (ShortVideoCommentsView.a(this.a).j != 4) {}
      }
      this.a.f();
    }
    for (;;)
    {
      ShortVideoCommentsView.a(this.a, paramInt);
      if ((ShortVideoCommentsView.a(this.a) != null) && (ShortVideoCommentsView.a(this.a).getChildCount() > 0) && (ShortVideoCommentsView.a(this.a).getChildAt(0).getTop() == 0) && (!ShortVideoCommentsView.e(this.a)))
      {
        ShortVideoCommentsView.b(this.a, true);
        this.a.postDelayed(new ShortVideoCommentsView.10.1(this), 100L);
      }
      return;
      label269:
      break;
      label272:
      if (!ShortVideoCommentsView.e(this.a))
      {
        this.a.j();
        ShortVideoCommentsView.a(this.a, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atjj
 * JD-Core Version:    0.7.0.1
 */