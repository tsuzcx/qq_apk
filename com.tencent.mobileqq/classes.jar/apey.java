import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

public class apey
  extends Dialog
  implements View.OnClickListener
{
  private apez a;
  
  public apey(@NonNull Context paramContext)
  {
    super(paramContext, 2131755969);
    super.setContentView(2131558691);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131363796).setOnClickListener(this);
  }
  
  public void a(apez paramapez)
  {
    this.a = paramapez;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apey
 * JD-Core Version:    0.7.0.1
 */