import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class awry
  implements awra<awog, awwp>
{
  private baxk a;
  
  public awry(baxk parambaxk)
  {
    this.a = parambaxk;
  }
  
  public void a(awog paramawog, awwp paramawwp)
  {
    if ((paramawwp.b() != null) && (!(paramawog instanceof awng)) && ((paramawog instanceof awod))) {
      paramawwp.b().setImageDrawable(awvy.a(this.a, paramawog));
    }
  }
  
  public void a(awog paramawog, awwp paramawwp, Bitmap paramBitmap)
  {
    if ((paramawwp.b() != null) && (!(paramawog instanceof awng))) {
      paramawwp.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(awwp paramawwp, awog paramawog)
  {
    if ((paramawwp.a() != null) && (paramawog != null)) {
      paramawwp.a().setText(paramawog.a());
    }
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    d(paramawog, paramawwp);
    a(paramawwp, paramawog);
    if (paramawwp.b() != null) {
      paramawwp.b().setText(paramawog.b());
    }
    if (paramawwp.c() != null) {
      paramawwp.c().setText(paramawog.c());
    }
    if (paramawwp.d() != null) {
      paramawwp.d().setText(paramawog.d());
    }
    if (paramawwp.a() != null)
    {
      if (!paramawog.a()) {
        break label462;
      }
      paramawwp.a().setVisibility(0);
    }
    for (;;)
    {
      c(paramawog, paramawwp);
      if (!(paramawog instanceof awng)) {
        break;
      }
      try
      {
        Object localObject = (ImageView)paramawwp.a().findViewById(2131379357);
        ImageView localImageView = (ImageView)paramawwp.a().findViewById(2131364799);
        TextView localTextView = (TextView)paramawwp.a().findViewById(2131367654);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        awng localawng = (awng)paramawog;
        int i = paramawwp.a().getResources().getDimensionPixelSize(2131297291);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localawng.c(), i, i);
        paramawwp.b().setImageDrawable(localURLDrawable);
        if ((localawng.a() != null) && (localawng.a().video_article.has()) && (localawng.a().video_article.get() == awvy.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((awng)paramawog).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramawwp.a() != null) {
            paramawwp.a().setMaxWidth(actn.a(190.0F, paramawwp.a().getResources()));
          }
          if ((localawng != null) && (localawng.a() != null))
          {
            localObject = localawng.a().hotword.get();
            i = localawng.a().hotword_type.get();
            noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localawng.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramawog.c() == null) {
          paramawwp.c().setVisibility(8);
        }
        return;
      }
      catch (Exception paramawog)
      {
        label462:
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramawog.toString());
        return;
      }
      paramawwp.a().setVisibility(8);
    }
    a(paramawog, paramawwp);
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    paramawwp = paramawwp.a();
    if (paramawwp != null) {
      paramawwp.setOnClickListener(new awrz(this, paramawog));
    }
  }
  
  public void d(awog paramawog, awwp paramawwp)
  {
    paramawwp = paramawwp.a();
    if (paramawog.a() == 0)
    {
      Integer localInteger1 = (Integer)paramawwp.getTag(2131379207);
      Integer localInteger2 = (Integer)paramawwp.getTag(2131379209);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        awwb.a(paramawog, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramawog.a();
    int k = paramawog.b();
    if ((paramawog instanceof awoh)) {}
    for (int i = ((awoh)paramawog).r;; i = 0)
    {
      awwb.a(j, k, paramawwp, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awry
 * JD-Core Version:    0.7.0.1
 */