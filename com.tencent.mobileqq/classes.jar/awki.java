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
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class awki
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public awow a;
  public HorizontalListView a;
  public List<awox> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = awki.class.getSimpleName();
  }
  
  public awki(awow paramawow, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Awow = paramawow;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new awkj(this, paramHorizontalListView));
  }
  
  public awox a(int paramInt)
  {
    return (awox)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<awox> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<awox> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Awow.m)) {
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
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awow.m))) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 1: 
      localObject1 = (awoz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      float f;
      if (paramView == null)
      {
        paramViewGroup = new awxf(paramViewGroup, 0);
        paramView = paramViewGroup.a();
        paramView.setTag(paramViewGroup);
        f = this.jdField_a_of_type_Awow.jdField_a_of_type_Int;
        f = (float)(bbdh.k() - baxn.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (baxn.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((awoz)localObject1).jdField_a_of_type_Awos.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        paramViewGroup.a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((awoz)localObject1).a(paramViewGroup);
        paramViewGroup.a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(paramViewGroup.a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((awoz)localObject1).jdField_a_of_type_Long;
        return paramView;
        paramViewGroup = (awxf)paramView.getTag();
        break;
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
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559638, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = baxn.a(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131364656);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131370413);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131370438);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839124);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130841827);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Awow.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new awkk(this, paramViewGroup));
      return localObject1;
      paramView.setBackgroundResource(2130839123);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130841826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awki
 * JD-Core Version:    0.7.0.1
 */