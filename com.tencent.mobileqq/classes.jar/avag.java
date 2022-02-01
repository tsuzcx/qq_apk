import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;

public class avag
  extends RecyclerView.OnScrollListener
  implements avdu
{
  private int jdField_a_of_type_Int = 0;
  private asag jdField_a_of_type_Asag;
  private avdt jdField_a_of_type_Avdt = new avdt(200, this);
  
  public avag(asag paramasag)
  {
    this.jdField_a_of_type_Asag = paramasag;
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.jdField_a_of_type_Avdt.a(true);
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_Asag != null)) {
        this.jdField_a_of_type_Asag.n();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Asag != null))
    {
      this.jdField_a_of_type_Asag.m();
      this.jdField_a_of_type_Avdt.a(false);
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.jdField_a_of_type_Int == 2) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_Asag != null)) {
        this.jdField_a_of_type_Asag.n();
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.jdField_a_of_type_Avdt.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avag
 * JD-Core Version:    0.7.0.1
 */