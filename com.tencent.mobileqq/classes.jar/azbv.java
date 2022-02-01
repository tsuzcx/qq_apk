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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class azbv
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private azbw jdField_a_of_type_Azbw;
  
  private azbv(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131365079));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static azbv a(Activity paramActivity, List<azbx> paramList, int paramInt, azbw paramazbw)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = agej.a(36.0F, localResources);
    int k = agej.a(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131561384, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131364002);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131365079);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      azbx localazbx = (azbx)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131561383, null);
      localRadioButton.setText(localazbx.a);
      localRadioButton.setTag(localazbx);
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
      if (i > agej.a(300.0F, localResources)) {
        paramInt = agej.a(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new azbv(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755031);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramazbw);
      return paramActivity;
    }
  }
  
  public void a(azbw paramazbw)
  {
    this.jdField_a_of_type_Azbw = paramazbw;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      azbx localazbx = (azbx)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Azbw != null) {
        this.jdField_a_of_type_Azbw.a(paramInt, localazbx);
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
 * Qualified Name:     azbv
 * JD-Core Version:    0.7.0.1
 */