import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aslp
  implements aslb
{
  public aslp() {}
  
  public aslp(QQAppInterface paramQQAppInterface)
  {
    this();
  }
  
  public static asnp a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    switch (paramMsgBackupResEntity.msgType)
    {
    default: 
      return null;
    case 1: 
      return new asns(paramMsgBackupResEntity);
    case 2: 
      return new asnx(paramMsgBackupResEntity);
    }
    return new asnu(paramMsgBackupResEntity);
  }
  
  public static asnv a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      return new asnr((MessageForPic)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return new asnw((MessageForShortVideo)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForPtt)) {
      return new asnt((MessageForPtt)paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      return new asnn(paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      return new asnq((MessageForMixedMsg)paramMessageRecord);
    }
    return null;
  }
  
  public aslo a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = a(paramMsgBackupResEntity);
    if (paramMessageRecord != null) {
      return paramMessageRecord.a();
    }
    return new aslo();
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    return null;
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord != null)
    {
      paramMessageRecord.a();
      Object localObject = paramMessageRecord.a();
      if (QLog.isColorLevel()) {
        paramMessageRecord.a("onExport");
      }
      if (localObject != null)
      {
        paramList.addAll((Collection)localObject);
        if (QLog.isColorLevel())
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (MsgBackupResEntity)paramList.next();
            if (QLog.isColorLevel()) {
              paramMessageRecord.a("export resEntity:" + ((MsgBackupResEntity)localObject).toLogString());
            }
          }
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = a(paramMessageRecord);
      if (paramMessageRecord != null) {
        return paramMessageRecord.a();
      }
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return (paramMsgBackupResEntity.msgType == 1) || (paramMsgBackupResEntity.msgType == 2) || (paramMsgBackupResEntity.msgType == 3);
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    asnv localasnv = a(paramMessageRecord);
    if (localasnv != null)
    {
      if (QLog.isColorLevel()) {
        localasnv.a("onImport,uniseq:" + paramMessageRecord.uniseq + " msg:" + paramMessageRecord);
      }
      localasnv.b();
      if (paramList != null)
      {
        paramMessageRecord = paramList.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramList = a((MsgBackupResEntity)paramMessageRecord.next());
          if (paramList != null) {
            paramList.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aslp
 * JD-Core Version:    0.7.0.1
 */