package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import pax;
import pqs;
import prb;
import pvb;
import qdt;
import qdv;

public class ComponentCenterTopicTitle
  extends ComponentTitle
  implements pqs
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
    LayoutInflater.from(paramContext).inflate(2131559887, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364591));
    this.b = ((TextView)findViewById(2131365018));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      paramObject = (pax)paramObject;
      this.jdField_a_of_type_Pvb.a(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.a != null) && (!paramObject.mSocialFeedInfo.a.a.isEmpty()))
      {
        paramObject = (qdv)paramObject.mSocialFeedInfo.a.a.get(0);
        String str = paramObject.c + paramObject.a;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (paramObject.b <= 0) {
          break label176;
        }
        paramObject = String.format("- %s人正在参与 -", new Object[] { bhvh.a(paramObject.b) });
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
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Pvb.a(paramprb);
  }
  
  public void b() {}
  
  public void setReadedStatus(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */