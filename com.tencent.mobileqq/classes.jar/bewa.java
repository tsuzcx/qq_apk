import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.ColorUtil;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bewa
  extends BaseAdapter
{
  public bewb a;
  protected List<String> a;
  public boolean a;
  private boolean b;
  private boolean c;
  
  public bewa()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(int paramInt, bewc parambewc, String paramString, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      if (paramString.equals(paramViewGroup.getContext().getString(2131719693)))
      {
        parambewc.b.setVisibility(8);
        parambewc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorUtil.parseColor("#4D94FF"));
        parambewc.jdField_a_of_type_AndroidWidgetTextView.setTag(TroopNickRuleFragment.f);
        paramString = (LinearLayout.LayoutParams)parambewc.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramString != null)
        {
          paramString.rightMargin = ViewUtils.dpToPx(12.0F);
          parambewc.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
        }
        parambewc.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        parambewc.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(parambewc);
      }
    }
    else {
      return;
    }
    parambewc.b.setVisibility(0);
    parambewc.b.setOnClickListener(parambewc);
    parambewc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getContext().getResources().getColorStateList(2131167031));
    parambewc.jdField_a_of_type_AndroidWidgetTextView.setTag(TroopNickRuleFragment.g);
    paramString = (LinearLayout.LayoutParams)parambewc.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramString != null)
    {
      paramString.rightMargin = ViewUtils.dpToPx(7.0F);
      parambewc.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
    }
    parambewc.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    parambewc.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void c()
  {
    this.c = true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt);
    View localView;
    Object localObject;
    if (TextUtils.isEmpty(str))
    {
      localView = paramView;
      localObject = paramView;
      paramView = localView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560727, null, false);
      if (this.b) {
        localView.setBackgroundDrawable(paramViewGroup.getContext().getResources().getDrawable(2130846219));
      }
      localObject = new bewc(this);
      ((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373113));
      ((bewc)localObject).b = ((TextView)localView.findViewById(2131373114));
      ((bewc)localObject).b.setTag(TroopNickRuleFragment.e);
      localView.setTag(localObject);
      if (this.c)
      {
        ((LinearLayout.LayoutParams)((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).setMargins(30, 15, 30, 15);
        ((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
        ((bewc)localObject).b.setVisibility(8);
      }
    }
    for (;;)
    {
      ((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      ((bewc)localObject).jdField_a_of_type_Int = paramInt;
      paramView = localView;
      localObject = localView;
      break;
      ((bewc)localObject).b.setOnClickListener((View.OnClickListener)localObject);
      a(paramInt, (bewc)localObject, str, paramViewGroup);
      continue;
      bewc localbewc = (bewc)paramView.getTag();
      localObject = localbewc;
      localView = paramView;
      if (!this.c)
      {
        a(paramInt, localbewc, str, paramViewGroup);
        localObject = localbewc;
        localView = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewa
 * JD-Core Version:    0.7.0.1
 */