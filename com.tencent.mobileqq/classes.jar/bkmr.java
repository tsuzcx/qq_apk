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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.2;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bkmr<K extends bklz>
  extends bkmp<K>
  implements bkmq
{
  protected bklw a;
  
  protected bkmr(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_Bkmq = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    bklw localbklw = b();
    View localView;
    QQAlbumInfo localQQAlbumInfo;
    Object localObject;
    if (paramView == null)
    {
      localView = ((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getLayoutInflater().inflate(2131560816, null);
      paramViewGroup = (TextView)localView;
      localQQAlbumInfo = localbklw.a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      paramViewGroup.setText(paramView);
      localObject = paramViewGroup.getCompoundDrawables()[0];
      if (localbklw.getItemViewType(paramInt) != 1) {
        break label389;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label375;
      }
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label205:
      LocalMediaInfo localLocalMediaInfo = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      localLocalMediaInfo.thumbWidth = 200;
      if ((localObject == null) || (!URLDrawable.class.isInstance(localObject))) {
        break label406;
      }
      localObject = (URLDrawable)localObject;
      if (!paramView.equals(((URLDrawable)localObject).getURL())) {
        break label406;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = baul.a(paramView, bklw.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, bklw.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
        ((URLDrawable)localObject).setBounds(0, 0, localbklw.jdField_a_of_type_Int, localbklw.b);
        if (!localQQAlbumInfo._id.equals(this.jdField_a_of_type_Aimj.albumId)) {
          break label401;
        }
        paramView = localbklw.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      }
      for (;;)
      {
        paramViewGroup.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        paramViewGroup = (TextView)paramView;
        localView = paramView;
        break;
        label375:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label205;
        label389:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
        break label205;
        label401:
        paramView = null;
      }
      label406:
      localObject = null;
    }
  }
  
  protected bklw a()
  {
    return new bklw((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter;
    boolean bool1 = ((MediaFileFilter)localObject).isSupportHeif();
    boolean bool2 = ((MediaFileFilter)localObject).isSupportWebp();
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
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return null;
    }
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        bddw.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label559;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (bklw.a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if (paramList1 != null) {
          break;
        }
        localObject = paramList2;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label259:
    label678:
    label684:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label684;
        }
        localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label678;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label259;
          boolean bool;
          if (paramInt == -1)
          {
            paramList1 = b().b(((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.isBothwidthheight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesBlockPaths);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter.showVideo()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = ((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
              i = 0;
              if (paramList1 != null)
              {
                i = paramList1.getCount();
                paramList1.close();
              }
              bool = false;
              if (i <= 0) {
                break label607;
              }
              bool = true;
              label510:
              b().jdField_a_of_type_Boolean = bool;
              if (bool)
              {
                if (paramInt != -1) {
                  break label638;
                }
                paramList1 = b().a(((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
              }
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            label559:
            bddw.a("PEAK", "compact.queryRecentBucket");
            return localObject;
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$RecentAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
            break;
            label607:
            paramList1 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
            i = 0;
            if (paramList1 != null) {
              i = paramList1.getMediaScannerInfosCount();
            }
            if (i <= 0) {
              break label510;
            }
            bool = true;
            break label510;
            label638:
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$VideoAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
          }
        }
        break;
      }
    }
  }
  
  public void a(int paramInt)
  {
    int k = 0;
    int j = 1;
    bklw localbklw = b();
    MediaFileFilter localMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter;
    List localList1;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      bddw.a();
      localList1 = localbklw.a(((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList1 != null) && (localList1.size() == paramInt))
      {
        i = 1;
        bddw.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      List localList2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        bddw.a();
        localList2 = localbklw.a(((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localMediaFileFilter);
        if ((paramInt != -1) && (localList2 != null) && (localList2.size() == paramInt))
        {
          i = 1;
          bddw.a("PEAK", "queryVideoBuckets");
        }
      }
      for (;;)
      {
        bddw.a();
        localList1 = this.jdField_a_of_type_Bkmq.a(localList1, localList2, paramInt);
        if (localList1 != null) {
          while (j < localList1.size())
          {
            k += ((QQAlbumInfo)localList1.get(j)).mMediaFileCount;
            j += 1;
          }
        }
        bddw.a("PEAK", "compact: medias ==null");
        do
        {
          return;
          bddw.a("PEAK", "compact(" + (localList1.size() - 1) + "," + k + ")");
          localbklw.b(localList1);
        } while (paramInt == -1);
        if (i != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.2(this, localbklw));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.3(this, localbklw, localMediaFileFilter));
        return;
        break;
        localList2 = null;
      }
      i = 0;
      break;
      localList1 = null;
      i = 0;
    }
  }
  
  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter = MediaFileFilter.getFilter(i);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filterVideoGif)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.showMediaType = 1;
    }
    this.jdField_a_of_type_Aimj.mIsAwlaysShowNumber = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.jdField_a_of_type_Aimj.mIsAwlaysShowNumber);
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null)
    {
      if ((this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap != null) && (!this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.isEmpty())) {
        break label178;
      }
      this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap = paramIntent;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bklw = a();
      ((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bklw = this.jdField_a_of_type_Bklw;
      ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.1(this));
      return;
      label178:
      this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.putAll(paramIntent);
    }
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.jdField_a_of_type_Aimj.albumName))) || ((str2 != null) && (!str2.equals(this.jdField_a_of_type_Aimj.albumId)))) {}
    for (boolean bool = true; a(bool, paramQQAlbumInfo); bool = false)
    {
      this.jdField_a_of_type_Aimj.albumName = str1;
      this.jdField_a_of_type_Aimj.albumId = str2;
      this.jdField_a_of_type_Aimj.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((bklz)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    View localView = localXListView.getChildAt(0);
    if (localView == null) {}
    for (paramInt = 0;; paramInt = localView.getTop())
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + localXListView.getFirstVisiblePosition() + " top:" + paramInt);
      }
      return a(paramIntent, paramQQAlbumInfo);
    }
  }
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  protected bklw b()
  {
    return this.jdField_a_of_type_Bklw;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmr
 * JD-Core Version:    0.7.0.1
 */