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

public class bgrw
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bgrw(bgrr parambgrr, Context paramContext)
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
    return a().inflate(2131497007, null);
  }
  
  private void a(bgrx parambgrx, bgry parambgry)
  {
    parambgrx = URLDrawable.getDrawable(parambgrx.b, null);
    parambgry.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambgrx);
    parambgry.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambgry.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bgrr.a != null) {
      return this.jdField_a_of_type_Bgrr.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bgrr.a != null) {
      return this.jdField_a_of_type_Bgrr.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bgrr.a != null) {
      return this.jdField_a_of_type_Bgrr.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bgry(this.jdField_a_of_type_Bgrr);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304242));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303445));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299832);
      paramView.setTag(paramViewGroup);
    }
    while (paramViewGroup == null)
    {
      return paramView;
      paramViewGroup = (bgry)paramView.getTag();
    }
    if (getCount() <= 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.setBackgroundResource(2130848079);
    }
    bgrx localbgrx;
    for (;;)
    {
      localbgrx = (bgrx)getItem(paramInt);
      if (localbgrx != null) {
        break;
      }
      return paramView;
      if (paramInt <= 0)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848079);
      }
      else if (paramInt < getCount() - 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848078);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130848077);
      }
    }
    paramViewGroup.jdField_a_of_type_Bgrx = localbgrx;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbgrx.a);
    if (TextUtils.isEmpty(localbgrx.b)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(localbgrx, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrw
 * JD-Core Version:    0.7.0.1
 */