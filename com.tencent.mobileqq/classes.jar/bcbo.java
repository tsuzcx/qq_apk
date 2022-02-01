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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class bcbo
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public bcgf a;
  public HorizontalListView a;
  public List<bcgg> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcbo.class.getSimpleName();
  }
  
  public bcbo(bcgf parambcgf, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_Bcgf = parambcgf;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new bcbp(this, paramHorizontalListView));
  }
  
  public bcgg a(int paramInt)
  {
    return (bcgg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<bcgg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bcgg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bcgf.m)) {
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
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bcgf.m))) {
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
      localObject2 = (bcgi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      label86:
      float f;
      if (paramView == null)
      {
        localObject1 = new bcon(paramViewGroup, 0);
        paramView = ((bcon)localObject1).a();
        paramView.setTag(localObject1);
        f = this.jdField_a_of_type_Bcgf.jdField_a_of_type_Int;
        f = (float)(bhlo.k() - bhgr.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.jdField_a_of_type_Float = (bhgr.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((bcgi)localObject2).jdField_a_of_type_Bcgb.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        ((bcon)localObject1).a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((bcgi)localObject2).a((bcol)localObject1);
        ((bcon)localObject1).a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(((bcon)localObject1).a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((bcgi)localObject2).jdField_a_of_type_Long;
        break;
        localObject1 = (bcon)paramView.getTag();
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
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559832, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = bhgr.a(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131365008);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131371401);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371429);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839394);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130842313);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_Bcgf.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new bcbq(this, paramViewGroup));
      paramView = (View)localObject1;
      break;
      paramView.setBackgroundResource(2130839393);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130842312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbo
 * JD-Core Version:    0.7.0.1
 */