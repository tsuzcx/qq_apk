package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import bhgr;
import bhlo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import java.util.List;
import ppu;
import qyg;
import qyh;

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
    qyh localqyh;
    if (getCount() == 1)
    {
      localLayoutParams = paramView.getLayoutParams();
      localqyh = (qyh)((ppu)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((bhlo.k() - bhgr.a(getContext(), 54.0F)) / 2L));
      if (localqyh.b <= 1.5F * localqyh.a) {
        break label126;
      }
      localLayoutParams.width = ((int)((bhlo.k() - bhgr.a(getContext(), 54.0F)) / 3L));
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
      return;
      label126:
      if (localqyh.b >= 1.0F * localqyh.a) {
        localLayoutParams.width = (localqyh.a * localLayoutParams.height / localqyh.b);
      } else if (localqyh.b > 0.6666667F * localqyh.a) {
        localLayoutParams.width = (localqyh.a * localLayoutParams.height / localqyh.b);
      } else {
        localLayoutParams.width = ((int)((bhlo.k() - bhgr.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */