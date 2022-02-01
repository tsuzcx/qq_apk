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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.util.DisplayUtil;

public class bcih
  extends bcjc
{
  protected bcij a;
  
  public bcih(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt, Bitmap paramBitmap)
  {
    if (parambcfj.c() == 103)
    {
      if (parambcnt.b() != null) {
        parambcnt.b().setImageDrawable(bcnc.a(paramBitmap));
      }
      return;
    }
    super.a(parambcfj, parambcnt, paramBitmap);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    if ((parambcfj instanceof bcfo)) {}
    for (Object localObject1 = (bcfo)parambcfj;; localObject1 = null)
    {
      if ((parambcnt instanceof bcnw)) {}
      for (bcnw localbcnw = (bcnw)parambcnt;; localbcnw = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (parambcfj.c() == null)
        {
          if (localbcnw.c() != null) {
            localbcnw.c().setVisibility(8);
          }
          if (localbcnw.a() != null) {
            localbcnw.a().setVisibility(8);
          }
          localObject2 = localbcnw.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localbcnw.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((bcfo)localObject1).a())) {
              ((TextView)localObject2).setText(((bcfo)localObject1).a());
            }
          }
          if ((parambcnt.b() != null) && (!TextUtils.isEmpty(((bcfo)localObject1).g())))
          {
            localObject2 = ((bcfo)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = DisplayUtil.dip2px(parambcnt.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = DisplayUtil.dip2px(parambcnt.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bkyp.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bgxc.b(DisplayUtil.dip2px(parambcnt.a().getContext(), 50.0F), DisplayUtil.dip2px(parambcnt.a().getContext(), 50.0F), DisplayUtil.dip2px(parambcnt.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bgxc.j);
            parambcnt.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(parambcfj, parambcnt);
          if ((localbcnw.a() != null) && (((bcfo)localObject1).c()))
          {
            parambcfj = ((bcfo)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px(parambcnt.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px(parambcnt.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            parambcfj = URLDrawable.getDrawable(parambcfj, (URLDrawable.URLDrawableOptions)localObject2);
            parambcfj.setTag(bgxc.b(DisplayUtil.dip2px(parambcnt.a().getContext(), 38.0F), DisplayUtil.dip2px(parambcnt.a().getContext(), 12.0F), 0));
            parambcfj.setDecodeHandler(bgxc.j);
            localbcnw.a().setImageDrawable(parambcfj);
            if ((parambcfj.getStatus() != 1) && (parambcfj.getStatus() != 0)) {
              parambcfj.restartDownload();
            }
          }
          return;
          if ((localbcnw.c() != null) && (!TextUtils.isEmpty(parambcfj.c())))
          {
            localbcnw.c().setVisibility(0);
            localbcnw.c().setText(parambcfj.c());
          }
          for (;;)
          {
            if (localbcnw.a() != null) {
              localbcnw.a().setVisibility(0);
            }
            localObject2 = localbcnw.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(parambcfj.a())) {
              break;
            }
            localbcnw.a().setText(((bcfo)localObject1).a());
            break;
            if (parambcnt.c() != null) {
              localbcnw.c().setVisibility(8);
            }
          }
          label625:
          parambcnt.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    if (this.a != null)
    {
      if (parambcnt.a() != null) {
        parambcnt.a().setOnClickListener(new bcii(this));
      }
      return;
    }
    super.c(parambcfj, parambcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcih
 * JD-Core Version:    0.7.0.1
 */