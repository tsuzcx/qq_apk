import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class anzl
  extends anyk
{
  private int e;
  private int f;
  
  public anzl(anzk paramanzk, int paramInt)
  {
    this.e = ((int)(paramanzk.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131365583);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    anyh localanyh = a(paramInt);
    paramRelativeLayout.setTag(localanyh);
    if ((localanyh != null) && ((localanyh instanceof aocu)))
    {
      paramViewGroup = (aocu)localanyh;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < ayjy.a.length))
      {
        String str = ayjy.a[paramInt];
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
      if (localanyh == null) {
        break;
      }
      if ((localanyh.c == 1) || (localanyh.c == 2) || (localanyh.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localanyh.c != -1)
      {
        paramRelativeLayout = localanyh.a(this.a.a, f1);
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
          paramRelativeLayout.setContentDescription(ayjy.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localanyh.h));
    label256:
    localImageView.setImageResource(2130839287);
    paramRelativeLayout.setContentDescription(ajya.a(2131704075));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzl
 * JD-Core Version:    0.7.0.1
 */