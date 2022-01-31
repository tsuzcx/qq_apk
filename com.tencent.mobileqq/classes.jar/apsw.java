import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class apsw
  extends alrq
{
  final WeakReference<apss> a;
  
  public apsw(apss paramapss)
  {
    this.a = new WeakReference(paramapss);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
    do
    {
      apss localapss;
      do
      {
        do
        {
          do
          {
            return;
            localapss = (apss)this.a.get();
            if (localapss == null)
            {
              QLog.d("SogouEmoji", 2, "WeakReference error");
              return;
            }
            paramObject = (EmoticonResp)paramObject;
          } while (paramObject.data == null);
          paramObject = (ArrayList)paramObject.data;
        } while (paramObject.size() == 0);
        paramBoolean = localapss.a.a(localapss.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
        }
        if (paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      return;
      localapss.a((Emoticon)paramObject.get(0));
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsw
 * JD-Core Version:    0.7.0.1
 */