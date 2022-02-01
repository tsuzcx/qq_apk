package com.tencent.mobileqq.activity;

import aebq;
import android.text.TextUtils;
import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

public class FriendProfilePhotoHelper$1
  implements Runnable
{
  public FriendProfilePhotoHelper$1(aebq paramaebq) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (anvk)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = ((anvk)localObject1).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject2 == null) {
        return;
      }
      if (((Card)localObject2).checkCoverUrl(this.this$0.jdField_a_of_type_ArrayOfByte)) {
        ((Card)localObject2).updateCoverData(this.this$0.jdField_a_of_type_ArrayOfByte);
      }
      ((anvk)localObject1).a((Card)localObject2);
      localObject1 = ((Card)localObject2).getCoverData(this.this$0.jdField_a_of_type_Int);
      localObject2 = (String)localObject1[0];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(this.this$0.b)))
      {
        this.this$0.b = ((String)localObject2);
        this.this$0.jdField_a_of_type_Int = ((Integer)localObject1[1]).intValue();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1
 * JD-Core Version:    0.7.0.1
 */