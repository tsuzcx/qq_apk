import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;

public class awkw
  extends RecyclerView.ViewHolder
{
  FormSwitchItem a;
  
  public awkw(Context paramContext, View paramView)
  {
    super(paramView);
    this.a = ((FormSwitchItem)paramView.findViewById(2131369824));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    QzoneConfig.getInstance();
    if (QzoneConfig.isQQCircleShowLebaBySwitchButton()) {
      paramFormSwitchItem.setChecked(true);
    }
    for (;;)
    {
      paramFormSwitchItem.setOnCheckedChangeListener(new awkx(this));
      QCircleGetCircleSwitchRequest localQCircleGetCircleSwitchRequest = new QCircleGetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable");
      VSNetworkHelper.a().a(localQCircleGetCircleSwitchRequest, new awkz(this, paramFormSwitchItem));
      return;
      paramFormSwitchItem.setChecked(false);
    }
  }
  
  public void a(awkq paramawkq)
  {
    if (!TextUtils.isEmpty(paramawkq.a))
    {
      this.a.setText(paramawkq.a);
      this.a.setVisibility(0);
      a(this.a);
    }
    for (;;)
    {
      if (paramawkq.b != 0) {
        this.a.setLeftIcon(paramawkq.b);
      }
      return;
      this.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkw
 * JD-Core Version:    0.7.0.1
 */