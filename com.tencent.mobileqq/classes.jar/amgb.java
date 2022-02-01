import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public abstract class amgb
  extends BaseAdapter
  implements bbzp, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected bbzg a;
  private bbzk jdField_a_of_type_Bbzk;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<? extends bbzd> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private List<bbzd> b;
  
  public amgb(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<? extends bbzd> paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = new ArrayList();
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true);
    }
    if (paramInt == 1) {
      return bheg.a();
    }
    if (paramInt == 101) {
      return bheg.h();
    }
    if (paramInt == 4) {
      return bheg.f();
    }
    if (paramInt == 11) {
      return bheg.b();
    }
    if (paramInt == 110) {
      return bheg.d();
    }
    if (paramInt == 111) {
      return bheg.e();
    }
    return bheg.a();
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<? extends bbzd> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    paramList.clear();
    if (this.jdField_a_of_type_Bbzg != null) {
      this.jdField_a_of_type_Bbzg.a(paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<? extends bbzd> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(amgc paramamgc)
  {
    return (paramamgc != null) && (!TextUtils.isEmpty(paramamgc.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbzk != null) {
      this.jdField_a_of_type_Bbzk.cancel(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b != null) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof amgc)))
        {
          localObject = (amgc)localObject;
          if ((localObject != null) && (!TextUtils.isEmpty(((amgc)localObject).jdField_a_of_type_JavaLangString)) && (((amgc)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (paramInt2 == ((amgc)localObject).jdField_a_of_type_Int)) {
            ((amgc)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof amgc)))
        {
          paramAbsListView = (amgc)paramAbsListView;
          if (a(paramAbsListView)) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, paramAbsListView.jdField_a_of_type_Int));
          }
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgb
 * JD-Core Version:    0.7.0.1
 */