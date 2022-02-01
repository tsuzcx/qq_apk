import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class bcji
  implements bcik<bcfr, bcnz>
{
  private aoof a;
  
  public bcji(aoof paramaoof)
  {
    this.a = paramaoof;
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    if ((parambcnz.b() != null) && (!(parambcfr instanceof bcer)) && ((parambcfr instanceof bcfo))) {
      parambcnz.b().setImageDrawable(bcni.a(this.a, parambcfr));
    }
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz, Bitmap paramBitmap)
  {
    if ((parambcnz.b() != null) && (!(parambcfr instanceof bcer))) {
      parambcnz.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bcnz parambcnz, bcfr parambcfr)
  {
    if ((parambcnz.a() != null) && (parambcfr != null)) {
      parambcnz.a().setText(parambcfr.a());
    }
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    d(parambcfr, parambcnz);
    a(parambcnz, parambcfr);
    if (parambcnz.b() != null) {
      parambcnz.b().setText(parambcfr.b());
    }
    if (parambcnz.c() != null) {
      parambcnz.c().setText(parambcfr.c());
    }
    if (parambcnz.d() != null) {
      parambcnz.d().setText(parambcfr.d());
    }
    if (parambcnz.a() != null)
    {
      if (parambcfr.a()) {
        parambcnz.a().setVisibility(0);
      }
    }
    else
    {
      c(parambcfr, parambcnz);
      if (!(parambcfr instanceof bcer)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)parambcnz.a().findViewById(2131381271);
        ImageView localImageView = (ImageView)parambcnz.a().findViewById(2131365160);
        TextView localTextView = (TextView)parambcnz.a().findViewById(2131368180);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        bcer localbcer = (bcer)parambcfr;
        int i = parambcnz.a().getResources().getDimensionPixelSize(2131297401);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localbcer.c(), i, i);
        parambcnz.b().setImageDrawable(localURLDrawable);
        if ((localbcer.a() != null) && (localbcer.a().video_article.has()) && (localbcer.a().video_article.get() == bcni.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((bcer)parambcfr).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (parambcnz.a() != null) {
            parambcnz.a().setMaxWidth(agej.a(190.0F, parambcnz.a().getResources()));
          }
          if ((localbcer != null) && (localbcer.a() != null))
          {
            localObject = localbcer.a().hotword.get();
            i = localbcer.a().hotword_type.get();
            ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localbcer.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (parambcfr.c() == null) {
          parambcnz.c().setVisibility(8);
        }
      }
      catch (Exception parambcnz)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + parambcnz.toString());
        continue;
      }
      if (!TextUtils.isEmpty(parambcfr.b())) {}
      try
      {
        if (Integer.valueOf(parambcfr.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception parambcfr)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", parambcfr);
      }
      parambcnz.a().setVisibility(8);
      break;
      a(parambcfr, parambcnz);
    }
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    parambcnz = parambcnz.a();
    if (parambcnz != null) {
      parambcnz.setOnClickListener(new bcjj(this, parambcfr));
    }
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz)
  {
    parambcnz = parambcnz.a();
    if (parambcfr.a() == 0)
    {
      Integer localInteger1 = (Integer)parambcnz.getTag(2131381108);
      Integer localInteger2 = (Integer)parambcnz.getTag(2131381110);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        bcnl.a(parambcfr, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = parambcfr.a();
    int k = parambcfr.b();
    if ((parambcfr instanceof bcfs)) {}
    for (int i = ((bcfs)parambcfr).u;; i = 0)
    {
      bcnl.a(j, k, parambcnz, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcji
 * JD-Core Version:    0.7.0.1
 */