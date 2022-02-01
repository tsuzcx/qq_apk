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

public class ayko
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ayky jdField_a_of_type_Ayky;
  
  public ayko(Context paramContext, RelativeLayout paramRelativeLayout, ayky paramayky)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new aylb(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Ayky = paramayky;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558689, null);
    if (localViewGroup != null)
    {
      ayle localayle = new ayle(this, null);
      localayle.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362887));
      localayle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362891));
      localayle.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362889));
      localayle.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362888));
      localayle.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362890));
      localayle.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362875));
      localayle.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362877));
      localayle.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362879));
      localayle.e = ((TextView)localViewGroup.findViewById(2131362878));
      localayle.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362880));
      localayle.f = ((TextView)localViewGroup.findViewById(2131362881));
      localayle.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362882);
      localayle.g = ((TextView)localViewGroup.findViewById(2131362883));
      localayle.h = ((TextView)localViewGroup.findViewById(2131362885));
      localayle.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362876));
      localViewGroup.setTag(localayle);
      localViewGroup.setOnTouchListener(new aykp(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aykz paramaykz, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramaykz, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aykz paramaykz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramaykz, Boolean.valueOf(paramBoolean1) }));
    }
    ayld localayld = new ayld(this, null);
    localayld.jdField_a_of_type_Int = paramInt1;
    localayld.jdField_b_of_type_Int = paramInt2;
    localayld.jdField_a_of_type_Boolean = paramBoolean1;
    localayld.d = paramString1;
    localayld.e = paramString2;
    localayld.jdField_a_of_type_Aykz = paramaykz;
    localayld.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localayld;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ayla paramayla, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramayla, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    ayld localayld = new ayld(this, null);
    localayld.jdField_a_of_type_Int = paramInt1;
    localayld.jdField_b_of_type_Int = paramInt2;
    localayld.jdField_a_of_type_Boolean = paramBoolean;
    localayld.jdField_a_of_type_JavaLangString = paramString1;
    localayld.jdField_b_of_type_JavaLangString = paramString2;
    localayld.jdField_c_of_type_JavaLangString = paramString3;
    localayld.jdField_a_of_type_Ayla = paramayla;
    localayld.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localayld;
    paramString1.sendToTarget();
  }
  
  private void a(ayld paramayld)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    ayle localayle;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362886, paramayld);
      localayle = (ayle)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localayle != null)
      {
        i = paramayld.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localayle.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localayle.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localayle.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localayle.jdField_a_of_type_AndroidWidgetTextView.setText(paramayld.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramayld.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localayle.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localayle.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramayld.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramayld = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramayld, 5000L);
      }
      return;
      label213:
      localayle.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localayle.jdField_b_of_type_AndroidWidgetTextView.setText(paramayld.jdField_b_of_type_JavaLangString);
      localayle.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localayle.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localayle.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localayle.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localayle.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localayle.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localayle.jdField_c_of_type_AndroidWidgetTextView.setText(paramayld.jdField_c_of_type_JavaLangString);
      localayle.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localayle.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localayle.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localayle.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramayld.jdField_c_of_type_Int);
      localayle.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localayle.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localayle.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localayle.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramayld.jdField_b_of_type_Boolean)
        {
          localayle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localayle.jdField_d_of_type_AndroidWidgetTextView.setText(paramayld.d);
          localayle.e.setText(paramayld.e);
          localayle.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new aykq(this, paramayld));
          localLayoutParams = (FrameLayout.LayoutParams)localayle.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localayle.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localayle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localayle.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = afur.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localayle.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localayle.f.setOnClickListener(new aykr(this, paramayld));
          localLayoutParams.bottomMargin = afur.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localayle.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localayle.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localayle.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramayld.jdField_a_of_type_Aylc != null)
        {
          localayle.g.setOnClickListener(new ayks(this, paramayld));
          localayle.h.setOnClickListener(new aykt(this, paramayld));
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
    ((ValueAnimator)localObject).addUpdateListener(new ayku(this));
    ((ValueAnimator)localObject).addListener(new aykv(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Ayky != null) {
      this.jdField_a_of_type_Ayky.a(true);
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
      localValueAnimator.addUpdateListener(new aykw(this, localViewGroup));
      localValueAnimator.addListener(new aykx(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Ayky != null) {
        this.jdField_a_of_type_Ayky.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ayld localayld = (ayld)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362886);
      if (localayld != null) {
        return localayld.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, aykz paramaykz)
  {
    a(paramInt, 11, paramString1, paramString2, paramaykz, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, ayla paramayla, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramayla, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, aykz paramaykz, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramaykz, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, ayla paramayla)
  {
    a(paramString1, paramString2, paramayla, false);
  }
  
  public void a(String paramString1, String paramString2, ayla paramayla, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramayla, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayko
 * JD-Core Version:    0.7.0.1
 */