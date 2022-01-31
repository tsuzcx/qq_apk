import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aueq
  extends aueu<MessageForPic>
{
  public aueq(MessageForPic paramMessageForPic)
  {
    super(paramMessageForPic);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public List<MsgBackupResEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    int[] arrayOfInt;
    label46:
    int k;
    int i;
    label55:
    int i1;
    MsgBackupResEntity localMsgBackupResEntity;
    if (((MessageForPic)this.a).fileSizeFlag == 1)
    {
      j = 1;
      if (j == 0) {
        break label131;
      }
      arrayOfInt = new int[] { 1, 2, 3 };
      int n = arrayOfInt.length;
      k = 0;
      i = 0;
      if (k >= n) {
        break label389;
      }
      i1 = arrayOfInt[k];
      localMsgBackupResEntity = a();
      localMsgBackupResEntity.msgSubType = i1;
      if (i1 != 1) {
        break label147;
      }
      localObject = "chatraw";
    }
    label90:
    int m;
    for (;;)
    {
      localObject = ((MessageForPic)this.a).getFilePath((String)localObject);
      if (a((String)localObject)) {
        break label176;
      }
      m = i;
      label131:
      label147:
      do
      {
        k += 1;
        i = m;
        break label55;
        j = 0;
        break;
        arrayOfInt = new int[] { 2, 3 };
        break label46;
        if (i1 == 2)
        {
          localObject = "chatimg";
          break label90;
        }
        m = i;
      } while (i1 != 3);
      localObject = "chatthumb";
    }
    label176:
    localMsgBackupResEntity.filePath = ((String)localObject);
    a((String)localObject, localMsgBackupResEntity);
    Object localObject = a(i1);
    ((HashMap)localObject).put("selfuin", ((MessageForPic)this.a).selfuin);
    if (((MessageForPic)this.a).uuid != null) {
      ((HashMap)localObject).put("uuid", ((MessageForPic)this.a).uuid.toUpperCase());
    }
    if (((MessageForPic)this.a).md5 != null) {
      ((HashMap)localObject).put("md5", ((MessageForPic)this.a).md5.toUpperCase());
    }
    if (j != 0)
    {
      ((HashMap)localObject).put("isOriginal", "1");
      label299:
      if (!((MessageForPic)this.a).checkGif()) {
        break label386;
      }
      if ((i1 != 1) && (i1 != 2)) {
        break label372;
      }
      i = 1;
    }
    label386:
    for (;;)
    {
      localMsgBackupResEntity.extraDataStr = a((Map)localObject);
      if (QLog.isColorLevel()) {}
      localArrayList.add(localMsgBackupResEntity);
      m = i;
      break;
      ((HashMap)localObject).put("isOriginal", "0");
      break label299;
      label372:
      if (i != 0) {
        ((HashMap)localObject).put("hasOriginGif", "1");
      }
    }
    label389:
    return localArrayList;
  }
  
  public void a()
  {
    MessageForPic localMessageForPic = (MessageForPic)this.a;
    a("packMsg uinType:" + localMessageForPic.istroop);
    localMessageForPic.richText = localMessageForPic.getRichText();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aueq
 * JD-Core Version:    0.7.0.1
 */