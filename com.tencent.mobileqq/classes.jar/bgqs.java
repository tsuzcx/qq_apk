import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.1;
import com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.ArrayList;

public class bgqs
  extends Dialog
  implements DialogInterface.OnCancelListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ArrayList<Button> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int k = 0;
    Object localObject1;
    label63:
    Object localObject2;
    if (k < m)
    {
      localObject1 = (Button)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      int j = ((Integer)((Button)localObject1).getTag()).intValue();
      int i;
      if ((k == 0) && (m == 1))
      {
        i = 2130840819;
        switch (j)
        {
        default: 
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165773);
        }
      }
      for (;;)
      {
        ((Button)localObject1).setBackgroundResource(i);
        ((Button)localObject1).setTextColor(j);
        k += 1;
        break;
        if ((k == 0) && (m > 1))
        {
          i = 2130840822;
          break label63;
        }
        if ((k == m - 1) && (m > 1))
        {
          i = 2130840809;
          break label63;
        }
        i = 2130840816;
        break label63;
        j = -16777216;
        ((Button)localObject1).setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297242));
        ((Button)localObject1).setClickable(false);
        ((Button)localObject1).setVisibility(8);
        a(((Button)localObject1).getText().toString());
        continue;
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165776);
        continue;
        DisplayUtil.dip2px(getContext(), 8.0F);
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165773);
        localObject2 = new SpannableString(((Button)localObject1).getText());
        Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840976);
        ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getIntrinsicWidth(), ((Drawable)localObject3).getIntrinsicHeight());
        localObject3 = new ImageSpan((Drawable)localObject3, 1);
        if ((((SpannableString)localObject2).length() >= 1) && (((SpannableString)localObject2).charAt(((SpannableString)localObject2).length() - 1) == '@')) {
          ((SpannableString)localObject2).setSpan(localObject3, ((SpannableString)localObject2).length() - 1, ((SpannableString)localObject2).length(), 33);
        }
        ((Button)localObject1).setText((CharSequence)localObject2);
      }
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559334, null);
      localObject2 = (Button)((View)localObject1).findViewById(2131361914);
      ((Button)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      ((Button)localObject2).setText(2131694328);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public TextView a(String paramString)
  {
    try
    {
      Button localButton = new Button(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, 0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297210));
      localLayoutParams.gravity = 17;
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297242));
      localButton.setText(paramString);
      localButton.setTextColor(-16777216);
      localButton.setBackgroundResource(2130840822);
      localButton.setClickable(false);
      return localButton;
    }
    catch (Exception paramString)
    {
      QMLog.e("ActionSheetDialog", "e:" + paramString.toString());
    }
    return null;
  }
  
  public void dismiss()
  {
    if (this.c)
    {
      this.c = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheetDialog.3(this), 0L);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(null);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      dismiss();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void show()
  {
    super.show();
    a();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheetDialog.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqs
 * JD-Core Version:    0.7.0.1
 */