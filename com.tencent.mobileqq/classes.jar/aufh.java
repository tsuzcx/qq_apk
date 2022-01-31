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

public class aufh
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aufr jdField_a_of_type_Aufr;
  
  public aufh(Context paramContext, RelativeLayout paramRelativeLayout, aufr paramaufr)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new aufu(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Aufr = paramaufr;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558627, null);
    if (localViewGroup != null)
    {
      aufx localaufx = new aufx(this, null);
      localaufx.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362746));
      localaufx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362750));
      localaufx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362748));
      localaufx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362747));
      localaufx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362749));
      localaufx.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362734));
      localaufx.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362736));
      localaufx.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362738));
      localaufx.e = ((TextView)localViewGroup.findViewById(2131362737));
      localaufx.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362739));
      localaufx.f = ((TextView)localViewGroup.findViewById(2131362740));
      localaufx.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362741);
      localaufx.g = ((TextView)localViewGroup.findViewById(2131362742));
      localaufx.h = ((TextView)localViewGroup.findViewById(2131362744));
      localaufx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362735));
      localViewGroup.setTag(localaufx);
      localViewGroup.setOnTouchListener(new aufi(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aufs paramaufs, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramaufs, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aufs paramaufs, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramaufs, Boolean.valueOf(paramBoolean1) }));
    }
    aufw localaufw = new aufw(this, null);
    localaufw.jdField_a_of_type_Int = paramInt1;
    localaufw.jdField_b_of_type_Int = paramInt2;
    localaufw.jdField_a_of_type_Boolean = paramBoolean1;
    localaufw.d = paramString1;
    localaufw.e = paramString2;
    localaufw.jdField_a_of_type_Aufs = paramaufs;
    localaufw.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaufw;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, auft paramauft, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramauft, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    aufw localaufw = new aufw(this, null);
    localaufw.jdField_a_of_type_Int = paramInt1;
    localaufw.jdField_b_of_type_Int = paramInt2;
    localaufw.jdField_a_of_type_Boolean = paramBoolean;
    localaufw.jdField_a_of_type_JavaLangString = paramString1;
    localaufw.jdField_b_of_type_JavaLangString = paramString2;
    localaufw.jdField_c_of_type_JavaLangString = paramString3;
    localaufw.jdField_a_of_type_Auft = paramauft;
    localaufw.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaufw;
    paramString1.sendToTarget();
  }
  
  private void a(aufw paramaufw)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    aufx localaufx;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362745, paramaufw);
      localaufx = (aufx)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localaufx != null)
      {
        i = paramaufw.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localaufx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localaufx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufx.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaufx.jdField_a_of_type_AndroidWidgetTextView.setText(paramaufw.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramaufw.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localaufx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localaufx.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramaufw.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramaufw = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramaufw, 5000L);
      }
      return;
      label213:
      localaufx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localaufx.jdField_b_of_type_AndroidWidgetTextView.setText(paramaufw.jdField_b_of_type_JavaLangString);
      localaufx.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localaufx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaufx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaufx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localaufx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localaufx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localaufx.jdField_c_of_type_AndroidWidgetTextView.setText(paramaufw.jdField_c_of_type_JavaLangString);
      localaufx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localaufx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaufx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localaufx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramaufw.jdField_c_of_type_Int);
      localaufx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localaufx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufx.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaufx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramaufw.jdField_b_of_type_Boolean)
        {
          localaufx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localaufx.jdField_d_of_type_AndroidWidgetTextView.setText(paramaufw.d);
          localaufx.e.setText(paramaufw.e);
          localaufx.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new aufj(this, paramaufw));
          localLayoutParams = (FrameLayout.LayoutParams)localaufx.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localaufx.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localaufx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localaufx.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = actn.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localaufx.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localaufx.f.setOnClickListener(new aufk(this, paramaufw));
          localLayoutParams.bottomMargin = actn.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localaufx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaufx.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramaufw.jdField_a_of_type_Aufv != null)
        {
          localaufx.g.setOnClickListener(new aufl(this, paramaufw));
          localaufx.h.setOnClickListener(new aufm(this, paramaufw));
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
    ((ValueAnimator)localObject).addUpdateListener(new aufn(this));
    ((ValueAnimator)localObject).addListener(new aufo(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Aufr != null) {
      this.jdField_a_of_type_Aufr.a(true);
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
      localValueAnimator.addUpdateListener(new aufp(this, localViewGroup));
      localValueAnimator.addListener(new aufq(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Aufr != null) {
        this.jdField_a_of_type_Aufr.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      aufw localaufw = (aufw)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362745);
      if (localaufw != null) {
        return localaufw.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, aufs paramaufs)
  {
    a(paramInt, 11, paramString1, paramString2, paramaufs, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, auft paramauft, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramauft, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, aufs paramaufs, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramaufs, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, auft paramauft)
  {
    a(paramString1, paramString2, paramauft, false);
  }
  
  public void a(String paramString1, String paramString2, auft paramauft, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramauft, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufh
 * JD-Core Version:    0.7.0.1
 */