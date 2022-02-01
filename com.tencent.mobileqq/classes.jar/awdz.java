import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;

public class awdz
  extends RecyclerView.ViewHolder
{
  FormSwitchItem a;
  
  public awdz(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((FormSwitchItem)paramView.findViewById(2131369983));
    if (paramBoolean)
    {
      this.a.setBackgroundColor(paramContext.getResources().getColor(2131165771));
      return;
    }
    this.a.setBackgroundColor(paramContext.getResources().getColor(2131165770));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    QzoneConfig.getInstance();
    if (QzoneConfig.isQQCircleShowLebaBySwitchButton()) {
      paramFormSwitchItem.setChecked(true);
    }
    for (;;)
    {
      paramFormSwitchItem.setOnCheckedChangeListener(new awea(this));
      return;
      paramFormSwitchItem.setChecked(false);
    }
  }
  
  public void a(awdt paramawdt, Context paramContext, boolean paramBoolean)
  {
    String str;
    if (!TextUtils.isEmpty(paramawdt.a))
    {
      this.a.setText(paramawdt.a);
      this.a.setVisibility(0);
      a(this.a);
      if (AppSetting.c)
      {
        if (!TextUtils.isEmpty(paramawdt.a)) {
          break label143;
        }
        str = "";
        label57:
        this.a.setFocusable(true);
        bgyd.a(this.a, str, Button.class.getName());
      }
      if (paramawdt.b != 0) {
        this.a.setLeftIcon(paramawdt.b);
      }
      paramawdt = this.a.a();
      if (paramawdt != null) {
        if (!paramBoolean) {
          break label152;
        }
      }
    }
    label143:
    label152:
    for (int i = 2131165773;; i = 2131165772)
    {
      paramawdt.setTextColor(paramContext.getResources().getColor(i));
      return;
      this.a.setVisibility(8);
      break;
      str = paramawdt.a;
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdz
 * JD-Core Version:    0.7.0.1
 */