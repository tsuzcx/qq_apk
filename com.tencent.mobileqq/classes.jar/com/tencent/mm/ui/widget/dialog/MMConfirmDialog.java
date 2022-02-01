package com.tencent.mm.ui.widget.dialog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MMConfirmDialog
{
  public static final int CB_CHECKED = 1;
  public static final int CB_DISABLE = 2;
  public static final int CB_UNCHECKED = 0;
  
  private static void b(MMAlertDialog.Builder paramBuilder, Bitmap paramBitmap)
  {
    paramBuilder.setOnDismissListener(new MMConfirmDialog.1(paramBitmap));
  }
  
  private static void b(MMAlertDialog.Builder paramBuilder, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (paramArrayOfByte != null)
      {
        paramBuilder.setMsgIcon(paramArrayOfByte);
        b(paramBuilder, paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog
 * JD-Core Version:    0.7.0.1
 */