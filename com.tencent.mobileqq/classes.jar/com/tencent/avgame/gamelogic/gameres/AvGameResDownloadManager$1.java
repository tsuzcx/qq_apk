package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.avgame.config.AvGameConfProcessor.OnGetConfigListener;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.qphone.base.util.QLog;

class AvGameResDownloadManager$1
  implements AvGameConfProcessor.OnGetConfigListener
{
  AvGameResDownloadManager$1(AvGameResDownloadManager paramAvGameResDownloadManager) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConfigFinished result:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AvGameResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = AvGameConfigUtil.a().b();
      String str = AvGameConfigUtil.a().c();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetConfigFinished url:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(str);
        QLog.i("AvGameResDownloadManager", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
      {
        this.a.a(new AvGameResDownloadManager.ResInfo((String)localObject, str));
        return;
      }
      AvGameResDownloadManager.a(this.a).b(110);
      return;
    }
    AvGameResDownloadManager.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */