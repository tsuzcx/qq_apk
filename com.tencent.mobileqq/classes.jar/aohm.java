import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

public class aohm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoiy jdField_a_of_type_Aoiy;
  
  public aohm(ExtendFriendGroupFragment paramExtendFriendGroupFragment, View paramView, aoiy paramaoiy)
  {
    super(paramView);
    this.jdField_a_of_type_Aoiy = paramaoiy;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378507));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ExtendFriendGroupFragment.a(paramExtendFriendGroupFragment));
  }
  
  public void a(aohm paramaohm, int paramInt)
  {
    String str = "";
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramaohm.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramaohm.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      str = ajya.a(2131704274);
      continue;
      str = ajya.a(2131704258);
      bool = true;
      continue;
      str = ajya.a(2131704256);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aoiy != null) {
      this.jdField_a_of_type_Aoiy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohm
 * JD-Core Version:    0.7.0.1
 */