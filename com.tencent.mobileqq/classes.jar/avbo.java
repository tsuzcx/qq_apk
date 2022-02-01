import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.1;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.2;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.3;
import com.tencent.mobileqq.utils.NetworkUtil;

public class avbo
{
  public static void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new QQMusicPlayReport.2(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new QQMusicPlayReport.1(paramBoolean, paramInt), 5, null, false);
  }
  
  public static void b(boolean paramBoolean, int paramInt)
  {
    ThreadManager.post(new QQMusicPlayReport.3(paramBoolean, NetworkUtil.getNetworkType(null), paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbo
 * JD-Core Version:    0.7.0.1
 */