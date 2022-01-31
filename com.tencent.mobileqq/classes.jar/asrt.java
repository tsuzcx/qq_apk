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

public class asrt
  extends AbstractImageAdapter
  implements asrz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private asrz jdField_a_of_type_Asrz;
  
  public asrt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = mpl.a();
    if ((i != 1) && (i != 4)) {}
    asrx localasrx;
    do
    {
      return;
      localasrx = (asrx)getItem(paramInt + 1);
      if (localasrx != null) {
        localasrx.a();
      }
      localasrx = (asrx)getItem(paramInt - 1);
    } while (localasrx == null);
    localasrx.a();
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
    ((asrx)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void a(asrz paramasrz)
  {
    this.jdField_a_of_type_Asrz = paramasrz;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.2(this, paramInt1, paramInt2));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      return paramView;
    }
    paramView = (asrx)getItem(paramInt);
    paramViewGroup = paramView.a;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).b)) {
      ((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app.a().b(paramViewGroup.a);
    }
    paramView = paramView.a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
    paramView.setTag(2131296390, Boolean.valueOf(true));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asrt
 * JD-Core Version:    0.7.0.1
 */