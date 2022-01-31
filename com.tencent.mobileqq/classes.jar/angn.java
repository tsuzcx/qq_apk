import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class angn
  extends ajhn
{
  final WeakReference<angj> a;
  
  public angn(angj paramangj)
  {
    this.a = new WeakReference(paramangj);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
    do
    {
      angj localangj;
      do
      {
        do
        {
          do
          {
            return;
            localangj = (angj)this.a.get();
            if (localangj == null)
            {
              QLog.d("SogouEmoji", 2, "WeakReference error");
              return;
            }
            paramObject = (EmoticonResp)paramObject;
          } while (paramObject.data == null);
          paramObject = (ArrayList)paramObject.data;
        } while (paramObject.size() == 0);
        paramBoolean = localangj.a.a(localangj.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
        }
        if (paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      return;
      localangj.a((Emoticon)paramObject.get(0));
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angn
 * JD-Core Version:    0.7.0.1
 */