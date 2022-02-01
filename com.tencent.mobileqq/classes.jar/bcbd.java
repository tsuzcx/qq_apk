import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public abstract class bcbd<M extends bcfg, V extends bcnr>
  extends bcbc<M, V>
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  protected FaceDecoder a;
  private ListView a;
  
  public bcbd(ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bcfg localbcfg = (bcfg)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381183);
        if ((localbcfg != null) && (localbcfg.c() == paramInt2) && (paramString.equals(localbcfg.b())))
        {
          bcie localbcie = (bcie)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381185);
          bcnr localbcnr = (bcnr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381188);
          if ((localbcie != null) && (localbcnr != null)) {
            localbcie.a(localbcfg, localbcnr, paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
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
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        bcfg localbcfg = (bcfg)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381183);
        bcie localbcie = (bcie)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381185);
        bcnr localbcnr = (bcnr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381188);
        if ((localbcie != null) && (localbcfg != null) && (paramAbsListView != null)) {
          localbcie.a(localbcfg, localbcnr);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbd
 * JD-Core Version:    0.7.0.1
 */