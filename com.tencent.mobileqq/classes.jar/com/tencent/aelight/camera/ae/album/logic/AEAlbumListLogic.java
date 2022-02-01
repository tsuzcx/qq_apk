package com.tencent.aelight.camera.ae.album.logic;

import android.content.Intent;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class AEAlbumListLogic<K extends AEAbstractAlbumListFragment>
{
  public static volatile AEAlbumListLogic d;
  public WeakReference<K> a;
  protected PhotoCommonBaseData b;
  public AlbumListBaseData c;
  public AEAlbumListLogic.IalbumListAdapterCallBack e = null;
  
  protected AEAlbumListLogic(K paramK)
  {
    this.a = new WeakReference(paramK);
    this.b = AEPhotoCommonDataCreator.a();
    this.b.addHoldNember();
    this.c = new AlbumListBaseData();
    if (QLog.isColorLevel())
    {
      paramK = new StringBuilder();
      paramK.append("AlbumListLogic new，activity = ");
      paramK.append(this.a);
      paramK.append(",PhotoCommonData = ");
      paramK.append(this.b);
      QLog.d("AlbumListActivity", 2, paramK.toString());
    }
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public void ai_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListLogic new，fragment = ");
      localStringBuilder.append(this.a.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.b);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.b.releaseCommonData();
    d = null;
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */