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

public class bazf
  implements Handler.Callback
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public bazf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(ThreadManager.getFileThreadLooper(), this);
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
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukp.b(paramSetting);
    localaukp.a();
  }
  
  public void a(ArrayList<String> paramArrayList, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    aukr localaukr = localaukp.a();
    localaukr.a();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)localaukp.a(Setting.class, (String)paramArrayList.get(i));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = paramLong;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting);
          localaukp.a(localSetting);
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      localaukr.c();
      localaukr.b();
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
 * Qualified Name:     bazf
 * JD-Core Version:    0.7.0.1
 */