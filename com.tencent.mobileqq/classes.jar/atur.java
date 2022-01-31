import android.content.Context;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyLabelInfo;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class atur
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LabelContainer jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public View a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 16777216) {
      i = paramInt1 - 16777216;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 16777216) {
      paramInt1 = paramInt2 - 16777216;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-7829368);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      localObject = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject);
      paramString1 = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel()) {
          QLog.w("TopicLabelCtrl", 2, "getDrawable exception, exp=" + localException + ", url=" + paramString1);
        }
        paramString1 = new ColorDrawable(-7829368);
      }
    }
    localObject = new View(this.jdField_a_of_type_AndroidContentContext);
    ((View)localObject).setBackgroundDrawable(paramString1);
    localLinearLayout.addView((View)localObject, vpm.b(this.jdField_a_of_type_AndroidContentContext, 18.0F), vpm.b(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).leftMargin = vpm.b(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    paramString1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(i);
    localLinearLayout.addView(paramString1);
    paramString1 = (LinearLayout.LayoutParams)paramString1.getLayoutParams();
    paramString1.rightMargin = vpm.b(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    paramString1.leftMargin = vpm.b(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    localLinearLayout.setBackgroundResource(2130844721);
    paramString1 = localLinearLayout.getBackground();
    if (paramString1 != null)
    {
      paramString1.setColorFilter(new LightingColorFilter(-16777216, paramInt1));
      paramString1.invalidateSelf();
    }
    localLinearLayout.setOnClickListener(new atus(this));
    return localLinearLayout;
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377440);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer = ((LabelContainer)paramView.findViewById(2131369048));
    this.b = paramView.findViewById(2131369232);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
  }
  
  public void a(cmd0xac5.NearbyNowData paramNearbyNowData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.getChildCount() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.removeAllViews();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setSpace(vpm.b(this.jdField_a_of_type_AndroidContentContext, 6.0F), vpm.b(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    if (paramNearbyNowData != null) {}
    for (paramNearbyNowData = paramNearbyNowData.label_info.get();; paramNearbyNowData = null)
    {
      if ((paramNearbyNowData != null) && (paramNearbyNowData.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TopicLabelCtrl", 2, "updateData, nearbyLabelInfoList.size=" + paramNearbyNowData.size());
        }
        int i = 0;
        while (i < paramNearbyNowData.size())
        {
          Object localObject = (cmd0xac5.NearbyLabelInfo)paramNearbyNowData.get(i);
          localObject = a(((cmd0xac5.NearbyLabelInfo)localObject).label_pic.get().toStringUtf8(), ((cmd0xac5.NearbyLabelInfo)localObject).label_name.get().toStringUtf8(), ((cmd0xac5.NearbyLabelInfo)localObject).font_colour.get(), ((cmd0xac5.NearbyLabelInfo)localObject).label_colour.get());
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.addView((View)localObject, -2, vpm.b(this.jdField_a_of_type_AndroidContentContext, 24.0F));
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelContainer.setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atur
 * JD-Core Version:    0.7.0.1
 */