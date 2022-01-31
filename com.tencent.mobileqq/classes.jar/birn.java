import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class birn
  extends biwa
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private biim jdField_a_of_type_Biim;
  private biry jdField_a_of_type_Biry;
  private bitc jdField_a_of_type_Bitc;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private String jdField_a_of_type_JavaLangString;
  private List<biqs> jdField_a_of_type_JavaUtilList;
  
  public birn(Activity paramActivity, View paramView, biwb parambiwb)
  {
    super(paramActivity, paramView, parambiwb);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Biim = ((biim)parambiwb.a(65537, new Object[0]));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this.jdField_a_of_type_Biim, new birp(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this.jdField_a_of_type_Biim).a(bivz.class));
    this.jdField_a_of_type_Bivz.a().a(this.jdField_a_of_type_Biim, new birq(this));
    this.jdField_a_of_type_Biry = ((biry)biix.a(this.jdField_a_of_type_Biim).a(biry.class));
    this.jdField_a_of_type_Biry.a().a(this.jdField_a_of_type_Biim, new birr(this));
    this.jdField_a_of_type_Biry.b().a(this.jdField_a_of_type_Biim, new birs(this));
    this.jdField_a_of_type_Biry.a(this.jdField_a_of_type_Biim);
  }
  
  private void e()
  {
    xff.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new birt(this)).b();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362172));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bitc = new bitc(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bitc.a(new biro(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bitc);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    d();
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birn
 * JD-Core Version:    0.7.0.1
 */