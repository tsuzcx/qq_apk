import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x971.oidb_0x971.NoticeInfo;
import tencent.im.oidb.cmd0x971.oidb_0x971.RspBody;

public abstract class aoiz
  extends nkq
{
  public aoiz()
  {
    super(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_0x971.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.notices.has())
        {
          paramArrayOfByte = new ArrayList();
          paramBundle = paramBundle.notices.get().iterator();
          while (paramBundle.hasNext())
          {
            oidb_0x971.NoticeInfo localNoticeInfo = (oidb_0x971.NoticeInfo)paramBundle.next();
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = new TroopAioKeywordTipInfo();
            localTroopAioKeywordTipInfo.ruleId = localNoticeInfo.rule_id.get();
            localTroopAioKeywordTipInfo.title = localNoticeInfo.title.get();
            localTroopAioKeywordTipInfo.summary = localNoticeInfo.summary.get();
            localTroopAioKeywordTipInfo.url = localNoticeInfo.url.get();
            localTroopAioKeywordTipInfo.icon = localNoticeInfo.icon.get();
            localTroopAioKeywordTipInfo.version = localNoticeInfo.version.get();
            paramArrayOfByte.add(localTroopAioKeywordTipInfo);
          }
          a(true, paramArrayOfByte);
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("TroopHandler", 1, "KeywordTipInfoObserver, e=" + paramArrayOfByte.toString());
        a(false, null);
        return;
      }
    }
    for (;;)
    {
      return;
      QLog.i("TroopHandler", 1, "KeywordTipInfoObserver, errorCode=" + paramInt);
      a(false, null);
      return;
      paramArrayOfByte = null;
    }
  }
  
  protected abstract void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoiz
 * JD-Core Version:    0.7.0.1
 */