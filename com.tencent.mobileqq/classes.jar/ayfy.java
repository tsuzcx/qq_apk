import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class ayfy
{
  public static ayfy a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<MessageRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private ayfy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static ayfy a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Ayfy == null) {}
    try
    {
      if (jdField_a_of_type_Ayfy == null) {
        jdField_a_of_type_Ayfy = new ayfy(paramQQAppInterface);
      }
      return jdField_a_of_type_Ayfy;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() <= 0) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localQQAppInterface == null) || (localQQAppInterface.a.a() != 1));
    ThreadManager.postImmediately(new TeamWorkUtils.ProcessTDFileScheduler.1(this, localQQAppInterface), null, true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    label190:
    do
    {
      do
      {
        for (;;)
        {
          return;
          Object localObject1;
          if ((paramMessageRecord instanceof MessageForStructing))
          {
            localObject1 = (MessageForStructing)paramMessageRecord;
            if ((((MessageForStructing)localObject1).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgUrl)) && (apej.a(((MessageForStructing)localObject1).structingMsg.mMsgUrl))) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
            }
          }
          else
          {
            if (!(paramMessageRecord instanceof MessageForArkApp)) {
              break label190;
            }
            localObject1 = (MessageForArkApp)paramMessageRecord;
            Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              try
              {
                localObject2 = new JSONObject(new JSONObject((String)localObject2).getString(((MessageForArkApp)localObject1).ark_app_message.appView));
                localObject1 = ((JSONObject)localObject2).optString("appid");
                localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
                if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(String.valueOf(ayfx.a)))) || ((!TextUtils.isEmpty((CharSequence)localObject2)) && (apej.a((String)localObject2))))
                {
                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
                  return;
                }
              }
              catch (JSONException paramMessageRecord) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e(ayed.i, 2, paramMessageRecord.getMessage());
      return;
    } while ((!(paramMessageRecord instanceof MessageForText)) || (!apej.a(((MessageForText)paramMessageRecord).msg)));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfy
 * JD-Core Version:    0.7.0.1
 */