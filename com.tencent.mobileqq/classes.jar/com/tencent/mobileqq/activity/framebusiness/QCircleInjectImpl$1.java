package com.tencent.mobileqq.activity.framebusiness;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import mqq.os.MqqHandler;

final class QCircleInjectImpl$1
  implements Runnable
{
  QCircleInjectImpl$1(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    if ((this.a.z.length > 8) && (this.a.z[8] != null) && (!this.a.getActivity().isFinishing()))
    {
      View localView = this.a.z[8].findViewById(2131446751);
      if (localView == null) {
        return;
      }
      int i = QCircleInjectImpl.e();
      if (QCircleInjectImpl.f() == null)
      {
        localObject = LayoutInflater.from(this.a.getContext()).inflate(2131626850, null);
        ((TextView)((View)localObject).findViewById(2131441900)).setText(QCircleHostGlobalInfo.getEntranceGuideTips());
        QCircleInjectImpl.a(new PopupWindow((View)localObject, -2, i));
        QCircleInjectImpl.f().setOutsideTouchable(true);
        ((View)localObject).measure(0, 0);
        QCircleInjectImpl.a(((View)localObject).getMeasuredWidth());
      }
      int j = localView.getWidth();
      Object localObject = new int[2];
      localView.getLocationInWindow((int[])localObject);
      QCircleInjectImpl.f().showAtLocation(this.a.getView(), 0, localObject[0] + j / 2 - QCircleInjectImpl.g() / 2, localObject[1] - i);
      ThreadManager.getUIHandler().postDelayed(QCircleInjectImpl.h(), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */