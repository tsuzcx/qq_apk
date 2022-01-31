package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import baxn;
import bbdh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import java.util.List;
import pau;
import qcv;
import qcw;

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
    qcw localqcw;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localqcw = (qcw)((pau)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((bbdh.k() - baxn.a(getContext(), 54.0F)) / 2L));
      if (localqcw.b <= 1.5F * localqcw.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((bbdh.k() - baxn.a(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localqcw.b >= 1.0F * localqcw.a) {
        localLayoutParams.width = (localqcw.a * localLayoutParams.height / localqcw.b);
      } else if (localqcw.b > 0.6666667F * localqcw.a) {
        localLayoutParams.width = (localqcw.a * localLayoutParams.height / localqcw.b);
      } else {
        localLayoutParams.width = ((int)((bbdh.k() - baxn.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */