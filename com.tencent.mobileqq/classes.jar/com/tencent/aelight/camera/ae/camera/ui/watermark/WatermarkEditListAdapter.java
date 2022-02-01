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
  private final List<WMElement> a;
  private Activity b;
  private WatermarkEditListAdapter.OnDateItemClickedListener c;
  private boolean d = true;
  private WMElement e;
  private EditText f;
  private TextView g;
  private final SimpleDateFormat h = new SimpleDateFormat("yyyy年MM月dd日");
  
  public WatermarkEditListAdapter(Activity paramActivity, List<WMElement> paramList)
  {
    this.a = paramList;
    this.b = paramActivity;
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
    return this.h.format(new Date(l1));
  }
  
  private void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.8(this, paramEditText), 200L);
    }
  }
  
  private void a(EditText paramEditText, WMElement paramWMElement)
  {
    this.f.setTextColor(-1);
    this.f = paramEditText;
    this.e = paramWMElement;
    this.f.setCursorVisible(true);
    paramEditText = this.c;
    if (paramEditText != null) {
      paramEditText.a();
    }
  }
  
  private void a(WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.f.getContext(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2131913794));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2131913798));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), new WatermarkEditListAdapter.6(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131913795), new WatermarkEditListAdapter.7(this, paramEditTextViewHolder));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private Date b(String paramString)
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
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new WatermarkEditListAdapter.9(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (this.f != null))
    {
      localObject = this.e;
      if (localObject != null) {
        if ((!"SINCE".equals(((WMElement)localObject).type)) && (!"COUNTDOWN".equals(this.e.type)))
        {
          if ("PLAIN_TEXT".equals(this.e.type))
          {
            this.f.requestFocus();
            localObject = this.f;
            ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
            ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.f, 1);
            localObject = this.c;
            if (localObject != null) {
              ((WatermarkEditListAdapter.OnDateItemClickedListener)localObject).a();
            }
          }
        }
        else
        {
          if (AECameraEntryManager.o(this.b.getIntent())) {
            this.f.setTextColor(this.b.getResources().getColor(2063794238));
          } else {
            this.f.setTextColor(this.b.getResources().getColor(2063794239));
          }
          localObject = this.c;
          if (localObject != null) {
            ((WatermarkEditListAdapter.OnDateItemClickedListener)localObject).a(b(this.e.getInnerValue()));
          }
        }
      }
    }
  }
  
  public void a(WatermarkEditListAdapter.OnDateItemClickedListener paramOnDateItemClickedListener)
  {
    this.c = paramOnDateItemClickedListener;
  }
  
  public void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    WMElement localWMElement = (WMElement)this.a.get(paramInt);
    if (localWMElement == null) {
      return;
    }
    paramViewHolder = (WatermarkEditListAdapter.EditTextViewHolder)paramViewHolder;
    if (paramInt == 0)
    {
      if (this.d)
      {
        this.d = false;
        this.f = paramViewHolder.a;
        this.e = localWMElement;
      }
      if (getItemCount() == 1) {
        paramViewHolder.a.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      paramViewHolder.b.setVisibility(8);
    }
    paramViewHolder.c.setOnClickListener(new WatermarkEditListAdapter.1(this, localWMElement, paramViewHolder));
    if ("EDITABLE_LOCATION".equals(localWMElement.type))
    {
      paramViewHolder.f.setVisibility(8);
      paramViewHolder.e.setVisibility(0);
      this.g = paramViewHolder.g;
      if (paramViewHolder.g != null)
      {
        paramViewHolder.g.setText(a(localWMElement));
        paramViewHolder.e.setOnClickListener(new WatermarkEditListAdapter.2(this));
      }
    }
    else if ((!"SINCE".equals(localWMElement.type)) && (!"COUNTDOWN".equals(localWMElement.type)))
    {
      if (("CHECK_IN".equals(localWMElement.type)) || ("PLAIN_TEXT".equals(localWMElement.type)))
      {
        paramViewHolder.f.setVisibility(0);
        paramViewHolder.e.setVisibility(8);
        paramViewHolder.a.setText(a(localWMElement));
        if ("CHECK_IN".equals(localWMElement.type))
        {
          paramViewHolder.a.setFocusable(false);
          paramViewHolder.a.setFocusableInTouchMode(false);
          paramViewHolder.c.setBackgroundResource(2063925382);
          paramViewHolder.c.setVisibility(0);
        }
        else
        {
          paramViewHolder.a.setFocusable(true);
          paramViewHolder.a.setFocusableInTouchMode(true);
          paramViewHolder.a.requestFocus();
          paramViewHolder.c.setBackgroundResource(2063925381);
          paramViewHolder.c.setVisibility(0);
        }
        paramViewHolder.a.setOnFocusChangeListener(new WatermarkEditListAdapter.4(this, paramViewHolder, localWMElement));
        paramViewHolder.a.setOnClickListener(new WatermarkEditListAdapter.5(this, paramViewHolder, localWMElement));
      }
    }
    else
    {
      paramViewHolder.f.setVisibility(0);
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.c.setVisibility(4);
      paramViewHolder.a.setText(a(localWMElement));
      paramViewHolder.a.setFocusable(false);
      paramViewHolder.a.setCursorVisible(false);
      paramViewHolder.a.setOnClickListener(new WatermarkEditListAdapter.3(this, paramViewHolder, localWMElement));
      b(paramViewHolder.a);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new WatermarkEditListAdapter.EditTextViewHolder(this, LayoutInflater.from(this.b).inflate(2064056371, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.f != null) && (this.e != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(HardCodeUtil.a(2131913797));
      int i = paramInt2 + 1;
      String str = "0";
      if (i < 10) {
        paramDatePicker = "0";
      } else {
        paramDatePicker = "";
      }
      localStringBuilder.append(paramDatePicker);
      localStringBuilder.append(i);
      localStringBuilder.append(HardCodeUtil.a(2131913793));
      if (paramInt3 < 10) {
        paramDatePicker = str;
      } else {
        paramDatePicker = "";
      }
      localStringBuilder.append(paramDatePicker);
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(HardCodeUtil.a(2131913796));
      paramDatePicker = localStringBuilder.toString();
      this.f.setText(paramDatePicker);
      paramDatePicker = Calendar.getInstance();
      paramDatePicker.set(paramInt1, paramInt2, paramInt3);
      this.f.setTag(paramDatePicker.getTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter
 * JD-Core Version:    0.7.0.1
 */