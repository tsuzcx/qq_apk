import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;

public class bjdb
  extends Handler
{
  public bjdb(FriendListOpenFrame paramFriendListOpenFrame) {}
  
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
        bjdd localbjdd = (bjdd)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i).getTag();
        if ((localbjdd != null) && (str.equals(localbjdd.b)))
        {
          localbjdd.a.setImageBitmap(paramMessage);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdb
 * JD-Core Version:    0.7.0.1
 */