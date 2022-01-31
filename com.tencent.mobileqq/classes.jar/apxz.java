import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class apxz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqba jdField_a_of_type_Aqba;
  
  public apxz(View paramView, aqba paramaqba)
  {
    super(paramView);
    this.jdField_a_of_type_Aqba = paramaqba;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379119));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(aqdo.a);
  }
  
  public void a(apxz paramapxz, apyo paramapyo)
  {
    String str = "";
    boolean bool = false;
    switch (paramapyo.mFooterType)
    {
    default: 
      paramapyo = str;
    }
    for (;;)
    {
      paramapxz.jdField_a_of_type_AndroidWidgetTextView.setText(paramapyo);
      paramapxz.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramapyo = alpo.a(2131705090);
      continue;
      paramapyo = alpo.a(2131705092);
      bool = true;
      continue;
      paramapyo = alpo.a(2131705091);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aqba != null) {
      this.jdField_a_of_type_Aqba.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxz
 * JD-Core Version:    0.7.0.1
 */