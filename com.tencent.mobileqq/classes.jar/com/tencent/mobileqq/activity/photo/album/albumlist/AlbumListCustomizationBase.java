package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AlbumListCustomizationBase<O extends OtherCommonData>
  extends AlbumListCustomization<O>
  implements AlbumListCustomization.IalbumListAdapterCallBack
{
  protected Activity a;
  protected AlbumListAdapter a;
  
  protected AlbumListCustomizationBase(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
    this.jdField_a_of_type_AndroidAppActivity = paramAbstractAlbumListFragment.getActivity();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization$IalbumListAdapterCallBack = this;
  }
  
  public Pair<Boolean, List<QQAlbumInfo>> a(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = b();
    LogTag.a();
    Pair localPair = b(paramInt);
    List localList = (List)localPair.second;
    LogTag.a("QQAlbum", "queryAllAlbumList");
    localAlbumListAdapter.a(localList);
    localAlbumListAdapter.b();
    return localPair;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.getResources();
    AlbumListAdapter localAlbumListAdapter = b();
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131560958, null);
      paramViewGroup = (TextView)localView;
    }
    else
    {
      paramViewGroup = (TextView)paramView;
      localView = paramView;
    }
    QQAlbumInfo localQQAlbumInfo = localAlbumListAdapter.a(paramInt);
    paramView = new StringBuilder();
    paramView.append(localQQAlbumInfo.name);
    paramView.append("，");
    paramView.append(localQQAlbumInfo.mMediaFileCount);
    paramView.append("张照片");
    localView.setContentDescription(paramView.toString());
    paramView = localQQAlbumInfo.name;
    if (localQQAlbumInfo.mMediaFileCount > 0)
    {
      paramView = new StringBuilder();
      paramView.append(localQQAlbumInfo.name);
      paramView.append(String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) }));
      paramView = paramView.toString();
    }
    paramViewGroup.setText(paramView);
    paramView = paramViewGroup.getCompoundDrawables()[0];
    URL localURL = a(paramInt, localAlbumListAdapter, localQQAlbumInfo);
    Object localObject = localQQAlbumInfo.mCoverInfo;
    localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
    ((LocalMediaInfo)localObject).thumbWidth = 200;
    if ((paramView != null) && (URLDrawable.class.isInstance(paramView)))
    {
      paramView = (URLDrawable)paramView;
      if (localURL.equals(paramView.getURL())) {}
    }
    else
    {
      paramView = null;
    }
    localObject = paramView;
    if (paramView == null)
    {
      localObject = URLDrawableHelper.getDrawable(localURL, AlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, AlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
      ((URLDrawable)localObject).setBounds(0, 0, localAlbumListAdapter.jdField_a_of_type_Int, localAlbumListAdapter.b);
    }
    if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
    {
      paramView = localAlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
      paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    }
    else
    {
      paramView = null;
    }
    paramViewGroup.setCompoundDrawables((Drawable)localObject, null, paramView, null);
    return localView;
  }
  
  protected AlbumListAdapter a()
  {
    return new AlbumListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
  }
  
  public QQAlbumInfo a()
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$VideoAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter.b(localQQAlbumInfo);
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoCount < 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQQAlbumInfo = b().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment, localQQAlbumInfo, false, true, bool);
    if (!bool) {
      localQQAlbumInfo.mMediaFileCount = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoCount;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstVideoInfo = localQQAlbumInfo.mCoverInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter.b(localQQAlbumInfo);
    LogTag.a("QQAlbum", "compact.LocalVideoAlbumInfo");
    return localQQAlbumInfo;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    boolean bool1 = ((MediaFileFilter)localObject).needHeif;
    boolean bool2 = ((MediaFileFilter)localObject).needWebp;
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'");
    if (bool1) {
      ((StringBuffer)localObject).append(" or mime_type='image/heif' or mime_type='image/heic'");
    }
    if (bool2) {
      ((StringBuffer)localObject).append(" or mime_type='image/webp'");
    }
    ((StringBuffer)localObject).append(")) GROUP BY (1");
    return ((StringBuffer)localObject).toString();
  }
  
  public URL a(int paramInt, AlbumListAdapter paramAlbumListAdapter, QQAlbumInfo paramQQAlbumInfo)
  {
    if (paramAlbumListAdapter.getItemViewType(paramInt) == 1)
    {
      if (paramQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        return QAlbumUtil.generateAlbumThumbURL(paramQQAlbumInfo.mCoverInfo, "VIDEO");
      }
      return QAlbumUtil.generateAlbumThumbURL(paramQQAlbumInfo.mCoverInfo, "APP_VIDEO");
    }
    return QAlbumUtil.generateAlbumThumbURL(paramQQAlbumInfo.mCoverInfo);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2)
  {
    paramList2 = paramList2.iterator();
    label180:
    while (paramList2.hasNext())
    {
      QQAlbumInfo localQQAlbumInfo1 = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      int j;
      QQAlbumInfo localQQAlbumInfo2;
      do
      {
        boolean bool = localIterator.hasNext();
        j = 1;
        if (!bool) {
          break;
        }
        localQQAlbumInfo2 = (QQAlbumInfo)localIterator.next();
      } while (!localQQAlbumInfo2.id.equals(localQQAlbumInfo1.id));
      localQQAlbumInfo2.mMediaFileCount += localQQAlbumInfo1.mMediaFileCount;
      int i = 1;
      break label103;
      i = 0;
      label103:
      if (i == 0)
      {
        localIterator = paramList1.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localQQAlbumInfo2 = (QQAlbumInfo)localIterator.next();
          if (localQQAlbumInfo1.coverDate > localQQAlbumInfo2.coverDate)
          {
            paramList1.add(i, localQQAlbumInfo1);
            i = j;
            break label180;
          }
          i += 1;
        }
        i = 0;
        if (i == 0) {
          paramList1.add(localQQAlbumInfo1);
        }
      }
    }
    return paramList1;
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.getActivity() == null) {
        return null;
      }
      if ((paramList1 == null) && (paramList2 == null)) {
        paramList1 = null;
      } else if (paramList1 == null) {
        paramList1 = paramList2;
      } else if (paramList2 != null) {
        paramList1 = a(paramList1, paramList2);
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        int i = paramList1.size();
        paramInt = 0;
        while (paramInt < i)
        {
          paramList2 = (QQAlbumInfo)paramList1.get(paramInt);
          if ((paramInt != 0) && (AlbumListAdapter.a(paramList2.name)))
          {
            paramList1.remove(paramList2);
            paramList1.add(0, paramList2);
          }
          paramInt += 1;
        }
      }
      return paramList1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    c();
    a();
    if (paramInt != -1)
    {
      if (((Boolean)a(paramInt).first).booleanValue()) {
        a(-1);
      }
    }
    else {
      a(-1);
    }
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll(paramIntent);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = paramIntent;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter;
    ThreadManagerV2.executeOnFileThread(new AlbumListCustomizationBase.1(this));
  }
  
  public boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = paramIntent.getStringExtra("ALBUM_ID");
    boolean bool;
    if (((str != null) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) || ((paramIntent != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (a(bool, paramQQAlbumInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = str;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent;
      return true;
    }
    return false;
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo.id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramInt = 0;
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.jdField_a_of_type_ComTencentWidgetXListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    Object localObject = localXListView.getChildAt(0);
    if (localObject != null) {
      paramInt = ((View)localObject).getTop();
    }
    paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save Scroll Position,index:");
      ((StringBuilder)localObject).append(localXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" top:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    return a(paramIntent, paramQQAlbumInfo);
  }
  
  public boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  public Pair<Boolean, List<QQAlbumInfo>> b(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = b();
    MediaFileFilter localMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    Object localObject2 = null;
    int i = 0;
    boolean bool1;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList = localAlbumListAdapter.a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      LogTag.a("QQAlbum", "queryImageBuckets");
    }
    else
    {
      localList = null;
      bool1 = false;
    }
    Object localObject1 = localObject2;
    boolean bool2 = bool1;
    if (localMediaFileFilter != null)
    {
      localObject1 = localObject2;
      bool2 = bool1;
      if (localMediaFileFilter.showVideo())
      {
        LogTag.a();
        localObject1 = localAlbumListAdapter.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, localMediaFileFilter);
        bool2 = bool1;
        if (paramInt != -1)
        {
          bool2 = bool1;
          if (localObject1 != null)
          {
            bool2 = bool1;
            if (((List)localObject1).size() == paramInt) {
              bool2 = true;
            }
          }
        }
        LogTag.a("QQAlbum", "queryVideoBuckets");
      }
    }
    LogTag.a();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization$IalbumListAdapterCallBack.a(localList, (List)localObject1, paramInt);
    if (localList != null)
    {
      paramInt = 1;
      while (paramInt < localList.size())
      {
        i += ((QQAlbumInfo)localList.get(paramInt)).mMediaFileCount;
        paramInt += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("compact(");
      ((StringBuilder)localObject1).append(localList.size() - 1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(")");
      LogTag.a("QQAlbum", ((StringBuilder)localObject1).toString());
    }
    else
    {
      LogTag.a("QQAlbum", "compact: medias ==null");
    }
    return new Pair(Boolean.valueOf(bool2), localList);
  }
  
  protected AlbumListAdapter b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter;
  }
  
  public void b() {}
  
  public void c()
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstRecentInfo != null)
    {
      localQQAlbumInfo.mMediaFileCount = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCount;
      localQQAlbumInfo.mCoverInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstRecentInfo;
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    else
    {
      localQQAlbumInfo = b().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment, localQQAlbumInfo, true, true, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCount = localQQAlbumInfo.mMediaFileCount;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstRecentInfo = localQQAlbumInfo.mCoverInfo;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter.a(localQQAlbumInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase
 * JD-Core Version:    0.7.0.1
 */