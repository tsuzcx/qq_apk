import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class bhxn
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bhxq> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  bhxr jdField_a_of_type_Bhxr;
  
  public bhxn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhxr = new bhxr(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165500)));
  }
  
  public bhxn a(int paramInt, View paramView, bhxp parambhxp)
  {
    bhxq localbhxq = (bhxq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbhxq != null) {
      localbhxq.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambhxp));
    }
    return this;
  }
  
  public bhxn a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      bhxq localbhxq = new bhxq(this, null);
      localbhxq.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbhxq.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbhxq.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbhxq);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Bhxr);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Bhxr.setOnClickListener(new bhxo(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxn
 * JD-Core Version:    0.7.0.1
 */