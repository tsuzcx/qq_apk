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

public class bbbp
  extends bbck
{
  protected bbbr a;
  
  public bbbp(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bayt parambayt, bbhb parambbhb, Bitmap paramBitmap)
  {
    if (parambayt.c() == 103)
    {
      if (parambbhb.b() != null) {
        parambbhb.b().setImageDrawable(bbgk.a(paramBitmap));
      }
      return;
    }
    super.a(parambayt, parambbhb, paramBitmap);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    if ((parambayt instanceof bayy)) {}
    for (Object localObject1 = (bayy)parambayt;; localObject1 = null)
    {
      if ((parambbhb instanceof bbhe)) {}
      for (bbhe localbbhe = (bbhe)parambbhb;; localbbhe = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (parambayt.c() == null)
        {
          if (localbbhe.c() != null) {
            localbbhe.c().setVisibility(8);
          }
          if (localbbhe.a() != null) {
            localbbhe.a().setVisibility(8);
          }
          localObject2 = localbbhe.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localbbhe.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((bayy)localObject1).a())) {
              ((TextView)localObject2).setText(((bayy)localObject1).a());
            }
          }
          if ((parambbhb.b() != null) && (!TextUtils.isEmpty(((bayy)localObject1).g())))
          {
            localObject2 = ((bayy)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = DisplayUtil.dip2px(parambbhb.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = DisplayUtil.dip2px(parambbhb.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!bjnd.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(bfol.b(DisplayUtil.dip2px(parambbhb.a().getContext(), 50.0F), DisplayUtil.dip2px(parambbhb.a().getContext(), 50.0F), DisplayUtil.dip2px(parambbhb.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(bfol.j);
            parambbhb.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(parambayt, parambbhb);
          if ((localbbhe.a() != null) && (((bayy)localObject1).c()))
          {
            parambayt = ((bayy)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px(parambbhb.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px(parambbhb.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            parambayt = URLDrawable.getDrawable(parambayt, (URLDrawable.URLDrawableOptions)localObject2);
            parambayt.setTag(bfol.b(DisplayUtil.dip2px(parambbhb.a().getContext(), 38.0F), DisplayUtil.dip2px(parambbhb.a().getContext(), 12.0F), 0));
            parambayt.setDecodeHandler(bfol.j);
            localbbhe.a().setImageDrawable(parambayt);
            if ((parambayt.getStatus() != 1) && (parambayt.getStatus() != 0)) {
              parambayt.restartDownload();
            }
          }
          return;
          if ((localbbhe.c() != null) && (!TextUtils.isEmpty(parambayt.c())))
          {
            localbbhe.c().setVisibility(0);
            localbbhe.c().setText(parambayt.c());
          }
          for (;;)
          {
            if (localbbhe.a() != null) {
              localbbhe.a().setVisibility(0);
            }
            localObject2 = localbbhe.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(parambayt.a())) {
              break;
            }
            localbbhe.a().setText(((bayy)localObject1).a());
            break;
            if (parambbhb.c() != null) {
              localbbhe.c().setVisibility(8);
            }
          }
          label625:
          parambbhb.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    if (this.a != null)
    {
      if (parambbhb.a() != null) {
        parambbhb.a().setOnClickListener(new bbbq(this));
      }
      return;
    }
    super.c(parambayt, parambbhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbp
 * JD-Core Version:    0.7.0.1
 */