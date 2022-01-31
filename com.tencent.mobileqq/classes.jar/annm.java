import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

public class annm
  extends Dialog
  implements View.OnClickListener
{
  private annn a;
  
  public annm(@NonNull Context paramContext)
  {
    super(paramContext, 2131755950);
    super.setContentView(2131558655);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131363741).setOnClickListener(this);
  }
  
  public void a(annn paramannn)
  {
    this.a = paramannn;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annm
 * JD-Core Version:    0.7.0.1
 */