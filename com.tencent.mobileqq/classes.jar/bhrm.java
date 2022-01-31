import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bhrm
  extends BroadcastReceiver
{
  bhrm(bhrl parambhrl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneDynamicAlbumPlugin", 2, paramContext);
    }
    paramIntent = paramIntent.getStringExtra("runningProcessName");
    if ((("com.tencent.process.stopping".equals(paramContext)) && (!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq:tool"))) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      bhrl.a(this.a, true);
      this.a.b();
    }
    while (((!"com.tencent.process.starting".equals(paramContext)) || (TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("com.tencent.mobileqq:tool")) || (!bhrl.a(this.a))) && (!"tencent.av.v2q.StopVideoChat".equals(paramContext))) {
      return;
    }
    bhrl.a(this.a, false);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrm
 * JD-Core Version:    0.7.0.1
 */