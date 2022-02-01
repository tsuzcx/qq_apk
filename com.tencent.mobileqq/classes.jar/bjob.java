import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.MyAppDialog.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bjob
  extends ReportDialog
{
  public ProgressBar a;
  TextView a;
  protected final WeakReference<Activity> a;
  TextView b;
  public TextView c;
  TextView d;
  public TextView e;
  
  public bjob(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559702);
  }
  
  public Activity a()
  {
    Activity localActivity2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public bjob a(int paramInt)
  {
    this.b.setTextColor(paramInt);
    return this;
  }
  
  public bjob a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt1);
    this.c.setTextColor(paramInt2);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bjod(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public bjob a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bjoc(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public bjob a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new MyAppDialog.1(this, paramInt1, paramInt2));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(paramDrawable);
  }
  
  public bjob b(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt1);
    this.d.setTextColor(paramInt2);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bjof(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public bjob b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bjoe(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public bjob b(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.b = ((TextView)findViewById(2131365644));
    this.c = ((TextView)findViewById(2131365633));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131365639));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373219));
    this.e = ((TextView)findViewById(2131373245));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjob
 * JD-Core Version:    0.7.0.1
 */