package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;
import pvc;
import rfe;
import rff;

public class ComponentContentPgcShortContentGridImage
  extends ComponentContentGridImage
{
  public ComponentContentPgcShortContentGridImage(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcShortContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ViewGroup.LayoutParams localLayoutParams;
    rff localrff;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localrff = (rff)((pvc)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getContext(), 54.0F)) / 2L));
      if (localrff.b <= 1.5F * localrff.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localrff.b >= 1.0F * localrff.a) {
        localLayoutParams.width = (localrff.a * localLayoutParams.height / localrff.b);
      } else if (localrff.b > 0.6666667F * localrff.a) {
        localLayoutParams.width = (localrff.a * localLayoutParams.height / localrff.b);
      } else {
        localLayoutParams.width = ((int)((DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */