import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import dov.com.qq.im.ae.play.AEPlayShowPageView;

public class bnvq
  extends RecyclerView.ItemDecoration
{
  public bnvq(AEPlayShowPageView paramAEPlayShowPageView, bnvk parambnvk) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (AEPlayShowPageView.a(this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView) != 1)
    {
      paramRect.left = this.jdField_a_of_type_Bnvk.c;
      paramRect.right = this.jdField_a_of_type_Bnvk.c;
      paramRect.top = this.jdField_a_of_type_Bnvk.d;
      paramRect.bottom = this.jdField_a_of_type_Bnvk.d;
      return;
    }
    paramRect.bottom = this.jdField_a_of_type_Bnvk.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvq
 * JD-Core Version:    0.7.0.1
 */