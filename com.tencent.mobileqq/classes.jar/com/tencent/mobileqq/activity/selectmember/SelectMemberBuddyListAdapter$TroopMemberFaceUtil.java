package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class SelectMemberBuddyListAdapter$TroopMemberFaceUtil
  implements DecodeTaskCompletionListener
{
  protected IFaceDecoder a;
  boolean jdField_a_of_type_Boolean = true;
  
  public SelectMemberBuddyListAdapter$TroopMemberFaceUtil(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter, Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramInt1, paramString, paramInt2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "requestDecodeFace, uin[" + paramString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt1, true, paramByte);
    return ImageUtil.c();
  }
  
  public Bitmap a(TroopMemberInfo paramTroopMemberInfo)
  {
    return a(paramTroopMemberInfo.memberuin, 1, (byte)0, 0);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "onDecodeTaskCompleted, uin[" + paramString + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    SelectMemberBuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter.TroopMemberFaceUtil
 * JD-Core Version:    0.7.0.1
 */