package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

public class WatermarkEditView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DatePicker jdField_a_of_type_AndroidWidgetDatePicker;
  private WatermarkEditListAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter;
  private WatermarkEditView.OnRendorTextListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener;
  private WatermarkListView jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView;
  protected VideoStoryCapturePartManager a;
  private List<WMElement> jdField_a_of_type_JavaUtilList;
  
  public WatermarkEditView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589824)) && (((Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589826, new Object[0])).booleanValue())) {
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589826, new Object[0]);
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(Activity paramActivity, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView = ((WatermarkListView)findViewById(2064122151));
    this.jdField_a_of_type_AndroidWidgetDatePicker = ((DatePicker)findViewById(2064122096));
    findViewById(2064122694).setOnClickListener(this);
    paramVideoStoryCapturePartManager = (TextView)findViewById(2064122695);
    paramVideoStoryCapturePartManager.setOnClickListener(this);
    if (AECameraEntryManager.k(paramActivity.getIntent()))
    {
      paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2063925310));
      return;
    }
    paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2063925311));
  }
  
  public void a(List<WMElement> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter = new WatermarkEditListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter);
    this.jdField_a_of_type_AndroidWidgetDatePicker.setVisibility(8);
    paramList = this.jdField_a_of_type_AndroidWidgetDatePicker;
    paramList.init(paramList.getYear(), this.jdField_a_of_type_AndroidWidgetDatePicker.getMonth(), this.jdField_a_of_type_AndroidWidgetDatePicker.getDayOfMonth(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter.a(new WatermarkEditView.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2064122695: 
      a();
      postDelayed(new WatermarkEditView.3(this), 200L);
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView.a())
      {
        Object localObject = (WatermarkEditListAdapter.EditTextViewHolder)this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkListView.a(i);
        if ((localObject != null) && (!CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_JavaUtilList, i)))
        {
          paramView = (WMElement)this.jdField_a_of_type_JavaUtilList.get(i);
          if (paramView != null) {
            if ((!"SINCE".equals(paramView.type)) && (!"COUNTDOWN".equals(paramView.type)))
            {
              if ("CHECK_IN".equals(paramView.type))
              {
                if (((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_Boolean)
                {
                  ((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_Boolean = false;
                  paramView.resetCheckIn();
                }
              }
              else if ("EDITABLE_LOCATION".equals(paramView.type))
              {
                localObject = StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim());
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  paramView.setLocation((String)localObject);
                }
              }
              else
              {
                paramView.setText(StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()));
              }
            }
            else if ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() instanceof Date))) {
              paramView.setDate(((Date)((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag()).getTime());
            }
          }
        }
        i += 1;
      }
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener;
      if (paramView != null) {
        paramView.a();
      }
      b();
      return;
    }
    a();
    postDelayed(new WatermarkEditView.4(this), 200L);
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnRenderTextListener(WatermarkEditView.OnRendorTextListener paramOnRendorTextListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener = paramOnRendorTextListener;
  }
  
  public void setWaterMarkLocation(String paramString)
  {
    WatermarkEditListAdapter localWatermarkEditListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter;
    if (localWatermarkEditListAdapter != null) {
      localWatermarkEditListAdapter.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */