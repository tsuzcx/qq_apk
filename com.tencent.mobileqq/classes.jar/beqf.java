import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class beqf
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<beqi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  beqj jdField_a_of_type_Beqj;
  
  public beqf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Beqj = new beqj(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165463)));
  }
  
  public beqf a(int paramInt, View paramView, beqh parambeqh)
  {
    beqi localbeqi = (beqi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbeqi != null) {
      localbeqi.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambeqh));
    }
    return this;
  }
  
  public beqf a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      beqi localbeqi = new beqi(this, null);
      localbeqi.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbeqi.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbeqi.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbeqi);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Beqj);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Beqj.setOnClickListener(new beqg(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqf
 * JD-Core Version:    0.7.0.1
 */