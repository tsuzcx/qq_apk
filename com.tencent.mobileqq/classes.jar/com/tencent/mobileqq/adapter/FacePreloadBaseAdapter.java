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
  private int jdField_a_of_type_Int = 0;
  protected IFaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public FacePreloadBaseAdapter(Context paramContext, AppInterface paramAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  protected Bitmap a()
  {
    return ImageUtil.f();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (AppConstants.SEC_MSG_UIN.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130847660);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  protected void a(BuddyListItem.ViewTag paramViewTag, Bitmap paramBitmap)
  {
    if (paramViewTag.d == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewTag.a))
    {
      paramViewTag.d.setBackgroundResource(2130844282);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewTag.a))
    {
      paramViewTag.d.setBackgroundResource(2130844277);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewTag.a))
    {
      paramViewTag.d.setBackgroundResource(2130844285);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewTag.a))
    {
      paramViewTag.d.setBackgroundResource(2130839566);
      return;
    }
    if ((AppConstants.SMARTDEVICE_UIN.equals(paramViewTag.a)) && ((paramViewTag instanceof BuddyListFriends.BuddyChildTag)))
    {
      paramBitmap = (BuddyListFriends.BuddyChildTag)paramViewTag;
      if ((paramBitmap.a instanceof Friends))
      {
        paramBitmap = (Friends)paramBitmap.a;
        if (paramBitmap != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name))
          {
            paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
            if (paramBitmap != null) {
              paramViewTag.d.setBackgroundDrawable(paramBitmap);
            }
          }
          else
          {
            paramViewTag.d.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
          }
        }
      }
    }
    else
    {
      if (paramBitmap != null)
      {
        paramViewTag.d.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
      paramViewTag.d.setBackgroundDrawable(new BitmapDrawable(a(paramViewTag.jdField_b_of_type_Int, paramViewTag.a)));
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject = (FacePreloadHolder.ViewHolder)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && (((FacePreloadHolder.ViewHolder)localObject).a != null) && (((FacePreloadHolder.ViewHolder)localObject).a.length() > 0) && (((FacePreloadHolder.ViewHolder)localObject).a.equals(paramString)))
          {
            ((FacePreloadHolder.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
    }
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    if ((localObject != null) && (((ListView)localObject).getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
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
    boolean bool = this.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if (bool)
    {
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = this.jdField_a_of_type_Int;
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
          paramInt1 = paramInt2;
          while (paramInt1 < i)
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
            paramBitmap = paramString.getTag();
            if ((paramBitmap != null) && ((paramBitmap instanceof FacePreloadHolder.ViewHolder)))
            {
              paramString = (FacePreloadHolder.ViewHolder)paramBitmap;
              if ((paramString != null) && (paramString.a != null) && (paramString.a.length() > 0))
              {
                paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a);
                if (paramBitmap != null) {
                  paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
                }
              }
            }
            else if ((paramString instanceof QzoneSearchResultView))
            {
              paramString = (QzoneSearchResultView)paramString;
              if ((paramString != null) && (!TextUtils.isEmpty(paramString.a())))
              {
                paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a());
                if (paramBitmap != null) {
                  paramString.setAvartaView(paramBitmap);
                }
              }
            }
            else if ((paramBitmap != null) && ((paramBitmap instanceof BuddyListItem.ViewTag)))
            {
              paramString = (BuddyListItem.ViewTag)paramBitmap;
              a(paramString, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a));
            }
            paramInt1 += 1;
          }
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        while (i < j)
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof FacePreloadHolder.ViewHolder)))
          {
            localObject = (FacePreloadHolder.ViewHolder)localObject;
            if ((localObject != null) && (((FacePreloadHolder.ViewHolder)localObject).a != null) && (((FacePreloadHolder.ViewHolder)localObject).a.length() > 0)) {
              ((FacePreloadHolder.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((FacePreloadHolder.ViewHolder)localObject).jdField_c_of_type_Int, ((FacePreloadHolder.ViewHolder)localObject).a));
            }
          }
          else if ((localObject != null) && ((localObject instanceof BuddyListItem.ViewTag)))
          {
            localObject = (BuddyListItem.ViewTag)localObject;
            a((BuddyListItem.ViewTag)localObject, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(((BuddyListItem.ViewTag)localObject).a));
          }
          i += 1;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.FacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */