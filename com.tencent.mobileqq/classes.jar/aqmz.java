import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper.4;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class aqmz
  implements afrc, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aqna(this);
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CopyPromptHelper.4(this);
  
  public aqmz(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext).inflate(2131559594, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView, false);
    ((TextView)localView.findViewById(2131373051)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131368751);
    paramString.leftMargin = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364407)).addView(localView, paramString);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", "", "0X800B22B", "0X800B22B", 0, 0, "", "", "", "");
    return localView;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364499).getVisibility() == 0;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(320);
    if ((localObject instanceof aqnd))
    {
      localObject = ((aqnd)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a();
        this.jdField_a_of_type_AndroidViewView = a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        nmg[] arrayOfnmg = new nmg[1];
        arrayOfnmg[0] = new nmg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView, new aqnb(this, arrayOfnmg));
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aqnc(this, (String)localObject));
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable.run();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public int[] a()
  {
    return new int[] { 3, 13 };
  }
  
  public void onClick(View paramView)
  {
    if (!a()) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmz
 * JD-Core Version:    0.7.0.1
 */