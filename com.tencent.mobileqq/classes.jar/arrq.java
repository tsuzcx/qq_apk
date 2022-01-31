import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class arrq
  extends arrp<MessageForShortVideo>
{
  public arrq(MessageForShortVideo paramMessageForShortVideo)
  {
    super(paramMessageForShortVideo);
  }
  
  protected int a()
  {
    return 2;
  }
  
  protected MsgBackupResEntity a(String paramString, int paramInt)
  {
    if (!a(paramString)) {
      return null;
    }
    MsgBackupResEntity localMsgBackupResEntity = a();
    localMsgBackupResEntity.msgSubType = paramInt;
    localMsgBackupResEntity.filePath = paramString;
    a(paramString, localMsgBackupResEntity);
    paramString = a(paramInt);
    paramString.put("selfuin", ((MessageForShortVideo)this.a).selfuin);
    paramString.put("md5", ((MessageForShortVideo)this.a).md5);
    paramString.put("thumbMd5", ((MessageForShortVideo)this.a).thumbMD5);
    localMsgBackupResEntity.extraDataStr = a(paramString);
    return localMsgBackupResEntity;
  }
  
  public List<MsgBackupResEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ShortVideoUtils.a((MessageForShortVideo)this.a, "mp4");
    Object localObject1 = ShortVideoUtils.a(((MessageForShortVideo)this.a).thumbMD5, "jpg");
    int j;
    int i;
    if ((this.a instanceof MessageForLightVideo))
    {
      j = 6;
      i = 9;
    }
    for (;;)
    {
      localObject2 = a((String)localObject2, j);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      localObject1 = a((String)localObject1, i);
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      return localArrayList;
      if ((((MessageForShortVideo)this.a).busiType == 0) || (((MessageForShortVideo)this.a).busiType == 1))
      {
        j = 4;
        i = 7;
      }
      else
      {
        if (((MessageForShortVideo)this.a).subBusiType != 2) {
          break;
        }
        j = 5;
        i = 8;
      }
    }
    return null;
  }
  
  public void a()
  {
    im_msg_body.RichText localRichText = ((MessageForShortVideo)this.a).getRichText();
    ((MessageForShortVideo)this.a).richText = localRichText;
  }
  
  public void b()
  {
    if (((MessageForShortVideo)this.a).isSendFromLocal()) {
      ((MessageForShortVideo)this.a).issend = 2;
    }
    if ((this.a instanceof MessageForLightVideo))
    {
      ((MessageForLightVideo)this.a).isLightVideoRead = true;
      ((MessageForShortVideo)this.a).saveExtInfoToExtStr(awav.u, "1");
    }
    ((MessageForShortVideo)this.a).serial();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrq
 * JD-Core Version:    0.7.0.1
 */