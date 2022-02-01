import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;

public class avsh
  extends RecyclerView.OnScrollListener
  implements avvw
{
  private int jdField_a_of_type_Int = 0;
  private aspu jdField_a_of_type_Aspu;
  private avvv jdField_a_of_type_Avvv = new avvv(200, this);
  
  public avsh(aspu paramaspu)
  {
    this.jdField_a_of_type_Aspu = paramaspu;
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.jdField_a_of_type_Avvv.a(true);
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_Aspu != null)) {
        this.jdField_a_of_type_Aspu.n();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aspu != null))
    {
      this.jdField_a_of_type_Aspu.m();
      this.jdField_a_of_type_Avvv.a(false);
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.jdField_a_of_type_Int == 2) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.jdField_a_of_type_Aspu != null)) {
        this.jdField_a_of_type_Aspu.n();
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.jdField_a_of_type_Avvv.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsh
 * JD-Core Version:    0.7.0.1
 */