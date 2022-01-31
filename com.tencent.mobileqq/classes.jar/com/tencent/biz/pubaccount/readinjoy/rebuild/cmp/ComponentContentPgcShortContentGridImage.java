package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import bcwh;
import bdcb;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import java.util.List;
import pgd;
import qmr;
import qms;

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
    qms localqms;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localqms = (qms)((pgd)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((bdcb.k() - bcwh.a(getContext(), 54.0F)) / 2L));
      if (localqms.b <= 1.5F * localqms.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((bdcb.k() - bcwh.a(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localqms.b >= 1.0F * localqms.a) {
        localLayoutParams.width = (localqms.a * localLayoutParams.height / localqms.b);
      } else if (localqms.b > 0.6666667F * localqms.a) {
        localLayoutParams.width = (localqms.a * localLayoutParams.height / localqms.b);
      } else {
        localLayoutParams.width = ((int)((bdcb.k() - bcwh.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */