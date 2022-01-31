import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class amfj
  extends alox
{
  amfj(amfi paramamfi) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    aloz localaloz;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localaloz = (aloz)this.a.a.getManager(51);
      ExtensionInfo localExtensionInfo = localaloz.a(paramString2, true);
      i = 0;
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs >= paramLong.longValue()) {
        break label152;
      }
      ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
      i = j;
    }
    label152:
    for (;;)
    {
      if (i != 0) {
        localaloz.a((ExtensionInfo)localObject);
      }
      if (amfi.a(this.a) == null) {}
      for (localObject = null;; localObject = (amfm)amfi.a(this.a).get())
      {
        if (localObject != null) {
          ((amfm)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfj
 * JD-Core Version:    0.7.0.1
 */