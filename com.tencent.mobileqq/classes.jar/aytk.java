import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class aytk
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  aytl jdField_a_of_type_Aytl;
  blih jdField_a_of_type_Blih;
  bljo jdField_a_of_type_Bljo;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  boolean jdField_a_of_type_Boolean;
  
  public aytk(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_Aytl = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Blih = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_Bljo = null;
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
    return a(this.jdField_a_of_type_Aytl, paramListAdapter);
  }
  
  ListAdapter a(aytl paramaytl, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramaytl != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new ayth(paramaytl, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  blih a()
  {
    return this.jdField_a_of_type_Blih;
  }
  
  bljo a()
  {
    return this.jdField_a_of_type_Bljo;
  }
  
  AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aytl != null) {
      this.jdField_a_of_type_Aytl.b();
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
  
  public void a(aytl paramaytl)
  {
    if (this.jdField_a_of_type_Aytl != null)
    {
      this.jdField_a_of_type_Aytl.a(null);
      this.jdField_a_of_type_Aytl = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramaytl != null)
    {
      paramaytl.a(this);
      a(a(paramaytl, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aytl = paramaytl;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_Blih);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_Bljo);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(blih paramblih)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Blih = paramblih;
  }
  
  public void a(bljo parambljo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bljo = parambljo;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aytl != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_Aytl.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytk
 * JD-Core Version:    0.7.0.1
 */