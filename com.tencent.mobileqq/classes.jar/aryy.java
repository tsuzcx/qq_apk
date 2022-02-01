import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class aryy
  extends arxj
{
  private int e;
  private int f;
  
  public aryy(aryx paramaryx, int paramInt)
  {
    this.e = ((int)(paramaryx.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131365902);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    arxg localarxg = a(paramInt);
    paramRelativeLayout.setTag(localarxg);
    if ((localarxg != null) && ((localarxg instanceof ascv)))
    {
      paramViewGroup = (ascv)localarxg;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < bdnh.a.length))
      {
        String str = bdnh.a[paramInt];
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
      if (localarxg == null) {
        break;
      }
      if ((localarxg.c == 1) || (localarxg.c == 2) || (localarxg.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localarxg.c != -1)
      {
        paramRelativeLayout = localarxg.a(this.a.a, f1);
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
          paramRelativeLayout.setContentDescription(bdnh.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localarxg.i));
    label256:
    localImageView.setImageResource(2130839556);
    paramRelativeLayout.setContentDescription(anni.a(2131702856));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryy
 * JD-Core Version:    0.7.0.1
 */