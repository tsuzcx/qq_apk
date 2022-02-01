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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ayvo
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private ayvp jdField_a_of_type_Ayvp;
  
  private ayvo(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131365191));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static ayvo a(Activity paramActivity, List<ayvq> paramList, int paramInt, ayvp paramayvp)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = AIOUtils.dp2px(36.0F, localResources);
    int k = AIOUtils.dp2px(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131561320, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131364101);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131365191);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      ayvq localayvq = (ayvq)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131561319, null);
      localRadioButton.setText(localayvq.a);
      localRadioButton.setTag(localayvq);
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
      if (i > AIOUtils.dp2px(300.0F, localResources)) {
        paramInt = AIOUtils.dp2px(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new ayvo(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755031);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramayvp);
      return paramActivity;
    }
  }
  
  public void a(ayvp paramayvp)
  {
    this.jdField_a_of_type_Ayvp = paramayvp;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      ayvq localayvq = (ayvq)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Ayvp != null) {
        this.jdField_a_of_type_Ayvp.a(paramInt, localayvq);
      }
      dismiss();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvo
 * JD-Core Version:    0.7.0.1
 */