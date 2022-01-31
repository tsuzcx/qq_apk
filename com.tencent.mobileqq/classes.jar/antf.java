import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class antf
{
  public static ansf a = new ansf(0);
  public static ansf b = new ansf(100000, 2130846498, 2130846499);
  public static ansf c = new ansf(100001, 2130846498, 2130846498);
  
  public static ansf a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramQQAppInterface, paramResources, paramBaseAdapter, true);
  }
  
  public static ansf a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
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
 * Qualified Name:     antf
 * JD-Core Version:    0.7.0.1
 */