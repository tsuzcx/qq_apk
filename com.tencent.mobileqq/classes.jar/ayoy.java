import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class ayoy
  extends ayou
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public RecyclerView a;
  public View a;
  public TextView a;
  public CircleImageView a;
  public TextView b;
  
  public ayoy(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131363164));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380038));
    this.b = ((TextView)paramView.findViewById(2131379934));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131367076));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370292);
    int i = -1;
    if (paramView.getContext() != null) {
      i = paramView.getContext().getResources().getDimensionPixelSize(2131298817);
    }
    if (i > 0) {}
    for (;;)
    {
      ayqx localayqx = new ayqx(i);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(localayqx);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ayoz(this));
      if ((paramView.getContext() instanceof Activity))
      {
        paramView = (Activity)paramView.getContext();
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(new aypd(paramView, new aypa(this, paramView)));
      }
      return;
      i = 25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoy
 * JD-Core Version:    0.7.0.1
 */