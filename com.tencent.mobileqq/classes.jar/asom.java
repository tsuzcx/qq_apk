import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class asom
  extends asmx
{
  private int e;
  private int f;
  
  public asom(asol paramasol, int paramInt)
  {
    this.e = ((int)(paramasol.a.getResources().getDisplayMetrics().density * 30.0F));
    this.f = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131365947);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    asmu localasmu = a(paramInt);
    paramRelativeLayout.setTag(localasmu);
    if ((localasmu != null) && ((localasmu instanceof assj)))
    {
      paramViewGroup = (assj)localasmu;
      paramInt = paramViewGroup.b;
      if (paramViewGroup.a != 1) {
        break label256;
      }
      if ((paramInt >= 0) && (paramInt < begd.a.length))
      {
        String str = begd.a[paramInt];
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
      if (localasmu == null) {
        break;
      }
      if ((localasmu.c == 1) || (localasmu.c == 2) || (localasmu.c == 7))
      {
        paramViewGroup.width = this.e;
        paramViewGroup.height = this.e;
      }
      if (localasmu.c != -1)
      {
        paramRelativeLayout = localasmu.a(this.a.a, f1);
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
          paramRelativeLayout.setContentDescription(begd.a(paramInt));
          break;
          localImageView.setVisibility(4);
        }
      }
    } while (!"delete".equals(localasmu.i));
    label256:
    localImageView.setImageResource(2130839565);
    paramRelativeLayout.setContentDescription(anzj.a(2131702963));
    return;
    localImageView.setImageDrawable(null);
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asom
 * JD-Core Version:    0.7.0.1
 */