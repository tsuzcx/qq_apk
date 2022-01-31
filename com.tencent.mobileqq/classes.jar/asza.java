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

public class asza
  extends asyn
{
  public asza(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(asyu paramasyu)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, asyu paramasyu)
  {
    paramasyu = (aszb)paramasyu;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495314, paramViewGroup, false);
    paramasyu.g = ((TextView)paramViewGroup.findViewById(2131312545));
    paramasyu.e = ((ImageView)paramViewGroup.findViewById(2131302919));
    paramasyu.f = ((ImageView)paramViewGroup.findViewById(2131303669));
    return paramViewGroup;
  }
  
  public aszb a()
  {
    return new aszb(this);
  }
  
  public boolean a(asyu paramasyu)
  {
    return false;
  }
  
  public void d(asyu paramasyu)
  {
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext)) {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131640406), 0).a();
    }
    do
    {
      return;
      bacn localbacn = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramasyu.a.m);
      if (localbacn != null) {
        localbacn.c();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramasyu.a.m);
  }
  
  public void f(asyu paramasyu)
  {
    paramasyu = (aszb)paramasyu;
    Object localObject2 = (ataq)paramasyu.a;
    paramasyu.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((ataq)localObject2).n))
    {
      paramasyu.g.setVisibility(0);
      paramasyu.g.setText(((ataq)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramasyu.e.getTag(2131311070);
      localObject2 = ((ataq)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844567);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844567);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(azue.b(vms.a(BaseApplicationImpl.getContext(), 180.0F), vms.a(BaseApplicationImpl.getContext(), 180.0F), azvv.a(paramasyu.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(azue.c);
        paramasyu.e.setImageDrawable((Drawable)localObject1);
        localObject1 = axsk.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramasyu.f.setImageDrawable((Drawable)localObject1);
        return;
        paramasyu.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramasyu.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844567));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asza
 * JD-Core Version:    0.7.0.1
 */