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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Hashtable;

public abstract class amgy
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected FaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public amgy(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  protected Bitmap a()
  {
    return bheg.a();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (AppConstants.SEC_MSG_UIN.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130847436);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  protected void a(ajjb paramajjb, Bitmap paramBitmap)
  {
    if (paramajjb.d == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (AppConstants.DATALINE_PC_UIN.equals(paramajjb.a))
          {
            paramajjb.d.setBackgroundResource(2130844186);
            return;
          }
          if (AppConstants.DATALINE_IPAD_UIN.equals(paramajjb.a))
          {
            paramajjb.d.setBackgroundResource(2130844184);
            return;
          }
          if (AppConstants.DATALINE_PRINTER_UIN.equals(paramajjb.a))
          {
            paramajjb.d.setBackgroundResource(2130844189);
            return;
          }
          if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramajjb.a))
          {
            paramajjb.d.setBackgroundResource(2130839629);
            return;
          }
          if ((!AppConstants.SMARTDEVICE_UIN.equals(paramajjb.a)) || (!(paramajjb instanceof ajlb))) {
            break;
          }
          paramBitmap = (ajlb)paramajjb;
        } while (!(paramBitmap.a instanceof Friends));
        paramBitmap = (Friends)paramBitmap.a;
      } while (paramBitmap == null);
      if (!DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name)) {
        break;
      }
      paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
    } while (paramBitmap == null);
    paramajjb.d.setBackgroundDrawable(paramBitmap);
    return;
    paramajjb.d.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
    return;
    if (paramBitmap != null)
    {
      paramajjb.d.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    paramajjb.d.setBackgroundDrawable(new BitmapDrawable(a(paramajjb.jdField_b_of_type_Int, paramajjb.a)));
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
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
        amgz localamgz = (amgz)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localamgz != null) && (localamgz.a != null) && (localamgz.a.length() > 0) && (localamgz.a.equals(paramString))) {
          localamgz.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(null, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
      } while (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing());
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
        if ((paramBitmap != null) && ((paramBitmap instanceof amgz)))
        {
          paramString = (amgz)paramBitmap;
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
            if ((paramString != null) && (!TextUtils.isEmpty(paramString.getUin())))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.getUin());
              if (paramBitmap != null) {
                paramString.setAvartaView(paramBitmap);
              }
            }
          }
          else if ((paramBitmap != null) && ((paramBitmap instanceof ajjb)))
          {
            paramString = (ajjb)paramBitmap;
            a(paramString, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a));
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof amgz)))
          {
            localObject = (amgz)localObject;
            if ((localObject != null) && (((amgz)localObject).a != null) && (((amgz)localObject).a.length() > 0)) {
              ((amgz)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((amgz)localObject).jdField_c_of_type_Int, ((amgz)localObject).a));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject != null) && ((localObject instanceof ajjb)))
            {
              localObject = (ajjb)localObject;
              a((ajjb)localObject, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(((ajjb)localObject).a));
            }
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgy
 * JD-Core Version:    0.7.0.1
 */