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

public class avzk
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private avzl jdField_a_of_type_Avzl;
  
  private avzk(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131364801));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static avzk a(Activity paramActivity, List<avzm> paramList, int paramInt, avzl paramavzl)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = aepi.a(36.0F, localResources);
    int k = aepi.a(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131561134, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363770);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131364801);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      avzm localavzm = (avzm)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131561133, null);
      localRadioButton.setText(localavzm.a);
      localRadioButton.setTag(localavzm);
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
      if (i > aepi.a(300.0F, localResources)) {
        paramInt = aepi.a(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new avzk(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755030);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramavzl);
      return paramActivity;
    }
  }
  
  public void a(avzl paramavzl)
  {
    this.jdField_a_of_type_Avzl = paramavzl;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      paramRadioGroup = (avzm)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Avzl != null) {
        this.jdField_a_of_type_Avzl.a(paramInt, paramRadioGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzk
 * JD-Core Version:    0.7.0.1
 */