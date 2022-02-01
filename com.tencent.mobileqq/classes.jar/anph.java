import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.FrameCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class anph
  implements amvj
{
  private ApolloActionData jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
  private List<anqh> jdField_a_of_type_JavaUtilList;
  
  public anph(List<anqh> paramList, ApolloActionData paramApolloActionData)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Error paramError)
  {
    QLog.d("ApolloPanel", 1, "ApolloPanel handleCMSPlayerGetFrame success : " + paramBoolean + " actionId: " + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    ThreadManager.getUIHandler().post(new ApolloPanel.FrameCallback.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anph
 * JD-Core Version:    0.7.0.1
 */