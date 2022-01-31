package com.tencent.mobileqq.app.upgrade;

import ajuf;
import akbv;
import akva;
import android.content.SharedPreferences;
import android.text.TextUtils;
import awzw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$1
  implements Runnable
{
  public UpgradeController$1(akva paramakva, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if ((akva.a(this.this$0) == null) || (akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.e.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeConfigManager", 2, "config do not allow to tip");
                return;
                if (awzw.a() >= akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.b / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeConfigManager", 2, "want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)akva.a(this.this$0).getRuntime();
            } while (localObject == null);
            if ((this.this$0.a() != 4) || (!this.this$0.b())) {
              break;
            }
          } while ((akva.a(this.this$0) == null) || (TextUtils.isEmpty(akva.a(this.this$0).l)));
          akva.a(this.this$0, true);
          localObject = new File(akva.a(this.this$0).l);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeConfigManager", 2, "the jacked apk has been removed.");
      return;
      localSharedPreferences = ((QQAppInterface)localObject).getPreferences();
      if (!ajuf.b((QQAppInterface)localObject))
      {
        if ((localSharedPreferences.getLong("upgrade_tip_time", 0L) == 0L) && (this.a))
        {
          this.this$0.a((QQAppInterface)localObject, false);
          return;
        }
        this.this$0.a((QQAppInterface)localObject);
        return;
      }
    } while ((akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1));
    if (localSharedPreferences.getLong("upgrade_tip_time", 0L) == 0L) {
      i = 1;
    }
    if (i != 0)
    {
      this.this$0.a((QQAppInterface)localObject, true);
      return;
    }
    this.this$0.a((QQAppInterface)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeController.1
 * JD-Core Version:    0.7.0.1
 */