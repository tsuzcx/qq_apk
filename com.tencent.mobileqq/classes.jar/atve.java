import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class atve
  extends atur
{
  public atve(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atuy paramatuy)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, atuy paramatuy)
  {
    paramatuy = (atvf)paramatuy;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560892, paramViewGroup, false);
    paramatuy.g = ((TextView)paramViewGroup.findViewById(2131378370));
    paramatuy.e = ((ImageView)paramViewGroup.findViewById(2131368544));
    paramatuy.f = ((ImageView)paramViewGroup.findViewById(2131369339));
    return paramViewGroup;
  }
  
  public atvf a()
  {
    return new atvf(this);
  }
  
  public boolean a(atuy paramatuy)
  {
    return false;
  }
  
  public void d(atuy paramatuy)
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext)) {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131706191), 0).a();
    }
    do
    {
      return;
      bbds localbbds = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramatuy.a.m);
      if (localbbds != null) {
        localbbds.c();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramatuy.a.m);
  }
  
  public void f(atuy paramatuy)
  {
    paramatuy = (atvf)paramatuy;
    Object localObject2 = (atwu)paramatuy.a;
    paramatuy.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((atwu)localObject2).n))
    {
      paramatuy.g.setVisibility(0);
      paramatuy.g.setText(((atwu)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramatuy.e.getTag(2131376880);
      localObject2 = ((atwu)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844648);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844648);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bavi.b(vzo.a(BaseApplicationImpl.getContext(), 180.0F), vzo.a(BaseApplicationImpl.getContext(), 180.0F), bawz.a(paramatuy.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bavi.c);
        paramatuy.e.setImageDrawable((Drawable)localObject1);
        localObject1 = aysr.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramatuy.f.setImageDrawable((Drawable)localObject1);
        return;
        paramatuy.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramatuy.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844648));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atve
 * JD-Core Version:    0.7.0.1
 */