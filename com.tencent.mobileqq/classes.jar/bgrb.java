import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

public class bgrb
  extends Dialog
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new bgrc(this);
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected EditText a;
  public ImageView a;
  protected LinearLayout a;
  ListView jdField_a_of_type_AndroidWidgetListView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  protected TextView a;
  private bgrh jdField_a_of_type_Bgrh = new bgrh(null);
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private ImageView b;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  TextView f;
  TextView g;
  TextView h;
  TextView i;
  private TextView j;
  private TextView k;
  
  @TargetApi(14)
  public bgrb(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131755758);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  protected int a()
  {
    return 2131559340;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  public bgrb a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131694329));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bgrf(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bgrb a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public bgrb a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return this;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public bgrb a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public bgrb a(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setTextColor(paramInt);
    return a(paramString, paramOnClickListener);
  }
  
  public bgrb a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setContentDescription(paramString + getContext().getString(2131694329));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bgrd(this, paramOnClickListener));
    a();
    return this;
  }
  
  protected void a() {}
  
  public bgrb b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setContentDescription(getContext().getString(paramInt));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bgrg(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bgrb b(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setTextColor(paramInt);
    return b(paramString, paramOnClickListener);
  }
  
  public bgrb b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setContentDescription(paramString + getContext().getString(2131694329));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bgre(this, paramOnClickListener));
    a();
    return this;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 181	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	bgrb
    //   5	2	1	localObject	java.lang.Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(2131694330));
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365237));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365233));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365218));
    this.c = ((TextView)findViewById(2131365211));
    this.g = ((TextView)findViewById(2131365504));
    this.f = ((TextView)findViewById(2131372246));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366819));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366818);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379729));
    this.j = ((TextView)findViewById(2131369870));
    this.k = ((TextView)findViewById(2131369871));
    this.d = ((TextView)findViewById(2131365222));
    this.e = ((TextView)findViewById(2131365228));
    this.h = ((TextView)findViewById(2131365219));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365263));
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363352));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131378215));
    this.i = ((TextView)findViewById(2131379127));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369519));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365229));
    if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (Build.VERSION.SDK_INT >= 9)) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Bgrh.a(findViewById(2131365196));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getContext().getString(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrb
 * JD-Core Version:    0.7.0.1
 */