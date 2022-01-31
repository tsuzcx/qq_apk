import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.ListView;

public class bdkn
  extends Dialog
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new bdko(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public bdkn(Context paramContext, int paramInt)
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
  
  public bdkn a(String paramString)
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
  
  public bdkn a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new bdkp(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bdkn b(String paramString)
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
  
  public bdkn b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bdkq(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bdkn c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bdkr(this, paramOnClickListener));
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365237));
    this.b = ((TextView)findViewById(2131365233));
    this.f = ((TextView)findViewById(2131372246));
    this.c = ((TextView)findViewById(2131365222));
    this.e = ((TextView)findViewById(2131365225));
    this.d = ((TextView)findViewById(2131365228));
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363352));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131369519));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdkn
 * JD-Core Version:    0.7.0.1
 */