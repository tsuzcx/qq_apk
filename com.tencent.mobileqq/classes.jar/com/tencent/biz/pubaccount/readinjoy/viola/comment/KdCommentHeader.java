package com.tencent.biz.pubaccount.readinjoy.viola.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFrameLayout;

public class KdCommentHeader
  extends VDiv
{
  public KdCommentHeader(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new KdCommentHeaderView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentHeader
 * JD-Core Version:    0.7.0.1
 */