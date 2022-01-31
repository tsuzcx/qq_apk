import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class bayr
  implements Handler.Callback
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public bayr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(ThreadManager.getFileThreadLooper(), this);
  }
  
  public Setting a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
  }
  
  public String a()
  {
    return ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("headType", paramInt1);
    localBundle.putString("id", paramString);
    localBundle.putInt("idType", paramInt2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void a(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSetting);
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukn.b(paramSetting);
    localaukn.a();
  }
  
  public void a(ArrayList<String> paramArrayList, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    aukp localaukp = localaukn.a();
    localaukp.a();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)localaukn.a(Setting.class, (String)paramArrayList.get(i));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = paramLong;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting);
          localaukn.a(localSetting);
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      localaukp.c();
      localaukp.b();
    }
  }
  
  public String b()
  {
    return ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage.what = 4139;
      ConnectNearbyProcService.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayr
 * JD-Core Version:    0.7.0.1
 */