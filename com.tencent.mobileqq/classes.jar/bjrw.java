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

public class bjrw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<tbn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bjrw(List<tbn> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    tbn localtbn = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131376956);
    ImageView localImageView = (ImageView)paramView.findViewById(2131376946);
    View localView = paramView.findViewById(2131376954);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131376951);
    localTextView.setText(localtbn.b);
    if (this.b == 0) {
      this.b = vzl.a(paramView.getContext(), 60.0F);
    }
    vzl.a(localImageView, localtbn.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130845853), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(ajya.a(2131714890) + localtbn.b + "’");
    }
    for (;;)
    {
      if (localtbn.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(ajya.a(2131714891) + localtbn.b + ajya.a(2131714889));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public tbn a(int paramInt)
  {
    return (tbn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560569, paramViewGroup, false);
      localView.setFocusable(true);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrw
 * JD-Core Version:    0.7.0.1
 */