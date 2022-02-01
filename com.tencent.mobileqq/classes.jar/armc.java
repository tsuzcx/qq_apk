import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class armc
  extends ReportDialog
  implements View.OnClickListener
{
  private armd a;
  
  public armc(@NonNull Context paramContext)
  {
    super(paramContext, 2131755989);
    super.setContentView(2131558758);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131364004).setOnClickListener(this);
  }
  
  public void a(armd paramarmd)
  {
    this.a = paramarmd;
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
 * Qualified Name:     armc
 * JD-Core Version:    0.7.0.1
 */