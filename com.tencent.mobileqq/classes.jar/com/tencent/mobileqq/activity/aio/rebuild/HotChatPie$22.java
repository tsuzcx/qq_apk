package com.tencent.mobileqq.activity.aio.rebuild;

import aeqb;
import aeqr;
import ainh;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import bbfj;
import bcql;
import bdjd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;
import mqq.manager.TicketManager;

public class HotChatPie$22
  implements Runnable
{
  public HotChatPie$22(aeqb paramaeqb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 1;
    if (!bbfj.g(this.this$0.jdField_a_of_type_AndroidContentContext)) {
      bcql.a(this.this$0.jdField_a_of_type_AndroidContentContext, 1, this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131694611), 0).a();
    }
    while ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    Object localObject1 = (TicketManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject1 != null) {}
    for (localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = null)
    {
      Bundle localBundle = new Bundle();
      Object localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.getTribeId();
      localBundle.putString("bid", (String)localObject3);
      localBundle.putString("num", this.a + "");
      Object localObject4 = new StringBuilder();
      TextView localTextView;
      if (this.b <= 0)
      {
        i = 0;
        localBundle.putString("start", i + "");
        localBundle.putString("Cookie", "uin=o" + (String)localObject2 + ";skey=" + (String)localObject1);
        localBundle.putString("Referer", String.format("https://buluo.qq.com/mobile/barindex.html?bid=%s&scene=detail_titleNav&_wv=1027", new Object[] { localObject3 }));
        localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext;
        localObject2 = this.this$0.jdField_a_of_type_ComTencentWidgetXListView;
        localObject3 = this.this$0.jdField_a_of_type_Ainh;
        localObject4 = aeqb.a(this.this$0);
        localTextView = this.this$0.n;
        if (this.b != 0) {
          break label357;
        }
      }
      label357:
      for (int i = j;; i = 2)
      {
        new bdjd("https://buluo.qq.com/cgi-bin/bar/post/get_post_from_reliao", "GET", new aeqr((Context)localObject1, (XListView)localObject2, (ainh)localObject3, (PullRefreshHeader)localObject4, localTextView, i)).a(localBundle);
        return;
        i = this.b;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.22
 * JD-Core Version:    0.7.0.1
 */