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
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1;
import com.tencent.mobileqq.widget.BounceScrollView;
import java.util.List;

public class audx
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private audy jdField_a_of_type_Audy;
  
  private audx(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131364721));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static audx a(Activity paramActivity, List<audz> paramList, int paramInt, audy paramaudy)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = actj.a(36.0F, localResources);
    int k = actj.a(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131560933, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363712);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131364721);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      audz localaudz = (audz)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131560932, null);
      localRadioButton.setText(localaudz.a);
      localRadioButton.setTag(localaudz);
      localRadioButton.setId(j);
      if (j != paramInt) {
        break label297;
      }
      localRadioButton.setChecked(true);
      localObject = localRadioButton;
    }
    label297:
    for (;;)
    {
      localRadioGroup.addView(localRadioButton, j, new LinearLayout.LayoutParams(-1, -2));
      j += 1;
      i += m;
      break;
      paramInt = i;
      if (i > actj.a(300.0F, localResources)) {
        paramInt = actj.a(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new audx(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755028);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramaudy);
      return paramActivity;
    }
  }
  
  public void a(audy paramaudy)
  {
    this.jdField_a_of_type_Audy = paramaudy;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      paramRadioGroup = (audz)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Audy != null) {
        this.jdField_a_of_type_Audy.a(paramInt, paramRadioGroup);
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
 * Qualified Name:     audx
 * JD-Core Version:    0.7.0.1
 */