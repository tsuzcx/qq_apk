import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfqc
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  List<bfqg<TroopInfo, Boolean>> jdField_a_of_type_JavaUtilList;
  
  public bfqc(Activity paramActivity, List<TroopInfo> paramList, TroopInfo paramTroopInfo, List<String> paramList1)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramTroopInfo != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(new bfqg(paramTroopInfo, Boolean.valueOf(true)));
      this.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
    }
    if (paramList != null)
    {
      paramActivity = paramList.iterator();
      while (paramActivity.hasNext())
      {
        paramList = (TroopInfo)paramActivity.next();
        if (paramList != null)
        {
          if ((paramList1 != null) && (paramList1.contains(paramList.troopuin))) {}
          for (boolean bool = true;; bool = false)
          {
            this.jdField_a_of_type_JavaUtilList.add(new bfqg(paramList, Boolean.valueOf(bool)));
            break;
          }
        }
      }
    }
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
    bfqg localbfqg = (bfqg)getItem(paramInt);
    bfqf localbfqf;
    Object localObject1;
    if (paramView != null)
    {
      localbfqf = (bfqf)paramView.getTag();
      paramView.setOnClickListener(null);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)localbfqg.b).booleanValue());
      localObject1 = localbfqf.jdField_a_of_type_AndroidWidgetCheckBox;
      if (((TroopInfo)localbfqg.a).troopuin.equals(this.jdField_a_of_type_JavaLangString)) {
        break label485;
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject1).setEnabled(bool);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bfqd(this, localbfqg));
      paramView.setOnClickListener(new bfqe(this, localbfqf.jdField_a_of_type_AndroidWidgetCheckBox));
      localbfqf.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localbfqg.a).troopname);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbfqf = new bfqf();
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramView.setMinimumHeight(ScreenUtil.dip2px(48.0F));
      paramView.setOrientation(0);
      paramView.setGravity(16);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(this.jdField_a_of_type_AndroidAppActivity);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839151);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(ScreenUtil.dip2px(12.0F), 0, 0, 0);
      localbfqf.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(ScreenUtil.dip2px(12.0F), 0, ScreenUtil.dip2px(12.0F), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(1);
      localbfqf.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      localbfqf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localbfqf.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
      localbfqf.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      localbfqf.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
      ((LinearLayout)localObject1).addView(localbfqf.jdField_a_of_type_AndroidWidgetTextView);
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramView.addView(localbfqf.jdField_a_of_type_AndroidWidgetCheckBox);
      paramView.addView((View)localObject1);
      paramView.setClickable(true);
      paramView.setTag(localbfqf);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqc
 * JD-Core Version:    0.7.0.1
 */