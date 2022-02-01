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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class aykg
  extends ayjt
{
  public aykg(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayka paramayka)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, ayka paramayka)
  {
    paramayka = (aykh)paramayka;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561277, paramViewGroup, false);
    paramayka.g = ((TextView)paramViewGroup.findViewById(2131380198));
    paramayka.e = ((ImageView)paramViewGroup.findViewById(2131369370));
    paramayka.f = ((ImageView)paramViewGroup.findViewById(2131370261));
    return paramViewGroup;
  }
  
  public aykh a()
  {
    return new aykh(this);
  }
  
  public boolean a(ayka paramayka)
  {
    return false;
  }
  
  public void d(ayka paramayka)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131705685), 0).a();
    }
    do
    {
      return;
      bheh localbheh = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramayka.a.m);
      if (localbheh != null) {
        localbheh.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramayka.a.m);
  }
  
  public void f(ayka paramayka)
  {
    paramayka = (aykh)paramayka;
    Object localObject2 = (aylw)paramayka.a;
    paramayka.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((aylw)localObject2).n))
    {
      paramayka.g.setVisibility(0);
      paramayka.g.setText(((aylw)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramayka.e.getTag(2131378495);
      localObject2 = ((aylw)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845460);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845460);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bgxc.b(UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F), UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F), DisplayUtil.dip2px(paramayka.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bgxc.c);
        paramayka.e.setImageDrawable((Drawable)localObject1);
        localObject1 = NearbyImgDownloader.convertURL("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramayka.f.setImageDrawable((Drawable)localObject1);
        return;
        paramayka.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramayka.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845460));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykg
 * JD-Core Version:    0.7.0.1
 */