import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class biqn
  implements View.OnClickListener
{
  biqn(biql parambiql) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = "";
    Object localObject2 = Uri.parse(biql.a(this.a).c());
    try
    {
      localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.a.f(this.a.jdField_a_of_type_JavaLangString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    bdll.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject2, "", "");
    ocd.a("0X8006A1D", "", "", (String)localObject2, "", "");
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694682, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqn
 * JD-Core Version:    0.7.0.1
 */