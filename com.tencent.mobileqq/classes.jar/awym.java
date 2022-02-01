import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Vector;

public class awym
  implements awyo
{
  public awym(ChatBackgroundManager paramChatBackgroundManager, Context paramContext) {}
  
  public void a(boolean paramBoolean, Vector<Integer> paramVector)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      paramVector = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((paramVector != null) && (paramVector.a() != null) && (paramVector.a().listView != null))
      {
        ChatXListView localChatXListView = paramVector.a().listView;
        int i = localChatXListView.getFirstVisiblePosition();
        int j = localChatXListView.getLastVisiblePosition();
        while (i <= j)
        {
          Object localObject = AIOUtils.getViewByPostion(localChatXListView, i);
          if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof afqr)))
          {
            localObject = (afqr)((View)localObject).getTag();
            if ((((afqr)localObject).jdField_a_of_type_Aqhi != null) && (!((afqr)localObject).jdField_a_of_type_Aqhi.a) && (((afqr)localObject).jdField_a_of_type_Aqhi.b))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "BgThemeColorExtractListener.onBgThemeColorExtracted: success=true, refresh AIO.");
              }
              paramVector.a().refreshListItem(((afqr)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage, 1);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awym
 * JD-Core Version:    0.7.0.1
 */