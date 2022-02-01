package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public abstract class SwipFacePreloadExpandableAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  protected ExpandableListView a;
  
  public SwipFacePreloadExpandableAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    ImageUtil.f();
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.d == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.d.setBackgroundResource(2130844282);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.d.setBackgroundResource(2130844277);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.d.setBackgroundResource(2130844285);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.d.setBackgroundResource(2130839566);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      if ((AppConstants.SMARTDEVICE_UIN.equals(paramViewHolder.a)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        Object localObject = (Friends)((BuddyListFriends.BuddyChildTag)paramViewHolder).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramViewHolder.d.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByDin(((Friends)localObject).name);
          }
        }
      }
      else
      {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramViewHolder.b, paramViewHolder.a);
      }
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        if ((paramViewHolder instanceof BuddyListTroop.TroopDisChildTag)) {
          localBitmap = ImageUtil.e();
        } else {
          localBitmap = ImageUtil.f();
        }
      }
      paramBitmap = localBitmap;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.a, paramViewHolder.b, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null)
    {
      if ((paramViewHolder.b == 1) && ((paramViewHolder.d instanceof DynamicAvatarView)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        if (!((BuddyListFriends.BuddyChildTag)paramViewHolder).b)
        {
          paramViewHolder.d.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramViewHolder.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap), 1, paramViewHolder.a, 100, false, true, 1);
          return;
        }
        paramViewHolder.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      paramViewHolder.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof SwipFacePreloadExpandableAdapter.ViewHolder)))
      {
        localObject = (SwipFacePreloadExpandableAdapter.ViewHolder)localObject;
        if (paramString == null)
        {
          a((SwipFacePreloadExpandableAdapter.ViewHolder)localObject, null, false);
        }
        else if (paramString.equals(((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).a))
        {
          if (paramBitmap == null) {
            break;
          }
          if ((((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).b == 1) && ((((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).d instanceof DynamicAvatarView)) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
          {
            if (!((BuddyListFriends.BuddyChildTag)localObject).b)
            {
              ((DynamicAvatarView)((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
              return;
            }
            ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
            return;
          }
          ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
          return;
        }
      }
      i += 1;
    }
  }
  
  public void b()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      a(null, null);
    }
    DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter
 * JD-Core Version:    0.7.0.1
 */