import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog.1;

public class bcpq
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
  private bcps jdField_a_of_type_Bcps;
  String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 48;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c = -2;
  
  public bcpq(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public bcpq(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131561032, 48);
  }
  
  public bcpq(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131755791);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363293));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370458));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377345));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377346));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(bcps parambcps)
  {
    this.jdField_a_of_type_Bcps = parambcps;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    setOnKeyListener(new bcpr(this, paramBoolean));
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 152	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 157	zzs:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 157	zzs:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 157	zzs:a	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	bcpq
    //   9	1	1	localException	java.lang.Exception
    //   15	6	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (AppSetting.d) {
      QQAppInterface.f(this.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void f(@DrawableRes int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_Bcps != null) {
      this.jdField_a_of_type_Bcps.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpq
 * JD-Core Version:    0.7.0.1
 */