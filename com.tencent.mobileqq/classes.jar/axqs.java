import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.1;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.2;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.3;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axqs
  extends AbstractImageAdapter
  implements axqy
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private axqy jdField_a_of_type_Axqy;
  
  public axqs(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = nlw.a();
    if ((i != 1) && (i != 4)) {}
    axqw localaxqw;
    do
    {
      return;
      localaxqw = (axqw)getItem(paramInt + 1);
      if (localaxqw != null) {
        localaxqw.a();
      }
      localaxqw = (axqw)getItem(paramInt - 1);
    } while (localaxqw == null);
    localaxqw.a();
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
    ((axqw)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void a(axqy paramaxqy)
  {
    this.jdField_a_of_type_Axqy = paramaxqy;
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
      localObject = (axqw)getItem(paramInt);
      PicInfo localPicInfo = ((axqw)localObject).a;
      if (((this.jdField_a_of_type_AndroidContentContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).b)) {
        ((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app.a().b(localPicInfo.a);
      }
      localObject = ((axqw)localObject).a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
      ((View)localObject).setTag(2131296390, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */