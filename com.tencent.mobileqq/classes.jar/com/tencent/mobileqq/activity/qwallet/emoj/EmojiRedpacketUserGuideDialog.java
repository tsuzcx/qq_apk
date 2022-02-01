package com.tencent.mobileqq.activity.qwallet.emoj;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class EmojiRedpacketUserGuideDialog
  extends ReportDialog
{
  private static final String TAG = EmojiRedpacketUserGuideDialog.class.getSimpleName();
  public static String URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201904/upload_13e561ae68d934abd06b8b6830d99754.png";
  
  public EmojiRedpacketUserGuideDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public EmojiRedpacketUserGuideDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.setContentView(new EmojiRedpacketUserGuideDialog.UserGuidView(this, getContext()));
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle.setLayout(-1, -1);
        paramBundle.setBackgroundDrawable(new ColorDrawable(0));
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          paramBundle.addFlags(67108864);
        }
      }
      super.setCancelable(true);
      return;
    }
    catch (Exception paramBundle) {}catch (OutOfMemoryError paramBundle) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        super.cancel();
        return false;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramKeyEvent.printStackTrace();
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedpacketUserGuideDialog
 * JD-Core Version:    0.7.0.1
 */