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

public class bnxr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bnxr(bnxm parambnxm, Context paramContext)
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
    return a().inflate(2131563098, null);
  }
  
  private void a(bnxs parambnxs, bnxt parambnxt)
  {
    parambnxs = URLDrawable.getDrawable(parambnxs.b, null);
    parambnxt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(parambnxs);
    parambnxt.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    parambnxt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bnxm.a != null) {
      return this.jdField_a_of_type_Bnxm.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Bnxm.a != null) {
      return this.jdField_a_of_type_Bnxm.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_Bnxm.a != null) {
      return this.jdField_a_of_type_Bnxm.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new bnxt(this.jdField_a_of_type_Bnxm);
      localView = a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370750));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369851));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365776);
      localView.setTag(paramView);
      if (paramView != null) {
        break label107;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (bnxt)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label107:
      if (getCount() <= 1)
      {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localView.setBackgroundResource(2130849292);
      }
      for (;;)
      {
        localObject = (bnxs)getItem(paramInt);
        if (localObject != null) {
          break label218;
        }
        break;
        if (paramInt <= 0)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849292);
        }
        else if (paramInt < getCount() - 1)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849291);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localView.setBackgroundResource(2130849290);
        }
      }
      label218:
      paramView.jdField_a_of_type_Bnxs = ((bnxs)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bnxs)localObject).a);
      if (TextUtils.isEmpty(((bnxs)localObject).b)) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      a((bnxs)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxr
 * JD-Core Version:    0.7.0.1
 */