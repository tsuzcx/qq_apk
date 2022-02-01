import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingVideoWrapper.2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class bjfy
  extends bjfv
  implements SeekBar.OnSeekBarChangeListener, bjfi, IVideoOuterStatusListener
{
  private int jdField_a_of_type_Int;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bjfs a;
  private IFullScreenEnterListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener;
  private IVideoInnerStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new FloatingVideoWrapper.2(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private Formatter jdField_a_of_type_JavaUtilFormatter;
  private List<View> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = -1;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 0;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public bjfy(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilFormatter == null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      this.jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
    }
    this.g = ((int)(paramLong / 1000L));
    this.h = (this.g % 60);
    this.i = (this.g / 60 % 60);
    this.j = (this.g / 3600);
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (this.j > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.h) }).toString();
  }
  
  private void a(boolean paramBoolean)
  {
    int n = -2;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    Resources localResources;
    label64:
    label118:
    do
    {
      for (;;)
      {
        return;
        localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        Object localObject;
        int k;
        int m;
        if (this.jdField_e_of_type_AndroidWidgetImageView != null)
        {
          localObject = this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
          if (paramBoolean)
          {
            ((ViewGroup.LayoutParams)localObject).width = -2;
            ((ViewGroup.LayoutParams)localObject).height = -2;
            this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838048);
            this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          if (this.jdField_f_of_type_AndroidWidgetImageView != null)
          {
            localObject = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
            if (!paramBoolean) {
              break label235;
            }
            k = 32;
            m = n;
            if (localResources != null)
            {
              k = agej.a(16.0F, localResources);
              m = n;
            }
            ((LinearLayout.LayoutParams)localObject).width = m;
            ((LinearLayout.LayoutParams)localObject).height = m;
            ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, k);
            this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          if (this.jdField_c_of_type_AndroidWidgetTextView != null)
          {
            if (!paramBoolean) {
              break label265;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(17.0F);
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
            break label275;
          }
          if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
            break label277;
          }
          if (localResources == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(localResources.getColor(2131166942));
          return;
          ((ViewGroup.LayoutParams)localObject).width = -1;
          ((ViewGroup.LayoutParams)localObject).height = -1;
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846243);
          break label64;
          m = 40;
          k = 16;
          if (localResources == null) {
            break label118;
          }
          m = agej.a(20.0F, localResources);
          k = agej.a(8.0F, localResources);
          break label118;
          this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        }
      }
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846244);
        return;
      }
    } while (localResources == null);
    label235:
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(localResources.getColor(2131167247));
    label265:
    label275:
    label277:
    return;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a())) {}
    label95:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b())
      {
        if ((this.jdField_a_of_type_Bjft == null) || (!this.jdField_a_of_type_Bjft.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(), this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b())))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener == null) {
            break label95;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener.onEnter(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(), this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b());
        }
        for (;;)
        {
          bjfq.e();
          return;
          e();
        }
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.c());
    i();
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.c());
    }
    a(false, new View[] { this.jdField_e_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_c_of_type_AndroidWidgetTextView });
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166942));
    }
    if (this.jdField_f_of_type_AndroidWidgetImageView != null)
    {
      if (!a(paramInt)) {
        break label138;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846242);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (paramInt != 400) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698539);
      }
      return;
      label138:
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramInt == 401)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698540);
      return;
    }
    if (paramInt == 402)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698542);
      return;
    }
    if (paramInt == 403)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698541);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131698540);
  }
  
  private void c(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setClipToOutline(paramBoolean);
        if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidContentContext.getResources() != null))
        {
          if (!paramBoolean) {
            break label97;
          }
          atby.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846238));
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidContentContext.getResources() != null)) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(paramBoolean);
      }
      return;
      label97:
      atby.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846237));
    }
  }
  
  private void d(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramInt == 0) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new PropertyValuesHolder[] { localPropertyValuesHolder });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new bjga(this, f2, f1));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new bjgb(this, paramInt));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L).start();
      }
      do
      {
        return;
      } while (paramInt != 1);
      f2 = 1.0F;
      f1 = 0.0F;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(true, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.f();
      b(true);
      a(true);
      a(false, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
    }
    g();
    c(false);
    h();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.c()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(false, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.g();
      b(false);
      a(false);
      a(true, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
    }
    if (this.jdField_a_of_type_Bjfs != null) {
      this.jdField_a_of_type_Bjfs.a();
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    c(true);
    h();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getAlpha() != 1.0F) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      }
    }
    this.jdField_f_of_type_Int = 0;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b())
      {
        if (this.jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131703525));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131703526));
        return;
      }
      if (this.jdField_f_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131703529));
        return;
      }
    } while (this.jdField_f_of_type_Int != 1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anzj.a(2131703523));
  }
  
  private void i()
  {
    switch (this.jdField_f_of_type_Int)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1));
      d(1);
      return;
    }
    d(0);
  }
  
  private void j()
  {
    onVideoStart(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStart();
    }
  }
  
  private void k()
  {
    onVideoStop();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    int k = super.a(paramFloatingScreenParams, paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoClose(6);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = null;
      this.jdField_b_of_type_Int = 0;
      return k;
      bjfq.a();
    }
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a()
  {
    b(3);
    bjfq.g();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setOnBackPressListener(this);
    this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setId(2131374504);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131374490);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374494));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131703531));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374493));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131703527));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374500));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131703528));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374499));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131703524));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374497));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374495));
    this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131703530));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374501));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374496));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374503));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374502));
    a(new View[] { this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374506));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(paramContext.getResources().getDrawable(2130849761));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130846048));
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_d_of_type_AndroidWidgetImageView);
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
    b(paramView);
    paramView.setId(2131374507);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    b(this.jdField_b_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, new FrameLayout.LayoutParams(-1, -1));
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(bjfs parambjfs)
  {
    this.jdField_a_of_type_Bjfs = parambjfs;
  }
  
  public void a(bjft parambjft)
  {
    super.a(parambjft);
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = paramIFullScreenEnterListener;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b())) {
      FloatingScreenManager.getInstance().saveFloatingCenter(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(), this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoClose(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIFullScreenEnterListener = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.b(paramInt);
  }
  
  public void c()
  {
    a(true, new View[] { this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView });
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    g();
    a(false);
    b(false);
    h();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a(0, new bjfz(this));
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131374492)
    {
      b(1);
      bjfq.d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (k == 2131374493)
      {
        b(2);
        bjfq.k();
      }
      else if (k == 2131374494)
      {
        f();
        bjfq.f();
      }
      else if (k == 2131374500)
      {
        j();
        bjfq.h();
      }
      else if (k == 2131374499)
      {
        k();
        bjfq.h();
      }
      else if (k == 2131374495)
      {
        j();
      }
      else if (k == 2131374498)
      {
        b();
      }
    }
  }
  
  public void onOrientationChange(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(paramBoolean);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoSeek(this.jdField_a_of_type_Int);
      onVideoProgressUpdate((int)(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int / 100.0D));
    }
  }
  
  public void onSetVideoCover(Bitmap paramBitmap)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (paramBitmap != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onSetVideoCover(Drawable paramDrawable)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (paramDrawable != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onVideoBuffering()
  {
    c(400);
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 3;
  }
  
  public void onVideoComplete(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b()) {
      bjfq.i();
    }
    for (;;)
    {
      a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
      a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetImageView });
      a(paramBoolean, new View[] { this.jdField_b_of_type_AndroidWidgetImageView });
      b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
      b(false, new View[] { this.jdField_a_of_type_AndroidWidgetSeekBar });
      this.jdField_d_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      this.jdField_c_of_type_Int = 1;
      h();
      return;
      bjfq.j();
    }
  }
  
  public void onVideoError(int paramInt)
  {
    c(401);
    b(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 2;
  }
  
  public void onVideoProgressUpdate(int paramInt)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return;
    }
    int k;
    if (paramInt < 0) {
      k = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = ((int)(100.0D * k / this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(a(k));
      return;
      k = paramInt;
      if (paramInt > this.jdField_b_of_type_Int) {
        k = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_d_of_type_Int = paramInt1;
    }
    if (paramInt2 > 0) {
      this.jdField_e_of_type_Int = paramInt2;
    }
    FloatingScreenContainer localFloatingScreenContainer;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a()))
    {
      localFloatingScreenContainer = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b()) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localFloatingScreenContainer.a(bool, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      return;
    }
  }
  
  public void onVideoStart(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      bjfq.c(paramInt);
    }
    a(false, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetImageView });
    a(true, new View[] { this.jdField_b_of_type_AndroidWidgetTextView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if ((Build.VERSION.SDK_INT < 23) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.c())) {
        break label172;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846244);
    }
    label172:
    do
    {
      for (;;)
      {
        this.jdField_c_of_type_Int = 0;
        h();
        if ((paramInt > 0) && (this.jdField_b_of_type_Int != paramInt)) {
          break;
        }
        return;
        if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidContentContext.getResources() != null)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167247));
        }
      }
      this.jdField_b_of_type_Int = paramInt;
    } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_e_of_type_AndroidWidgetImageView });
    a(false, new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetImageView });
    b(true, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetSeekBar });
    this.jdField_c_of_type_Int = 1;
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfy
 * JD-Core Version:    0.7.0.1
 */