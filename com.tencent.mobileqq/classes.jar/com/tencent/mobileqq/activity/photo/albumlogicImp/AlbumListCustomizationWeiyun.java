package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import java.util.ArrayList;
import java.util.List;

public class AlbumListCustomizationWeiyun
  extends AlbumListCustomizationDefault
{
  public static final String j = "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationWeiyun";
  private List<String> k;
  
  AlbumListCustomizationWeiyun(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = this.b;
    if ((paramViewGroup != null) && (paramViewGroup.isAdded()) && (!paramViewGroup.isDetached()) && (!paramViewGroup.isRemoving()))
    {
      paramViewGroup = paramViewGroup.b;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.a(paramInt);
        if ((paramViewGroup != null) && ((paramView instanceof TextView))) {
          ((TextView)paramView).setText(paramViewGroup.name);
        }
      }
    }
    return paramView;
  }
  
  public void a(int paramInt)
  {
    super.a(-1);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0) == 5) {
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    }
    super.a(paramIntent);
    this.d.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = this.b;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()))
    {
      paramIntent = PreferenceUtils.a(paramIntent.getActivity().getApplicationContext(), ((PhotoOtherData)this.e).e, "pref_select_album");
      if (TextUtils.isEmpty(paramIntent)) {
        paramIntent = new ArrayList();
      } else {
        paramIntent = PreferenceUtils.a(paramIntent);
      }
      this.k = paramIntent;
      paramIntent = this.k;
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        this.d.albumId = ((String)this.k.get(0));
      }
      if (TextUtils.isEmpty(this.d.albumId)) {
        this.d.albumId = "$RecentAlbumId";
      }
    }
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    boolean bool = super.a(paramQQAlbumInfo, paramInt, paramIntent);
    if (!TextUtils.isEmpty(this.d.albumName)) {
      paramIntent.putExtra("ALBUM_NAME", this.d.albumName);
    }
    paramIntent = this.b;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()) && (this.k != null))
    {
      if (!TextUtils.isEmpty(paramQQAlbumInfo.id))
      {
        if ((this.k.contains(paramQQAlbumInfo.id)) && (!TextUtils.equals(paramQQAlbumInfo.id, (CharSequence)this.k.get(0)))) {
          this.k.remove(paramQQAlbumInfo.id);
        }
        if (this.k.isEmpty()) {
          this.k.add(paramQQAlbumInfo.id);
        } else {
          this.k.set(0, paramQQAlbumInfo.id);
        }
      }
      PreferenceUtils.a(paramIntent.getActivity().getApplicationContext(), ((PhotoOtherData)this.e).e, "pref_select_album", PreferenceUtils.a(this.k.iterator()));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationWeiyun
 * JD-Core Version:    0.7.0.1
 */