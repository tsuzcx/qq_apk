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

public class awsa
  implements awrc<awoi, awwr>
{
  private baxy a;
  
  public awsa(baxy parambaxy)
  {
    this.a = parambaxy;
  }
  
  public void a(awoi paramawoi, awwr paramawwr)
  {
    if ((paramawwr.b() != null) && (!(paramawoi instanceof awni)) && ((paramawoi instanceof awof))) {
      paramawwr.b().setImageDrawable(awwa.a(this.a, paramawoi));
    }
  }
  
  public void a(awoi paramawoi, awwr paramawwr, Bitmap paramBitmap)
  {
    if ((paramawwr.b() != null) && (!(paramawoi instanceof awni))) {
      paramawwr.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(awwr paramawwr, awoi paramawoi)
  {
    if ((paramawwr.a() != null) && (paramawoi != null)) {
      paramawwr.a().setText(paramawoi.a());
    }
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    d(paramawoi, paramawwr);
    a(paramawwr, paramawoi);
    if (paramawwr.b() != null) {
      paramawwr.b().setText(paramawoi.b());
    }
    if (paramawwr.c() != null) {
      paramawwr.c().setText(paramawoi.c());
    }
    if (paramawwr.d() != null) {
      paramawwr.d().setText(paramawoi.d());
    }
    if (paramawwr.a() != null)
    {
      if (!paramawoi.a()) {
        break label462;
      }
      paramawwr.a().setVisibility(0);
    }
    for (;;)
    {
      c(paramawoi, paramawwr);
      if (!(paramawoi instanceof awni)) {
        break;
      }
      try
      {
        Object localObject = (ImageView)paramawwr.a().findViewById(2131379362);
        ImageView localImageView = (ImageView)paramawwr.a().findViewById(2131364798);
        TextView localTextView = (TextView)paramawwr.a().findViewById(2131367654);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        awni localawni = (awni)paramawoi;
        int i = paramawwr.a().getResources().getDimensionPixelSize(2131297291);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localawni.c(), i, i);
        paramawwr.b().setImageDrawable(localURLDrawable);
        if ((localawni.a() != null) && (localawni.a().video_article.has()) && (localawni.a().video_article.get() == awwa.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((awni)paramawoi).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramawwr.a() != null) {
            paramawwr.a().setMaxWidth(actj.a(190.0F, paramawwr.a().getResources()));
          }
          if ((localawni != null) && (localawni.a() != null))
          {
            localObject = localawni.a().hotword.get();
            i = localawni.a().hotword_type.get();
            nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localawni.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramawoi.c() == null) {
          paramawwr.c().setVisibility(8);
        }
        return;
      }
      catch (Exception paramawoi)
      {
        label462:
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramawoi.toString());
        return;
      }
      paramawwr.a().setVisibility(8);
    }
    a(paramawoi, paramawwr);
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    paramawwr = paramawwr.a();
    if (paramawwr != null) {
      paramawwr.setOnClickListener(new awsb(this, paramawoi));
    }
  }
  
  public void d(awoi paramawoi, awwr paramawwr)
  {
    paramawwr = paramawwr.a();
    if (paramawoi.a() == 0)
    {
      Integer localInteger1 = (Integer)paramawwr.getTag(2131379212);
      Integer localInteger2 = (Integer)paramawwr.getTag(2131379214);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        awwd.a(paramawoi, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramawoi.a();
    int k = paramawoi.b();
    if ((paramawoi instanceof awoj)) {}
    for (int i = ((awoj)paramawoi).r;; i = 0)
    {
      awwd.a(j, k, paramawwr, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsa
 * JD-Core Version:    0.7.0.1
 */