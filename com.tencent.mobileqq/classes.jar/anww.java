import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class anww
  extends ajvq
{
  final WeakReference<anws> a;
  
  public anww(anws paramanws)
  {
    this.a = new WeakReference(paramanws);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
    do
    {
      anws localanws;
      do
      {
        do
        {
          do
          {
            return;
            localanws = (anws)this.a.get();
            if (localanws == null)
            {
              QLog.d("SogouEmoji", 2, "WeakReference error");
              return;
            }
            paramObject = (EmoticonResp)paramObject;
          } while (paramObject.data == null);
          paramObject = (ArrayList)paramObject.data;
        } while (paramObject.size() == 0);
        paramBoolean = localanws.a.a(localanws.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
        }
        if (paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      return;
      localanws.a((Emoticon)paramObject.get(0));
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anww
 * JD-Core Version:    0.7.0.1
 */