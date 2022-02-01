package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.activity.contact.addcontact.QzoneSearchResultView;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.Hashtable;

public abstract class FacePreloadBaseAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private ListView a;
  private boolean b;
  private AbsListView.OnScrollListener c;
  private int d = 0;
  private int e;
  private boolean f;
  private Hashtable<String, Bitmap> g = new Hashtable();
  protected IFaceDecoder i;
  
  public FacePreloadBaseAdapter(Context paramContext, AppInterface paramAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.a = paramListView;
    this.e = paramInt;
    this.f = paramBoolean;
    this.a.setOnScrollListener(this);
    this.i = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.i.setDecodeTaskCompletionListener(this);
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (AppConstants.SEC_MSG_UIN.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130849320);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.i.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.b)
    {
      this.i.cancelPendingRequests();
      this.b = false;
    }
    if (!this.i.isPausing()) {
      this.i.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return g();
  }
  
  protected void a(BuddyListItem.ViewTag paramViewTag, Bitmap paramBitmap)
  {
    if (paramViewTag.r == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewTag.p))
    {
      paramViewTag.r.setBackgroundResource(2130845599);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewTag.p))
    {
      paramViewTag.r.setBackgroundResource(2130845594);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewTag.p))
    {
      paramViewTag.r.setBackgroundResource(2130845602);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewTag.p))
    {
      paramViewTag.r.setBackgroundResource(2130839779);
      return;
    }
    if ((AppConstants.SMARTDEVICE_UIN.equals(paramViewTag.p)) && ((paramViewTag instanceof BuddyListFriends.BuddyChildTag)))
    {
      paramBitmap = (BuddyListFriends.BuddyChildTag)paramViewTag;
      if ((paramBitmap.c instanceof Friends))
      {
        paramBitmap = (Friends)paramBitmap.c;
        if (paramBitmap != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name))
          {
            paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
            if (paramBitmap != null) {
              paramViewTag.r.setBackgroundDrawable(paramBitmap);
            }
          }
          else
          {
            paramViewTag.r.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
          }
        }
      }
    }
    else
    {
      if (paramBitmap != null)
      {
        paramViewTag.r.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
      paramViewTag.r.setBackgroundDrawable(new BitmapDrawable(a(paramViewTag.q, paramViewTag.p)));
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.d == 0)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        int k = ((ListView)localObject).getChildCount();
        int j = 0;
        while (j < k)
        {
          localObject = (FacePreloadHolder.ViewHolder)this.a.getChildAt(j).getTag();
          if ((localObject != null) && (((FacePreloadHolder.ViewHolder)localObject).y != null) && (((FacePreloadHolder.ViewHolder)localObject).y.length() > 0) && (((FacePreloadHolder.ViewHolder)localObject).y.equals(paramString)))
          {
            ((FacePreloadHolder.ViewHolder)localObject).A.setImageBitmap(paramBitmap);
            return;
          }
          j += 1;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
    }
    IFaceDecoder localIFaceDecoder = this.i;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.i = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.i.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void c()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ListView)localObject).getOnScrollListener() == this)) {
      this.a.setOnScrollListener(null);
    }
    localObject = this.i;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.a = null;
  }
  
  protected Bitmap g()
  {
    return ImageUtil.k();
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
    boolean bool = this.b;
    paramInt2 = 0;
    if (bool)
    {
      if (paramInt1 == 0) {
        this.b = false;
      }
    }
    else if (!this.i.isPausing())
    {
      if (paramBitmap != null) {
        this.g.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = this.d;
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          int j = this.a.getChildCount();
          paramInt1 = paramInt2;
          while (paramInt1 < j)
          {
            paramString = this.a.getChildAt(paramInt1);
            paramBitmap = paramString.getTag();
            if ((paramBitmap != null) && ((paramBitmap instanceof FacePreloadHolder.ViewHolder)))
            {
              paramString = (FacePreloadHolder.ViewHolder)paramBitmap;
              if ((paramString != null) && (paramString.y != null) && (paramString.y.length() > 0))
              {
                paramBitmap = (Bitmap)this.g.get(paramString.y);
                if (paramBitmap != null) {
                  paramString.A.setImageBitmap(paramBitmap);
                }
              }
            }
            else if ((paramString instanceof QzoneSearchResultView))
            {
              paramString = (QzoneSearchResultView)paramString;
              if ((paramString != null) && (!TextUtils.isEmpty(paramString.getUin())))
              {
                paramBitmap = (Bitmap)this.g.get(paramString.getUin());
                if (paramBitmap != null) {
                  paramString.setAvartaView(paramBitmap);
                }
              }
            }
            else if ((paramBitmap != null) && ((paramBitmap instanceof BuddyListItem.ViewTag)))
            {
              paramString = (BuddyListItem.ViewTag)paramBitmap;
              a(paramString, (Bitmap)this.g.get(paramString.p));
            }
            paramInt1 += 1;
          }
        }
        this.g.clear();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.c;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    int j = 0;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.b = false;
      this.i.cancelPendingRequests();
      this.i.pause();
    }
    else
    {
      if (this.i.isPausing()) {
        this.i.resume();
      }
      localObject = this.a;
      if (localObject != null)
      {
        int k = ((ListView)localObject).getChildCount();
        while (j < k)
        {
          localObject = this.a.getChildAt(j).getTag();
          if ((localObject != null) && ((localObject instanceof FacePreloadHolder.ViewHolder)))
          {
            localObject = (FacePreloadHolder.ViewHolder)localObject;
            if ((localObject != null) && (((FacePreloadHolder.ViewHolder)localObject).y != null) && (((FacePreloadHolder.ViewHolder)localObject).y.length() > 0)) {
              ((FacePreloadHolder.ViewHolder)localObject).A.setImageBitmap(a(((FacePreloadHolder.ViewHolder)localObject).z, ((FacePreloadHolder.ViewHolder)localObject).y));
            }
          }
          else if ((localObject != null) && ((localObject instanceof BuddyListItem.ViewTag)))
          {
            localObject = (BuddyListItem.ViewTag)localObject;
            a((BuddyListItem.ViewTag)localObject, (Bitmap)this.g.get(((BuddyListItem.ViewTag)localObject).p));
          }
          j += 1;
        }
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.FacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */