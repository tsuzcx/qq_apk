package com.tencent.mobileqq.activity.framebusiness;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QCircleInjectImpl$1
  implements Runnable
{
  QCircleInjectImpl$1(QCircleInjectImpl paramQCircleInjectImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    if ((this.a.a.length > 8) && (!this.a.getActivity().isFinishing()))
    {
      View localView = this.a.a[8].findViewById(2131378232);
      if (localView == null) {
        return;
      }
      int i = QCircleInjectImpl.a();
      int j = QCircleInjectImpl.b();
      if (QCircleInjectImpl.a(this.this$0) == null)
      {
        localObject = LayoutInflater.from(this.a.getContext()).inflate(2131560718, null);
        QCircleInjectImpl.a(this.this$0, new PopupWindow((View)localObject, j, i));
        QCircleInjectImpl.a(this.this$0).setOutsideTouchable(true);
      }
      int k = localView.getWidth();
      Object localObject = new int[2];
      localView.getLocationInWindow((int[])localObject);
      QCircleInjectImpl.a(this.this$0).showAtLocation(this.a.getView(), 0, localObject[0] + k / 2 - j / 2, localObject[1] - i);
      ThreadManager.getUIHandler().postDelayed(QCircleInjectImpl.a(this.this$0), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */