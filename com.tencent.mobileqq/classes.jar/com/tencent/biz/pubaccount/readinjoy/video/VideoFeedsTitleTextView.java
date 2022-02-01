package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsTitleTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsTitleTextView
  extends TextView
{
  public static final VideoFeedsTitleTextView.Companion a = new VideoFeedsTitleTextView.Companion(null);
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsTitleTextView", 2, "onMeasure: text=" + getText() + ", type=" + getText().getClass());
    }
    paramInt1 = TextViewCompat.getMaxLines((TextView)this);
    if (getLineCount() > paramInt1)
    {
      paramInt1 = getLayout().getLineVisibleEnd(paramInt1 - 1);
      CharSequence localCharSequence = getText();
      if ((localCharSequence instanceof SpannableStringBuilder))
      {
        ((SpannableStringBuilder)localCharSequence).delete(paramInt1 - "…".length(), localCharSequence.length());
        setText((CharSequence)((SpannableStringBuilder)localCharSequence).append((CharSequence)"…"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTitleTextView
 * JD-Core Version:    0.7.0.1
 */