import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class aujb
  extends aujd<MessageForPtt>
{
  public aujb(MessageForPtt paramMessageForPtt)
  {
    super(paramMessageForPtt);
  }
  
  protected int a()
  {
    return 3;
  }
  
  public List<MsgBackupResEntity> a()
  {
    MsgBackupResEntity localMsgBackupResEntity = a();
    localMsgBackupResEntity.msgSubType = 15;
    localMsgBackupResEntity.filePath = ((MessageForPtt)this.a).getLocalFilePath();
    if (!a(localMsgBackupResEntity.filePath)) {
      return null;
    }
    a(localMsgBackupResEntity.filePath, localMsgBackupResEntity);
    Object localObject = a(15);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.a).selfuin);
    ((HashMap)localObject).put("uuid", ((MessageForPtt)this.a).urlAtServer);
    ((HashMap)localObject).put("md5", ((MessageForPtt)this.a).md5);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.a).selfuin);
    if (((MessageForPtt)this.a).istroop == 1) {
      ((HashMap)localObject).put("chatType", "1");
    }
    for (;;)
    {
      localMsgBackupResEntity.extraDataStr = a((Map)localObject);
      localObject = new ArrayList();
      ((List)localObject).add(localMsgBackupResEntity);
      return localObject;
      if (((MessageForPtt)this.a).istroop == 3000) {
        ((HashMap)localObject).put("chatType", "2");
      } else {
        ((HashMap)localObject).put("chatType", "3");
      }
    }
  }
  
  public void a()
  {
    Object localObject = (MessageForPtt)this.a;
    a("packMsg uinType:" + ((MessageForPtt)localObject).istroop);
    localObject = ((MessageForPtt)this.a).getRichText();
    ((MessageForPtt)this.a).richText = ((im_msg_body.RichText)localObject);
  }
  
  public void b()
  {
    ((MessageForPtt)this.a).url = aujc.a(((MessageForPtt)this.a).md5, ((MessageForPtt)this.a).selfuin);
    if (((MessageForPtt)this.a).isSendFromLocal()) {
      ((MessageForPtt)this.a).issend = 2;
    }
    ((MessageForPtt)this.a).isReadPtt = true;
    ((MessageForPtt)this.a).serial();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujb
 * JD-Core Version:    0.7.0.1
 */