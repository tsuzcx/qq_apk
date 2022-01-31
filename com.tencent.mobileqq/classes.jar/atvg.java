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

public class atvg
  extends atut
{
  public atvg(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atva paramatva)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, atva paramatva)
  {
    paramatva = (atvh)paramatva;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560891, paramViewGroup, false);
    paramatva.g = ((TextView)paramViewGroup.findViewById(2131378373));
    paramatva.e = ((ImageView)paramViewGroup.findViewById(2131368543));
    paramatva.f = ((ImageView)paramViewGroup.findViewById(2131369339));
    return paramViewGroup;
  }
  
  public atvh a()
  {
    return new atvh(this);
  }
  
  public boolean a(atva paramatva)
  {
    return false;
  }
  
  public void d(atva paramatva)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext)) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131706202), 0).a();
    }
    do
    {
      return;
      bbeg localbbeg = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramatva.a.m);
      if (localbbeg != null) {
        localbbeg.c();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramatva.a.m);
  }
  
  public void f(atva paramatva)
  {
    paramatva = (atvh)paramatva;
    Object localObject2 = (atww)paramatva.a;
    paramatva.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((atww)localObject2).n))
    {
      paramatva.g.setVisibility(0);
      paramatva.g.setText(((atww)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramatva.e.getTag(2131376882);
      localObject2 = ((atww)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844649);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844649);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bavw.b(vzl.a(BaseApplicationImpl.getContext(), 180.0F), vzl.a(BaseApplicationImpl.getContext(), 180.0F), baxn.a(paramatva.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bavw.c);
        paramatva.e.setImageDrawable((Drawable)localObject1);
        localObject1 = ayst.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramatva.f.setImageDrawable((Drawable)localObject1);
        return;
        paramatva.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramatva.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844649));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvg
 * JD-Core Version:    0.7.0.1
 */