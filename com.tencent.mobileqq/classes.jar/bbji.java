import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class bbji
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bbjl> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  bbjm jdField_a_of_type_Bbjm;
  
  public bbji(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bbjm = new bbjm(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099869)));
  }
  
  public bbji a(int paramInt, View paramView, bbjk parambbjk)
  {
    bbjl localbbjl = (bbjl)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbbjl != null) {
      localbbjl.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambbjk));
    }
    return this;
  }
  
  public bbji a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      bbjl localbbjl = new bbjl(this, null);
      localbbjl.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbbjl.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbbjl.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbbjl);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Bbjm);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Bbjm.setOnClickListener(new bbjj(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbji
 * JD-Core Version:    0.7.0.1
 */