import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

class aszr
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aszt(this);
  private atff jdField_a_of_type_Atff = new aszs(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<atfe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<atfe> b = new ArrayList();
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.gvideo.message.communicate.qq2gvideo");
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    atfz localatfz = (atfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.b = paramIntent.getStringExtra("closeRoomGroupOwnerUin");
    localNewTogetherRoomMessageData.a = paramIntent.getStringExtra("closeRoomGroupUin");
    localatfz.a(paramIntent.getStringExtra("closeRoomFrom"), localNewTogetherRoomMessageData);
  }
  
  private void a(Intent paramIntent, List<atfe> paramList)
  {
    int i;
    String str;
    StringBuilder localStringBuilder;
    if (!paramList.isEmpty())
    {
      i = paramIntent.getIntExtra("callback_return_code", 0);
      str = paramIntent.getStringExtra("callback_return_message");
      paramIntent = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramIntent.hasNext()) {
        ((atfe)paramIntent.next()).a(i, str);
      }
      localStringBuilder = new StringBuilder().append("receive ");
      if (paramList != this.jdField_a_of_type_JavaUtilList) {
        break label130;
      }
    }
    label130:
    for (paramIntent = "close";; paramIntent = "open")
    {
      QLog.i("GroupVideoManager|Communicate", 2, paramIntent + " room message " + i + " " + str);
      paramList.clear();
      return;
    }
  }
  
  private void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, int paramInt)
  {
    Intent localIntent = a();
    localIntent.putExtra("command_type", paramInt);
    localIntent.putExtra("togetherRoomMessageData", paramNewTogetherRoomMessageData);
    b(localIntent);
  }
  
  private void b()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
    {
      localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Intent localIntent = a();
      localIntent.putExtra("command_type", 6);
      localIntent.putExtra("sKeyKey", (String)localObject);
      b(localIntent);
      return;
    }
    QLog.e("GroupVideoManager|Communicate", 1, "get skey error");
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramIntent);
  }
  
  public atff a()
  {
    return this.jdField_a_of_type_Atff;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.b.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  void a(Bundle paramBundle, atfe paramatfe)
  {
    Intent localIntent = a();
    localIntent.putExtra("command_type", 4);
    localIntent.putExtra("closeRoomBundle", paramBundle);
    b(localIntent);
    this.jdField_a_of_type_JavaUtilList.add(paramatfe);
  }
  
  void a(atfe paramatfe)
  {
    this.b.add(paramatfe);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("com.tencent.gvideo.message.communicate.gvideo2qq");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszr
 * JD-Core Version:    0.7.0.1
 */