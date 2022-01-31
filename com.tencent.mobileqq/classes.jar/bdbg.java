import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;

public class bdbg
  extends Handler
{
  public bdbg(FriendListOpenFrame paramFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 40, 0);
      return;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      return;
      String str = paramMessage.getData().getString("url");
      paramMessage = (Bitmap)paramMessage.obj;
      int j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        bdbi localbdbi = (bdbi)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i).getTag();
        if ((localbdbi != null) && (str.equals(localbdbi.b)))
        {
          localbdbi.a.setImageBitmap(paramMessage);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbg
 * JD-Core Version:    0.7.0.1
 */