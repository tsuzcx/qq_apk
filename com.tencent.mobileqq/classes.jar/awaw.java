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

public class awaw
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private awbg jdField_a_of_type_Awbg;
  
  public awaw(Context paramContext, RelativeLayout paramRelativeLayout, awbg paramawbg)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new awbj(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Awbg = paramawbg;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558660, null);
    if (localViewGroup != null)
    {
      awbm localawbm = new awbm(this, null);
      localawbm.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362775));
      localawbm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362779));
      localawbm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362777));
      localawbm.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362776));
      localawbm.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362778));
      localawbm.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362763));
      localawbm.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362765));
      localawbm.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362767));
      localawbm.e = ((TextView)localViewGroup.findViewById(2131362766));
      localawbm.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362768));
      localawbm.f = ((TextView)localViewGroup.findViewById(2131362769));
      localawbm.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362770);
      localawbm.g = ((TextView)localViewGroup.findViewById(2131362771));
      localawbm.h = ((TextView)localViewGroup.findViewById(2131362773));
      localawbm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362764));
      localViewGroup.setTag(localawbm);
      localViewGroup.setOnTouchListener(new awax(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, awbh paramawbh, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramawbh, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, awbh paramawbh, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramawbh, Boolean.valueOf(paramBoolean1) }));
    }
    awbl localawbl = new awbl(this, null);
    localawbl.jdField_a_of_type_Int = paramInt1;
    localawbl.jdField_b_of_type_Int = paramInt2;
    localawbl.jdField_a_of_type_Boolean = paramBoolean1;
    localawbl.d = paramString1;
    localawbl.e = paramString2;
    localawbl.jdField_a_of_type_Awbh = paramawbh;
    localawbl.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localawbl;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, awbi paramawbi, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramawbi, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    awbl localawbl = new awbl(this, null);
    localawbl.jdField_a_of_type_Int = paramInt1;
    localawbl.jdField_b_of_type_Int = paramInt2;
    localawbl.jdField_a_of_type_Boolean = paramBoolean;
    localawbl.jdField_a_of_type_JavaLangString = paramString1;
    localawbl.jdField_b_of_type_JavaLangString = paramString2;
    localawbl.jdField_c_of_type_JavaLangString = paramString3;
    localawbl.jdField_a_of_type_Awbi = paramawbi;
    localawbl.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localawbl;
    paramString1.sendToTarget();
  }
  
  private void a(awbl paramawbl)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    awbm localawbm;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362774, paramawbl);
      localawbm = (awbm)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localawbm != null)
      {
        i = paramawbl.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localawbm.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localawbm.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localawbm.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localawbm.jdField_a_of_type_AndroidWidgetTextView.setText(paramawbl.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramawbl.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localawbm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localawbm.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramawbl.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramawbl = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramawbl, 5000L);
      }
      return;
      label213:
      localawbm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localawbm.jdField_b_of_type_AndroidWidgetTextView.setText(paramawbl.jdField_b_of_type_JavaLangString);
      localawbm.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localawbm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localawbm.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localawbm.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localawbm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localawbm.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localawbm.jdField_c_of_type_AndroidWidgetTextView.setText(paramawbl.jdField_c_of_type_JavaLangString);
      localawbm.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localawbm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localawbm.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localawbm.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramawbl.jdField_c_of_type_Int);
      localawbm.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localawbm.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localawbm.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localawbm.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramawbl.jdField_b_of_type_Boolean)
        {
          localawbm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localawbm.jdField_d_of_type_AndroidWidgetTextView.setText(paramawbl.d);
          localawbm.e.setText(paramawbl.e);
          localawbm.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new away(this, paramawbl));
          localLayoutParams = (FrameLayout.LayoutParams)localawbm.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localawbm.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localawbm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localawbm.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = aepi.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localawbm.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localawbm.f.setOnClickListener(new awaz(this, paramawbl));
          localLayoutParams.bottomMargin = aepi.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localawbm.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localawbm.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localawbm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramawbl.jdField_a_of_type_Awbk != null)
        {
          localawbm.g.setOnClickListener(new awba(this, paramawbl));
          localawbm.h.setOnClickListener(new awbb(this, paramawbl));
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
    ((ValueAnimator)localObject).addUpdateListener(new awbc(this));
    ((ValueAnimator)localObject).addListener(new awbd(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Awbg != null) {
      this.jdField_a_of_type_Awbg.a(true);
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
      localValueAnimator.addUpdateListener(new awbe(this, localViewGroup));
      localValueAnimator.addListener(new awbf(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Awbg != null) {
        this.jdField_a_of_type_Awbg.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      awbl localawbl = (awbl)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362774);
      if (localawbl != null) {
        return localawbl.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, awbh paramawbh)
  {
    a(paramInt, 11, paramString1, paramString2, paramawbh, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, awbi paramawbi, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramawbi, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, awbh paramawbh, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramawbh, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, awbi paramawbi)
  {
    a(paramString1, paramString2, paramawbi, false);
  }
  
  public void a(String paramString1, String paramString2, awbi paramawbi, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramawbi, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awaw
 * JD-Core Version:    0.7.0.1
 */