import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class anzg
  extends anyf
{
  private int e;
  private int f;
  
  public anzg(anzf paramanzf, int paramInt)
  {
    this.e = ((int)(paramanzf.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131365584);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    anyc localanyc = a(paramInt);
    paramRelativeLayout.setTag(localanyc);
    if ((localanyc != null) && ((localanyc instanceof aocp)))
    {
      paramViewGroup = (aocp)localanyc;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < ayjw.a.length))
      {
        String str = ayjw.a[paramInt];
        paramViewGroup = str;
        if (str != null)
        {
          paramViewGroup = str;
          if (str.startsWith("/"))
          {
            paramViewGroup = str;
            if (str.length() > 1) {
              paramViewGroup = str.substring(1);
            }
          }
        }
        if (paramViewGroup != null) {
          paramRelativeLayout.setContentDescription(paramViewGroup);
        }
      }
    }
    label255:
    do
    {
      break label255;
      paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      float f1 = this.a.a.getResources().getDisplayMetrics().density;
      if (localanyc == null) {
        break;
      }
      if ((localanyc.c == 1) || (localanyc.c == 2) || (localanyc.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localanyc.c != -1)
      {
        paramRelativeLayout = localanyc.a(this.a.a, f1);
        if (paramRelativeLayout != null) {
          localImageView.setImageDrawable(paramRelativeLayout);
        }
        for (;;)
        {
          localImageView.setBackgroundDrawable(null);
          return;
          if (paramViewGroup.a != 2) {
            break;
          }
          paramRelativeLayout.setContentDescription(ayjw.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localanyc.h));
    label256:
    localImageView.setImageResource(2130839287);
    paramRelativeLayout.setContentDescription(ajyc.a(2131704064));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzg
 * JD-Core Version:    0.7.0.1
 */