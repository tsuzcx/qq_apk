import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.1.1;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.1.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class anok
  extends bhow
{
  private volatile String a;
  
  public anok(ApolloPanel paramApolloPanel) {}
  
  private boolean a(@NotNull String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    if (paramArrayList.contains(paramString))
    {
      paramString = anlw.a(paramString);
      QLog.d("ApolloPanel", 1, "check needReGetFrame, current dressInfo:" + paramString + ", old dressInfo:" + this.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return true;
      }
    }
    return false;
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    super.onApolloDressChange(paramBoolean, paramObject);
    QLog.d("ApolloPanel", 1, this + " onApolloDressChange " + paramBoolean + "; data : " + paramObject);
    if (paramBoolean) {
      paramBoolean = false;
    }
    try
    {
      paramObject = (ArrayList)paramObject;
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.app.getCurrentUin(), paramObject);
      paramBoolean = bool;
    }
    catch (Exception paramObject)
    {
      do
      {
        for (;;)
        {
          QLog.e("ApolloPanel", 1, "onApolloDressChange needReGetFrame exception", paramObject);
        }
        paramObject = (amme)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      } while ((paramObject == null) || (amme.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.app) == 2));
      ThreadManager.getSubThreadHandler().post(new ApolloPanel.1.1(this, paramObject));
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloPanel.1.2(this, paramObject), 100L);
    }
    QLog.d("ApolloPanel", 1, "onApolloDressChange reGetFrame:" + paramBoolean);
    if (!paramBoolean) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anok
 * JD-Core Version:    0.7.0.1
 */