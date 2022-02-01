package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

public class WatermarkEditListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WatermarkEditListAdapter.OnDateItemClickedListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener;
  private final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
  private final List<WMElement> jdField_a_of_type_JavaUtilList;
  private WMElement jdField_a_of_type_OrgLightBeanWMElement;
  private boolean jdField_a_of_type_Boolean = true;
  
  public WatermarkEditListAdapter(Activity paramActivity, List<WMElement> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private String a(WMElement paramWMElement)
  {
    if (paramWMElement == null) {
      return null;
    }
    String str = paramWMElement.getInnerValue();
    if ((!"SINCE".equals(paramWMElement.type)) && (!"COUNTDOWN".equals(paramWMElement.type))) {
      return str;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (NumberFormatException paramWMElement)
    {
      AEQLog.a("WatermarkEditListAdapter", "getDisplayText---parseLong error: ", paramWMElement);
    }
    return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1));
  }
  
  private Date a(String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      AEQLog.a("WatermarkEditListAdapter", "parseToDate---parseLong error: ", paramString);
      l = 0L;
    }
    return new Date(l);
  }
  
  private void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.8(this, paramEditText), 200L);
    }
  }
  
  private void a(EditText paramEditText, WMElement paramWMElement)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_OrgLightBeanWMElement = paramWMElement;
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    paramEditText = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener;
    if (paramEditText != null) {
      paramEditText.a();
    }
  }
  
  private void a(WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2131716352));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2131716357));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131716353), new WatermarkEditListAdapter.6(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131716354), new WatermarkEditListAdapter.7(this, paramEditTextViewHolder));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new WatermarkEditListAdapter.9(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      localObject = this.jdField_a_of_type_OrgLightBeanWMElement;
      if (localObject != null) {
        if ((!"SINCE".equals(((WMElement)localObject).type)) && (!"COUNTDOWN".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type)))
        {
          if ("PLAIN_TEXT".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
            localObject = this.jdField_a_of_type_AndroidWidgetEditText;
            ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
            ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
            localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener;
            if (localObject != null) {
              ((WatermarkEditListAdapter.OnDateItemClickedListener)localObject).a();
            }
          }
        }
        else
        {
          if (AECameraEntryManager.k(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
            this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2063925310));
          } else {
            this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2063925311));
          }
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener;
          if (localObject != null) {
            ((WatermarkEditListAdapter.OnDateItemClickedListener)localObject).a(a(this.jdField_a_of_type_OrgLightBeanWMElement.getInnerValue()));
          }
        }
      }
    }
  }
  
  public void a(WatermarkEditListAdapter.OnDateItemClickedListener paramOnDateItemClickedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener = paramOnDateItemClickedListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    WMElement localWMElement = (WMElement)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localWMElement == null) {
      return;
    }
    paramViewHolder = (WatermarkEditListAdapter.EditTextViewHolder)paramViewHolder;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetEditText = paramViewHolder.jdField_a_of_type_AndroidWidgetEditText;
        this.jdField_a_of_type_OrgLightBeanWMElement = localWMElement;
      }
      if (getItemCount() == 1) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new WatermarkEditListAdapter.1(this, localWMElement, paramViewHolder));
    if ("EDITABLE_LOCATION".equals(localWMElement.type))
    {
      paramViewHolder.b.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(localWMElement));
        paramViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(new WatermarkEditListAdapter.2(this));
      }
    }
    else if ((!"SINCE".equals(localWMElement.type)) && (!"COUNTDOWN".equals(localWMElement.type)))
    {
      if (("CHECK_IN".equals(localWMElement.type)) || ("PLAIN_TEXT".equals(localWMElement.type)))
      {
        paramViewHolder.b.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(a(localWMElement));
        if ("CHECK_IN".equals(localWMElement.type))
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2064056413);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
          paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
          paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2064056412);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new WatermarkEditListAdapter.4(this, paramViewHolder, localWMElement));
        paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new WatermarkEditListAdapter.5(this, paramViewHolder, localWMElement));
      }
    }
    else
    {
      paramViewHolder.b.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(a(localWMElement));
      paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new WatermarkEditListAdapter.3(this, paramViewHolder, localWMElement));
      b(paramViewHolder.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new WatermarkEditListAdapter.EditTextViewHolder(this, LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2064318504, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_OrgLightBeanWMElement != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(HardCodeUtil.a(2131716356));
      int i = paramInt2 + 1;
      String str = "0";
      if (i < 10) {
        paramDatePicker = "0";
      } else {
        paramDatePicker = "";
      }
      localStringBuilder.append(paramDatePicker);
      localStringBuilder.append(i);
      localStringBuilder.append(HardCodeUtil.a(2131716351));
      if (paramInt3 < 10) {
        paramDatePicker = str;
      } else {
        paramDatePicker = "";
      }
      localStringBuilder.append(paramDatePicker);
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(HardCodeUtil.a(2131716355));
      paramDatePicker = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramDatePicker);
      paramDatePicker = Calendar.getInstance();
      paramDatePicker.set(paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_AndroidWidgetEditText.setTag(paramDatePicker.getTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter
 * JD-Core Version:    0.7.0.1
 */