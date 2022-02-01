import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class bbdi
  extends anvi
{
  bbdi(bbdh parambbdh) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    anvk localanvk;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localanvk = (anvk)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtensionInfo localExtensionInfo = localanvk.a(paramString2, true);
      i = 0;
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs >= paramLong.longValue()) {
        break label153;
      }
      ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
      i = j;
    }
    label153:
    for (;;)
    {
      if (i != 0) {
        localanvk.a((ExtensionInfo)localObject);
      }
      if (bbdh.a(this.a) == null) {}
      for (localObject = null;; localObject = (bbdl)bbdh.a(this.a).get())
      {
        if (localObject != null) {
          ((bbdl)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdi
 * JD-Core Version:    0.7.0.1
 */