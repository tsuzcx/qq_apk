import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment;

public class bhbf
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  
  public bhbf(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, int paramInt)
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
 * Qualified Name:     bhbf
 * JD-Core Version:    0.7.0.1
 */