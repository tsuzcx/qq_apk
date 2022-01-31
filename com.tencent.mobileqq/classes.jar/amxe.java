import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

public class amxe
  extends Dialog
  implements View.OnClickListener
{
  private amxf a;
  
  public amxe(@NonNull Context paramContext)
  {
    super(paramContext, 2131690339);
    super.setContentView(2131493104);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131298186).setOnClickListener(this);
  }
  
  public void a(amxf paramamxf)
  {
    this.a = paramamxf;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxe
 * JD-Core Version:    0.7.0.1
 */