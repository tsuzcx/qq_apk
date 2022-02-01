package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class PlaceholderSegment
  extends SegmentView
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int = 0;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private String jdField_a_of_type_JavaLangString = null;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public PlaceholderSegment(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void M_()
  {
    super.M_();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
    if (localObject == null) {
      return;
    }
    localObject = (ImageView)((BaseViewHolder)localObject).a(2131374561);
    if (localObject == null) {
      return;
    }
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      ((ImageView)localObject).setImageResource(this.jdField_b_of_type_Int);
      return;
    }
    ((ImageView)localObject).setImageResource(this.jdField_a_of_type_Int);
  }
  
  public void P_()
  {
    Q_();
  }
  
  protected void Q_()
  {
    SegmentView localSegmentView = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localSegmentView != null) && (localSegmentView.a() != 0))
    {
      a_(false);
      return;
    }
    a_(true);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131374560);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131374561);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131708183));
      localStringBuilder.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("\n拍摄一段小视频，分享眼前的世界");
      paramViewGroup.setText(localStringBuilder.toString());
    }
    else
    {
      paramViewGroup.setText(this.jdField_a_of_type_JavaLangString);
    }
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    } else {
      localImageView.setImageResource(this.jdField_a_of_type_Int);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561654, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "PlaceholderSegment";
  }
  
  protected void c()
  {
    Q_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment
 * JD-Core Version:    0.7.0.1
 */