import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bcbu
  implements View.OnLayoutChangeListener
{
  bcbu(bcbq parambcbq, View paramView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidGraphicsRect);
    paramInt2 = this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidGraphicsRect.left;
    paramInt4 = this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidGraphicsRect.top;
    if ((this.jdField_a_of_type_Bcbq.jdField_c_of_type_Int != paramInt2) || (this.jdField_a_of_type_Bcbq.d != paramInt4))
    {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_Bcbq.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Bcbq.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_Bcbq.d = paramInt4;
    }
    paramInt1 = paramInt3 - paramInt1;
    if (paramInt1 != paramInt7 - paramInt5)
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if ((paramView.leftMargin > paramInt1 / 2) && (this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView != null) && (8 == this.jdField_a_of_type_Bcbq.jdField_c_of_type_AndroidViewView.getVisibility()))
      {
        paramView.leftMargin = (paramInt1 - this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView.getWidth());
        this.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
      }
    }
    this.jdField_a_of_type_Bcbq.jdField_a_of_type_Int = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcbu
 * JD-Core Version:    0.7.0.1
 */