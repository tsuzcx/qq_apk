import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class bcfe
  implements View.OnClickListener
{
  bcfe(bcfc parambcfc) {}
  
  public void onClick(View paramView)
  {
    paramView = "";
    Object localObject = Uri.parse(bcfc.a(this.a).c());
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
    axqy.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject, "", "");
    nol.a("0X8006A1D", "", "", (String)localObject, "", "");
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      bcql.a(BaseApplicationImpl.getContext(), 0, 2131695591, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfe
 * JD-Core Version:    0.7.0.1
 */