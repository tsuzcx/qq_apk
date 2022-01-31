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

public class bmhs
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<uuo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bmhs(List<uuo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    uuo localuuo = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131377530);
    ImageView localImageView = (ImageView)paramView.findViewById(2131377520);
    View localView = paramView.findViewById(2131377528);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131377525);
    localTextView.setText(localuuo.b);
    if (this.b == 0) {
      this.b = xsm.a(paramView.getContext(), 60.0F);
    }
    xsm.a(localImageView, localuuo.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130846305), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(alud.a(2131715274) + localuuo.b + "’");
    }
    for (;;)
    {
      if (localuuo.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(alud.a(2131715275) + localuuo.b + alud.a(2131715273));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public uuo a(int paramInt)
  {
    return (uuo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560763, paramViewGroup, false);
      localView.setFocusable(true);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhs
 * JD-Core Version:    0.7.0.1
 */