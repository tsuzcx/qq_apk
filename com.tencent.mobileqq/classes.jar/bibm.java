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

public class bibm
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bibm(bibh parambibh, Context paramContext)
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
    return a().inflate(2131562603, null);
  }
  
  private void a(bibn parambibn, bibo parambibo)
  {
    parambibn = URLDrawable.getDrawable(parambibn.b, null);
    parambibo.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambibn);
    parambibo.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambibo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bibh.a != null) {
      return this.jdField_a_of_type_Bibh.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bibh.a != null) {
      return this.jdField_a_of_type_Bibh.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bibh.a != null) {
      return this.jdField_a_of_type_Bibh.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bibo(this.jdField_a_of_type_Bibh);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369921));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369113));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365411);
      paramView.setTag(paramViewGroup);
    }
    while (paramViewGroup == null)
    {
      return paramView;
      paramViewGroup = (bibo)paramView.getTag();
    }
    if (getCount() <= 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.setBackgroundResource(2130848315);
    }
    bibn localbibn;
    for (;;)
    {
      localbibn = (bibn)getItem(paramInt);
      if (localbibn != null) {
        break;
      }
      return paramView;
      if (paramInt <= 0)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848315);
      }
      else if (paramInt < getCount() - 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848314);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130848313);
      }
    }
    paramViewGroup.jdField_a_of_type_Bibn = localbibn;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbibn.a);
    if (TextUtils.isEmpty(localbibn.b)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(localbibn, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibm
 * JD-Core Version:    0.7.0.1
 */