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
  protected VideoStoryCapturePartManager a;
  private WatermarkListView b;
  private Activity c;
  private DatePicker d;
  private WatermarkEditListAdapter e;
  private WatermarkEditView.OnRendorTextListener f;
  private int g = 0;
  private List<WMElement> h;
  
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
    if ((this.a.a(589824)) && (((Boolean)this.a.a(589826, new Object[0])).booleanValue())) {
      this.a.b(589826, new Object[0]);
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(Activity paramActivity, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.c = paramActivity;
    this.a = paramVideoStoryCapturePartManager;
    this.b = ((WatermarkListView)findViewById(2063991041));
    this.d = ((DatePicker)findViewById(2063991010));
    findViewById(2063991484).setOnClickListener(this);
    paramVideoStoryCapturePartManager = (TextView)findViewById(2063991485);
    paramVideoStoryCapturePartManager.setOnClickListener(this);
    if (AECameraEntryManager.o(paramActivity.getIntent()))
    {
      paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2063794238));
      return;
    }
    paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2063794239));
  }
  
  public void a(List<WMElement> paramList)
  {
    this.h = paramList;
    this.e = new WatermarkEditListAdapter(this.c, this.h);
    this.b.setAdapter(this.e);
    this.d.setVisibility(8);
    paramList = this.d;
    paramList.init(paramList.getYear(), this.d.getMonth(), this.d.getDayOfMonth(), this.e);
    this.e.a(new WatermarkEditView.1(this));
    this.b.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2063991485: 
      a();
      postDelayed(new WatermarkEditView.3(this), 200L);
      int i = 0;
      while (i < this.b.getViewHolderCount())
      {
        Object localObject = (WatermarkEditListAdapter.EditTextViewHolder)this.b.a(i);
        if ((localObject != null) && (!CollectionUtils.indexOutOfBounds(this.h, i)))
        {
          paramView = (WMElement)this.h.get(i);
          if (paramView != null) {
            if ((!"SINCE".equals(paramView.type)) && (!"COUNTDOWN".equals(paramView.type)))
            {
              if ("CHECK_IN".equals(paramView.type))
              {
                if (((WatermarkEditListAdapter.EditTextViewHolder)localObject).d)
                {
                  ((WatermarkEditListAdapter.EditTextViewHolder)localObject).d = false;
                  paramView.resetCheckIn();
                }
              }
              else if ("EDITABLE_LOCATION".equals(paramView.type))
              {
                localObject = StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).g.getText().toString().trim());
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  paramView.setLocation((String)localObject);
                }
              }
              else
              {
                paramView.setText(StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).a.getText().toString().trim()));
              }
            }
            else if ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).a.getTag() != null) && ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).a.getTag() instanceof Date))) {
              paramView.setDate(((Date)((WatermarkEditListAdapter.EditTextViewHolder)localObject).a.getTag()).getTime());
            }
          }
        }
        i += 1;
      }
      paramView = this.f;
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
    this.g = paramInt;
  }
  
  public void setOnRenderTextListener(WatermarkEditView.OnRendorTextListener paramOnRendorTextListener)
  {
    this.f = paramOnRendorTextListener;
  }
  
  public void setWaterMarkLocation(String paramString)
  {
    WatermarkEditListAdapter localWatermarkEditListAdapter = this.e;
    if (localWatermarkEditListAdapter != null) {
      localWatermarkEditListAdapter.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */