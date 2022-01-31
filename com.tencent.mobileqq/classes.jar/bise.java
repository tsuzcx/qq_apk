import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class bise
  extends biwr
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bijd jdField_a_of_type_Bijd;
  private bisp jdField_a_of_type_Bisp;
  private bitt jdField_a_of_type_Bitt;
  private biwp jdField_a_of_type_Biwp;
  private biwq jdField_a_of_type_Biwq;
  private String jdField_a_of_type_JavaLangString;
  private List<birj> jdField_a_of_type_JavaUtilList;
  
  public bise(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, new bisg(this));
    this.jdField_a_of_type_Biwq = ((biwq)bijo.a(this.jdField_a_of_type_Bijd).a(biwq.class));
    this.jdField_a_of_type_Biwq.a().a(this.jdField_a_of_type_Bijd, new bish(this));
    this.jdField_a_of_type_Bisp = ((bisp)bijo.a(this.jdField_a_of_type_Bijd).a(bisp.class));
    this.jdField_a_of_type_Bisp.a().a(this.jdField_a_of_type_Bijd, new bisi(this));
    this.jdField_a_of_type_Bisp.b().a(this.jdField_a_of_type_Bijd, new bisj(this));
    this.jdField_a_of_type_Bisp.a(this.jdField_a_of_type_Bijd);
  }
  
  private void e()
  {
    xfc.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bisk(this)).b();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362171));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bitt = new bitt(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bitt.a(new bisf(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bitt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    d();
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bise
 * JD-Core Version:    0.7.0.1
 */