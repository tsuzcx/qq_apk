package com.tencent.mobileqq.app;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil;
import mqq.os.MqqHandler;

class FrameHelperActivity$7
  implements Runnable
{
  FrameHelperActivity$7(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (FrameHelperActivity.a(this.this$0) == null) {
        return;
      }
      RandomCoverView localRandomCoverView = (RandomCoverView)this.this$0.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378997);
      Object localObject1 = this.a.getCurrentAccountUin();
      localObject1 = ProfileCardUtil.a(this.a, (String)localObject1);
      String str = (String)localObject1.getCoverData(0)[0];
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getCoverData] getCovertUrl from cache,url:");
        ((StringBuilder)localObject2).append(str);
        QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.b()))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("card.isNoCover()=");
          ((StringBuilder)localObject2).append(((Card)localObject1).isNoCover());
          QLog.d("Q.recent", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!DrawerCoverUtil.a(this.a, (Card)localObject1)) && (((Card)localObject1).isNoCover()))
        {
          FrameHelperActivity.a(this.this$0).a(false);
          ThreadManager.getUIHandler().post(new FrameHelperActivity.7.1(this, localRandomCoverView));
          return;
        }
        localObject2 = FrameHelperActivity.a(this.this$0);
        boolean bool = true;
        ((FrameHelperActivity.QQSettingMeListener)localObject2).a(true);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.7.2(this, localRandomCoverView));
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) && (QLog.isColorLevel())) {
          QLog.d("Q.recent", 2, new Object[] { "setDrawerBg: mDrawerFrame=null, app", this.a });
        }
        localObject2 = this.this$0;
        QBaseActivity localQBaseActivity = ((FrameHelperActivity)localObject2).a();
        QQAppInterface localQQAppInterface = this.a;
        FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = FrameHelperActivity.a(this.this$0);
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
          bool = false;
        }
        FrameHelperActivity.a((FrameHelperActivity)localObject2, DrawerCoverUtil.a(localQBaseActivity, localQQAppInterface, (Card)localObject1, localRandomCoverView, str, localQQSettingMeListener, bool));
        return;
      }
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.7.3(this, (Card)localObject1), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.7
 * JD-Core Version:    0.7.0.1
 */