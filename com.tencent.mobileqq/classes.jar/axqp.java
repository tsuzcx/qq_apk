import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress;
import com.tencent.qphone.base.util.QLog;

public class axqp
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private axqz jdField_a_of_type_Axqz;
  
  public axqp(Context paramContext, RelativeLayout paramRelativeLayout, axqz paramaxqz)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new axrc(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Axqz = paramaxqz;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558695, null);
    if (localViewGroup != null)
    {
      axrf localaxrf = new axrf(this, null);
      localaxrf.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362916));
      localaxrf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362920));
      localaxrf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362918));
      localaxrf.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362917));
      localaxrf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362919));
      localaxrf.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362904));
      localaxrf.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362906));
      localaxrf.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362908));
      localaxrf.e = ((TextView)localViewGroup.findViewById(2131362907));
      localaxrf.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362909));
      localaxrf.f = ((TextView)localViewGroup.findViewById(2131362910));
      localaxrf.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362911);
      localaxrf.g = ((TextView)localViewGroup.findViewById(2131362912));
      localaxrf.h = ((TextView)localViewGroup.findViewById(2131362914));
      localaxrf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362905));
      localViewGroup.setTag(localaxrf);
      localViewGroup.setOnTouchListener(new axqq(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, axra paramaxra, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramaxra, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, axra paramaxra, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramaxra, Boolean.valueOf(paramBoolean1) }));
    }
    axre localaxre = new axre(this, null);
    localaxre.jdField_a_of_type_Int = paramInt1;
    localaxre.jdField_b_of_type_Int = paramInt2;
    localaxre.jdField_a_of_type_Boolean = paramBoolean1;
    localaxre.d = paramString1;
    localaxre.e = paramString2;
    localaxre.jdField_a_of_type_Axra = paramaxra;
    localaxre.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaxre;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, axrb paramaxrb, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramaxrb, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    axre localaxre = new axre(this, null);
    localaxre.jdField_a_of_type_Int = paramInt1;
    localaxre.jdField_b_of_type_Int = paramInt2;
    localaxre.jdField_a_of_type_Boolean = paramBoolean;
    localaxre.jdField_a_of_type_JavaLangString = paramString1;
    localaxre.jdField_b_of_type_JavaLangString = paramString2;
    localaxre.jdField_c_of_type_JavaLangString = paramString3;
    localaxre.jdField_a_of_type_Axrb = paramaxrb;
    localaxre.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaxre;
    paramString1.sendToTarget();
  }
  
  private void a(axre paramaxre)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    axrf localaxrf;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362915, paramaxre);
      localaxrf = (axrf)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localaxrf != null)
      {
        i = paramaxre.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localaxrf.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localaxrf.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaxrf.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaxrf.jdField_a_of_type_AndroidWidgetTextView.setText(paramaxre.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramaxre.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localaxrf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localaxrf.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup.getParent() == null) {
        b();
      }
      if (paramaxre.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramaxre = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramaxre, 5000L);
      }
      return;
      label213:
      localaxrf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localaxrf.jdField_b_of_type_AndroidWidgetTextView.setText(paramaxre.jdField_b_of_type_JavaLangString);
      localaxrf.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localaxrf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaxrf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaxrf.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localaxrf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localaxrf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaxrf.jdField_c_of_type_AndroidWidgetTextView.setText(paramaxre.jdField_c_of_type_JavaLangString);
      localaxrf.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localaxrf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaxrf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localaxrf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramaxre.jdField_c_of_type_Int);
      localaxrf.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localaxrf.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaxrf.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaxrf.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramaxre.jdField_b_of_type_Boolean)
        {
          localaxrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localaxrf.jdField_d_of_type_AndroidWidgetTextView.setText(paramaxre.d);
          localaxrf.e.setText(paramaxre.e);
          localaxrf.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new axqr(this, paramaxre));
          localLayoutParams = (FrameLayout.LayoutParams)localaxrf.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localaxrf.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localaxrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localaxrf.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localaxrf.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localaxrf.f.setOnClickListener(new axqs(this, paramaxre));
          localLayoutParams.bottomMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localaxrf.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaxrf.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaxrf.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramaxre.jdField_a_of_type_Axrd != null)
        {
          localaxrf.g.setOnClickListener(new axqt(this, paramaxre));
          localaxrf.h.setOnClickListener(new axqu(this, paramaxre));
        }
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "addTipsWithAnim");
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(400L);
    ((ValueAnimator)localObject).addUpdateListener(new axqv(this));
    ((ValueAnimator)localObject).addListener(new axqw(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Axqz != null) {
      this.jdField_a_of_type_Axqz.a(true);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new axqx(this, localViewGroup));
      localValueAnimator.addListener(new axqy(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Axqz != null) {
        this.jdField_a_of_type_Axqz.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      axre localaxre = (axre)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362915);
      if (localaxre != null) {
        return localaxre.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("dismissTips", new Object[0]));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101).sendToTarget();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 1, paramString, null, null, null, 0, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, axra paramaxra)
  {
    a(paramInt, 11, paramString1, paramString2, paramaxra, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, axrb paramaxrb, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramaxrb, 0, paramBoolean);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, 1, paramString, null, null, null, 0, paramBoolean);
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(0, 3, paramString, null, null, null, paramInt, false);
  }
  
  public void a(String paramString1, String paramString2, axra paramaxra, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramaxra, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, axrb paramaxrb)
  {
    a(paramString1, paramString2, paramaxrb, false);
  }
  
  public void a(String paramString1, String paramString2, axrb paramaxrb, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramaxrb, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqp
 * JD-Core Version:    0.7.0.1
 */