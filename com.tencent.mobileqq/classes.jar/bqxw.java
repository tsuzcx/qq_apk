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

public class bqxw
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bqyb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bqxw(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bqyb> paramArrayList)
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
    bqyb localbqyb = (bqyb)getItem(paramInt);
    bqxx localbqxx;
    if (paramView == null)
    {
      localbqxx = new bqxx(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559105, paramViewGroup, false);
        localbqxx.b = ((ImageView)paramView.findViewById(2131368985));
        localbqxx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368859));
        localbqxx.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368858));
        paramView.setTag(localbqxx);
        label97:
        if (Build.VERSION.SDK_INT < 21) {
          localbqxx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localbqxx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbqyb.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label240;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label217;
        }
        localbqxx.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localbqyb.b != null) {
        paramView.setContentDescription(localbqyb.b);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559104, paramViewGroup, false);
      break;
      localbqxx = (bqxx)paramView.getTag();
      break label97;
      label217:
      localbqxx.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130845091));
      continue;
      label240:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        localbqxx.b.setVisibility(4);
      } else {
        localbqxx.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxw
 * JD-Core Version:    0.7.0.1
 */