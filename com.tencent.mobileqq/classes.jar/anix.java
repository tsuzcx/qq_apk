import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class anix
  extends anhw
{
  private int e;
  private int f;
  
  public anix(aniw paramaniw, int paramInt)
  {
    this.e = ((int)(paramaniw.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131300003);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    anht localanht = a(paramInt);
    paramRelativeLayout.setTag(localanht);
    if ((localanht != null) && ((localanht instanceof anmf)))
    {
      paramViewGroup = (anmf)localanht;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < axjs.a.length))
      {
        String str = axjs.a[paramInt];
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
      if (localanht == null) {
        break;
      }
      if ((localanht.c == 1) || (localanht.c == 2) || (localanht.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localanht.c != -1)
      {
        paramRelativeLayout = localanht.a(this.a.a, f1);
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
          paramRelativeLayout.setContentDescription(axjs.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localanht.h));
    label256:
    localImageView.setImageResource(2130839263);
    paramRelativeLayout.setContentDescription(ajjy.a(2131638279));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anix
 * JD-Core Version:    0.7.0.1
 */