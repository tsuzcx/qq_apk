import android.app.Activity;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apzg
{
  public static apyv a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      return new ArkHeaderView(paramActivity, null);
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int n;
      int i1;
      try
      {
        paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (paramMessageRecord != null) {
          break label247;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("QQGamePubHeaderFactory", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
        return null;
      }
      if (n < paramMessageRecord.size())
      {
        if (!(paramMessageRecord.get(n) instanceof awum)) {
          break label269;
        }
        ArrayList localArrayList = ((awum)paramMessageRecord.get(n)).a;
        k = i;
        i = j;
        i1 = 0;
        j = k;
        k = j;
        m = i;
        if (i1 >= localArrayList.size()) {
          break label275;
        }
        if ((localArrayList.get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k != 0) && (j != 0))
          {
            paramMessageRecord = new ImgHeaderView(paramActivity);
            return paramMessageRecord;
          }
        }
        else
        {
          k = i;
          if (!(localArrayList.get(i1) instanceof awwo)) {
            continue;
          }
          j = 1;
          k = i;
          continue;
        }
      }
      else
      {
        if (paramMessageRecord.size() != 2) {
          continue;
        }
        paramMessageRecord = new TextHeaderView(paramActivity);
        return paramMessageRecord;
        if ((paramMessageRecord instanceof MessageForPubAccount)) {
          return new ImgHeaderView(paramActivity);
        }
        return new MoreMsgHeaderView(paramActivity);
        label247:
        n = 0;
        i = 0;
        j = 0;
        continue;
      }
      i1 += 1;
      int i = k;
      continue;
      label269:
      int m = j;
      int k = i;
      label275:
      n += 1;
      int j = m;
      i = k;
    }
  }
  
  public static apyv a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity)
  {
    if (paramQQGameMsgInfo == null) {
      return new MoreMsgHeaderView(paramActivity);
    }
    if (paramQQGameMsgInfo.msgType == 1) {
      return new GameArkView(paramActivity, null);
    }
    if (paramQQGameMsgInfo.msgType == 2) {
      return new ImgHeaderView(paramActivity);
    }
    if (paramQQGameMsgInfo.msgType == 3) {
      return new TextHeaderView(paramActivity);
    }
    return new MoreMsgHeaderView(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzg
 * JD-Core Version:    0.7.0.1
 */