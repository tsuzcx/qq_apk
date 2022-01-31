import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class aoww
  extends aowp
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ayqd jdField_a_of_type_Ayqd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public aoww(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, ayqd paramayqd, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Ayqd = paramayqd;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ayqd == null) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_Ayqd.g)) || (!this.jdField_a_of_type_Ayqd.g.endsWith(".mp4"))) {
      return;
    }
    String str2 = "3";
    String str1 = str2;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      str1 = str2;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) {
        str1 = "1";
      }
    }
    ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(0), 1, "3", str1);
  }
  
  protected int a()
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_Ayqd != null) {
      if ((this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 1) && (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 8))
      {
        i = j;
        if (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 0) {}
      }
      else
      {
        i = 2;
      }
    }
    return i;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_Ayqd != null) {
      return this.jdField_a_of_type_Ayqd.jdField_c_of_type_Long;
    }
    return 0L;
  }
  
  public Intent a()
  {
    if (!apdh.a(this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).b();
    }
    switch (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int)
    {
    default: 
      localObject1 = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayqd.g)) {
        localObject1 = this.jdField_a_of_type_Ayqd.g;
      }
      Object localObject2 = new ayqd();
      ((ayqd)localObject2).g = ((String)localObject1);
      ((ayqd)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString;
      ((ayqd)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Ayqd.jdField_c_of_type_Long;
      ((ayqd)localObject2).jdField_d_of_type_Long = this.jdField_a_of_type_Ayqd.jdField_d_of_type_Long;
      ((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID;
      ((ayqd)localObject2).jdField_a_of_type_Long = this.jdField_a_of_type_Ayqd.jdField_a_of_type_Long;
      ((ayqd)localObject2).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      ((ayqd)localObject2).h = this.jdField_a_of_type_Ayqd.h;
      ((ayqd)localObject2).e = this.jdField_a_of_type_Ayqd.e;
      ((ayqd)localObject2).f = this.jdField_a_of_type_Ayqd.f;
      ((ayqd)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Ayqd.jdField_b_of_type_JavaLangString;
      ((ayqd)localObject2).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Ayqd.jdField_c_of_type_JavaLangString;
      ((ayqd)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Ayqd.jdField_d_of_type_JavaLangString;
      ((ayqd)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int;
      azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID);
      Object localObject3 = apck.a((ayqd)localObject2);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ((FileManagerEntity)localObject3).selfUin = this.jdField_a_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_Long != 0L) {
        ((FileManagerEntity)localObject3).lastTime = this.jdField_b_of_type_Long;
      }
      ((FileManagerEntity)localObject3).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject3).selfUin);
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject3).nSessionId);
      ((ForwardFileInfo)localObject1).d(4);
      ((ForwardFileInfo)localObject1).b(10006);
      ((ForwardFileInfo)localObject1).a(((ayqd)localObject2).jdField_a_of_type_JavaLangString);
      ((ForwardFileInfo)localObject1).d(((ayqd)localObject2).g);
      ((ForwardFileInfo)localObject1).d(((ayqd)localObject2).jdField_c_of_type_Long);
      ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_Long);
      ((ForwardFileInfo)localObject1).c(((ayqd)localObject2).jdField_a_of_type_Long);
      localObject2 = new Intent();
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject3 = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_Ayqd.i);
        if (localObject3 != null) {
          ((Intent)localObject2).putExtra("leftViewText", ((ayoq)localObject3).jdField_c_of_type_JavaLangString);
        }
      }
      ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("removemementity", true);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("not_forward", true);
      ((Intent)localObject2).putExtra("file_browser_extra_params_uin", String.valueOf(this.jdField_a_of_type_Long));
      if (this.jdField_b_of_type_Long != 0L) {
        ((Intent)localObject2).putExtra("last_time", this.jdField_b_of_type_Long);
      }
      ((Intent)localObject2).putExtra("from_type_troop", this.jdField_a_of_type_Int);
      a();
      return localObject2;
    }
    Object localObject1 = "";
    int i = this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
    if (i < this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString.length()) {
      localObject1 = this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString.substring(i, this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString.length() - 1);
    }
    localObject1 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131631851), new Object[] { azjg.a((String)localObject1) });
    azic.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
    return null;
  }
  
  protected String a()
  {
    if ((this.jdField_a_of_type_Ayqd != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayqd.g))) {
      return this.jdField_a_of_type_Ayqd.g;
    }
    return "";
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Ayqd != null) {
      return this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      paramBundle.putLong("troopfile_shmsgseq", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.shmsgseq);
    }
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  boolean c()
  {
    if ((this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int == 10) || (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID + " status:" + this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int + " resume");
      }
      TroopFileTransferManager.a(this.jdField_a_of_type_Long).c(this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID);
      return true;
    }
    return false;
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_Ayqd == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return false;
              i = apck.a(a());
              if (i == 2) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID + " type is:" + i + " use old filebrowser:");
            return false;
            if (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 12) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileVideo", 1, "id:" + this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID + " is deleted, return false,(check why is here!)");
          return false;
          if ((this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 4) && (this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int != 5)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileVideo", 1, "id:" + this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID + " is forwarding, return false,(check why is here!)");
        return false;
        if (!ayor.a(this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaUtilUUID + " status:" + this.jdField_a_of_type_Ayqd.jdField_b_of_type_Int + " use old browser!");
      return false;
      if ((apdh.b(this.jdField_a_of_type_Ayqd.jdField_a_of_type_JavaLangString)) || (apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoww
 * JD-Core Version:    0.7.0.1
 */