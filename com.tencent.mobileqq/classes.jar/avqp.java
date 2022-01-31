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

public class avqp
  extends avqc
{
  public avqp(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avqj paramavqj)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, avqj paramavqj)
  {
    paramavqj = (avqq)paramavqj;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561092, paramViewGroup, false);
    paramavqj.g = ((TextView)paramViewGroup.findViewById(2131379033));
    paramavqj.e = ((ImageView)paramViewGroup.findViewById(2131368753));
    paramavqj.f = ((ImageView)paramViewGroup.findViewById(2131369595));
    return paramViewGroup;
  }
  
  public avqq a()
  {
    return new avqq(this);
  }
  
  public boolean a(avqj paramavqj)
  {
    return false;
  }
  
  public void d(avqj paramavqj)
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131706586), 0).a();
    }
    do
    {
      return;
      bdhk localbdhk = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramavqj.a.m);
      if (localbdhk != null) {
        localbdhk.c();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramavqj.a.m);
  }
  
  public void f(avqj paramavqj)
  {
    paramavqj = (avqq)paramavqj;
    Object localObject2 = (avsf)paramavqj.a;
    paramavqj.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((avsf)localObject2).n))
    {
      paramavqj.g.setVisibility(0);
      paramavqj.g.setText(((avsf)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramavqj.e.getTag(2131377450);
      localObject2 = ((avsf)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845085);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845085);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bcyz.b(xsm.a(BaseApplicationImpl.getContext(), 180.0F), xsm.a(BaseApplicationImpl.getContext(), 180.0F), bdaq.a(paramavqj.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bcyz.c);
        paramavqj.e.setImageDrawable((Drawable)localObject1);
        localObject1 = bauz.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramavqj.f.setImageDrawable((Drawable)localObject1);
        return;
        paramavqj.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramavqj.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845085));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqp
 * JD-Core Version:    0.7.0.1
 */