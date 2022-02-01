import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class awed
  extends RecyclerView.ItemDecoration
{
  int jdField_a_of_type_Int = ViewUtils.dip2px(1.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  awdu jdField_a_of_type_Awdu;
  
  public awed(Context paramContext, awdu paramawdu, boolean paramBoolean)
  {
    this.jdField_a_of_type_Awdu = paramawdu;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131165771));
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131165770));
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (this.jdField_a_of_type_Awdu == null) {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "MyItemDecoration getItemOffsets mAdapter == null");
    }
    while (paramRecyclerView.getChildAdapterPosition(paramView) < 0) {
      return;
    }
    paramRect.bottom = this.jdField_a_of_type_Int;
    paramRect.right = this.jdField_a_of_type_Int;
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      Object localObject = paramState.getTag(2131369981);
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2)) {
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop(), paramState.getRight(), paramState.getBottom(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awed
 * JD-Core Version:    0.7.0.1
 */