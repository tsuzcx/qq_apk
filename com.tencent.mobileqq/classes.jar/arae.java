import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpic.HotPicTab;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class arae
  extends BaseAdapter
{
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  public List<HotPicTagInfo> a;
  boolean jdField_a_of_type_Boolean;
  
  public arae(List<HotPicTagInfo> paramList, ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBoolean.clone());
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new arag(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab);
      paramView = LayoutInflater.from(HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab)).inflate(2131558556, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131367629));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = ((HotPicTagInfo)getItem(paramInt)).tagName;
      paramViewGroup = paramViewGroup.a;
      paramViewGroup.setText(str);
      paramViewGroup.setTextSize(2, HotPicTab.b());
      paramViewGroup.setTextColor(HotPicTab.c());
      paramViewGroup.setPadding(0, 0, 0, 0);
      paramViewGroup.setFocusable(true);
      paramViewGroup.setGravity(17);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue(), -1));
      paramView.setContentDescription(str);
      paramView.setFocusable(true);
      paramView.setOnHoverListener(new araf(this));
      if (!HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).contains(Integer.valueOf(paramInt)))
      {
        axqy.b(null, "dc00898", "", "", "0X8008077", "0X8008077", 0, 0, paramInt + "", "", str, "");
        HotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab).add(Integer.valueOf(paramInt));
      }
      return paramView;
      paramViewGroup = (arag)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arae
 * JD-Core Version:    0.7.0.1
 */