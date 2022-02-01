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

public class azdh
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private azdr jdField_a_of_type_Azdr;
  
  public azdh(Context paramContext, RelativeLayout paramRelativeLayout, azdr paramazdr)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new azdu(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Azdr = paramazdr;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558691, null);
    if (localViewGroup != null)
    {
      azdx localazdx = new azdx(this, null);
      localazdx.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362905));
      localazdx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362909));
      localazdx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362907));
      localazdx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362906));
      localazdx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362908));
      localazdx.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362893));
      localazdx.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362895));
      localazdx.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362897));
      localazdx.e = ((TextView)localViewGroup.findViewById(2131362896));
      localazdx.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362898));
      localazdx.f = ((TextView)localViewGroup.findViewById(2131362899));
      localazdx.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362900);
      localazdx.g = ((TextView)localViewGroup.findViewById(2131362901));
      localazdx.h = ((TextView)localViewGroup.findViewById(2131362903));
      localazdx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362894));
      localViewGroup.setTag(localazdx);
      localViewGroup.setOnTouchListener(new azdi(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, azds paramazds, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramazds, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, azds paramazds, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramazds, Boolean.valueOf(paramBoolean1) }));
    }
    azdw localazdw = new azdw(this, null);
    localazdw.jdField_a_of_type_Int = paramInt1;
    localazdw.jdField_b_of_type_Int = paramInt2;
    localazdw.jdField_a_of_type_Boolean = paramBoolean1;
    localazdw.d = paramString1;
    localazdw.e = paramString2;
    localazdw.jdField_a_of_type_Azds = paramazds;
    localazdw.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localazdw;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, azdt paramazdt, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramazdt, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    azdw localazdw = new azdw(this, null);
    localazdw.jdField_a_of_type_Int = paramInt1;
    localazdw.jdField_b_of_type_Int = paramInt2;
    localazdw.jdField_a_of_type_Boolean = paramBoolean;
    localazdw.jdField_a_of_type_JavaLangString = paramString1;
    localazdw.jdField_b_of_type_JavaLangString = paramString2;
    localazdw.jdField_c_of_type_JavaLangString = paramString3;
    localazdw.jdField_a_of_type_Azdt = paramazdt;
    localazdw.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localazdw;
    paramString1.sendToTarget();
  }
  
  private void a(azdw paramazdw)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    azdx localazdx;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362904, paramazdw);
      localazdx = (azdx)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localazdx != null)
      {
        i = paramazdw.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localazdx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localazdx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localazdx.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localazdx.jdField_a_of_type_AndroidWidgetTextView.setText(paramazdw.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramazdw.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localazdx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localazdx.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramazdw.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramazdw = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramazdw, 5000L);
      }
      return;
      label213:
      localazdx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localazdx.jdField_b_of_type_AndroidWidgetTextView.setText(paramazdw.jdField_b_of_type_JavaLangString);
      localazdx.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localazdx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localazdx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localazdx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localazdx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localazdx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localazdx.jdField_c_of_type_AndroidWidgetTextView.setText(paramazdw.jdField_c_of_type_JavaLangString);
      localazdx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localazdx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localazdx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localazdx.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramazdw.jdField_c_of_type_Int);
      localazdx.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localazdx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localazdx.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localazdx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramazdw.jdField_b_of_type_Boolean)
        {
          localazdx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localazdx.jdField_d_of_type_AndroidWidgetTextView.setText(paramazdw.d);
          localazdx.e.setText(paramazdw.e);
          localazdx.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new azdj(this, paramazdw));
          localLayoutParams = (FrameLayout.LayoutParams)localazdx.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localazdx.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localazdx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localazdx.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = agej.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localazdx.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localazdx.f.setOnClickListener(new azdk(this, paramazdw));
          localLayoutParams.bottomMargin = agej.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localazdx.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localazdx.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localazdx.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramazdw.jdField_a_of_type_Azdv != null)
        {
          localazdx.g.setOnClickListener(new azdl(this, paramazdw));
          localazdx.h.setOnClickListener(new azdm(this, paramazdw));
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
    ((ValueAnimator)localObject).addUpdateListener(new azdn(this));
    ((ValueAnimator)localObject).addListener(new azdo(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Azdr != null) {
      this.jdField_a_of_type_Azdr.a(true);
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
      localValueAnimator.addUpdateListener(new azdp(this, localViewGroup));
      localValueAnimator.addListener(new azdq(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Azdr != null) {
        this.jdField_a_of_type_Azdr.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      azdw localazdw = (azdw)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362904);
      if (localazdw != null) {
        return localazdw.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, azds paramazds)
  {
    a(paramInt, 11, paramString1, paramString2, paramazds, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, azdt paramazdt, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramazdt, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, azds paramazds, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramazds, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, azdt paramazdt)
  {
    a(paramString1, paramString2, paramazdt, false);
  }
  
  public void a(String paramString1, String paramString2, azdt paramazdt, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramazdt, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdh
 * JD-Core Version:    0.7.0.1
 */