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

public class bnsa
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bnsf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bnsa(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bnsf> paramArrayList)
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
    bnsf localbnsf = (bnsf)getItem(paramInt);
    bnsb localbnsb;
    if (paramView == null)
    {
      localbnsb = new bnsb(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559113, paramViewGroup, false);
        localbnsb.b = ((ImageView)paramView.findViewById(2131369011));
        localbnsb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368884));
        localbnsb.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368883));
        paramView.setTag(localbnsb);
        label97:
        if (Build.VERSION.SDK_INT < 21) {
          localbnsb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localbnsb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbnsf.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label240;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label217;
        }
        localbnsb.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localbnsf.b != null) {
        paramView.setContentDescription(localbnsf.b);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559112, paramViewGroup, false);
      break;
      localbnsb = (bnsb)paramView.getTag();
      break label97;
      label217:
      localbnsb.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130844972));
      continue;
      label240:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        localbnsb.b.setVisibility(4);
      } else {
        localbnsb.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsa
 * JD-Core Version:    0.7.0.1
 */