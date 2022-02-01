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

public class bmpo
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bmpo(bmpj parambmpj, Context paramContext)
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
    return a().inflate(2131563056, null);
  }
  
  private void a(bmpp parambmpp, bmpq parambmpq)
  {
    parambmpp = URLDrawable.getDrawable(parambmpp.b, null);
    parambmpq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambmpp);
    parambmpq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambmpq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bmpj.a != null) {
      return this.jdField_a_of_type_Bmpj.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bmpj.a != null) {
      return this.jdField_a_of_type_Bmpj.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bmpj.a != null) {
      return this.jdField_a_of_type_Bmpj.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new bmpq(this.jdField_a_of_type_Bmpj);
      localView = a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370903));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370012));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365906);
      localView.setTag(paramView);
      if (paramView != null) {
        break label107;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (bmpq)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label107:
      if (getCount() <= 1)
      {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localView.setBackgroundResource(2130849295);
      }
      for (;;)
      {
        localObject = (bmpp)getItem(paramInt);
        if (localObject != null) {
          break label218;
        }
        break;
        if (paramInt <= 0)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849295);
        }
        else if (paramInt < getCount() - 1)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849294);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localView.setBackgroundResource(2130849293);
        }
      }
      label218:
      paramView.jdField_a_of_type_Bmpp = ((bmpp)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bmpp)localObject).a);
      if (TextUtils.isEmpty(((bmpp)localObject).b)) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      a((bmpp)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpo
 * JD-Core Version:    0.7.0.1
 */