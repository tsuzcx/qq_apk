import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.util.List;

public class atgp
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private atgq jdField_a_of_type_Atgq;
  
  private atgp(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131299161));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static atgp a(Activity paramActivity, List<atgr> paramList, int paramInt, atgq paramatgq)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = aciy.a(36.0F, localResources);
    int k = aciy.a(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131495354, null);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131299161);
    int j = 0;
    int i = 78;
    while (j < paramList.size())
    {
      atgr localatgr = (atgr)paramList.get(j);
      RadioButton localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131495353, null);
      localRadioButton.setText(localatgr.a);
      localRadioButton.setTag(localatgr);
      localRadioButton.setId(j);
      if (j == paramInt) {
        localRadioButton.setChecked(true);
      }
      localRadioGroup.addView(localRadioButton, j, new LinearLayout.LayoutParams(-1, -2));
      j += 1;
      i += m;
    }
    paramInt = i;
    if (i > aciy.a(300.0F, localResources)) {
      paramInt = aciy.a(300.0F, localResources);
    }
    paramActivity = new atgp(paramActivity, localView, k, paramInt);
    paramActivity.setAnimationStyle(2131689492);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setFocusable(true);
    paramActivity.setOutsideTouchable(true);
    paramActivity.a(paramatgq);
    return paramActivity;
  }
  
  public void a(atgq paramatgq)
  {
    this.jdField_a_of_type_Atgq = paramatgq;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      paramRadioGroup = (atgr)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Atgq != null) {
        this.jdField_a_of_type_Atgq.a(paramInt, paramRadioGroup);
      }
      dismiss();
      return;
    }
    catch (Exception paramRadioGroup)
    {
      paramRadioGroup.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgp
 * JD-Core Version:    0.7.0.1
 */