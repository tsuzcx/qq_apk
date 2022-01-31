import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class blbe
  extends blfs
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bkpl jdField_a_of_type_Bkpl;
  private blbp jdField_a_of_type_Blbp;
  private blct jdField_a_of_type_Blct;
  private blfq jdField_a_of_type_Blfq;
  private blfr jdField_a_of_type_Blfr;
  private String jdField_a_of_type_JavaLangString;
  private List<blag> jdField_a_of_type_JavaUtilList;
  
  public blbe(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
  }
  
  private void a(blag paramblag)
  {
    this.jdField_a_of_type_Blbp.c(paramblag);
    if (paramblag == null)
    {
      this.jdField_a_of_type_Blbp.b(null);
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramblag.jdField_a_of_type_JavaLangString;
    switch (paramblag.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Blbp.a(paramblag);
      return;
    }
    this.jdField_a_of_type_Blbp.b(paramblag);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new blbg(this));
    this.jdField_a_of_type_Blfr = ((blfr)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfr.class));
    this.jdField_a_of_type_Blfr.a().a(this.jdField_a_of_type_Bkpl, new blbh(this));
    this.jdField_a_of_type_Blbp = ((blbp)bkpx.a(this.jdField_a_of_type_Bkpl).a(blbp.class));
    this.jdField_a_of_type_Blbp.a().a(this.jdField_a_of_type_Bkpl, new blbi(this));
    this.jdField_a_of_type_Blbp.b().a(this.jdField_a_of_type_Bkpl, new blbj(this));
    this.jdField_a_of_type_Blbp.a(this.jdField_a_of_type_Bkpl);
  }
  
  private void e()
  {
    yyk.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new blbk(this)).b();
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
    this.jdField_a_of_type_Blct = new blct(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Blct.a(new blbf(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Blct);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    d();
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbe
 * JD-Core Version:    0.7.0.1
 */