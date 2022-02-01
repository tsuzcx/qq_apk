package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
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

public class AlbumListLogicBase<K extends AbstractAlbumListFragment, O extends OtherCommonData>
  extends AlbumListLogic<K, O>
  implements AlbumListLogic.IalbumListAdapterCallBack
{
  protected Activity mActivity;
  protected AlbumListAdapter mAlbumListAdapter;
  
  protected AlbumListLogicBase(K paramK)
  {
    super(paramK);
    this.mActivity = paramK.getActivity();
    this.mAlbumListAdapterCallBack = this;
  }
  
  private URL generateDrawableUrl(int paramInt, AlbumListAdapter paramAlbumListAdapter, QQAlbumInfo paramQQAlbumInfo)
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
  
  private QQAlbumInfo getLocalVideoAlbumInfo(QQAlbumInfo paramQQAlbumInfo)
  {
    paramQQAlbumInfo = getAlbumListAdapter().queryRecentMediaBucket(this.mFragment, paramQQAlbumInfo, false, true);
    LogTag.a("PEAK", "compact.LocalVideoAlbumInfo");
    return paramQQAlbumInfo;
  }
  
  private Pair<Boolean, List<QQAlbumInfo>> queryCommonAlbumList(int paramInt)
  {
    int i = 0;
    int j = 1;
    Object localObject = getAlbumListAdapter();
    MediaFileFilter localMediaFileFilter = this.mPhotoCommonData.filter;
    List localList;
    boolean bool1;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList = ((AlbumListAdapter)localObject).queryImageBuckets(this.mActivity, paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        bool1 = true;
        LogTag.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      boolean bool2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        LogTag.a();
        localObject = ((AlbumListAdapter)localObject).queryVideoBuckets(this.mActivity, paramInt, localMediaFileFilter);
        bool2 = bool1;
        if (paramInt != -1)
        {
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((List)localObject).size() == paramInt) {
              bool2 = true;
            }
          }
        }
        LogTag.a("PEAK", "queryVideoBuckets");
      }
      for (;;)
      {
        LogTag.a();
        localList = this.mAlbumListAdapterCallBack.compact(localList, (List)localObject, paramInt);
        if (localList != null)
        {
          paramInt = j;
          while (paramInt < localList.size())
          {
            i += ((QQAlbumInfo)localList.get(paramInt)).mMediaFileCount;
            paramInt += 1;
          }
          LogTag.a("PEAK", "compact(" + (localList.size() - 1) + "," + i + ")");
        }
        for (;;)
        {
          return new Pair(Boolean.valueOf(bool2), localList);
          LogTag.a("PEAK", "compact: medias ==null");
        }
        localObject = null;
        bool2 = bool1;
      }
      bool1 = false;
      break;
      localList = null;
      bool1 = false;
    }
  }
  
  private List<QQAlbumInfo> realCompactImagesAndVideos(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2)
  {
    paramList2 = paramList2.iterator();
    label180:
    label185:
    for (;;)
    {
      QQAlbumInfo localQQAlbumInfo1;
      Iterator localIterator;
      QQAlbumInfo localQQAlbumInfo2;
      if (paramList2.hasNext())
      {
        localQQAlbumInfo1 = (QQAlbumInfo)paramList2.next();
        localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          localQQAlbumInfo2 = (QQAlbumInfo)localIterator.next();
          if (localQQAlbumInfo2.id.equals(localQQAlbumInfo1.id)) {
            localQQAlbumInfo2.mMediaFileCount += localQQAlbumInfo1.mMediaFileCount;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label185;
        }
        localIterator = paramList1.iterator();
        i = 0;
        label105:
        if (localIterator.hasNext())
        {
          localQQAlbumInfo2 = (QQAlbumInfo)localIterator.next();
          if (localQQAlbumInfo1.coverDate > localQQAlbumInfo2.coverDate) {
            paramList1.add(i, localQQAlbumInfo1);
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label180;
          }
          paramList1.add(localQQAlbumInfo1);
          break;
          i += 1;
          break label105;
          return paramList1;
        }
        break;
      }
    }
  }
  
  private Pair<Boolean, List<QQAlbumInfo>> updateCommonAndDefaultAlbumList(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = getAlbumListAdapter();
    LogTag.a();
    Pair localPair = queryCommonAlbumList(paramInt);
    List localList = (List)localPair.second;
    LogTag.a("PEAK", "queryAllAlbumList");
    localAlbumListAdapter.updateCommonAlbums(localList);
    localAlbumListAdapter.postData();
    return localPair;
  }
  
  public String adapterGenerateSelection()
  {
    Object localObject = this.mPhotoCommonData.filter;
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
  
  boolean checkAlbumChange(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.mPhotoCommonData.albumName))) || ((str2 != null) && (!str2.equals(this.mPhotoCommonData.albumId)))) {}
    for (boolean bool = true; needUpdateAlbum(bool, paramQQAlbumInfo); bool = false)
    {
      this.mPhotoCommonData.albumName = str1;
      this.mPhotoCommonData.albumId = str2;
      this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      return true;
    }
    return false;
  }
  
  public List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if ((this.mFragment == null) || (this.mFragment.getActivity() == null)) {
      return null;
    }
    if ((paramList1 == null) && (paramList2 == null)) {
      paramList1 = null;
    }
    while ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      int i = paramList1.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramList2 = (QQAlbumInfo)paramList1.get(paramInt);
        if ((paramInt != 0) && (AlbumListAdapter.isCameraDir(paramList2.name)))
        {
          paramList1.remove(paramList2);
          paramList1.add(0, paramList2);
        }
        paramInt += 1;
      }
      if (paramList1 == null) {
        paramList1 = paramList2;
      } else if (paramList2 != null) {
        paramList1 = realCompactImagesAndVideos(paramList1, paramList2);
      }
    }
    return paramList1;
  }
  
  protected AlbumListAdapter generateAlbumListAdapter()
  {
    return new AlbumListAdapter(this.mFragment);
  }
  
  protected AlbumListAdapter getAlbumListAdapter()
  {
    return this.mAlbumListAdapter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = this.mFragment.getResources();
    AlbumListAdapter localAlbumListAdapter = getAlbumListAdapter();
    View localView;
    QQAlbumInfo localQQAlbumInfo;
    URL localURL;
    Object localObject;
    if (paramView == null)
    {
      localView = this.mActivity.getLayoutInflater().inflate(2131561095, null);
      paramViewGroup = (TextView)localView;
      localQQAlbumInfo = localAlbumListAdapter.getItem(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      paramViewGroup.setText(paramView);
      paramView = paramViewGroup.getCompoundDrawables()[0];
      localURL = generateDrawableUrl(paramInt, localAlbumListAdapter, localQQAlbumInfo);
      localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      ((LocalMediaInfo)localObject).thumbWidth = 200;
      if ((paramView == null) || (!URLDrawable.class.isInstance(paramView))) {
        break label355;
      }
      paramView = (URLDrawable)paramView;
      if (!localURL.equals(paramView.getURL())) {
        break label355;
      }
    }
    for (;;)
    {
      localObject = paramView;
      if (paramView == null)
      {
        localObject = URLDrawableHelper.getDrawable(localURL, AlbumListAdapter.COLOR_DRAWABLE, AlbumListAdapter.COLOR_DRAWABLE);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
        ((URLDrawable)localObject).setBounds(0, 0, localAlbumListAdapter.mCoverWidth, localAlbumListAdapter.mCoverHeight);
      }
      if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.mPhotoCommonData.albumId)))
      {
        paramView = localAlbumListAdapter.mRightArrow.newDrawable(localResources);
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      }
      for (;;)
      {
        paramViewGroup.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        paramViewGroup = (TextView)paramView;
        localView = paramView;
        break;
        paramView = null;
      }
      label355:
      paramView = null;
    }
  }
  
  protected void initData(Intent paramIntent)
  {
    this.mPhotoCommonData.mIsAwlaysShowNumber = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.mPhotoCommonData.mIsAwlaysShowNumber);
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null)
    {
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.isEmpty())) {
        break label98;
      }
      this.mPhotoCommonData.selectedMediaInfoHashMap = paramIntent;
    }
    for (;;)
    {
      this.mAlbumListAdapter = generateAlbumListAdapter();
      this.mFragment.listAdapter = this.mAlbumListAdapter;
      ThreadManagerV2.executeOnFileThread(new AlbumListLogicBase.1(this));
      return;
      label98:
      this.mPhotoCommonData.selectedMediaInfoHashMap.putAll(paramIntent);
    }
  }
  
  boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  protected boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramInt = 0;
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo.id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = this.mFragment.mListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    View localView = localXListView.getChildAt(0);
    if (localView == null) {}
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + localXListView.getFirstVisiblePosition() + " top:" + paramInt);
      }
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
      paramInt = localView.getTop();
    }
  }
  
  void postInitUI() {}
  
  public void queryAlbumList(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = getAlbumListAdapter();
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    localQQAlbumInfo.mMediaFileCount = this.mPhotoCommonData.recentCount;
    if (this.mPhotoCommonData.firstRecentInfo != null)
    {
      localQQAlbumInfo.mCoverInfo = this.mPhotoCommonData.firstRecentInfo;
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    localAlbumListAdapter.updateRecentAlbum(localQQAlbumInfo);
    localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$VideoAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
    localAlbumListAdapter.updateVideoAlbum(localQQAlbumInfo);
    if (paramInt != -1) {
      if (((Boolean)updateCommonAndDefaultAlbumList(paramInt).first).booleanValue()) {
        updateCommonAndDefaultAlbumList(-1);
      }
    }
    for (;;)
    {
      localAlbumListAdapter.updateVideoAlbum(getLocalVideoAlbumInfo(localQQAlbumInfo));
      return;
      updateCommonAndDefaultAlbumList(-1);
    }
  }
  
  public List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return QAlbumUtil.queryRecentImages(paramContext, paramInt3, paramInt2, paramMediaFileFilter, paramBoolean, paramInt1, paramArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase
 * JD-Core Version:    0.7.0.1
 */