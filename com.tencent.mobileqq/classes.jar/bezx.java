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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bezx
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  List<bfab<TroopInfo, Boolean>> jdField_a_of_type_JavaUtilList;
  
  public bezx(Activity paramActivity, List<TroopInfo> paramList, TroopInfo paramTroopInfo, List<String> paramList1)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramTroopInfo != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(new bfab(paramTroopInfo, Boolean.valueOf(true)));
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
            this.jdField_a_of_type_JavaUtilList.add(new bfab(paramList, Boolean.valueOf(bool)));
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
    bfab localbfab = (bfab)getItem(paramInt);
    bfaa localbfaa;
    Object localObject1;
    if (paramView != null)
    {
      localbfaa = (bfaa)paramView.getTag();
      paramView.setOnClickListener(null);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)localbfab.b).booleanValue());
      localObject1 = localbfaa.jdField_a_of_type_AndroidWidgetCheckBox;
      if (((TroopInfo)localbfab.a).troopuin.equals(this.jdField_a_of_type_JavaLangString)) {
        break label485;
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject1).setEnabled(bool);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bezy(this, localbfab));
      paramView.setOnClickListener(new bezz(this, localbfaa.jdField_a_of_type_AndroidWidgetCheckBox));
      localbfaa.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localbfab.a).troopname);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbfaa = new bfaa();
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramView.setMinimumHeight(bclx.a(48.0F));
      paramView.setOrientation(0);
      paramView.setGravity(16);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(this.jdField_a_of_type_AndroidAppActivity);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839088);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(bclx.a(12.0F), 0, 0, 0);
      localbfaa.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(bclx.a(12.0F), 0, bclx.a(12.0F), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(1);
      localbfaa.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      localbfaa.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localbfaa.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
      localbfaa.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      localbfaa.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
      ((LinearLayout)localObject1).addView(localbfaa.jdField_a_of_type_AndroidWidgetTextView);
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramView.addView(localbfaa.jdField_a_of_type_AndroidWidgetCheckBox);
      paramView.addView((View)localObject1);
      paramView.setClickable(true);
      paramView.setTag(localbfaa);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezx
 * JD-Core Version:    0.7.0.1
 */