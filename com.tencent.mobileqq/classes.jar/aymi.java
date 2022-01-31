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

public class aymi
  extends aynd
{
  protected aymk a;
  
  public aymi(bcws parambcws)
  {
    super(parambcws);
  }
  
  public void a(ayjl paramayjl, ayru paramayru, Bitmap paramBitmap)
  {
    if (paramayjl.c() == 103)
    {
      if (paramayru.b() != null) {
        paramayru.b().setImageDrawable(ayrd.a(paramBitmap));
      }
      return;
    }
    super.a(paramayjl, paramayru, paramBitmap);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    if ((paramayjl instanceof ayjq)) {}
    for (Object localObject1 = (ayjq)paramayjl;; localObject1 = null)
    {
      if ((paramayru instanceof ayrx)) {}
      for (ayrx localayrx = (ayrx)paramayru;; localayrx = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramayjl.c() == null)
        {
          if (localayrx.c() != null) {
            localayrx.c().setVisibility(8);
          }
          if (localayrx.a() != null) {
            localayrx.a().setVisibility(8);
          }
          localObject2 = localayrx.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localayrx.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((ayjq)localObject1).a())) {
              ((TextView)localObject2).setText(((ayjq)localObject1).a());
            }
          }
          if ((paramayru.b() != null) && (!TextUtils.isEmpty(((ayjq)localObject1).g())))
          {
            localObject2 = ((ayjq)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = bcwh.a(paramayru.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = bcwh.a(paramayru.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bhos.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bcuq.b(bcwh.a(paramayru.a().getContext(), 50.0F), bcwh.a(paramayru.a().getContext(), 50.0F), bcwh.a(paramayru.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bcuq.i);
            paramayru.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramayjl, paramayru);
          if ((localayrx.a() != null) && (((ayjq)localObject1).c()))
          {
            paramayjl = ((ayjq)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bcwh.a(paramayru.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bcwh.a(paramayru.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramayjl = URLDrawable.getDrawable(paramayjl, (URLDrawable.URLDrawableOptions)localObject2);
            paramayjl.setTag(bcuq.b(bcwh.a(paramayru.a().getContext(), 38.0F), bcwh.a(paramayru.a().getContext(), 12.0F), 0));
            paramayjl.setDecodeHandler(bcuq.i);
            localayrx.a().setImageDrawable(paramayjl);
            if ((paramayjl.getStatus() != 1) && (paramayjl.getStatus() != 0)) {
              paramayjl.restartDownload();
            }
          }
          return;
          if ((localayrx.c() != null) && (!TextUtils.isEmpty(paramayjl.c())))
          {
            localayrx.c().setVisibility(0);
            localayrx.c().setText(paramayjl.c());
          }
          for (;;)
          {
            if (localayrx.a() != null) {
              localayrx.a().setVisibility(0);
            }
            localObject2 = localayrx.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramayjl.a())) {
              break;
            }
            localayrx.a().setText(((ayjq)localObject1).a());
            break;
            if (paramayru.c() != null) {
              localayrx.c().setVisibility(8);
            }
          }
          label625:
          paramayru.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    if (this.a != null)
    {
      if (paramayru.a() != null) {
        paramayru.a().setOnClickListener(new aymj(this));
      }
      return;
    }
    super.c(paramayjl, paramayru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymi
 * JD-Core Version:    0.7.0.1
 */