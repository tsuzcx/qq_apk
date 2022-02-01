package com.tencent.mobileqq.activity.aio.voicetextpanel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import mqq.app.AppRuntime;

public abstract class BaseVoicetoTextView
  extends RelativeLayout
{
  public BaseVoicetoTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseVoicetoTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseVoicetoTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract void a(AppRuntime paramAppRuntime, BaseAIOContext paramBaseAIOContext, BaseSessionInfo paramBaseSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void setParam(String paramString1, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
 * JD-Core Version:    0.7.0.1
 */