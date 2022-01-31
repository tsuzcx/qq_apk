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

public class biav
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public biav(biaq parambiaq, Context paramContext)
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
    return a().inflate(2131562604, null);
  }
  
  private void a(biaw parambiaw, biax parambiax)
  {
    parambiaw = URLDrawable.getDrawable(parambiaw.b, null);
    parambiax.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambiaw);
    parambiax.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambiax.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Biaq.a != null) {
      return this.jdField_a_of_type_Biaq.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Biaq.a != null) {
      return this.jdField_a_of_type_Biaq.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Biaq.a != null) {
      return this.jdField_a_of_type_Biaq.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new biax(this.jdField_a_of_type_Biaq);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369922));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369113));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365412);
      paramView.setTag(paramViewGroup);
    }
    while (paramViewGroup == null)
    {
      return paramView;
      paramViewGroup = (biax)paramView.getTag();
    }
    if (getCount() <= 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.setBackgroundResource(2130848309);
    }
    biaw localbiaw;
    for (;;)
    {
      localbiaw = (biaw)getItem(paramInt);
      if (localbiaw != null) {
        break;
      }
      return paramView;
      if (paramInt <= 0)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848309);
      }
      else if (paramInt < getCount() - 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848308);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130848307);
      }
    }
    paramViewGroup.jdField_a_of_type_Biaw = localbiaw;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbiaw.a);
    if (TextUtils.isEmpty(localbiaw.b)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(localbiaw, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biav
 * JD-Core Version:    0.7.0.1
 */