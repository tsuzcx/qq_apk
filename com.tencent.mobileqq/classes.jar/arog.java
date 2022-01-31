import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class arog
  extends arod
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aria jdField_a_of_type_Aria;
  private bhvx jdField_a_of_type_Bhvx = new aroh(this);
  private DragGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery;
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public arog(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560697, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366322));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131367020));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365555));
      this.jdField_a_of_type_Aria = new aria(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(this.jdField_a_of_type_Aria);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(this.jdField_a_of_type_Aria);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131297026));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371396));
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365489));
      Rect localRect = a();
      if (localRect != null)
      {
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this.jdField_a_of_type_Bhvx);
    }
  }
  
  public void a(bhuw parambhuw)
  {
    if (parambhuw != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(parambhuw);
    }
  }
  
  public void a(bhux parambhux)
  {
    if (parambhux != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemLongClickListener(parambhux);
    }
  }
  
  public void a(bhuy parambhuy)
  {
    if (parambhuy != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(parambhuy);
    }
  }
  
  public void a(List<arkl> paramList)
  {
    this.jdField_a_of_type_Aria.a(paramList);
    this.jdField_a_of_type_Aria.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 0;
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if ((!paramBoolean) || (this.c)) {
        break label46;
      }
      i = 1;
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i == 0) {
        break label51;
      }
    }
    label46:
    label51:
    for (int i = j;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      super.b(bool);
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aria != null) {
      this.jdField_a_of_type_Aria.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.e();
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentWidgetDragView != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(a());
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetDragView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public void e(boolean paramBoolean)
  {
    Rect localRect;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetDragView != null)
    {
      localRect = a();
      if (localRect != null)
      {
        if (paramBoolean) {
          break label101;
        }
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        if ((bnle.c) && (bnle.jdField_a_of_type_Boolean))
        {
          i = bnle.b(this.jdField_a_of_type_AndroidAppActivity);
          localRect.top += i;
        }
      }
    }
    for (localRect.bottom = (i + localRect.bottom);; localRect.bottom -= i)
    {
      label101:
      do
      {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
        return;
        localRect.top += ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        localRect.bottom += ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      } while ((!bnle.c) || (!bnle.jdField_a_of_type_Boolean));
      i = bnle.b(this.jdField_a_of_type_AndroidAppActivity);
      localRect.top -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arog
 * JD-Core Version:    0.7.0.1
 */