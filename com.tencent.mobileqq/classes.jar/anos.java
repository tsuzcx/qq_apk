import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class anos
  extends bhow
{
  public anos(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt) {}
  
  protected void onAuthResponse(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if ((paramObject != null) && ((paramObject instanceof HashMap)))
    {
      paramObject = (HashMap)paramObject;
      localObject = (String)paramObject.get("optFrom");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("newActionFloatView".equals(localObject))) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.app.removeObserver(this);
    if (paramBoolean)
    {
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 0, 21, this.jdField_a_of_type_Int, null);
      return;
    }
    Object localObject = new Bundle();
    paramObject = (String)paramObject.get("url");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, activityUrl=", paramObject });
    }
    ((Bundle)localObject).putString("activityUrl", paramObject);
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 1, 22, this.jdField_a_of_type_Int, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anos
 * JD-Core Version:    0.7.0.1
 */