import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Hashtable;

public abstract class amoe
  extends BaseAdapter
  implements aoog, blih
{
  private int jdField_a_of_type_Int = 0;
  protected aoof a;
  private blih jdField_a_of_type_Blih;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public amoe(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_Aoof = new aoof(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  protected Bitmap a()
  {
    return bhmq.a();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (antf.Z.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130847439);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Aoof.a()) {
      this.jdField_a_of_type_Aoof.a(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  protected void a(ajsp paramajsp, Bitmap paramBitmap)
  {
    if (paramajsp.d == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (antf.z.equals(paramajsp.a))
          {
            paramajsp.d.setBackgroundResource(2130844234);
            return;
          }
          if (antf.A.equals(paramajsp.a))
          {
            paramajsp.d.setBackgroundResource(2130844232);
            return;
          }
          if (antf.B.equals(paramajsp.a))
          {
            paramajsp.d.setBackgroundResource(2130844237);
            return;
          }
          if (antf.y.equals(paramajsp.a))
          {
            paramajsp.d.setBackgroundResource(2130839573);
            return;
          }
          if ((!antf.aa.equals(paramajsp.a)) || (!(paramajsp instanceof ajup))) {
            break;
          }
          paramBitmap = (ajup)paramajsp;
        } while (!(paramBitmap.a instanceof Friends));
        paramBitmap = (Friends)paramBitmap.a;
      } while (paramBitmap == null);
      if (!DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name)) {
        break;
      }
      paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
    } while (paramBitmap == null);
    paramajsp.d.setBackgroundDrawable(paramBitmap);
    return;
    paramajsp.d.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
    return;
    if (paramBitmap != null)
    {
      paramajsp.d.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    paramajsp.d.setBackgroundDrawable(new BitmapDrawable(a(paramajsp.jdField_b_of_type_Int, paramajsp.a)));
  }
  
  public void a(blih paramblih)
  {
    this.jdField_a_of_type_Blih = paramblih;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        amof localamof = (amof)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localamof != null) && (localamof.a != null) && (localamof.a.length() > 0) && (localamof.a.equals(paramString))) {
          localamof.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
    }
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.d();
      this.jdField_a_of_type_Aoof = new aoof(null, paramQQAppInterface);
      this.jdField_a_of_type_Aoof.a(this);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aoof.a());
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
    } while (paramInt1 > 0);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        paramBitmap = paramString.getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof amof)))
        {
          paramString = (amof)paramBitmap;
          if ((paramString != null) && (paramString.a != null) && (paramString.a.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if ((paramString instanceof QzoneSearchResultView))
          {
            paramString = (QzoneSearchResultView)paramString;
            if ((paramString != null) && (!TextUtils.isEmpty(paramString.a())))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a());
              if (paramBitmap != null) {
                paramString.setAvartaView(paramBitmap);
              }
            }
          }
          else if ((paramBitmap != null) && ((paramBitmap instanceof ajsp)))
          {
            paramString = (ajsp)paramBitmap;
            a(paramString, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a));
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Aoof.a()) {
        this.jdField_a_of_type_Aoof.b();
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof amof)))
          {
            localObject = (amof)localObject;
            if ((localObject != null) && (((amof)localObject).a != null) && (((amof)localObject).a.length() > 0)) {
              ((amof)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((amof)localObject).jdField_c_of_type_Int, ((amof)localObject).a));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject != null) && ((localObject instanceof ajsp)))
            {
              localObject = (ajsp)localObject;
              a((ajsp)localObject, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(((ajsp)localObject).a));
            }
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
    }
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoe
 * JD-Core Version:    0.7.0.1
 */