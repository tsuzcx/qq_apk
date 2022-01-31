import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

public class atiy
{
  public static float a = 600.0F;
  public static float b = 1334.0F;
  public static float c = -1.0F;
  
  public static boolean a(atkl paramatkl)
  {
    paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = paramatkl.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramatkl.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    return true;
  }
  
  public static boolean a(atkl paramatkl, float paramFloat1, float paramFloat2)
  {
    if ((paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null)) {}
    while ((!(paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) || (paramFloat2 == 0.0F) || (paramFloat1 == 0.0F)) {
      return false;
    }
    if ((paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramatkl);
      return false;
    }
    Object localObject = paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = muf.a(paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
    c = f2 / 2.0F;
    if (f1 / f2 < paramFloat1 / paramFloat2)
    {
      paramFloat1 = f1 / paramFloat1 * paramFloat2;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)paramFloat1);
      if (paramFloat1 <= c)
      {
        localLayoutParams.width = ((int)f1);
        localLayoutParams.height = ((int)c);
        ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
        ((ViewGroup.LayoutParams)localObject).height = ((int)c);
        paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(localLayoutParams);
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
    for (;;)
    {
      localObject = (ImageView)paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368544);
      paramatkl = (ImageView)paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365315);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramatkl.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return true;
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      continue;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      localLayoutParams.width = ((int)f1);
      localLayoutParams.height = ((int)f2);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
    }
  }
  
  public static boolean a(atkl paramatkl, float paramFloat1, float paramFloat2, VideoData paramVideoData, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    if ((paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null) || (paramShortVideoCommentsView == null)) {}
    while (!(paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) {
      return false;
    }
    if ((paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramatkl);
      return false;
    }
    paramVideoData = paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getLayoutParams();
    paramShortVideoCommentsView = paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = muf.a(paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
    c = f2 / 2.0F;
    if (f1 / f2 < paramFloat2 / paramFloat1)
    {
      paramFloat1 = f1 / paramFloat2 * paramFloat1;
      paramVideoData.width = ((int)f1);
      paramVideoData.height = ((int)paramFloat1);
      if (paramFloat1 <= c)
      {
        paramShortVideoCommentsView.width = ((int)f1);
        paramShortVideoCommentsView.height = ((int)c);
        paramVideoData.width = ((int)f1);
        paramVideoData.height = ((int)c);
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramShortVideoCommentsView);
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      }
    }
    for (;;)
    {
      paramatkl.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
      return false;
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      continue;
      paramVideoData.width = ((int)f1);
      paramVideoData.height = ((int)f2);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      paramShortVideoCommentsView.width = ((int)f1);
      paramShortVideoCommentsView.height = ((int)f2);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkl.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atiy
 * JD-Core Version:    0.7.0.1
 */