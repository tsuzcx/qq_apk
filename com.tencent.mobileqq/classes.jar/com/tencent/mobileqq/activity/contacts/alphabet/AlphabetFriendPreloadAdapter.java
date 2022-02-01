package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public abstract class AlphabetFriendPreloadAdapter
  extends PinnedDividerListView.DividerAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IFaceDecoder a;
  protected XListView a;
  
  public AlphabetFriendPreloadAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    paramContext = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (paramContext != null) {
      paramContext.setOnScrollListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    ImageUtil.f();
  }
  
  protected void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, Bitmap paramBitmap)
  {
    a(paramBuddyChildTag, paramBitmap, true);
  }
  
  protected void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBuddyChildTag.d == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramBuddyChildTag.jdField_a_of_type_JavaLangString))
    {
      paramBuddyChildTag.d.setBackgroundResource(2130844282);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramBuddyChildTag.jdField_a_of_type_JavaLangString))
    {
      paramBuddyChildTag.d.setBackgroundResource(2130844277);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramBuddyChildTag.jdField_a_of_type_JavaLangString))
    {
      paramBuddyChildTag.d.setBackgroundResource(2130844285);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramBuddyChildTag.jdField_a_of_type_JavaLangString))
    {
      paramBuddyChildTag.d.setBackgroundResource(2130839566);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      if (AppConstants.SMARTDEVICE_UIN.equals(paramBuddyChildTag.jdField_a_of_type_JavaLangString))
      {
        Object localObject = (Friends)paramBuddyChildTag.jdField_a_of_type_JavaLangObject;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramBuddyChildTag.d.setBackgroundDrawable((Drawable)localObject);
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
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramBuddyChildTag.jdField_b_of_type_Int, paramBuddyChildTag.jdField_a_of_type_JavaLangString);
      }
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.f();
      }
      paramBitmap = localBitmap;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramBuddyChildTag.jdField_a_of_type_JavaLangString, paramBuddyChildTag.jdField_b_of_type_Int, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null)
    {
      paramBuddyChildTag.d.setImageDrawable(null);
      if ((paramBuddyChildTag.jdField_b_of_type_Int == 1) && ((paramBuddyChildTag.d instanceof DynamicAvatarView)) && ((paramBuddyChildTag instanceof BuddyListFriends.BuddyChildTag)))
      {
        if (!paramBuddyChildTag.jdField_b_of_type_Boolean)
        {
          paramBuddyChildTag.d.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramBuddyChildTag.d).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap), 1, paramBuddyChildTag.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
        }
        paramBuddyChildTag.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
      paramBuddyChildTag.d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject == null) {
      return;
    }
    int j = ((XListView)localObject).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if (paramString == null)
        {
          a((BuddyListFriends.BuddyChildTag)localObject, null, false);
        }
        else if (paramString.equals(((BuddyListFriends.BuddyChildTag)localObject).jdField_a_of_type_JavaLangString))
        {
          if (paramBitmap == null) {
            break;
          }
          if ((((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_Int == 1) && ((((BuddyListFriends.BuddyChildTag)localObject).d instanceof DynamicAvatarView)))
          {
            if (!((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_Boolean)
            {
              ((DynamicAvatarView)((BuddyListFriends.BuddyChildTag)localObject).d).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
              return;
            }
            ((BuddyListFriends.BuddyChildTag)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
            return;
          }
          ((BuddyListFriends.BuddyChildTag)localObject).d.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
          return;
        }
      }
      i += 1;
    }
  }
  
  public void e()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
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
    this.jdField_a_of_type_Int = paramInt;
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
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendPreloadAdapter
 * JD-Core Version:    0.7.0.1
 */