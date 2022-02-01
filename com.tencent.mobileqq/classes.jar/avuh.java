import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;

public class avuh
  extends RecyclerView.OnScrollListener
{
  public avuh(HotPicRecyclerView paramHotPicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      avup.c();
      this.a.b();
      if (paramInt != 2) {
        break label128;
      }
      this.a.jdField_a_of_type_Avvv.a(true);
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.a.jdField_a_of_type_Int == 2))
      {
        ((StaggeredGridLayoutManager)this.a.getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.a.jdField_a_of_type_ArrayOfInt);
        if ((this.a.jdField_a_of_type_ArrayOfInt[0] == 0) && (this.a.jdField_a_of_type_Avui != null)) {
          this.a.jdField_a_of_type_Avui.d();
        }
      }
      this.a.jdField_a_of_type_Int = paramInt;
      return;
      this.a.c();
      AbstractGifImage.pauseAll();
      avup.b();
      break;
      label128:
      this.a.jdField_a_of_type_Avvv.a(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.a.jdField_a_of_type_Avvv.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuh
 * JD-Core Version:    0.7.0.1
 */