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

public class ayjr
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public ayoi a;
  public HorizontalListView a;
  public List<ayoj> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ayjr.class.getSimpleName();
  }
  
  public ayjr(ayoi paramayoi, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Ayoi = paramayoi;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new ayjs(this, paramHorizontalListView));
  }
  
  public ayoj a(int paramInt)
  {
    return (ayoj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<ayoj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<ayoj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ayoi.m)) {
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
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoi.m))) {
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
      localObject1 = (ayol)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      float f;
      if (paramView == null)
      {
        paramViewGroup = new aywr(paramViewGroup, 0);
        paramView = paramViewGroup.a();
        paramView.setTag(paramViewGroup);
        f = this.jdField_a_of_type_Ayoi.jdField_a_of_type_Int;
        f = (float)(bdgk.k() - bdaq.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (bdaq.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((ayol)localObject1).jdField_a_of_type_Ayoe.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        paramViewGroup.a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((ayol)localObject1).a(paramViewGroup);
        paramViewGroup.a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(paramViewGroup.a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((ayol)localObject1).jdField_a_of_type_Long;
        return paramView;
        paramViewGroup = (aywr)paramView.getTag();
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
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559689, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = bdaq.a(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131364736);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131370738);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131370763);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839209);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130841992);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Ayoi.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new ayjt(this, paramViewGroup));
      return localObject1;
      paramView.setBackgroundResource(2130839208);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130841991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjr
 * JD-Core Version:    0.7.0.1
 */