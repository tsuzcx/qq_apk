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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper.4;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class arqk
  implements agin, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new arql(this);
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CopyPromptHelper.4(this);
  private ntg jdField_a_of_type_Ntg;
  
  public arqk(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext).inflate(2131559629, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView, false);
    ((TextView)localView.findViewById(2131373261)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131368910);
    paramString.leftMargin = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364488)).addView(localView, paramString);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", "", "0X800B22B", "0X800B22B", 0, 0, "", "", "", "");
    return localView;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new arqn(this, paramString));
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364581).getVisibility() == 0;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
    if ((localObject instanceof arqo))
    {
      localObject = ((arqo)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a();
        this.jdField_a_of_type_AndroidViewView = a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        c();
        a((String)localObject);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ntg == null) {
      this.jdField_a_of_type_Ntg = new ntg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView, new arqm(this));
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
      if (this.jdField_a_of_type_Ntg != null)
      {
        this.jdField_a_of_type_Ntg.a();
        this.jdField_a_of_type_Ntg = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public int[] a()
  {
    return new int[] { 4, 14 };
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
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */