import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.TroopGameCardView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bgpn
  implements View.OnClickListener
{
  public bgpn(TroopGameCardView paramTroopGameCardView) {}
  
  public void onClick(View paramView)
  {
    bhbu.a("grpProfile", "grpProfile_clk", "game_tips_clk", 0, 0, new String[] { this.a.a });
    ReportDialog localReportDialog = new ReportDialog(this.a.getContext(), 2131755829);
    localReportDialog.setContentView(2131559019);
    localReportDialog.setCanceledOnTouchOutside(false);
    Object localObject1 = (TextView)localReportDialog.findViewById(2131365633);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = (TextView)localReportDialog.findViewById(2131365639);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(this.a.getContext().getString(2131719569));
      ((TextView)localObject1).setOnClickListener(new bgpo(this, localReportDialog));
    }
    localObject1 = this.a.getContext().getString(2131719570);
    Object localObject2 = (bgft)aqxe.a().a(695);
    if (localObject2 != null) {
      localObject1 = ((bgft)localObject2).c();
    }
    localObject2 = (TextView)localReportDialog.findViewById(2131365648);
    ((TextView)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((TextView)localObject2).setText(this.a.getContext().getString(2131719571));
    localObject2 = (TextView)localReportDialog.findViewById(2131365644);
    ((TextView)localObject2).setWidth(ViewUtils.dpToPx(236.0F));
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localReportDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpn
 * JD-Core Version:    0.7.0.1
 */