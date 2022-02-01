import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class aycs
  extends ayco
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public RecyclerView a;
  public View a;
  public TextView a;
  public CircleImageView a;
  public TextView b;
  
  public aycs(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363107));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379779));
    this.b = ((TextView)paramView.findViewById(2131379669));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131366886));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370021);
    int i = -1;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298735);
    }
    if (i > 0) {}
    for (;;)
    {
      ayer localayer = new ayer(i);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localayer);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ayct(this));
      if ((paramView.getContext() instanceof Activity))
      {
        paramView = (Activity)paramView.getContext();
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new aycx(paramView, new aycu(this, paramView)));
      }
      return;
      i = 25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycs
 * JD-Core Version:    0.7.0.1
 */