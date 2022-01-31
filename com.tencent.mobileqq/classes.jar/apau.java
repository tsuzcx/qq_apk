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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4;
import com.tencent.widget.XEditTextEx;

public class apau
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new apav(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LiteCopyPromptHelper.4(this);
  
  public apau(Context paramContext, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = paramXEditTextEx;
  }
  
  private View a(String paramString)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559456, this.jdField_a_of_type_AndroidViewViewGroup, false);
    ((TextView)localView.findViewById(2131372375)).setText(new bamp(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131368344);
    paramString.leftMargin = aepi.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364139)).addView(localView, paramString);
    return localView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(320);
    if ((paramView instanceof apat))
    {
      paramView = ((apat)paramView).a();
      if (!TextUtils.isEmpty(paramView))
      {
        c();
        this.jdField_a_of_type_AndroidViewView = a(paramView);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        nad[] arrayOfnad = new nad[1];
        arrayOfnad[0] = new nad(this.jdField_a_of_type_AndroidViewViewGroup, new apaw(this, arrayOfnad));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new apax(this, paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apau
 * JD-Core Version:    0.7.0.1
 */