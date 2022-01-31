import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager.RunnableShowForKey;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class atmd
  implements atom
{
  public atmd(ListenTogetherManager paramListenTogetherManager) {}
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("ListenTogether.Manager", 1, new Object[] { "onPlayStateChanged: " + atoh.a(paramInt), " songId:", paramString, " curSongID:", QQMusicPlayService.a().a() });
    HashMap localHashMap = new HashMap();
    if (paramInt == 8)
    {
      ListenTogetherManager.a(this.a);
      if (paramInt != 2) {
        break label289;
      }
      ListenTogetherManager.a(this.a).k();
      ListenTogetherManager.a(this.a).m();
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
      ListenTogetherManager.b(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.b(this.a), ListenTogetherManager.a(this.a));
      localHashMap.put("status", String.valueOf(paramInt));
      label177:
      if (paramInt != 2) {
        break label368;
      }
      ListenTogetherManager.a(this.a).removeMessages(1001);
      ListenTogetherManager.a(this.a).sendEmptyMessageDelayed(1001, atlw.a().a);
    }
    for (;;)
    {
      ListenTogetherManager.a(this.a, paramString, paramInt);
      if (!localHashMap.isEmpty()) {
        azri.a(BaseApplication.getContext()).a("", "listen_together_player_status", true, 0L, 0L, localHashMap, "");
      }
      if (QQMusicPlayService.a() != null) {
        awfa.a().a(paramInt);
      }
      return;
      if ((paramInt != 5) && (paramInt != 7)) {
        break;
      }
      localHashMap.put("status", String.valueOf(paramInt));
      break;
      label289:
      if ((paramInt != 4) && (paramInt != 5) && (paramInt != 7)) {
        break label177;
      }
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
      break label177;
      label368:
      ListenTogetherManager.a(this.a).removeMessages(1001);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "onNetChanged: " + paramBoolean);
    if (paramBoolean) {
      ListenTogetherManager.b(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ListenTogether.Manager", 1, "onFocusChanged: " + paramBoolean1 + " isTransient:" + paramBoolean2);
    ListenTogetherManager.a(this.a, paramBoolean1);
    if (paramBoolean1)
    {
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
      ListenTogetherManager.b(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.b(this.a), ListenTogetherManager.a(this.a));
      ListenTogetherManager.a(this.a, 0L);
      return;
    }
    ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
    ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.b(this.a));
    ListenTogetherManager.a(this.a).a(ListenTogetherManager.b(this.a));
    ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
    if (paramBoolean2)
    {
      ListenTogetherManager.a(this.a, 0L);
      return;
    }
    ListenTogetherManager.a(this.a, SystemClock.elapsedRealtime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmd
 * JD-Core Version:    0.7.0.1
 */