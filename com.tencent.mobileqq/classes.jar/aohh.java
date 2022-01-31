import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

public class aohh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoit jdField_a_of_type_Aoit;
  
  public aohh(ExtendFriendGroupFragment paramExtendFriendGroupFragment, View paramView, aoit paramaoit)
  {
    super(paramView);
    this.jdField_a_of_type_Aoit = paramaoit;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378502));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ExtendFriendGroupFragment.a(paramExtendFriendGroupFragment));
  }
  
  public void a(aohh paramaohh, int paramInt)
  {
    String str = "";
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramaohh.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramaohh.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      str = ajyc.a(2131704263);
      continue;
      str = ajyc.a(2131704247);
      bool = true;
      continue;
      str = ajyc.a(2131704245);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aoit != null) {
      this.jdField_a_of_type_Aoit.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohh
 * JD-Core Version:    0.7.0.1
 */