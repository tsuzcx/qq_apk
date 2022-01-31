import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.ToastView.1;

public class bdjb
{
  private int jdField_a_of_type_Int = 1500;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  Runnable jdField_a_of_type_JavaLangRunnable = new ToastView.1(this);
  
  public bdjb(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public static int a(String paramString)
  {
    if ("success".equals(paramString)) {
      return 2130840689;
    }
    if ("warn".equals(paramString)) {
      return 2130840687;
    }
    if ("loading".equals(paramString)) {
      return 2130840763;
    }
    return 2130840688;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0) {
      a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493733, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(paramBoolean);
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311708);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311705);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 360.0F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(2000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    ((TextView)localObject).setEms(7);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((TextView)localObject).setMaxLines(1);
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = localImageView.getLayoutParams();
      if (localObject != null)
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      localImageView.setVisibility(8);
      ((TextView)localObject).setGravity(17);
      if (paramInt == 1)
      {
        ((TextView)localObject).setMaxLines(1);
      }
      else if (paramInt == 0)
      {
        ((TextView)localObject).setEms(18);
        ((TextView)localObject).setMaxLines(2);
      }
    }
    ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  private void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  private void b()
  {
    bdnw.a("ToastView", "show mParentView=" + this.jdField_a_of_type_AndroidViewViewGroup + ",toastLayout=" + this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      if (this.jdField_a_of_type_Int > -1) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    bdnw.a("ToastView", "hide mParentView=" + this.jdField_a_of_type_AndroidViewViewGroup + ",toastLayout=" + this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    bdnw.a("ToastView", "show iconType=" + paramString1 + ",localIconPath=" + paramString2 + ",msg=" + paramCharSequence + ",duration=" + paramInt2 + ",mask=" + paramBoolean);
    a();
    if (!TextUtils.isEmpty(paramString2)) {
      a(new BitmapDrawable(paramString2));
    }
    for (;;)
    {
      a(paramCharSequence);
      b(paramInt2);
      a(paramInt1, paramBoolean);
      b();
      return;
      a(a(paramString1));
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    while (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */