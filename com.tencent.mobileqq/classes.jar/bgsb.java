import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import mqq.app.AppRuntime;

public class bgsb
  extends bbgu
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, View.OnClickListener, bblz
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bbly a;
  protected bgsc a;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public bgsb(Context paramContext, AppRuntime paramAppRuntime, int paramInt, bgsc parambgsc)
  {
    super(paramContext, 2131755791);
    this.jdField_a_of_type_Bgsc = parambgsc;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    super.setContentView(2131558919);
    super.setNegativeButton(2131690596, this);
    super.setPositiveButton(2131692324, this);
    super.setTitle(2131689693);
    ((TextView)super.findViewById(2131365150)).setGravity(3);
    paramInt = bbll.a(6.0F);
    int i = bbll.a(16.0F);
    int j = bbll.a(40.0F);
    int k = bbll.a(50.0F);
    paramContext = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramAppRuntime = new LinearLayout.LayoutParams(j, j);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramContext.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppRuntime);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131372061);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843354);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772197));
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130843359, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setHeight(k);
    paramContext.addView(this.jdField_a_of_type_AndroidWidgetButton);
    super.findViewById(2131365146).setVisibility(8);
    paramAppRuntime = (RelativeLayout)super.findViewById(2131365142);
    parambgsc = new RelativeLayout.LayoutParams(0, -2);
    parambgsc.addRule(3, 2131365150);
    parambgsc.addRule(5, 2131365150);
    parambgsc.addRule(7, 2131365150);
    parambgsc.bottomMargin = i;
    parambgsc.topMargin = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131368186));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131692330);
    Object localObject = new InputFilter.LengthFilter(60);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localObject });
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
    paramContext.setId(2131364701);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364701);
    paramAppRuntime.addView(paramContext, parambgsc);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    super.setOnDismissListener(this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130843359, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a(String paramString, int paramInt, Bitmap paramBitmap, Drawable paramDrawable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (apvd.a(paramString))
      {
        bool1 = bool2;
        if (paramInt > 0)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText(adwp.a(paramInt));
          this.jdField_a_of_type_AndroidWidgetButton.setPadding(bbll.a(20.0F), 0, Math.min(adwp.a(this.jdField_a_of_type_AndroidContentContext, paramInt, null, null, 0), bbll.a(200.0F)), 0);
          if (paramDrawable == null) {
            break label107;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.b = paramInt;
      bool1 = true;
      return bool1;
      label107:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.cancel();
      return;
      if (this.jdField_a_of_type_Bgsc != null) {
        this.jdField_a_of_type_Bgsc.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() == 2))
    {
      this.jdField_a_of_type_Bbly.e();
      this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130843359, 0, 0, 0);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      return;
    }
    if (this.jdField_a_of_type_Bbly != null) {
      this.jdField_a_of_type_Bbly.f();
    }
    this.jdField_a_of_type_Bbly = new bbly(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bbly.a(super.getContext());
    this.jdField_a_of_type_Bbly.b();
    this.jdField_a_of_type_Bbly.a(this);
    this.jdField_a_of_type_Bbly.c();
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable, null, null, null);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    if (this.jdField_a_of_type_Bbly != null) {
      this.jdField_a_of_type_Bbly.f();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      super.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsb
 * JD-Core Version:    0.7.0.1
 */