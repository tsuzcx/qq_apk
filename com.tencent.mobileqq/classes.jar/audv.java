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

public class audv
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private audw jdField_a_of_type_Audw;
  
  private audv(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131364722));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static audv a(Activity paramActivity, List<audx> paramList, int paramInt, audw paramaudw)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = actn.a(36.0F, localResources);
    int k = actn.a(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131560934, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363713);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131364722);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      audx localaudx = (audx)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131560933, null);
      localRadioButton.setText(localaudx.a);
      localRadioButton.setTag(localaudx);
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
      if (i > actn.a(300.0F, localResources)) {
        paramInt = actn.a(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new audv(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755028);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramaudw);
      return paramActivity;
    }
  }
  
  public void a(audw paramaudw)
  {
    this.jdField_a_of_type_Audw = paramaudw;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      paramRadioGroup = (audx)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Audw != null) {
        this.jdField_a_of_type_Audw.a(paramInt, paramRadioGroup);
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
 * Qualified Name:     audv
 * JD-Core Version:    0.7.0.1
 */