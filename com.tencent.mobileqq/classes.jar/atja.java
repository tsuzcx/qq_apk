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

public class atja
{
  public static float a = 600.0F;
  public static float b = 1334.0F;
  public static float c = -1.0F;
  
  public static boolean a(atkn paramatkn)
  {
    paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = paramatkn.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramatkn.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    return true;
  }
  
  public static boolean a(atkn paramatkn, float paramFloat1, float paramFloat2)
  {
    if ((paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null)) {}
    while ((!(paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) || (paramFloat2 == 0.0F) || (paramFloat1 == 0.0F)) {
      return false;
    }
    if ((paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramatkn);
      return false;
    }
    Object localObject = paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = muc.a(paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
        paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(localLayoutParams);
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
    for (;;)
    {
      localObject = (ImageView)paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368543);
      paramatkn = (ImageView)paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365314);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramatkn.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return true;
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      continue;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      localLayoutParams.width = ((int)f1);
      localLayoutParams.height = ((int)f2);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
    }
  }
  
  public static boolean a(atkn paramatkn, float paramFloat1, float paramFloat2, VideoData paramVideoData, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    if ((paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null) || (paramShortVideoCommentsView == null)) {}
    while (!(paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) {
      return false;
    }
    if ((paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramatkn);
      return false;
    }
    paramVideoData = paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getLayoutParams();
    paramShortVideoCommentsView = paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = muc.a(paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramShortVideoCommentsView);
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      }
    }
    for (;;)
    {
      paramatkn.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
      return false;
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      continue;
      paramVideoData.width = ((int)f1);
      paramVideoData.height = ((int)f2);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      paramShortVideoCommentsView.width = ((int)f1);
      paramShortVideoCommentsView.height = ((int)f2);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramatkn.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atja
 * JD-Core Version:    0.7.0.1
 */