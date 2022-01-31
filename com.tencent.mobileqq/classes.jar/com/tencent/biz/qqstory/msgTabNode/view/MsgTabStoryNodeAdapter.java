package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.ViewHolderFactory;
import java.util.List;

public class MsgTabStoryNodeAdapter
  extends BaseAdapter
{
  private int a;
  
  public MsgTabStoryNodeAdapter(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a(int paramInt)
  {
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)a(paramInt);
    if (localMsgTabNodeInfo != null) {
      return localMsgTabNodeInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = a();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((MsgTabNodeInfo)localList.get(i)).jdField_a_of_type_JavaLangString, paramString)) {
        return b() + i;
      }
      i += 1;
    }
    return b();
  }
  
  public void a(BaseViewHolder paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.a();
  }
  
  public boolean a()
  {
    int j = getItemCount();
    int i = 0;
    while (i < j)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)a(i);
      if ((localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.jdField_a_of_type_Int != 1) && (localMsgTabNodeInfo.jdField_a_of_type_Int != 4)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public BaseViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    return ViewHolderFactory.a(paramViewGroup, paramInt);
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    paramBaseViewHolder.a((MsgTabNodeInfo)a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter
 * JD-Core Version:    0.7.0.1
 */