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
  private int f = -1;
  private boolean g = false;
  
  public MsgTabStoryNodeAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a(int paramInt)
  {
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)b(paramInt);
    if (localMsgTabNodeInfo != null) {
      return localMsgTabNodeInfo.b;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    List localList = b();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((MsgTabNodeInfo)localList.get(i)).d, paramString)) {
        return i + d();
      }
      i += 1;
    }
    return d();
  }
  
  public void a(BaseViewHolder<MsgTabNodeInfo> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.b();
  }
  
  public BaseViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    return ViewHolderFactory.a(paramViewGroup, paramInt);
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    paramBaseViewHolder.a((MsgTabNodeInfo)b(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter
 * JD-Core Version:    0.7.0.1
 */