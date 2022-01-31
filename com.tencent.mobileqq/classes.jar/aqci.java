import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class aqci
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqfj jdField_a_of_type_Aqfj;
  
  public aqci(View paramView, aqfj paramaqfj)
  {
    super(paramView);
    this.jdField_a_of_type_Aqfj = paramaqfj;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379177));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(aqhx.a);
  }
  
  public void a(aqci paramaqci, aqcx paramaqcx)
  {
    String str = "";
    boolean bool = false;
    switch (paramaqcx.mFooterType)
    {
    default: 
      paramaqcx = str;
    }
    for (;;)
    {
      paramaqci.jdField_a_of_type_AndroidWidgetTextView.setText(paramaqcx);
      paramaqci.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramaqcx = alud.a(2131705102);
      continue;
      paramaqcx = alud.a(2131705104);
      bool = true;
      continue;
      paramaqcx = alud.a(2131705103);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aqfj != null) {
      this.jdField_a_of_type_Aqfj.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqci
 * JD-Core Version:    0.7.0.1
 */