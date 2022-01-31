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
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bdlq
  extends Dialog
{
  public ProgressBar a;
  TextView a;
  protected final WeakReference<Activity> a;
  TextView b;
  public TextView c;
  TextView d;
  public TextView e;
  
  public bdlq(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559472);
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
  
  public bdlq a(int paramInt)
  {
    this.b.setTextColor(paramInt);
    return this;
  }
  
  public bdlq a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt1);
    this.c.setTextColor(paramInt2);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bdls(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public bdlq a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bdlr(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public bdlq a(String paramString)
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
  
  public bdlq b(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt1);
    this.d.setTextColor(paramInt2);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bdlu(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public bdlq b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bdlt(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public bdlq b(String paramString)
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365151));
    this.b = ((TextView)findViewById(2131365147));
    this.c = ((TextView)findViewById(2131365136));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131365142));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131371995));
    this.e = ((TextView)findViewById(2131372021));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlq
 * JD-Core Version:    0.7.0.1
 */