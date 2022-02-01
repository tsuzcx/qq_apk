import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class aqii
{
  public static aqhi a = new aqhi(0);
  public static aqhi b = new aqhi(100000, 2130847034, 2130847035);
  public static aqhi c = new aqhi(100001, 2130847034, 2130847034);
  
  public static aqhi a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramQQAppInterface, paramResources, paramBaseAdapter, true);
  }
  
  @NonNull
  public static aqhi a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleUtils", 2, "getBubbleInfo, bubbleId=" + paramInt + ", shouldDownload=" + paramBoolean);
    }
    long l = SystemClock.elapsedRealtime();
    if (paramInt == 100000) {
      paramQQAppInterface = c;
    }
    do
    {
      return paramQQAppInterface;
      if (paramInt == 100001) {
        return b;
      }
      if (paramInt < 1) {
        return a;
      }
      paramResources = ((BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramInt, paramBoolean);
      if (paramResources == null) {
        break;
      }
      paramQQAppInterface = paramResources;
    } while (!QLog.isColorLevel());
    QLog.d("bubble_performance", 2, "getBubbleInfo time " + (SystemClock.elapsedRealtime() - l));
    return paramResources;
    if (QLog.isColorLevel()) {
      QLog.d("bubble_performance", 2, "getBubbleInfo time default" + (SystemClock.elapsedRealtime() - l));
    }
    return a;
  }
  
  public static aqhi a(int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return a(paramInt, paramQQAppInterface, null, null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqii
 * JD-Core Version:    0.7.0.1
 */