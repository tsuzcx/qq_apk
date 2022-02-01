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

public class axeb
  extends axdo
{
  public axeb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axdv paramaxdv)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, axdv paramaxdv)
  {
    paramaxdv = (axec)paramaxdv;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561216, paramViewGroup, false);
    paramaxdv.g = ((TextView)paramViewGroup.findViewById(2131379865));
    paramaxdv.e = ((ImageView)paramViewGroup.findViewById(2131369207));
    paramaxdv.f = ((ImageView)paramViewGroup.findViewById(2131370089));
    return paramViewGroup;
  }
  
  public axec a()
  {
    return new axec(this);
  }
  
  public boolean a(axdv paramaxdv)
  {
    return false;
  }
  
  public void d(axdv paramaxdv)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131705334), 0).a();
    }
    do
    {
      return;
      bfvp localbfvp = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramaxdv.a.m);
      if (localbfvp != null) {
        localbfvp.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramaxdv.a.m);
  }
  
  public void f(axdv paramaxdv)
  {
    paramaxdv = (axec)paramaxdv;
    Object localObject2 = (axfr)paramaxdv.a;
    paramaxdv.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((axfr)localObject2).n))
    {
      paramaxdv.g.setVisibility(0);
      paramaxdv.g.setText(((axfr)localObject2).n);
    }
    for (;;)
    {
      Object localObject1 = (String)paramaxdv.e.getTag(2131378207);
      localObject2 = ((axfr)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845375);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845375);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bfol.b(UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F), UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F), DisplayUtil.dip2px(paramaxdv.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bfol.c);
        paramaxdv.e.setImageDrawable((Drawable)localObject1);
        localObject1 = NearbyImgDownloader.convertURL("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramaxdv.f.setImageDrawable((Drawable)localObject1);
        return;
        paramaxdv.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramaxdv.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845375));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axeb
 * JD-Core Version:    0.7.0.1
 */