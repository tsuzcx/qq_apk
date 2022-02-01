import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class befi
  extends bedw
{
  protected int a;
  
  public befi(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, beex parambeex, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559250, null);
      parambeex = new befk(null);
      parambeex.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367743));
      parambeex.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367744));
      paramView.setTag(parambeex);
    }
    for (;;)
    {
      parambeex.jdField_a_of_type_AndroidWidgetTextView.setText(2131692821);
      parambeex.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840264);
      return paramView;
      parambeex = (befk)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befi
 * JD-Core Version:    0.7.0.1
 */