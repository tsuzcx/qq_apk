package com.tencent.mobileqq.activity.contacts.fragment;

import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wlf;

public class TroopFragment$MyTroopObserver
  extends TroopObserver
{
  protected TroopFragment$MyTroopObserver(TroopFragment paramTroopFragment) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.h();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.h();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.h();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.b();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener.a(1, paramBoolean, null);
      }
    }
    ThreadManager.getUIHandler().postDelayed(new wlf(this), 500L);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.TroopFragment.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */