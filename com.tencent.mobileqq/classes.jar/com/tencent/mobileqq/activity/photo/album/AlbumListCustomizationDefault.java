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
  protected AlbumListFragment b;
  
  public AlbumListCustomizationDefault(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
    this.b = ((AlbumListFragment)paramAbstractAlbumListFragment);
    this.g = this;
    this.f = new AlbumListData();
    this.a = ((AlbumListData)this.f);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    Object localObject1 = d();
    Object localObject2 = ((NewAlbumListAdapter)localObject1).a(paramInt);
    paramViewGroup = (TextView)paramView;
    if (((QQAlbumInfo)localObject2).id.equals("qzone_album"))
    {
      localObject2 = this.h.getResources().getDrawable(2130853604);
      ((Drawable)localObject2).setBounds(0, 0, ((NewAlbumListAdapter)localObject1).k, ((NewAlbumListAdapter)localObject1).l);
      if (this.a.c == null) {
        this.a.c = this.h.getResources().getDrawable(2130839446).getConstantState();
      }
      localObject1 = this.a.c.newDrawable(this.h.getResources());
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
  
  protected PhotoOtherData a()
  {
    return new AlbumListCustomizationDefault.1(this);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.d.isShowQzoneAlbum) {
      this.a.c = this.h.getResources().getDrawable(2130839446).getConstantState();
    }
    super.a(paramIntent);
    this.a.a = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.d.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    d().a(((PhotoOtherData)this.e).b);
    if ((this.d.isShowQzoneAlbum) && (!((PhotoOtherData)this.e).c))
    {
      this.a.b = new AlbumListCustomizationDefault.QZoneGetAlbumListNumObserver(this);
      ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.a.b, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
      this.a.c = this.h.getResources().getDrawable(2130839446).getConstantState();
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
      QZoneHelper.forwardToPersonalAlbumSelect(this.h, localUserInfo, localBundle, 10016);
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
  
  public String b()
  {
    return super.b();
  }
  
  protected AlbumListAdapter c()
  {
    return new NewAlbumListAdapter(this.b);
  }
  
  protected NewAlbumListAdapter d()
  {
    return (NewAlbumListAdapter)super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault
 * JD-Core Version:    0.7.0.1
 */