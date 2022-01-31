import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class biyh
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  
  public biyh(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    super.getItemOffsets(paramRect, paramInt, paramRecyclerView);
    if (paramInt == 0) {
      paramRect.left = this.jdField_a_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biyh
 * JD-Core Version:    0.7.0.1
 */