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

public class bcyz
  extends bcxn
{
  protected int a;
  
  public bcyz(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, bcyo parambcyo, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559257, null);
      parambcyo = new bczb(null);
      parambcyo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367775));
      parambcyo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367776));
      paramView.setTag(parambcyo);
    }
    for (;;)
    {
      parambcyo.jdField_a_of_type_AndroidWidgetTextView.setText(2131692872);
      parambcyo.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840302);
      return paramView;
      parambcyo = (bczb)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyz
 * JD-Core Version:    0.7.0.1
 */