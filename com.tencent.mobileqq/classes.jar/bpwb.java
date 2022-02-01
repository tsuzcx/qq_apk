import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.util.ArrayList;

public class bpwb
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bpwg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bpwb(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bpwg> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bpwg localbpwg = (bpwg)getItem(paramInt);
    bpwc localbpwc;
    if (paramView == null)
    {
      localbpwc = new bpwc(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559105, paramViewGroup, false);
        localbpwc.b = ((ImageView)paramView.findViewById(2131368892));
        localbpwc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368785));
        localbpwc.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368784));
        paramView.setTag(localbpwc);
        label97:
        if (Build.VERSION.SDK_INT < 21) {
          localbpwc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localbpwc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbpwg.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label240;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label217;
        }
        localbpwc.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localbpwg.b != null) {
        paramView.setContentDescription(localbpwg.b);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559104, paramViewGroup, false);
      break;
      localbpwc = (bpwc)paramView.getTag();
      break label97;
      label217:
      localbpwc.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130845076));
      continue;
      label240:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        localbpwc.b.setVisibility(4);
      } else {
        localbpwc.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwb
 * JD-Core Version:    0.7.0.1
 */