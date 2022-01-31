import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;

public class bbzp
  extends Handler
{
  public bbzp(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    BitmapDrawable localBitmapDrawable;
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        do
        {
          return;
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            if (this.a.jdField_a_of_type_Boolean)
            {
              if ((this.a.g instanceof Button)) {
                ((Button)this.a.g).setText(ajya.a(2131716745));
              }
              this.a.g.setEnabled(false);
              return;
            }
            this.a.g.setEnabled(true);
            return;
          }
          if (this.a.jdField_a_of_type_Boolean)
          {
            this.a.g.setVisibility(0);
            this.a.g.setEnabled(true);
            if ((this.a.g instanceof Button)) {
              ((Button)this.a.g).setText(ajya.a(2131716739));
            }
            this.a.g.setEnabled(false);
            this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            this.a.f.setVisibility(8);
            return;
          }
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof BitmapDrawable)));
        localRelativeLayout = (RelativeLayout)this.a.findViewById(2131379268);
        localBitmapDrawable = (BitmapDrawable)paramMessage.obj;
      } while ((localBitmapDrawable == null) || (localRelativeLayout == null));
      localRelativeLayout.setBackgroundDrawable(localBitmapDrawable);
    } while (paramMessage.arg1 != 1);
    this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbzp
 * JD-Core Version:    0.7.0.1
 */