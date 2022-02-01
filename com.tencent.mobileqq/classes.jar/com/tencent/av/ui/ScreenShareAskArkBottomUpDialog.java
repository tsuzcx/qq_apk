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
  private ScreenShareAskArkBottomUpDialog.OnArrowClickListener jdField_a_of_type_ComTencentAvUiScreenShareAskArkBottomUpDialog$OnArrowClickListener = null;
  private ScreenShareAskArkBottomUpDialog.OnConfirmListener jdField_a_of_type_ComTencentAvUiScreenShareAskArkBottomUpDialog$OnConfirmListener = null;
  
  public ScreenShareAskArkBottomUpDialog(Context paramContext, String paramString, Object paramObject, ScreenShareAskArkBottomUpDialog.OnConfirmListener paramOnConfirmListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiScreenShareAskArkBottomUpDialog$OnConfirmListener = paramOnConfirmListener;
    a(paramContext, paramString, paramObject);
  }
  
  private void a(Context paramContext, String paramString, Object paramObject)
  {
    paramContext = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131561413, null);
    ((TextView)paramContext.findViewById(2131376971)).setText(paramString);
    paramString = (VasAvatar)paramContext.findViewById(2131376970);
    if ((paramObject instanceof Drawable)) {
      paramString.setImageDrawable((Drawable)paramObject);
    } else {
      paramString.setLoader(null, (VasAvatarLoader)paramObject);
    }
    setContentView(paramContext);
    ((ImageView)paramContext.findViewById(2131376968)).setOnClickListener(new ScreenShareAskArkBottomUpDialog.1(this));
    setOnCancelListener(new ScreenShareAskArkBottomUpDialog.2(this));
    ((Button)paramContext.findViewById(2131376969)).setOnClickListener(new ScreenShareAskArkBottomUpDialog.3(this));
  }
  
  public void a(ScreenShareAskArkBottomUpDialog.OnArrowClickListener paramOnArrowClickListener)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenShareAskArkBottomUpDialog$OnArrowClickListener = paramOnArrowClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenShareAskArkBottomUpDialog
 * JD-Core Version:    0.7.0.1
 */