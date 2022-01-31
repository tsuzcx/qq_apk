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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azwu
  extends BaseAdapter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  List<azwy<TroopInfo, Boolean>> jdField_a_of_type_JavaUtilList;
  
  public azwu(Activity paramActivity, List<TroopInfo> paramList, TroopInfo paramTroopInfo, List<String> paramList1)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramTroopInfo != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(new azwy(paramTroopInfo, Boolean.valueOf(true)));
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
            this.jdField_a_of_type_JavaUtilList.add(new azwy(paramList, Boolean.valueOf(bool)));
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
    azwy localazwy = (azwy)getItem(paramInt);
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = (azwx)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.setOnClickListener(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)localazwy.b).booleanValue());
      localObject1 = paramView.jdField_a_of_type_AndroidWidgetCheckBox;
      if (((TroopInfo)localazwy.a).troopuin.equals(this.jdField_a_of_type_JavaLangString)) {
        break label458;
      }
    }
    label458:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject1).setEnabled(bool);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new azwv(this, localazwy));
      paramViewGroup.setOnClickListener(new azww(this, paramView.jdField_a_of_type_AndroidWidgetCheckBox));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localazwy.a).troopname);
      return paramViewGroup;
      paramView = new azwx();
      paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setMinimumHeight(axlk.a(48.0F));
      paramViewGroup.setOrientation(0);
      paramViewGroup.setGravity(16);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(this.jdField_a_of_type_AndroidAppActivity);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838759);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(axlk.a(12.0F), 0, 0, 0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(axlk.a(12.0F), 0, axlk.a(12.0F), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(1);
      paramView.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
      ((LinearLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidWidgetTextView);
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramViewGroup.addView(paramView.jdField_a_of_type_AndroidWidgetCheckBox);
      paramViewGroup.addView((View)localObject1);
      paramViewGroup.setClickable(true);
      paramViewGroup.setTag(paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwu
 * JD-Core Version:    0.7.0.1
 */