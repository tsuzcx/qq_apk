import android.view.View;
import com.tencent.tavcut.util.FloatUtils;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout.PanelState;

public class bmdl
  extends bmdx
{
  private bmdl(AESlidingUpPanelLayout paramAESlidingUpPanelLayout) {}
  
  public int a(View paramView)
  {
    return AESlidingUpPanelLayout.a(this.a);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt2 = AESlidingUpPanelLayout.a(this.a, 0.0F);
    int i = AESlidingUpPanelLayout.a(this.a, 1.0F);
    if (AESlidingUpPanelLayout.b(this.a)) {
      return Math.min(Math.max(paramInt1, i), paramInt2);
    }
    return Math.min(Math.max(paramInt1, paramInt2), i);
  }
  
  public void a(int paramInt)
  {
    if ((AESlidingUpPanelLayout.a(this.a) != null) && (AESlidingUpPanelLayout.a(this.a).a() == 0))
    {
      AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.a(this.a).getTop()));
      AESlidingUpPanelLayout.a(this.a);
      if (FloatUtils.isEquals(AESlidingUpPanelLayout.b(this.a), 1.0F))
      {
        this.a.b();
        AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.EXPANDED);
      }
    }
    else
    {
      return;
    }
    if (FloatUtils.isEquals(AESlidingUpPanelLayout.b(this.a), 0.0F))
    {
      AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.COLLAPSED);
      return;
    }
    if (AESlidingUpPanelLayout.b(this.a) < 0.0F)
    {
      AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.HIDDEN);
      AESlidingUpPanelLayout.a(this.a).setVisibility(4);
      return;
    }
    this.a.b();
    AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.ANCHORED);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2;
    if (AESlidingUpPanelLayout.b(this.a)) {
      paramFloat1 = -paramFloat2;
    }
    int i;
    if ((paramFloat1 > 0.0F) && (AESlidingUpPanelLayout.b(this.a) <= AESlidingUpPanelLayout.a(this.a))) {
      i = AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.a(this.a));
    }
    for (;;)
    {
      if (AESlidingUpPanelLayout.a(this.a) != null) {
        AESlidingUpPanelLayout.a(this.a).a(paramView.getLeft(), i);
      }
      this.a.invalidate();
      return;
      if ((paramFloat1 > 0.0F) && (AESlidingUpPanelLayout.b(this.a) > AESlidingUpPanelLayout.a(this.a))) {
        i = AESlidingUpPanelLayout.a(this.a, 1.0F);
      } else if ((paramFloat1 < 0.0F) && (AESlidingUpPanelLayout.b(this.a) >= AESlidingUpPanelLayout.a(this.a))) {
        i = AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.a(this.a));
      } else if ((paramFloat1 < 0.0F) && (AESlidingUpPanelLayout.b(this.a) < AESlidingUpPanelLayout.a(this.a))) {
        i = AESlidingUpPanelLayout.a(this.a, 0.0F);
      } else if (AESlidingUpPanelLayout.b(this.a) >= (AESlidingUpPanelLayout.a(this.a) + 1.0F) / 2.0F) {
        i = AESlidingUpPanelLayout.a(this.a, 1.0F);
      } else if (AESlidingUpPanelLayout.b(this.a) >= AESlidingUpPanelLayout.a(this.a) / 2.0F) {
        i = AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.a(this.a));
      } else {
        i = AESlidingUpPanelLayout.a(this.a, 0.0F);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    this.a.c();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AESlidingUpPanelLayout.a(this.a, paramInt2);
    this.a.invalidate();
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return (!AESlidingUpPanelLayout.a(this.a)) && (paramView != null) && (paramView.equals(AESlidingUpPanelLayout.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdl
 * JD-Core Version:    0.7.0.1
 */