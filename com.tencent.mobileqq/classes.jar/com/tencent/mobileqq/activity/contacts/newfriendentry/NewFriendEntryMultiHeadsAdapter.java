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
  private int jdField_a_of_type_Int;
  PaintDrawable jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public NewFriendEntryMultiHeadsAdapter(QQAppInterface paramQQAppInterface, List<Object> paramList, PaintDrawable paramPaintDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable = paramPaintDrawable;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public NewFriendEntryMultiHeadsAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new NewFriendEntryMultiHeadsAdapter.ViewHolder(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131559850, null));
  }
  
  public void a(NewFriendEntryMultiHeadsAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localObject instanceof FriendSystemMessage))
      {
        localObject = (FriendSystemMessage)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((FriendSystemMessage)localObject).a());
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else if ((localObject instanceof PhoneContact))
      {
        localObject = (PhoneContact)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((PhoneContact)localObject).unifiedCode);
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      else if ((localObject instanceof ContactMatchMessage))
      {
        localObject = (ContactMatchMessage)localObject;
        localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, ((ContactMatchMessage)localObject).a.unifiedCode);
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable != null) {
        if (paramInt == this.jdField_a_of_type_Int - 1)
        {
          paramViewHolder.b.setVisibility(0);
          paramViewHolder.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawablePaintDrawable);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      int j = this.jdField_a_of_type_Int;
      if (i == j)
      {
        this.jdField_a_of_type_JavaUtilList.remove(j - 1);
        notifyItemRemoved(this.jdField_a_of_type_Int - 1);
      }
      this.jdField_a_of_type_JavaUtilList.add(0, paramObject);
      notifyItemInserted(0);
      i = this.jdField_a_of_type_JavaUtilList.size();
      j = this.jdField_a_of_type_Int;
      if (i == j) {
        notifyItemChanged(j - 1);
      }
    }
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = paramList.size();
      int j = this.jdField_a_of_type_Int;
      if (i > j) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, j));
      } else {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.NewFriendEntryMultiHeadsAdapter
 * JD-Core Version:    0.7.0.1
 */