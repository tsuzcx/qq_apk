import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class amjy
  extends altm
{
  amjy(amjx paramamjx) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    alto localalto;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localalto = (alto)this.a.a.getManager(51);
      ExtensionInfo localExtensionInfo = localalto.a(paramString2, true);
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
        localalto.a((ExtensionInfo)localObject);
      }
      if (amjx.a(this.a) == null) {}
      for (localObject = null;; localObject = (amkb)amjx.a(this.a).get())
      {
        if (localObject != null) {
          ((amkb)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjy
 * JD-Core Version:    0.7.0.1
 */