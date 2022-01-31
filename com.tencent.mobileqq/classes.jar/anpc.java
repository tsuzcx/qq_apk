import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class anpc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansk jdField_a_of_type_Ansk;
  
  public anpc(View paramView, ansk paramansk)
  {
    super(paramView);
    this.jdField_a_of_type_Ansk = paramansk;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312678));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(anue.a);
  }
  
  public void a(anpc paramanpc, anpv paramanpv)
  {
    String str = "";
    boolean bool = false;
    switch (paramanpv.mFooterType)
    {
    default: 
      paramanpv = str;
    }
    for (;;)
    {
      paramanpc.jdField_a_of_type_AndroidWidgetTextView.setText(paramanpv);
      paramanpc.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramanpv = ajjy.a(2131638922);
      continue;
      paramanpv = ajjy.a(2131638924);
      bool = true;
      continue;
      paramanpv = ajjy.a(2131638923);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ansk != null) {
      this.jdField_a_of_type_Ansk.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */