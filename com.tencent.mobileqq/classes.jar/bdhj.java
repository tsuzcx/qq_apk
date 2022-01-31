import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class bdhj
  extends Dialog
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new bdhk(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  
  public bdhj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public bdhj a(int paramInt)
  {
    this.b.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.b.setVisibility(0);
    return this;
  }
  
  public bdhj a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(paramInt1);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getContext().getString(paramInt2));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bdhm(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bdhj a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bdhn(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bdhj a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(new baig(paramString, 5, 24));
      this.b.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public bdhj a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(new baig(paramString, 5, 20));
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public bdhj a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(new baig(paramString, 5, 20));
    this.d.setContentDescription(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bdhl(this, paramOnClickListener));
    a();
    return this;
  }
  
  protected void a() {}
  
  public bdhj b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(paramString);
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365235));
    this.b = ((TextView)findViewById(2131365231));
    this.c = ((TextView)findViewById(2131365209));
    this.e = ((TextView)findViewById(2131365210));
    this.g = ((TextView)findViewById(2131365502));
    this.f = ((TextView)findViewById(2131372226));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366809));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366808);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365220));
    this.d = ((TextView)findViewById(2131365226));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363352));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369501));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhj
 * JD-Core Version:    0.7.0.1
 */