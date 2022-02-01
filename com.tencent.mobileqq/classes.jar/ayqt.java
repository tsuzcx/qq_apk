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

public class ayqt
  extends ayqg
{
  public ayqt(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayqn paramayqn)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, ayqn paramayqn)
  {
    paramayqn = (ayqu)paramayqn;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561341, paramViewGroup, false);
    paramayqn.g = ((TextView)paramViewGroup.findViewById(2131380126));
    paramayqn.e = ((ImageView)paramViewGroup.findViewById(2131369184));
    paramayqn.f = ((ImageView)paramViewGroup.findViewById(2131370092));
    return paramViewGroup;
  }
  
  public ayqu a()
  {
    return new ayqu(this);
  }
  
  public boolean a(ayqn paramayqn)
  {
    return false;
  }
  
  public void d(ayqn paramayqn)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131705104), 0).a();
    }
    do
    {
      return;
      bhmr localbhmr = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramayqn.a.m);
      if (localbhmr != null) {
        localbhmr.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramayqn.a.m);
  }
  
  public void f(ayqn paramayqn)
  {
    paramayqn = (ayqu)paramayqn;
    Object localObject2 = (aysj)paramayqn.a;
    paramayqn.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((aysj)localObject2).n))
    {
      paramayqn.g.setVisibility(0);
      paramayqn.g.setText(((aysj)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramayqn.e.getTag(2131378440);
      localObject2 = ((aysj)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845496);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845496);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bhez.b(zps.a(BaseApplicationImpl.getContext(), 180.0F), zps.a(BaseApplicationImpl.getContext(), 180.0F), bhgr.a(paramayqn.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bhez.c);
        paramayqn.e.setImageDrawable((Drawable)localObject1);
        localObject1 = bevg.a("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramayqn.f.setImageDrawable((Drawable)localObject1);
        return;
        paramayqn.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramayqn.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845496));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqt
 * JD-Core Version:    0.7.0.1
 */