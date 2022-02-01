package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

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
    SocializeFeedsInfo.PGCPicInfo localPGCPicInfo;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)((IReadInJoyModel)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 2L));
      if (localPGCPicInfo.b <= 1.5F * localPGCPicInfo.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localPGCPicInfo.b >= 1.0F * localPGCPicInfo.a) {
        localLayoutParams.width = (localPGCPicInfo.a * localLayoutParams.height / localPGCPicInfo.b);
      } else if (localPGCPicInfo.b > 0.6666667F * localPGCPicInfo.a) {
        localLayoutParams.width = (localPGCPicInfo.a * localLayoutParams.height / localPGCPicInfo.b);
      } else {
        localLayoutParams.width = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */