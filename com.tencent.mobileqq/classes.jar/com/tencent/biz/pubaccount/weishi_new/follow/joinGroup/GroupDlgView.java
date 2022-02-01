package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import java.util.ArrayList;
import java.util.List;

public class GroupDlgView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GroupAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupGroupAdapter;
  private WSFollowFeedHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
  private List<GroupEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public GroupDlgView(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder = paramWSFollowFeedHolder;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560023, null, false));
    addView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370507));
    paramContext = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
  }
  
  public void a(List<GroupEntity> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupGroupAdapter = new GroupAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupGroupAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupDlgView
 * JD-Core Version:    0.7.0.1
 */