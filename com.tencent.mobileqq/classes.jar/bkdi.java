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

public class bkdi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bkdi(bkdd parambkdd, Context paramContext)
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
    return a().inflate(2131562808, null);
  }
  
  private void a(bkdj parambkdj, bkdk parambkdk)
  {
    parambkdj = URLDrawable.getDrawable(parambkdj.b, null);
    parambkdk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambkdj);
    parambkdk.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambkdk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bkdd.a != null) {
      return this.jdField_a_of_type_Bkdd.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bkdd.a != null) {
      return this.jdField_a_of_type_Bkdd.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bkdd.a != null) {
      return this.jdField_a_of_type_Bkdd.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bkdk(this.jdField_a_of_type_Bkdd);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370186));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369345));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365495);
      paramView.setTag(paramViewGroup);
    }
    while (paramViewGroup == null)
    {
      return paramView;
      paramViewGroup = (bkdk)paramView.getTag();
    }
    if (getCount() <= 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.setBackgroundResource(2130848722);
    }
    bkdj localbkdj;
    for (;;)
    {
      localbkdj = (bkdj)getItem(paramInt);
      if (localbkdj != null) {
        break;
      }
      return paramView;
      if (paramInt <= 0)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848722);
      }
      else if (paramInt < getCount() - 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130848721);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130848720);
      }
    }
    paramViewGroup.jdField_a_of_type_Bkdj = localbkdj;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbkdj.a);
    if (TextUtils.isEmpty(localbkdj.b)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(localbkdj, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdi
 * JD-Core Version:    0.7.0.1
 */