package com.tencent.av.business.manager;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import jfc;

public class BusinessMessageCenter
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private jfc jdField_a_of_type_Jfc;
  
  public BusinessMessageCenter(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Jfc = new jfc(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Jfc);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < 10)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i).a(paramString, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
    case 101: 
    case 6009: 
    case 6103: 
    case 13: 
    case 203: 
      do
      {
        return;
        a(2, null);
        return;
        b(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
        a(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
        a(1, null);
        AVLog.c("BusinessMessageCenter", "create TYPE_NOTIFY_CONNECTED,cost time zzzz:");
        return;
        paramObservable = (String)paramObject[1];
        boolean bool = ((Boolean)paramObject[2]).booleanValue();
        paramObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c;
        long l = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().f;
        QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[END], eventPeerUin[" + paramObservable + "], isQuit[" + bool + "], curPeerUin[" + paramObject + "], relationId[" + l + "]");
      } while ((paramObject != null) && (!paramObject.equalsIgnoreCase(paramObservable)));
      a(3, null);
      return;
    }
    a((String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
  }
  
  public int a(int paramInt, String paramString)
  {
    if (((paramInt == 3) || (paramInt == 1)) && (!((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, paramInt, paramString))) {
      ((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramInt, paramString);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("EMPTY_ITEM")) {
        break label120;
      }
      i = j;
      if (ZimuToolbar.isSupport())
      {
        paramString = (ZimuItem)((EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)).a();
        if ((paramString == null) || (TextUtils.isEmpty(paramString.getId()))) {
          break label397;
        }
        paramString = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
        paramString.c();
        a(Integer.valueOf(6006), "0");
        paramString.b(null);
        a(Integer.valueOf(6010), Integer.valueOf(1));
      }
    }
    label397:
    for (i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(0);
      label120:
      do
      {
        return i;
        i = j;
      } while (!ZimuToolbar.isSupport());
      Object localObject = paramString.split("\\|");
      if (localObject.length > 0) {}
      for (String str = localObject[0];; str = null)
      {
        if (localObject.length > 1) {}
        for (localObject = localObject[1];; localObject = null)
        {
          AVLog.d("BusinessMessageCenter", "onReceivedChangingZimuOfPeer : " + paramString + "|" + str + "|" + (String)localObject);
          paramString = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
          ZimuItem localZimuItem1 = (ZimuItem)paramString.a(str);
          ZimuItem localZimuItem2;
          boolean bool;
          if (localZimuItem1 != null)
          {
            localZimuItem2 = (ZimuItem)paramString.a();
            if (localZimuItem2 == null)
            {
              bool = false;
              if (bool) {
                break label380;
              }
              paramString.a(false, (String)localObject);
              paramString.b(str);
              if (!localZimuItem1.isUsable()) {
                paramString.a(localZimuItem1);
              }
              a(Integer.valueOf(6005), str);
              if (localZimuItem2 != null) {
                break label375;
              }
              i = 3;
              label302:
              a(Integer.valueOf(6010), Integer.valueOf(i));
              j = i;
              if (!ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication())) {
                a(Integer.valueOf(6012), Integer.valueOf(i));
              }
            }
          }
          label375:
          label380:
          for (j = i;; j = 0)
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(0);
            return j;
            bool = localZimuItem2.getId().equalsIgnoreCase(localZimuItem1.getId());
            break;
            i = 2;
            break label302;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() + "";
    int i = 0;
    while (i < 10)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i).a(paramInt, str, paramString);
      }
      i += 1;
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    AVLog.c("BusinessMessageCenter", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public int b(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while (((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(0, paramInt, paramString));
      a(paramString);
      return 0;
    } while (((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(0, paramInt, paramString));
    String str = paramString;
    if (paramString.equals("。")) {
      str = "。 ";
    }
    paramString = new SentenceInfo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c, str, str, 2);
    paramString.a = true;
    a(Integer.valueOf(6008), paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessMessageCenter
 * JD-Core Version:    0.7.0.1
 */