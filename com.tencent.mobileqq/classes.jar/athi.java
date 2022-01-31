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

public class athi
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aths jdField_a_of_type_Aths;
  
  public athi(Context paramContext, RelativeLayout paramRelativeLayout, aths paramaths)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new athv(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Aths = paramaths;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493075, null);
    if (localViewGroup != null)
    {
      athy localathy = new athy(this, null);
      localathy.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131297206));
      localathy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131297210));
      localathy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131297208));
      localathy.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131297207));
      localathy.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131297209));
      localathy.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131297194));
      localathy.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131297196));
      localathy.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131297198));
      localathy.e = ((TextView)localViewGroup.findViewById(2131297197));
      localathy.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131297199));
      localathy.f = ((TextView)localViewGroup.findViewById(2131297200));
      localathy.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131297201);
      localathy.g = ((TextView)localViewGroup.findViewById(2131297202));
      localathy.h = ((TextView)localViewGroup.findViewById(2131297204));
      localathy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131297195));
      localViewGroup.setTag(localathy);
      localViewGroup.setOnTouchListener(new athj(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, atht paramatht, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramatht, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, atht paramatht, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramatht, Boolean.valueOf(paramBoolean1) }));
    }
    athx localathx = new athx(this, null);
    localathx.jdField_a_of_type_Int = paramInt1;
    localathx.jdField_b_of_type_Int = paramInt2;
    localathx.jdField_a_of_type_Boolean = paramBoolean1;
    localathx.d = paramString1;
    localathx.e = paramString2;
    localathx.jdField_a_of_type_Atht = paramatht;
    localathx.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localathx;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, athu paramathu, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramathu, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    athx localathx = new athx(this, null);
    localathx.jdField_a_of_type_Int = paramInt1;
    localathx.jdField_b_of_type_Int = paramInt2;
    localathx.jdField_a_of_type_Boolean = paramBoolean;
    localathx.jdField_a_of_type_JavaLangString = paramString1;
    localathx.jdField_b_of_type_JavaLangString = paramString2;
    localathx.jdField_c_of_type_JavaLangString = paramString3;
    localathx.jdField_a_of_type_Athu = paramathu;
    localathx.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localathx;
    paramString1.sendToTarget();
  }
  
  private void a(athx paramathx)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    athy localathy;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131297205, paramathx);
      localathy = (athy)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localathy != null)
      {
        i = paramathx.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localathy.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localathy.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localathy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localathy.jdField_a_of_type_AndroidWidgetTextView.setText(paramathx.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramathx.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localathy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localathy.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramathx.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramathx = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramathx, 5000L);
      }
      return;
      label213:
      localathy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localathy.jdField_b_of_type_AndroidWidgetTextView.setText(paramathx.jdField_b_of_type_JavaLangString);
      localathy.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localathy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localathy.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localathy.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localathy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localathy.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localathy.jdField_c_of_type_AndroidWidgetTextView.setText(paramathx.jdField_c_of_type_JavaLangString);
      localathy.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localathy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localathy.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localathy.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramathx.jdField_c_of_type_Int);
      localathy.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localathy.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localathy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localathy.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramathx.jdField_b_of_type_Boolean)
        {
          localathy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localathy.jdField_d_of_type_AndroidWidgetTextView.setText(paramathx.d);
          localathy.e.setText(paramathx.e);
          localathy.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new athk(this, paramathx));
          localLayoutParams = (FrameLayout.LayoutParams)localathy.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localathy.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localathy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localathy.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = aciy.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localathy.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localathy.f.setOnClickListener(new athl(this, paramathx));
          localLayoutParams.bottomMargin = aciy.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localathy.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localathy.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localathy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramathx.jdField_a_of_type_Athw != null)
        {
          localathy.g.setOnClickListener(new athm(this, paramathx));
          localathy.h.setOnClickListener(new athn(this, paramathx));
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
    ((ValueAnimator)localObject).addUpdateListener(new atho(this));
    ((ValueAnimator)localObject).addListener(new athp(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_Aths != null) {
      this.jdField_a_of_type_Aths.a(true);
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
      localValueAnimator.addUpdateListener(new athq(this, localViewGroup));
      localValueAnimator.addListener(new athr(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_Aths != null) {
        this.jdField_a_of_type_Aths.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      athx localathx = (athx)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131297205);
      if (localathx != null) {
        return localathx.jdField_a_of_type_Int;
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
  
  public void a(int paramInt, String paramString1, String paramString2, atht paramatht)
  {
    a(paramInt, 11, paramString1, paramString2, paramatht, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, athu paramathu, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramathu, 0, paramBoolean);
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
  
  public void a(String paramString1, String paramString2, atht paramatht, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramatht, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, athu paramathu)
  {
    a(paramString1, paramString2, paramathu, false);
  }
  
  public void a(String paramString1, String paramString2, athu paramathu, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramathu, paramBoolean);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     athi
 * JD-Core Version:    0.7.0.1
 */