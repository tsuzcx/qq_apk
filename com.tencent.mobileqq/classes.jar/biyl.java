import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class biyl
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<biyo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  biyp jdField_a_of_type_Biyp;
  
  public biyl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biyp = new biyp(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165498)));
  }
  
  public biyl a(int paramInt, View paramView, biyn parambiyn)
  {
    biyo localbiyo = (biyo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbiyo != null) {
      localbiyo.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambiyn));
    }
    return this;
  }
  
  public biyl a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      biyo localbiyo = new biyo(this, null);
      localbiyo.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbiyo.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbiyo.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbiyo);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Biyp);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Biyp.setOnClickListener(new biym(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyl
 * JD-Core Version:    0.7.0.1
 */