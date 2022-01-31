package com.tencent.mobileqq.apollo.process.chanel;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;
import ymy;

public class CmGameAccountHandler
  implements FaceDecoder.DecodeTaskCompletionListener
{
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ymy(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map b = new HashMap();
  
  public CmGameAccountHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilMap = null;
    this.b = null;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      switch (paramInt2)
      {
      default: 
        return;
      case 1: 
        localObject = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
        if ((!AvatarTroopUtil.b((String)localObject)) || (!((String)localObject).equals(paramString))) {
          break label133;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_CmGameAccountHandler", 2, "nickName.equals(uin):" + paramString);
        }
        break;
      }
    } while (this.jdField_a_of_type_JavaUtilMap == null);
    this.jdField_a_of_type_JavaUtilMap.put(paramString + "nick", Integer.valueOf(paramInt1));
    return;
    label133:
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_CmGameAccountHandler", 2, "nickName != null:" + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putString("uin", paramString);
    localBundle.putString("nickName", (String)localObject);
    paramString = EIPCResult.createResult(0, localBundle);
    CmGameServerQIPCModule.a().callbackResult(paramInt1, paramString);
    return;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, String.valueOf(paramString), 0, (byte)1);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qwe", 2, "bm != null:" + paramString);
      }
      localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
      localBundle = new Bundle();
      localBundle.putInt("type", 2);
      localBundle.putString("uin", paramString);
      localBundle.putParcelable("head", (Parcelable)localObject);
      paramString = EIPCResult.createResult(0, localBundle);
      CmGameServerQIPCModule.a().callbackResult(paramInt1, paramString);
      return;
    }
    if (this.b != null) {
      this.b.put(paramString + "head", Integer.valueOf(paramInt1));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, false, 1, true, (byte)0, 1);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qwe", 2, "onDecodeTaskCompleted:" + paramString);
      }
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      if ((this.b != null) && (this.b.get(paramString + "head") != null))
      {
        paramInt1 = ((Integer)this.b.remove(paramString + "head")).intValue();
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 2);
        localBundle.putString("uin", paramString);
        localBundle.putParcelable("head", paramBitmap);
        paramString = EIPCResult.createResult(0, localBundle);
        CmGameServerQIPCModule.a().callbackResult(paramInt1, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAccountHandler
 * JD-Core Version:    0.7.0.1
 */