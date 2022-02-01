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

public class axxz
  extends axxm
{
  public axxz(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axxt paramaxxt)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, axxt paramaxxt)
  {
    paramaxxt = (axya)paramaxxt;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561303, paramViewGroup, false);
    paramaxxt.g = ((TextView)paramViewGroup.findViewById(2131379942));
    paramaxxt.e = ((ImageView)paramViewGroup.findViewById(2131369094));
    paramaxxt.f = ((ImageView)paramViewGroup.findViewById(2131369994));
    return paramViewGroup;
  }
  
  public axya a()
  {
    return new axya(this);
  }
  
  public boolean a(axxt paramaxxt)
  {
    return false;
  }
  
  public void d(axxt paramaxxt)
  {
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131704997), 0).a();
    }
    do
    {
      return;
      bgmp localbgmp = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramaxxt.a.m);
      if (localbgmp != null) {
        localbgmp.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramaxxt.a.m);
  }
  
  public void f(axxt paramaxxt)
  {
    paramaxxt = (axya)paramaxxt;
    Object localObject2 = (axzp)paramaxxt.a;
    paramaxxt.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((axzp)localObject2).n))
    {
      paramaxxt.g.setVisibility(0);
      paramaxxt.g.setText(((axzp)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramaxxt.e.getTag(2131378283);
      localObject2 = ((axzp)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845481);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845481);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bgey.b(zlx.a(BaseApplicationImpl.getContext(), 180.0F), zlx.a(BaseApplicationImpl.getContext(), 180.0F), bggq.a(paramaxxt.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bgey.c);
        paramaxxt.e.setImageDrawable((Drawable)localObject1);
        localObject1 = bdwn.a("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramaxxt.f.setImageDrawable((Drawable)localObject1);
        return;
        paramaxxt.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramaxxt.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845481));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxz
 * JD-Core Version:    0.7.0.1
 */