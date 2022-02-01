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

public class bbqp
  implements bbpr<bbmy, bbvg>
{
  private aobu a;
  
  public bbqp(aobu paramaobu)
  {
    this.a = paramaobu;
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    if ((parambbvg.b() != null) && (!(parambbmy instanceof bbly)) && ((parambbmy instanceof bbmv))) {
      parambbvg.b().setImageDrawable(bbup.a(this.a, parambbmy));
    }
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg, Bitmap paramBitmap)
  {
    if ((parambbvg.b() != null) && (!(parambbmy instanceof bbly))) {
      parambbvg.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bbvg parambbvg, bbmy parambbmy)
  {
    if ((parambbvg.a() != null) && (parambbmy != null)) {
      parambbvg.a().setText(parambbmy.a());
    }
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    d(parambbmy, parambbvg);
    a(parambbvg, parambbmy);
    if (parambbvg.b() != null) {
      parambbvg.b().setText(parambbmy.b());
    }
    if (parambbvg.c() != null) {
      parambbvg.c().setText(parambbmy.c());
    }
    if (parambbvg.d() != null) {
      parambbvg.d().setText(parambbmy.d());
    }
    if (parambbvg.a() != null)
    {
      if (parambbmy.a()) {
        parambbvg.a().setVisibility(0);
      }
    }
    else
    {
      c(parambbmy, parambbvg);
      if (!(parambbmy instanceof bbly)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)parambbvg.a().findViewById(2131381099);
        ImageView localImageView = (ImageView)parambbvg.a().findViewById(2131365114);
        TextView localTextView = (TextView)parambbvg.a().findViewById(2131368108);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        bbly localbbly = (bbly)parambbmy;
        int i = parambbvg.a().getResources().getDimensionPixelSize(2131297389);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localbbly.c(), i, i);
        parambbvg.b().setImageDrawable(localURLDrawable);
        if ((localbbly.a() != null) && (localbbly.a().video_article.has()) && (localbbly.a().video_article.get() == bbup.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((bbly)parambbmy).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (parambbvg.a() != null) {
            parambbvg.a().setMaxWidth(afur.a(190.0F, parambbvg.a().getResources()));
          }
          if ((localbbly != null) && (localbbly.a() != null))
          {
            localObject = localbbly.a().hotword.get();
            i = localbbly.a().hotword_type.get();
            oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localbbly.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (parambbmy.c() == null) {
          parambbvg.c().setVisibility(8);
        }
      }
      catch (Exception parambbvg)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + parambbvg.toString());
        continue;
      }
      if (!TextUtils.isEmpty(parambbmy.b())) {}
      try
      {
        if (Integer.valueOf(parambbmy.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception parambbmy)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", parambbmy);
      }
      parambbvg.a().setVisibility(8);
      break;
      a(parambbmy, parambbvg);
    }
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    parambbvg = parambbvg.a();
    if (parambbvg != null) {
      parambbvg.setOnClickListener(new bbqq(this, parambbmy));
    }
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg)
  {
    parambbvg = parambbvg.a();
    if (parambbmy.a() == 0)
    {
      Integer localInteger1 = (Integer)parambbvg.getTag(2131380928);
      Integer localInteger2 = (Integer)parambbvg.getTag(2131380930);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        bbus.a(parambbmy, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = parambbmy.a();
    int k = parambbmy.b();
    if ((parambbmy instanceof bbmz)) {}
    for (int i = ((bbmz)parambbmy).s;; i = 0)
    {
      bbus.a(j, k, parambbvg, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqp
 * JD-Core Version:    0.7.0.1
 */