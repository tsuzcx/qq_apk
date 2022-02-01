import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

public class bnyf
  extends BroadcastReceiver
{
  public bnyf(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bnrh.b(AEEditorVideoEditFragment.f(), "[musicBroadcastReceiver.onReceive]");
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) {}
    do
    {
      return;
      AEEditorVideoEditFragment.a(this.a, AEEditorMusicHelper.a(paramIntent));
    } while (AEEditorVideoEditFragment.a(this.a) == null);
    if (!this.a.a)
    {
      AEEditorVideoEditFragment.a(this.a, AEEditorVideoEditFragment.a(this.a));
      return;
    }
    bnrh.b(AEEditorVideoEditFragment.f(), "[musicBroadcastReceiver.onReceive], fragment not resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyf
 * JD-Core Version:    0.7.0.1
 */