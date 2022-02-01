import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class axit
  extends axip
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public RecyclerView a;
  public View a;
  public TextView a;
  public CircleImageView a;
  public TextView b;
  
  public axit(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363145));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379724));
    this.b = ((TextView)paramView.findViewById(2131379622));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131366958));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370119);
    int i = -1;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298813);
    }
    if (i > 0) {}
    for (;;)
    {
      axks localaxks = new axks(i);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localaxks);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new axiu(this));
      if ((paramView.getContext() instanceof Activity))
      {
        paramView = (Activity)paramView.getContext();
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new axiy(paramView, new axiv(this, paramView)));
      }
      return;
      i = 25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axit
 * JD-Core Version:    0.7.0.1
 */