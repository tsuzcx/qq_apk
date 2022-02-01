import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ariv
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private armg jdField_a_of_type_Armg;
  
  public ariv(View paramView, armg paramarmg)
  {
    super(paramView);
    this.jdField_a_of_type_Armg = paramarmg;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380012));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(arpf.a);
  }
  
  public void a(ariv paramariv, arjk paramarjk)
  {
    String str = "";
    boolean bool = false;
    switch (paramarjk.mFooterType)
    {
    default: 
      paramarjk = str;
    }
    for (;;)
    {
      paramariv.jdField_a_of_type_AndroidWidgetTextView.setText(paramarjk);
      paramariv.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramarjk = amtj.a(2131703835);
      continue;
      paramarjk = amtj.a(2131703837);
      bool = true;
      continue;
      paramarjk = amtj.a(2131703836);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Armg != null) {
      this.jdField_a_of_type_Armg.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariv
 * JD-Core Version:    0.7.0.1
 */