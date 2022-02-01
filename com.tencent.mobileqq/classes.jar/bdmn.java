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

public class bdmn
  extends bdlb
{
  protected int a;
  
  public bdmn(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, bdmc parambdmc, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559250, null);
      parambdmc = new bdmp(null);
      parambdmc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367674));
      parambdmc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367675));
      paramView.setTag(parambdmc);
    }
    for (;;)
    {
      parambdmc.jdField_a_of_type_AndroidWidgetTextView.setText(2131692813);
      parambdmc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840254);
      return paramView;
      parambdmc = (bdmp)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmn
 * JD-Core Version:    0.7.0.1
 */