package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class GdtVideoCeilingTitleBar
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private GdtVideoCeilingTitleBar.OnBtnClickListener c;
  private String d;
  private int e;
  
  public GdtVideoCeilingTitleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBar Style ");
    ((StringBuilder)localObject).append(this.e);
    GdtLog.b("GdtVideoCeilingView", ((StringBuilder)localObject).toString());
    if (this.e != 1)
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131903206));
      ((StringBuilder)localObject).append(this.d);
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(this.d)) && (((String)localObject).length() <= 7))
      {
        this.b.setText((CharSequence)localObject);
        return;
      }
      this.b.setText("在APP中打开");
      return;
    }
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void b()
  {
    this.a = ((TextView)findViewById(2131447463));
    this.b = ((TextView)findViewById(2131439593));
    this.b.setOnClickListener(new GdtVideoCeilingTitleBar.1(this));
    View localView = findViewById(2131429208);
    int i = AIOUtils.b(5.0F, getResources());
    AIOUtils.a(localView, i, i, 0, i);
    localView.setOnClickListener(new GdtVideoCeilingTitleBar.2(this));
  }
  
  public void setAppName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setOnBtnClickListener(GdtVideoCeilingTitleBar.OnBtnClickListener paramOnBtnClickListener)
  {
    this.c = paramOnBtnClickListener;
  }
  
  public void setStyle(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWebBarTitle(String paramString)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(paramString))) {
      this.a.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar
 * JD-Core Version:    0.7.0.1
 */