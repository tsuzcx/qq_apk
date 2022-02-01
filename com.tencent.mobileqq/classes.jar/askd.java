import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;

public class askd
  extends antv
{
  public askd(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    EmoticonResp localEmoticonResp;
    int i;
    label134:
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      localEmoticonResp = (EmoticonResp)paramObject;
      if (paramBoolean)
      {
        i = localEmoticonResp.delEpId;
        if ((localEmoticonResp.keySeq == null) || (localEmoticonResp.keySeq.equals(""))) {
          paramObject = anvx.a(2131699523);
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localEmoticonResp.emoticonId)) {
          break label134;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIOEmotionFragment", 2, "auth type emoticon id is null");
        return;
        paramObject = localEmoticonResp.keySeq;
        continue;
        i = -404;
        paramObject = anvx.a(2131699524);
      }
      localQQAppInterface = this.a.a();
    } while (localQQAppInterface == null);
    ((awyr)localQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(localEmoticonResp.epId), localEmoticonResp.emoticonId, new aske(this, paramInt, localQQAppInterface, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askd
 * JD-Core Version:    0.7.0.1
 */