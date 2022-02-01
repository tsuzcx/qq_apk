package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization.IalbumListAdapterCallBack;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AlbumListCustomizationDefault
  extends AlbumListCustomizationBase<PhotoOtherData>
  implements AlbumListCustomization.IalbumListAdapterCallBack
{
  protected AlbumListData a;
  protected AlbumListFragment a;
  
  public AlbumListCustomizationDefault(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment = ((AlbumListFragment)paramAbstractAlbumListFragment);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization$IalbumListAdapterCallBack = this;
    this.a = new AlbumListData();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData = ((AlbumListData)this.a);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    Object localObject1 = a();
    Object localObject2 = ((NewAlbumListAdapter)localObject1).a(paramInt);
    paramViewGroup = (TextView)paramView;
    if (((QQAlbumInfo)localObject2).id.equals("qzone_album"))
    {
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130847897);
      ((Drawable)localObject2).setBounds(0, 0, ((NewAlbumListAdapter)localObject1).a, ((NewAlbumListAdapter)localObject1).b);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839270).getConstantState();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      paramViewGroup.setCompoundDrawables((Drawable)localObject2, null, (Drawable)localObject1, null);
    }
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      paramView.setBackgroundColor(-16777216);
      paramViewGroup.setTextColor(-9211021);
    }
    return paramView;
  }
  
  protected NewAlbumListAdapter a()
  {
    return (NewAlbumListAdapter)super.b();
  }
  
  protected PhotoOtherData a()
  {
    return new AlbumListCustomizationDefault.1(this);
  }
  
  protected AlbumListAdapter a()
  {
    return new NewAlbumListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment);
  }
  
  public String a()
  {
    return super.a();
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839270).getConstantState();
    }
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    a().a(((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum) && (!((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumQZonePhotoObserver = new AlbumListCustomizationDefault.QZoneGetAlbumListNumObserver(this);
      ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumQZonePhotoObserver, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839270).getConstantState();
    }
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    if (paramQQAlbumInfo.id.equals("qzone_album"))
    {
      Bundle localBundle = paramIntent.getExtras();
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      localBundle.putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      localBundle.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localBundle.putString("keyAction", "actionSelectPicture");
      localBundle.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.forwardToPersonalAlbumSelect(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, localBundle, 10016);
      return a(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo.id)) {
      ReportController.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.a(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  public boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo.id.equals("qzone_album")) && (paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault
 * JD-Core Version:    0.7.0.1
 */