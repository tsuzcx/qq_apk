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
  extends BaseAdapter<MsgTabNodeInfo, BaseViewHolder<MsgTabNodeInfo>>
{
  private int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean = false;
  
  public MsgTabStoryNodeAdapter(Context paramContext)
  {
    super(paramContext);
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
        return i + b();
      }
      i += 1;
    }
    return b();
  }
  
  public void a(BaseViewHolder<MsgTabNodeInfo> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter
 * JD-Core Version:    0.7.0.1
 */