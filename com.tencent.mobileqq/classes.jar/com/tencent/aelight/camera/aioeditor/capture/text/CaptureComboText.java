package com.tencent.aelight.camera.aioeditor.capture.text;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureComboText
  extends CaptureComboBase
{
  private String f;
  private List<String> g = new ArrayList();
  private float h;
  private float i;
  private float j;
  private DynamicTextConfigManager k;
  private DynamicTextConfigManager.DynamicTextConfigBean l;
  private volatile int m = 2;
  private volatile float n;
  private DynamicTextConfigManager.IDynamicTextResDownloadCallback o = new CaptureComboText.2(this);
  
  public CaptureComboText(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.f = paramString;
    this.g.addAll(paramList);
    this.h = paramFloat1;
    this.i = paramFloat2;
    this.j = paramFloat3;
    this.k = ((DynamicTextConfigManager)QIMManager.a(7));
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("CaptureComboText id is: ");
      paramList.append(paramString);
      QLog.i("QComboDText", 2, paramList.toString());
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboDText", 2, "apply ComboText");
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      if (!this.k.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        return 0;
      }
      if (paramActivity != null)
      {
        localObject = DoodleLayoutConnector.a().b(paramInt);
        if ((localObject != null) && (((DoodleLayout)localObject).getTextLayer() != null))
        {
          ((DoodleLayout)localObject).getTextLayer().a(4);
          DynamicTextItem localDynamicTextItem = new DynamicTextBuilder().a(Integer.valueOf(this.f).intValue(), this.g);
          if (localDynamicTextItem != null)
          {
            float f1 = ScreenUtil.SCREEN_WIDTH * this.j / localDynamicTextItem.c();
            TextLayer.LayerParams localLayerParams = new TextLayer.LayerParams(this.h * ScreenUtil.SCREEN_WIDTH, this.i * ScreenUtil.SCREEN_WIDTH, f1, 0.0F, 0.0F, 0.0F, localDynamicTextItem.c(), localDynamicTextItem.d());
            if (((DoodleLayout)localObject).getTextLayer().a(localLayerParams, this.d, ((DoodleLayout)localObject).getFrom()) != null)
            {
              localDynamicTextItem.a(true);
              ((DoodleLayout)localObject).getTextLayer().b(localDynamicTextItem);
              ((DoodleLayout)localObject).getTextLayer().u();
              return 0;
            }
            QQToast.makeText(paramActivity, paramActivity.getString(2131896291), 0).show();
            ThreadManager.getUIHandler().post(new CaptureComboText.1(this, (DoodleLayout)localObject));
          }
        }
      }
    }
    return 0;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      paramActivity = DoodleLayoutConnector.a().b(paramInt);
      if ((paramActivity != null) && (paramActivity.getTextLayer() != null))
      {
        paramActivity.getTextLayer().a(4);
        paramActivity.getTextLayer().m();
        paramActivity.getTextLayer().u();
      }
    }
  }
  
  public int c()
  {
    if (this.l == null)
    {
      this.k.b();
      this.l = this.k.b(this.f);
    }
    Object localObject = this.l;
    int i1;
    if (localObject == null) {
      i1 = 2;
    } else if ((this.k.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) && (this.m == 2)) {
      i1 = 3;
    } else {
      i1 = this.m;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CaptureComboText getState, state is: ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" id is: ");
      ((StringBuilder)localObject).append(this.f);
      QLog.i("QComboDText", 2, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  public int d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CaptureComboText download, state is: ");
      localStringBuilder.append(this.m);
      QLog.i("QComboDText", 2, localStringBuilder.toString());
    }
    if ((this.m != 1) && (this.m != 3))
    {
      if (this.l == null) {
        this.l = this.k.b(this.f);
      }
      if (this.l == null)
      {
        this.k.b();
        this.l = this.k.b(this.f);
      }
      if (this.l == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QComboDText", 2, "CaptureComboText download, bean is null.");
        }
        this.m = 2;
        return 2;
      }
      a();
      if (this.k.a(this.l))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QComboDText", 2, "startDownload dynamicText is usable.");
        }
        b();
        this.m = 3;
        return 2;
      }
      this.k.a(this.l, this.o);
      this.m = 1;
      return 1;
    }
    return this.m;
  }
  
  public float e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CaptureComboText getProgress, progress is: ");
      localStringBuilder.append(this.n);
      QLog.i("QComboDText", 2, localStringBuilder.toString());
    }
    return this.n * 0.01F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text@");
    localStringBuilder.append(Arrays.toString(this.g.toArray()));
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText
 * JD-Core Version:    0.7.0.1
 */