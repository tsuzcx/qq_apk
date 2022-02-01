import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bqat
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<wrv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public bqat(List<wrv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(int paramInt, View paramView)
  {
    wrv localwrv = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131378525);
    ImageView localImageView = (ImageView)paramView.findViewById(2131378515);
    View localView = paramView.findViewById(2131378523);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131378520);
    localTextView.setText(localwrv.b);
    if (this.b == 0) {
      this.b = zps.a(paramView.getContext(), 60.0F);
    }
    zps.a(localImageView, localwrv.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130846761), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(anzj.a(2131713682) + localwrv.b + "’");
    }
    for (;;)
    {
      if (localwrv.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(anzj.a(2131713683) + localwrv.b + anzj.a(2131713681));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public wrv a(int paramInt)
  {
    return (wrv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560998, paramViewGroup, false);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqat
 * JD-Core Version:    0.7.0.1
 */