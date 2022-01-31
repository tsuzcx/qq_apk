import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class bcmf
{
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<bcmi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  bcmj jdField_a_of_type_Bcmj;
  
  public bcmf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcmj = new bcmj(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165428)));
  }
  
  public bcmf a(int paramInt, View paramView, bcmh parambcmh)
  {
    bcmi localbcmi = (bcmi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbcmi != null) {
      localbcmi.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, parambcmh));
    }
    return this;
  }
  
  public bcmf a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      bcmi localbcmi = new bcmi(this, null);
      localbcmi.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localbcmi.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localbcmi.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbcmi);
    }
    return this;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Bcmj);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Bcmj.setOnClickListener(new bcmg(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmf
 * JD-Core Version:    0.7.0.1
 */