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

public class avkn
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public avpb a;
  public HorizontalListView a;
  public List<avpc> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = avkn.class.getSimpleName();
  }
  
  public avkn(avpb paramavpb, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Avpb = paramavpb;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new avko(this, paramHorizontalListView));
  }
  
  public avpc a(int paramInt)
  {
    return (avpc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<avpc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<avpc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Avpb.m)) {
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
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Avpb.m))) {
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
      localObject1 = (avpe)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      float f;
      if (paramView == null)
      {
        paramViewGroup = new avxk(paramViewGroup, 0);
        paramView = paramViewGroup.a();
        paramView.setTag(paramViewGroup);
        f = this.jdField_a_of_type_Avpb.jdField_a_of_type_Int;
        f = (float)(babp.k() - azvv.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (azvv.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((avpe)localObject1).jdField_a_of_type_Avox.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        paramViewGroup.a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((avpe)localObject1).a(paramViewGroup);
        paramViewGroup.a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(paramViewGroup.a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((avpe)localObject1).jdField_a_of_type_Long;
        return paramView;
        paramViewGroup = (avxk)paramView.getTag();
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
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494066, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = azvv.a(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131299097);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131304757);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131304778);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839096);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130841733);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Avpb.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new avkp(this, paramViewGroup));
      return localObject1;
      paramView.setBackgroundResource(2130839095);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130841732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkn
 * JD-Core Version:    0.7.0.1
 */