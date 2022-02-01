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

public class blcx
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public blcx(blcs paramblcs, Context paramContext)
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
    return a().inflate(2131562980, null);
  }
  
  private void a(blcy paramblcy, blcz paramblcz)
  {
    paramblcy = URLDrawable.getDrawable(paramblcy.b, null);
    paramblcz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramblcy);
    paramblcz.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramblcz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Blcs.a != null) {
      return this.jdField_a_of_type_Blcs.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Blcs.a != null) {
      return this.jdField_a_of_type_Blcs.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Blcs.a != null) {
      return this.jdField_a_of_type_Blcs.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new blcz(this.jdField_a_of_type_Blcs);
      localView = a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370718));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369842));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365808);
      localView.setTag(paramView);
      if (paramView != null) {
        break label107;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (blcz)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label107:
      if (getCount() <= 1)
      {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localView.setBackgroundResource(2130849203);
      }
      for (;;)
      {
        localObject = (blcy)getItem(paramInt);
        if (localObject != null) {
          break label218;
        }
        break;
        if (paramInt <= 0)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849203);
        }
        else if (paramInt < getCount() - 1)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849202);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localView.setBackgroundResource(2130849201);
        }
      }
      label218:
      paramView.jdField_a_of_type_Blcy = ((blcy)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((blcy)localObject).a);
      if (TextUtils.isEmpty(((blcy)localObject).b)) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      a((blcy)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcx
 * JD-Core Version:    0.7.0.1
 */