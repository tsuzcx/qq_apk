import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class anyk
  implements bhuk
{
  anyk(anyj paramanyj, Context paramContext, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      do
      {
        return;
        paramView = this.jdField_a_of_type_Anyj.b + this.jdField_a_of_type_Anyj.jdField_a_of_type_JavaLangString;
      } while ((TextUtils.isEmpty(paramView)) || ((!paramView.startsWith("http://")) && (!paramView.startsWith("https://"))));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if ((this.jdField_a_of_type_Anyj.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Anyj.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        azqs.b((QQAppInterface)this.jdField_a_of_type_Anyj.jdField_a_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "aio_search", "", "aio_hotword", "search_hotword", 0, 0, "", "", this.jdField_a_of_type_Anyj.jdField_a_of_type_JavaLangString, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyk
 * JD-Core Version:    0.7.0.1
 */