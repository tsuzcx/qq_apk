import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

public class apjh
  extends Dialog
  implements View.OnClickListener
{
  private apji a;
  
  public apjh(@NonNull Context paramContext)
  {
    super(paramContext, 2131755969);
    super.setContentView(2131558691);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131363798).setOnClickListener(this);
  }
  
  public void a(apji paramapji)
  {
    this.a = paramapji;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjh
 * JD-Core Version:    0.7.0.1
 */