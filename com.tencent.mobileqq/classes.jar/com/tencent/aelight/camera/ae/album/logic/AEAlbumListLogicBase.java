package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEAlbumListLogicBase<K extends AEAbstractAlbumListFragment>
  extends AEAlbumListLogic<K>
  implements AEAlbumListLogic.IalbumListAdapterCallBack
{
  protected AEAlbumListAdapter a;
  
  protected AEAlbumListLogicBase(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    AEAlbumListAdapter localAEAlbumListAdapter = b();
    View localView;
    TextView localTextView;
    if (paramView == null)
    {
      localView = ((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getLayoutInflater().inflate(2131560958, null);
      localTextView = (TextView)localView;
    }
    else
    {
      localTextView = (TextView)paramView;
      localView = paramView;
    }
    QQAlbumInfo localQQAlbumInfo = localAEAlbumListAdapter.a(paramInt);
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
    localTextView.setText(paramView);
    paramViewGroup = localTextView.getCompoundDrawables()[0];
    if (localAEAlbumListAdapter.getItemViewType(paramInt) == 1)
    {
      if (localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      } else {
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
      }
    }
    else {
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
    }
    Object localObject = localQQAlbumInfo.mCoverInfo;
    localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
    ((LocalMediaInfo)localObject).thumbWidth = 200;
    if ((paramViewGroup != null) && (URLDrawable.class.isInstance(paramViewGroup)))
    {
      paramViewGroup = (URLDrawable)paramViewGroup;
      if (paramView.equals(paramViewGroup.getURL())) {}
    }
    else
    {
      paramViewGroup = null;
    }
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = URLDrawableHelper.getDrawable(paramView, AEAlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, AEAlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
      ((URLDrawable)localObject).setBounds(0, 0, localAEAlbumListAdapter.jdField_a_of_type_Int, localAEAlbumListAdapter.b);
    }
    if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
    {
      paramView = localAEAlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
      paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    }
    else
    {
      paramView = null;
    }
    localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
    return localView;
  }
  
  protected AEAlbumListAdapter a()
  {
    return new AEAlbumListAdapter((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get());
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
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return QAlbumUtil.queryRecentImages(paramContext, paramInt3, paramInt2, paramMediaFileFilter, paramBoolean, paramInt1, paramArrayList, false);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      if (((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null) {
        return null;
      }
      boolean bool = false;
      int i;
      if ((paramList1 == null) && (paramList2 == null)) {
        paramList2 = null;
      } else if (paramList1 != null) {
        if (paramList2 == null)
        {
          paramList2 = paramList1;
        }
        else
        {
          Iterator localIterator1 = paramList2.iterator();
          for (;;)
          {
            paramList2 = paramList1;
            if (!localIterator1.hasNext()) {
              break;
            }
            paramList2 = (QQAlbumInfo)localIterator1.next();
            Iterator localIterator2 = paramList1.iterator();
            QQAlbumInfo localQQAlbumInfo;
            while (localIterator2.hasNext())
            {
              localQQAlbumInfo = (QQAlbumInfo)localIterator2.next();
              if (localQQAlbumInfo.id.equals(paramList2.id))
              {
                localQQAlbumInfo.mMediaFileCount += paramList2.mMediaFileCount;
                i = 1;
                break label160;
              }
            }
            i = 0;
            label160:
            if (i == 0)
            {
              localIterator2 = paramList1.iterator();
              i = 0;
              while (localIterator2.hasNext())
              {
                localQQAlbumInfo = (QQAlbumInfo)localIterator2.next();
                if (paramList2.coverDate > localQQAlbumInfo.coverDate)
                {
                  paramList1.add(i, paramList2);
                  i = 1;
                  break label241;
                }
                i += 1;
              }
              i = 0;
              label241:
              if (i == 0) {
                paramList1.add(paramList2);
              }
            }
          }
        }
      }
      LogTag.a();
      if ((paramList2 != null) && (!paramList2.isEmpty()))
      {
        int j = paramList2.size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)paramList2.get(i);
          if ((i != 0) && (AEAlbumListAdapter.a(paramList1.name)))
          {
            paramList2.remove(paramList1);
            paramList2.add(0, paramList1);
          }
          i += 1;
        }
        if (paramInt == -1)
        {
          paramList1 = b().b(((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 210, -1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, -1, false, null);
        }
        else
        {
          paramList1 = new QQAlbumInfo();
          paramList1.id = "$RecentAlbumId";
          paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
          paramList1.mCoverInfo = new LocalMediaInfo();
        }
        paramList2.add(0, paramList1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.showVideo()))
        {
          paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          paramList1 = ((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
          if (paramList1 != null)
          {
            i = paramList1.getCount();
            paramList1.close();
          }
          else
          {
            i = 0;
          }
          if (i > 0) {}
          do
          {
            bool = true;
            break;
            paramList1 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
            if (paramList1 != null) {
              i = paramList1.getMediaScannerInfosCount();
            } else {
              i = 0;
            }
          } while (i > 0);
          b().jdField_a_of_type_Boolean = bool;
          if (bool)
          {
            if (paramInt == -1)
            {
              paramList1 = b().a(((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
            }
            else
            {
              paramList1 = new QQAlbumInfo();
              paramList1.id = "$VideoAlbumId";
              paramList1.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
              paramList1.mCoverInfo = new LocalMediaInfo();
            }
            paramList2.add(1, paramList1);
          }
        }
      }
      LogTag.a("PEAK", "compact.queryRecentBucket");
      return paramList2;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    AEAlbumListAdapter localAEAlbumListAdapter = b();
    MediaFileFilter localMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    Object localObject2 = null;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList = localAEAlbumListAdapter.a(((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt)) {
        i = 1;
      } else {
        i = 0;
      }
      LogTag.a("PEAK", "queryImageBuckets");
    }
    else
    {
      localList = null;
      i = 0;
    }
    Object localObject1 = localObject2;
    int j = i;
    if (localMediaFileFilter != null)
    {
      localObject1 = localObject2;
      j = i;
      if (localMediaFileFilter.showVideo())
      {
        LogTag.a();
        localObject1 = localAEAlbumListAdapter.a(((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localMediaFileFilter);
        j = i;
        if (paramInt != -1)
        {
          j = i;
          if (localObject1 != null)
          {
            j = i;
            if (((List)localObject1).size() == paramInt) {
              j = 1;
            }
          }
        }
        LogTag.a("PEAK", "queryVideoBuckets");
      }
    }
    LogTag.a();
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(localList, (List)localObject1, paramInt);
    if (localList != null)
    {
      i = 1;
      int k = 0;
      while (i < localList.size())
      {
        k += ((QQAlbumInfo)localList.get(i)).mMediaFileCount;
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("compact(");
      ((StringBuilder)localObject1).append(localList.size() - 1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(")");
      LogTag.a("PEAK", ((StringBuilder)localObject1).toString());
      localAEAlbumListAdapter.b(localList);
      if (paramInt != -1)
      {
        if (j != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.2(this, localAEAlbumListAdapter));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.3(this, localAEAlbumListAdapter, localMediaFileFilter));
      }
      return;
    }
    LogTag.a("PEAK", "compact: medias ==null");
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (localObject != null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = ((HashMap)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("passed in albumId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      ((StringBuilder)localObject).append(", albumName=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      AEQLog.b("AEAlbumListLogicBase", ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAdapterAEAlbumListAdapter = a();
    ((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumAdapterAEAlbumListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAdapterAEAlbumListAdapter;
    ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.1(this));
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
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
    XListView localXListView = ((AEAbstractAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
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
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  protected AEAlbumListAdapter b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAdapterAEAlbumListAdapter;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase
 * JD-Core Version:    0.7.0.1
 */