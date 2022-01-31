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

public class aufj
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private auft jdField_a_of_type_Auft;
  
  public aufj(Context paramContext, RelativeLayout paramRelativeLayout, auft paramauft)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new aufw(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Auft = paramauft;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558627, null);
    if (localViewGroup != null)
    {
      aufz localaufz = new aufz(this, null);
      localaufz.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362745));
      localaufz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362749));
      localaufz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362747));
      localaufz.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362746));
      localaufz.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362748));
      localaufz.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362733));
      localaufz.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362735));
      localaufz.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362737));
      localaufz.e = ((TextView)localViewGroup.findViewById(2131362736));
      localaufz.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362738));
      localaufz.f = ((TextView)localViewGroup.findViewById(2131362739));
      localaufz.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362740);
      localaufz.g = ((TextView)localViewGroup.findViewById(2131362741));
      localaufz.h = ((TextView)localViewGroup.findViewById(2131362743));
      localaufz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362734));
      localViewGroup.setTag(localaufz);
      localViewGroup.setOnTouchListener(new aufk(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aufu paramaufu, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramaufu, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aufu paramaufu, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramaufu, Boolean.valueOf(paramBoolean1) }));
    }
    aufy localaufy = new aufy(this, null);
    localaufy.jdField_a_of_type_Int = paramInt1;
    localaufy.jdField_b_of_type_Int = paramInt2;
    localaufy.jdField_a_of_type_Boolean = paramBoolean1;
    localaufy.d = paramString1;
    localaufy.e = paramString2;
    localaufy.jdField_a_of_type_Aufu = paramaufu;
    localaufy.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaufy;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, aufv paramaufv, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramaufv, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    aufy localaufy = new aufy(this, null);
    localaufy.jdField_a_of_type_Int = paramInt1;
    localaufy.jdField_b_of_type_Int = paramInt2;
    localaufy.jdField_a_of_type_Boolean = paramBoolean;
    localaufy.jdField_a_of_type_JavaLangString = paramString1;
    localaufy.jdField_b_of_type_JavaLangString = paramString2;
    localaufy.jdField_c_of_type_JavaLangString = paramString3;
    localaufy.jdField_a_of_type_Aufv = paramaufv;
    localaufy.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaufy;
    paramString1.sendToTarget();
  }
  
  private void a(aufy paramaufy)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    aufz localaufz;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362744, paramaufy);
      localaufz = (aufz)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localaufz != null)
      {
        i = paramaufy.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localaufz.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localaufz.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufz.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaufz.jdField_a_of_type_AndroidWidgetTextView.setText(paramaufy.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramaufy.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localaufz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localaufz.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramaufy.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramaufy = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramaufy, 5000L);
      }
      return;
      label213:
      localaufz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localaufz.jdField_b_of_type_AndroidWidgetTextView.setText(paramaufy.jdField_b_of_type_JavaLangString);
      localaufz.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localaufz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaufz.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaufz.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localaufz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localaufz.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaufz.jdField_c_of_type_AndroidWidgetTextView.setText(paramaufy.jdField_c_of_type_JavaLangString);
      localaufz.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localaufz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaufz.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localaufz.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramaufy.jdField_c_of_type_Int);
      localaufz.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localaufz.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufz.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaufz.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramaufy.jdField_b_of_type_Boolean)
        {
          localaufz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localaufz.jdField_d_of_type_AndroidWidgetTextView.setText(paramaufy.d);
          localaufz.e.setText(paramaufy.e);
          localaufz.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new aufl(this, paramaufy));
          localLayoutParams = (FrameLayout.LayoutParams)localaufz.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localaufz.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localaufz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localaufz.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = actj.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localaufz.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localaufz.f.setOnClickListener(new aufm(this, paramaufy));
          localLayoutParams.bottomMargin = actj.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localaufz.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufz.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufz.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramaufy.jdField_a_of_type_Aufx != null)
        {
          localaufz.g.setOnClickListener(new aufn(this, paramaufy));
          localaufz.h.setOnClickListener(new aufo(this, paramaufy));
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
    ((ValueAnimator)localObject).addUpdateListener(new aufp(this));
    ((ValueAnimator)localObject).addListener(new aufq(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Auft != null) {
      this.jdField_a_of_type_Auft.a(true);
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
      localValueAnimator.addUpdateListener(new aufr(this, localViewGroup));
      localValueAnimator.addListener(new aufs(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Auft != null) {
        this.jdField_a_of_type_Auft.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      aufy localaufy = (aufy)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362744);
      if (localaufy != null) {
        return localaufy.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, aufu paramaufu)
  {
    a(paramInt, 11, paramString1, paramString2, paramaufu, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, aufv paramaufv, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramaufv, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, aufu paramaufu, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramaufu, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, aufv paramaufv)
  {
    a(paramString1, paramString2, paramaufv, false);
  }
  
  public void a(String paramString1, String paramString2, aufv paramaufv, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramaufv, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufj
 * JD-Core Version:    0.7.0.1
 */