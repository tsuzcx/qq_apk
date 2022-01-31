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

public class bnaj
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<bnao> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bnaj(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<bnao> paramArrayList)
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
    bnao localbnao = (bnao)getItem(paramInt);
    if (paramView == null)
    {
      bnak localbnak = new bnak(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559039, paramViewGroup, false);
        localbnak.b = ((ImageView)paramView.findViewById(2131368558));
        localbnak.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368466));
        localbnak.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368465));
        paramView.setTag(localbnak);
        paramViewGroup = localbnak;
        label100:
        if (Build.VERSION.SDK_INT < 21) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbnao.a);
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
      if (localbnao.b != null) {
        paramView.setContentDescription(localbnao.b);
      }
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559038, paramViewGroup, false);
      break;
      paramViewGroup = (bnak)paramView.getTag();
      break label100;
      label202:
      paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130844610));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnaj
 * JD-Core Version:    0.7.0.1
 */