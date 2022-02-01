package com.tencent.comic.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import mqq.util.WeakReference;

public class ComicCancelRedPointPopDialog
  extends Dialog
  implements View.OnClickListener
{
  public int a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ComicHorizontalCenterScrollView.OnCustomScrollListener jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView$OnCustomScrollListener = new ComicCancelRedPointPopDialog.1(this);
  private ComicHorizontalCenterScrollView jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView = null;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  private Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[5];
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[5];
  private ComicCancelRedPointPopItemView[] jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView = new ComicCancelRedPointPopItemView[5];
  
  public ComicCancelRedPointPopDialog(@NonNull Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    setContentView(1996816384);
    a(paramContext);
    setCanceledOnTouchOutside(false);
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Rect[] arrayOfRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
      if (i >= arrayOfRect.length) {
        break;
      }
      if ((arrayOfRect[i].left <= paramInt) && (paramInt <= this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].right)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      int j;
      if (i == paramInt) {
        j = 1996685313;
      } else {
        j = 1996685312;
      }
      ((ImageView)localObject).setImageResource(j);
      i += 1;
    }
  }
  
  private void a(Context paramContext)
  {
    Size localSize = DisplayUtil.a(paramContext);
    this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView = ((ComicHorizontalCenterScrollView)findViewById(1996750856));
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(localSize.jdField_a_of_type_Int, DisplayUtil.a(paramContext, 346.5F));
      ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(paramContext, 15.0F);
    }
    else
    {
      ((LinearLayout.LayoutParams)localObject).width = localSize.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int j = DisplayUtil.a(paramContext, 260.0F);
    int k = DisplayUtil.a(paramContext, 8.0F);
    this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView.setBaseInfo(j, k, this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView$OnCustomScrollListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(1996750858));
    paramContext = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView;
    localObject = (ComicCancelRedPointPopItemView)findViewById(1996750859);
    int i = 0;
    paramContext[0] = localObject;
    this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[1] = ((ComicCancelRedPointPopItemView)findViewById(1996750860));
    this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[2] = ((ComicCancelRedPointPopItemView)findViewById(1996750861));
    this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[3] = ((ComicCancelRedPointPopItemView)findViewById(1996750862));
    this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[4] = ((ComicCancelRedPointPopItemView)findViewById(1996750863));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(1996750848));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(1996750849));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)findViewById(1996750850));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)findViewById(1996750851));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[4] = ((ImageView)findViewById(1996750852));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(1996750853));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    j += k;
    for (;;)
    {
      paramContext = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView;
      if (i >= paramContext.length) {
        break;
      }
      paramContext[i].jdField_a_of_type_Int = i;
      paramContext[i].setOnClickListener(this);
      paramContext = new Rect();
      paramContext.left = (i * j);
      paramContext.right = (paramContext.left + j);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i] = paramContext;
      i += 1;
    }
  }
  
  private void a(ComicCancelRedPointPopItemData paramComicCancelRedPointPopItemData)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localActivity != null) && (paramComicCancelRedPointPopItemData != null))
    {
      this.jdField_a_of_type_Boolean = true;
      VipComicDC01327ReportData localVipComicDC01327ReportData = new VipComicDC01327ReportData().a("2000").b("2").c("20249").d("4").e(paramComicCancelRedPointPopItemData.comicId);
      ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(localVipComicDC01327ReportData);
    }
    try
    {
      ComicHippyBackEventInterceptorProxy.INSTANCE.openReader(localActivity, paramComicCancelRedPointPopItemData.comicId);
      label77:
      dismiss();
      return;
    }
    catch (Throwable paramComicCancelRedPointPopItemData)
    {
      break label77;
    }
  }
  
  public void a(List<ComicCancelRedPointPopItemData> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView.length)
    {
      if (i >= paramList.size())
      {
        this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[i].setData(null);
      }
      else
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[i].setData((ComicCancelRedPointPopItemData)paramList.get(i));
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView.scrollTo(0, 0);
    a(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 1996750863: 
      paramView = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[4].jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData;
      break;
    case 1996750862: 
      paramView = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[3].jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData;
      break;
    case 1996750861: 
      paramView = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[2].jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData;
      break;
    case 1996750860: 
      paramView = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[1].jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData;
      break;
    case 1996750859: 
      paramView = this.jdField_a_of_type_ArrayOfComTencentComicUiComicCancelRedPointPopItemView[0].jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopItemData;
      a(paramView);
      return;
    }
    dismiss();
  }
  
  public void show()
  {
    super.show();
    VipComicDC01327ReportData localVipComicDC01327ReportData = new VipComicDC01327ReportData().a("2000").b("3").c("39973");
    ComicHippyBackEventInterceptorProxy.INSTANCE.reportData(localVipComicDC01327ReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopDialog
 * JD-Core Version:    0.7.0.1
 */