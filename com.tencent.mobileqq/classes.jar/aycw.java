import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.1;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.2;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.3;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aycw
  extends AbstractImageAdapter
  implements aydc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private aydc jdField_a_of_type_Aydc;
  
  public aycw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = HttpUtil.getNetWorkType();
    if ((i != 1) && (i != 4)) {}
    ayda localayda;
    do
    {
      return;
      localayda = (ayda)getItem(paramInt + 1);
      if (localayda != null) {
        localayda.a();
      }
      localayda = (ayda)getItem(paramInt - 1);
    } while (localayda == null);
    localayda.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.1(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.3(this, paramInt, paramBoolean));
  }
  
  public void a(View paramView, int paramInt)
  {
    ((ayda)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void a(aydc paramaydc)
  {
    this.jdField_a_of_type_Aydc = paramaydc;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.2(this, paramInt1, paramInt2));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (ayda)getItem(paramInt);
      PicInfo localPicInfo = ((ayda)localObject).a;
      if (((this.jdField_a_of_type_AndroidContentContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).b)) {
        ((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app.getNearbyProxy().b(localPicInfo.a);
      }
      localObject = ((ayda)localObject).a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
      ((View)localObject).setTag(2131296390, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycw
 * JD-Core Version:    0.7.0.1
 */