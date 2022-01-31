import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class bkwx
  extends blbl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bkle jdField_a_of_type_Bkle;
  private bkxi jdField_a_of_type_Bkxi;
  private bkym jdField_a_of_type_Bkym;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private String jdField_a_of_type_JavaLangString;
  private List<bkvz> jdField_a_of_type_JavaUtilList;
  
  public bkwx(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
  }
  
  private void a(bkvz parambkvz)
  {
    this.jdField_a_of_type_Bkxi.c(parambkvz);
    if (parambkvz == null)
    {
      this.jdField_a_of_type_Bkxi.b(null);
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambkvz.jdField_a_of_type_JavaLangString;
    switch (parambkvz.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Bkxi.a(parambkvz);
      return;
    }
    this.jdField_a_of_type_Bkxi.b(parambkvz);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_Blbj.a.a(this.jdField_a_of_type_Bkle, new bkwz(this));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this.jdField_a_of_type_Bkle).a(blbk.class));
    this.jdField_a_of_type_Blbk.a().a(this.jdField_a_of_type_Bkle, new bkxa(this));
    this.jdField_a_of_type_Bkxi = ((bkxi)bklq.a(this.jdField_a_of_type_Bkle).a(bkxi.class));
    this.jdField_a_of_type_Bkxi.a().a(this.jdField_a_of_type_Bkle, new bkxb(this));
    this.jdField_a_of_type_Bkxi.b().a(this.jdField_a_of_type_Bkle, new bkxc(this));
    this.jdField_a_of_type_Bkxi.a(this.jdField_a_of_type_Bkle);
  }
  
  private void e()
  {
    ytv.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bkxd(this)).b();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362188));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bkym = new bkym(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bkym.a(new bkwy(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkym);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    d();
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwx
 * JD-Core Version:    0.7.0.1
 */