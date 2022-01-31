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

public class awrf
  extends awsa
{
  protected awrh a;
  
  public awrf(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  public void a(awoi paramawoi, awwr paramawwr, Bitmap paramBitmap)
  {
    if (paramawoi.c() == 103)
    {
      if (paramawwr.b() != null) {
        paramawwr.b().setImageDrawable(awwa.a(paramBitmap));
      }
      return;
    }
    super.a(paramawoi, paramawwr, paramBitmap);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    if ((paramawoi instanceof awon)) {}
    for (Object localObject1 = (awon)paramawoi;; localObject1 = null)
    {
      if ((paramawwr instanceof awwu)) {}
      for (awwu localawwu = (awwu)paramawwr;; localawwu = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramawoi.c() == null)
        {
          if (localawwu.c() != null) {
            localawwu.c().setVisibility(8);
          }
          if (localawwu.a() != null) {
            localawwu.a().setVisibility(8);
          }
          localObject2 = localawwu.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localawwu.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((awon)localObject1).a())) {
              ((TextView)localObject2).setText(((awon)localObject1).a());
            }
          }
          if ((paramawwr.b() != null) && (!TextUtils.isEmpty(((awon)localObject1).g())))
          {
            localObject2 = ((awon)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = baxn.a(paramawwr.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = baxn.a(paramawwr.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bfnx.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bavw.b(baxn.a(paramawwr.a().getContext(), 50.0F), baxn.a(paramawwr.a().getContext(), 50.0F), baxn.a(paramawwr.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bavw.i);
            paramawwr.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramawoi, paramawwr);
          if ((localawwu.a() != null) && (((awon)localObject1).c()))
          {
            paramawoi = ((awon)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = baxn.a(paramawwr.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = baxn.a(paramawwr.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramawoi = URLDrawable.getDrawable(paramawoi, (URLDrawable.URLDrawableOptions)localObject2);
            paramawoi.setTag(bavw.b(baxn.a(paramawwr.a().getContext(), 38.0F), baxn.a(paramawwr.a().getContext(), 12.0F), 0));
            paramawoi.setDecodeHandler(bavw.i);
            localawwu.a().setImageDrawable(paramawoi);
            if ((paramawoi.getStatus() != 1) && (paramawoi.getStatus() != 0)) {
              paramawoi.restartDownload();
            }
          }
          return;
          if ((localawwu.c() != null) && (!TextUtils.isEmpty(paramawoi.c())))
          {
            localawwu.c().setVisibility(0);
            localawwu.c().setText(paramawoi.c());
          }
          for (;;)
          {
            if (localawwu.a() != null) {
              localawwu.a().setVisibility(0);
            }
            localObject2 = localawwu.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramawoi.a())) {
              break;
            }
            localawwu.a().setText(((awon)localObject1).a());
            break;
            if (paramawwr.c() != null) {
              localawwu.c().setVisibility(8);
            }
          }
          label625:
          paramawwr.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    if (this.a != null)
    {
      if (paramawwr.a() != null) {
        paramawwr.a().setOnClickListener(new awrg(this));
      }
      return;
    }
    super.c(paramawoi, paramawwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrf
 * JD-Core Version:    0.7.0.1
 */