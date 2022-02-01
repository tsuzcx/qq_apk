package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.doodle.IDoodlePanel;

public class BaseDoodlePanel
  extends RelativeLayout
  implements IDoodlePanel
{
  public BaseDoodlePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseDoodlePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a(boolean paramBoolean)
  {
    return 0;
  }
  
  public void a(Bitmap paramBitmap, DoodleItem paramDoodleItem, int paramInt) {}
  
  public void a(BaseAIOContext paramBaseAIOContext, DoodlePanelListener paramDoodlePanelListener) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel
 * JD-Core Version:    0.7.0.1
 */