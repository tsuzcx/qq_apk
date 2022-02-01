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

public class bphs
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bphx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bphs(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bphx> paramArrayList)
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
    bphx localbphx = (bphx)getItem(paramInt);
    bpht localbpht;
    if (paramView == null)
    {
      localbpht = new bpht(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559141, paramViewGroup, false);
        localbpht.b = ((ImageView)paramView.findViewById(2131369173));
        localbpht.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369042));
        localbpht.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369041));
        paramView.setTag(localbpht);
        label97:
        if (Build.VERSION.SDK_INT < 21) {
          localbpht.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localbpht.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbphx.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label240;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label217;
        }
        localbpht.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localbphx.b != null) {
        paramView.setContentDescription(localbphx.b);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559140, paramViewGroup, false);
      break;
      localbpht = (bpht)paramView.getTag();
      break label97;
      label217:
      localbpht.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130845046));
      continue;
      label240:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        localbpht.b.setVisibility(4);
      } else {
        localbpht.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphs
 * JD-Core Version:    0.7.0.1
 */