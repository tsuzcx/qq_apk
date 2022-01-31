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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class aowg
  implements afal, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aowh(this);
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CopyPromptHelper.4(this);
  
  public aowg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131559457, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c, false);
    ((TextView)localView.findViewById(2131372355)).setText(new baig(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131368333);
    paramString.leftMargin = aekt.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364137)).addView(localView, paramString);
    return localView;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364227).getVisibility() == 0;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(320);
    if ((localObject instanceof aowk))
    {
      localObject = ((aowk)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a();
        this.jdField_a_of_type_AndroidViewView = a((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        nad[] arrayOfnad = new nad[1];
        arrayOfnad[0] = new nad(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c, new aowi(this, arrayOfnad));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aowj(this, (String)localObject));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable.run();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
  
  public void onClick(View paramView)
  {
    if (!a()) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowg
 * JD-Core Version:    0.7.0.1
 */