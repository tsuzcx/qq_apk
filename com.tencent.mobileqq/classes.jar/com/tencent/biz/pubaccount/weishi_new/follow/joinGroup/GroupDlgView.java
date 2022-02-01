package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import uht;
import uhv;
import uhz;

public class GroupDlgView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<uhv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uht jdField_a_of_type_Uht;
  private uhz jdField_a_of_type_Uhz;
  
  public GroupDlgView(Context paramContext, uhz paramuhz)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uhz = paramuhz;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560011, null, false));
    addView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370435));
    paramContext = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
  }
  
  public void a(List<uhv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Uht = new uht(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Uhz);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uht);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupDlgView
 * JD-Core Version:    0.7.0.1
 */