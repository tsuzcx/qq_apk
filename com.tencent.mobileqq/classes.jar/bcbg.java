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

public class bcbg
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public bcfx a;
  public HorizontalListView a;
  public List<bcfy> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcbg.class.getSimpleName();
  }
  
  public bcbg(bcfx parambcfx, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Bcfx = parambcfx;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new bcbh(this, paramHorizontalListView));
  }
  
  public bcfy a(int paramInt)
  {
    return (bcfy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<bcfy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bcfy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bcfx.m)) {
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
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bcfx.m))) {
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
      localObject2 = (bcga)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      label86:
      float f;
      if (paramView == null)
      {
        localObject1 = new bcoh(paramViewGroup, 0);
        paramView = ((bcoh)localObject1).a();
        paramView.setTag(localObject1);
        f = this.jdField_a_of_type_Bcfx.jdField_a_of_type_Int;
        f = (float)(DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((bcga)localObject2).jdField_a_of_type_Bcft.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        ((bcoh)localObject1).a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((bcga)localObject2).a((bcof)localObject1);
        ((bcoh)localObject1).a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(((bcoh)localObject1).a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((bcga)localObject2).jdField_a_of_type_Long;
        break;
        localObject1 = (bcoh)paramView.getTag();
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
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559878, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131365119);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131371554);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371582);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839450);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130842385);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Bcfx.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new bcbi(this, paramViewGroup));
      paramView = (View)localObject1;
      break;
      paramView.setBackgroundResource(2130839449);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130842384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbg
 * JD-Core Version:    0.7.0.1
 */