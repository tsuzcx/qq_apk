import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class atxm
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  atxn jdField_a_of_type_Atxn;
  bfob jdField_a_of_type_Bfob;
  bfpe jdField_a_of_type_Bfpe;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  boolean jdField_a_of_type_Boolean;
  
  public atxm(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_Atxn = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bfob = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_Bfpe = null;
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
    return a(this.jdField_a_of_type_Atxn, paramListAdapter);
  }
  
  ListAdapter a(atxn paramatxn, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramatxn != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new atxj(paramatxn, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  bfob a()
  {
    return this.jdField_a_of_type_Bfob;
  }
  
  bfpe a()
  {
    return this.jdField_a_of_type_Bfpe;
  }
  
  AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atxn != null) {
      this.jdField_a_of_type_Atxn.b();
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
  
  public void a(atxn paramatxn)
  {
    if (this.jdField_a_of_type_Atxn != null)
    {
      this.jdField_a_of_type_Atxn.a(null);
      this.jdField_a_of_type_Atxn = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramatxn != null)
    {
      paramatxn.a(this);
      a(a(paramatxn, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_Atxn = paramatxn;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_Bfob);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_Bfpe);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(bfob parambfob)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bfob = parambfob;
  }
  
  public void a(bfpe parambfpe)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bfpe = parambfpe;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Atxn != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_Atxn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxm
 * JD-Core Version:    0.7.0.1
 */