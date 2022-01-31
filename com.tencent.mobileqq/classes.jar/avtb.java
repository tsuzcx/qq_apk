import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class avtb
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  avtc jdField_a_of_type_Avtc;
  bhtv jdField_a_of_type_Bhtv;
  bhuy jdField_a_of_type_Bhuy;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  boolean jdField_a_of_type_Boolean;
  
  public avtb(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_Avtc = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bhtv = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_Bhuy = null;
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
    return a(this.jdField_a_of_type_Avtc, paramListAdapter);
  }
  
  ListAdapter a(avtc paramavtc, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramavtc != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new avsy(paramavtc, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  bhtv a()
  {
    return this.jdField_a_of_type_Bhtv;
  }
  
  bhuy a()
  {
    return this.jdField_a_of_type_Bhuy;
  }
  
  AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avtc != null) {
      this.jdField_a_of_type_Avtc.b();
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
  
  public void a(avtc paramavtc)
  {
    if (this.jdField_a_of_type_Avtc != null)
    {
      this.jdField_a_of_type_Avtc.a(null);
      this.jdField_a_of_type_Avtc = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramavtc != null)
    {
      paramavtc.a(this);
      a(a(paramavtc, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_Avtc = paramavtc;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_Bhuy);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(bhtv parambhtv)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bhtv = parambhtv;
  }
  
  public void a(bhuy parambhuy)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bhuy = parambhuy;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Avtc != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_Avtc.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtb
 * JD-Core Version:    0.7.0.1
 */