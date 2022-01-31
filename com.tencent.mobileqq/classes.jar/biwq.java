import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import dov.com.qq.im.ae.play.AEPlayShowPageView;

public class biwq
  extends RecyclerView.ItemDecoration
{
  public biwq(AEPlayShowPageView paramAEPlayShowPageView, biwk parambiwk) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (AEPlayShowPageView.a(this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView) != 1)
    {
      paramRect.left = this.jdField_a_of_type_Biwk.c;
      paramRect.right = this.jdField_a_of_type_Biwk.c;
      paramRect.top = this.jdField_a_of_type_Biwk.d;
      paramRect.bottom = this.jdField_a_of_type_Biwk.d;
      return;
    }
    paramRect.bottom = this.jdField_a_of_type_Biwk.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwq
 * JD-Core Version:    0.7.0.1
 */