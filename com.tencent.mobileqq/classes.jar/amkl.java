import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class amkl
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addDatingSafetyGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + bdeu.a(paramString2));
    }
    long l = ayzl.a();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)azaf.a(-1028);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, -1028, paramInt, l);
    localMessageForGrayTips.isread = true;
    if (!alww.a(paramQQAppInterface, localMessageForGrayTips)) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArrayList<GrayTipsSpan> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + bdeu.a(paramString2));
    }
    if ((paramBoolean1) && (abti.e(paramInt)) && (QLog.isColorLevel())) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
    }
    long l = ayzl.a();
    if (paramBoolean1) {}
    for (int i = -5001;; i = -5000)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString1, paramInt);
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)azaf.a(i);
      localMessageForNewGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, i, paramInt, l);
      if (localMessage != null) {
        localMessageForNewGrayTips.shmsgseq = localMessage.shmsgseq;
      }
      localMessageForNewGrayTips.isread = paramBoolean3;
      localMessageForNewGrayTips.spans = paramArrayList;
      localMessageForNewGrayTips.updateMsgData();
      if ((!paramBoolean2) || (!alww.a(paramQQAppInterface, localMessageForNewGrayTips, false))) {
        paramQQAppInterface.a().a(localMessageForNewGrayTips, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt, null, paramBoolean1, paramBoolean2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkl
 * JD-Core Version:    0.7.0.1
 */