import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.QQProgressDialog.1;

public class bgnd
  extends Dialog
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgne jdField_a_of_type_Bgne;
  String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 48;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c = -2;
  
  public bgnd(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public bgnd(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131559360, 48);
  }
  
  public bgnd(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131755762);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363330));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370763));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377879));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377880));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 110	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	bgnd
    //   5	2	1	localObject	java.lang.Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    return true;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_Bgne != null) {
      this.jdField_a_of_type_Bgne.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.c;
    localLayoutParams.gravity = this.jdField_b_of_type_Int;
    localLayoutParams.y += this.jdField_a_of_type_Int;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.postDelayed(new QQProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnd
 * JD-Core Version:    0.7.0.1
 */