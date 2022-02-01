package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import com.tencent.av.AVLog;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class MagicFaceDataEntity$MyDataObserver
  implements Observer
{
  private WeakReference<MagicFaceDataEntity> a;
  
  MagicFaceDataEntity$MyDataObserver(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    this.a = new WeakReference(paramMagicFaceDataEntity);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.get() != null)
    {
      paramObservable = ((MagicFaceDataEntity)this.a.get()).b;
      if (paramObject != null)
      {
        Object localObject = (Object[])paramObject;
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          int j = ((Integer)localObject[0]).intValue();
          if ((j == 130) || (j == 131) || (j == 132))
          {
            if ((j == 131) || (j == 132)) {
              i = 500;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("MagicFaceDataEntity update :");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(i);
            AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
            paramObservable.sendMessageDelayed(paramObservable.obtainMessage(1, paramObject), i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.MyDataObserver
 * JD-Core Version:    0.7.0.1
 */