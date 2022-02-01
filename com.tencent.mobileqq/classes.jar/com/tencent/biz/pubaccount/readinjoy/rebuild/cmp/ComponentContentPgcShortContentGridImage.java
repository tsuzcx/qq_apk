package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import bggq;
import bgln;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import java.util.List;
import pxk;
import rhn;
import rho;

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
    rho localrho;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localrho = (rho)((pxk)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((bgln.k() - bggq.a(getContext(), 54.0F)) / 2L));
      if (localrho.b <= 1.5F * localrho.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((bgln.k() - bggq.a(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localrho.b >= 1.0F * localrho.a) {
        localLayoutParams.width = (localrho.a * localLayoutParams.height / localrho.b);
      } else if (localrho.b > 0.6666667F * localrho.a) {
        localLayoutParams.width = (localrho.a * localLayoutParams.height / localrho.b);
      } else {
        localLayoutParams.width = ((int)((bgln.k() - bggq.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */