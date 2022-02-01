import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;

public abstract class amju
  extends blef
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  protected ExpandableListView a;
  
  public amju(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    bheg.a();
  }
  
  protected void a(amjv paramamjv, Bitmap paramBitmap)
  {
    a(paramamjv, paramBitmap, true);
  }
  
  protected void a(amjv paramamjv, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramamjv.d == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramamjv.a))
    {
      paramamjv.d.setBackgroundResource(2130844186);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramamjv.a))
    {
      paramamjv.d.setBackgroundResource(2130844184);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramamjv.a))
    {
      paramamjv.d.setBackgroundResource(2130844189);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramamjv.a))
    {
      paramamjv.d.setBackgroundResource(2130839629);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((AppConstants.SMARTDEVICE_UIN.equals(paramamjv.a)) && ((paramamjv instanceof ajlb)))
      {
        Object localObject = (Friends)((ajlb)paramamjv).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramamjv.d.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByDin(((Friends)localObject).name);
          }
        }
        paramBitmap = localBitmap;
      }
    }
    for (;;)
    {
      label205:
      localBitmap = paramBitmap;
      if (paramBitmap == null) {
        if (paramBoolean) {
          if (!(paramamjv instanceof ajnw)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bheg.h();; paramBitmap = bheg.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramamjv.a, paramamjv.b, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramamjv.b != 1) || (!(paramamjv.d instanceof DynamicAvatarView)) || (!(paramamjv instanceof ajlb))) {
          break label399;
        }
        if (((ajlb)paramamjv).b) {
          break label375;
        }
        paramamjv.d.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramamjv.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramamjv.a, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramamjv.b, paramamjv.a);
        break label205;
      }
      label375:
      paramamjv.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramamjv.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof amjv)))
      {
        localObject = (amjv)localObject;
        if (paramString != null) {
          break label69;
        }
        a((amjv)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((amjv)localObject).a))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((amjv)localObject).b != 1) || (!(((amjv)localObject).d instanceof DynamicAvatarView)) || (!(localObject instanceof ajlb))) {
          break label175;
        }
        if (((ajlb)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((amjv)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((amjv)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((amjv)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      aokb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
      a(null, null);
    }
    aokb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amju
 * JD-Core Version:    0.7.0.1
 */