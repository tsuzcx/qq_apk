import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;

public class bkhp
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bkhp(bkhk parambkhk, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private LayoutInflater a()
  {
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  private View a()
  {
    return a().inflate(2131562826, null);
  }
  
  private void a(bkhq parambkhq, bkhr parambkhr)
  {
    parambkhq = URLDrawable.getDrawable(parambkhq.b, null);
    parambkhr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambkhq);
    parambkhr.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambkhr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bkhk.a != null) {
      return this.jdField_a_of_type_Bkhk.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bkhk.a != null) {
      return this.jdField_a_of_type_Bkhk.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bkhk.a != null) {
      return this.jdField_a_of_type_Bkhk.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bkhr(this.jdField_a_of_type_Bkhk);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370205));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369363));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365497);
      paramView.setTag(paramViewGroup);
    }
    while (paramViewGroup == null)
    {
      return paramView;
      paramViewGroup = (bkhr)paramView.getTag();
    }
    if (getCount() <= 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.setBackgroundResource(2130848795);
    }
    bkhq localbkhq;
    for (;;)
    {
      localbkhq = (bkhq)getItem(paramInt);
      if (localbkhq != null) {
        break;
      }
      return paramView;
      if (paramInt <= 0)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848795);
      }
      else if (paramInt < getCount() - 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848794);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130848793);
      }
    }
    paramViewGroup.jdField_a_of_type_Bkhq = localbkhq;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbkhq.a);
    if (TextUtils.isEmpty(localbkhq.b)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(localbkhq, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhp
 * JD-Core Version:    0.7.0.1
 */