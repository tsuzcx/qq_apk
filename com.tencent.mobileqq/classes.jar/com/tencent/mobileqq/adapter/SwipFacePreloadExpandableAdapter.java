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
  private final Context a;
  private final QQAppInterface b;
  private IFaceDecoder c = null;
  protected ExpandableListView r = null;
  
  public SwipFacePreloadExpandableAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.r = paramExpandableListView;
    this.c = ((IQQAvatarService)this.b.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.b);
    this.c.setDecodeTaskCompletionListener(this);
    ImageUtil.k();
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.r == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewHolder.p))
    {
      paramViewHolder.r.setBackgroundResource(2130845599);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewHolder.p))
    {
      paramViewHolder.r.setBackgroundResource(2130845594);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewHolder.p))
    {
      paramViewHolder.r.setBackgroundResource(2130845602);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewHolder.p))
    {
      paramViewHolder.r.setBackgroundResource(2130839779);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      if ((AppConstants.SMARTDEVICE_UIN.equals(paramViewHolder.p)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        Object localObject = (Friends)((BuddyListFriends.BuddyChildTag)paramViewHolder).c;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramViewHolder.r.setBackgroundDrawable((Drawable)localObject);
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
        localBitmap = this.c.getBitmapFromCache(paramViewHolder.q, paramViewHolder.p);
      }
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        if ((paramViewHolder instanceof BuddyListTroop.TroopDisChildTag)) {
          localBitmap = ImageUtil.i();
        } else {
          localBitmap = ImageUtil.k();
        }
      }
      paramBitmap = localBitmap;
      if (!this.c.isPausing())
      {
        this.c.requestDecodeFace(paramViewHolder.p, paramViewHolder.q, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null)
    {
      if ((paramViewHolder.q == 1) && ((paramViewHolder.r instanceof DynamicAvatarView)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        if (!((BuddyListFriends.BuddyChildTag)paramViewHolder).n)
        {
          paramViewHolder.r.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramViewHolder.r).setFaceDrawable(this.b, new BitmapDrawable(this.a.getResources(), paramBitmap), 1, paramViewHolder.p, 100, false, true, 1);
          return;
        }
        paramViewHolder.r.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
        return;
      }
      paramViewHolder.r.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.r.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.r.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof SwipFacePreloadExpandableAdapter.ViewHolder)))
      {
        localObject = (SwipFacePreloadExpandableAdapter.ViewHolder)localObject;
        if (paramString == null)
        {
          a((SwipFacePreloadExpandableAdapter.ViewHolder)localObject, null, false);
        }
        else if (paramString.equals(((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).p))
        {
          if (paramBitmap == null) {
            break;
          }
          if ((((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).q == 1) && ((((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).r instanceof DynamicAvatarView)) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
          {
            if (!((BuddyListFriends.BuddyChildTag)localObject).n)
            {
              ((DynamicAvatarView)((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).r).a(new BitmapDrawable(this.a.getResources(), paramBitmap));
              return;
            }
            ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).r.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
            return;
          }
          ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).r.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
          return;
        }
      }
      i += 1;
    }
  }
  
  public void b()
  {
    IFaceDecoder localIFaceDecoder = this.c;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.c.isPausing()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.c.cancelPendingRequests();
      this.c.pause();
      DynamicFaceDrawable.a(this.b);
      return;
    }
    if (this.c.isPausing())
    {
      this.c.cancelPendingRequests();
      this.c.resume();
      a(null, null);
    }
    DynamicFaceDrawable.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter
 * JD-Core Version:    0.7.0.1
 */