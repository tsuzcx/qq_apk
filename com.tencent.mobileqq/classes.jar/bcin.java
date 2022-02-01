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

public class bcin
  extends bcji
{
  protected bcip a;
  
  public bcin(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz, Bitmap paramBitmap)
  {
    if (parambcfr.c() == 103)
    {
      if (parambcnz.b() != null) {
        parambcnz.b().setImageDrawable(bcni.a(paramBitmap));
      }
      return;
    }
    super.a(parambcfr, parambcnz, paramBitmap);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    if ((parambcfr instanceof bcfw)) {}
    for (Object localObject1 = (bcfw)parambcfr;; localObject1 = null)
    {
      if ((parambcnz instanceof bcoc)) {}
      for (bcoc localbcoc = (bcoc)parambcnz;; localbcoc = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (parambcfr.c() == null)
        {
          if (localbcoc.c() != null) {
            localbcoc.c().setVisibility(8);
          }
          if (localbcoc.a() != null) {
            localbcoc.a().setVisibility(8);
          }
          localObject2 = localbcoc.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localbcoc.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((bcfw)localObject1).a())) {
              ((TextView)localObject2).setText(((bcfw)localObject1).a());
            }
          }
          if ((parambcnz.b() != null) && (!TextUtils.isEmpty(((bcfw)localObject1).g())))
          {
            localObject2 = ((bcfw)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = bhgr.a(parambcnz.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = bhgr.a(parambcnz.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!blhn.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bhez.b(bhgr.a(parambcnz.a().getContext(), 50.0F), bhgr.a(parambcnz.a().getContext(), 50.0F), bhgr.a(parambcnz.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bhez.j);
            parambcnz.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(parambcfr, parambcnz);
          if ((localbcoc.a() != null) && (((bcfw)localObject1).c()))
          {
            parambcfr = ((bcfw)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bhgr.a(parambcnz.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bhgr.a(parambcnz.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            parambcfr = URLDrawable.getDrawable(parambcfr, (URLDrawable.URLDrawableOptions)localObject2);
            parambcfr.setTag(bhez.b(bhgr.a(parambcnz.a().getContext(), 38.0F), bhgr.a(parambcnz.a().getContext(), 12.0F), 0));
            parambcfr.setDecodeHandler(bhez.j);
            localbcoc.a().setImageDrawable(parambcfr);
            if ((parambcfr.getStatus() != 1) && (parambcfr.getStatus() != 0)) {
              parambcfr.restartDownload();
            }
          }
          return;
          if ((localbcoc.c() != null) && (!TextUtils.isEmpty(parambcfr.c())))
          {
            localbcoc.c().setVisibility(0);
            localbcoc.c().setText(parambcfr.c());
          }
          for (;;)
          {
            if (localbcoc.a() != null) {
              localbcoc.a().setVisibility(0);
            }
            localObject2 = localbcoc.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(parambcfr.a())) {
              break;
            }
            localbcoc.a().setText(((bcfw)localObject1).a());
            break;
            if (parambcnz.c() != null) {
              localbcoc.c().setVisibility(8);
            }
          }
          label625:
          parambcnz.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    if (this.a != null)
    {
      if (parambcnz.a() != null) {
        parambcnz.a().setOnClickListener(new bcio(this));
      }
      return;
    }
    super.c(parambcfr, parambcnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcin
 * JD-Core Version:    0.7.0.1
 */