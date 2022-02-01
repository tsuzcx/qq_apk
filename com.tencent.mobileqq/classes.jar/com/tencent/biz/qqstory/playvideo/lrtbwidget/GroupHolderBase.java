package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class GroupHolderBase
  extends StoryPlayerContextWrapper
{
  protected int a;
  @NonNull
  public final View a;
  public IDataProvider.GroupId a;
  protected GroupHolderContainer a;
  protected String a;
  public List<StoryPlayerVideoData> a;
  @Deprecated
  protected boolean a;
  private final String b;
  protected boolean b;
  
  public GroupHolderBase(@NonNull View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = null;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(System.identityHashCode(this));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if ((paramView instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewView = a((ViewGroup)paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public GroupHolderBase(@NonNull ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = null;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(System.identityHashCode(this));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public GroupHolderBase a(Class<? extends GroupHolderBase> paramClass)
  {
    GroupHolderContainer localGroupHolderContainer = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetGroupHolderContainer;
    if (localGroupHolderContainer != null) {
      return localGroupHolderContainer.b(paramClass);
    }
    return null;
  }
  
  public GroupHolderContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetGroupHolderContainer;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(System.identityHashCode(this));
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
    localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)((Iterator)localObject).next();
      if ((paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
        localStoryPlayerVideoData.a = ((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a;
      } else {
        localStoryPlayerVideoData.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_b_of_type_Boolean = true;
  }
  
  void a(GroupHolderContainer paramGroupHolderContainer)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetGroupHolderContainer = paramGroupHolderContainer;
  }
  
  protected void b() {}
  
  public void c()
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderBase
 * JD-Core Version:    0.7.0.1
 */