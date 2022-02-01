package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSHomeFragmentPresenter$4
  implements IWeishiServiceListener
{
  WSHomeFragmentPresenter$4(WSHomeFragmentPresenter paramWSHomeFragmentPresenter) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if (!paramWeishiTask.a()) {
      WSLog.d("WSHomeFragmentPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramWeishiTask.jdField_a_of_type_Int + ", msg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stPublisherRsp)) {
        break;
      }
      paramWeishiTask = (stPublisherRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
    } while (this.a.a() == null);
    ((IWSHomeView)this.a.a()).a(paramWeishiTask);
    return;
    WSLog.d("WSHomeFragmentPresenter", "GetPublisherRequest onTaskResponse failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.4
 * JD-Core Version:    0.7.0.1
 */