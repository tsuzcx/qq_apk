import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class bgpw
  implements blih
{
  protected float a;
  protected int a;
  protected Bitmap a;
  protected Handler a;
  protected LruCache<String, Bitmap> a;
  protected bgpx a;
  protected blih a;
  protected ListView a;
  protected ArrayList<String> a;
  protected int b;
  protected LruCache<String, String> b;
  protected int c;
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    int j = this.jdField_b_of_type_Int;
    int i = this.c;
    float f2 = this.jdField_a_of_type_Float;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return bhmq.a(paramBitmap, j, j, i);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localObject != null)
        {
          if (!QLog.isColorLevel()) {
            return localObject;
          }
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in cache:" + paramString + ", add2Request=" + paramBoolean);
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          if (TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString))) {
            continue;
          }
          localObject = Message.obtain();
          ((Message)localObject).obj = paramString;
          ((Message)localObject).what = 1001;
          this.jdField_a_of_type_Bgpx.sendMessage((Message)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, in file cache:" + paramString + ", send decode msg ");
          }
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        continue;
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in file cache:" + paramString + ", send getQQHead msg ");
        }
      }
    }
    return localObject;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "refreshListFace, add2Request:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    label49:
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if (!(localObject instanceof amof)) {
        break label131;
      }
      localObject = (amof)localObject;
      if ((localObject != null) && (((amof)localObject).a != null) && (((amof)localObject).a.length() > 0)) {
        ((amof)localObject).c.setImageBitmap(a(((amof)localObject).a, paramBoolean));
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label131:
      if ((localObject instanceof rot))
      {
        localObject = (rot)localObject;
        if ((((rot)localObject).a != null) && (((rot)localObject).a.a != null) && ((((rot)localObject).a.a.jdField_a_of_type_Int == 1) || (((rot)localObject).a.a.jdField_a_of_type_Int == 6)) && (!TextUtils.isEmpty(((rot)localObject).a.a.j)) && (((rot)localObject).b != null)) {
          ((rot)localObject).b.setImageBitmap(a(((rot)localObject).a.a.j, paramBoolean));
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "onScrollStateChanged, " + this.jdField_a_of_type_Int + " => " + paramInt);
      }
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt == 0)
      {
        a(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
      }
      while (this.jdField_a_of_type_Blih != null)
      {
        this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
        return;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpw
 * JD-Core Version:    0.7.0.1
 */