import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class azhf
  extends ReportDialog
{
  public static boolean a;
  protected Context a;
  
  public azhf(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131755206);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setCanceledOnTouchOutside(true);
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void dismiss()
  {
    jdField_a_of_type_Boolean = false;
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561549, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131755572);
    ((Window)localObject).setGravity(80);
    ((ImageView)paramBundle.findViewById(2131362929)).setOnClickListener(new azhg(this));
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhf
 * JD-Core Version:    0.7.0.1
 */