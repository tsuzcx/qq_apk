package com.tencent.mobileqq.app;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import anyl;
import bhhz;
import blgu;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FrameHelperActivity$7
  implements Runnable
{
  FrameHelperActivity$7(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidViewViewGroup == null) || (FrameHelperActivity.a(this.this$0) == null)) {
      return;
    }
    RandomCoverView localRandomCoverView = (RandomCoverView)this.this$0.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379156);
    Object localObject = this.a.getCurrentAccountUin();
    localObject = bhhz.a(this.a, (String)localObject);
    String str = (String)localObject.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from cache,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!blgu.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + ((Card)localObject).isNoCover());
      }
      if ((!blgu.a(this.a, (Card)localObject)) && (((Card)localObject).isNoCover()))
      {
        FrameHelperActivity.a(this.this$0).a(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.7.1(this, localRandomCoverView));
        return;
      }
      FrameHelperActivity.a(this.this$0).a(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.7.2(this, localRandomCoverView));
      FrameHelperActivity.a(this.this$0, blgu.a(this.this$0.getActivity(), this.a, (Card)localObject, localRandomCoverView, str, FrameHelperActivity.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a()));
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.7.3(this, (Card)localObject), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.7
 * JD-Core Version:    0.7.0.1
 */