package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import uet;
import ueu;
import uev;
import uew;

public class QCirclePushAsyncTextView
  extends AsyncRichTextView
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private List<FeedCloudMeta.StUser> jdField_a_of_type_JavaUtilList;
  private uew jdField_a_of_type_Uew;
  private boolean jdField_a_of_type_Boolean;
  private int d = 15;
  
  public QCirclePushAsyncTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(" ");
    localSpannableString.setSpan(new VerticalCenterImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), 0, 1, 33);
    localSpannableString.setSpan(new uev(this), 0, 1, 33);
    return localSpannableString;
  }
  
  private SpannableString a(FeedCloudMeta.StUser paramStUser)
  {
    SpannableString localSpannableString = new SpannableString(paramStUser.nick.get());
    localSpannableString.setSpan(new uet(this, paramStUser), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  private SpannableString a(String paramString)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new ueu(this), 0, paramString.length(), 33);
    return paramString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localSpannableStringBuilder.append(a());
      localSpannableStringBuilder.append(" ");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localSpannableStringBuilder.append(a((FeedCloudMeta.StUser)this.jdField_a_of_type_JavaUtilList.get(i)));
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        localSpannableStringBuilder.append("、 ");
      }
      for (;;)
      {
        i += 1;
        break;
        localSpannableStringBuilder.append(" ");
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.d > this.jdField_a_of_type_JavaUtilList.size())) {
      localSpannableStringBuilder.append(a(this.jdField_a_of_type_JavaLangString));
    }
    setHighlightColor(getResources().getColor(2131167140));
    setText(localSpannableStringBuilder);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Uew != null) {
      this.jdField_a_of_type_Uew = null;
    }
  }
  
  public void setBold(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setDataList(Drawable paramDrawable, List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  public void setDataList(List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    setDataList(null, paramList, paramString);
  }
  
  public void setMaxNum(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnClickItemListener(uew paramuew)
  {
    this.jdField_a_of_type_Uew = paramuew;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView
 * JD-Core Version:    0.7.0.1
 */