package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import qfw;
import rbo;
import rbx;
import rfw;
import rsh;
import rsj;

public class ComponentCenterTopicTitle
  extends ComponentTitle
  implements rbo
{
  TextView a;
  TextView b;
  
  public ComponentCenterTopicTitle(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560194, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365042));
    this.b = ((TextView)findViewById(2131365513));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof qfw))
    {
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.a != null) && (!paramObject.mSocialFeedInfo.a.a.isEmpty()))
      {
        paramObject = (rsj)paramObject.mSocialFeedInfo.a.a.get(0);
        String str = paramObject.c + paramObject.a;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (paramObject.b <= 0) {
          break label176;
        }
        paramObject = String.format("- %s人正在参与 -", new Object[] { bmhv.a(paramObject.b) });
        this.b.setText(paramObject);
        this.b.setVisibility(0);
      }
    }
    for (;;)
    {
      b();
      return;
      label176:
      this.b.setVisibility(8);
    }
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b() {}
  
  public void setReadedStatus(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */