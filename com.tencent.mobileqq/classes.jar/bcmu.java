import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class bcmu
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bcmx> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  bcmy jdField_a_of_type_Bcmy;
  
  public bcmu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcmy = new bcmy(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165428)));
  }
  
  public bcmu a(int paramInt, View paramView, bcmw parambcmw)
  {
    bcmx localbcmx = (bcmx)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbcmx != null) {
      localbcmx.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambcmw));
    }
    return this;
  }
  
  public bcmu a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      bcmx localbcmx = new bcmx(this, null);
      localbcmx.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbcmx.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbcmx.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbcmx);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Bcmy);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Bcmy.setOnClickListener(new bcmv(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmu
 * JD-Core Version:    0.7.0.1
 */