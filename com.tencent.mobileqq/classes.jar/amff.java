import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class amff
  extends bkng
  implements aobv, bkhe
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private aobu jdField_a_of_type_Aobu;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public amff(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Aobu = new aobu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
    bgmo.a();
  }
  
  protected void a(amfg paramamfg, Bitmap paramBitmap)
  {
    a(paramamfg, paramBitmap, true);
  }
  
  protected void a(amfg paramamfg, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramamfg.d == null) {
      return;
    }
    if (anhk.z.equals(paramamfg.a))
    {
      paramamfg.d.setBackgroundResource(2130844220);
      return;
    }
    if (anhk.A.equals(paramamfg.a))
    {
      paramamfg.d.setBackgroundResource(2130844218);
      return;
    }
    if (anhk.B.equals(paramamfg.a))
    {
      paramamfg.d.setBackgroundResource(2130844223);
      return;
    }
    if (anhk.y.equals(paramamfg.a))
    {
      paramamfg.d.setBackgroundResource(2130839564);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((anhk.aa.equals(paramamfg.a)) && ((paramamfg instanceof ajjg)))
      {
        Object localObject = (Friends)((ajjg)paramamfg).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramamfg.d.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramamfg instanceof ajmb)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bgmo.h();; paramBitmap = bgmo.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aobu.a())
        {
          this.jdField_a_of_type_Aobu.a(paramamfg.a, paramamfg.b, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramamfg.b != 1) || (!(paramamfg.d instanceof DynamicAvatarView)) || (!(paramamfg instanceof ajjg))) {
          break label399;
        }
        if (((ajjg)paramamfg).b) {
          break label375;
        }
        paramamfg.d.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramamfg.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramamfg.a, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Aobu.a(paramamfg.b, paramamfg.a);
        break label205;
      }
      label375:
      paramamfg.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramamfg.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof amfg)))
      {
        localObject = (amfg)localObject;
        if (paramString != null) {
          break label69;
        }
        a((amfg)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((amfg)localObject).a))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((amfg)localObject).b != 1) || (!(((amfg)localObject).d instanceof DynamicAvatarView)) || (!(localObject instanceof ajjg))) {
          break label175;
        }
        if (((ajjg)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((amfg)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((amfg)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((amfg)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aobu.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.c();
      aobo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Aobu.a())
    {
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.b();
      a(null, null);
    }
    aobo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amff
 * JD-Core Version:    0.7.0.1
 */