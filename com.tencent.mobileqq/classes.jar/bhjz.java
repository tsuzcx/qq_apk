import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bhjz
  extends ReportDialog
{
  protected Context a;
  private String a;
  private String b;
  private String c;
  
  public bhjz(@NonNull Context paramContext)
  {
    super(paramContext, 2131755206);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setCanceledOnTouchOutside(true);
  }
  
  public bhjz a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bhjz b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public bhjz c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562955, null);
    setContentView(paramBundle);
    TextView localTextView = (TextView)paramBundle.findViewById(2131367695);
    localTextView.setOnClickListener(new bhka(this));
    if (this.c != null) {
      localTextView.setText(this.c);
    }
    localTextView = (TextView)paramBundle.findViewById(2131379001);
    if (this.jdField_a_of_type_JavaLangString != null) {
      localTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    paramBundle = (TextView)paramBundle.findViewById(2131365544);
    if (this.b != null) {
      paramBundle.setText(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjz
 * JD-Core Version:    0.7.0.1
 */