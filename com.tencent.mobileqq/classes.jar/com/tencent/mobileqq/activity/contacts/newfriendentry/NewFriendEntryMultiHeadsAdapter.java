package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

public class NewFriendEntryMultiHeadsAdapter
  extends RecyclerView.Adapter<NewFriendEntryMultiHeadsAdapter.ViewHolder>
{
  PaintDrawable a;
  private QQAppInterface b;
  private List<Object> c = new ArrayList();
  private int d;
  
  public NewFriendEntryMultiHeadsAdapter(QQAppInterface paramQQAppInterface, List<Object> paramList, PaintDrawable paramPaintDrawable, int paramInt)
  {
    this.b = paramQQAppInterface;
    if (paramList != null) {
      this.c = paramList;
    }
    this.a = paramPaintDrawable;
    this.d = paramInt;
  }
  
  public NewFriendEntryMultiHeadsAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new NewFriendEntryMultiHeadsAdapter.ViewHolder(this, LayoutInflater.from(this.b.getApp()).inflate(2131625893, null));
  }
  
  public void a(NewFriendEntryMultiHeadsAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.c.get(paramInt);
      if ((localObject instanceof FriendSystemMessage))
      {
        localObject = (FriendSystemMessage)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.b, 1, ((FriendSystemMessage)localObject).a());
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else if ((localObject instanceof PhoneContact))
      {
        localObject = (PhoneContact)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.b, 11, ((PhoneContact)localObject).unifiedCode);
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else if ((localObject instanceof ContactMatchMessage))
      {
        localObject = (ContactMatchMessage)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.b, 11, ((ContactMatchMessage)localObject).a.unifiedCode);
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      if (this.a != null) {
        if (paramInt == this.d - 1)
        {
          paramViewHolder.b.setVisibility(0);
          paramViewHolder.b.setBackgroundDrawable(this.a);
        }
        else
        {
          paramViewHolder.b.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = this.c.size();
      int j = this.d;
      if (i == j)
      {
        this.c.remove(j - 1);
        notifyItemRemoved(this.d - 1);
      }
      this.c.add(0, paramObject);
      notifyItemInserted(0);
      i = this.c.size();
      j = this.d;
      if (i == j) {
        notifyItemChanged(j - 1);
      }
    }
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList != null)
    {
      this.c.clear();
      int i = paramList.size();
      int j = this.d;
      if (i > j) {
        this.c.addAll(paramList.subList(0, j));
      } else {
        this.c.addAll(paramList);
      }
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.NewFriendEntryMultiHeadsAdapter
 * JD-Core Version:    0.7.0.1
 */