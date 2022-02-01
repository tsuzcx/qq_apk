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
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationWeiyun";
  private List<String> a;
  
  AlbumListCustomizationWeiyun(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment;
    if ((paramViewGroup != null) && (paramViewGroup.isAdded()) && (!paramViewGroup.isDetached()) && (!paramViewGroup.isRemoving()))
    {
      paramViewGroup = paramViewGroup.a;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()))
    {
      paramIntent = PreferenceUtils.a(paramIntent.getActivity().getApplicationContext(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a, "pref_select_album");
      if (TextUtils.isEmpty(paramIntent)) {
        paramIntent = new ArrayList();
      } else {
        paramIntent = PreferenceUtils.a(paramIntent);
      }
      this.jdField_a_of_type_JavaUtilList = paramIntent;
      paramIntent = this.jdField_a_of_type_JavaUtilList;
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      }
    }
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    boolean bool = super.a(paramQQAlbumInfo, paramInt, paramIntent);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) {
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      if (!TextUtils.isEmpty(paramQQAlbumInfo.id))
      {
        if ((this.jdField_a_of_type_JavaUtilList.contains(paramQQAlbumInfo.id)) && (!TextUtils.equals(paramQQAlbumInfo.id, (CharSequence)this.jdField_a_of_type_JavaUtilList.get(0)))) {
          this.jdField_a_of_type_JavaUtilList.remove(paramQQAlbumInfo.id);
        }
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo.id);
        } else {
          this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo.id);
        }
      }
      PreferenceUtils.a(paramIntent.getActivity().getApplicationContext(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a, "pref_select_album", PreferenceUtils.a(this.jdField_a_of_type_JavaUtilList.iterator()));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationWeiyun
 * JD-Core Version:    0.7.0.1
 */