package com.tencent.luggage.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaMusicActivity$updateMusicHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "message", "Landroid/os/Message;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaMusicActivity$h
  extends s
{
  WxaMusicActivity$h(Looper paramLooper)
  {
    super(localLooper);
  }
  
  public void a(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "message");
    if (paramMessage.what == 1) {
      WxaMusicActivity.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.h
 * JD-Core Version:    0.7.0.1
 */