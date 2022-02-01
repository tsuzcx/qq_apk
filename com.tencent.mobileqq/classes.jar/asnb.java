import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asnb
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asqm jdField_a_of_type_Asqm;
  
  public asnb(View paramView, asqm paramasqm)
  {
    super(paramView);
    this.jdField_a_of_type_Asqm = paramasqm;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380347));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(astl.a);
  }
  
  public void a(asnb paramasnb, asnq paramasnq)
  {
    String str = "";
    boolean bool = false;
    switch (paramasnq.mFooterType)
    {
    default: 
      paramasnq = str;
    }
    for (;;)
    {
      paramasnb.jdField_a_of_type_AndroidWidgetTextView.setText(paramasnq);
      paramasnb.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramasnq = anvx.a(2131704186);
      continue;
      paramasnq = anvx.a(2131704188);
      bool = true;
      continue;
      paramasnq = anvx.a(2131704187);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Asqm != null) {
      this.jdField_a_of_type_Asqm.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnb
 * JD-Core Version:    0.7.0.1
 */