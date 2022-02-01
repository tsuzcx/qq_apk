import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ashe
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aski jdField_a_of_type_Aski;
  
  public ashe(View paramView, aski paramaski)
  {
    super(paramView);
    this.jdField_a_of_type_Aski = paramaski;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380100));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(asmy.a);
  }
  
  public void a(ashe paramashe, asht paramasht)
  {
    String str = "";
    boolean bool = false;
    switch (paramasht.mFooterType)
    {
    default: 
      paramasht = str;
    }
    for (;;)
    {
      paramashe.jdField_a_of_type_AndroidWidgetTextView.setText(paramasht);
      paramashe.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramasht = anni.a(2131703498);
      continue;
      paramasht = anni.a(2131703500);
      bool = true;
      continue;
      paramasht = anni.a(2131703499);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aski != null) {
      this.jdField_a_of_type_Aski.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashe
 * JD-Core Version:    0.7.0.1
 */