package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleKolMessagePresenter
  extends QCircleBaseMessagePresenter
{
  private Drawable q;
  
  public QCircleKolMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView)
  {
    this.h.setOnClickListener(new QCircleKolMessagePresenter.1(this, paramContext));
    if (this.b != null)
    {
      paramContext = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      paramContext.rightMargin = ImmersiveUtils.a(16.0F);
      this.b.setLayoutParams(paramContext);
    }
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.message.get() != null))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramStNotice = paramStNotice.feed.content.get();
      localSpannableStringBuilder.append(paramStNotice);
      String str = this.c.getString(2131895770);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), paramStNotice.length(), paramStNotice.length() + str.length(), 33);
      if (this.q == null)
      {
        this.q = QCircleSkinHelper.getInstance().getDrawable(2130845350);
        this.q.setBounds(0, ImmersiveUtils.a(1.5F), ImmersiveUtils.a(14.0F), ImmersiveUtils.a(14.0F));
      }
      this.h.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.q);
      this.h.setText(localSpannableStringBuilder);
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  void c() {}
  
  protected String f()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleKolMessagePresenter
 * JD-Core Version:    0.7.0.1
 */