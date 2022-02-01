package com.tencent.av.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ShareChat$1
  implements ShareChat.SharePanel.IHandle
{
  ShareChat$1(ShareChat paramShareChat, long paramLong) {}
  
  public int a()
  {
    return 99;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Long;
  }
  
  public Bitmap a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString, (byte)3, false, false);
  }
  
  public TroopInfoData a()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
  }
  
  public String a()
  {
    return ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString);
  }
  
  public String a(int paramInt)
  {
    return null;
  }
  
  public String a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return null;
    }
    String str = ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat, paramInt);
    if (TextUtils.isEmpty(str))
    {
      ShareChat localShareChat = this.jdField_a_of_type_ComTencentAvShareShareChat;
      localShareChat.a(paramLong, localShareChat.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Int);
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinish, choosedChannel[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], choosedLinkType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], result[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    ShareChatReport.a(paramInt1, paramInt2);
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, 99, null);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQRForward, choosedChannel[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], choosedLinkType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], result[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (paramInt3 == 2) {
      ShareChatReport.a(paramInt1, paramInt2, 99, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.1
 * JD-Core Version:    0.7.0.1
 */