import android.util.SparseArray;
import android.view.View;
import com.tencent.widget.AbsSpinner;

public class bego
{
  private final SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public bego(AbsSpinner paramAbsSpinner) {}
  
  public View a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localView != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
    }
    return localView;
  }
  
  public void a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.a(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
  }
  
  public void b()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = (View)localSparseArray.valueAt(i);
      if ((localView == null) || (!(localView.getTag(2131301287) instanceof Boolean))) {
        break label94;
      }
    }
    label94:
    for (boolean bool = ((Boolean)localView.getTag(2131301287)).booleanValue();; bool = true)
    {
      if ((localView != null) && (bool)) {
        AbsSpinner.b(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
      break;
      localSparseArray.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bego
 * JD-Core Version:    0.7.0.1
 */