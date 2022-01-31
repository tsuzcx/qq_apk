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

public class avej
{
  public static float a = 600.0F;
  public static float b = 1334.0F;
  public static float c = -1.0F;
  
  public static boolean a(avfw paramavfw)
  {
    paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = paramavfw.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramavfw.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    return true;
  }
  
  public static boolean a(avfw paramavfw, float paramFloat1, float paramFloat2)
  {
    if ((paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null)) {}
    while ((!(paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) || (paramFloat2 == 0.0F) || (paramFloat1 == 0.0F)) {
      return false;
    }
    if ((paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramavfw);
      return false;
    }
    Object localObject = paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = mww.a(paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
        paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(localLayoutParams);
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
    for (;;)
    {
      localObject = (ImageView)paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368753);
      paramavfw = (ImageView)paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365401);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramavfw.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return true;
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      continue;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      localLayoutParams.width = ((int)f1);
      localLayoutParams.height = ((int)f2);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
    }
  }
  
  public static boolean a(avfw paramavfw, float paramFloat1, float paramFloat2, VideoData paramVideoData, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    if ((paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null) || (paramShortVideoCommentsView == null)) {}
    while (!(paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) {
      return false;
    }
    if ((paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 6))
    {
      a(paramavfw);
      return false;
    }
    paramVideoData = paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getLayoutParams();
    paramShortVideoCommentsView = paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
    View localView = ((Activity)paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
    Rect localRect = new Rect();
    localView.getWindowVisibleDisplayFrame(localRect);
    float f2 = localRect.height();
    float f1 = mww.a(paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramShortVideoCommentsView);
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      }
    }
    for (;;)
    {
      paramavfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
      return false;
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      continue;
      paramVideoData.width = ((int)f1);
      paramVideoData.height = ((int)f2);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      paramShortVideoCommentsView.width = ((int)f1);
      paramShortVideoCommentsView.height = ((int)f2);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
      paramavfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avej
 * JD-Core Version:    0.7.0.1
 */