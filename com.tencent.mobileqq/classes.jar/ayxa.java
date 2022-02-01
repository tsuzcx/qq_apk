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

public class ayxa
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ayxk jdField_a_of_type_Ayxk;
  
  public ayxa(Context paramContext, RelativeLayout paramRelativeLayout, ayxk paramayxk)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new ayxn(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Ayxk = paramayxk;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558707, null);
    if (localViewGroup != null)
    {
      ayxq localayxq = new ayxq(this, null);
      localayxq.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362933));
      localayxq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362937));
      localayxq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362935));
      localayxq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362934));
      localayxq.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362936));
      localayxq.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362921));
      localayxq.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362923));
      localayxq.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362925));
      localayxq.e = ((TextView)localViewGroup.findViewById(2131362924));
      localayxq.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362926));
      localayxq.f = ((TextView)localViewGroup.findViewById(2131362927));
      localayxq.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362928);
      localayxq.g = ((TextView)localViewGroup.findViewById(2131362929));
      localayxq.h = ((TextView)localViewGroup.findViewById(2131362931));
      localayxq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362922));
      localViewGroup.setTag(localayxq);
      localViewGroup.setOnTouchListener(new ayxb(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ayxl paramayxl, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramayxl, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ayxl paramayxl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramayxl, Boolean.valueOf(paramBoolean1) }));
    }
    ayxp localayxp = new ayxp(this, null);
    localayxp.jdField_a_of_type_Int = paramInt1;
    localayxp.jdField_b_of_type_Int = paramInt2;
    localayxp.jdField_a_of_type_Boolean = paramBoolean1;
    localayxp.d = paramString1;
    localayxp.e = paramString2;
    localayxp.jdField_a_of_type_Ayxl = paramayxl;
    localayxp.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localayxp;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ayxm paramayxm, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramayxm, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    ayxp localayxp = new ayxp(this, null);
    localayxp.jdField_a_of_type_Int = paramInt1;
    localayxp.jdField_b_of_type_Int = paramInt2;
    localayxp.jdField_a_of_type_Boolean = paramBoolean;
    localayxp.jdField_a_of_type_JavaLangString = paramString1;
    localayxp.jdField_b_of_type_JavaLangString = paramString2;
    localayxp.jdField_c_of_type_JavaLangString = paramString3;
    localayxp.jdField_a_of_type_Ayxm = paramayxm;
    localayxp.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localayxp;
    paramString1.sendToTarget();
  }
  
  private void a(ayxp paramayxp)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    ayxq localayxq;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362932, paramayxp);
      localayxq = (ayxq)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localayxq != null)
      {
        i = paramayxp.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localayxq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localayxq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localayxq.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localayxq.jdField_a_of_type_AndroidWidgetTextView.setText(paramayxp.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramayxp.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localayxq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localayxq.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramayxp.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramayxp = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramayxp, 5000L);
      }
      return;
      label213:
      localayxq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localayxq.jdField_b_of_type_AndroidWidgetTextView.setText(paramayxp.jdField_b_of_type_JavaLangString);
      localayxq.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localayxq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localayxq.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localayxq.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localayxq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localayxq.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localayxq.jdField_c_of_type_AndroidWidgetTextView.setText(paramayxp.jdField_c_of_type_JavaLangString);
      localayxq.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localayxq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localayxq.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localayxq.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramayxp.jdField_c_of_type_Int);
      localayxq.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localayxq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localayxq.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localayxq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramayxp.jdField_b_of_type_Boolean)
        {
          localayxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localayxq.jdField_d_of_type_AndroidWidgetTextView.setText(paramayxp.d);
          localayxq.e.setText(paramayxp.e);
          localayxq.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new ayxc(this, paramayxp));
          localLayoutParams = (FrameLayout.LayoutParams)localayxq.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localayxq.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localayxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localayxq.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localayxq.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localayxq.f.setOnClickListener(new ayxd(this, paramayxp));
          localLayoutParams.bottomMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localayxq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localayxq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localayxq.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramayxp.jdField_a_of_type_Ayxo != null)
        {
          localayxq.g.setOnClickListener(new ayxe(this, paramayxp));
          localayxq.h.setOnClickListener(new ayxf(this, paramayxp));
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
    ((ValueAnimator)localObject).addUpdateListener(new ayxg(this));
    ((ValueAnimator)localObject).addListener(new ayxh(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Ayxk != null) {
      this.jdField_a_of_type_Ayxk.a(true);
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
      localValueAnimator.addUpdateListener(new ayxi(this, localViewGroup));
      localValueAnimator.addListener(new ayxj(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Ayxk != null) {
        this.jdField_a_of_type_Ayxk.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ayxp localayxp = (ayxp)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362932);
      if (localayxp != null) {
        return localayxp.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, ayxl paramayxl)
  {
    a(paramInt, 11, paramString1, paramString2, paramayxl, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, ayxm paramayxm, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramayxm, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, ayxl paramayxl, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramayxl, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, ayxm paramayxm)
  {
    a(paramString1, paramString2, paramayxm, false);
  }
  
  public void a(String paramString1, String paramString2, ayxm paramayxm, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramayxm, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxa
 * JD-Core Version:    0.7.0.1
 */