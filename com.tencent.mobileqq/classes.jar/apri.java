import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class apri
  extends appz
{
  private int e;
  private int f;
  
  public apri(aprh paramaprh, int paramInt)
  {
    this.e = ((int)(paramaprh.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131365666);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    appw localappw = a(paramInt);
    paramRelativeLayout.setTag(localappw);
    if ((localappw != null) && ((localappw instanceof apur)))
    {
      paramViewGroup = (apur)localappw;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < bahu.a.length))
      {
        String str = bahu.a[paramInt];
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
      if (localappw == null) {
        break;
      }
      if ((localappw.c == 1) || (localappw.c == 2) || (localappw.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localappw.c != -1)
      {
        paramRelativeLayout = localappw.a(this.a.a, f1);
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
          paramRelativeLayout.setContentDescription(bahu.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localappw.i));
    label256:
    localImageView.setImageResource(2130839376);
    paramRelativeLayout.setContentDescription(alpo.a(2131704447));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apri
 * JD-Core Version:    0.7.0.1
 */