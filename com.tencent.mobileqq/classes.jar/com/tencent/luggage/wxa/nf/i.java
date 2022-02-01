package com.tencent.luggage.wxa.nf;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "(Landroid/content/Context;Landroid/os/Handler;)V", "audioManager", "Landroid/media/AudioManager;", "deliverSelfNotifications", "", "onChange", "", "selfChange", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  extends ContentObserver
{
  public static final i.a a = new i.a(null);
  private final AudioManager b;
  
  public i(@NotNull Context paramContext, @Nullable Handler paramHandler)
  {
    super(paramHandler);
    paramContext = paramContext.getSystemService("audio");
    if (paramContext != null)
    {
      this.b = ((AudioManager)paramContext);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean)
  {
    int i = this.b.getStreamVolume(3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Volume now ");
    localStringBuilder.append(i);
    o.d("SettingsContentObserver", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.i
 * JD-Core Version:    0.7.0.1
 */