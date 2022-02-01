package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;

class CTEntryMng$5
  extends CardObserver
{
  CTEntryMng$5(CTEntryMng paramCTEntryMng) {}
  
  private void a(short paramShort1, short paramShort2)
  {
    if ((paramShort1 == -23447) && (CTEntryMng.a(this.a) != null))
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)CTEntryMng.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localFriendListHandler != null)
      {
        localFriendListHandler.notifyUI(110, true, null);
        if (paramShort2 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
          }
          localFriendListHandler.getMayKnowRecommend(null, null, 6, null);
          return;
        }
        this.a.b(false);
      }
    }
  }
  
  private void a(short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel())
    {
      Object localObject1 = "";
      int i = 0;
      while ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        Object localObject2 = localObject1;
        if (QLog.isColorLevel()) {
          localObject2 = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { localObject1, Short.valueOf(s), localShort });
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", new Object[] { localObject1 }));
      }
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      Object localObject1 = "";
      int i = 0;
      boolean bool;
      for (paramBoolean = false; (paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length); paramBoolean = bool)
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        CTEntryMng.EntryUserSetting localEntryUserSetting = CTEntryMng.a(this.a, s);
        bool = paramBoolean;
        if (localEntryUserSetting != null)
        {
          bool = paramBoolean;
          if (localShort != null)
          {
            bool = paramBoolean;
            if (localEntryUserSetting.c != localShort.shortValue())
            {
              localEntryUserSetting.c = localShort.shortValue();
              bool = true;
            }
          }
        }
        Object localObject2 = localObject1;
        if (localEntryUserSetting != null)
        {
          localObject2 = localObject1;
          if (QLog.isColorLevel()) {
            localObject2 = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { localObject1, Short.valueOf(s), localShort });
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (paramBoolean)
      {
        CTEntryMng.e(this.a);
        CTEntryMng.d(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 }));
      }
    }
    else
    {
      a(paramArrayOfShort, paramMap);
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    if (paramBoolean)
    {
      CTEntryMng.EntryUserSetting localEntryUserSetting = CTEntryMng.a(this.a, paramShort1);
      if ((localEntryUserSetting != null) && (localEntryUserSetting.c != paramShort2))
      {
        localEntryUserSetting.c = paramShort2;
        CTEntryMng.e(this.a);
        CTEntryMng.d(this.a);
        a(paramShort1, paramShort2);
      }
      if ((localEntryUserSetting != null) && (QLog.isColorLevel())) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.5
 * JD-Core Version:    0.7.0.1
 */