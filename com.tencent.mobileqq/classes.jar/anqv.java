import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

public class anqv
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansh jdField_a_of_type_Ansh;
  
  public anqv(ExtendFriendGroupFragment paramExtendFriendGroupFragment, View paramView, ansh paramansh)
  {
    super(paramView);
    this.jdField_a_of_type_Ansh = paramansh;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312678));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ExtendFriendGroupFragment.a(paramExtendFriendGroupFragment));
  }
  
  public void a(anqv paramanqv, int paramInt)
  {
    String str = "";
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramanqv.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramanqv.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      str = ajjy.a(2131638478);
      continue;
      str = ajjy.a(2131638462);
      bool = true;
      continue;
      str = ajjy.a(2131638460);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ansh != null) {
      this.jdField_a_of_type_Ansh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anqv
 * JD-Core Version:    0.7.0.1
 */