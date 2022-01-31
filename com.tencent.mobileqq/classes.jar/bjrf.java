import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bjrf
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<tbq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bjrf(List<tbq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    tbq localtbq = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131376954);
    ImageView localImageView = (ImageView)paramView.findViewById(2131376944);
    View localView = paramView.findViewById(2131376952);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131376949);
    localTextView.setText(localtbq.b);
    if (this.b == 0) {
      this.b = vzo.a(paramView.getContext(), 60.0F);
    }
    vzo.a(localImageView, localtbq.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130845847), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(ajyc.a(2131714879) + localtbq.b + "’");
    }
    for (;;)
    {
      if (localtbq.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(ajyc.a(2131714880) + localtbq.b + ajyc.a(2131714878));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public tbq a(int paramInt)
  {
    return (tbq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560570, paramViewGroup, false);
      localView.setFocusable(true);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrf
 * JD-Core Version:    0.7.0.1
 */