import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.util.ArrayList;

public class bkoi
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bkon> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bkoi(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bkon> paramArrayList)
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
    bkon localbkon = (bkon)getItem(paramInt);
    if (paramView == null)
    {
      bkoj localbkoj = new bkoj(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559000, paramViewGroup, false);
        localbkoj.b = ((ImageView)paramView.findViewById(2131368375));
        localbkoj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368320));
        localbkoj.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368319));
        paramView.setTag(localbkoj);
        paramViewGroup = localbkoj;
        label100:
        if (Build.VERSION.SDK_INT < 21) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbkon.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label224;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label202;
        }
        paramViewGroup.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localbkon.b != null) {
        paramView.setContentDescription(localbkon.b);
      }
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558999, paramViewGroup, false);
      break;
      paramViewGroup = (bkoj)paramView.getTag();
      break label100;
      label202:
      paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130844266));
      continue;
      label224:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        paramViewGroup.b.setVisibility(4);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkoi
 * JD-Core Version:    0.7.0.1
 */