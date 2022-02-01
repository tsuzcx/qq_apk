import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bmwj
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bmwj(bmwe parambmwe, Context paramContext)
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
    return a().inflate(2131563063, null);
  }
  
  private void a(bmwk parambmwk, bmwl parambmwl)
  {
    parambmwk = URLDrawable.getDrawable(parambmwk.b, null);
    parambmwl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambmwk);
    parambmwl.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambmwl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bmwe.a != null) {
      return this.jdField_a_of_type_Bmwe.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bmwe.a != null) {
      return this.jdField_a_of_type_Bmwe.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bmwe.a != null) {
      return this.jdField_a_of_type_Bmwe.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new bmwl(this.jdField_a_of_type_Bmwe);
      localView = a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370646));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369754));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365733);
      localView.setTag(paramView);
      if (paramView != null) {
        break label107;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (bmwl)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label107:
      if (getCount() <= 1)
      {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localView.setBackgroundResource(2130849273);
      }
      for (;;)
      {
        localObject = (bmwk)getItem(paramInt);
        if (localObject != null) {
          break label218;
        }
        break;
        if (paramInt <= 0)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849273);
        }
        else if (paramInt < getCount() - 1)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849272);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localView.setBackgroundResource(2130849271);
        }
      }
      label218:
      paramView.jdField_a_of_type_Bmwk = ((bmwk)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bmwk)localObject).a);
      if (TextUtils.isEmpty(((bmwk)localObject).b)) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      a((bmwk)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwj
 * JD-Core Version:    0.7.0.1
 */