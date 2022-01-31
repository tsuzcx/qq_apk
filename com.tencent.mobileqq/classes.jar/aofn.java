import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class aofn
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoiw jdField_a_of_type_Aoiw;
  
  public aofn(View paramView, aoiw paramaoiw)
  {
    super(paramView);
    this.jdField_a_of_type_Aoiw = paramaoiw;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378502));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(aokr.a);
  }
  
  public void a(aofn paramaofn, aogh paramaogh)
  {
    String str = "";
    boolean bool = false;
    switch (paramaogh.mFooterType)
    {
    default: 
      paramaogh = str;
    }
    for (;;)
    {
      paramaofn.jdField_a_of_type_AndroidWidgetTextView.setText(paramaogh);
      paramaofn.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramaogh = ajyc.a(2131704707);
      continue;
      paramaogh = ajyc.a(2131704709);
      bool = true;
      continue;
      paramaogh = ajyc.a(2131704708);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aoiw != null) {
      this.jdField_a_of_type_Aoiw.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofn
 * JD-Core Version:    0.7.0.1
 */