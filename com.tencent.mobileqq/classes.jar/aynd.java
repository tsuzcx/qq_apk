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

public class aynd
  implements aymf<ayjl, ayru>
{
  private bcws a;
  
  public aynd(bcws parambcws)
  {
    this.a = parambcws;
  }
  
  public void a(ayjl paramayjl, ayru paramayru)
  {
    if ((paramayru.b() != null) && (!(paramayjl instanceof ayil)) && ((paramayjl instanceof ayji))) {
      paramayru.b().setImageDrawable(ayrd.a(this.a, paramayjl));
    }
  }
  
  public void a(ayjl paramayjl, ayru paramayru, Bitmap paramBitmap)
  {
    if ((paramayru.b() != null) && (!(paramayjl instanceof ayil))) {
      paramayru.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ayru paramayru, ayjl paramayjl)
  {
    if ((paramayru.a() != null) && (paramayjl != null)) {
      paramayru.a().setText(paramayjl.a());
    }
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    d(paramayjl, paramayru);
    a(paramayru, paramayjl);
    if (paramayru.b() != null) {
      paramayru.b().setText(paramayjl.b());
    }
    if (paramayru.c() != null) {
      paramayru.c().setText(paramayjl.c());
    }
    if (paramayru.d() != null) {
      paramayru.d().setText(paramayjl.d());
    }
    if (paramayru.a() != null)
    {
      if (paramayjl.a()) {
        paramayru.a().setVisibility(0);
      }
    }
    else
    {
      c(paramayjl, paramayru);
      if (!(paramayjl instanceof ayil)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)paramayru.a().findViewById(2131380076);
        ImageView localImageView = (ImageView)paramayru.a().findViewById(2131364879);
        TextView localTextView = (TextView)paramayru.a().findViewById(2131367783);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        ayil localayil = (ayil)paramayjl;
        int i = paramayru.a().getResources().getDimensionPixelSize(2131297310);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localayil.c(), i, i);
        paramayru.b().setImageDrawable(localURLDrawable);
        if ((localayil.a() != null) && (localayil.a().video_article.has()) && (localayil.a().video_article.get() == ayrd.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((ayil)paramayjl).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramayru.a() != null) {
            paramayru.a().setMaxWidth(aekt.a(190.0F, paramayru.a().getResources()));
          }
          if ((localayil != null) && (localayil.a() != null))
          {
            localObject = localayil.a().hotword.get();
            i = localayil.a().hotword_type.get();
            nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localayil.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramayjl.c() == null) {
          paramayru.c().setVisibility(8);
        }
      }
      catch (Exception paramayru)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramayru.toString());
        continue;
      }
      if (!TextUtils.isEmpty(paramayjl.b())) {}
      try
      {
        if (Integer.valueOf(paramayjl.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception paramayjl)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", paramayjl);
      }
      paramayru.a().setVisibility(8);
      break;
      a(paramayjl, paramayru);
    }
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    paramayru = paramayru.a();
    if (paramayru != null) {
      paramayru.setOnClickListener(new ayne(this, paramayjl));
    }
  }
  
  public void d(ayjl paramayjl, ayru paramayru)
  {
    paramayru = paramayru.a();
    if (paramayjl.a() == 0)
    {
      Integer localInteger1 = (Integer)paramayru.getTag(2131379912);
      Integer localInteger2 = (Integer)paramayru.getTag(2131379914);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        ayrg.a(paramayjl, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramayjl.a();
    int k = paramayjl.b();
    if ((paramayjl instanceof ayjm)) {}
    for (int i = ((ayjm)paramayjl).r;; i = 0)
    {
      ayrg.a(j, k, paramayru, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynd
 * JD-Core Version:    0.7.0.1
 */