package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class TroopActivity$6
  extends StrangerObserver
{
  TroopActivity$6(TroopActivity paramTroopActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField != null)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        while (paramPBRepeatMessageField.hasNext())
        {
          oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ondelete: uin ");
          ((StringBuilder)localObject).append(localDelResult.uin.get());
          QLog.d("TroopActivity", 2, ((StringBuilder)localObject).toString());
          if (this.a.q != null)
          {
            int i = 0;
            while (i < this.a.q.size())
            {
              localObject = (Stranger)this.a.q.get(i);
              if (((Stranger)localObject).uin.equals(String.valueOf(localDelResult.uin.get()))) {
                this.a.q.remove(localObject);
              }
              i += 1;
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopActivity", 2, "onDelete is failed");
    }
  }
  
  public void a(boolean paramBoolean, List<Stranger> paramList)
  {
    if (paramBoolean)
    {
      if (paramList != null)
      {
        this.a.q.clear();
        this.a.q.addAll(paramList);
        paramList = new StringBuilder();
        paramList.append("onGetListRemote :");
        paramList.append(this.a.q.size());
        QLog.d("TroopActivity", 2, paramList.toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopActivity", 2, "onGetListRemote is failed");
    }
  }
  
  public void b(boolean paramBoolean, List<Stranger> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.a.q.clear();
      this.a.q.addAll(paramList);
      paramList = new StringBuilder();
      paramList.append("onGetListLocal :");
      paramList.append(this.a.q.size());
      QLog.d("TroopActivity", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.6
 * JD-Core Version:    0.7.0.1
 */