package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.widget.XListView;
import mqq.manager.TicketManager;

class HotChatPie$17
  implements Runnable
{
  HotChatPie$17(HotChatPie paramHotChatPie, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!NetworkUtil.isNetworkAvailable(this.this$0.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.this$0.jdField_a_of_type_AndroidContentContext, 1, this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131694425), 0).a();
      return;
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      Object localObject1 = null;
      Object localObject2 = (TicketManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      Object localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (localObject2 != null) {
        localObject1 = ((TicketManager)localObject2).getSkey((String)localObject3);
      }
      localObject2 = new Bundle();
      Object localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.getTribeId();
      ((Bundle)localObject2).putString("bid", (String)localObject4);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(this.a);
      ((StringBuilder)localObject5).append("");
      ((Bundle)localObject2).putString("num", ((StringBuilder)localObject5).toString());
      localObject5 = new StringBuilder();
      int j = this.b;
      int i = j;
      if (j <= 0) {
        i = 0;
      }
      ((StringBuilder)localObject5).append(i);
      ((StringBuilder)localObject5).append("");
      ((Bundle)localObject2).putString("start", ((StringBuilder)localObject5).toString());
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("uin=o");
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append(";skey=");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((Bundle)localObject2).putString("Cookie", ((StringBuilder)localObject5).toString());
      ((Bundle)localObject2).putString("Referer", String.format("https://buluo.qq.com/mobile/barindex.html?bid=%s&scene=detail_titleNav&_wv=1027", new Object[] { localObject4 }));
      localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext;
      localObject3 = this.this$0.jdField_a_of_type_ComTencentWidgetXListView;
      localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter;
      localObject5 = HotChatPie.a(this.this$0);
      TextView localTextView = this.this$0.j;
      if (this.b == 0) {
        i = 1;
      } else {
        i = 2;
      }
      new HttpCgiAsyncTask("https://buluo.qq.com/cgi-bin/bar/post/get_post_from_reliao", "GET", new HotChatPie.GetPostListCallBack((Context)localObject1, (XListView)localObject3, (IHotChatPostListAdapter)localObject4, (PullRefreshHeader)localObject5, localTextView, i)).a((Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */