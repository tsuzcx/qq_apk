package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.aelight.camera.ae.biz.circle.adapter.AlbumListAdapter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AlbumListData;
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

public class AECircleAlbumListLogic
  implements AEAlbumListLogic.IalbumListAdapterCallBack
{
  public WeakReference<AECircleAlbumListFragment> a;
  protected PhotoCommonBaseData b;
  protected AlbumListData c;
  public AEAlbumListLogic.IalbumListAdapterCallBack d = null;
  protected AlbumListAdapter e;
  
  protected AECircleAlbumListLogic(AECircleAlbumListFragment paramAECircleAlbumListFragment)
  {
    this.a = new WeakReference(paramAECircleAlbumListFragment);
    this.b = AEPhotoCommonDataCreator.a();
    this.b.addHoldNember();
    if (QLog.isColorLevel())
    {
      paramAECircleAlbumListFragment = new StringBuilder();
      paramAECircleAlbumListFragment.append("AlbumListLogic new，activity = ");
      paramAECircleAlbumListFragment.append(this.a);
      paramAECircleAlbumListFragment.append(",PhotoCommonData = ");
      paramAECircleAlbumListFragment.append(this.b);
      QLog.d("AlbumListActivity", 2, paramAECircleAlbumListFragment.toString());
    }
    this.d = this;
    this.c = new AlbumListData();
  }
  
  private AlbumListAdapter c()
  {
    return this.e;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = c();
    View localView = paramView;
    if (paramView == null) {
      localView = ((AECircleAlbumListFragment)this.a.get()).getActivity().getLayoutInflater().inflate(2064056511, null);
    }
    ImageView localImageView1 = (ImageView)localView.findViewById(2063990873);
    paramView = (TextView)localView.findViewById(2063990875);
    Object localObject = (TextView)localView.findViewById(2063990881);
    ImageView localImageView2 = (ImageView)localView.findViewById(2063990882);
    QQAlbumInfo localQQAlbumInfo = paramViewGroup.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQQAlbumInfo.name);
    localStringBuilder.append("，");
    localStringBuilder.append(localQQAlbumInfo.mMediaFileCount);
    localStringBuilder.append("张照片");
    localView.setContentDescription(localStringBuilder.toString());
    paramView.setText(localQQAlbumInfo.name);
    if (localQQAlbumInfo.mMediaFileCount > 0) {
      ((TextView)localObject).setText(String.format("(%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) }));
    } else {
      ((TextView)localObject).setText("");
    }
    if (paramViewGroup.getItemViewType(paramInt) == 1)
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
    paramViewGroup = localQQAlbumInfo.mCoverInfo;
    localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
    paramViewGroup.thumbWidth = 200;
    if ((localImageView1.getDrawable() instanceof URLDrawable))
    {
      paramViewGroup = (URLDrawable)localImageView1.getDrawable();
      if (paramView.equals(paramViewGroup.getURL())) {}
    }
    else
    {
      paramViewGroup = null;
    }
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = URLDrawableHelper.getDrawable(paramView, AlbumListAdapter.a, AlbumListAdapter.a);
      ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
    }
    localImageView1.setImageDrawable((Drawable)localObject);
    if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.b.albumId)))
    {
      localImageView2.setVisibility(0);
      return localView;
    }
    localImageView2.setVisibility(8);
    return localView;
  }
  
  public String a()
  {
    Object localObject = this.b.filter;
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
    if (this.a.get() != null)
    {
      if (((AECircleAlbumListFragment)this.a.get()).getActivity() == null) {
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
          if ((i != 0) && (AlbumListAdapter.a(paramList1.name)))
          {
            paramList2.remove(paramList1);
            paramList2.add(0, paramList1);
          }
          i += 1;
        }
        if (paramInt == -1)
        {
          paramList1 = AlbumListAdapter.b(((AECircleAlbumListFragment)this.a.get()).getActivity());
        }
        else
        {
          paramList1 = new QQAlbumInfo();
          paramList1.id = "$RecentAlbumId";
          paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
          paramList1.mCoverInfo = new LocalMediaInfo();
        }
        paramList2.add(0, paramList1);
        if ((this.b.filter != null) && (this.b.filter.showVideo()))
        {
          paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          paramList1 = ((AECircleAlbumListFragment)this.a.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
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
          c().c = bool;
          if (bool)
          {
            if (paramInt == -1)
            {
              paramList1 = c().a(((AECircleAlbumListFragment)this.a.get()).getActivity());
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
    AlbumListAdapter localAlbumListAdapter = c();
    MediaFileFilter localMediaFileFilter = this.b.filter;
    Object localObject2 = null;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList = localAlbumListAdapter.a(((AECircleAlbumListFragment)this.a.get()).getActivity(), paramInt);
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
        localObject1 = localAlbumListAdapter.a(((AECircleAlbumListFragment)this.a.get()).getActivity(), paramInt, localMediaFileFilter);
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
    List localList = this.d.a(localList, (List)localObject1, paramInt);
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
      localAlbumListAdapter.b(localList);
      if (paramInt != -1)
      {
        if (j != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.2(this, localAlbumListAdapter));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.3(this, localAlbumListAdapter, localMediaFileFilter));
      }
      return;
    }
    LogTag.a("PEAK", "compact: medias ==null");
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (localObject != null) {
      if ((this.b.selectedMediaInfoHashMap != null) && (!this.b.selectedMediaInfoHashMap.isEmpty())) {
        this.b.selectedMediaInfoHashMap.putAll((Map)localObject);
      } else {
        this.b.selectedMediaInfoHashMap = ((HashMap)localObject);
      }
    }
    this.b.albumId = paramIntent.getStringExtra("ALBUM_ID");
    this.b.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    if (this.b.albumId == null)
    {
      localObject = this.b;
      ((PhotoCommonBaseData)localObject).albumId = "$RecentAlbumId";
      ((PhotoCommonBaseData)localObject).albumName = null;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("passed in albumId=");
      ((StringBuilder)localObject).append(this.b.albumId);
      ((StringBuilder)localObject).append(", albumName=");
      ((StringBuilder)localObject).append(this.b.albumName);
      AEQLog.b("AECircleAlbumListLogic", ((StringBuilder)localObject).toString());
    }
    this.b.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localObject = this.b;
    ((PhotoCommonBaseData)localObject).filter = MediaFileFilter.getFilter(((PhotoCommonBaseData)localObject).showMediaType);
    if (paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false))
    {
      this.b.filter.needGif = false;
      this.b.filter.needVideo = false;
    }
    this.e = new AlbumListAdapter((AECircleAlbumListFragment)this.a.get());
    ((AECircleAlbumListFragment)this.a.get()).e = this.e;
    ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.1(this));
    this.c.a = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.b.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = paramIntent.getStringExtra("ALBUM_ID");
    boolean bool;
    if (((str != null) && (!str.equals(this.b.albumName))) || ((paramIntent != null) && (!paramIntent.equals(this.b.albumId)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (a(bool, paramQQAlbumInfo))
    {
      paramQQAlbumInfo = this.b;
      paramQQAlbumInfo.albumName = str;
      paramQQAlbumInfo.albumId = paramIntent;
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
    XListView localXListView = ((AECircleAlbumListFragment)this.a.get()).f;
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
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListLogic new，fragment = ");
      localStringBuilder.append(this.a.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.b);
      QLog.d("AlbumListActivity", 2, localStringBuilder.toString());
    }
    this.b.releaseCommonData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */