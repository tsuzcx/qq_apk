package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class IntimateInfoView$13
  extends IntimateInfoObserver
{
  IntimateInfoView$13(IntimateInfoView paramIntimateInfoView) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList)
  {
    if (paramBoolean)
    {
      paramArrayList = IntimateInfoView.a(this.a).obtainMessage();
      paramArrayList.what = 9;
      paramArrayList.obj = null;
      IntimateInfoView.a(this.a).removeMessages(9);
      IntimateInfoView.a(this.a).sendMessage(paramArrayList);
      return;
    }
    paramArrayList = IntimateInfoView.a(this.a).obtainMessage();
    paramArrayList.what = 10;
    paramArrayList.obj = null;
    IntimateInfoView.a(this.a).sendMessage(paramArrayList);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) || (!paramBoolean))
    {
      QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    this.a.c();
  }
  
  public void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mViewDelegate == null:" + IntimateInfoView.b(this.a));
      }
    } while (IntimateInfoView.b(this.a));
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mode: " + this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      }
    }
    if (paramBoolean)
    {
      paramString = IntimateInfoView.a(this.a).obtainMessage();
      paramString.what = 0;
      paramString.obj = paramIntimateInfo;
      IntimateInfoView.a(this.a).removeMessages(0);
      IntimateInfoView.a(this.a).sendMessage(paramString);
      return;
    }
    paramString = IntimateInfoView.a(this.a).obtainMessage();
    paramString.what = 1;
    paramString.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693477);
    IntimateInfoView.a(this.a).sendMessage(paramString);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    Message localMessage = IntimateInfoView.a(this.a).obtainMessage();
    if (!paramBoolean1)
    {
      localMessage.what = 5;
      IntimateInfoView.a(this.a).sendMessage(localMessage);
      return;
    }
    if (paramBoolean2)
    {
      this.a.c();
      return;
    }
    localMessage.what = 6;
    localMessage.obj = paramString;
    IntimateInfoView.a(this.a).sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null : " + IntimateInfoView.b(this.a));
      }
    } while (IntimateInfoView.b(this.a));
    paramObject = null;
    if ((paramBoolean) && (paramHashMap != null))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue();
        l1 = l2;
      }
      catch (NumberFormatException paramObject)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err ");
        }
      }
    }
    for (paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));; paramHashMap = paramObject)
    {
      if (paramHashMap == null) {
        break label272;
      }
      paramObject = IntimateInfoView.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      IntimateInfoView.a(this.a).removeMessages(0);
      IntimateInfoView.a(this.a).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = IntimateInfoView.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693477);
    IntimateInfoView.a(this.a).sendMessage(paramHashMap);
  }
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onHandleGetLoverIntimateInfo isSuccess = " + paramBoolean + " data = " + paramArrayOfObject);
    }
    if (paramBoolean)
    {
      Message localMessage = IntimateInfoView.a(this.a).obtainMessage();
      localMessage.what = 7;
      localMessage.obj = paramArrayOfObject;
      IntimateInfoView.a(this.a).removeMessages(7);
      IntimateInfoView.a(this.a).sendMessage(localMessage);
      return;
    }
    paramArrayOfObject = IntimateInfoView.a(this.a).obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    IntimateInfoView.a(this.a).sendMessage(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.13
 * JD-Core Version:    0.7.0.1
 */