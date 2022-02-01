package com.tencent.av.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;

public class ScreenShareAskArkBottomUpDialog
  extends DialogFromBottom
{
  private ScreenShareAskArkBottomUpDialog.OnConfirmListener a = null;
  private ScreenShareAskArkBottomUpDialog.OnArrowClickListener b = null;
  
  public ScreenShareAskArkBottomUpDialog(Context paramContext, String paramString, Object paramObject, ScreenShareAskArkBottomUpDialog.OnConfirmListener paramOnConfirmListener)
  {
    super(paramContext);
    this.a = paramOnConfirmListener;
    a(paramContext, paramString, paramObject);
  }
  
  private void a(Context paramContext, String paramString, Object paramObject)
  {
    paramContext = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131627769, null);
    ((TextView)paramContext.findViewById(2131445335)).setText(paramString);
    paramString = (VasAvatar)paramContext.findViewById(2131445334);
    if ((paramObject instanceof Drawable)) {
      paramString.setImageDrawable((Drawable)paramObject);
    } else {
      paramString.setLoader(null, (VasAvatarLoader)paramObject);
    }
    setContentView(paramContext);
    ((ImageView)paramContext.findViewById(2131445332)).setOnClickListener(new ScreenShareAskArkBottomUpDialog.1(this));
    setOnCancelListener(new ScreenShareAskArkBottomUpDialog.2(this));
    ((Button)paramContext.findViewById(2131445333)).setOnClickListener(new ScreenShareAskArkBottomUpDialog.3(this));
  }
  
  public void a(ScreenShareAskArkBottomUpDialog.OnArrowClickListener paramOnArrowClickListener)
  {
    this.b = paramOnArrowClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenShareAskArkBottomUpDialog
 * JD-Core Version:    0.7.0.1
 */