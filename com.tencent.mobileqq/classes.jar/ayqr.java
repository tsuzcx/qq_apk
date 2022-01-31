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

public class ayqr
  extends ayrm
{
  protected ayqt a;
  
  public ayqr(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  public void a(aynu paramaynu, aywd paramaywd, Bitmap paramBitmap)
  {
    if (paramaynu.c() == 103)
    {
      if (paramaywd.b() != null) {
        paramaywd.b().setImageDrawable(ayvm.a(paramBitmap));
      }
      return;
    }
    super.a(paramaynu, paramaywd, paramBitmap);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    if ((paramaynu instanceof aynz)) {}
    for (Object localObject1 = (aynz)paramaynu;; localObject1 = null)
    {
      if ((paramaywd instanceof aywg)) {}
      for (aywg localaywg = (aywg)paramaywd;; localaywg = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramaynu.c() == null)
        {
          if (localaywg.c() != null) {
            localaywg.c().setVisibility(8);
          }
          if (localaywg.a() != null) {
            localaywg.a().setVisibility(8);
          }
          localObject2 = localaywg.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localaywg.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((aynz)localObject1).a())) {
              ((TextView)localObject2).setText(((aynz)localObject1).a());
            }
          }
          if ((paramaywd.b() != null) && (!TextUtils.isEmpty(((aynz)localObject1).g())))
          {
            localObject2 = ((aynz)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = bdaq.a(paramaywd.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = bdaq.a(paramaywd.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bhsz.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bcyz.b(bdaq.a(paramaywd.a().getContext(), 50.0F), bdaq.a(paramaywd.a().getContext(), 50.0F), bdaq.a(paramaywd.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bcyz.i);
            paramaywd.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramaynu, paramaywd);
          if ((localaywg.a() != null) && (((aynz)localObject1).c()))
          {
            paramaynu = ((aynz)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bdaq.a(paramaywd.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bdaq.a(paramaywd.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramaynu = URLDrawable.getDrawable(paramaynu, (URLDrawable.URLDrawableOptions)localObject2);
            paramaynu.setTag(bcyz.b(bdaq.a(paramaywd.a().getContext(), 38.0F), bdaq.a(paramaywd.a().getContext(), 12.0F), 0));
            paramaynu.setDecodeHandler(bcyz.i);
            localaywg.a().setImageDrawable(paramaynu);
            if ((paramaynu.getStatus() != 1) && (paramaynu.getStatus() != 0)) {
              paramaynu.restartDownload();
            }
          }
          return;
          if ((localaywg.c() != null) && (!TextUtils.isEmpty(paramaynu.c())))
          {
            localaywg.c().setVisibility(0);
            localaywg.c().setText(paramaynu.c());
          }
          for (;;)
          {
            if (localaywg.a() != null) {
              localaywg.a().setVisibility(0);
            }
            localObject2 = localaywg.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramaynu.a())) {
              break;
            }
            localaywg.a().setText(((aynz)localObject1).a());
            break;
            if (paramaywd.c() != null) {
              localaywg.c().setVisibility(8);
            }
          }
          label625:
          paramaywd.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    if (this.a != null)
    {
      if (paramaywd.a() != null) {
        paramaywd.a().setOnClickListener(new ayqs(this));
      }
      return;
    }
    super.c(paramaynu, paramaywd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqr
 * JD-Core Version:    0.7.0.1
 */