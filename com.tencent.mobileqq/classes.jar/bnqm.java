import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class bnqm
  extends bnva
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bndy jdField_a_of_type_Bndy;
  private bnqx jdField_a_of_type_Bnqx;
  private bnsb jdField_a_of_type_Bnsb;
  private bnuy jdField_a_of_type_Bnuy;
  private bnuz jdField_a_of_type_Bnuz;
  private String jdField_a_of_type_JavaLangString;
  private List<bnpk> jdField_a_of_type_JavaUtilList;
  
  public bnqm(Activity paramActivity, View paramView, bnvb parambnvb)
  {
    super(paramActivity, paramView, parambnvb);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Bndy = ((bndy)parambnvb.a(65537, new Object[0]));
  }
  
  private void a(bnpk parambnpk)
  {
    this.jdField_a_of_type_Bnqx.c(parambnpk);
    if (parambnpk == null)
    {
      this.jdField_a_of_type_Bnqx.b(null);
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambnpk.jdField_a_of_type_JavaLangString;
    switch (parambnpk.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Bnqx.a(parambnpk);
      return;
    }
    this.jdField_a_of_type_Bnqx.b(parambnpk);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_Bnuy.a.observe(this.jdField_a_of_type_Bndy, new bnqo(this));
    this.jdField_a_of_type_Bnuz = ((bnuz)bner.a(this.jdField_a_of_type_Bndy).get(bnuz.class));
    this.jdField_a_of_type_Bnuz.a().observe(this.jdField_a_of_type_Bndy, new bnqp(this));
    this.jdField_a_of_type_Bnqx = ((bnqx)bner.a(this.jdField_a_of_type_Bndy).get(bnqx.class));
    this.jdField_a_of_type_Bnqx.a().observe(this.jdField_a_of_type_Bndy, new bnqq(this));
    this.jdField_a_of_type_Bnqx.b().observe(this.jdField_a_of_type_Bndy, new bnqr(this));
    this.jdField_a_of_type_Bnqx.a(this.jdField_a_of_type_Bndy);
  }
  
  private void e()
  {
    aavn.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bnqs(this)).b();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362258));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bnsb = new bnsb(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bnsb.a(new bnqn(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnsb);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    d();
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqm
 * JD-Core Version:    0.7.0.1
 */