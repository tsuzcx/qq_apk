import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ForwardSendPicUtil.1;
import com.tencent.qphone.base.util.QLog;

public class bbdl
{
  private static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = bbdr.a(paramContext, paramString, paramInt);
    ImageInfo localImageInfo = new ImageInfo();
    if (paramBoolean) {}
    for (int i = 7;; i = 4)
    {
      bbdr.a(i, paramContext, paramString, str, true, localImageInfo, paramInt);
      return localImageInfo.b;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Context paramContext)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramInt, paramString3, paramBoolean, paramContext, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, boolean paramBoolean, Context paramContext, int paramInt2)
  {
    Object localObject;
    if ((paramContext instanceof Activity))
    {
      localObject = ((Activity)paramContext).getIntent();
      if (localObject == null) {}
    }
    for (boolean bool = ((Intent)localObject).getBooleanExtra("isFromFavorites", false);; bool = false)
    {
      localObject = "ForwardSendPicUtil.sendPicTo." + paramContext.getClass().getSimpleName();
      bbdr.a(-1L, paramInt1, true, "image_send_prepare", (String)localObject + ", isQzoneShare=" + paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage start!");
      }
      paramString1 = a(paramContext, paramString1, paramInt1, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage end!");
      }
      if (!bbdj.b(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardSendPicUtil", 2, "sendPicTo,pic not exist,return false!");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord start!");
      }
      if (paramString1 != null)
      {
        int i = 1009;
        if (bool) {
          i = 1053;
        }
        paramContext = new auoc();
        paramContext.a(paramString1);
        paramContext.d(i);
        paramContext.d(paramString2);
        paramContext.c(ayvu.d);
        paramContext.e(paramString3);
        paramContext.c(paramQQAppInterface.getCurrentAccountUin());
        paramContext.e(paramInt1);
        paramString2 = aunj.a(2, i);
        paramString2.a(paramContext.a());
        paramString2.c = paramInt2;
        aunj.a(paramString2, paramQQAppInterface);
        ThreadManager.post(new ForwardSendPicUtil.1(paramString1, paramInt1, paramQQAppInterface), 5, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord end!");
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdl
 * JD-Core Version:    0.7.0.1
 */