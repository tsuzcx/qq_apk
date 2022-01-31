import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Vector;

public class asjy
  implements aska
{
  public asjy(ChatBackgroundManager paramChatBackgroundManager, Context paramContext) {}
  
  public void a(boolean paramBoolean, Vector<Integer> paramVector)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      paramVector = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((paramVector != null) && (paramVector.a() != null) && (paramVector.a().a != null))
      {
        ChatXListView localChatXListView = paramVector.a().a;
        int i = localChatXListView.getFirstVisiblePosition();
        int j = localChatXListView.getLastVisiblePosition();
        while (i <= j)
        {
          Object localObject = actn.a(localChatXListView, i);
          if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof acun)))
          {
            localObject = (acun)((View)localObject).getTag();
            if ((((acun)localObject).jdField_a_of_type_Ambh != null) && (!((acun)localObject).jdField_a_of_type_Ambh.a) && (((acun)localObject).jdField_a_of_type_Ambh.b))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "BgThemeColorExtractListener.onBgThemeColorExtracted: success=true, refresh AIO.");
              }
              paramVector.a().a(((acun)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage, 1);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjy
 * JD-Core Version:    0.7.0.1
 */