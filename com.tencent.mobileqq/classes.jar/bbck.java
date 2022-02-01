import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class bbck
  implements bbbm<bayt, bbhb>
{
  private FaceDecoder a;
  
  public bbck(FaceDecoder paramFaceDecoder)
  {
    this.a = paramFaceDecoder;
  }
  
  public void a(bayt parambayt, bbhb parambbhb)
  {
    if ((parambbhb.b() != null) && (!(parambayt instanceof baxt)) && ((parambayt instanceof bayq))) {
      parambbhb.b().setImageDrawable(bbgk.a(this.a, parambayt));
    }
  }
  
  public void a(bayt parambayt, bbhb parambbhb, Bitmap paramBitmap)
  {
    if ((parambbhb.b() != null) && (!(parambayt instanceof baxt))) {
      parambbhb.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bbhb parambbhb, bayt parambayt)
  {
    if ((parambbhb.a() != null) && (parambayt != null)) {
      parambbhb.a().setText(parambayt.a());
    }
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    d(parambayt, parambbhb);
    a(parambbhb, parambayt);
    if (parambbhb.b() != null) {
      parambbhb.b().setText(parambayt.b());
    }
    if (parambbhb.c() != null) {
      parambbhb.c().setText(parambayt.c());
    }
    if (parambbhb.d() != null) {
      parambbhb.d().setText(parambayt.d());
    }
    if (parambbhb.a() != null)
    {
      if (parambayt.a()) {
        parambbhb.a().setVisibility(0);
      }
    }
    else
    {
      c(parambayt, parambbhb);
      if (!(parambayt instanceof baxt)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)parambbhb.a().findViewById(2131380989);
        ImageView localImageView = (ImageView)parambbhb.a().findViewById(2131365187);
        TextView localTextView = (TextView)parambbhb.a().findViewById(2131368208);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        baxt localbaxt = (baxt)parambayt;
        int i = parambbhb.a().getResources().getDimensionPixelSize(2131297456);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localbaxt.c(), i, i);
        parambbhb.b().setImageDrawable(localURLDrawable);
        if ((localbaxt.a() != null) && (localbaxt.a().video_article.has()) && (localbaxt.a().video_article.get() == bbgk.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((baxt)parambayt).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (parambbhb.a() != null) {
            parambbhb.a().setMaxWidth(AIOUtils.dp2px(190.0F, parambbhb.a().getResources()));
          }
          if ((localbaxt != null) && (localbaxt.a() != null))
          {
            localObject = localbaxt.a().hotword.get();
            i = localbaxt.a().hotword_type.get();
            odq.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localbaxt.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (parambayt.c() == null) {
          parambbhb.c().setVisibility(8);
        }
      }
      catch (Exception parambbhb)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + parambbhb.toString());
        continue;
      }
      if (!TextUtils.isEmpty(parambayt.b())) {}
      try
      {
        if (Integer.valueOf(parambayt.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception parambayt)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", parambayt);
      }
      parambbhb.a().setVisibility(8);
      break;
      a(parambayt, parambbhb);
    }
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    parambbhb = parambbhb.a();
    if (parambbhb != null) {
      parambbhb.setOnClickListener(new bbcl(this, parambayt));
    }
  }
  
  public void d(bayt parambayt, bbhb parambbhb)
  {
    parambbhb = parambbhb.a();
    if (parambayt.a() == 0)
    {
      Integer localInteger1 = (Integer)parambbhb.getTag(2131380830);
      Integer localInteger2 = (Integer)parambbhb.getTag(2131380832);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        bbgn.a(parambayt, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = parambayt.a();
    int k = parambayt.b();
    if ((parambayt instanceof bayu)) {}
    for (int i = ((bayu)parambayt).u;; i = 0)
    {
      bbgn.a(j, k, parambbhb, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbck
 * JD-Core Version:    0.7.0.1
 */