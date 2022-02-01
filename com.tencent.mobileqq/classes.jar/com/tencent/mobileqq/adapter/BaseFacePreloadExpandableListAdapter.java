package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public abstract class BaseFacePreloadExpandableListAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  public ExpandableListView a;
  
  public BaseFacePreloadExpandableListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    ImageUtil.c();
  }
  
  protected void a(FacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(FacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844376);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844371);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844379);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramViewHolder.a))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839708);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramViewHolder.jdField_c_of_type_Int, paramViewHolder.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.c();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.a, paramViewHolder.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof FacePreloadBaseAdapter.ViewHolder)))
      {
        localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
        if (paramString != null) {
          break label69;
        }
        a((FacePreloadBaseAdapter.ViewHolder)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((FacePreloadBaseAdapter.ViewHolder)localObject).a))
      {
        i += 1;
        break;
      }
      ((FacePreloadBaseAdapter.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public void configHeaderView(View paramView, int paramInt) {}
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 0;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
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
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */