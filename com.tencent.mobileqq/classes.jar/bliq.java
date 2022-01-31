import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

public class bliq
  extends BroadcastReceiver
{
  public bliq(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) {}
    do
    {
      return;
      paramContext = AEEditorMusicHelper.a(paramIntent);
    } while (paramContext == null);
    if ((AEEditorMusicHelper.a(paramContext)) && (AEEditorVideoEditFragment.a(this.a) != null))
    {
      AEEditorVideoEditFragment.a(this.a).a(new bljv(paramContext, false));
      return;
    }
    AEEditorVideoEditFragment.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bliq
 * JD-Core Version:    0.7.0.1
 */