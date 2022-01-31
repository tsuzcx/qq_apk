import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class aofs
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aojb jdField_a_of_type_Aojb;
  
  public aofs(View paramView, aojb paramaojb)
  {
    super(paramView);
    this.jdField_a_of_type_Aojb = paramaojb;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378507));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(aokw.a);
  }
  
  public void a(aofs paramaofs, aogm paramaogm)
  {
    String str = "";
    boolean bool = false;
    switch (paramaogm.mFooterType)
    {
    default: 
      paramaogm = str;
    }
    for (;;)
    {
      paramaofs.jdField_a_of_type_AndroidWidgetTextView.setText(paramaogm);
      paramaofs.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramaogm = ajya.a(2131704718);
      continue;
      paramaogm = ajya.a(2131704720);
      bool = true;
      continue;
      paramaogm = ajya.a(2131704719);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aojb != null) {
      this.jdField_a_of_type_Aojb.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofs
 * JD-Core Version:    0.7.0.1
 */