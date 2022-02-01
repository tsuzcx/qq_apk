package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class VideoHolderBase
  extends StoryPlayerContextWrapper
{
  public int a;
  @NonNull
  public final View a;
  public StoryPlayerGroupHolder a;
  public StoryPlayerVideoData a;
  protected VideoHolderContainer a;
  protected String a;
  protected boolean a;
  public int b;
  private final String b;
  protected boolean b;
  
  public VideoHolderBase(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.playernew." + getClass().getSimpleName());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public VideoHolderBase a(Class<? extends VideoHolderBase> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderContainer != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderContainer.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    SLog.a(this.jdField_a_of_type_JavaLangString, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = paramStoryPlayerGroupHolder;
  }
  
  void a(VideoHolderContainer paramVideoHolderContainer)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderContainer = paramVideoHolderContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      b(this.jdField_b_of_type_Boolean);
      return;
    }
    SLog.e(this.jdField_a_of_type_JavaLangString, "onSelected donot changed !");
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean)
  {
    SLog.b(this.jdField_a_of_type_JavaLangString, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(paramBoolean));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = null;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String toString()
  {
    return "VideoHolderBase{, GroupPos=" + this.jdField_a_of_type_Int + ", VideoPos=" + this.jdField_b_of_type_Int + ", mData=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase
 * JD-Core Version:    0.7.0.1
 */