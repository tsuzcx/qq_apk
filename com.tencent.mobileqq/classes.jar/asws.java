import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asws
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aszz jdField_a_of_type_Aszz;
  
  public asws(View paramView, aszz paramaszz)
  {
    super(paramView);
    this.jdField_a_of_type_Aszz = paramaszz;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380285));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(atcx.a);
  }
  
  public void a(asws paramasws, asxh paramasxh)
  {
    String str = "";
    boolean bool = false;
    switch (paramasxh.mFooterType)
    {
    default: 
      paramasxh = str;
    }
    for (;;)
    {
      paramasws.jdField_a_of_type_AndroidWidgetTextView.setText(paramasxh);
      paramasws.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramasxh = anzj.a(2131703605);
      continue;
      paramasxh = anzj.a(2131703607);
      bool = true;
      continue;
      paramasxh = anzj.a(2131703606);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aszz != null) {
      this.jdField_a_of_type_Aszz.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asws
 * JD-Core Version:    0.7.0.1
 */