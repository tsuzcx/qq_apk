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
  private final QQAppInterface a;
  private int b = 0;
  protected XListView d;
  protected IFaceDecoder e;
  protected Context f;
  
  public AlphabetFriendPreloadAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.f = paramContext;
    this.a = paramQQAppInterface;
    this.d = paramXListView;
    paramContext = this.d;
    if (paramContext != null) {
      paramContext.setOnScrollListener(this);
    }
    this.e = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
    this.e.setDecodeTaskCompletionListener(this);
    ImageUtil.k();
  }
  
  protected void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, Bitmap paramBitmap)
  {
    a(paramBuddyChildTag, paramBitmap, true);
  }
  
  protected void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBuddyChildTag.r == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramBuddyChildTag.p))
    {
      paramBuddyChildTag.r.setBackgroundResource(2130845599);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramBuddyChildTag.p))
    {
      paramBuddyChildTag.r.setBackgroundResource(2130845594);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramBuddyChildTag.p))
    {
      paramBuddyChildTag.r.setBackgroundResource(2130845602);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramBuddyChildTag.p))
    {
      paramBuddyChildTag.r.setBackgroundResource(2130839779);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      if (AppConstants.SMARTDEVICE_UIN.equals(paramBuddyChildTag.p))
      {
        Object localObject = (Friends)paramBuddyChildTag.c;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramBuddyChildTag.r.setBackgroundDrawable((Drawable)localObject);
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
        localBitmap = this.e.getBitmapFromCache(paramBuddyChildTag.q, paramBuddyChildTag.p);
      }
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.k();
      }
      paramBitmap = localBitmap;
      if (!this.e.isPausing())
      {
        this.e.requestDecodeFace(paramBuddyChildTag.p, paramBuddyChildTag.q, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null)
    {
      paramBuddyChildTag.r.setImageDrawable(null);
      if ((paramBuddyChildTag.q == 1) && ((paramBuddyChildTag.r instanceof DynamicAvatarView)) && ((paramBuddyChildTag instanceof BuddyListFriends.BuddyChildTag)))
      {
        if (!paramBuddyChildTag.n)
        {
          paramBuddyChildTag.r.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramBuddyChildTag.r).setFaceDrawable(this.a, new BitmapDrawable(this.f.getResources(), paramBitmap), 1, paramBuddyChildTag.p, 100, false, true, 1);
          return;
        }
        paramBuddyChildTag.r.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), paramBitmap));
        return;
      }
      paramBuddyChildTag.r.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    int j = ((XListView)localObject).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.d.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if (paramString == null)
        {
          a((BuddyListFriends.BuddyChildTag)localObject, null, false);
        }
        else if (paramString.equals(((BuddyListFriends.BuddyChildTag)localObject).p))
        {
          if (paramBitmap == null) {
            break;
          }
          if ((((BuddyListFriends.BuddyChildTag)localObject).q == 1) && ((((BuddyListFriends.BuddyChildTag)localObject).r instanceof DynamicAvatarView)))
          {
            if (!((BuddyListFriends.BuddyChildTag)localObject).n)
            {
              ((DynamicAvatarView)((BuddyListFriends.BuddyChildTag)localObject).r).a(new BitmapDrawable(this.f.getResources(), paramBitmap));
              return;
            }
            ((BuddyListFriends.BuddyChildTag)localObject).r.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), paramBitmap));
            return;
          }
          ((BuddyListFriends.BuddyChildTag)localObject).r.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), paramBitmap));
          return;
        }
      }
      i += 1;
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
  
  public void h()
  {
    IFaceDecoder localIFaceDecoder = this.e;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.e.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.b = paramInt;
    if (paramInt != 0)
    {
      this.e.cancelPendingRequests();
      this.e.pause();
      DynamicFaceDrawable.a(this.a);
      return;
    }
    if (this.e.isPausing())
    {
      this.e.cancelPendingRequests();
      this.e.resume();
      a(null, null);
    }
    DynamicFaceDrawable.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendPreloadAdapter
 * JD-Core Version:    0.7.0.1
 */