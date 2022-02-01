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
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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

public class bmzf<K extends bmyl>
  extends bmzd<K>
  implements bmze
{
  protected bmyh a;
  
  protected bmzf(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_Bmze = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    bmyh localbmyh = b();
    View localView;
    TextView localTextView;
    QQAlbumInfo localQQAlbumInfo;
    label207:
    Object localObject;
    if (paramView == null)
    {
      localView = ((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getLayoutInflater().inflate(2131561008, null);
      localTextView = (TextView)localView;
      localQQAlbumInfo = localbmyh.a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      localTextView.setText(paramView);
      paramViewGroup = localTextView.getCompoundDrawables()[0];
      if (localbmyh.getItemViewType(paramInt) != 1) {
        break label398;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label384;
      }
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      ((LocalMediaInfo)localObject).thumbWidth = 200;
      if ((paramViewGroup == null) || (!URLDrawable.class.isInstance(paramViewGroup))) {
        break label415;
      }
      paramViewGroup = (URLDrawable)paramViewGroup;
      if (!paramView.equals(paramViewGroup.getURL())) {
        break label415;
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        localObject = URLDrawableHelper.getDrawable(paramView, bmyh.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, bmyh.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
        ((URLDrawable)localObject).setBounds(0, 0, localbmyh.jdField_a_of_type_Int, localbmyh.b);
      }
      if ((localQQAlbumInfo._id != null) && (localQQAlbumInfo._id.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
      {
        paramView = localbmyh.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      }
      for (;;)
      {
        localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        localTextView = (TextView)paramView;
        localView = paramView;
        break;
        label384:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label207;
        label398:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
        break label207;
        paramView = null;
      }
      label415:
      paramViewGroup = null;
    }
  }
  
  protected bmyh a()
  {
    return new bmyh((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
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
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
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
        bhfd.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label559;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (bmyh.a(paramList1.name)))
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
            paramList1 = b().b(((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesLimitWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.isBothwidthheight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData.recentImagesBlockPaths);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.showVideo()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = ((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
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
                paramList1 = b().a(((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
              }
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            label559:
            bhfd.a("PEAK", "compact.queryRecentBucket");
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
    bmyh localbmyh = b();
    MediaFileFilter localMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    List localList1;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      bhfd.a();
      localList1 = localbmyh.a(((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList1 != null) && (localList1.size() == paramInt))
      {
        i = 1;
        bhfd.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      List localList2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        bhfd.a();
        localList2 = localbmyh.a(((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localMediaFileFilter);
        if ((paramInt != -1) && (localList2 != null) && (localList2.size() == paramInt))
        {
          i = 1;
          bhfd.a("PEAK", "queryVideoBuckets");
        }
      }
      for (;;)
      {
        bhfd.a();
        localList1 = this.jdField_a_of_type_Bmze.a(localList1, localList2, paramInt);
        if (localList1 != null) {
          while (j < localList1.size())
          {
            k += ((QQAlbumInfo)localList1.get(j)).mMediaFileCount;
            j += 1;
          }
        }
        bhfd.a("PEAK", "compact: medias ==null");
        do
        {
          return;
          bhfd.a("PEAK", "compact(" + (localList1.size() - 1) + "," + k + ")");
          localbmyh.b(localList1);
        } while (paramInt == -1);
        if (i != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.2(this, localbmyh));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.3(this, localbmyh, localMediaFileFilter));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsAwlaysShowNumber = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsAwlaysShowNumber);
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (localHashMap != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = localHashMap;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId != null) {
        break label260;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = 1;
      }
      this.jdField_a_of_type_Bmyh = a();
      ((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyh = this.jdField_a_of_type_Bmyh;
      ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.1(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll(localHashMap);
      break;
      label260:
      bnrh.b("AEAlbumListLogicBase", "passed in albumId=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId + ", albumName=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    }
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) || ((str2 != null) && (!str2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))) {}
    for (boolean bool = true; a(bool, paramQQAlbumInfo); bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = str1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str2;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((bmyl)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
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
  
  protected bmyh b()
  {
    return this.jdField_a_of_type_Bmyh;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzf
 * JD-Core Version:    0.7.0.1
 */