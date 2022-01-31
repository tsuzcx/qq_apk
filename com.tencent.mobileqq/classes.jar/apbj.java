import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import java.lang.ref.WeakReference;

public class apbj
  extends ClickableSpan
{
  private alqh jdField_a_of_type_Alqh;
  private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  public apbj(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips = paramShareHotChatGrayTips;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Alqh = new alqh((BaseActivity)paramContext, paramQQAppInterface, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (((Context)this.b.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips != null))
    {
      paramView = ((HotChatManager)paramView.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips.mTroopUin);
      this.jdField_a_of_type_Alqh.a(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbj
 * JD-Core Version:    0.7.0.1
 */