import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatSso.TItem;
import com.tencent.mobileqq.flashchat.FlashChatSso.TSsoCmd0x1Rsp;
import com.tencent.mobileqq.flashchat.FlashChatSso.TSsoReq;
import com.tencent.mobileqq.flashchat.FlashChatSso.TSsoRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aumd
  extends MSFServlet
{
  public static ArrayList<FlashChatItem> a(byte[] paramArrayOfByte)
  {
    try
    {
      FlashChatSso.TSsoRsp localTSsoRsp = new FlashChatSso.TSsoRsp();
      localTSsoRsp.mergeFrom(paramArrayOfByte);
      if (localTSsoRsp.st_cmd0x1_rsp.has())
      {
        paramArrayOfByte = new ArrayList();
        int i = 0;
        while (i < localTSsoRsp.st_cmd0x1_rsp.item.size())
        {
          FlashChatSso.TItem localTItem = (FlashChatSso.TItem)localTSsoRsp.st_cmd0x1_rsp.item.get(i);
          FlashChatItem localFlashChatItem = new FlashChatItem();
          localFlashChatItem.id = localTItem.i32_id.get();
          localFlashChatItem.feedType = localTItem.uint32_feetype.get();
          localFlashChatItem.name = localTItem.string_name.get();
          localFlashChatItem.appName = localTItem.string_app_name.get();
          localFlashChatItem.iconUrl = localTItem.string_icon_url.get();
          localFlashChatItem.mainView = localTItem.string_main_view.get();
          localFlashChatItem.ver = localTItem.string_ver.get();
          localFlashChatItem.color = localTItem.string_bg_color.get();
          paramArrayOfByte.add(localFlashChatItem);
          i += 1;
        }
        return paramArrayOfByte;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool;
    int i;
    Bundle localBundle;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      i = paramIntent.getIntExtra("req_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "onReceive cmd:" + i);
      }
      localBundle = new Bundle();
      if (!bool) {}
    }
    do
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        switch (i)
        {
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          Object localObject;
          paramFromServiceMsg.printStackTrace();
        }
      }
      notifyObserver(paramIntent, 967, false, localBundle, auly.class);
      return;
      bool = paramFromServiceMsg.isSuccess();
      break;
      localObject = a(paramFromServiceMsg);
    } while (localObject == null);
    ((FlashChatManager)getAppRuntime().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((ArrayList)localObject, true, paramFromServiceMsg);
    notifyObserver(paramIntent, 967, bool, localBundle, auly.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "onSend cmd:" + i);
    }
    switch (i)
    {
    }
    do
    {
      return;
      paramIntent = new FlashChatSso.TSsoReq();
      paramIntent.i32_cmd.set(1);
      paramIntent.i32_implat.set(109);
      paramIntent.str_qq_ver.set("8.4.10");
      paramIntent = paramIntent.toByteArray();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramIntent.length + 4);
      localByteBuffer.putInt(paramIntent.length + 4).put(paramIntent);
      paramIntent = localByteBuffer.array();
      paramPacket.setSSOCommand("Flashchat.OpReq");
      paramPacket.putSendData(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FlashChat", 2, "FlashChatServlet onSend ssoCmd:" + "Flashchat.OpReq");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumd
 * JD-Core Version:    0.7.0.1
 */