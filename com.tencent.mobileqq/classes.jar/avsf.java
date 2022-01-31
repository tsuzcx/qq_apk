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

public class avsf
  implements avrh<avon, avww>
{
  private azwg a;
  
  public avsf(azwg paramazwg)
  {
    this.a = paramazwg;
  }
  
  public void a(avon paramavon, avww paramavww)
  {
    if ((paramavww.b() != null) && (!(paramavon instanceof avnn)) && ((paramavon instanceof avok))) {
      paramavww.b().setImageDrawable(avwf.a(this.a, paramavon));
    }
  }
  
  public void a(avon paramavon, avww paramavww, Bitmap paramBitmap)
  {
    if ((paramavww.b() != null) && (!(paramavon instanceof avnn))) {
      paramavww.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(avww paramavww, avon paramavon)
  {
    if ((paramavww.a() != null) && (paramavon != null)) {
      paramavww.a().setText(paramavon.a());
    }
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    d(paramavon, paramavww);
    a(paramavww, paramavon);
    if (paramavww.b() != null) {
      paramavww.b().setText(paramavon.b());
    }
    if (paramavww.c() != null) {
      paramavww.c().setText(paramavon.c());
    }
    if (paramavww.d() != null) {
      paramavww.d().setText(paramavon.d());
    }
    if (paramavww.a() != null)
    {
      if (!paramavon.a()) {
        break label462;
      }
      paramavww.a().setVisibility(0);
    }
    for (;;)
    {
      c(paramavon, paramavww);
      if (!(paramavon instanceof avnn)) {
        break;
      }
      try
      {
        Object localObject = (ImageView)paramavww.a().findViewById(2131313522);
        ImageView localImageView = (ImageView)paramavww.a().findViewById(2131299236);
        TextView localTextView = (TextView)paramavww.a().findViewById(2131302036);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        avnn localavnn = (avnn)paramavon;
        int i = paramavww.a().getResources().getDimensionPixelSize(2131166210);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localavnn.c(), i, i);
        paramavww.b().setImageDrawable(localURLDrawable);
        if ((localavnn.a() != null) && (localavnn.a().video_article.has()) && (localavnn.a().video_article.get() == avwf.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((avnn)paramavon).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramavww.a() != null) {
            paramavww.a().setMaxWidth(aciy.a(190.0F, paramavww.a().getResources()));
          }
          if ((localavnn != null) && (localavnn.a() != null))
          {
            localObject = localavnn.a().hotword.get();
            i = localavnn.a().hotword_type.get();
            ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localavnn.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramavon.c() == null) {
          paramavww.c().setVisibility(8);
        }
        return;
      }
      catch (Exception paramavon)
      {
        label462:
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramavon.toString());
        return;
      }
      paramavww.a().setVisibility(8);
    }
    a(paramavon, paramavww);
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    paramavww = paramavww.a();
    if (paramavww != null) {
      paramavww.setOnClickListener(new avsg(this, paramavon));
    }
  }
  
  public void d(avon paramavon, avww paramavww)
  {
    paramavww = paramavww.a();
    if (paramavon.a() == 0)
    {
      Integer localInteger1 = (Integer)paramavww.getTag(2131313372);
      Integer localInteger2 = (Integer)paramavww.getTag(2131313374);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        avwi.a(paramavon, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramavon.a();
    int k = paramavon.b();
    if ((paramavon instanceof avoo)) {}
    for (int i = ((avoo)paramavon).r;; i = 0)
    {
      avwi.a(j, k, paramavww, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsf
 * JD-Core Version:    0.7.0.1
 */