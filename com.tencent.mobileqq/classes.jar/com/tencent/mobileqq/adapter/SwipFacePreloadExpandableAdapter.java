package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public abstract class SwipFacePreloadExpandableAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public ExpandableListView a;
  
  public SwipFacePreloadExpandableAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    ImageUtil.a();
  }
  
  public void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (AppConstants.y.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841551);
      return;
    }
    if (AppConstants.z.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841549);
      return;
    }
    if (AppConstants.A.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841554);
      return;
    }
    if (AppConstants.x.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838728);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((AppConstants.W.equals(paramViewHolder.jdField_a_of_type_JavaLangString)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        Object localObject = (Friends)((BuddyListFriends.BuddyChildTag)paramViewHolder).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByDin(((Friends)localObject).name);
          }
        }
        paramBitmap = localBitmap;
      }
    }
    for (;;)
    {
      localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      if ((paramViewHolder.jdField_a_of_type_Int == 1) && ((paramViewHolder.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        if (!((BuddyListFriends.BuddyChildTag)paramViewHolder).b)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          ((DynamicAvatarView)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap), 1, paramViewHolder.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        }
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        return;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      a(null, null);
    }
    DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof SwipFacePreloadExpandableAdapter.ViewHolder)))
      {
        localObject = (SwipFacePreloadExpandableAdapter.ViewHolder)localObject;
        if (paramString != null) {
          break label69;
        }
        a((SwipFacePreloadExpandableAdapter.ViewHolder)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_Int != 1) || (!(((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(localObject instanceof BuddyListFriends.BuddyChildTag))) {
          break label175;
        }
        if (((BuddyListFriends.BuddyChildTag)localObject).b) {
          break label151;
        }
        ((DynamicAvatarView)((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView).a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    return;
    label175:
    ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter
 * JD-Core Version:    0.7.0.1
 */