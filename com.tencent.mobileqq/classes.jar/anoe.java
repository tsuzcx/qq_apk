import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anoe
  implements View.OnClickListener
{
  anoe(anob paramanob, Bundle paramBundle, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((anob.a(this.jdField_a_of_type_Anob) != null) && (anob.a(this.jdField_a_of_type_Anob).mActivity != null))
    {
      Object localObject1 = null;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("activityUrl");
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, new Object[] { "[realshowNewActionFloatView] btn click, activityUrl=", localObject2 });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new Intent(anob.a(this.jdField_a_of_type_Anob).mActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        anob.a(this.jdField_a_of_type_Anob).mActivity.startActivity((Intent)localObject1);
      }
      this.jdField_a_of_type_Anob.a();
      anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "action_flame_clickgain");
      anme.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoe
 * JD-Core Version:    0.7.0.1
 */