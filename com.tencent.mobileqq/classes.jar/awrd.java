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

public class awrd
  extends awry
{
  protected awrf a;
  
  public awrd(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  public void a(awog paramawog, awwp paramawwp, Bitmap paramBitmap)
  {
    if (paramawog.c() == 103)
    {
      if (paramawwp.b() != null) {
        paramawwp.b().setImageDrawable(awvy.a(paramBitmap));
      }
      return;
    }
    super.a(paramawog, paramawwp, paramBitmap);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    if ((paramawog instanceof awol)) {}
    for (Object localObject1 = (awol)paramawog;; localObject1 = null)
    {
      if ((paramawwp instanceof awws)) {}
      for (awws localawws = (awws)paramawwp;; localawws = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramawog.c() == null)
        {
          if (localawws.c() != null) {
            localawws.c().setVisibility(8);
          }
          if (localawws.a() != null) {
            localawws.a().setVisibility(8);
          }
          localObject2 = localawws.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localawws.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((awol)localObject1).a())) {
              ((TextView)localObject2).setText(((awol)localObject1).a());
            }
          }
          if ((paramawwp.b() != null) && (!TextUtils.isEmpty(((awol)localObject1).g())))
          {
            localObject2 = ((awol)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = bawz.a(paramawwp.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = bawz.a(paramawwp.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bfng.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bavi.b(bawz.a(paramawwp.a().getContext(), 50.0F), bawz.a(paramawwp.a().getContext(), 50.0F), bawz.a(paramawwp.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bavi.i);
            paramawwp.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramawog, paramawwp);
          if ((localawws.a() != null) && (((awol)localObject1).c()))
          {
            paramawog = ((awol)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bawz.a(paramawwp.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bawz.a(paramawwp.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramawog = URLDrawable.getDrawable(paramawog, (URLDrawable.URLDrawableOptions)localObject2);
            paramawog.setTag(bavi.b(bawz.a(paramawwp.a().getContext(), 38.0F), bawz.a(paramawwp.a().getContext(), 12.0F), 0));
            paramawog.setDecodeHandler(bavi.i);
            localawws.a().setImageDrawable(paramawog);
            if ((paramawog.getStatus() != 1) && (paramawog.getStatus() != 0)) {
              paramawog.restartDownload();
            }
          }
          return;
          if ((localawws.c() != null) && (!TextUtils.isEmpty(paramawog.c())))
          {
            localawws.c().setVisibility(0);
            localawws.c().setText(paramawog.c());
          }
          for (;;)
          {
            if (localawws.a() != null) {
              localawws.a().setVisibility(0);
            }
            localObject2 = localawws.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramawog.a())) {
              break;
            }
            localawws.a().setText(((awol)localObject1).a());
            break;
            if (paramawwp.c() != null) {
              localawws.c().setVisibility(8);
            }
          }
          label625:
          paramawwp.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    if (this.a != null)
    {
      if (paramawwp.a() != null) {
        paramawwp.a().setOnClickListener(new awre(this));
      }
      return;
    }
    super.c(paramawog, paramawwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrd
 * JD-Core Version:    0.7.0.1
 */