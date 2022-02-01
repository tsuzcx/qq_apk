import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class bipf
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bipi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  bipj jdField_a_of_type_Bipj;
  
  public bipf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bipj = new bipj(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165512)));
  }
  
  public bipf a(int paramInt, View paramView, biph parambiph)
  {
    bipi localbipi = (bipi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbipi != null) {
      localbipi.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambiph));
    }
    return this;
  }
  
  public bipf a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      bipi localbipi = new bipi(this, null);
      localbipi.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbipi.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbipi.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbipi);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Bipj);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Bipj.setOnClickListener(new bipg(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipf
 * JD-Core Version:    0.7.0.1
 */