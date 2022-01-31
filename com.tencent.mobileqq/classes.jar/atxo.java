import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class atxo
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  atxp jdField_a_of_type_Atxp;
  bfos jdField_a_of_type_Bfos;
  bfpv jdField_a_of_type_Bfpv;
  final AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  boolean jdField_a_of_type_Boolean;
  
  public atxo(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidWidgetListAdapter = null;
    this.jdField_a_of_type_Atxp = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bfos = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_Bfpv = null;
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
    return a(this.jdField_a_of_type_Atxp, paramListAdapter);
  }
  
  ListAdapter a(atxp paramatxp, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramatxp != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new atxl(paramatxp, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  bfos a()
  {
    return this.jdField_a_of_type_Bfos;
  }
  
  bfpv a()
  {
    return this.jdField_a_of_type_Bfpv;
  }
  
  AbsListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atxp != null) {
      this.jdField_a_of_type_Atxp.b();
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
  
  public void a(atxp paramatxp)
  {
    if (this.jdField_a_of_type_Atxp != null)
    {
      this.jdField_a_of_type_Atxp.a(null);
      this.jdField_a_of_type_Atxp = null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramatxp != null)
    {
      paramatxp.a(this);
      a(a(paramatxp, this.jdField_a_of_type_AndroidWidgetListAdapter));
    }
    for (;;)
    {
      this.jdField_a_of_type_Atxp = paramatxp;
      this.jdField_a_of_type_Boolean = false;
      b();
      return;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.setOnItemSelectedListener(this.jdField_a_of_type_Bfpv);
      a(this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void a(bfos parambfos)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bfos = parambfos;
  }
  
  public void a(bfpv parambfpv)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bfpv = parambfpv;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Atxp != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null)) {
      this.jdField_a_of_type_Atxp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxo
 * JD-Core Version:    0.7.0.1
 */