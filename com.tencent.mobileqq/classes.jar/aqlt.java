import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class aqlt
{
  public static aqkt a = new aqkt(0);
  public static aqkt b = new aqkt(100000, 2130847029, 2130847030);
  public static aqkt c = new aqkt(100001, 2130847029, 2130847029);
  
  public static aqkt a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramQQAppInterface, paramResources, paramBaseAdapter, true);
  }
  
  public static aqkt a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
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
      paramResources = ((BubbleManager)paramQQAppInterface.getManager(44)).a(paramInt, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlt
 * JD-Core Version:    0.7.0.1
 */