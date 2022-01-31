import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class avos
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  avot jdField_a_of_type_Avot;
  bhpo jdField_a_of_type_Bhpo;
  bhqr jdField_a_of_type_Bhqr;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  boolean jdField_a_of_type_Boolean;
  
  public avos(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_Avot = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bhpo = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_Bhqr = null;
  }
  
  View.OnTouchListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnTouchListener;
  }
  
  ListAdapter a()
  {
    ListAdapter localListAdapter2 = (ListAdapter)this.jdField_a_of_type_ComTencentWidgetAbsListView.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof WrapperListAdapter)) {
      localListAdapter1 = ((WrapperListAdapter)localListAdapter2).getWrappedAdapter();
    }
    return localListAdapter1;
  }
  
  public ListAdapter a(ListAdapter paramListAdapter)
  {
    return a(this.jdField_a_of_type_Avot, paramListAdapter);
  }
  
  ListAdapter a(avot paramavot, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramavot != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new avop(paramavot, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  bhpo a()
  {
    return this.jdField_a_of_type_Bhpo;
  }
  
  bhqr a()
  {
    return this.jdField_a_of_type_Bhqr;
  }
  
  AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avot != null) {
      this.jdField_a_of_type_Avot.b();
    }
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  @TargetApi(11)
  void a(ListAdapter paramListAdapter)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setAdapter(paramListAdapter);
    }
    while (!(this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView)) {
      return;
    }
    ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setAdapter(paramListAdapter);
  }
  
  public void a(avot paramavot)
  {
    if (this.jdField_a_of_type_Avot != null)
    {
      this.jdField_a_of_type_Avot.a(null);
      this.jdField_a_of_type_Avot = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramavot != null)
    {
      paramavot.a(this);
      a(a(paramavot, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_Avot = paramavot;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_Bhpo);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_Bhqr);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(bhpo parambhpo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bhpo = parambhpo;
  }
  
  public void a(bhqr parambhqr)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bhqr = parambhqr;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Avot != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_Avot.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avos
 * JD-Core Version:    0.7.0.1
 */