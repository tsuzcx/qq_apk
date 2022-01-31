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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class avmg
  extends avlt
{
  public avmg(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avma paramavma)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, avma paramavma)
  {
    paramavma = (avmh)paramavma;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561074, paramViewGroup, false);
    paramavma.g = ((TextView)paramViewGroup.findViewById(2131378975));
    paramavma.e = ((ImageView)paramViewGroup.findViewById(2131368739));
    paramavma.f = ((ImageView)paramViewGroup.findViewById(2131369577));
    return paramViewGroup;
  }
  
  public avmh a()
  {
    return new avmh(this);
  }
  
  public boolean a(avma paramavma)
  {
    return false;
  }
  
  public void d(avma paramavma)
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131706574), 0).a();
    }
    do
    {
      return;
      bddb localbddb = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramavma.a.m);
      if (localbddb != null) {
        localbddb.c();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramavma.a.m);
  }
  
  public void f(avma paramavma)
  {
    paramavma = (avmh)paramavma;
    Object localObject2 = (avnw)paramavma.a;
    paramavma.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((avnw)localObject2).n))
    {
      paramavma.g.setVisibility(0);
      paramavma.g.setText(((avnw)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramavma.e.getTag(2131377396);
      localObject2 = ((avnw)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845013);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845013);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bcuq.b(xod.a(BaseApplicationImpl.getContext(), 180.0F), xod.a(BaseApplicationImpl.getContext(), 180.0F), bcwh.a(paramavma.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bcuq.c);
        paramavma.e.setImageDrawable((Drawable)localObject1);
        localObject1 = baqq.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramavma.f.setImageDrawable((Drawable)localObject1);
        return;
        paramavma.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramavma.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845013));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmg
 * JD-Core Version:    0.7.0.1
 */