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
import wbh;
import wbi;
import wbj;
import wbk;
import wbl;

public class QCirclePushAsyncTextView
  extends AsyncRichTextView
{
  private int jdField_a_of_type_Int = 15;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private List<FeedCloudMeta.StUser> jdField_a_of_type_JavaUtilList;
  private wbl jdField_a_of_type_Wbl;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
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
    localSpannableString.setSpan(new wbj(this), 0, 1, 33);
    return localSpannableString;
  }
  
  private SpannableString a(FeedCloudMeta.StUser paramStUser)
  {
    SpannableString localSpannableString = new SpannableString(paramStUser.nick.get());
    localSpannableString.setSpan(new wbh(this, paramStUser), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  private SpannableString a(String paramString)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new wbi(this), 0, paramString.length(), 33);
    return paramString;
  }
  
  private SpannableString b()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangString);
    localSpannableString.setSpan(new wbk(this), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localSpannableStringBuilder.append(a());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(b());
    }
    localSpannableStringBuilder.append("   ");
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
    if ((!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size())) {
      localSpannableStringBuilder.append(a(this.b));
    }
    setHighlightColor(getResources().getColor(2131167247));
    setText(localSpannableStringBuilder);
  }
  
  public void setBold(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setDataList(Drawable paramDrawable, String paramString1, List<FeedCloudMeta.StUser> paramList, String paramString2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString2;
    a();
  }
  
  public void setDataList(List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    setDataList(null, "", paramList, paramString);
  }
  
  public void setMaxNum(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnClickItemListener(wbl paramwbl)
  {
    this.jdField_a_of_type_Wbl = paramwbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView
 * JD-Core Version:    0.7.0.1
 */