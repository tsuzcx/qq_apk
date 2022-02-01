import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class bauq
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public bazh a;
  public HorizontalListView a;
  public List<bazi> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bauq.class.getSimpleName();
  }
  
  public bauq(bazh parambazh, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Bazh = parambazh;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new baur(this, paramHorizontalListView));
  }
  
  public bazi a(int paramInt)
  {
    return (bazi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<bazi> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bazi> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bazh.m)) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bazh.m))) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    case 1: 
      localObject2 = (bazk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      label86:
      float f;
      if (paramView == null)
      {
        localObject1 = new bbhp(paramViewGroup, 0);
        paramView = ((bbhp)localObject1).a();
        paramView.setTag(localObject1);
        f = this.jdField_a_of_type_Bazh.jdField_a_of_type_Int;
        f = (float)(DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((bazk)localObject2).jdField_a_of_type_Bazd.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        ((bbhp)localObject1).a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((bazk)localObject2).a((bbhn)localObject1);
        ((bbhp)localObject1).a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(((bbhp)localObject1).a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((bazk)localObject2).jdField_a_of_type_Long;
        break;
        localObject1 = (bbhp)paramView.getTag();
        break label86;
        this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        continue;
        this.jdField_b_of_type_Float = f;
        continue;
        this.jdField_b_of_type_Float = (228.0F * f / 162.0F);
        continue;
        this.jdField_b_of_type_Float = f;
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559834, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131365035);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131371369);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371397);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839429);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130842355);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Bazh.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new baus(this, paramViewGroup));
      paramView = (View)localObject1;
      break;
      paramView.setBackgroundResource(2130839428);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130842354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauq
 * JD-Core Version:    0.7.0.1
 */