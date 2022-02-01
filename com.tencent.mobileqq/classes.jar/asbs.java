import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class asbs
  extends ReportDialog
  implements View.OnClickListener
{
  private asbt a;
  
  public asbs(@NonNull Context paramContext)
  {
    super(paramContext, 2131755990);
    super.setContentView(2131558754);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131364030).setOnClickListener(this);
  }
  
  public void a(asbt paramasbt)
  {
    this.a = paramasbt;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbs
 * JD-Core Version:    0.7.0.1
 */