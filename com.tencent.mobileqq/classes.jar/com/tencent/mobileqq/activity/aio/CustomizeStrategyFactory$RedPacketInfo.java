package com.tencent.mobileqq.activity.aio;

import aghh;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$RedPacketInfo
  extends RedPacketInfoBase
{
  public int a;
  public long a;
  public aghh a;
  public Bitmap a;
  public MessageRecord a;
  public String a;
  public boolean a;
  public Drawable[] a;
  public String b;
  public boolean b;
  public boolean c;
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForQQWalletMsg)) {
      return ((MessageForQQWalletMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getIsHideTitleDefault();
    }
    return 0;
  }
  
  public boolean a()
  {
    Object localObject2 = null;
    if ((this.b) && (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable.length > 0) && (this.jdField_a_of_type_Aghh != null) && (this.jdField_a_of_type_Aghh.b > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "anim valid");
      }
      return true;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("anim invalid|").append(this.b).append("|");
      if (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable == null) {
        break label151;
      }
    }
    label151:
    for (Object localObject1 = Integer.valueOf(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable.length);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append("|");
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Aghh != null) {
        localObject1 = Integer.valueOf(this.jdField_a_of_type_Aghh.b);
      }
      QLog.d("CustomizeStrategyFactory", 2, localObject1);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo
 * JD-Core Version:    0.7.0.1
 */