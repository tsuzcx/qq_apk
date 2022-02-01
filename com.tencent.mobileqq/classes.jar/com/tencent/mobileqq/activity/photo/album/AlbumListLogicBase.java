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
import beyq;
import bhnn;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQAlbumInfo;
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
  
  private QQAlbumInfo getLocalVideoAlbumInfo(QQAlbumInfo paramQQAlbumInfo)
  {
    paramQQAlbumInfo = getAlbumListAdapter().queryRecentMediaBucket(this.mFragment, paramQQAlbumInfo, false, true);
    bhnn.a("PEAK", "compact.LocalVideoAlbumInfo");
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
      bhnn.a();
      localList = ((AlbumListAdapter)localObject).queryImageBuckets(this.mActivity, paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        bool1 = true;
        bhnn.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      boolean bool2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        bhnn.a();
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
        bhnn.a("PEAK", "queryVideoBuckets");
      }
      for (;;)
      {
        bhnn.a();
        localList = this.mAlbumListAdapterCallBack.compact(localList, (List)localObject, paramInt);
        if (localList != null)
        {
          paramInt = j;
          while (paramInt < localList.size())
          {
            i += ((QQAlbumInfo)localList.get(paramInt)).mMediaFileCount;
            paramInt += 1;
          }
          bhnn.a("PEAK", "compact(" + (localList.size() - 1) + "," + i + ")");
        }
        for (;;)
        {
          return new Pair(Boolean.valueOf(bool2), localList);
          bhnn.a("PEAK", "compact: medias ==null");
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
  
  private Pair<Boolean, List<QQAlbumInfo>> updateCommonAndDefaultAlbumList(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = getAlbumListAdapter();
    bhnn.a();
    Pair localPair = queryCommonAlbumList(paramInt);
    List localList = (List)localPair.second;
    bhnn.a("PEAK", "queryAllAlbumList");
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
  
  protected boolean checkAlbumChange(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
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
      for (;;)
      {
        if (paramInt < i)
        {
          paramList2 = (QQAlbumInfo)paramList1.get(paramInt);
          if ((paramInt != 0) && (AlbumListAdapter.isCameraDir(paramList2.name)))
          {
            paramList1.remove(paramList2);
            paramList1.add(0, paramList2);
          }
          paramInt += 1;
          continue;
          if (paramList1 == null)
          {
            paramList1 = paramList2;
            break;
          }
          if (paramList2 == null) {
            break;
          }
          paramList2 = paramList2.iterator();
        }
      }
    }
    label129:
    label305:
    label310:
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
          if (localQQAlbumInfo2._id.equals(localQQAlbumInfo1._id)) {
            localQQAlbumInfo2.mMediaFileCount += localQQAlbumInfo1.mMediaFileCount;
          }
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label310;
        }
        localIterator = paramList1.iterator();
        paramInt = 0;
        label227:
        if (localIterator.hasNext())
        {
          localQQAlbumInfo2 = (QQAlbumInfo)localIterator.next();
          if (localQQAlbumInfo1.coverDate > localQQAlbumInfo2.coverDate) {
            paramList1.add(paramInt, localQQAlbumInfo1);
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label305;
          }
          paramList1.add(localQQAlbumInfo1);
          break label129;
          paramInt += 1;
          break label227;
          break;
          return paramList1;
        }
        break label129;
      }
    }
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
    TextView localTextView;
    QQAlbumInfo localQQAlbumInfo;
    label197:
    Object localObject;
    if (paramView == null)
    {
      localView = this.mActivity.getLayoutInflater().inflate(2131561074, null);
      localTextView = (TextView)localView;
      localQQAlbumInfo = localAlbumListAdapter.getItem(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      localTextView.setText(paramView);
      paramViewGroup = localTextView.getCompoundDrawables()[0];
      if (localAlbumListAdapter.getItemViewType(paramInt) != 1) {
        break label390;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label375;
      }
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      ((LocalMediaInfo)localObject).thumbWidth = 200;
      if ((paramViewGroup == null) || (!URLDrawable.class.isInstance(paramViewGroup))) {
        break label407;
      }
      paramViewGroup = (URLDrawable)paramViewGroup;
      if (!paramView.equals(paramViewGroup.getURL())) {
        break label407;
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        localObject = beyq.a(paramView, AlbumListAdapter.COLOR_DRAWABLE, AlbumListAdapter.COLOR_DRAWABLE);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
        ((URLDrawable)localObject).setBounds(0, 0, localAlbumListAdapter.mCoverWidth, localAlbumListAdapter.mCoverHeight);
      }
      if ((localQQAlbumInfo._id != null) && (localQQAlbumInfo._id.equals(this.mPhotoCommonData.albumId)))
      {
        paramView = localAlbumListAdapter.mRightArrow.newDrawable(localResources);
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      }
      for (;;)
      {
        localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        localTextView = (TextView)paramView;
        localView = paramView;
        break;
        label375:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label197;
        label390:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
        break label197;
        paramView = null;
      }
      label407:
      paramViewGroup = null;
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
  
  protected boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  protected boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramInt = 0;
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
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
  
  protected void postInitUI() {}
  
  public void queryAlbumList(int paramInt)
  {
    AlbumListAdapter localAlbumListAdapter = getAlbumListAdapter();
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    localQQAlbumInfo.mMediaFileCount = this.mPhotoCommonData.recentCount;
    if (this.mPhotoCommonData.firstRecentInfo != null)
    {
      localQQAlbumInfo.mCoverInfo = this.mPhotoCommonData.firstRecentInfo;
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    localAlbumListAdapter.updateRecentAlbum(localQQAlbumInfo);
    localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$VideoAlbumId";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase
 * JD-Core Version:    0.7.0.1
 */