import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

public class bhpr
  extends ReportDialog
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new bhps(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public bhpr(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    TextView localTextView = null;
    if (this.d.getVisibility() == 0) {
      localTextView = this.d;
    }
    for (;;)
    {
      if (localTextView != null) {}
      return;
      if (this.e.getVisibility() == 0) {
        localTextView = this.e;
      } else if (this.c.getVisibility() == 0) {
        localTextView = this.c;
      }
    }
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public bhpr a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public bhpr a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bhpt(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bhpr b(String paramString)
  {
    if (paramString != null)
    {
      this.b.setText(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public bhpr b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bhpu(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bhpr c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bhpv(this, paramOnClickListener));
    a();
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365523));
    this.b = ((TextView)findViewById(2131365519));
    this.f = ((TextView)findViewById(2131372949));
    this.c = ((TextView)findViewById(2131365508));
    this.e = ((TextView)findViewById(2131365511));
    this.d = ((TextView)findViewById(2131365514));
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363566));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131370012));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpr
 * JD-Core Version:    0.7.0.1
 */