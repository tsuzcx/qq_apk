import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;

public class aqzx
  extends RecyclerView.OnScrollListener
{
  public aqzx(HotPicRecyclerView paramHotPicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      araf.c();
      this.a.b();
      if (paramInt != 2) {
        break label128;
      }
      this.a.jdField_a_of_type_Arbl.a(true);
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.a.jdField_a_of_type_Int == 2))
      {
        ((StaggeredGridLayoutManager)this.a.getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.a.jdField_a_of_type_ArrayOfInt);
        if ((this.a.jdField_a_of_type_ArrayOfInt[0] == 0) && (this.a.jdField_a_of_type_Aqzy != null)) {
          this.a.jdField_a_of_type_Aqzy.d();
        }
      }
      this.a.jdField_a_of_type_Int = paramInt;
      return;
      this.a.c();
      AbstractGifImage.pauseAll();
      araf.b();
      break;
      label128:
      this.a.jdField_a_of_type_Arbl.a(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.a.jdField_a_of_type_Arbl.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqzx
 * JD-Core Version:    0.7.0.1
 */