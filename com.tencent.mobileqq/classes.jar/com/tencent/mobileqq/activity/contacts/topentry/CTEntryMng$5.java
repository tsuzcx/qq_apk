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
        localFriendListHandler.notifyUI(112, true, null);
        if (paramShort2 != 0) {
          break label75;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
        }
        localFriendListHandler.getMayKnowRecommend(null, null, 6, null);
      }
    }
    return;
    label75:
    this.a.b(false);
  }
  
  private void a(short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    String str;
    int i;
    if (QLog.isColorLevel())
    {
      str = "";
      i = 0;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
      {
        short s = paramArrayOfShort[i];
        Short localShort = (Short)paramMap.get(Short.valueOf(s));
        if (!QLog.isColorLevel()) {
          break label124;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label124:
    for (;;)
    {
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", new Object[] { str }));
      }
      return;
    }
  }
  
  public void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str;
    int i;
    boolean bool;
    if (paramBoolean)
    {
      str = "";
      i = 0;
      paramBoolean = false;
      if ((paramMap != null) && (paramArrayOfShort != null) && (i < paramArrayOfShort.length))
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
            if (localEntryUserSetting.b != localShort.shortValue())
            {
              localEntryUserSetting.b = localShort.shortValue();
              bool = true;
            }
          }
        }
        if ((localEntryUserSetting == null) || (!QLog.isColorLevel())) {
          break label254;
        }
        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", new Object[] { str, Short.valueOf(s), localShort });
      }
    }
    label254:
    for (;;)
    {
      i += 1;
      paramBoolean = bool;
      break;
      if (paramBoolean)
      {
        CTEntryMng.b(this.a);
        CTEntryMng.a(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", new Object[] { Boolean.valueOf(paramBoolean), str }));
      }
      return;
      a(paramArrayOfShort, paramMap);
      return;
    }
  }
  
  public void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    if (paramBoolean)
    {
      localEntryUserSetting = CTEntryMng.a(this.a, paramShort1);
      if ((localEntryUserSetting != null) && (localEntryUserSetting.b != paramShort2))
      {
        localEntryUserSetting.b = paramShort2;
        CTEntryMng.b(this.a);
        CTEntryMng.a(this.a);
        a(paramShort1, paramShort2);
      }
      if ((localEntryUserSetting != null) && (QLog.isColorLevel())) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
      }
    }
    while (!QLog.isColorLevel())
    {
      CTEntryMng.EntryUserSetting localEntryUserSetting;
      return;
    }
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.5
 * JD-Core Version:    0.7.0.1
 */