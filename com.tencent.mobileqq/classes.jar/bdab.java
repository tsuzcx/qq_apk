import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bdab
  implements View.OnClickListener
{
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  String b = null;
  
  public bdab(bczz parambczz, Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseChatPie localBaseChatPie;
    Object localObject2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)) && (!MultiForwardActivity.class.isInstance(this.jdField_a_of_type_JavaLangRefWeakReference.get())))
    {
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getChatFragment();
      if (localObject1 != null)
      {
        localBaseChatPie = ((ChatFragment)localObject1).a();
        adrm.b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString + " +1");
        localObject2 = "";
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.b)) {
          localObject1 = Uri.parse(this.b);
        }
      }
    }
    try
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
      localObject2 = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    oat.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007239", "0X8007239", 0, 0, (String)localObject1, "", "", "");
    oat.a("0X8007239", "", (String)localObject1, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdab
 * JD-Core Version:    0.7.0.1
 */