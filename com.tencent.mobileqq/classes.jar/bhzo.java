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

public class bhzo
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<sou> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bhzo(List<sou> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    sou localsou = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131311144);
    ImageView localImageView = (ImageView)paramView.findViewById(2131311134);
    View localView = paramView.findViewById(2131311142);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131311139);
    localTextView.setText(localsou.b);
    if (this.b == 0) {
      this.b = vms.a(paramView.getContext(), 60.0F);
    }
    vms.a(localImageView, localsou.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130845665), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(ajjy.a(2131649090) + localsou.b + "’");
    }
    for (;;)
    {
      if (localsou.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(ajjy.a(2131649091) + localsou.b + ajjy.a(2131649089));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public sou a(int paramInt)
  {
    return (sou)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494996, paramViewGroup, false);
      localView.setFocusable(true);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhzo
 * JD-Core Version:    0.7.0.1
 */