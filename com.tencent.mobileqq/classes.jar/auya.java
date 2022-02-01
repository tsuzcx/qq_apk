import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;

public class auya
  extends RecyclerView.ViewHolder
{
  FormSwitchItem a;
  
  public auya(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((FormSwitchItem)paramView.findViewById(2131369813));
    if (paramBoolean)
    {
      this.a.setBackgroundColor(paramContext.getResources().getColor(2131165762));
      return;
    }
    this.a.setBackgroundColor(paramContext.getResources().getColor(2131165761));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    QzoneConfig.getInstance();
    if (QzoneConfig.isQQCircleShowLebaBySwitchButton()) {
      paramFormSwitchItem.setChecked(true);
    }
    for (;;)
    {
      paramFormSwitchItem.setOnCheckedChangeListener(new auyb(this));
      return;
      paramFormSwitchItem.setChecked(false);
    }
  }
  
  public void a(auxu paramauxu, Context paramContext, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramauxu.a))
    {
      this.a.setText(paramauxu.a);
      this.a.setVisibility(0);
      a(this.a);
      if (paramauxu.b != 0) {
        this.a.setLeftIcon(paramauxu.b);
      }
      paramauxu = this.a.a();
      if (paramauxu != null) {
        if (!paramBoolean) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 2131165764;; i = 2131165763)
    {
      paramauxu.setTextColor(paramContext.getResources().getColor(i));
      return;
      this.a.setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auya
 * JD-Core Version:    0.7.0.1
 */