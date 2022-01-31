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

public class avrk
  extends avsf
{
  protected avrm a;
  
  public avrk(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  public void a(avon paramavon, avww paramavww, Bitmap paramBitmap)
  {
    if (paramavon.c() == 103)
    {
      if (paramavww.b() != null) {
        paramavww.b().setImageDrawable(avwf.a(paramBitmap));
      }
      return;
    }
    super.a(paramavon, paramavww, paramBitmap);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    if ((paramavon instanceof avos)) {}
    for (Object localObject1 = (avos)paramavon;; localObject1 = null)
    {
      if ((paramavww instanceof avwz)) {}
      for (avwz localavwz = (avwz)paramavww;; localavwz = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramavon.c() == null)
        {
          if (localavwz.c() != null) {
            localavwz.c().setVisibility(8);
          }
          if (localavwz.a() != null) {
            localavwz.a().setVisibility(8);
          }
          localObject2 = localavwz.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localavwz.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((avos)localObject1).a())) {
              ((TextView)localObject2).setText(((avos)localObject1).a());
            }
          }
          if ((paramavww.b() != null) && (!TextUtils.isEmpty(((avos)localObject1).g())))
          {
            localObject2 = ((avos)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = azvv.a(paramavww.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = azvv.a(paramavww.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!befm.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(azue.b(azvv.a(paramavww.a().getContext(), 50.0F), azvv.a(paramavww.a().getContext(), 50.0F), azvv.a(paramavww.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(azue.i);
            paramavww.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramavon, paramavww);
          if ((localavwz.a() != null) && (((avos)localObject1).c()))
          {
            paramavon = ((avos)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = azvv.a(paramavww.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = azvv.a(paramavww.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramavon = URLDrawable.getDrawable(paramavon, (URLDrawable.URLDrawableOptions)localObject2);
            paramavon.setTag(azue.b(azvv.a(paramavww.a().getContext(), 38.0F), azvv.a(paramavww.a().getContext(), 12.0F), 0));
            paramavon.setDecodeHandler(azue.i);
            localavwz.a().setImageDrawable(paramavon);
            if ((paramavon.getStatus() != 1) && (paramavon.getStatus() != 0)) {
              paramavon.restartDownload();
            }
          }
          return;
          if ((localavwz.c() != null) && (!TextUtils.isEmpty(paramavon.c())))
          {
            localavwz.c().setVisibility(0);
            localavwz.c().setText(paramavon.c());
          }
          for (;;)
          {
            if (localavwz.a() != null) {
              localavwz.a().setVisibility(0);
            }
            localObject2 = localavwz.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramavon.a())) {
              break;
            }
            localavwz.a().setText(((avos)localObject1).a());
            break;
            if (paramavww.c() != null) {
              localavwz.c().setVisibility(8);
            }
          }
          label625:
          paramavww.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    if (this.a != null)
    {
      if (paramavww.a() != null) {
        paramavww.a().setOnClickListener(new avrl(this));
      }
      return;
    }
    super.c(paramavon, paramavww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrk
 * JD-Core Version:    0.7.0.1
 */