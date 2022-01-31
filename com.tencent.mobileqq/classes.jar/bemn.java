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

public class bemn
  extends Dialog
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new bemo(this);
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected EditText a;
  public ImageView a;
  protected LinearLayout a;
  ListView jdField_a_of_type_AndroidWidgetListView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  protected TextView a;
  private bemt jdField_a_of_type_Bemt = new bemt(null);
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
  public bemn(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131755749);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  protected int a()
  {
    return 2131559294;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public TextView a()
  {
    return this.e;
  }
  
  public bemn a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131694209));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bemr(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bemn a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public bemn a(CharSequence paramCharSequence)
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
  
  public bemn a(String paramString)
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
  
  public bemn a(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setTextColor(paramInt);
    return a(paramString, paramOnClickListener);
  }
  
  public bemn a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setContentDescription(paramString + getContext().getString(2131694209));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new bemp(this, paramOnClickListener));
    a();
    return this;
  }
  
  protected void a() {}
  
  public bemn b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setContentDescription(getContext().getString(paramInt));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bems(this, paramOnClickListener));
    a();
    return this;
  }
  
  public bemn b(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setTextColor(paramInt);
    return b(paramString, paramOnClickListener);
  }
  
  public bemn b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setContentDescription(paramString + getContext().getString(2131694209));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new bemq(this, paramOnClickListener));
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
    //   0	10	0	this	bemn
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
      paramAccessibilityEvent.getText().add(getContext().getString(2131694210));
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365151));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365147));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365132));
    this.c = ((TextView)findViewById(2131365125));
    this.g = ((TextView)findViewById(2131365419));
    this.f = ((TextView)findViewById(2131371907));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366690));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366689);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379002));
    this.j = ((TextView)findViewById(2131369589));
    this.k = ((TextView)findViewById(2131369590));
    this.d = ((TextView)findViewById(2131365136));
    this.e = ((TextView)findViewById(2131365142));
    this.h = ((TextView)findViewById(2131365133));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365177));
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363315));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131377619));
    this.i = ((TextView)findViewById(2131378452));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369266));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365143));
    if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (Build.VERSION.SDK_INT >= 9)) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Bemt.a(findViewById(2131365110));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getContext().getString(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemn
 * JD-Core Version:    0.7.0.1
 */