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

public class ayrm
  implements ayqo<aynu, aywd>
{
  private bdbb a;
  
  public ayrm(bdbb parambdbb)
  {
    this.a = parambdbb;
  }
  
  public void a(aynu paramaynu, aywd paramaywd)
  {
    if ((paramaywd.b() != null) && (!(paramaynu instanceof aymu)) && ((paramaynu instanceof aynr))) {
      paramaywd.b().setImageDrawable(ayvm.a(this.a, paramaynu));
    }
  }
  
  public void a(aynu paramaynu, aywd paramaywd, Bitmap paramBitmap)
  {
    if ((paramaywd.b() != null) && (!(paramaynu instanceof aymu))) {
      paramaywd.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(aywd paramaywd, aynu paramaynu)
  {
    if ((paramaywd.a() != null) && (paramaynu != null)) {
      paramaywd.a().setText(paramaynu.a());
    }
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    d(paramaynu, paramaywd);
    a(paramaywd, paramaynu);
    if (paramaywd.b() != null) {
      paramaywd.b().setText(paramaynu.b());
    }
    if (paramaywd.c() != null) {
      paramaywd.c().setText(paramaynu.c());
    }
    if (paramaywd.d() != null) {
      paramaywd.d().setText(paramaynu.d());
    }
    if (paramaywd.a() != null)
    {
      if (paramaynu.a()) {
        paramaywd.a().setVisibility(0);
      }
    }
    else
    {
      c(paramaynu, paramaywd);
      if (!(paramaynu instanceof aymu)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)paramaywd.a().findViewById(2131380134);
        ImageView localImageView = (ImageView)paramaywd.a().findViewById(2131364881);
        TextView localTextView = (TextView)paramaywd.a().findViewById(2131367793);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        aymu localaymu = (aymu)paramaynu;
        int i = paramaywd.a().getResources().getDimensionPixelSize(2131297310);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localaymu.c(), i, i);
        paramaywd.b().setImageDrawable(localURLDrawable);
        if ((localaymu.a() != null) && (localaymu.a().video_article.has()) && (localaymu.a().video_article.get() == ayvm.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((aymu)paramaynu).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramaywd.a() != null) {
            paramaywd.a().setMaxWidth(aepi.a(190.0F, paramaywd.a().getResources()));
          }
          if ((localaymu != null) && (localaymu.a() != null))
          {
            localObject = localaymu.a().hotword.get();
            i = localaymu.a().hotword_type.get();
            nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localaymu.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramaynu.c() == null) {
          paramaywd.c().setVisibility(8);
        }
      }
      catch (Exception paramaywd)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramaywd.toString());
        continue;
      }
      if (!TextUtils.isEmpty(paramaynu.b())) {}
      try
      {
        if (Integer.valueOf(paramaynu.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception paramaynu)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", paramaynu);
      }
      paramaywd.a().setVisibility(8);
      break;
      a(paramaynu, paramaywd);
    }
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    paramaywd = paramaywd.a();
    if (paramaywd != null) {
      paramaywd.setOnClickListener(new ayrn(this, paramaynu));
    }
  }
  
  public void d(aynu paramaynu, aywd paramaywd)
  {
    paramaywd = paramaywd.a();
    if (paramaynu.a() == 0)
    {
      Integer localInteger1 = (Integer)paramaywd.getTag(2131379970);
      Integer localInteger2 = (Integer)paramaywd.getTag(2131379972);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        ayvp.a(paramaynu, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramaynu.a();
    int k = paramaynu.b();
    if ((paramaynu instanceof aynv)) {}
    for (int i = ((aynv)paramaynu).r;; i = 0)
    {
      ayvp.a(j, k, paramaywd, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrm
 * JD-Core Version:    0.7.0.1
 */