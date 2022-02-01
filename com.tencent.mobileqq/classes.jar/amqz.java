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

public abstract class amqz
  extends bloj
  implements aoog, blih
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private aoof jdField_a_of_type_Aoof;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public amqz(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    bhmq.a();
  }
  
  protected void a(amra paramamra, Bitmap paramBitmap)
  {
    a(paramamra, paramBitmap, true);
  }
  
  protected void a(amra paramamra, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramamra.d == null) {
      return;
    }
    if (antf.z.equals(paramamra.a))
    {
      paramamra.d.setBackgroundResource(2130844234);
      return;
    }
    if (antf.A.equals(paramamra.a))
    {
      paramamra.d.setBackgroundResource(2130844232);
      return;
    }
    if (antf.B.equals(paramamra.a))
    {
      paramamra.d.setBackgroundResource(2130844237);
      return;
    }
    if (antf.y.equals(paramamra.a))
    {
      paramamra.d.setBackgroundResource(2130839573);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((antf.aa.equals(paramamra.a)) && ((paramamra instanceof ajup)))
      {
        Object localObject = (Friends)((ajup)paramamra).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramamra.d.setBackgroundDrawable((Drawable)localObject);
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
          if (!(paramamra instanceof ajxk)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = bhmq.h();; paramBitmap = bhmq.a())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramamra.a, paramamra.b, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((paramamra.b != 1) || (!(paramamra.d instanceof DynamicAvatarView)) || (!(paramamra instanceof ajup))) {
          break label399;
        }
        if (((ajup)paramamra).b) {
          break label375;
        }
        paramamra.d.setBackgroundDrawable(null);
        ((DynamicAvatarView)paramamra.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramamra.a, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_a_of_type_Aoof.a(paramamra.b, paramamra.a);
        break label205;
      }
      label375:
      paramamra.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
      label399:
      paramamra.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
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
      if ((localObject != null) && ((localObject instanceof amra)))
      {
        localObject = (amra)localObject;
        if (paramString != null) {
          break label69;
        }
        a((amra)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((amra)localObject).a))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((amra)localObject).b != 1) || (!(((amra)localObject).d instanceof DynamicAvatarView)) || (!(localObject instanceof ajup))) {
          break label175;
        }
        if (((ajup)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((amra)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((amra)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((amra)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aoof.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
      aonz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_Aoof.a())
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.b();
      a(null, null);
    }
    aonz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqz
 * JD-Core Version:    0.7.0.1
 */