import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

public class bbpu
  extends bbqp
{
  protected bbpw a;
  
  public bbpu(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg, Bitmap paramBitmap)
  {
    if (parambbmy.c() == 103)
    {
      if (parambbvg.b() != null) {
        parambbvg.b().setImageDrawable(bbup.a(paramBitmap));
      }
      return;
    }
    super.a(parambbmy, parambbvg, paramBitmap);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    if ((parambbmy instanceof bbnd)) {}
    for (Object localObject1 = (bbnd)parambbmy;; localObject1 = null)
    {
      if ((parambbvg instanceof bbvj)) {}
      for (bbvj localbbvj = (bbvj)parambbvg;; localbbvj = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (parambbmy.c() == null)
        {
          if (localbbvj.c() != null) {
            localbbvj.c().setVisibility(8);
          }
          if (localbbvj.a() != null) {
            localbbvj.a().setVisibility(8);
          }
          localObject2 = localbbvj.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localbbvj.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((bbnd)localObject1).a())) {
              ((TextView)localObject2).setText(((bbnd)localObject1).a());
            }
          }
          if ((parambbvg.b() != null) && (!TextUtils.isEmpty(((bbnd)localObject1).g())))
          {
            localObject2 = ((bbnd)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = bggq.a(parambbvg.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = bggq.a(parambbvg.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bkgj.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bgey.b(bggq.a(parambbvg.a().getContext(), 50.0F), bggq.a(parambbvg.a().getContext(), 50.0F), bggq.a(parambbvg.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bgey.j);
            parambbvg.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(parambbmy, parambbvg);
          if ((localbbvj.a() != null) && (((bbnd)localObject1).c()))
          {
            parambbmy = ((bbnd)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bggq.a(parambbvg.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bggq.a(parambbvg.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            parambbmy = URLDrawable.getDrawable(parambbmy, (URLDrawable.URLDrawableOptions)localObject2);
            parambbmy.setTag(bgey.b(bggq.a(parambbvg.a().getContext(), 38.0F), bggq.a(parambbvg.a().getContext(), 12.0F), 0));
            parambbmy.setDecodeHandler(bgey.j);
            localbbvj.a().setImageDrawable(parambbmy);
            if ((parambbmy.getStatus() != 1) && (parambbmy.getStatus() != 0)) {
              parambbmy.restartDownload();
            }
          }
          return;
          if ((localbbvj.c() != null) && (!TextUtils.isEmpty(parambbmy.c())))
          {
            localbbvj.c().setVisibility(0);
            localbbvj.c().setText(parambbmy.c());
          }
          for (;;)
          {
            if (localbbvj.a() != null) {
              localbbvj.a().setVisibility(0);
            }
            localObject2 = localbbvj.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(parambbmy.a())) {
              break;
            }
            localbbvj.a().setText(((bbnd)localObject1).a());
            break;
            if (parambbvg.c() != null) {
              localbbvj.c().setVisibility(8);
            }
          }
          label625:
          parambbvg.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    if (this.a != null)
    {
      if (parambbvg.a() != null) {
        parambbvg.a().setOnClickListener(new bbpv(this));
      }
      return;
    }
    super.c(parambbmy, parambbvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpu
 * JD-Core Version:    0.7.0.1
 */