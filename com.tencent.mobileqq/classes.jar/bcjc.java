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

public class bcjc
  implements bcie<bcfj, bcnt>
{
  private FaceDecoder a;
  
  public bcjc(FaceDecoder paramFaceDecoder)
  {
    this.a = paramFaceDecoder;
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    if ((parambcnt.b() != null) && (!(parambcfj instanceof bcej)) && ((parambcfj instanceof bcfg))) {
      parambcnt.b().setImageDrawable(bcnc.a(this.a, parambcfj));
    }
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt, Bitmap paramBitmap)
  {
    if ((parambcnt.b() != null) && (!(parambcfj instanceof bcej))) {
      parambcnt.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bcnt parambcnt, bcfj parambcfj)
  {
    if ((parambcnt.a() != null) && (parambcfj != null)) {
      parambcnt.a().setText(parambcfj.a());
    }
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    d(parambcfj, parambcnt);
    a(parambcnt, parambcfj);
    if (parambcnt.b() != null) {
      parambcnt.b().setText(parambcfj.b());
    }
    if (parambcnt.c() != null) {
      parambcnt.c().setText(parambcfj.c());
    }
    if (parambcnt.d() != null) {
      parambcnt.d().setText(parambcfj.d());
    }
    if (parambcnt.a() != null)
    {
      if (parambcfj.a()) {
        parambcnt.a().setVisibility(0);
      }
    }
    else
    {
      c(parambcfj, parambcnt);
      if (!(parambcfj instanceof bcej)) {
        break label544;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)parambcnt.a().findViewById(2131381344);
        ImageView localImageView = (ImageView)parambcnt.a().findViewById(2131365278);
        TextView localTextView = (TextView)parambcnt.a().findViewById(2131368352);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        bcej localbcej = (bcej)parambcfj;
        int i = parambcnt.a().getResources().getDimensionPixelSize(2131297457);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localbcej.c(), i, i);
        parambcnt.b().setImageDrawable(localURLDrawable);
        if ((localbcej.a() != null) && (localbcej.a().video_article.has()) && (localbcej.a().video_article.get() == bcnc.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((bcej)parambcfj).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (parambcnt.a() != null) {
            parambcnt.a().setMaxWidth(AIOUtils.dp2px(190.0F, parambcnt.a().getResources()));
          }
          if ((localbcej != null) && (localbcej.a() != null))
          {
            localObject = localbcej.a().hotword.get();
            i = localbcej.a().hotword_type.get();
            olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localbcej.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (parambcfj.c() == null) {
          parambcnt.c().setVisibility(8);
        }
      }
      catch (Exception parambcnt)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + parambcnt.toString());
        continue;
      }
      if (!TextUtils.isEmpty(parambcfj.b())) {}
      try
      {
        if (Integer.valueOf(parambcfj.b()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception parambcfj)
      {
        label544:
        QLog.e("SearchResultPresenter", 1, "report expo failed", parambcfj);
      }
      parambcnt.a().setVisibility(8);
      break;
      a(parambcfj, parambcnt);
    }
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    parambcnt = parambcnt.a();
    if (parambcnt != null) {
      parambcnt.setOnClickListener(new bcjd(this, parambcfj));
    }
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt)
  {
    parambcnt = parambcnt.a();
    if (parambcfj.a() == 0)
    {
      Integer localInteger1 = (Integer)parambcnt.getTag(2131381182);
      Integer localInteger2 = (Integer)parambcnt.getTag(2131381184);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        bcnf.a(parambcfj, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = parambcfj.a();
    int k = parambcfj.b();
    if ((parambcfj instanceof bcfk)) {}
    for (int i = ((bcfk)parambcfj).u;; i = 0)
    {
      bcnf.a(j, k, parambcnt, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjc
 * JD-Core Version:    0.7.0.1
 */