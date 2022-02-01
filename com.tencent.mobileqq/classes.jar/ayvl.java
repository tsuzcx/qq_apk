import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class ayvl
  extends ayvh
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public RecyclerView a;
  public View a;
  public TextView a;
  public CircleImageView a;
  public TextView b;
  
  public ayvl(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363128));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379958));
    this.b = ((TextView)paramView.findViewById(2131379844));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131366937));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370123);
    int i = -1;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298748);
    }
    if (i > 0) {}
    for (;;)
    {
      ayxk localayxk = new ayxk(i);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localayxk);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ayvm(this));
      if ((paramView.getContext() instanceof Activity))
      {
        paramView = (Activity)paramView.getContext();
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new ayvq(paramView, new ayvn(this, paramView)));
      }
      return;
      i = 25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvl
 * JD-Core Version:    0.7.0.1
 */