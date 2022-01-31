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
import com.tencent.mobileqq.olympic.activity.ARTipsCircleProgress;
import com.tencent.qphone.base.util.QLog;

public class avwn
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private avwx jdField_a_of_type_Avwx;
  
  public avwn(Context paramContext, RelativeLayout paramRelativeLayout, avwx paramavwx)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new avxa(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Avwx = paramavwx;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558660, null);
    if (localViewGroup != null)
    {
      avxd localavxd = new avxd(this, null);
      localavxd.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362775));
      localavxd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362779));
      localavxd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362777));
      localavxd.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362776));
      localavxd.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362778));
      localavxd.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362763));
      localavxd.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362765));
      localavxd.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362767));
      localavxd.e = ((TextView)localViewGroup.findViewById(2131362766));
      localavxd.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362768));
      localavxd.f = ((TextView)localViewGroup.findViewById(2131362769));
      localavxd.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362770);
      localavxd.g = ((TextView)localViewGroup.findViewById(2131362771));
      localavxd.h = ((TextView)localViewGroup.findViewById(2131362773));
      localavxd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362764));
      localViewGroup.setTag(localavxd);
      localViewGroup.setOnTouchListener(new avwo(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, avwy paramavwy, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramavwy, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, avwy paramavwy, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramavwy, Boolean.valueOf(paramBoolean1) }));
    }
    avxc localavxc = new avxc(this, null);
    localavxc.jdField_a_of_type_Int = paramInt1;
    localavxc.jdField_b_of_type_Int = paramInt2;
    localavxc.jdField_a_of_type_Boolean = paramBoolean1;
    localavxc.d = paramString1;
    localavxc.e = paramString2;
    localavxc.jdField_a_of_type_Avwy = paramavwy;
    localavxc.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localavxc;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, avwz paramavwz, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramavwz, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    avxc localavxc = new avxc(this, null);
    localavxc.jdField_a_of_type_Int = paramInt1;
    localavxc.jdField_b_of_type_Int = paramInt2;
    localavxc.jdField_a_of_type_Boolean = paramBoolean;
    localavxc.jdField_a_of_type_JavaLangString = paramString1;
    localavxc.jdField_b_of_type_JavaLangString = paramString2;
    localavxc.jdField_c_of_type_JavaLangString = paramString3;
    localavxc.jdField_a_of_type_Avwz = paramavwz;
    localavxc.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localavxc;
    paramString1.sendToTarget();
  }
  
  private void a(avxc paramavxc)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    avxd localavxd;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362774, paramavxc);
      localavxd = (avxd)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localavxd != null)
      {
        i = paramavxc.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localavxd.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localavxd.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localavxd.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localavxd.jdField_a_of_type_AndroidWidgetTextView.setText(paramavxc.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramavxc.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localavxd.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localavxd.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramavxc.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramavxc = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramavxc, 5000L);
      }
      return;
      label213:
      localavxd.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localavxd.jdField_b_of_type_AndroidWidgetTextView.setText(paramavxc.jdField_b_of_type_JavaLangString);
      localavxd.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localavxd.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localavxd.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localavxd.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localavxd.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localavxd.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localavxd.jdField_c_of_type_AndroidWidgetTextView.setText(paramavxc.jdField_c_of_type_JavaLangString);
      localavxd.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localavxd.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localavxd.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localavxd.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramavxc.jdField_c_of_type_Int);
      localavxd.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localavxd.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localavxd.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localavxd.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramavxc.jdField_b_of_type_Boolean)
        {
          localavxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localavxd.jdField_d_of_type_AndroidWidgetTextView.setText(paramavxc.d);
          localavxd.e.setText(paramavxc.e);
          localavxd.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new avwp(this, paramavxc));
          localLayoutParams = (FrameLayout.LayoutParams)localavxd.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localavxd.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localavxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localavxd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = aekt.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localavxd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localavxd.f.setOnClickListener(new avwq(this, paramavxc));
          localLayoutParams.bottomMargin = aekt.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localavxd.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localavxd.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localavxd.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramavxc.jdField_a_of_type_Avxb != null)
        {
          localavxd.g.setOnClickListener(new avwr(this, paramavxc));
          localavxd.h.setOnClickListener(new avws(this, paramavxc));
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
    ((ValueAnimator)localObject).addUpdateListener(new avwt(this));
    ((ValueAnimator)localObject).addListener(new avwu(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Avwx != null) {
      this.jdField_a_of_type_Avwx.a(true);
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
      localValueAnimator.addUpdateListener(new avwv(this, localViewGroup));
      localValueAnimator.addListener(new avww(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Avwx != null) {
        this.jdField_a_of_type_Avwx.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      avxc localavxc = (avxc)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362774);
      if (localavxc != null) {
        return localavxc.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, avwy paramavwy)
  {
    a(paramInt, 11, paramString1, paramString2, paramavwy, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, avwz paramavwz, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramavwz, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, avwy paramavwy, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramavwy, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, avwz paramavwz)
  {
    a(paramString1, paramString2, paramavwz, false);
  }
  
  public void a(String paramString1, String paramString2, avwz paramavwz, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramavwz, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwn
 * JD-Core Version:    0.7.0.1
 */