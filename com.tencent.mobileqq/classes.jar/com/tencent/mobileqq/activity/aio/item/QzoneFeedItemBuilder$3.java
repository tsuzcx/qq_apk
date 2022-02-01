package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneReq;
import java.util.HashMap;
import mqq.app.NewIntent;

class QzoneFeedItemBuilder$3
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  boolean jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
  
  QzoneFeedItemBuilder$3(QzoneFeedItemBuilder paramQzoneFeedItemBuilder, boolean paramBoolean, int paramInt1, QzoneFeedItemBuilder.Holder paramHolder, String paramString, int paramInt2, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Boolean ^= true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder$Holder.i.setText(QzoneFeedItemBuilder.a(this.jdField_a_of_type_Int));
    }
    else
    {
      this.jdField_a_of_type_Int -= 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder$Holder.i.setText(QzoneFeedItemBuilder.a(this.jdField_a_of_type_Int));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder$Holder.d;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2130847755;
    } else {
      i = 2130847754;
    }
    ((ImageView)localObject1).setImageResource(i);
    localObject1 = ((IQzoneReq)QRoute.api(IQzoneReq.class)).getLikeIntent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getApplication(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getLongAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.c);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("like_key", this.jdField_a_of_type_Boolean);
    ((NewIntent)localObject1).putExtras((Bundle)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.startServlet((NewIntent)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed;
    ((MessageForQzoneFeed)localObject1).ulikeNum = this.jdField_a_of_type_Int;
    if (((MessageForQzoneFeed)localObject1).mapExt == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt = new HashMap();
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt;
    if (this.jdField_a_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((HashMap)localObject2).put("isliked", localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, false);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getMessageFacade();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed;
    ((QQMessageFacade)localObject1).a((MessageRecord)localObject2, ((MessageForQzoneFeed)localObject2).selfuin);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */