import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class bbbq
  implements View.OnClickListener
{
  bbbq(bbbo parambbbo) {}
  
  public void onClick(View paramView)
  {
    paramView = "";
    Object localObject = Uri.parse(bbbo.a(this.a).c());
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
      paramView = (View)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.a.f(this.a.jdField_a_of_type_JavaLangString);
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = "";
    }
    awqx.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject, "", "");
    ndn.a("0X8006A1D", "", "", (String)localObject, "", "");
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      bbmy.a(BaseApplicationImpl.getContext(), 0, 2131629909, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167766));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbbq
 * JD-Core Version:    0.7.0.1
 */